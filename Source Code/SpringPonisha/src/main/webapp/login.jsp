<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login_style.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

        <script type="text/javascript" src="js/jquery-latest.min.js"></script>

        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>

    </head>

    <body>
        <%@ include file="menu.jsp" %> 

        <div id="form-main" dir = "rtl">
            <div id="form-div">

                <form class="form" id="form1"  role="form" method="post" action="LoginController">
                    <p class="name" >
                        <input name="userName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نام کاربری" id="name" />
                    </p>

                    <p class="password">
                        <input name="password" type="text" class="validate[required,custom[email]] feedback-input" id="password" placeholder="رمز عبور" />
                    </p>

                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6">
                            <div class="submit">
                                <input type="submit" value="ورود" id="button-red"/>
                            </div>
                        </div>
                    </div>

                </form>
                <br>
                <p>اگر حساب کاربری ندارید، برای ثبت نام <a href="register.jsp">اینجا</a> را کلیک کنید.</p>

            </div>
        </div>


    </body>
</html>

