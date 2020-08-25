package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Wear;
import manage.WearDAO;

public class WearSaleServlet extends HttpServlet {

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
			String strsaleintax = request.getParameter("saleintax");
			String saletag = request.getParameter("saletag");


			if (strsaleintax.isEmpty()) {
				error = "セール価格(税込)が未入力の為、処理は行えませんでした。";
				return;
			}
			if (saletag.isEmpty()) {
				error = "セールフラグが未入力の為、処理は行えませんでした。";
				return;
			}

			//idが存在しない場合→エラー画面へ
			Wear objwear = objDao.selectByid(id);
			if (objwear.getId() != null) {
				error = "該当商品がない為、処理は行えませんでした。";
				return;
			}

			int saleintax = Integer.parseInt(strsaleintax);
			wear.setId(id);
			wear.setSaleintax(saleintax);
			wear.setSaletag(saletag);


			//Wearオブジェクトに格納されたデータでDBを更新
			objDao.updateSALE(wear);

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
