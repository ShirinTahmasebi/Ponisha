<%@page import="ir.ac.sbu.springponisha.dao.model.ResumeItem"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html >
    <head>
        <link rel="stylesheet" type="text/css" href="css/edit_profile_style.css">
        <link rel="stylesheet" type="text/css" href="css/projects_list_admin_style.css">

        <link rel='stylesheet prefetch' href='css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/projects_list_admin_style.css">

        <script type="text/javascript" src="js/jquery-latest.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>

    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <% User user = (User) session.getAttribute(Tag.USER);%>
        <div id="form-div">
            <form class="form" id="form1"  role="form" method="post" action="EditProfileController">
                <div class = "container" dir="rtl">
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="userFirstLastName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" 
                                       value="<%=(user.getUserFirstLastName() == null) ? " " : user.getUserFirstLastName()%>" >
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">نام و نام خانوادگی:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="email" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" 
                                       value="<%=(user.getEmail() == null) ? " " : user.getEmail()%>" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">آدرس ایمیل:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6"></div>
                        <div class = "col-md-3 col-sm-3 col-xs-3">
                            <select class="form-control">
                                <option value="undefined">نامشخص</option>
                                <option value="female">زن</option>
                                <option value="male">مرد</option>
                            </select>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">جنسیت:</div>
                    </div>

                    <hr>


                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="city" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" 
                                       value="<%= (user.getCity() == null) ? "" : user.getCity()%>" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">شهر:</div>
                    </div>

                    <hr>
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="birthDate" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" placeholder="برای مثال 12 بهمن 95" 
                                       value="<%=(user.getBirthDate() == null) ? "" : user.getBirthDate()%>" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">تاریخ تولد:</div>
                    </div>

                    <hr>



                    <div id="table" class="table-editable">

                        <table class="table" dir="rtl">
                            <tr>
                                <th>عنوان مهارت</th>
                                <th>میزان تسلط</th>
                                <th>توضیحات</th>
                                <th><span id="additem" onclick="openResumeEditor()" class="table-add glyphicon glyphicon-plus"></span></th>
                            </tr>
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
                        </table>
                    </div>

                    <hr>
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >

                                <textarea name="resumeDescription" class="validate[required,length[6,300]] feedback-input" id="comment" placeholder="توضیحات لازم در مورد رزومه خود را میتوانید اینجا وارد کنید. مثلا نام دانشگاه و ...">
                                    <%=user.getResumeId().getResumeDescription()%>
                                </textarea>
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">توضیحات شما:</div>
                    </div>

                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="اعمال تغییرات" id="button-red"/>
                                <div class="ease"></div>
                            </div>
                        </div>
                        <div class = "col-md-4 col-sm-4 col-xs-4"></div>
                    </div>
                </div>
            </form>
        </div>
        <script src='js/bootstrap.min.js'></script>
        <script>
                                    function openResumeEditor() {
                                        window.location.replace("add_resume_item.jsp");
                                    }
        </script>
    </body>
</html>

