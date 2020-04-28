package com.rec.movie.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rec.movie.domain.Movieinfo;
import com.rec.movie.domain.ScoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendService {

    List<Movieinfo> ramdom();

    String score(Integer userid, List<ScoreDTO> scoreDTOS);

    List allMoviesByPage(String movieName, Integer page,Integer size);

    List<Movieinfo> getRecommend(Integer userId);
}
