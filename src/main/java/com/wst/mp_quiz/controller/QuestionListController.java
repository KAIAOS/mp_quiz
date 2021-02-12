package com.wst.mp_quiz.controller;

import com.wst.mp_quiz.dao.QuestionListMapper;
import com.wst.mp_quiz.entity.QuestionList;
import com.wst.mp_quiz.entity.Users;
import com.wst.mp_quiz.pojo.QuestionListVo;
import com.wst.mp_quiz.service.AnswerRecordService;
import com.wst.mp_quiz.service.QuestionListService;
import com.wst.mp_quiz.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "QuestionListController", tags = {"题目列表信息"})
@Controller
public class QuestionListController {

    @Autowired
    QuestionListMapper questionListMapper;
    @Autowired
    QuestionListService questionListService;
    @Autowired
    AnswerRecordService answerRecordService;

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

    @ApiOperation(value = "题目详情", notes = "题目列表信息")
    @GetMapping("/questionList/detail")
    @ResponseBody
    public R test(Integer group_id){
        List<QuestionList> list = questionListMapper.getList(group_id);
        List<QuestionListVo> result =questionListService.getOption(list);
        return R.ok().data("list",result);
    }

    @ApiOperation(value = "提交选择题答案数组", notes = "提交选择题答案数组")
    @PostMapping("/questionList/questionIdList")
    @ResponseBody
    public R questionIdList(  @RequestParam(value = "ChooseAnswer")List<String> ChooseAnswer,
                                @RequestParam(value="group_id")Integer group_id,
                              @RequestParam(value = "openId")String openId){
        System.out.println(ChooseAnswer);
        System.out.println(group_id);
        System.out.println(openId);

        int updateAnswer = answerRecordService.updateAnswer(ChooseAnswer,group_id,openId);

        return R.ok();
    }

}
