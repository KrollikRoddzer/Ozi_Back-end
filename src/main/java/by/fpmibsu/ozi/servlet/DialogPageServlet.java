package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.FriendDao;
import by.fpmibsu.ozi.dao.MessageDao;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.services.DialogPageService;
import by.fpmibsu.ozi.services.ProfilePageService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/ozi/messages")
public class DialogPageServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(DialogPageServlet.class.getName());
    DialogPageService service = new DialogPageService(new UserDao(), new MessageDao(), new FriendDao());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "Getting info from address /ozi/messages");
        req.getRequestDispatcher("/messages.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "Posting info from address /ozi/messages");
        HttpSession session = (HttpSession)req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Integer messagePersonId = Integer.parseInt(session.getAttribute("activeButton").toString());
        String text = req.getParameter("message_in");
        try {
            service.sendMessage(userId, messagePersonId, text, new Date(new java.util.Date().getTime()));
        } catch (DaoException | InterruptedException e) {
            logger.log(Level.ERROR, "Something went wrong in posting.");
            resp.sendRedirect("/ozi");
            return;
        }
        logger.log(Level.INFO   , "Done posting.");
        resp.sendRedirect("/ozi/messages?active=" + messagePersonId.toString());
    }
}
