package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Wear;
import manage.WearDAO;

public class WearDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		//DAOクラスのオブジェクトを生成
		WearDAO objWear = new WearDAO();

		try {
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");
			Wear wear = objWear.selectByid(id);

			if (wear == null) {
				error = "削除対象の商品が存在しないため、処理ができませんでした。";
				return;
			}

			objWear.delete(id);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);

			if (error.isEmpty()) {
					request.getRequestDispatcher("/view/menustaff.jsp").forward(request, response);

			} else {
				//error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
