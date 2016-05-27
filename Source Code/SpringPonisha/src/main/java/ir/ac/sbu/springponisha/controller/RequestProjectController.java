package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.Project;
import ir.ac.sbu.springponisha.dao.model.RequestedProjects;
import ir.ac.sbu.springponisha.dao.model.User;
import ir.ac.sbu.springponisha.service.ProjectManager;
import ir.ac.sbu.springponisha.service.RequestedProjectsManager;
import ir.ac.sbu.springponisha.utils.Helper;
import ir.ac.sbu.springponisha.utils.Response;
import ir.ac.sbu.springponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(name = "RequestProjectController", urlPatterns = {"/RequestProjectController"})
public class RequestProjectController extends HttpServlet {

    private RequestedProjectsManager requestedProjectsService;
    private ProjectManager projectService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        requestedProjectsService = context.getBean(RequestedProjectsManager.class);
        projectService = context.getBean(ProjectManager.class);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();
        String deadline = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_DEADLINE);
        String price = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_PRICE);
        String description = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_DESCRIPTION);

        Project project = projectService.getProject(Integer.parseInt(request.getParameter(Tag.PROJECT_ID)));

        RequestedProjects requestedProjects = new RequestedProjects();
        requestedProjects.setDeadline(deadline);
        requestedProjects.setPrice(price);
        requestedProjects.setDescription(description);
        requestedProjects.setProjectId(project);
        requestedProjects.setUserId(((User) session.getAttribute(Tag.USER)));

        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkInsertRequest(requestedProjects, request, session);
        response.sendRedirect(forwardPage);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String checkInsertRequest(RequestedProjects requestedProjects, HttpServletRequest request, HttpSession session) {
        if (requestedProjects == null
                || requestedProjects.getDeadline() == null
                || requestedProjects.getDescription() == null
                || requestedProjects.getPrice() == null
                || requestedProjects.getProjectId() == null
                || requestedProjects.getUserId() == null
                || session.getAttribute(Tag.USER) == null) {
            return Tag.CREATE_RECOMMENDATION_PAGE + "?projectId=" + request.getParameter(Tag.PROJECT_ID);
        }
        requestedProjectsService.insertRequest(requestedProjects);
        //َ Update user attribute in session
        session.setAttribute(Tag.USER, requestedProjects.getUserId());
        return Tag.FIRST_PAGE;
    }

}
