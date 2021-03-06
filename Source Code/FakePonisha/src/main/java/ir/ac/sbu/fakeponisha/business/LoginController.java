package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.User;
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

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. doPost is used here">
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

        String userName = Helper.getRequestString(request, Tag.USER_NAME);
        String password = Helper.getRequestString(request, Tag.USER_PASSWORD);
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkUserAuthentication(user, request, session);

        response.sendRedirect(forwardPage);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is used to authenticate users in Ponisha site login process.";
    }// </editor-fold>

    private String checkUserAuthentication(User user, HttpServletRequest request, HttpSession session) {
        UserDao userDao = new UserDaoImplementation();
        User userFound = userDao.getUser(user.getUsername(), user.getPassword());
        if (userFound != null) {
            request.setAttribute(Tag.USER, userFound);
            session.setAttribute(Tag.USER, userFound);
            return Tag.FIRST_PAGE;
        }
        return Tag.LOGIN_PAGE;
    }

}
