package by.fpmibsu.ozi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req,resp);
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("Hello, Anonymous" + "<br>");
//        printWriter.write("Page was visited " + 0 + " times.");
//        printWriter.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/jsp/enter.jsp").forward(req,resp);
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Hello, Anonymous" + "<br>");
        printWriter.write("Page was visited " + 0 + " times.");
        printWriter.close();
    }
}
