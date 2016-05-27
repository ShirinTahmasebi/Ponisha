<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet prefetch' href='css/bootstrap.min.css'>

        <link rel="stylesheet" href="css/projects_list_admin_style.css">

        <script type="text/javascript" src="js/jquery-latest.min.js"></script>
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>    
    </head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

    <body>
        <%@ include file="menu.jsp" %> 

        <div class="container">


            <div id="table" class="table-editable">

                <table class="table" dir="rtl">
                    <tr>
                        <th>نام پروژه</th>
                        <th>مهارت ها</th>
                        <th>ددلاین</th>
                        <th>بودجه پروژه</th>
                        <th><span class="table-add glyphicon glyphicon-plus"></span></th>

                    </tr>
                    <tr>
                        <td contenteditable="true">پروژه شبکه اجتماعی</td>
                        <td contenteditable="true">برنامه نویسی اندروید و پایتون</td>
                        <td contenteditable="true">پایان سال 95</td>
                        <td contenteditable="true">5000000 ریال</td>
                        <td>
                            <span class="table-remove glyphicon glyphicon-remove"></span>
                        </td>

                    </tr>
                    <!-- This is our clonable table line -->
                    <tr class="hide">
                        <td contenteditable="true">نام پروژه</td>
                        <td contenteditable="true">مهارت ها</td>
                        <td contenteditable="true">ددلاین</td>
                        <td contenteditable="true">بودجه</td>
                        <td>
                            <span class="table-remove glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
            </div>

        </div>


        <script src='js/bootstrap.min.js'></script>

        <script src="js/projects_list_admin_functions.js"></script>


    </body>
</html>


