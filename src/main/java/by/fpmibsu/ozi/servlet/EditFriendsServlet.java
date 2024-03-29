package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.services.ProfilePageService;
import by.fpmibsu.ozi.services.Status;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ozi/editFriends")
public class EditFriendsServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(EditFriendsServlet.class.getName());
    private final ProfilePageService service = new ProfilePageService(new UserDao(), new FriendDao(), new PostDao(), new FriendRequestDao());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        logger.log(Level.INFO, "Posting by addres /ozi/editFrineds");
        try {
            String st = req.getParameter("status");
            if (st == null)
            {
                logger.log(Level.ERROR, "status is null redirecting /ozi");
                resp.sendRedirect("/ozi");
                return;
            }
            Integer pageId;
            try {
                String str = req.getParameter("pageId");
                if (str == null)
                {
                    pageId = null;
                }
                else pageId = Integer.parseInt(str);
            }
            catch (NumberFormatException e)
            {
                pageId = null;
            }
            Integer userId = (Integer)req.getSession().getAttribute("userId");
            logger.log(Level.INFO, "Dealing with person.");
            if (st.equals(Status.REQUEST_SEND.toString()))
            {
                service.acceptRequest(userId, pageId);
            }
            else
            if (st.equals(Status.FRIEND.toString()))
            {
                service.deleteFriend(userId, pageId);
            }
            else if (st.equals(Status.FOLLOWER.toString()))
            {
                service.unsendRequest(userId, pageId);
            }
            else
            {
                service.sendRequest(userId, pageId);
            }
            logger.log(Level.INFO, "Done posting");
            resp.sendRedirect("/ozi?pageId=" + pageId.toString());
            return;
        } catch (DaoException | InterruptedException e) {
            logger.log(Level.ERROR, "Something went wrong, redirecting /ozi");
            resp.sendRedirect("/ozi");
        }

    }
}
