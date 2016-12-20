package mvc;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by williaz on 12/19/16.
 */
@Component
public class SessionHandler extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.getSession().setMaxInactiveInterval(3*60); //sec
        long timer = System.currentTimeMillis();
        System.out.println("Start time: " + timer);
        request.setAttribute("timer", timer);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post handler: " + System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long timer = System.currentTimeMillis() - (Long)request.getAttribute("timer");
        System.out.println("End time: " + timer + "ms");
    }
}
