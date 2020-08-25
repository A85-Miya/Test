package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.JAN;
import manage.JANDAO;

public class JANUpdateServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			JANDAO objDao = new JANDAO();

			//Wearオブジェクトを生成
			JAN jan = new JAN();

			request.setCharacterEncoding("UTF-8");

			String JANcode = request.getParameter("JAN");
			String name = request.getParameter("name");
			String brandid = request.getParameter("brandid");
			String categoryid = request.getParameter("categoryid");
			String catedetailid = request.getParameter("catedetailid");

			//未入力→エラー画面へ
			if (JANcode.isEmpty()) {
				error = "JANコードが未入力の為、更新処理は行えませんでした。";
				return;
			}
			if (name.isEmpty()) {
				error = "商品名が未入力の為、更新処理は行えませんでした。";
				return;
			}
			if (brandid.isEmpty()) {
				error = "ブランドが未選択の為、更新処理は行えませんでした。";
				return;
			}
			if (categoryid.isEmpty()) {
				error = "カテゴリが未選択の為、更新処理は行えませんでした。";
				return;
			}
			if (catedetailid.isEmpty()) {
				error = "服分類が未選択の為、更新処理は行えませんでした。";
				return;
			}

			//JANcodeが存在しない場合→エラー画面へ
			JAN objjan = objDao.selectByJancode(JANcode);
			if (objjan.getJancode() != null) {
				error = "該当商品がない為、処理は行えませんでした。";
				return;
			}

			jan.setJancode(JANcode);
			jan.setName(name);
			jan.setBrandid(brandid);
			jan.setCategoryid(categoryid);
			jan.setCatedetailid(catedetailid);

			//Wearオブジェクトに格納されたデータでDBを更新
			objDao.update(jan);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新処理は行えませんでした。";

		} catch (NumberFormatException nfe) {
			error = "価格の値が不正の為、更新処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);

			if (error.equals("")) {
				//「ListServlet」へフォワード
				request.getRequestDispatcher("/view/complete.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}
		}

	}

}
