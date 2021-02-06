package com.wst.mp_quiz.service;

import com.wst.mp_quiz.dao.AnswerRecordMapper;
import com.wst.mp_quiz.dao.GroupListMapper;
import com.wst.mp_quiz.entity.AnswerRecord;
import com.wst.mp_quiz.entity.GroupList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupListService {

    @Autowired
    GroupListMapper groupListMapper;
    @Autowired
    AnswerRecordMapper answerRecordMapper;

    public List<GroupList> getGroupList(String wx_id){
        List<GroupList> list = groupListMapper.getList();
        if(wx_id.equals("")){
            for (GroupList groupList:list){
                groupList.setStatus("未提交");
            }
        }else{
            for (GroupList groupList:list){
                AnswerRecord answerRecord = answerRecordMapper.byWxIdAndQid(wx_id, groupList.getId());
                if(answerRecord!=null){
                    groupList.setStatus("已提交");
                }else{
                    groupList.setStatus("未提交");
                }
            }
        }
        return list;
    }

    public List<GroupList> getRecordList(String wx_id){
        List<GroupList> list = groupListMapper.getList();
        List<GroupList> recordList = new ArrayList<>();
        for (GroupList groupList:list){
            AnswerRecord answerRecord = answerRecordMapper.byWxIdAndQid(wx_id, groupList.getId());
            if(answerRecord!=null){
                recordList.add(groupList);
            }
        }
        return recordList;
    }
}
