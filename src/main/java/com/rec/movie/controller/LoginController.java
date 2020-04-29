package com.rec.movie.controller;

import com.rec.movie.domain.Result;
import com.rec.movie.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/start")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("login")
    @ApiOperation("登录")
    public Result login(@RequestParam String username, @RequestParam String pswd){
        Map ans = loginService.login(username,pswd);
        if(ans.containsKey("失败原因")){
            return new Result().fail(ans);
        }
        return new Result().success(ans);
    }

    @PostMapping("signUp")
    @ApiOperation("注册")
    public Result signUp(@RequestParam String username,@RequestParam String pswd1,@RequestParam String pswd2){
        String ans = loginService.signUp(username,pswd1,pswd2);
        if(!ans.equals("注册成功")){
            return new Result().fail(ans);
        }
        return new Result().success(ans);
    }

}
