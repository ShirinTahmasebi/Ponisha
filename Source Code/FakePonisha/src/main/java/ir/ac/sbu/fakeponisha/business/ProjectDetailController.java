package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.persistance.ProjectDao;
import ir.ac.sbu.fakeponisha.persistance.ProjectDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProjectDetailController", urlPatterns = {"/helper.html"})
public class ProjectDetailController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Response.initialize(response);
        if (request.getParameter(Tag.PROJECT_ID) != null) {
            String projectIDString = Helper.getRequestString(request, Tag.PROJECT_ID);
            int projectId = Integer.parseInt(projectIDString);

            ProjectDao projectDao = new ProjectDaoImplementation();
            Project project = projectDao.getProject(projectId);
            if (project != null) {
                request.setAttribute(Tag.PROJECT, project);
            }
            request.getRequestDispatcher(Tag.PROJECT_DETAILS_PAGE).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is used to show project details in Ponisha site.";
    }// </editor-fold>

}
