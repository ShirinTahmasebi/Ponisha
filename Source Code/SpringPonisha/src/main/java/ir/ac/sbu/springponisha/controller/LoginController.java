package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.User;
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

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private UserManager userService;
    
    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean(UserManager.class);
    }

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

    @Override
    public String getServletInfo() {
        return "This servlet is used to authenticate users in Ponisha site login process.";
    }

    private String checkUserAuthentication(User user, HttpServletRequest request, HttpSession session) {
        User userFound = userService.getUser(user.getUsername(), user.getPassword());
        if (userFound != null) {
            request.setAttribute(Tag.USER, userFound);
            session.setAttribute(Tag.USER, userFound);
            return Tag.FIRST_PAGE;
        }
        return Tag.LOGIN_PAGE;
    }

}
