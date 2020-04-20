package com.rec.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rec.movie.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}