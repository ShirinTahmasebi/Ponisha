package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.Project;
import ir.ac.sbu.springponisha.dao.model.User;
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
import javax.servlet.http.HttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(name = "CreateProjectController", urlPatterns = {"/CreateProjectController"})
public class CreateProjectController extends HttpServlet {

    private UserManager userService;
    private ProjectManager projectService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean(UserManager.class);
        projectService = context.getBean(ProjectManager.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();

        Project project = new Project();
        project.setProjectName(Helper.getRequestString(request, Tag.PROJECT_NAME));
        project.setBudget(Helper.getRequestString(request, Tag.PROJECT_BUDGET));
        project.setDeadline(Helper.getRequestString(request, Tag.PROJECT_DEADLINE));
        project.setNeededSkills(Helper.getRequestString(request, Tag.PROJECT_NEEDED_SKILLS));
        project.setProjectDescription(Helper.getRequestString(request, Tag.PROJECT_DESCRIPTION));
        User user;
        if (session.getAttribute(Tag.USER) != null) {
            user = userService.getUser(((User) session.getAttribute(Tag.USER)).getUsername());
        } else {
            user = null;
        }
        project.setUserCreator(user);
        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkInsertProject(project, user, session);
        response.sendRedirect(forwardPage);
    }

    @Override
    public String getServletInfo() {
        return "This servlet is used to create projects in Ponisha site.";
    }

    private String checkInsertProject(Project project, User user, HttpSession session) {
        if (project == null
                || project.getBudget() == null
                || project.getProjectName() == null
                || project.getDeadline() == null
                || project.getNeededSkills() == null
                || project.getUserCreator() == null
                || session.getAttribute(Tag.USER) == null) {
            return Tag.CREATE_NEW_PROJECT_PAGE;
        }
        projectService.insertProject(project);
        //َ Update user attribute in session
        session.setAttribute(Tag.USER, user);
        return Tag.FIRST_PAGE;
    }

}
