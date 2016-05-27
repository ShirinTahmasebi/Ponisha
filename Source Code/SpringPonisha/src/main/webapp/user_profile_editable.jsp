<%@page import="java.util.List"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.ResumeItem"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.RequestedProjects"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.Project"%>
<%@page import="ir.ac.sbu.springponisha.utils.GenderType"%>
<html>
    <link rel="stylesheet" type="text/css" href="css/table_style.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">   
    <script src="js/jquery-latest.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <body style= " text-align: justify; text-justify: inter-word;">
        <%@ include file="menu.jsp" %> 
        <%  User user;
            boolean isEditable = false;
            if (request.getParameter(Tag.USER_ID) != null) {
                user = (User) request.getAttribute(Tag.USER);
                isEditable = false;
            } else {
                user = (User) session.getAttribute(Tag.USER);
                isEditable = true;
            }%>

        <div class = "container" dir="rtl">
            <%if (isEditable) {%>
            <hr>
            <div class = "row" >
                <a href="edit_profile.jsp" class="btn  editProfileBtn btn-block" role="button">ویرایش پروفایل</a>
            </div>
            <%}%>
            <hr>
            <p style = "font-size:30px;">اطلاعات شخصی:</p>
            <hr>
            <div class = "row" >
                <%
                    if (user != null && user.getUserFirstLastName() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + user.getUserFirstLastName()
                                + "</div>"
                        );
                    } else if (isEditable) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است. میتوانید آن را ویرایش کنید"
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است"
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">نام و نام خانوادگی:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    if (user != null && user.getEmail() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + user.getEmail()
                                + "</div>"
                        );
                    } else if (isEditable) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است. میتوانید آن را ویرایش کنید"
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است"
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">آدرس ایمیل:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    if (user != null && user.getGender() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + GenderType.getGenderString(user.getGender())
                                + "</div>"
                        );
                    } else if (isEditable) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است. میتوانید آن را ویرایش کنید"
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است"
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">جنسیت:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    if (user != null && user.getCity() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + user.getCity()
                                + "</div>"
                        );
                    } else if (isEditable) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است. میتوانید آن را ویرایش کنید"
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است"
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">شهر:</div>
            </div>

            <hr>

            <div class = "row" >
                <%
                    if (user != null && user.getBirthDate() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + user.getBirthDate()
                                + "</div>"
                        );
                    } else if (isEditable) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است. میتوانید آن را ویرایش کنید"
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است"
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">تاریخ تولد:</div>
            </div>

            <hr>

            <div class = "row" >
                <% if (isEditable) {%>
                <a href="creat_new_company_page.jsp" class="btn btn-info col-md-2 col-sm-2 col-xs-2" role="button">ایجاد شرکت جدید</a>
                <div class = "col-md-7 col-sm-7 col-xs-7"></div>
                <%
                } else { %>
                <div class = "col-md-9 col-sm-9 col-xs-9"></div>
                <%}%>
                <div class = "col-md-3 col-sm-3 col-xs-3"><p style = "font-size:30px;">شرکت های ثبت شده:</p></div>
            </div>

            <div style="margin:20px auto" class= "table-body container">  
                <div class="table-responsive">
                    <table id="companyTable"class="table hover" collapsing="0" width="100%" >
                        <thead>  
                            <tr >  
                                <th style="text-align:right;">نام&nbsp;شرکت</th>  
                                <th style="text-align:right;">آدرس وبگاه</th>  
                                <th style="text-align:right;">محل شرکت</th>  
                                <th style="text-align:right;"></th>  
                            </tr>  
                        </thead>  
                        <tbody>  
                            <tr>  
                                <td>عمید رایانه شریف</td>  
                                <td>arsh.ir</td>  
                                <td>جنب مترو شریف</td>  
                                <td><a href="user_profile.jsp" class="btn btn-default" role="button">ثبت آگهی استخدام برای شرکت</a></td>
                            </tr> 

                            <tr>  
                                <td>عمید رایانه شریف</td>  
                                <td>arsh.ir</td>  
                                <td>جنب مترو شریف</td>  
                                <td><a href="user_profile.jsp" class="btn btn-default" role="button">ثبت آگهی استخدام برای شرکت</a></td>
                            </tr> 



                        </tbody>  
                    </table>  
                </div>
            </div>
            <hr>

            <div class = "row" >
                <% if (isEditable) {%>
                <a href="creat_new_project.jsp" class="btn btn-info col-md-2 col-sm-2 col-xs-2" role="button">ایجاد پروژه جدید</a>
                <div class = "col-md-7 col-sm-7 col-xs-7"></div>
                <%
                } else { %>
                <div class = "col-md-9 col-sm-9 col-xs-9"></div>
                <%}%>
                <div class = "col-md-3 col-sm-3 col-xs-3"><p style = "font-size:30px;">پروژه های ثبت شده:</p></div>
            </div>

            <div style="margin:20px auto" class= "table-body container">  
                <div class="table-responsive">
                    <table id="projctsTable"class="table hover" collapsing="0" width="100%" >
                        <thead>  
                            <tr >  
                                <th style="text-align:right;">نام&nbsp;پروژه</th>  
                                <th style="text-align:right;">کارفرما</th>  
                                <th style="text-align:right;">مهارت&nbsp;های&nbsp;مورد&nbsp;نیاز</th>  
                                <th style="text-align:right;">پایان</th>  
                            </tr>  
                        </thead>  
                        <tbody>  
                            <%
                                if (user != null && user.getProjectList()!= null && user.getProjectList().size() > 0) {
                                    for (Project proj : user.getProjectList()) {

                                        out.println("<tr>");
                                        out.println("<td>" + proj.getProjectName() + "</td>");

                                        if (proj.getUserCreator() != null && proj.getUserCreator().getUserFirstLastName() != null) {
                                            out.println("<td>" + proj.getUserCreator().getUserFirstLastName() + "</td>");
                                        } else if (proj.getUserCreator() != null && proj.getUserCreator().getUserFirstLastName() == null) {
                                            out.println("<td>" + proj.getUserCreator().getUsername() + "</td>");
                                        } else {
                                            out.println("<td>" + " " + "</td>");
                                        }
                                        out.println("<td>" + proj.getNeededSkills() + "</td>");
                                        out.println("<td>" + proj.getDeadline() + "</td>");
                                        out.println("</tr>");
                                    }

                                } else {
                                    out.println(
                                            "<tr>"
                                            + "پروژه ای ایجاد نشده است. برای ایجاد آن روی دکمه روبرو کلیک کنید."
                                            + "</tr>"
                                    );
                                }
                            %>

                        </tbody>  
                    </table>  
                </div>
            </div>



            <hr>

            <div class = "row" >
                <div class = "col-md-9 col-sm-9 col-xs-9"></div>
                <div class = "col-md-3 col-sm-3 col-xs-3"><p style = "font-size:30px;">پیشنهاد های ثبت شده:</p></div>
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
                                <th style="display:none;"></th>
                            </tr>  
                        </thead>  
                        <tbody>  

                            <%
                                if (user != null && user.getRequestedProjectsList()!= null && user.getRequestedProjectsList().size() > 0) {
                                    for (RequestedProjects requestedProject : user.getRequestedProjectsList()) {%>
                            <tr>
                                <td><%=(requestedProject.getUserId().getUserFirstLastName() != null) ? requestedProject.getUserId().getUserFirstLastName() : requestedProject.getUserId().getUsername()%></td>
                                <td><%=requestedProject.getPrice()%></td>
                                <td><%=requestedProject.getDeadline()%></td>
                                <td><%=requestedProject.getDescription()%></td>
                                <td style="display:none;"><%=requestedProject.getProjectId().getProjectId()%></td>
                            </tr>

                            <%}
                            } else {
                            %>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>پبشنهادی ایجاد نشده است.</td> 
                                <td></td>
                                <td></td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>  
                    </table>  
                </div>
            </div>


            <hr>

            <div class = "row" >
                <div class = "col-md-9 col-sm-9 col-xs-9"></div>
                <div class = "col-md-3 col-sm-3 col-xs-3"><p style = "font-size:30px;">اطلاعات رزومه:</p></div>
            </div>

            <hr>

            <div class = "row" >
                <div class = "col-md-9 col-sm-9 col-xs-9"><%=user.getResumeId().getResumeDescription()%></div>
                <div class = "col-md-3 col-sm-3 col-xs-3">توضیحات:</div>
            </div>
            <hr>

            <div class = "row" >
                <div class = "col-md-9 col-sm-9 col-xs-9"></div>
                <div class = "col-md-3 col-sm-3 col-xs-3">مهارت های شما:</div>
            </div>



            <div style="margin:20px auto" class= "table-body container">  
                <div class="table-responsive">
                    <table id="myTable"class="table hover" collapsing="0" width="100%" >
                        <thead>  
                            <tr >  
                                <th style="text-align:right;">عنوان&nbsp;مهارت</th>  
                                <th style="text-align:right;">میزان تسلط </th>   
                                <th style="text-align:right;">توضیحات</th>  
                            </tr>  
                        </thead>  
                        <tbody>  
                            <%
                                List<ResumeItem> resumeItems = user.getResumeId().getResumeItemList();

                                for (ResumeItem resumeItem : resumeItems) {
                            %>
                            <tr>
                                <td><%=resumeItem.getItemName()%></td>
                                <td style = "padding:10px;"><%=resumeItem.getItemLevel()%></td>
                                <td><%=resumeItem.getItemDescription()%></td>
                                <td><span  class="table-remove glyphicon glyphicon-minus"></span></td>
                            </tr>
                            <%}%>
                        </tbody>  
                    </table>  
                </div>
            </div>

        </div>


        <script type="text/javascript">
            $(document).ready(function () {
                var table = document.getElementById("myTable");
                var tbody = table.getElementsByTagName("tbody")[0];
                tbody.onclick = function (e) {
                    e = e || window.event;
                    var data = [];
                    var target = e.srcElement || e.target;
                    while (target && target.nodeName !== "TR") {
                        target = target.parentNode;
                    }
                    var cell4 = "";
                    if (target) {
                        var cells = target.getElementsByTagName("td");
                        for (var i = 0; i < cells.length; i++) {
                            data.push(cells[i].innerHTML);
                        }
                        cell4 = cells[4].innerHTML;
                    }
                    window.location.href = "helper.html?projectId=" + cell4;
                };
            });
        </script>
    </body>
</html>


