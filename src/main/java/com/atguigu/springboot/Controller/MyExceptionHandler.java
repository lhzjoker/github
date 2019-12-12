package com.atguigu.springboot.Controller;

import com.atguigu.springboot.exception.UserNotExsitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//异常处理器
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器和客户端都是json数据，缺点是无法进行自适应
//    @ResponseBody
//    @ExceptionHandler(UserNotExsitException.class)      //错误发生的时候运行
//    public  Map<String,Object> handleExcepiton(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExsitException.class)      //错误发生的时候运行
    public  String handleExcepiton(Exception e, HttpServletRequest request){
        //必须传入我们自己的错误状态码，4xx,5xx,不然无法进入定制的错误页面
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map=new HashMap<>();
        //但是这样的话，map中的数据无法显示，需要添加到容器中
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
