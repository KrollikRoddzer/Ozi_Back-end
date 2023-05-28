package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.User;
import by.fpmibsu.ozi.services.ProfilePageService;
import by.fpmibsu.ozi.services.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/ozi")
public class ProfilePageServlet extends HttpServlet
{
    private final ProfilePageService service = new ProfilePageService(new UserDao(), new FriendDao(), new PostDao(), new FriendRequestDao());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Integer pageId = (Integer) req.getAttribute("pageId");
        if (userId == null)
        {
            resp.sendRedirect("/ozi/login");
            return;
        }
        try {
            Status status = service.getStatus(userId, pageId);
            User user = service.getUserInfo(userId);
            Integer followersCount = service.getFollowersCount(userId);
            Integer friendsCount = service.getFriendsCount(userId);

            req.setAttribute("name", user.getName());

            req.setAttribute("surname", user.getSurname());

            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM d, yyyy");
            String inputDateStr = String.valueOf(service.getUserInfo(userId).getBirthday());
            java.util.Date inputDate = inputFormat.parse(inputDateStr);
            String outputDateStr = outputFormat.format(inputDate).toUpperCase();
            req.setAttribute("birthday", outputDateStr);

            req.setAttribute("friends", friendsCount.toString());
            req.setAttribute("followers", followersCount.toString());
            req.setAttribute("city", user.getCity());

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if (req.getParameter("exit") != null)
        {
            req.getSession().invalidate();
            resp.sendRedirect("/ozi/login");
        }
    }
}
