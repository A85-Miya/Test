package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import manage.Customer;
import manage.Order;
import manage.OrderDAO;
import manage.Size;
import manage.SizeDAO;
import manage.Wear;
import manage.WearDAO;


public class DeleteCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objDao = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			WearDAO objwear = new WearDAO();
			//selectAllでデータ取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objDao.selectAll();
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

			//encodeingの指定
			request.setCharacterEncoding("UTF-8");

			//Customer情報がある場合、取得したCustomerオブジェクトをセッションスコープへ登録
			//sessionオブジェクトの生成
			HttpSession session = request.getSession();

			Customer customer = (Customer)session.getAttribute("customer");
			String customerid = customer.getCustomerid();

			String orderid = request.getParameter("orderid");
			OrderDAO objorder = new OrderDAO();
			Order order = objorder.selectByOrderid(orderid);

			if (order.getDate().isEmpty()) {
				error = "注文履歴が存在しない為、キャンセルできませんでした。";
				return;
			}

			objorder.delete(orderid);

		} catch (NumberFormatException nfe) {
			error = "価格の値が不正の為、更新処理は行えませんでした。";

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、処理は行えませんでした。";

		} finally {
			request.setAttribute("error", error);
			if (error.equals("")) {
				//grandmenu.jspへフォワード
				request.getRequestDispatcher("/view/cartlistcustomer.jsp").forward(request, response);
			} else {
				//error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
