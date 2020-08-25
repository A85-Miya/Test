package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.JAN;
import manage.JANDAO;

public class JANInsertServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//Wearオブジェクトを生成
			JAN jan = new JAN();

			//WearDAOクラスのオブジェクトを生成
			JANDAO objDao = new JANDAO();

			//エンコード
			request.setCharacterEncoding("UTF-8");

			//変数宣言
			String JANcode = request.getParameter("JAN");
			String name = request.getParameter("name");
			String brandid = request.getParameter("brandid");
			String categoryid = request.getParameter("categoryid");
			String catedetailid = request.getParameter("catedetailid");

			//未入力→エラー画面へ
			if (JANcode.isEmpty()) {
				error = "JANコードが未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (name.isEmpty()) {
				error = "商品名が未入力の為、登録処理は行えませんでした。";
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

			//Wearオブジェクトに格納
			jan.setJancode(JANcode);
			jan.setName(name);
			jan.setBrandid(brandid);
			jan.setCategoryid(categoryid);
			jan.setCatedetailid(catedetailid);

			//Wearオブジェクトに格納されたデータをDBに登録
			objDao.insert(jan);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録処理は行えませんでした。";

		} catch (NullPointerException ne) {
			error = "値が不正の為、登録処理は行えませんでした。";

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
