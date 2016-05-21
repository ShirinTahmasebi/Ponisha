package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.persistance.UserDao;
import ir.ac.sbu.fakeponisha.persistance.UserDaoImplementation;
import ir.ac.sbu.fakeponisha.utils.Helper;
import ir.ac.sbu.fakeponisha.utils.Response;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditProfileController", urlPatterns = {"/EditProfileController"})
public class EditProfileController extends HttpServlet {

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

        if (session.getAttribute(Tag.USER) == null) {
            response.sendRedirect(Tag.EDIT_PROFILE_PAGE);
            return;
        }

        User newUser = (User) session.getAttribute(Tag.USER);

        newUser.setUserFirstLastName(Helper.getRequestString(request, Tag.USER_FIRST_LAST_NAME));
        newUser.setEmail(Helper.getRequestString(request, Tag.USER_EMAIL));
        newUser.setCity(Helper.getRequestString(request, Tag.USER_CITY));
        newUser.setBirthDate(Helper.getRequestString(request, Tag.USER_BIRTH_DATE));

        UserDao userDao = new UserDaoImplementation();
        userDao.updateUser((User) session.getAttribute(Tag.USER), newUser);

        response.sendRedirect(Tag.FIRST_PAGE);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "ُThis servlet is used to edit registered users in Ponisha site.";
    }// </editor-fold>

}
