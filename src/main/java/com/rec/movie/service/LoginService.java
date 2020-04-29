package com.rec.movie.service;

import com.rec.movie.domain.Movieinfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LoginService {

    Map<String,String> login(String username, String password);

    String signUp(String username,String pwd1,String pwd2);

}
