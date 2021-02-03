package com.wst.mp_quiz.dao;

import com.wst.mp_quiz.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "UsersMapper")
public interface UsersMapper {
    Users findByWxId(String wx_id);
}
