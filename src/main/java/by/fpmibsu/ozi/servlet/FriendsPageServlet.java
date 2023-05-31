package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.FriendDao;
import by.fpmibsu.ozi.entity.User;
import by.fpmibsu.ozi.services.FriendsPageService;
import by.fpmibsu.ozi.services.Status;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/ozi/friends")
public class FriendsPageServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(FriendsPageServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "Getting person friends");
        req.getRequestDispatcher("/friends.jsp").forward(req, resp);
    }
}
