/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2020-08-31 08:53:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import manage.Wear;
import manage.Brand;
import manage.Size;
import manage.Color;
import manage.Ordercom;
import manage.Category;
import manage.Catedetail;

public final class weardelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/view/footer.jsp", Long.valueOf(1595227668407L));
    _jspx_dependants.put("/view/header.jsp", Long.valueOf(1597823643926L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("manage.Wear");
    _jspx_imports_classes.add("manage.Brand");
    _jspx_imports_classes.add("manage.Size");
    _jspx_imports_classes.add("manage.Color");
    _jspx_imports_classes.add("manage.Ordercom");
    _jspx_imports_classes.add("manage.Catedetail");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("manage.Category");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

Wear wear = (Wear)request.getAttribute("wear");
ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brand_list");
ArrayList<Size> sizeList = (ArrayList<Size>)request.getAttribute("size_list");
ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("category_list");
ArrayList<Catedetail> catedetailList = (ArrayList<Catedetail>)request.getAttribute("catedetail_list");
ArrayList<Color> colorList = (ArrayList<Color>)request.getAttribute("color_list");
ArrayList<Ordercom> ordercomList = (ArrayList<Ordercom>)request.getAttribute("ordercom_list");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>fashion</title>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t.box{\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.box-above{\r\n");
      out.write("\t\t\twidth:100%;\r\n");
      out.write("\t\t\theight:400px;\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t\tbackground-color:#FFFFFF;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.box-above2{\r\n");
      out.write("\t\t\twidth:100%;\r\n");
      out.write("\t\t\theight:150px;\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t\tbackground-color:#FFFFFF;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.box-left{\r\n");
      out.write("\t\t\twidth:25%;\r\n");
      out.write("\t\t\tbackground-color:#E5E5E5;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.box-right{\r\n");
      out.write("\t\t\twidth:75%;\r\n");
      out.write("\t\t\tbackground-color:#FFFFAA;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.box-bottom{\r\n");
      out.write("\t\t\twidth:100%;\r\n");
      out.write("\t\t\theight:50px;\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t\tbackground-color:#A7CE02;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.float-left{\r\n");
      out.write("\t\t\tfloat:left;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.clearfix:after{\r\n");
      out.write("\t\t\tcontent:\"\";\r\n");
      out.write("\t\t\tdisplay:block;\r\n");
      out.write("\t\t\tclear:both;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttr {\r\n");
      out.write("\t\t\tbackground: #FFFFFF; /** 行全体の背景色を指定する */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttr:nth-child(odd) {\r\n");
      out.write("\t\t\tbackground: #E5E5E5; /** 奇数行の背景色を指定する */\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"box\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\t.box2{\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t.left{\r\n");
      out.write("\t\twidth:25%;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tbackground-color:#FFFFFF;\r\n");
      out.write("\t}\r\n");
      out.write("\t.right{\r\n");
      out.write("\t\twidth:75%;\r\n");
      out.write("\t\ttext-align:right;\r\n");
      out.write("\t\tmargin:30px 0px 0px;\r\n");
      out.write("\t\tbackground-color:#FFFFFF;\r\n");
      out.write("\t}\r\n");
      out.write("\t.bottom{\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\theight:10px;\r\n");
      out.write("\t\tbackground-color:#FFFFFF;\r\n");
      out.write("\t}\r\n");
      out.write("\t.float-left{\r\n");
      out.write("\t\tfloat:left;\r\n");
      out.write("\t}\r\n");
      out.write("\t.clearfix:after{\r\n");
      out.write("\t\tcontent:\"\";\r\n");
      out.write("\t\tdisplay:block;\r\n");
      out.write("\t\tclear:both;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"box2 clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"left float-left\">\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/GrandMenu\">\r\n");
      out.write("\t\t\t<img src=\"menutop.jpg\"  alt=\"ヘッダー\" width=\"250\" height=\"60\"></a></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"right float-left\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/view/logincustomer.jsp\">ログイン</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/FreeSearch\">\r\n");
      out.write("\t\t\tフリーワード検索\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"search\" value=\"\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"検索\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"bottom\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<hr style=\"height:5; background-color:#A7CE02\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"box\" align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/WearDelete\">\r\n");
      out.write("\t\t<table align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">JAN</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">商品名</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">税込価格</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">税抜価格</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">在庫</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">入荷数</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">卸売会社</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">ブランド</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">カテゴリ</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">服分類</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">サイズ</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">カラー</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th style=\"background-color:#36484F; color:#FFFFFF\">詳細情報</th>\r\n");
      out.write("\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"削除\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(wear.getId() );
      out.write("\">\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<hr style=\"text-align:center; height:5; background-color:#A7CE02\">\r\n");
      out.write("<p>&copy; Copyright 2020 All Right Reserved.</p>");
      out.write("</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}