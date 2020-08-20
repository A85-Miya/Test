package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdercomDAO {

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



	public void insert(Ordercom ordercom) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO ordercominfo(ordercomid,ordercomname) "
					+ "VALUES('"+ ordercom.getOrdercomid() +"','"+ ordercom.getOrdercomname() +"')";

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



	public void update(Ordercom ordercom) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE ordercominfo SET ordercomname='"+ ordercom.getOrdercomname()
				+"' WHERE ordercomid='"+ ordercom.getOrdercomid() +"'";

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



	public Ordercom selectByOrdercomid(String ordercomid){

		Connection con = null;
		Statement smt = null;

		//Ordercomオブジェクトを生成
		Ordercom ordercom = new Ordercom();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM ordercominfo WHERE ordercomid= '" + ordercomid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Ordercomオブジェクトに格納
			while (rs.next()) {
				ordercom.setOrdercomid(rs.getString("ordercomid"));
				ordercom.setOrdercomname(rs.getString("ordercomname"));
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
		return ordercom;
	}



	public ArrayList<Ordercom> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Ordercom> ordercomList = new ArrayList<Ordercom>();

		String sql = "SELECT * FROM ordercominfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにOrdercomオブジェクトとして格納
			 */
			while (rs.next()) {
				Ordercom ordercom = new Ordercom();
				ordercom.setOrdercomid(rs.getString("ordercomid"));
				ordercom.setOrdercomname(rs.getString("ordercomname"));
				ordercomList.add(ordercom);
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
	return ordercomList;
	}

}
