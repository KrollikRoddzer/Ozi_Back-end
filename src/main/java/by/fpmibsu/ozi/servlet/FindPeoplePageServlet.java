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

@WebServlet("/ozi/find")
public class FindPeoplePageServlet extends HttpServlet
{
    static Logger logger = LogManager.getLogger(FindPeoplePageServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        logger.log(Level.INFO, "finding person with id " + req.getParameter("search"));
        req.setAttribute("findPersonName", req.getParameter("search"));
        req.getRequestDispatcher("/search.jsp").forward(req, resp);
    }
}
