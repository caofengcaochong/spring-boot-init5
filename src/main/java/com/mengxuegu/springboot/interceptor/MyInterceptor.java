package com.mengxuegu.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUsername = request.getSession().getAttribute("loginUser");
        if(loginUsername!=null){
            return true;
        }
        request.setAttribute("msg","没有权限，请先登录!");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
