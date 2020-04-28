package com.rec.movie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rec.movie.domain.Result;
import com.rec.movie.domain.ScoreDTO;
import com.rec.movie.service.RecommendService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rec")
@RestController
public class RecommendController {

    @Autowired
    RecommendService recommendService;

    @GetMapping("getRecommend")
    @ApiOperation("获取推荐信息")
    public Result getRecommend(@RequestParam Integer userId){
        return new Result().success(recommendService.getRecommend(userId));
    }

    @PostMapping("score")
    @ApiOperation("打分")
    public Result score(@RequestParam Integer userId,@RequestBody List<ScoreDTO> scoreDTOS){
        return new Result().success(recommendService.score(userId,scoreDTOS));
    }

    @GetMapping("AllMoviesByPage")
    @ApiOperation("获取所有影片")
    public Result history(@RequestParam(required = false,defaultValue = "") String movieName,
                          @RequestParam(required = false,defaultValue = "1")Integer page,
                          @RequestParam(required = false,defaultValue = "10")Integer size){
        return new Result().success(recommendService.allMoviesByPage(movieName,page,size));
    }


    @GetMapping("ramdomMovies")
    @ApiOperation("随机电影获取")
    public Result ramdomMovies(){
        return new Result().success(recommendService.ramdom());
    }
}
