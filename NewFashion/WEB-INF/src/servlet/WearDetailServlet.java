/*
 * 書籍情報(ISBN、書籍名、価格)をMySQLデータベースで管理し、
 * Web画面上から操作を行えるシステム。
 * プログラムでは書籍管理に必要なメニュー(登録、削除、変更、一覧)を提供し、
 * 選択されたメニューに応じて各処理が実行。
 *
 * 作成者：宮﨑絢子
 * 作成日：2020年5月25日
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Brand;
import manage.BrandDAO;
import manage.Catedetail;
import manage.CatedetailDAO;
import manage.Category;
import manage.CategoryDAO;
import manage.Catemenu;
import manage.CatemenuDAO;
import manage.Color;
import manage.ColorDAO;
import manage.Size;
import manage.SizeDAO;
import manage.Wear;
import manage.WearDAO;

public class WearDetailServlet extends HttpServlet {

	//書籍詳細機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";
		String cmd = "";

		try {
			WearDAO objDao = new WearDAO();

			request.setCharacterEncoding("UTF-8");

			cmd = request.getParameter("cmd");
			String id = request.getParameter("id");

			if (cmd == null) {
				cmd= "";
			}

			Wear wear = objDao.selectByid(id);

			//対象が存在しない場合→エラー画面へ
			if (wear.getId() == null) {
				error = "対象が存在しない為、処理できませんでした。";
			}

			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objCategory = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			//selectAllでデータ取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objCategory.selectAll();
			ArrayList<Catemenu> catemenuList = objDaomenu.selectAll();
			ArrayList<Color> colorList = objColor.selectAll();
			ArrayList<Size> sizeList = objSize.selectAll();
			//requestに登録
			request.setAttribute("brand_list", brandList);
			request.setAttribute("catedetail_list", catedetailList);
			request.setAttribute("category_list", categoryList);
			request.setAttribute("catemenu_list", catemenuList);
			request.setAttribute("color_list", colorList);
			request.setAttribute("size_list", sizeList);
			request.setAttribute("wear", wear);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);

			if (error.equals("")) {

				if (cmd.equals("update")) {
					request.getRequestDispatcher("/view/wearUpdate.jsp").forward(request, response);

				} else if (cmd.equals("delete")) {
					request.getRequestDispatcher("/view/wearDelete.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/view/weardetail.jsp").forward(request, response);

				}

			} else {
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
