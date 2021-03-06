package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.Resume;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.ResumeDao;
import ir.ac.sbu.fakeponisha.persistance.ResumeDaoImplementation;
import ir.ac.sbu.fakeponisha.persistance.UserDao;
import ir.ac.sbu.fakeponisha.persistance.UserDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.GenderType;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Regex;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
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
        String password = Helper.getRequestString(request, Tag.USER_PASSWORD);
        String email = Helper.getRequestString(request, Tag.USER_EMAIL);

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(GenderType.getGenderCode(GenderType.Gender.NOTDEFINED));

        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkInsertUser(user, request, session);

        response.sendRedirect(forwardPage);
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
            Resume resume = new Resume();
            resume.setResumeDescription("User Resume");
            ResumeDao resumeDao = new ResumeDaoImplementation();
            resumeDao.insertResume(resume);
            user.setResumeId(resume);
            userDao.insertUser(user);
            return true;
        }
        return false;
    }

    private String checkInsertUser(User user, HttpServletRequest request, HttpSession session) {
        boolean isUserValid = checkValidUserInfoFormat(user);
        boolean isUserUnique = (isUserValid) ? checkUniqueUserInfo(user) : false;

        if (isUserValid && isUserUnique) {
            UserDao userDao = new UserDaoImplementation();
            User foundUser = userDao.getUser(user.getUsername());
            request.setAttribute(Tag.USER, foundUser);
            session.setAttribute(Tag.USER, foundUser);
            return Tag.FIRST_PAGE;
        }
        return Tag.REGISTER_PAGE;
    }

}
