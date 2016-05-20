package ir.ac.sbu.fakeponisha.business;

import ir.ac.sbu.fakeponisha.model.ResumeItem;
import ir.ac.sbu.fakeponisha.model.User;
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

@WebServlet(name = "CreateResumeItemController", urlPatterns = {"/CreateResumeItemController"})
public class CreateResumeItemController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (session.getAttribute(Tag.USER) == null) {
            response.sendRedirect(Tag.ADD_RESUME_ITEM_PAGE);
            return;
        }

        ResumeItem resumeItem = new ResumeItem();
        resumeItem.setItemName(Helper.getRequestString(request, Tag.RESUME_ITEM_NAME));
        resumeItem.setItemLevel(Helper.getRequestString(request, Tag.RESUME_ITEM_LEVEL));
        resumeItem.setItemDescription(Helper.getRequestString(request, Tag.RESUME_ITEM_DESCIRPTION));
        resumeItem.setResumeId(((User) session.getAttribute(Tag.USER)).getResumeId());

        String forwardPage = checkInsertResumeItem(resumeItem);
        response.sendRedirect(forwardPage);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet is used to create resume items by user in Ponisha site.";
    }// </editor-fold>

    private String checkInsertResumeItem(ResumeItem resumeItem) {
        if (resumeItem == null
                || resumeItem.getResumeId() == null
                || resumeItem.getItemName() == null
                || resumeItem.getItemLevel() == null
                || resumeItem.getItemDescription() == null) {
            return Tag.ADD_RESUME_ITEM_PAGE;
        }
//        ProjectDao projectDao = new ProjectDaoImplementation();
//        projectDao.insertProject(project);
//        //َ Update user attribute in session
//        session.setAttribute(Tag.USER, user);
        return Tag.FIRST_PAGE;
    }
}
