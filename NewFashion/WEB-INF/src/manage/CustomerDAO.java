package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {

	private static String RDB_DRIVE ="com.mysql.cj.jdbc.Driver";
	private static String URL ="jdbc:mysql://localhost:3306/fashiondb?serverTimezone=JST";
	private static String USER ="item";
	private static String PASS ="item123";

	private static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASS);
			return con;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}



	public void insert(Customer customer) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO customerinfo(customerid,customername,customerkana,customergender,customerbirth,tel,email,customerpass) "
					+ "VALUES('"+customer.getCustomerid()+"','"+customer.getCustomername()+"','"+customer.getCustomerkana()
					+"','"+customer.getCustomergender()+"','"+customer.getCustomerbirth()+"','"+customer.getTel()
					+"','"+customer.getEmail()+"','"+customer.getCustomerpass()+"')";

			int count = smt.executeUpdate(sql);


		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
	}



	public Customer selectByCustomerid(String customerid){

		Connection con = null;
		Statement smt = null;

		//Bookオブジェクトを生成
		Customer customer = new Customer();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM customerinfo WHERE customerid= '" + customerid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//customerオブジェクトに格納
			while (rs.next()) {
				customer.setCustomerid(rs.getString("customerid"));
				customer.setCustomername(rs.getString("customername"));
				customer.setCustomerkana(rs.getString("customerkana"));
				customer.setCustomergender(rs.getString("customergender"));
				customer.setCustomerbirth(rs.getString("customerbirth"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setCustomerpass(rs.getString("customerpass"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
		return customer;
	}



	public ArrayList<Customer> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		String sql = "SELECT * FROM customerinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにcustomerオブジェクトとして格納
			 */
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerid(rs.getString("customerid"));
				customer.setCustomername(rs.getString("customername"));
				customer.setCustomerkana(rs.getString("customerkana"));
				customer.setCustomergender(rs.getString("customergender"));
				customer.setCustomerbirth(rs.getString("customerbirth"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setCustomerpass(rs.getString("customerpass"));
				customerList.add(customer);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
	return customerList;
	}


	public void delete(String customerid) {

		Connection con = null;
		Statement smt = null;

		try {

			//SQL文を文字列として定義
			String sql = "DELETE FROM customerinfo WHERE customerid ='" + customerid + "'";

			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			int count = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
	}

	public void update(Customer customer) {

		Connection con = null;
		Statement smt = null;

		try {
			//SQL文を文字列として定義
			String sql = "UPDATE customerinfo SET customername='"+customer.getCustomername()+"',customerkana='"+customer.getCustomerkana()+"',"
					+ "customergender='"+customer.getCustomergender()+"',customerbirth='"+customer.getCustomerbirth()+"',"
					+ "tel='"+customer.getTel()+"',email='"+customer.getEmail()+"',customerpass='"+customer.getCustomerpass()+"'"
					+ " WHERE customerid='"+customer.getCustomerid()+"'";

			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			int count = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
	}

	public Customer selectByCustomer(String email, String customerpass){

		Connection con = null;
		Statement smt = null;

		//customerオブジェクトを生成
		Customer customer = new Customer();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM customerinfo WHERE customerpass= '" + customerpass + "' AND email='"+ email +"'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//customerオブジェクトに格納
			while (rs.next()) {
				customer.setCustomerid(rs.getString("customerid"));
				customer.setCustomername(rs.getString("customername"));
				customer.setCustomerkana(rs.getString("customerkana"));
				customer.setCustomergender(rs.getString("customergender"));
				customer.setCustomerbirth(rs.getString("customerbirth"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setCustomerpass(rs.getString("customerpass"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
		return customer;
	}
}
