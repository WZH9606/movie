package com.rec.movie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rec.movie.domain.Recommendresult;
import com.rec.movie.domain.RecommendresultExample;
import com.rec.movie.domain.User;
import com.rec.movie.mapper.RecommendresultMapper;
import com.rec.movie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.spi.ResolveResult;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RecommendresultMapper recommendresultMapper;
    @Override
    public String login(String username, String password) {
        QueryWrapper<User> byName = new QueryWrapper<>();
        byName.eq("username",username).last("limit 1");
        User user = userMapper.selectOne(byName);
        if(user == null)
            return "用户不存在";
        if(!user.getPassword().equals(password)){
            return "密码错误";
        }
        QueryWrapper<Recommendresult> byUserId = new QueryWrapper<>();
        byUserId.eq("userid",user.getUserid());
        List<Recommendresult> l = recommendresultMapper.selectList(byUserId);
        if(l.size() == 0) {
            return "新用户";
        }else{
            return "老用户";
        }
    }

    @Override
    public String signUp(String username, String pwd1, String pwd2) {
        QueryWrapper<User> byName = new QueryWrapper<>();
        byName.eq("username",username).last("limit 1");
        User user = userMapper.selectOne(byName);
        if(user != null)
            return "用户已存在";
        if(!pwd1.equals(pwd2))
            return "两次密码不一致";
        User newUser = new User();
        newUser.setPassword(pwd1);
        newUser.setUsername(username);
        userMapper.insert(newUser);
        return "注册成功";
    }
}
