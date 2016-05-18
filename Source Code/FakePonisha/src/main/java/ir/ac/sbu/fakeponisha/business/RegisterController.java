package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.UserDao;
import ir.ac.sbu.fakeponisha.persistance.UserDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Regex;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

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
        String password = Helper.getRequestString(request, Tag.PASSWORD);
        String email = Helper.getRequestString(request, Tag.EMAIL);

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);

        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkInsertUser(user);

        if (!forwardPage.equals(Tag.REGISTER_PAGE)) {
            request.setAttribute(Tag.USER, user);
            session.setAttribute(Tag.USER, user);
        }

        response.sendRedirect(forwardPage);
//        RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
//        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is used to register users in Ponisha site.";
    }

    private String checkInsertUser(User user) {
        boolean isUserValid = checkValidUserInfoFormat(user);
        boolean isUserUnique = (isUserValid) ? checkUniqueUserInfo(user) : false;

        if (isUserValid && isUserUnique) {
            return Tag.FIRST_PAGE;
        }
        return Tag.REGISTER_PAGE;

    }

    private boolean checkValidUserInfoFormat(User user) {
        boolean isUsernameValid = Helper.validator(user.getUsername(), Regex.USERNAME_PATTERN);
        boolean isPasswordValid = Helper.validator(user.getPassword(), Regex.PASSWORD_PATTERN);
        boolean isEmailValid = Helper.validator(user.getEmail(), Regex.EMAIL_PATTERN);
        return isUsernameValid && isPasswordValid && isEmailValid;
    }

    private boolean checkUniqueUserInfo(User user) {
        UserDao userDao = new UserDaoImplementation();
        User u = userDao.getUser(user.getUsername());
        if (u == null) {
            userDao.insertUser(user);
            return true;
        }
        return false;
    }

}
