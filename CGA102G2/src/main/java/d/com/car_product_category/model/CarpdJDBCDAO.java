package d.com.car_product_category.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarpdJDBCDAO implements CarpdDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA102_2?serverTimezone=Asia/Taipei";
	// 記得修改database => CGA102
	String userid = "root";
	String passwd = "00000000";

	private static final String INSERT_STMT = "INSERT INTO CAR_PRODUCT_CATEGORY (product_id,member_id,product_name,quantity) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM CAR_PRODUCT_CATEGORY order by quantity";
	private static final String GET_ONE_STMT = "SELECT * FROM CAR_PRODUCT_CATEGORY where product_id=? and member_id = ?";
	private static final String DELETE = "DELETE FROM CAR_PRODUCT_CATEGORY where product_id = ? and member_id = ?";
	private static final String DELETEALL = "DELETE FROM CAR_PRODUCT_CATEGORY where member_id = ?";
	private static final String UPDATE = "UPDATE CAR_PRODUCT_CATEGORY set quantity=? where product_id=? and member_id=?";
	private static final String GET_ALL_BY_MEMBER_ID = "select * from CAR_PRODUCT_CATEGORY where member_id = ?;";

	@Override
	public void insert(CarpdVO car) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, car.getProduct_id());
			pstmt.setInt(2, car.getMember_id());
			pstmt.setString(3, car.getProduct_name());
			pstmt.setInt(4, car.getQuantity());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(Integer product_id, Integer member_id, Integer qauntity) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, product_id);
			pstmt.setInt(2, member_id);
			pstmt.setInt(3, qauntity);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer product_id, Integer member_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_id);
			pstmt.setInt(2, member_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public void deleteAll(Integer member_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETEALL);

			pstmt.setInt(1, member_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public CarpdVO findByPrimaryKey(Integer product_id, Integer member_id) {
		CarpdVO car = new CarpdVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_id);
			pstmt.setInt(2, member_id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				car.setProduct_id(rs.getInt("product_id"));
				car.setMember_id(rs.getInt("member_id"));
				car.setProduct_name(rs.getString("product_name"));
				car.setQuantity(rs.getInt("quantity"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return car;
	}

	@Override
	public List<CarpdVO> getAll() {

		List<CarpdVO> car_allList = new ArrayList<CarpdVO>(); // no use for HashSet and TreeSet
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				CarpdVO car = new CarpdVO();
				car.setProduct_id(rs.getInt("product_id"));
				car.setMember_id(rs.getInt("member_id"));
				car.setProduct_name(rs.getString("product_name"));
				car.setQuantity(rs.getInt("quantity"));
				car_allList.add(car);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return car_allList;
	}

	public List<CarpdVO> getMembersCar(Integer member_id) {

		List<CarpdVO> car_allList = new ArrayList<CarpdVO>(); // no use for HashSet and TreeSet
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_BY_MEMBER_ID);
			pstmt.setInt(1, member_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CarpdVO car = new CarpdVO();
				car.setProduct_id(rs.getInt("product_id"));
				car.setMember_id(rs.getInt("member_id"));
				car.setProduct_name(rs.getString("product_name"));
				car.setQuantity(rs.getInt("quantity"));
				car_allList.add(car);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return car_allList;
	}

	public static void main(String[] args) {
		CarpdJDBCDAO dao = new CarpdJDBCDAO();

		// insert
		CarpdVO car = new CarpdVO();
		car.setMember_id(5);
		car.setProduct_id(3);
		car.setProduct_name("測試");
		car.setQuantity(34);
		dao.insert(car);

		// update
//		dao.update(22, 1, 1);

		// delete
//		dao.delete(5);

		// find one
//		CarpdVO car = dao.findByPrimaryKey(2, 5);
//		System.out.println(car);

		// find all
//		List<CarpdVO> carList = dao.getAll();
//		for(CarpdVO eachCar : carList) {
//			System.out.println(eachCar);
//		}

	}

}
