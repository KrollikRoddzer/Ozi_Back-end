package by.fpmibsu.ozi.servlet;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.Post;
import by.fpmibsu.ozi.entity.User;
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
import java.util.Date;

@WebServlet("/ozi/post")
public class MakePostServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(LoginPageServlet.class.getName());
    private final ProfilePageService service = new ProfilePageService(new UserDao(), new FriendDao(), new PostDao(), new FriendRequestDao());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.log(Level.INFO, "creating post");
        final Integer id = (Integer) request.getSession().getAttribute("userId");
        String postText = request.getParameter("post_in");
        try {
            service.createPost(id, postText, new Date());
        } catch (DaoException | InterruptedException e) {
            logger.log(Level.ERROR, "Unable to create post: " + e.getMessage());
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO, "Post created");
        response.sendRedirect("/ozi");
    }
}