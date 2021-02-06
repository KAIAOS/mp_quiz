package com.wst.mp_quiz.controller;

import com.wst.mp_quiz.entity.Users;
import com.wst.mp_quiz.pojo.Student;
import com.wst.mp_quiz.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(value = "UserController", tags = {"用户信息"})
@Controller
public class UsersController {

    @Autowired
    UsersService userService;

    @ApiOperation(value = "根据wxid查询用户信息", notes = "为空则需要注册信息")
    @GetMapping("/users/index")
    @ResponseBody
    public Map<String, Object> getUsers(String wx_id){
        Map<String, Object> result = new HashMap<>();
        Users byWx = userService.findByWx(wx_id);
        if(byWx == null){
            result.put("status", 401);
            result.put("msg", "用户未注册");
        }else {
            result.put("status", 200);
            result.put("msg", "用户已注册");
            result.put("data", byWx);
        }
        return result;
    }

    @ApiOperation(value = "根据wxid注册用户信息", notes = "若存在则更新")
    @PostMapping("/users")
    @ResponseBody
    public Map<String, Object> saveUsers(Student student){
        Map<String, Object> result = new HashMap<>();
        userService.registerOrUpdate(student);
        result.put("status", 200);
        result.put("msg", "用户信息更新成功");
        return result;
    }

}
