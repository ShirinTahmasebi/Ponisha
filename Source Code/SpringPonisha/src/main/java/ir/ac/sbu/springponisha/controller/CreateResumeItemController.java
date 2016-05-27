package ir.ac.sbu.springponisha.controller;

import ir.ac.sbu.springponisha.dao.model.ResumeItem;
import ir.ac.sbu.springponisha.dao.model.User;
import ir.ac.sbu.springponisha.service.ResumeItemManager;
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

@WebServlet(name = "CreateResumeItemController", urlPatterns = {"/CreateResumeItemController"})
public class CreateResumeItemController extends HttpServlet {

    private UserManager userService;
    private ResumeItemManager resumeItemService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean(UserManager.class);
        resumeItemService = context.getBean(ResumeItemManager.class);
    }

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

        //Update User in session
        User user = userService.getUserByResumeId(((User) session.getAttribute(Tag.USER)).getResumeId().getResumeId());
        session.setAttribute(Tag.USER, user);

        response.sendRedirect(forwardPage);

    }

    @Override
    public String getServletInfo() {
        return "This servlet is used to create resume items by user in Ponisha site.";
    }

    private String checkInsertResumeItem(ResumeItem resumeItem) {
        if (resumeItem == null
                || resumeItem.getResumeId() == null
                || resumeItem.getItemName() == null
                || resumeItem.getItemLevel() == null
                || resumeItem.getItemDescription() == null) {
            return Tag.ADD_RESUME_ITEM_PAGE;
        }

        resumeItemService.insertResumeItem(resumeItem);

        return Tag.USER_EDITABLE_PROFILE_PAGE;
    }
}
