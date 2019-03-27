//package com.geohor.filter;
//
//import com.geohor.entity.User;
//import com.geohor.myenum.UserType;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "UserTypeFilter", urlPatterns = {"/*"})
//public class UserTypeFilter implements Filter {
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpSession session = request.getSession();
//        HttpServletResponse response = (HttpServletResponse) resp;
//        User user = (User) session.getAttribute("user");
//        String uri = request.getRequestURI();
//
//        if(user.getType()== UserType.SUBCONTRACTOR &&
//                (uri.matches("\\/user\\/geo\\/.+"))) {
//            response.sendRedirect(request.getContextPath()+"/");
//            return;
//
//        }
//
//        chain.doFilter(req, resp);
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
