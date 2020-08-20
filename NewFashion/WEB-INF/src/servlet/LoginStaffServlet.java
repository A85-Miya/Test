package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
import manage.Size;
import manage.SizeDAO;
import manage.Staff;
import manage.StaffDAO;

public class LoginStaffServlet {

	/**
	 * ログイン機能を実装するメソッド
	 *
	 * @param HttpServletRequestオブジェクト、HttpServletResponseオブジェクト
	 * @return なし
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "";
		String error = "";

		String staffid = null; // 従業員IDを格納する変数
		String staffpass = null; // パスワードを格納する変数
		Staff staff = null; // Staffクラスのオブジェクト変数の宣言

		try {
			//DAOクラスのオブジェクトを生成
			BrandDAO objBrand = new BrandDAO();
			CatedetailDAO objCate = new CatedetailDAO();
			CategoryDAO objDao = new CategoryDAO();
			CatemenuDAO objDaomenu = new CatemenuDAO();
			ColorDAO objColor = new ColorDAO();
			SizeDAO objSize = new SizeDAO();
			//selectAllでデータ取得
			ArrayList<Brand> brandList = objBrand.selectAll();
			ArrayList<Catedetail> catedetailList = objCate.selectAll();
			ArrayList<Category> categoryList = objDao.selectAll();
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

			//encodeingの指定
			request.setCharacterEncoding("UTF-8");

			//画面からの入力情報を受け取る
			staffid = request.getParameter("staffid");
			staffpass = request.getParameter("staffpass");

			//if文で未入力チェック
			if (staffid == "") {
				message = "スタッフIDを入力してください。";
				return;
			}
			if (staffpass == "") {
				message = "パスワードを入力して下さい。";
				return;
			}

			//StaffDAOクラスのオブジェクト生成
			StaffDAO staffDao = new StaffDAO();

			//selectByUserメソッドに、画面からの入力情報を渡してユーザー情報を取得
			staff = staffDao.selectByStaffid(staffid);

			//User情報がない場合はメッセージを格納
			if (staff.getStaffid().equals(null)) {
				message = "入力データが間違っています。";
				return;
			}

			//Staff情報がある場合、取得したStaffオブジェクトをセッションスコープへ登録
			//sessionオブジェクトの生成
			HttpSession session = request.getSession();

			//sessionへのデータの登録
			session.setAttribute("staff", staff);

			//Cookieに入力情報のstaffidとpasswordを登録
			//Cookieオブジェクトの生成
			Cookie cookieUserid = new Cookie("staffid", staffid);
			Cookie cookiePassword = new Cookie("staffpass", staffpass);

			//Cookieの有効期限の指定
			cookieUserid.setMaxAge(60 * 60 * 24 * 5);
			cookiePassword.setMaxAge(60 * 60 * 24 * 5);

			//Cookieをレスポンスに登録
			response.addCookie(cookieUserid);
			response.addCookie(cookiePassword);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";

		} catch (NumberFormatException nfe) {
			message = "入力値が不正です。";
			return;

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。";

		} finally {

			//messageによってフォワード先を変える
			if (!(message.equals(""))) { //Staff情報がないorエラーの場合

				//messageをリクエストスコープへ登録
				request.setAttribute("message", message);

				//loginstaff.jspへフォワード
				request.getRequestDispatcher("/view/loginstaff.jsp").forward(request, response);

			} else if (!(error.equals(""))) {
				//messageをリクエストスコープへ登録
				request.setAttribute("error", error);

				//error.jspへフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("/view/menustaff.jsp").forward(request, response);

			}
		}
	}
}
