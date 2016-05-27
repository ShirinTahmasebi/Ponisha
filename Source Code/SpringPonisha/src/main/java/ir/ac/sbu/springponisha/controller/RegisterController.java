package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.User;
import ir.ac.sbu.springponisha.service.UserManager;
import ir.ac.sbu.springponisha.utils.GenderType;
import ir.ac.sbu.springponisha.utils.Helper;
import ir.ac.sbu.springponisha.utils.Regex;
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

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private UserManager service;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        service = context.getBean(UserManager.class);
    }

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
        User u = service.getUser(user.getUsername());
        if (u == null) {
            // TODO: Add resumeId for users here
            service.insertUser(user);
            return true;
        }
        return false;
    }

    private String checkInsertUser(User user, HttpServletRequest request, HttpSession session) {
        boolean isUserValid = checkValidUserInfoFormat(user);
        boolean isUserUnique = (isUserValid) ? checkUniqueUserInfo(user) : false;

        if (isUserValid && isUserUnique) {
            User foundUser = service.getUser(user.getUsername());
            request.setAttribute(Tag.USER, foundUser);
            session.setAttribute(Tag.USER, foundUser);
            return Tag.FIRST_PAGE;
        }
        return Tag.REGISTER_PAGE;
    }

}
