/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2016-05-14 21:11:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/menu.jsp", Long.valueOf(1462721683000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html >\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login_style.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-latest.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"css/menu_style.css\">\n");
      out.write("\t\t\n");
      out.write("\t</head>\n");
      out.write("\t<body style= \"margin:0\">\n");
      out.write("\t\t<div id = \"mySidenav\" class = \"sidenav\">\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"closebtn menu-item-line\" onclick=\"closeNav()\">x</a>\n");
      out.write("\t\t\t<a href=\"login.jsp\" class=\"firstitem menu-item-line\">ورود</a>\n");
      out.write("\t\t\t<a href=\"projects_list.jsp\" class=\"seconditem menu-item-line\">پروژه&nbsp;ها</a>\n");
      out.write("\t\t\t<a href=\"contact-us.jsp\" class=\"thirditem menu-item-line\">ارتباط&nbsp;با&nbsp;ما</a>\n");
      out.write("\t\t\t<a href=\"about_us.jsp\" class=\"forthitem menu-item-line\">درباره&nbsp;ما</a>\n");
      out.write("\t\t\t<a href=\"creat_new_project.jsp\" class=\"fifthitem menu-item-line\">ایجاد&nbsp;پروژه</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"header\">\n");
      out.write("\t\t\t<span style=\"box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24); font-size:15px;cursor:pointer;position: absolute;right:10px;top:5px; border:1px solid black; margin: 5px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#ffffff;\" onclick=\"openNav()\">\n");
      out.write("\t\t\t\t<img src=\"img/menu-black.png\"/> \n");
      out.write("\t\t\t</span>\n");
      out.write("\t\t\t<span style=\"cursor:pointer;position: absolute;left:10px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;\">\n");
      out.write("\t\t\t\t<a href=\"first_page.jsp\" id=\"logo\"></a>\n");
      out.write("\t\t\t</span>\n");
      out.write("\t\t\t<span id=\"header_text\" style=\"cursor:pointer;position: absolute;left:110px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;\" onclick=\"openLink();\">وب سایت کاریابی پونیشا</span>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- Slidebars -->\n");
      out.write("\t\t<script src=\"js/menu_functions.js\"></script>\n");
      out.write("\t</body>\n");
      out.write("</html>");
      out.write(" \n");
      out.write("        <div id=\"form-main\" dir = \"rtl\">\n");
      out.write("            <div id=\"form-div\">\n");
      out.write("                <form class=\"form\" id=\"form1\"  role=\"form\" method=\"post\" action=\"RegisterController\">\n");
      out.write("                    <p class=\"name\" >\n");
      out.write("                        <input name=\"userName\" type=\"text\" class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" placeholder=\"نام کاربری\" id=\"name\" />\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <p class=\"email\" >\n");
      out.write("                        <input name=\"email\" type=\"text\" class=\"validate[required,custom[onlyLetter],length[0,100]] feedback-input\" placeholder=\"آدرس پست الکترونیکی\" id=\"email\" />\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <p class=\"password\">\n");
      out.write("                        <input name=\"password\" type=\"text\" class=\"validate[required,custom[email]] feedback-input\" id=\"password\" placeholder=\"رمز عبور\" />\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <div class = \"row\" >\n");
      out.write("                        <div class = \"col-md-6 col-sm-6 col-xs-6\">\n");
      out.write("                            <div class=\"submit\">\n");
      out.write("                                <input type=\"submit\" value=\"ثبت نام\" id=\"button-red\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
