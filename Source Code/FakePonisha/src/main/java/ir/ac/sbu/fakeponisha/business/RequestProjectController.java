package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.RequestedProjects;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.ProjectDao;
import ir.ac.sbu.fakeponisha.persistance.ProjectDaoImplementation;
import ir.ac.sbu.fakeponisha.persistance.RequestedProjectsDao;
import ir.ac.sbu.fakeponisha.persistance.RequestedProjectsDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RequestProjectController", urlPatterns = {"/RequestProjectController"})
public class RequestProjectController extends HttpServlet {

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
        String deadline = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_DEADLINE);
        String price = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_PRICE);
        String description = Helper.getRequestString(request, Tag.REQUESTED_PROJECTS_DESCRIPTION);

        ProjectDao projectDao = new ProjectDaoImplementation();
        Project project = projectDao.getProject(Integer.parseInt(request.getParameter(Tag.PROJECT_ID)));

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

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
        RequestedProjectsDao requestedProjectsDao = new RequestedProjectsDaoImplementation();
        requestedProjectsDao.insertRequest(requestedProjects);
        //َ Update user attribute in session
        session.setAttribute(Tag.USER, requestedProjects.getUserId());
        return Tag.FIRST_PAGE;
    }

}
