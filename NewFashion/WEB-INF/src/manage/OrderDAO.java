package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDAO {

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



	public void insert(Order order) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO orderinfo(orderid,id,customerid,quantity,date) "
					+ "VALUES('"+order.getOrderid()+"','"+order.getId()+"','"+order.getCustomerid()
					+"','"+order.getQuantity()+"','"+order.getDate()+"')";

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



	public void update(Order order) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE orderinfo SET quantity='"+ order.getQuantity()
				+"' WHERE orderid='"+ order.getOrderid() +"'";

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



	public Order selectByOrderid(String orderid){

		Connection con = null;
		Statement smt = null;

		//Orderオブジェクトを生成
		Order order = new Order();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM orderinfo WHERE orderid= '" + orderid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Orderオブジェクトに格納
			while (rs.next()) {
				order.setOrderid(rs.getString("orderid"));
				order.setId(rs.getString("id"));
				order.setCustomerid(rs.getString("customerid"));
				order.setQuantity(rs.getInt("quantity"));
				order.setDate(rs.getString("date"));
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
		return order;
	}



	public ArrayList<Order> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Order> orderList = new ArrayList<Order>();

		String sql = "SELECT * FROM orderinfo ORDER BY date";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにOrderオブジェクトとして格納
			 */
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getString("orderid"));
				order.setId(rs.getString("id"));
				order.setCustomerid(rs.getString("customerid"));
				order.setQuantity(rs.getInt("quantity"));
				order.setDate(rs.getString("date"));
				orderList.add(order);
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
	return orderList;
	}

}
