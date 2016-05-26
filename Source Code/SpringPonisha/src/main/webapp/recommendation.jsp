<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/recommendation_style.css">  
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
                <form class="form" id="form1" method="post" action="RequestProjectController">

                    <p class="text" >
                        <input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="مدت زمان تخمینی شما" id="deadline" />
                    </p>

                    <p class="text">
                        <input name="price" type="text" class="feedback-input" id="price" placeholder="مبلغ پیشنهادی به ریال" />
                    </p>

                    <%                        out.println("<p  style='display: none;'class='text'><input name='projectId' type='text' class='feedback-input' value='"
                                + request.getParameter(Tag.PROJECT_ID)
                                + "'/></p>");%>

                    <p class="text">
                        <textarea name="description" class="validate[required,length[6,300]] feedback-input" id="comment" placeholder="توضیحات شما"></textarea>
                    </p>


                    <div class="submit">
                        <input type="submit" value="ارسال پیشنهاد" id="button-red"/>
                        <div class="ease"></div>
                    </div>
                </form>
            </div>
    </body>
</html>

