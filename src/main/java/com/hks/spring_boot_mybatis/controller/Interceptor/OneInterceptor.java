package com.hks.spring_boot_mybatis.controller.Interceptor;

import com.hks.spring_boot_mybatis.utils.JsonResult;
import com.hks.spring_boot_mybatis.utils.JsonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaohe
 * @Date: 2018/7/25 14:13
 * @Description: 拦截处理类
 */
//HandlerInterceptor 拦截器
public class OneInterceptor implements HandlerInterceptor {

    /**
     * Controller方法执行前调用
     * HttpServletRequest 对象代表客户端的请求
     * HttpServletResponse 重定向（响应）
     *
     */
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object object) throws Exception{

//        System.out.println("被OneController拦截。。。放行");
//        return true;

        if(true){//返回json给客户端
            returnErrorResponse(response,JsonResult.errorMsg("被OneController拦截"));
        }
        return false;
    }

    /**
     *  请求处理之后（Controller方法执行后），视图渲染之前调用
     * @param request
     * @param response
     * @param object
     * @param mv
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView mv) throws Exception{
        //ModelAndView 视图数据和视图名称
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
     * （主要是用于进行资源清理工作）
     */
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
                                Object object,Exception ex) throws Exception{

    }

    /**
     *  返回响应数据
     * @param response
     * @param result
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public void returnErrorResponse(HttpServletResponse response, JsonResult result)
            throws IOException,UnsupportedEncodingException {
        OutputStream out = null;
        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            //向response缓冲区中写入字节
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        }finally{
            if(out!=null){
                out.close();
            }
        }
    }
}
