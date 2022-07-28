package p.com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Product_DAO implements Product_DAO_interface {
	


	// connection pool
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CGA102_2");
//			ds = (DataSource) ctx.lookup("java:comp/env/CGA102_2");
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = /*"jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";*/
	               "jdbc:mysql://localhost:3306/"
	               + "CGA102_2?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	private static final String INSERT_STMT =
			"INSERT INTO product (product_category_id, product_describtion, product_price, product_name, product_quantity, product_status) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT =
			"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status "
			+ "FROM product order by product_id";
	private static final String GET_ONE_STMT =
			"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status "
			+ "FROM product where product_id = ?";
	private static final String DELETE =
			"DELETE FROM product where product_id = ?";
	private static final String UPDATE =
			"UPDATE product set product_category_id=?, product_describtion=?, product_price=?, product_name=?, product_quantity=?, product_status=? "
			+ "where product_id = ?";
	private static final String GET_Product_ByProduct_name_STMT =
			"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status "
			+ "FROM product where product_name = ? order by product_id";
	private static final String GET_Product_By_Like_Product_name_STMT =
			"SELECT product_id, product_category_name, product_describtion, product_price, product_name, product_quantity, product_status "
			+ "	from product as p left join product_category as c on p.product_category_id = c.product_category_id where product_name like ? order by product_id; ";
			
//			"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status "
//					+ "FROM product where product_name like  ? order by product_id ";
	
	
//			"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status"
//					+ "FROM product where product_name = \"%\" ? \"%\" order by product_id ";
	
//	private static final String GET_Product_ByProduct_category_id_STMT =
//	"SELECT product_id, product_category_id, product_describtion, product_price, product_name, product_quantity, product_status"
//	+ "FROM product where product_category_id = ? order by product_id";

	private static final String Get_All_Data_STMT_True = "select p.PRODUCT_ID, p.PRODUCT_CATEGORY_ID, p.PRODUCT_DESCRIBTION, p.PRODUCT_NAME, p.PRODUCT_PRICE, p.PRODUCT_QUANTITY, p.PRODUCT_STATUS, "
			+ " ph.PRODUCT_PHOTO, pic.PRODUCT_CATEGORY_NAME, pic.PRODUCT_CATEGORY_DETAIL "
			+ " from CGA102_2.PRODUCT as p "
			+ " left join PRODUCT_PICS as ph on p.product_id = ph.PRODUCT_ID "
			+ " left join PRODUCT_CATEGORY as pic on p.PRODUCT_CATEGORY_ID = pic.PRODUCT_CATEGORY_ID "
			+ " where PRODUCT_STATUS = true "
			+ " order by p.PRODUCT_ID; ";
	
	private static final String Get_product_by_category_id_STMT = " select product_id, product_category_name, product_describtion, product_price, product_name, product_quantity, product_status "
			+ "	from product as p left join product_category as c on p.product_category_id = c.product_category_id "
			+ "	where 1 = 1 and p.PRODUCT_CATEGORY_ID = ? ; ";
	
	

	@Override
	public List<ProductVO> getAllProductsCateGoryId(Integer product_category_id) {
	List<ProductVO> list = new ArrayList<>();
	ProductVO productVO = null;

//	Connection conn;
	try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(Get_product_by_category_id_STMT);
			) {
		pstmt.setInt(1, product_category_id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		productVO = new ProductVO();
//		productVO.setProduct_category_id(rs.getInt("product_category_id"));
		productVO.setProduct_category_name(rs.getString("product_category_name"));
		productVO.setProduct_describtion(rs.getString("product_describtion"));
		productVO.setProduct_price(rs.getInt("product_price"));
		productVO.setProduct_name(rs.getString("product_name"));
		productVO.setProduct_quantity(rs.getInt("product_quantity"));
		productVO.setProduct_status(rs.getBoolean("product_status"));
		productVO.setProduct_id(rs.getInt("product_id"));
		list.add(productVO);
//		list.add(productVO); // Store the row in the list
						
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}







	@Override
	//尚未測試
	public List<ProductVO> fineAllDataSales() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

//		Connection conn;
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Get_All_Data_STMT_True); ) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			productVO = new ProductVO();
			productVO.setProduct_category_detail(rs.getString("product_category_detail"));
			productVO.setProduct_category_id(rs.getInt("product_category_id"));
			productVO.setProduct_category_name(rs.getString("product_category_name"));
			productVO.setProduct_describtion(rs.getString("product_describtion"));
			productVO.setProduct_id(rs.getInt("product_id"));
			productVO.setProduct_name(rs.getString("product_name"));
			productVO.setProduct_photo(rs.getBytes("product_photo"));
			productVO.setProduct_price(rs.getInt("product_price"));
			productVO.setProduct_quantity(rs.getInt("product_quantity"));
			productVO.setProduct_status(rs.getBoolean("product_status"));
			list.add(productVO);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}




	
	
	
	@Override
	public void insert(Product_VO productVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		String col[] = {"product_id"};
		try {

			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
			
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT, col);
			
//			pstmt.setInt(1, product_category_id);
//			pstmt.setString(2, product_describtion);
//			pstmt.setInt(3, product_price);
//			pstmt.setString(4, product_name);
//			pstmt.setInt(5, product_quantity);
//			pstmt.setBoolean(6, product_status);

			pstmt.setInt(1, productVO.getProduct_category_id());
			pstmt.setString(2, productVO.getProduct_describtion());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setString(4, productVO.getProduct_name());
			pstmt.setInt(5, productVO.getProduct_quantity());
			pstmt.setBoolean(6, productVO.getProduct_status());
			

			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			productVO.setProduct_id(rs.getInt(1));

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
//	public ProductVO update() {
	public void update(Product_VO productVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
//			pstmt.setInt(1, product_category_id);
//			pstmt.setString(2, product_describtion);
//			pstmt.setInt(3, product_price);
//			pstmt.setString(4, product_name);
//			pstmt.setInt(5, product_quantity);
//			pstmt.setBoolean(6, product_status);
//			pstmt.setInt(7, product_id);
//System.out.println(productVO.getProduct_category_id());
//System.out.println("=======================");
			pstmt.setInt(1, productVO.getProduct_category_id());
//System.out.println(productVO.getProduct_category_id());
			pstmt.setString(2, productVO.getProduct_describtion());
			pstmt.setInt(3, productVO.getProduct_price());
			pstmt.setString(4, productVO.getProduct_name());
			pstmt.setInt(5, productVO.getProduct_quantity());
			pstmt.setBoolean(6, productVO.getProduct_status());
			pstmt.setInt(7, productVO.getProduct_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	
	// 要再調整delete 要連動相關表格
	@Override
	public void delete(Integer product_id) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Product_VO findByPrimarykey(Integer product_id) {
		// TODO Auto-generated method stub

		Product_VO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();

//			"UPDATE product set product_category_id=?, product_describtion=?, product_price=?, product_name=?, product_quantity=?, product_status=? "
//			+ "where product_id = ?";
			
			while (rs.next()) {
				productVO = new Product_VO();
				productVO.setProduct_category_id(rs.getInt("product_category_id"));
				productVO.setProduct_describtion(rs.getString("product_describtion"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_quantity(rs.getInt("product_quantity"));
				productVO.setProduct_status(rs.getBoolean("product_status"));
				productVO.setProduct_id(rs.getInt("product_id"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productVO;
	}

	@Override
	public List<Product_VO> getAll() {
		// TODO Auto-generated method stub
		List<Product_VO> list = new ArrayList<Product_VO>();
		Product_VO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {				
				productVO = new Product_VO();
				productVO.setProduct_category_id(rs.getInt("product_category_id"));
				productVO.setProduct_describtion(rs.getString("product_describtion"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_quantity(rs.getInt("product_quantity"));
				productVO.setProduct_status(rs.getBoolean("product_status"));
				productVO.setProduct_id(rs.getInt("product_id"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public Product_VO findByProductName(String product_name) {
		// TODO Auto-generated method stub
		Product_VO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Product_ByProduct_name_STMT);

			pstmt.setString(1, product_name);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				productVO = new Product_VO();
				productVO.setProduct_category_id(rs.getInt("product_category_id"));
				productVO.setProduct_describtion(rs.getString("product_describtion"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_quantity(rs.getInt("product_quantity"));
				productVO.setProduct_status(rs.getBoolean("product_status"));
				productVO.setProduct_id(rs.getInt("product_id"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
		return productVO;
	}

	@Override
	public List<ProductVO> findByLikeProductName(String product_name) {
		// TODO Auto-generated method stubList<Product_VO> list = new ArrayList<Product_VO>();
/*
		List<Product_VO> list = new ArrayList<Product_VO>();
		Product_VO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_Product_By_Like_Product_name_STMT);
			pstmt.setString(1, "%" + product_name + "%");
			rs = pstmt.executeQuery();
//			System.out.println(pstmt.toString()+"===");
//printRealSql(GET_Product_By_Like_Product_name_STMT, product_name);
//pstmt.setInt(1, product_id);
//
//rs = pstmt.executeQuery();

			while (rs.next()) {				
				productVO = new Product_VO();
				productVO.setProduct_category_id(rs.getInt("product_category_id"));
				productVO.setProduct_describtion(rs.getString("product_describtion"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_quantity(rs.getInt("product_quantity"));
				productVO.setProduct_status(rs.getBoolean("product_status"));
				productVO.setProduct_id(rs.getInt("product_id"));
				list.add(productVO); // Store the row in the list
			}
System.out.println(list.size());
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
*/		
		
		
		
		
		
		
		
		
		
		
		
// ---------------------------------------------------------------	
		
		List<ProductVO> list = new ArrayList<ProductVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO productVO = null;

		try (Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GET_Product_By_Like_Product_name_STMT) ){
//			PreparedStatement pstmt = conn.prepareStatement(GET_Product_By_Lied_Product_name_STMT);
			pstmt.setString(1, "%" + product_name + "%");
			rs = pstmt.executeQuery();
//			List<Product_VO> list = null;
			while(rs.next()) {
				productVO = new ProductVO();
//				productVO.setProduct_category_id(rs.getInt("product_category_id"));
				productVO.setProduct_category_name(rs.getString("product_category_name"));
				productVO.setProduct_describtion(rs.getString("product_describtion"));
				productVO.setProduct_price(rs.getInt("product_price"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_quantity(rs.getInt("product_quantity"));
				productVO.setProduct_status(rs.getBoolean("product_status"));
				productVO.setProduct_id(rs.getInt("product_id"));
				list.add(productVO);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
// ---------------------------------------------------------------		

		
		
//		GET_Product_By_Lied_Product_name_STMT
		return list;
	}
	
	
	

	

	public static void main(String[] args) {

		Product_DAO dao = new Product_DAO();

		// 新增
//		"INSERT INTO product (product_category_id, product_describtion, product_price, product_name, product_quantity, product_status) "
//		+ "VALUES (?, ?, ?, ?, ?, ?)";
//		Product_VO productVO = new Product_VO();
//		productVO.setProduct_category_id(new Integer(1));
//		productVO.setProduct_describtion("日式進口茶葉超值組合包");
//		productVO.setProduct_price(new Integer(299));
//		productVO.setProduct_name("幸福茶葉包");
//		productVO.setProduct_quantity(new Integer(150));
//		productVO.setProduct_status(new Boolean("true"));
//		dao.insert(productVO);

		// 修改
//		"UPDATE product set product_category_id=?, product_describtion=?, product_price=?, product_name=?, product_quantity=?, product_status=? "
//		+ "where product_id = ?";
//		Product_VO productVO = new Product_VO();
//		productVO.setProduct_id(1);
//		productVO.setProduct_category_id(new Integer(1));
//		productVO.setProduct_describtion("日式進口茶葉超值組合包");
//		productVO.setProduct_price(new Integer(299));
//		productVO.setProduct_name("幸福茶葉包");
//		productVO.setProduct_quantity(new Integer(150));
//		productVO.setProduct_status(new Boolean("true"));
//		dao.update(productVO);

		// 刪除
//		dao.delete(2);

//		 查詢
//		Product_VO productVO = dao.findByPrimarykey(3);
//		System.out.println("Product_id: " + productVO.getProduct_id() + ",");
//		System.out.print("Product_category_id: " + productVO.getProduct_category_id() + ",");
//		System.out.print("Product_describtion: " + productVO.getProduct_describtion() + ",");
//		System.out.print("Product_price: " + productVO.getProduct_price() + ",");
//		System.out.print("Product_name: " + productVO.getProduct_name() + ",");
//		System.out.print("Product_quantity: " + productVO.getProduct_quantity() + ",");
//		System.out.print("Product_status: " + productVO.getProduct_status());
//		System.out.println();
//		System.out.println("---------------------");

		// 查詢
//		List<Product_VO> list = dao.getAll();
//		for (Product_VO aProduct : list) {
//			System.out.print(aProduct.getProduct_id() + ",");
//			System.out.print(aProduct.getProduct_category_id() + ",");
//			System.out.print(aProduct.getProduct_describtion() + ",");
//			System.out.print(aProduct.getProduct_price() + ",");
//			System.out.print(aProduct.getProduct_name() + ",");
//			System.out.print(aProduct.getProduct_quantity() + ",");
//			System.out.print(aProduct.getProduct_status());
//			System.out.println();			
//		}
		
		// 查詢模糊比對
		List<ProductVO> list = dao.findByLikeProductName("茶");
		for (ProductVO aProduct : list) {
			System.out.print(aProduct.getProduct_id() + ",");
			System.out.print(aProduct.getProduct_category_id() + ",");
			System.out.print(aProduct.getProduct_describtion() + ",");
			System.out.print(aProduct.getProduct_price() + ",");
			System.out.print(aProduct.getProduct_name() + ",");
			System.out.print(aProduct.getProduct_quantity() + ",");
			System.out.print(aProduct.getProduct_status());
			System.out.println();			
		}
		
	}
	
	
}

