package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDAO {

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



	public void insert(Staff staff) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO staffinfo(staffid,staffname,staffpass) "
					+ "VALUES('"+staff.getStaffid()+"','"+staff.getStaffname()+"','"+staff.getStaffpass()+"')";

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



	public Staff selectByStaffid(String staffid){

		Connection con = null;
		Statement smt = null;

		//Staffオブジェクトを生成
		Staff staff = new Staff();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM staffinfo WHERE staffid= '" + staffid + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Staffオブジェクトに格納
			while (rs.next()) {
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setStaffpass(rs.getString("staffpass"));
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
		return staff;
	}



	public ArrayList<Staff> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Staff> staffList = new ArrayList<Staff>();

		String sql = "SELECT * FROM staffinfo";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにStaffオブジェクトとして格納
			 */
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setStaffpass(rs.getString("staffpass"));
				staffList.add(staff);
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
	return staffList;
	}


	public void delete(String staffid) {

		Connection con = null;
		Statement smt = null;

		try {

			//SQL文を文字列として定義
			String sql = "DELETE FROM staffinfo WHERE staffid ='" + staffid + "'";

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

	public void update(Staff staff) {

		Connection con = null;
		Statement smt = null;

		try {
			//SQL文を文字列として定義
			String sql = "UPDATE staffinfo SET staffname='"+staff.getStaffname()+"', "
					+ "staffpass='"+staff.getStaffpass()+"' WHERE staffid='"+staff.getStaffid()+"'";

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
}
