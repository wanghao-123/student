package com.cssl.interceptor;
import com.cssl.pojo.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class Myinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*StringBuffer requestURL = request.getRequestURL();
        List<Users> userMsg =(List<Users>) request.getServletContext().getAttribute("userMsg");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(requestURL);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);*/
        return true;
    }
}
