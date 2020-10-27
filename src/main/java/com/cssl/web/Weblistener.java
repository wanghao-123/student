package com.cssl.web;

import com.cssl.pojo.Users;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class Weblistener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(120);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Users userMsg = (Users)se.getSession().getServletContext().getAttribute("userMsg");
        if(userMsg!=null){
            se.getSession().getServletContext().removeAttribute("userMsg");
        }
    }
}
