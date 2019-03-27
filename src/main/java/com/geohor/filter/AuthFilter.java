package com.geohor.filter;

import com.geohor.entity.User;
import com.geohor.myenum.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        User user = (User) session.getAttribute("user");

        if(user == null && !uri.equals("/resources/")
                        && !uri.equals("/user/login")) {
            response.sendRedirect(request.getContextPath()+"/user/login");
            return;
        } else if(user != null && user.getType()== UserType.SUBCONTRACTOR && (
                uri.matches(".+\\/geo\\/.+") || uri.matches(".+\\/gw\\/.+"))){
            response.sendRedirect(request.getContextPath()+"/");
            return;
        } else if(user != null && user.getType()== UserType.GENERAL_CONTRACTOR && (
                uri.matches(".+\\/geo\\/.+") || uri.matches(".+\\/sub\\/.+"))){
            response.sendRedirect(request.getContextPath()+"/");
            return;
        }else if(user != null && user.getType()== UserType.GEODESY && (
                uri.matches(".+\\/gw\\/.+") || uri.matches(".+\\/sub\\/.+"))) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
