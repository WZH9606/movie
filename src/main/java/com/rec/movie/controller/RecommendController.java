package com.rec.movie.controller;

import com.rec.movie.domain.Result;
import com.rec.movie.domain.ScoreDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("rec")
@RestController
public class RecommendController {

    @GetMapping("getRecommend")
    @ApiOperation("获取推荐信息")
    public Result getRecommend(@RequestParam Integer userId){
        return new Result().success();
    }

    @PostMapping("score")
    @ApiOperation("打分")
    public Result score(@RequestParam Integer userId,@RequestBody List<ScoreDTO> scoreDTOS){
        return new Result().success();
    }

    @GetMapping("AllMoviesByPage")
    @ApiOperation("获取所有影片")
    public Result history(@RequestParam String movieName){
        return new Result().success();
    }

}
