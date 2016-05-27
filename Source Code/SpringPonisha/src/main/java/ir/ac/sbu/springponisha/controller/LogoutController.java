package ir.ac.sbu.springponisha.controller;


import ir.ac.sbu.springponisha.utils.Tag;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        RequestDispatcher rd = request.getRequestDispatcher(Tag.FIRST_PAGE);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This servlet is used to make user's session invalid in Ponisha site logout process.";
    }

}
