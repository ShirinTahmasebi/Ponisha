package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.User;
import ir.ac.sbu.springponisha.utils.Helper;
import ir.ac.sbu.springponisha.utils.Response;
import ir.ac.sbu.springponisha.utils.Tag;
import ir.ac.sbu.springponisha.service.UserManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(name = "EditProfileController", urlPatterns = {"/EditProfileController"})
public class EditProfileController extends HttpServlet {

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

        if (session.getAttribute(Tag.USER) == null) {
            response.sendRedirect(Tag.EDIT_PROFILE_PAGE);
            return;
        }

        User newUser = (User) session.getAttribute(Tag.USER);

        newUser.setUserFirstLastName(Helper.getRequestString(request, Tag.USER_FIRST_LAST_NAME));
        newUser.setEmail(Helper.getRequestString(request, Tag.USER_EMAIL));
        newUser.setCity(Helper.getRequestString(request, Tag.USER_CITY));
        newUser.setBirthDate(Helper.getRequestString(request, Tag.USER_BIRTH_DATE));
        newUser.getResumeId().setResumeDescription(Helper.getRequestString(request, Tag.RESUME_DESCRIPTION));
        userService.updateUser((User) session.getAttribute(Tag.USER), newUser);

        session.setAttribute(Tag.USER, newUser);

        response.sendRedirect(Tag.FIRST_PAGE);

    }

   
    @Override
    public String getServletInfo() {
        return "ُThis servlet is used to edit registered users in Ponisha site.";
    }

}
