package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Brand;
import manage.BrandDAO;

public class BrandInsertServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//Brandオブジェクトを生成
			Brand brand = new Brand();

			//BrandDAOクラスのオブジェクトを生成
			BrandDAO objDao = new BrandDAO();

			//encode
			request.setCharacterEncoding("UTF-8");

			//変数宣言
			String brandid = request.getParameter("brandid");
			String brandname = request.getParameter("brandname");

			//if文で判定→エラー画面へ
			if (brandid.isEmpty()) {
				error = "ブランドIDが未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (brandname.isEmpty()) {
				error = "ブランド名が未入力の為、登録処理は行えませんでした。";
				return;
			}

			//Wearオブジェクトに格納
			brand.setBrandid(brandid);
			brand.setBrandname(brandname);

			//Brandオブジェクトに格納されたデータをDBに登録
			objDao.insert(brand);

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
