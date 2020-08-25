package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Wear;
import manage.WearDAO;

public class WearUpdateServlet extends HttpServlet {

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
			String name = request.getParameter("name");
			String strintax = request.getParameter("intax");
			String strouttax = request.getParameter("outtax");
			String strpurchase = request.getParameter("purchase");
			String comment = request.getParameter("comment");


			if (name.isEmpty()) {
				error = "商品名が未入力の為、処理は行えませんでした。";
				return;
			}
			if (strintax.isEmpty()) {
				error = "税込価格が未入力の為、処理は行えませんでした。";
				return;
			}
			if (strouttax.isEmpty()) {
				error = "税抜価格が未入力の為、処理は行えませんでした。";
				return;
			}
			if (strpurchase.isEmpty()) {
				error = "在庫数が未入力の為、処理は行えませんでした。";
				return;
			}
			if (comment.isEmpty()) {
				error = "詳細情報が未入力の為、処理は行えませんでした。";
				return;
			}

			//idが存在しない場合→エラー画面へ
			Wear objwear = objDao.selectByid(id);
			if (objwear.getId() != null) {
				error = "該当商品がない為、処理は行えませんでした。";
				return;
			}

			int intax = Integer.parseInt(strintax);
			int outtax = Integer.parseInt(strouttax);
			int purchase = Integer.parseInt(strpurchase);
			wear.setId(id);
			wear.setName(name);
			wear.setIntax(intax);
			wear.setOuttax(outtax);
			wear.setPurchase(purchase);
			wear.setComment(comment);

			//Wearオブジェクトに格納されたデータでDBを更新
			objDao.update(wear);

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
