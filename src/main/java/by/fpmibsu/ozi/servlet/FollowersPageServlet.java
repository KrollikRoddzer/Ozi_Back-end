package by.fpmibsu.ozi.servlet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ozi/followers")
public class FollowersPageServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(FollowersPageServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO, "Getting person followers");
        req.getRequestDispatcher("/followers.jsp").forward(req, resp);
    }
}
