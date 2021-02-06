package com.wst.mp_quiz.dao;

import com.wst.mp_quiz.entity.QuestionList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "QuestionListMapper")
public interface QuestionListMapper {

    List<QuestionList> getList(Integer group_id);

}