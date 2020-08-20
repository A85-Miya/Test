package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WearDAO {

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



	public void insert(Wear wear) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "INSERT INTO JANlist (JAN, name, intax, outtax, purchase, ordervalue, ordercomid, "
					+ "brandid, categoryid, catedetailid, sizeid, colorid, comment) "
					+ "VALUES('"+ wear.getJancode() +"','"+ wear.getName() +"','"+ wear.getIntax() +"','"
					+ wear.getOuttax() +"','"+ wear.getPurchase() +"','"+ wear.getOrdervalue() +"','"
					+ wear.getOrdercomid() +"','"+ wear.getBrandid() +"','"+ wear.getCategoryid() +"','"
					+ wear.getCatedetailid() +"','"+ wear.getSizeid() +"','"+ wear.getColorid() +"','"
					+ wear.getComment() +"')";

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



	public void updateTAG(Wear wear) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE JANlist SET tagone='"+ wear.getTagone()
					+"' tagtwo='"+ wear.getTagtwo() +"' tagthree='"+ wear.getTagthree()
					+"' WHERE id='"+ wear.getId() +"'";

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



	public void updateSALE(Wear wear) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE JANlist SET saleintax='"+ wear.getSaleintax() +"' saletag='"+ wear.getSaletag() +"' "
					+ "WHERE id='"+ wear.getId() +"'";

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



	public void update(Wear wear) {

		Connection con = null;
		Statement smt = null;

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "UPDATE JANlist SET name='"+ wear.getName() +"' intax='"+ wear.getIntax()
					+"' outtax='"+ wear.getOuttax() +"' purchase='"+ wear.getPurchase() +"' "
					+ "WHERE id='"+ wear.getId() +"'";

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



	public Wear selectByid(String id){

		Connection con = null;
		Statement smt = null;

		//Wearオブジェクトを生成
		Wear wear = new Wear();

		try {
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//SQL文を文字列として定義
			String sql = "SELECT * FROM JANlist WHERE id= '" + id + "'";

			//executeQuery()メソッドを利用し、結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			//Wearオブジェクトに格納
			while (rs.next()) {
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
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
		return wear;
	}



	public ArrayList<Wear> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Wear> wearList = new ArrayList<Wear>();

		String sql = "SELECT * FROM JANlist";

		try{
			//Connectionオブジェクトを生成
			con = getConnection();
			//Statementオブジェクトを生成
			smt = con.createStatement();
			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
	return wearList;
	}



	public ArrayList<Wear> search(String name) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist WHERE name LIKE '%"+ name +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchBrand(String brandid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist WHERE brandid LIKE '%"+ brandid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットから書籍データを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchCate(String catedetailid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist WHERE catedetailid LIKE '%"+ catedetailid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchSize(String sizeid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist WHERE sizeid LIKE '%"+ sizeid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchColor(String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist WHERE colorid LIKE '%"+ colorid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchI(String brandid, String catedetailid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid
							+ "%' AND brandid LIKE '%" + brandid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchII(String brandid, String sizeid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE brandid LIKE '%"+ brandid
							+ "%' AND sizeid LIKE '%" + sizeid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchIII(String brandid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE brandid LIKE '%"+ brandid
							+ "%' AND colorid LIKE '%" + colorid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchIV(String sizeid, String catedetailid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid
							+ "%' AND sizeid LIKE '%" + sizeid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchV(String colorid, String catedetailid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid
							+ "%' AND colorid LIKE '%" + colorid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchVI(String sizeid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE colorid LIKE '%"+ colorid
							+ "%' AND sizeid LIKE '%" + sizeid + "%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchOne(String catedetailid, String sizeid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid +"%' AND sizeid LIKE '%"+ sizeid
							+"%' AND colorid LIKE '%"+ colorid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchTwo(String brandid, String sizeid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE brandid LIKE '%"+ brandid +"%' AND sizeid LIKE '%"+ sizeid
							+"%' AND colorid LIKE '%"+ colorid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchThree(String brandid, String catedetailid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid +"%' AND brandid LIKE '%"+ brandid
							+"%' AND colorid LIKE '%"+ colorid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}


	public ArrayList<Wear> searchFour(String catedetailid, String sizeid, String brandid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid +"%' AND sizeid LIKE '%"+ sizeid
							+"%' AND brandid LIKE '%"+ brandid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}



	public ArrayList<Wear> searchAll(String brandid, String catedetailid, String sizeid, String colorid) {

		Connection con = null;
		Statement smt = null;

		//AllayListオブジェクトを生成
		ArrayList<Wear> wearList = new ArrayList<Wear>();

		//SQL文を文字列として定義
		String sql = "SELECT * FROM JANlist"
							+ " WHERE catedetailid LIKE '%"+ catedetailid +"%' AND sizeid LIKE '%"+ sizeid
							+"%' AND colorid LIKE '%"+ colorid +"%' AND brandid LIKE '%"+ brandid +"%'";

		try{
			//Connectionオブジェクト・Statementオブジェクトを生成
			con = getConnection();
			smt = con.createStatement();

			//resultセットを取得
			ResultSet rs = smt.executeQuery(sql);

			/*
			 * 結果セットからデータを検索件数分全て取り出し、
			 * AllayListオブジェクトにWearオブジェクトとして格納
			 */
			while (rs.next()) {
				Wear wear = new Wear();
				wear.setId(rs.getString("id"));
				wear.setJancode(rs.getString("JAN"));
				wear.setName(rs.getString("name"));
				wear.setIntax(rs.getInt("intax"));
				wear.setOuttax(rs.getInt("outtax"));
				wear.setSaleintax(rs.getInt("saleintax"));
				wear.setSaletag(rs.getString("saletag"));
				wear.setPurchase(rs.getInt("purchase"));
				wear.setOrdervalue(rs.getInt("ordervalue"));
				wear.setOrdercomid(rs.getString("ordercomid"));
				wear.setImage(rs.getString("image"));
				wear.setBrandid(rs.getString("brandid"));
				wear.setCategoryid(rs.getString("categoryid"));
				wear.setCatedetailid(rs.getString("catedetailid"));
				wear.setSizeid(rs.getString("sizeid"));
				wear.setColorid(rs.getString("colorid"));
				wear.setTagone(rs.getString("tagone"));
				wear.setTagtwo(rs.getString("tagtwo"));
				wear.setTagthree(rs.getString("tagthree"));
				wear.setComment(rs.getString("comment"));
				wearList.add(wear);
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
		return wearList;
	}

}
