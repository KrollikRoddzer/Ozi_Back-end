package by.fpmibsu.ozi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

//@WebFilter({"/ozi", "/ozi/profile", "/ozi/friends", "/register"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final Long id = (Long) req.getSession().getAttribute("userUd");
        final HttpSession session = req.getSession();

        if (nonNull(session) && nonNull(id)) {
            filterChain.doFilter(request, response);
        } else {
            res.sendRedirect("/null");
        }
    }
    @Override
    public void destroy() {
    }
}