package com.rec.movie.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rec.movie.domain.Movieinfo;
import com.rec.movie.domain.User;
import com.rec.movie.mapper.MovieinfoMapper;
import com.rec.movie.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    MovieinfoMapper movieinfoMapper;

    @GetMapping("test")
    @ApiOperation("测试")
    public String test(){

        List<Movieinfo> movieinfos = movieinfoMapper.selectList(new QueryWrapper<>());
       // System.out.println(movieinfos);
        return movieinfos.toString();
    }

    @GetMapping("test2")
    @ApiOperation("测试2")
    public Object test2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",1);
        List<User> users = userMapper.selectList(queryWrapper);
        //System.out.println(users);
        return users.get(0);
    }

}
