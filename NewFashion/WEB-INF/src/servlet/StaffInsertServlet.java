package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.Staff;
import manage.StaffDAO;

public class StaffInsertServlet extends HttpServlet {

	//書籍登録機能
	public void doGet(HttpServletRequest request ,HttpServletResponse response)
			throws ServletException ,IOException{

		String error = "";

		try {
			//Staffオブジェクトを生成
			Staff staff = new Staff();

			//StaffDAOクラスのオブジェクトを生成
			StaffDAO objDao = new StaffDAO();

			//エンコード
			request.setCharacterEncoding("UTF-8");

			//変数宣言
			String staffid = request.getParameter("staffid");
			String staffname = request.getParameter("staffname");
			String staffpass = request.getParameter("staffpass");

			//未入力→エラー画面へ
			if (staffid.isEmpty()) {
				error = "スタッフIDが未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (staffname.isEmpty()) {
				error = "氏名が未入力の為、登録処理は行えませんでした。";
				return;
			}
			if (staffpass.isEmpty()) {
				error = "パスワードが未入力の為、登録処理は行えませんでした。";
				return;
			}


			//Staffオブジェクトに格納
			staff.setStaffid(staffid);
			staff.setStaffname(staffname);
			staff.setStaffpass(staffpass);

			//Wearオブジェクトに格納されたデータをDBに登録
			objDao.insert(staff);

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
