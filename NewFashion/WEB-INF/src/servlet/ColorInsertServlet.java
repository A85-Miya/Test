package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Color;
import manage.ColorDAO;

public class ColorInsertServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//Colorオブジェクトを生成
			Color color = new Color();

			//ColorDAOクラスのオブジェクトを生成
			ColorDAO objDao = new ColorDAO();

			//encode
			request.setCharacterEncoding("UTF-8");

			//変数宣言
			String colorid = request.getParameter("colorid");
			String colorname = request.getParameter("colorname");

			//if文で判定→エラー画面へ
			if (colorid.isEmpty()) {
				error = "ブランドIDが未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (colorname.isEmpty()) {
				error = "ブランド名が未入力の為、登録処理は行えませんでした。";
				return;
			}

			//Colorオブジェクトに格納
			color.setColorid(colorid);
			color.setColorname(colorname);

			//Brandオブジェクトに格納されたデータをDBに登録
			objDao.insert(color);

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
