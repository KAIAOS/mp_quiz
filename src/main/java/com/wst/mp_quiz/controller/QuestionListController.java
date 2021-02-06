package com.wst.mp_quiz.controller;

import com.wst.mp_quiz.dao.QuestionListMapper;
import com.wst.mp_quiz.entity.QuestionList;
import com.wst.mp_quiz.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "QuestionListController", tags = {"题目列表信息"})
@Controller
public class QuestionListController {

    @Autowired
    QuestionListMapper questionListMapper;

    @ApiOperation(value = "题目列表信息", notes = "题目列表信息")
    @GetMapping("/questionList/index")
    @ResponseBody
    public Map<String, Object> getQuestionList(Integer group_id){
        Map<String, Object> result = new HashMap<>();
        List<QuestionList> list = questionListMapper.getList(group_id);
        result.put("status", 200);
        result.put("msg", "题目查询成功");
        result.put("data", list);
        return result;
    }


}
