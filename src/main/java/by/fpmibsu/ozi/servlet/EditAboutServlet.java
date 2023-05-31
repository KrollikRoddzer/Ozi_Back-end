package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.services.ProfilePageService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ozi/editabout")
public class EditAboutServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(EditAboutServlet.class.getName());
    ProfilePageService service = new ProfilePageService(new UserDao(), new FriendDao(), new PostDao(), new FriendRequestDao());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        logger.log(Level.INFO, "Posting in address /ozi/editabout");
        try {
            service.editAbout((Integer) req.getSession().getAttribute("userId"),(String) req.getParameter("about"));
            req.setAttribute("about", service.getUserInfo((Integer)req.getSession().getAttribute("userId")).getAbout());
        } catch (DaoException | InterruptedException e) {
            logger.log(Level.ERROR, "Something went wrong in posting.");
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO, "Done posting.");
        resp.sendRedirect("/ozi");
    }
}
