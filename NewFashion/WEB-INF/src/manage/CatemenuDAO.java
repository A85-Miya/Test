package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CatemenuDAO {

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



	public void insert(Catemenu catemenu) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO catemenuinfo(catemenuid,catemenuname) "
					+ "VALUES('"+ catemenu.getCatemenuid() +"','"+ catemenu.getCatemenuname() +"')";

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



	public void update(Catemenu catemenu) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE catemenuinfo SET catemenuname='"+ catemenu.getCatemenuname() +"' WHERE catemenuid='"+ catemenu.getCatemenuid() +"'";

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



	public Catemenu selectByCatemenuid(String catemenuid){

		Connection con = null;
		Statement smt = null;

		//catemenuオブジェクトを生成
		Catemenu catemenu = new Catemenu();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM catemenuinfo WHERE catemenuid= '" + catemenuid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//catemenuオブジェクトに格納
			while (rs.next()) {
				catemenu.setCatemenuid(rs.getString("catemenuid"));
				catemenu.setCatemenuname(rs.getString("catemenuname"));
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
		return catemenu;
	}



	public ArrayList<Catemenu> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Catemenu> catemenuList = new ArrayList<Catemenu>();

		String sql = "SELECT * FROM catemenuinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにcatemenuオブジェクトとして格納
			 */
			while (rs.next()) {
				Catemenu catemenu = new Catemenu();
				catemenu.setCatemenuid(rs.getString("catemenuid"));
				catemenu.setCatemenuname(rs.getString("catemenuname"));
				catemenuList.add(catemenu);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//リソースの開放
			if ( smt != null ) {
				try { smt.close(); } catch (SQLException ignore) { }
			}
			if ( con != null ) {
				try { con.close(); } catch (SQLException ignore) { }
			}
		}
	return catemenuList;
	}

}
