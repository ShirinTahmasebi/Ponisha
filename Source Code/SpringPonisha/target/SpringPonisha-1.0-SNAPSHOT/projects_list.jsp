<%@page import="ir.ac.sbu.springponisha.service.ProjectManager"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="ir.ac.sbu.springponisha.dao.ProjectDao"%>
<%@page import="ir.ac.sbu.springponisha.dao.impl.ProjectDaoImplementation"%>
<%@page import="java.util.List"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.Project"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.Project"%>
<html dir="rtl" lang="fa">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
        <link rel="stylesheet" type="text/css" href="css/table_style.css">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body  class= "table-body">
        <%@ include file="menu.jsp" %> 
        <div style="height:50px;"></div>
        <div style="margin:20px auto" class="container" >
            <div class="table-responsive">
                <table id="projctsTable"class="table hover" collapsing="0" width="100%" >
                    <thead>
                        <tr>
                            <th style="text-align:right; padding-right:25px;">نام&nbspپروژه</th>
                            <th style="text-align:right; padding-right:25px">کارفرما</th>
                            <th style="text-align:right; padding-right:25px">مهارت&nbspهای&nbspمورد&nbspنیاز</th>
                            <th style="text-align:right; padding-right:25px">پایان</th>
                            <th style="display:none;"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
                            ProjectManager projectService = context.getBean(ProjectManager.class);
                            List<Project> projects = projectService.getAllProjects();

                            for (Project project : projects) {
                        %>
                        <tr>
                            <td><%=project.getProjectName()%></td>
                            <td><%=project.getUserCreator().getUsername()%></td>
                            <td><%=project.getNeededSkills()%></td>
                            <td><%=project.getDeadline()%></td>
                            <td style="display:none;"><%=project.getProjectId()%></td>
                        </tr>

                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                var table = document.getElementById("projctsTable");
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