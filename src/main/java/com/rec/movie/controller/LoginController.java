package com.rec.movie.controller;

import com.rec.movie.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
public class LoginController {

    @PostMapping("login")
    @ApiOperation("登录")
    public Result login(@RequestParam String username, @RequestParam String pswd){
        return new Result().success();
    }

    @PostMapping("signUp")
    @ApiOperation("注册")
    public Result signUp(@RequestParam String username,@RequestParam String pswd1,@RequestParam String pswd2){
        return new Result().success();
    }

    @GetMapping("ramdomMovies")
    @ApiOperation("随机电影获取")
    public Result ramdomMovies(){
        return new Result().success();
    }

}
