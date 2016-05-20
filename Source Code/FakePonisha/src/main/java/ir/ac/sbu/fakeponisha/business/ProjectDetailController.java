package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.persistance.ProjectDao;
import ir.ac.sbu.fakeponisha.persistance.ProjectDaoImplementation;
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

@WebServlet(name = "ProjectDetailController", urlPatterns = {"/project_details.html"})
public class ProjectDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProjectDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProjectDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String projectIDString = Helper.getRequestString(request, Tag.PROJECT_ID);
        int projectId = Integer.parseInt(projectIDString);

        ProjectDao projectDao = new ProjectDaoImplementation();
        Project project = projectDao.getProject(projectId);
        if (project != null) {
            request.setAttribute(Tag.PROJECT, project);
        }
//        response.sendRedirect(Tag.PROJECT_DETAILS);
        request.getRequestDispatcher(Tag.PROJECT_DETAILS).forward(request, response);
        
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
