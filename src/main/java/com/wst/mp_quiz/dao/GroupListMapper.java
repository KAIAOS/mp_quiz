package com.wst.mp_quiz.dao;

import com.wst.mp_quiz.entity.GroupList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "GroupListMapper")
public interface GroupListMapper {
    List<GroupList> getList();
}
