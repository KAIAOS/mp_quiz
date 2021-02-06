package com.wst.mp_quiz.controller;

import com.wst.mp_quiz.entity.GroupList;
import com.wst.mp_quiz.service.GroupListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "GroupListController", tags = {"组题列表信息"})
@Controller
public class GroupListController {

    @Autowired
    GroupListService groupListService;

    @ApiOperation(value = "根据wxid查询组题列表信息", notes = "为空则全部status为为提交")
    @GetMapping("/groupList/index")
    @ResponseBody
    public Map<String, Object> getGroupList(String wx_id){
        List<GroupList> groupList = groupListService.getGroupList(wx_id);

        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("msg", "查询组卷列表成功");
        result.put("data", groupList);
        return result;
    }

    @ApiOperation(value = "根据wxid查询已经回答的组题列表信息", notes = "")
    @GetMapping("/recordList/index")
    @ResponseBody
    public Map<String, Object> getRecordList(String wx_id){
        List<GroupList> recordList = groupListService.getRecordList(wx_id);

        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        result.put("msg", "查询已回答组卷列表成功");
        result.put("data", recordList);
        return result;
    }

}
