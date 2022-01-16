package test.com.code;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import test.com.bean.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/")
@RequestMapping("/v1")   //所有请求前面得加上V1
public class MyPostMethod {
    //设置一个变量值
    private static Cookie cookies;
    //用户登录成功获取cookies,然后访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，获取cookies",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
        if (username.equals("zhangsan") && password.equals("123456")){
            cookies = new Cookie("login","true");
            response.addCookie(cookies);
            return "登录成功并获取cookies";
        }
        return "登录失败";
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u){
        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie c:cookies){
            if (c.getName().equals("login") && c.getValue().equals("true")){
                user = new User();
                user.setAge("18");
                user.setSex("man");
                user.setName("arvin");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
