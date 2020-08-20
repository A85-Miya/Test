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


public class WearSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";
		String catedetailid = "";
		String brandid = "";
		String sizeid = "";
		String colorid = "";

		try {
			WearDAO objWear = new WearDAO();
			request.setCharacterEncoding("UTF-8");

			brandid = request.getParameter("brandid");
			catedetailid = request.getParameter("catedetailid");
			sizeid = request.getParameter("sizeid");
			colorid = request.getParameter("colorid");

			ArrayList<Wear> wearList = objWear.selectAll();

			if (catedetailid.equals("")&&sizeid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchBrand(brandid);

			} else if (brandid.equals("")&&sizeid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchCate(catedetailid);

			} else if (brandid.equals("")&&catedetailid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchSize(sizeid);

			} else if (brandid.equals("")&&catedetailid.equals("")&&sizeid.equals("")) {
				wearList = objWear.searchColor(colorid);

			} else if (sizeid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchI(brandid, catedetailid);

			} else if (catedetailid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchII(brandid, sizeid);

			} else if (catedetailid.equals("")&&sizeid.equals("")) {
				wearList = objWear.searchIII(brandid, colorid);

			} else if (brandid.equals("")&&colorid.equals("")) {
				wearList = objWear.searchIV(sizeid, catedetailid);

			} else if (brandid.equals("")&&sizeid.equals("")) {
				wearList = objWear.searchV(colorid, catedetailid);

			} else if (brandid.equals("")&&catedetailid.equals("")) {
				wearList = objWear.searchVI(sizeid, colorid);

			} else if (brandid.equals("")) {
				wearList = objWear.searchOne(catedetailid, sizeid, colorid);

			} else if (catedetailid.equals("")) {
				wearList = objWear.searchTwo(brandid, sizeid, colorid);

			} else if (sizeid.equals("")) {
				wearList = objWear.searchThree(brandid, catedetailid, colorid);

			} else if (colorid.equals("")) {
				wearList = objWear.searchFour(catedetailid, sizeid, brandid);

			}

			request.setAttribute("wear_list", wearList);


			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objDao = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			//
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objDao.selectAll();
			ArrayList<Catemenu> catemenuList = objDaomenu.selectAll();
			ArrayList<Color> colorList = objColor.selectAll();
			ArrayList<Size> sizeList = objSize.selectAll();
			//
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
				//「ListServlet」へフォワード
				request.getRequestDispatcher("/view/wearanswer.jsp").forward(request, response);
			} else {
				//「error.jsp」へフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
