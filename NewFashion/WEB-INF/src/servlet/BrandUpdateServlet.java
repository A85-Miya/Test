package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Brand;
import manage.BrandDAO;

public class BrandUpdateServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			BrandDAO objDao = new BrandDAO();

			//JANオブジェクトを生成
			Brand brand = new Brand();

			request.setCharacterEncoding("UTF-8");

			String brandid = request.getParameter("brandid");
			String brandname = request.getParameter("brandname");

			if (brandname.isEmpty()) {
				error = "ブランド名が未入力の為、処理は行えませんでした。";
				return;
			}
			if (brandid.isEmpty()) {
				error = "ブランドIDが未入力の為、処理は行えませんでした。";
				return;
			}

			//idが存在しない場合→エラー画面へ
			Brand objbrand = objDao.selectByBrandid(brandid);
			if (objbrand.getBrandid() != null) {
				error = "該当商品がない為、処理は行えませんでした。";
				return;
			}

			brand.setBrandid(brandid);
			brand.setBrandname(brandname);

			//Wearオブジェクトに格納されたデータでDBを更新
			objDao.update(brand);

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
