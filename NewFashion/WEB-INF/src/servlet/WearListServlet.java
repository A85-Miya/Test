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
import manage.Ordercom;
import manage.OrdercomDAO;
import manage.Size;
import manage.SizeDAO;
import manage.Wear;
import manage.WearDAO;

public class WearListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";
		String cmd = "";

		//DAOクラスのオブジェクトを生成
		BrandDAO objBrand = new BrandDAO();
		CatedetailDAO objCate = new CatedetailDAO();
		CategoryDAO objDao = new CategoryDAO();
		CatemenuDAO objDaomenu = new CatemenuDAO();
		ColorDAO objColor = new ColorDAO();
		OrdercomDAO objcom = new OrdercomDAO();
		SizeDAO objSize = new SizeDAO();
		WearDAO objWear = new WearDAO();

		try {
			//selectAllでデータ取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objDao.selectAll();
			ArrayList<Catemenu> catemenuList = objDaomenu.selectAll();
			ArrayList<Color> colorList = objColor.selectAll();
			ArrayList<Ordercom> ordercomList = objcom.selectAll();
			ArrayList<Size> sizeList = objSize.selectAll();
			ArrayList<Wear> wearList = objWear.selectAll();
			//requestに登録
			request.setAttribute("brand_list", brandList);
			request.setAttribute("catedetail_list", catedetailList);
			request.setAttribute("category_list", categoryList);
			request.setAttribute("catemenu_list", catemenuList);
			request.setAttribute("color_list", colorList);
			request.setAttribute("ordercom_list", ordercomList);
			request.setAttribute("size_list", sizeList);
			request.setAttribute("wear_list", wearList);

			cmd = request.getParameter("cmd");


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);

			if (error.equals("")) {

				if (cmd.equals("list")) {
					request.getRequestDispatcher("/view/wearliststaff.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/view/wearinsert.jsp").forward(request, response);
				}

			} else {
				//error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
