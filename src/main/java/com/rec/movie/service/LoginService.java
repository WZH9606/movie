package com.rec.movie.service;

import com.rec.movie.domain.Movieinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    String login(String username,String password);

    String signUp(String username,String pwd1,String pwd2);

}
