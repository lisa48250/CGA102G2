/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *     所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */


package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_ActivitySession {

	public static String get_aCondition_For_myDB(String columnName, String value) {

		String aCondition = null;

		if ("activity_session_ID".equals(columnName) || "activity_ID".equals(columnName) || "activity_enroll_state".equals(columnName) || "activity_max_part".equals(columnName) || "activity_min_part".equals(columnName) || "enroll_total".equals(columnName) || "activity_session_state".equals(columnName)) // 用於其他(數字或浮點數)
			aCondition = columnName + "=" + value;
		else if ("status_note".equals(columnName)) // 用於varchar
			aCondition = columnName + " like '%" + value + "%'";
		else if ("activity_session_start".equals(columnName) || "activity_session_end".equals(columnName) || "enroll_start".equals(columnName) || "enroll_end".equals(columnName))                          // 用於date
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
		map.put("activity_session_ID", new String[] { "1" });
		map.put("activity_ID", new String[] { "1" });
		map.put("activity_session_start", new String[] { "2022-07-02 15:00:00" });
		map.put("activity_session_end", new String[] { "2022-07-02 17:00:00" });
		map.put("activity_enroll_state", new String[] { "0" });
		map.put("status_note", new String[] { "無" });
		map.put("activity_max_part", new String[] { "30" });
		map.put("activity_min_part", new String[] { "10" });
		map.put("enroll_total", new String[] { "0" });
		map.put("enroll_start", new String[] { "2022-06-01" });
		map.put("enroll_end", new String[] { "2022-06-18" });
		map.put("activity_session_state", new String[] { "1" });
		map.put("action", new String[] { "getXXX" }); // 注意Map裡面會含有action的key

		String finalSQL = "select * from ACTIVITY_SESSION "
				          + jdbcUtil_CompositeQuery_ActivitySession.get_WhereCondition(map)
				          + "order by ACTIVITY_SESSION_ID";
		System.out.println("●●finalSQL = " + finalSQL);

	}
}
