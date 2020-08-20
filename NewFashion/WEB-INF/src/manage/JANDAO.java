package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JANDAO {

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



	public void insert(JAN jan) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO jancodeinfo(JAN,name,brandid,categoryid,catedetailid) "
					+ "VALUES('"+ jan.getJancode() +"','"+ jan.getName()
					+"','"+ jan.getBrandid() +"','"+ jan.getCategoryid() +"','"+ jan.getCatedetailid() +"')";

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



	public void update(JAN jan) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE jancodeinfo SET name='"+ jan.getName() + "' brandid='"+ jan.getBrandid()
				+"' categoryid='"+ jan.getCategoryid() +"' catedetailid='"+ jan.getCatedetailid()
				+"' WHERE JAN='"+ jan.getJancode() +"'";

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



	public JAN selectByJancode(String jancode){

		Connection con = null;
		Statement smt = null;

		//Janオブジェクトを生成
		JAN jan = new JAN();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM jancodeinfo WHERE JAN= '" + jancode + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Janオブジェクトに格納
			while (rs.next()) {
				jan.setJancode(rs.getString("JAN"));
				jan.setName(rs.getString("name"));
				jan.setBrandid(rs.getString("brandid"));
				jan.setCategoryid(rs.getString("categoryid"));
				jan.setCatedetailid(rs.getString("catedetailid"));
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
		return jan;
	}



	public ArrayList<JAN> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<JAN> janList = new ArrayList<JAN>();

		String sql = "SELECT * FROM jancodeinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにJANオブジェクトとして格納
			 */
			while (rs.next()) {
				JAN jan = new JAN();
				jan.setJancode(rs.getString("JAN"));
				jan.setName(rs.getString("name"));
				jan.setBrandid(rs.getString("brandid"));
				jan.setCategoryid(rs.getString("categoryid"));
				jan.setCatedetailid(rs.getString("catedetailid"));
				janList.add(jan);
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
	return janList;
	}

}
