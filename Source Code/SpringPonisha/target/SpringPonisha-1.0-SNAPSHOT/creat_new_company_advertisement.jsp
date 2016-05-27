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
                                <input name="coName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="برای مثال برنامه نویس اندروید" id="coName" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">عنوان سمت:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="website" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="برای مثال ساعتی 10 هزار تومان" id="website" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">میانگین حقوق مورد نظر:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="telephone" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="برای مثال آشنا به زبان جاوا و ..." id="telephone" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">حداقل مهارت های مورد انتظار:</div>
                    </div>


                    <hr>

                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >

                                <textarea name="text" class="validate[required,length[6,300]] feedback-input" id="comment" placeholder="توضیحاتی که به روشن شدن جزییات شغل مورد نظر کمک میکند را بنویسید"></textarea>
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">توضیحات شما:</div>
                    </div>



                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="ارسال آگهی" id="button-red"/>
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

