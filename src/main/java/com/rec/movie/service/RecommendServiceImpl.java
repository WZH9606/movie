package com.rec.movie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rec.movie.domain.Movieinfo;
import com.rec.movie.domain.Personalratings;
import com.rec.movie.domain.Recommendresult;
import com.rec.movie.domain.ScoreDTO;
import com.rec.movie.mapper.MovieinfoMapper;
import com.rec.movie.mapper.PersonalratingsMapper;
import com.rec.movie.mapper.RecommendresultMapper;
import com.rec.movie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    MovieinfoMapper movieinfoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonalratingsMapper personalratingsMapper;
    @Autowired
    RecommendresultMapper recommendresultMapper;

    @Override
    public List<Movieinfo> ramdom() {
        int a = 47000;
        int start = (int) (Math.random() * 47000);
        QueryWrapper<Movieinfo> ramdom = new QueryWrapper<>();
        ramdom.last("limit " + start + ",10");
        List<Movieinfo> ans = movieinfoMapper.selectList(ramdom);
        return ans;
    }

    @Override
    public String score(Integer userid, List<ScoreDTO> scoreDTOS) {
        Date now = new Date();
        for (int i = 0; i < scoreDTOS.size(); i++) {
            Personalratings rating = new Personalratings();
            rating.setTimestamp("" + now.getTime() / 1000);
            rating.setMovieid(scoreDTOS.get(i).getMovieId());
            rating.setUserid(userid);
            rating.setRating(scoreDTOS.get(i).getScore());
            personalratingsMapper.insert(rating);
        }
        Runnable doALS = new Runnable() {
            @Override
            public void run() {
                //调用你的函数
                try {
                    Thread.sleep(3000);
                    System.out.println("线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //并行执行，不影响打分，打分之后直接返回
        Thread callScale = new Thread(doALS);
        callScale.start();
        Recommendresult temp = new Recommendresult();
        temp.setMovieid(301);
        temp.setMoviename("admin");
        temp.setRating(9.9f);
        temp.setUserid(userid);
        recommendresultMapper.insert(temp);
        return "操作成功";
    }

    @Override
    public List allMoviesByPage(String movieName, Integer page, Integer size) {
        QueryWrapper<Movieinfo> byName = new QueryWrapper<>();
        byName.likeRight("moviename", movieName).last("limit " + (page - 1) * size + "," + size);
        List ans = movieinfoMapper.selectList(byName);
        return ans;
    }

    @Override
    public List<Movieinfo> getRecommend(Integer userId) {
        List<Movieinfo> ans = new ArrayList<>();
        QueryWrapper<Recommendresult> byUserId = new QueryWrapper<>();
        byUserId.eq("userid", userId);
        List<Recommendresult> recommendresults = recommendresultMapper.selectList(byUserId);
        for (int i = 0; i < recommendresults.size(); i++) {
            QueryWrapper<Movieinfo> byMovieId = new QueryWrapper<>();
            byMovieId.eq("movieid",recommendresults.get(i).getMovieid()).last("limit 1");
            ans.add(movieinfoMapper.selectOne(byMovieId));
        }
        return ans;
    }
}
