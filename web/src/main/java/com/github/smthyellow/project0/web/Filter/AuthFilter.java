package com.github.smthyellow.project0.web.Filter;

import com.github.smthyellow.project0.web.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter ("/personalpage")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtils.forward("login", req, ((HttpServletResponse) servletResponse));
            return;
        }
        filterChain.doFilter(req, servletResponse);
    }
}
