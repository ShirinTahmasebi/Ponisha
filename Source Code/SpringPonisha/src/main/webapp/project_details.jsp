<%@page import="ir.ac.sbu.springponisha.dao.model.RequestedProjects"%>
<%@page import="java.util.List"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.Project"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">   
    <script src="js/jquery-latest.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%@ page 
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        %>
    <body style= " text-align: justify; text-justify: inter-word;">

        <%Project project = (Project) request.getAttribute(Tag.PROJECT);%>
        <%@ include file="menu.jsp" %> 

        <div class = "container" dir="rtl">
            <hr>
            <div class = "row" >
                <% if (project != null && project.getProjectName() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getProjectName()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">نام پروژه:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    if (project != null && project.getUserCreator() != null && project.getUserCreator().getUserFirstLastName() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getUserCreator().getUserFirstLastName()
                                + "</div>"
                        );
                    } else if (project != null && project.getUserCreator() != null && project.getUserCreator().getUserFirstLastName() == null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getUserCreator().getUsername()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">نام کارفرما:</div>
            </div>

            <hr>

            <div class = "row" >
                <% if (project != null && project.getBudget() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getBudget()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">بودجه تقریبی:</div>
            </div>

            <hr>

            <div class = "row" >
                <% if (project != null && project.getDeadline() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getDeadline()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">ددلاین کار:</div>
            </div>

            <hr>

            <div class = "row" >
                <% if (project != null && project.getNeededSkills() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getNeededSkills()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">مهارت های مورد نیاز:</div>
            </div>

            <hr>

            <div class = "row" >
                <% if (project != null && project.getProjectDescription() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + project.getProjectDescription()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">توضیحات پروژه:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    out.println("<a href='recommendation.jsp?projectId="
                            + project.getProjectId()
                            + "'"
                            + "class='btn btn-info col-md-2 col-sm-2 col-xs-2' role='button'>ارسال پیشنهاد</a>");
                %>
                <div class = "col-md-7 col-sm-7 col-xs-7"></div>
                <div class = "col-md-3 col-sm-3 col-xs-3">پیشنهاد های ثبت شده:</div>
            </div>

            <div style="margin:20px auto" class= "table-body container">  
                <div class="table-responsive">
                    <table id="myTable"class="table hover" collapsing="0" width="100%" >
                        <thead>  
                            <tr >  
                                <th style="text-align:right;">نام&nbsp;کارجو</th>  
                                <th style="text-align:right;">مبلغ</th>  
                                <th style="text-align:right;">زمان&nbsp;انجام</th>  
                                <th style="text-align:right;">توضیحات</th> 
                                <th style="text-align:right;"></th>  
                                <th style="display: none;text-align:right;">userID!</th>  
                            </tr>  
                        </thead>  
                        <tbody>  
                            <%
                                List<RequestedProjects> requestedProjects = project.getRequestedProjectsList();

                                for (RequestedProjects requestProj : requestedProjects) {
                            %>
                            <tr>
                                <td><%=(requestProj.getUserId().getUserFirstLastName() != null) ? requestProj.getUserId().getUserFirstLastName() : requestProj.getUserId().getUsername()%></td>
                                <td><%=requestProj.getPrice()%></td>
                                <td><%=requestProj.getDeadline()%></td>
                                <td><%=requestProj.getDescription()%></td>
                                <td><%
                                    out.println("<a href='user_profile_editable.jsp?userId="
                                            + requestProj.getUserId().getUserId()
                                            + "'"
                                            + "class='btn btn-default' role='button'>مشاهده پروفایل کارجو</a>");
                                    %></td>
                                <td style="display:none;"><%=requestProj.getUserId().getUserId()%></td>
                            </tr>

                            <%}%>


                        </tbody>  
                    </table>  
                </div>
            </div>

        </div>



    </body>
</html>


