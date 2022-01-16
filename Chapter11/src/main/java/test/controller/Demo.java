package test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.model.User;

@Log4j
@RestController
@Api(value = "v1")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行SQL的对象
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数",httpMethod = "GET")
    public int getUserCount(){
       return template.selectOne("getUserCount");
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        int result = template.insert("addUser",user);
        return result;
    }
    @RequestMapping(value = "/updateUser",method =RequestMethod.POST)
     public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
     }
    @RequestMapping(value = "/deleteUser",method =RequestMethod.GET)
     public int delUser(@RequestParam int id){
       return template.delete("deleteUser",id);

     }
}
