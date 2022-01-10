package com.code;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MygetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest  装请求信息的类
        //HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true1");
        response.addCookie(cookie);
        return "获得cookies信息";
    }
    //要求客户端携带cookies访问的get请求
    @RequestMapping(value = "/getwithcookies",method = RequestMethod.GET)
    public String getwithcookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "cookies为空";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return "必须带cookies";
    }
    //要求带参数才能访问的get请求，2种方式
    //1、url:ip:port/getwithparam?key=value&key=value
    @RequestMapping(value = "/getwithparam",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);myList.put("衣服",200);myList.put("帽子",50);
        return myList;
    }
    //2、url:ip:port/getwithparam/10/20
    @RequestMapping(value = "/getwithparam/{start}/{end}")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);myList.put("衣服",200);myList.put("帽子",50);
        return myList;
    }
}
