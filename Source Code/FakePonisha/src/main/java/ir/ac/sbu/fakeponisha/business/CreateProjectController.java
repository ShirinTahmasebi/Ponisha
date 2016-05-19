/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.ProjectDao;
import ir.ac.sbu.fakeponisha.persistance.ProjectDaoImplementation;
import ir.ac.sbu.fakeponisha.persistance.UserDao;
import ir.ac.sbu.fakeponisha.persistance.UserDaoImplementation;
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

/**
 *
 * @author Shirin
 */
@WebServlet(name = "CreateProjectController", urlPatterns = {"/CreateProjectController"})
public class CreateProjectController extends HttpServlet {
    
    
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
            out.println("<title>Servlet CreateProjectController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateProjectController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        User user = new User();
        user.setUsername(Tag.USER_NAME);
        user.setPassword(Tag.USER_PASSWORD);
        user.setEmail(Tag.USER_EMAIL);
        UserDao userDao = new UserDaoImplementation();
        userDao.insertUser(user);
        project.setUserCreator(user);
        
        ProjectDao projectDao = new ProjectDaoImplementation();
        projectDao.insertProject(project);
        
        
        processRequest(request, response);

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

}
