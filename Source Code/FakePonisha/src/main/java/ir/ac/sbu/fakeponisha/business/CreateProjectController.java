package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.ProjectDao;
import ir.ac.sbu.fakeponisha.persistance.ProjectDaoImplementation;
import ir.ac.sbu.fakeponisha.persistance.UserDao;
import ir.ac.sbu.fakeponisha.persistance.UserDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.GenderType;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shirin
 */
@WebServlet(name = "CreateProjectController", urlPatterns = {"/CreateProjectController"})
public class CreateProjectController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        UserDao userDao = new UserDaoImplementation();
        User user;
        if (session.getAttribute(Tag.USER) != null) {
            user = userDao.getUser(((User) session.getAttribute(Tag.USER)).getUsername());
        } else {
            user = null;
        }
        project.setUserCreator(user);
        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkInsertProject(project, user, session);
        response.sendRedirect(forwardPage);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is used to create projects in Ponisha site.";
    }// </editor-fold>

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
        ProjectDao projectDao = new ProjectDaoImplementation();
        projectDao.insertProject(project);
        //َ Update user attribute in session
        session.setAttribute(Tag.USER, user);
        return Tag.FIRST_PAGE;
    }

}
