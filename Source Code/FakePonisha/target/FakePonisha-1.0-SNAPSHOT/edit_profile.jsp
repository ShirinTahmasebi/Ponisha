

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
  <div id="form-div">
    <form class="form" id="form1"  role="form" method="post">
      <div class = "container" dir="rtl">
		<div class = "row" >
			<div class = "col-md-9 col-sm-9 col-xs-9">
				<p class="text" >
        			<input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" value="شیرین طهماسبی" >
				</p>
      		</div>
			<div class = "col-md-3 col-sm-3 col-xs-3 lables">نام و نام خانوادگی:</div>
		</div>

		<hr>

		<div class = "row" >
			<div class = "col-md-9 col-sm-9 col-xs-9">
				<p class="text" >
        			<input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" value="tahmasebi_shirin@yahoo.com" />
				</p>
      		</div>
			<div class = "col-md-3 col-sm-3 col-xs-3 lables">آدرس ایمیل::</div>
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
        			<input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" value="تهران" />
				</p>
      		</div>
			<div class = "col-md-3 col-sm-3 col-xs-3 lables">شهر:</div>
		</div>

<hr>
		<div class = "row" >
			<div class = "col-md-9 col-sm-9 col-xs-9">
				<p class="text" >
        			<input name="deadline" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"  id="deadline" placeholder="برای مثال 12 بهمن 95" value="31 شهریور 1373" />
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
                		<th><span class="table-add glyphicon glyphicon-plus"></span></th>
        			</tr>
      				<tr>
        				<td contenteditable="true">برنامه نویسی اندروید</td>
        				<td contenteditable="true" style = "padding:10px;">
        					<select class="form-control">
    							<option value="undefined">نامشخص</option>
    							<option value="low">کم</option>
    							<option value="middle"  selected="selected">متوسط</option>
    							<option value="high">زیاد</option>
							</select>
						</td>
        				<td contenteditable="true">مدرک مجتمع فنی تایستان سال 94</td>
        				<td><span class="table-remove glyphicon glyphicon-minus"></span></td>
        			</tr>
      				<!-- This is our clonable table line -->
      				<tr class="hide">
        				<td contenteditable="true">عنوان مهارت</td>
        				<td contenteditable="true" style = "padding:10px;">
        					<select class="form-control">
    							<option value="undefined">نامشخص</option>
    							<option value="low">کم</option>
    							<option value="middle">متوسط</option>
    							<option value="high">زیاد</option>
							</select>
						</td>
        				<td contenteditable="true">-</td>
        				<td><span class="table-remove glyphicon glyphicon-minus"></span></td>
      				</tr>
    			</table>
  			</div>
		
<hr>
		<div class = "row" >
			<div class = "col-md-9 col-sm-9 col-xs-9">
				<p class="text" >
        			
        			<textarea name="text" class="validate[required,length[6,300]] feedback-input" id="comment" placeholder="توضیحات لازم در مورد رزومه خود را میتوانید اینجا وارد کنید. مثلا نام دانشگاه و ..."></textarea>
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
			<div class = "col-md-4 col-sm-4 col-xs-4"/>
			
		</div>
		
	</div>
      
      
      
      
    </form>
  </div>
    
    
		<script src='js/bootstrap.min.js'></script>

        <script src="js/projects_list_admin_functions.js"></script>
    
  </body>
</html>
 
