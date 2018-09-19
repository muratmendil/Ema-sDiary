package com.formation.config;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.formation.model.User;
  
public class LoginFilter implements Filter {
  
         public void destroy() {
                   // TODO Auto-generated method stub
  
         }
  
         public void doFilter(ServletRequest request, ServletResponse response,
                            FilterChain chain) throws IOException, ServletException {
             User user = null;
             HttpServletRequest req = (HttpServletRequest) request;
             HttpServletResponse res = (HttpServletResponse) response;
             
             res.addHeader("Pragma", "no-cache");
             res.addHeader("Cache-Control", "no-cache");
             // Stronger according to blog comment below that references HTTP spec
             res.addHeader("Cache-Control", "no-store");
             res.addHeader("Cache-Control", "must-revalidate");
             // some date in the past
             res.addHeader("Expires", "Mon, 8 Aug 2006 10:00:00 GMT");
             
             HttpSession sess =  req.getSession(false);
             String contextPath = req.getContextPath();
             
             if (sess != null){
                   user = (User) sess.getAttribute("current_user");                   
             }
                   
             if (user == null) {
                      res.sendRedirect(contextPath+ "/index.xhtml");
             } else {
                 chain.doFilter(request, response);
             }
         }
  
         public void init(FilterConfig arg0) throws ServletException {
                   // TODO Auto-generated method stub
         }
  
}