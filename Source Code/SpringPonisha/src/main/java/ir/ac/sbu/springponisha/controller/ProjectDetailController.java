package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.Project;
import ir.ac.sbu.springponisha.service.ProjectManager;
import ir.ac.sbu.springponisha.service.UserManager;
import ir.ac.sbu.springponisha.utils.Helper;
import ir.ac.sbu.springponisha.utils.Response;
import ir.ac.sbu.springponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(name = "ProjectDetailController", urlPatterns = {"/helper.html"})
public class ProjectDetailController extends HttpServlet {

    private ProjectManager projectService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        projectService = context.getBean(ProjectManager.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Response.initialize(response);
        if (request.getParameter(Tag.PROJECT_ID) != null) {
            String projectIDString = Helper.getRequestString(request, Tag.PROJECT_ID);
            int projectId = Integer.parseInt(projectIDString);

            Project project = projectService.getProject(projectId);
            if (project != null) {
                request.setAttribute(Tag.PROJECT, project);
            }
            request.getRequestDispatcher(Tag.PROJECT_DETAILS_PAGE).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "This servlet is used to show project details in Ponisha site.";
    }

}
