package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BrandDAO {

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



	public void insert(Brand brand) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO brandinfo(brandid,brandname) "
					+ "VALUES('"+ brand.getBrandid() +"','"+ brand.getBrandname() +"')";

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



	public void update(Brand brand) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE brandinfo SET brandname='"+ brand.getBrandname() +"' WHERE brandid='"+ brand.getBrandid() +"'";

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



	public Brand selectByBrandid(String brandid){

		Connection con = null;
		Statement smt = null;

		//Brandオブジェクトを生成
		Brand brand = new Brand();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM brandinfo WHERE brandid= '" + brandid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Brandオブジェクトに格納
			while (rs.next()) {
				brand.setBrandid(rs.getString("brandid"));
				brand.setBrandname(rs.getString("brandname"));
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
		return brand;
	}



	public ArrayList<Brand> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Brand> brandList = new ArrayList<Brand>();

		String sql = "SELECT * FROM brandinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにBrandkオブジェクトとして格納
			 */
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setBrandid(rs.getString("brandid"));
				brand.setBrandname(rs.getString("brandname"));
				brandList.add(brand);
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
	return brandList;
	}

}
