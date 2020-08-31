package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Wear;
import manage.WearDAO;

public class WearInsertServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//Wearオブジェクトを生成
			Wear wear = new Wear();

			//WearDAOクラスのオブジェクトを生成
			WearDAO objDao = new WearDAO();

			//エンコード
			request.setCharacterEncoding("UTF-8");

			//変数宣言
			String JANcode = request.getParameter("JAN");
			String name = request.getParameter("name");
			String strintax = request.getParameter("intax");
			String strouttax = request.getParameter("outtax");
			String strpurchase = request.getParameter("purchase");
			String strordervalue = request.getParameter("ordervalue");
			String ordercomid = request.getParameter("ordercomid");
			String brandid = request.getParameter("brandid");
			String categoryid = request.getParameter("categoryid");
			String catedetailid = request.getParameter("catedetailid");
			String sizeid = request.getParameter("sizeid");
			String colorid = request.getParameter("colorid");
			String comment = request.getParameter("comment");

			//未入力→エラー画面へ
			if (JANcode.isEmpty()) {
				error = "JANコードが未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (name.isEmpty()) {
				error = "商品名が未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (strintax.isEmpty()) {
				error = "税込み価格が未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (strouttax.isEmpty()) {
				error = "税抜き価格が未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (strpurchase.isEmpty()) {
				error = "在庫数が未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (strordervalue.isEmpty()) {
				error = "入荷数が未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (ordercomid.isEmpty()) {
				error = "卸売会社が未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (brandid.isEmpty()) {
				error = "ブランドが未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (categoryid.isEmpty()) {
				error = "カテゴリが未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (catedetailid.isEmpty()) {
				error = "服分類が未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (sizeid.isEmpty()) {
				error = "サイズが未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (colorid.isEmpty()) {
				error = "カラーが未選択の為、登録処理は行えませんでした。";
				return;
			}
			if (comment.isEmpty()) {
				error = "詳細情報が未入力の為、登録処理は行えませんでした。";
				return;
			}

			//Wearオブジェクトに格納
			int intax = Integer.parseInt(strintax);
			int outtax = Integer.parseInt(strouttax);
			int purchase = Integer.parseInt(strpurchase);
			int ordervalue = Integer.parseInt(strordervalue);
			wear.setJancode(JANcode);
			wear.setName(name);
			wear.setIntax(intax);
			wear.setOuttax(outtax);
			wear.setPurchase(purchase);
			wear.setOrdervalue(ordervalue);
			wear.setOrdercomid(ordercomid);
			wear.setBrandid(brandid);
			wear.setCategoryid(categoryid);
			wear.setCatedetailid(catedetailid);
			wear.setSizeid(sizeid);
			wear.setColorid(colorid);
			wear.setComment(comment);

			//Wearオブジェクトに格納されたデータをDBに登録
			objDao.insert(wear);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録処理は行えませんでした。";

		} catch (NullPointerException ne) {
			error = "値が不正の為、登録処理は行えませんでした。";

		} catch (NumberFormatException nfe) {
			error = "価格の値が不正の為、登録処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);
			if (error.isEmpty()) {
				//「GrandMenu」へフォワード
				request.getRequestDispatcher("/GrandMenu").forward(request, response);
			} else {
				//「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
