package com.wst.mp_quiz.service;

import com.wst.mp_quiz.dao.AnswerRecordMapper;
import com.wst.mp_quiz.pojo.AnswerRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerRecordService {
    @Autowired
    AnswerRecordMapper answerRecordMapper;
    public int updateAnswer(List<String> chooseAnswer, Integer group_id, String openId) {

        List<AnswerRecordVo> answerRecordVos = new ArrayList<>();

        for (int i=0;i<chooseAnswer.size();i++){

            AnswerRecordVo answerRecordVo = new AnswerRecordVo();

            int question_id = i+1;
            String answer = chooseAnswer.get(i);
            String unique_index = openId.concat(String.valueOf(group_id)).concat(String.valueOf(question_id));
            answerRecordVo.setWx_id(openId);
            answerRecordVo.setGroup_id(group_id);
            answerRecordVo.setQuestion_id(question_id);
            answerRecordVo.setAnswer(answer);
            answerRecordVo.setUnique_index(unique_index);

            answerRecordVos.add(answerRecordVo);
        }

        for (AnswerRecordVo answerRecordVo : answerRecordVos) {
            answerRecordMapper.updateAnswer(answerRecordVo);
        }


        return 0;
    }
}
