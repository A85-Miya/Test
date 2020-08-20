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


public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";
		String cmd = "";

		try {
			cmd = request.getParameter("cmd");
			WearDAO wearDao = new WearDAO();
			ArrayList<Wear> wearList = wearDao.searchCate(cmd);

			CategoryDAO cateDao = new CategoryDAO();
			Category topname = cateDao.selectByCategoryid(cmd);

			request.setAttribute("wear_list", wearList);
			request.setAttribute("topname", topname);


			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objDao = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			//selectAllで情報を取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objDao.selectAll();
			ArrayList<Catemenu> catemenuList = objDaomenu.selectAll();
			ArrayList<Color> colorList = objColor.selectAll();
			ArrayList<Size> sizeList = objSize.selectAll();
			//requestスコープに登録
			request.setAttribute("brand_list", brandList);
			request.setAttribute("catedetail_list", catedetailList);
			request.setAttribute("category_list", categoryList);
			request.setAttribute("catemenu_list", catemenuList);
			request.setAttribute("color_list", colorList);
			request.setAttribute("size_list", sizeList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);

			if (error.equals("")) {
				//test.jspへフォワード
				request.getRequestDispatcher("/view/test.jsp").forward(request, response);
			} else {
				//error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
