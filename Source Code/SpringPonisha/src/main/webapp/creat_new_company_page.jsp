<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/create_new_company_page_style.css">

        <script src="js/jquery-latest.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <div id="form-div">
            <form class="form" id="form1"  role="form" method="post">
                <div class = "container" dir="rtl">


                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="coName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نام شرکت" id="coName" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">نام شرکت:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="website" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="www.example.com" id="website" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">آدرس وبگاه شرکت:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="telephone" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="برای مثال 02144444444" id="telephone" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">شماره تماس:</div>
                    </div>

                    <hr>


                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="برای مثال تهران - خیابان آزادی - ..." id="deadline" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">آدرس شرکت:</div>
                    </div>


                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="ساخت شرکت" id="button-red"/>
                                <div class="ease"></div>
                            </div>
                        </div>
                        <div class = "col-md-4 col-sm-4 col-xs-4"/>

                    </div>

                </div>




            </form>
        </div>



    </body>
</html>

