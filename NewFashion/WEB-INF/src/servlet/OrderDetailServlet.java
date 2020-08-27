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
import manage.Order;
import manage.OrderDAO;
import manage.Size;
import manage.SizeDAO;
import manage.Wear;
import manage.WearDAO;

public class OrderDetailServlet extends HttpServlet {

	//書籍詳細機能
	public void doPost(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";
		String cmd = "";

		try {
			OrderDAO objDao = new OrderDAO();

			request.setCharacterEncoding("UTF-8");

			cmd = request.getParameter("cmd");
			String orderid = request.getParameter("orderid");

			if (cmd == null) {
				cmd= "";
			}

			Order order = objDao.selectByOrderid(orderid);

			//対象が存在しない場合→エラー画面へ
			if (order.getId().isEmpty()) {
				error = "対象が存在しない為、処理できませんでした。";
			}

			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objCategory = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			WearDAO objwear = new WearDAO();
			//selectAllでデータ取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objCategory.selectAll();
			ArrayList<Catemenu> catemenuList = objDaomenu.selectAll();
			ArrayList<Color> colorList = objColor.selectAll();
			ArrayList<Size> sizeList = objSize.selectAll();
			ArrayList<Wear> wearList = objwear.selectAll();
			//requestに登録
			request.setAttribute("brand_list", brandList);
			request.setAttribute("catedetail_list", catedetailList);
			request.setAttribute("category_list", categoryList);
			request.setAttribute("catemenu_list", catemenuList);
			request.setAttribute("color_list", colorList);
			request.setAttribute("size_list", sizeList);
			request.setAttribute("wear_list", wearList);
			request.setAttribute("order", order);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、更新処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);
			request.setAttribute("cmd", cmd);

			if (error.equals("")) {

				if (cmd.equals("update")) {
					request.getRequestDispatcher("/view/cartupdate.jsp").forward(request, response);

				} else if (cmd.equals("delete")) {
					request.getRequestDispatcher("/view/cartdelete.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/view/cartdetail.jsp").forward(request, response);

				}

			} else {
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
