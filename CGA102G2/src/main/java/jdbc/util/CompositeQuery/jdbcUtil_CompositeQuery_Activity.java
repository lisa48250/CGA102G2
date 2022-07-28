/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *     所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */


package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Activity {

	public static String get_aCondition_For_myDB(String columnName, String value) {

		String aCondition = null;

		if ("activity_ID".equals(columnName) || "activity_category_ID".equals(columnName) || "activity_price".equals(columnName) || "activity_state".equals(columnName)) // 用於其他(數字或浮點數)
			aCondition = columnName + "=" + value;
		else if ("activity_name".equals(columnName) || "activity_description".equals(columnName) || "activity_content".equals(columnName) || "activity_info".equals(columnName)) // 用於varchar
			aCondition = columnName + " like '%" + value + "%'";
		else if ("activity_start".equals(columnName) || "activity_end".equals(columnName))                          // 用於date
			aCondition = columnName + "=" + "'"+ value +"'";                          //for 其它DB  的 date
//		    aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";  //for Oracle 的 date
		
		return aCondition + " ";
	}

	public static String get_WhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_myDB(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("有送出查詢資料的欄位數count = " + count);
			}
		}
		
		return whereCondition.toString();
	}

	public static void main(String argv[]) {

		// 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
		Map<String, String[]> map = new TreeMap<String, String[]>();
		map.put("activity_ID", new String[] { "1" });
		map.put("activity_category_ID", new String[] { "1" });
		map.put("activity_name", new String[] { "日本茶道體驗" });
		map.put("activity_price", new String[] { "2000" });
		map.put("activity_start", new String[] { "2022-07-01" });
		map.put("activity_end", new String[] { "2022-07-31" });
		map.put("activity_description", new String[] { "日本茶道是為客人奉茶之事，是一種茶敍的儀式，日本人稱之為「茶湯」，和其他東亞茶儀式一樣，都是一種以品茶為主而發展出來的特殊文化。現代的茶道，由主人準備茶與點心（和菓子）招待客人，而主人與客人都按照固定的規矩與步驟行事。" });
		map.put("activity_content", new String[] { "1.茶室的禮儀：進入茶室的方法。 2.茶會的空間佈置介紹。 3.正統日本茶道裏千家「盆略點前」演示。 4.正確享用抹茶與伴茶干菓子的方法。 5.刷一碗茶實作。 6.茶室中歡聚的一期一會，留下永恆留念的照片。" });
		map.put("activity_info", new String[] { "活動資訊：1.活動報名時間為6/1~7/17，6/1~6/14報名可享有早鳥優惠8折1600元，6/15~7/17報名本活動費用為原價2000元。 2.進入茶室，需穿著白襪，如未穿著白襪者，可現場購買台灣白棉襪一雙20元。 3.本活動在榻榻米房間進行，請穿著適合散盤或跪坐之衣著，避免太短的裙裝。 4.本活動僅供7歲以上貴賓報名參加(7歲以下兒童可陪同父母，但無法參與活動)，7歲~13歲兒童需成人陪同才可參加活動。" });
		map.put("activity_state", new String[] { "1" });
		map.put("action", new String[] { "getXXX" }); // 注意Map裡面會含有action的key

		String finalSQL = "select * from ACTIVITY "
				          + jdbcUtil_CompositeQuery_Activity.get_WhereCondition(map)
				          + "order by ACTIVITY_ID";
		System.out.println("●●finalSQL = " + finalSQL);

	}
}
