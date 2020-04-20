package com.rec.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rec.movie.domain.Recommendresult;
import com.rec.movie.domain.RecommendresultExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecommendresultMapper extends BaseMapper<Recommendresult> {
}