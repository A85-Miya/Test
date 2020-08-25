package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Wear;
import manage.WearDAO;

public class WearTagServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			WearDAO objDao = new WearDAO();

			//Wearオブジェクトを生成
			Wear wear = new Wear();

			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");
			String tagone = request.getParameter("tagone");
			String tagtwo = request.getParameter("tagtwo");
			String tagthree = request.getParameter("tagthree");

			if (tagone.isEmpty()) {
				error = "タグ１が未入力の為、処理は行えませんでした。";
				return;
			}

			//idが存在しない場合→エラー画面へ
			Wear objwear = objDao.selectByid(id);
			if (objwear.getId() != null) {
				error = "該当商品がない為、処理は行えませんでした。";
				return;
			}

			wear.setId(id);
			wear.setTagone(tagone);

			if (tagthree.isEmpty() && tagtwo.isEmpty()) {

			} else if (tagthree.isEmpty()) {
				wear.setTagtwo(tagtwo);

			} else {
				wear.setTagthree(tagthree);

			}

			//Wearオブジェクトに格納されたデータでDBを更新
			objDao.updateTAG(wear);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新処理は行えませんでした。";

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
