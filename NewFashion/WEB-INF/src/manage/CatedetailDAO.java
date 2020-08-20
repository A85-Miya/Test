package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CatedetailDAO {

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



	public void insert(Catedetail catedetail) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO catedetailinfo(catedetailid,catedetailname) "
					+ "VALUES('"+ catedetail.getCatedetailid() +"','"+ catedetail.getCatedetailname() +"')";

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



	public void update(Catedetail catedetail) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE catedetailinfo SET catedetailname='"+ catedetail.getCatedetailname()
				+"' WHERE catedetailid='"+ catedetail.getCatedetailid() +"'";

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



	public Catedetail selectByCatedetailid(String catedetailid){

		Connection con = null;
		Statement smt = null;

		//Bookオブジェクトを生成
		Catedetail catedetail = new Catedetail();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM catedetailinfo WHERE catedetailid= '" + catedetailid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//catedetailオブジェクトに格納
			while (rs.next()) {
				catedetail.setCatedetailid(rs.getString("catedetailid"));
				catedetail.setCatedetailname(rs.getString("catedetailname"));
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
		return catedetail;
	}



	public ArrayList<Catedetail> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Catedetail> catedetailList = new ArrayList<Catedetail>();

		String sql = "SELECT * FROM catedetailinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにBookオブジェクトとして格納
			 */
			while (rs.next()) {
				Catedetail catedetail = new Catedetail();
				catedetail.setCatedetailid(rs.getString("catedetailid"));
				catedetail.setCatedetailname(rs.getString("catedetailname"));
				catedetailList.add(catedetail);
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
	return catedetailList;
	}

}
