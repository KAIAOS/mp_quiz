package com.wst.mp_quiz.controller;

import com.wst.mp_quiz.dao.AnswerRecordMapper;
import com.wst.mp_quiz.entity.AnswerRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "AnswerRecordController", tags = {"回答问题记录"})
@Controller
public class AnswerRecordController {

    @Autowired
    AnswerRecordMapper answerRecordMapper;

    @ApiOperation(value = "根据wxid查询用户信息", notes = "为空则需要注册信息")
    @GetMapping("/answerRecord/index")
    @ResponseBody
    public Map<String, Object> getUsers(String wx_id, Integer group_id){
        List<AnswerRecord> answerRecords = answerRecordMapper.listByWxIdAndQid(wx_id, group_id);
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("msg", "回答记录返回成功");
        result.put("data", answerRecords);
        return result;
    }
}
