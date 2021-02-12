package com.wst.mp_quiz.dao;

import com.wst.mp_quiz.entity.AnswerRecord;
import com.wst.mp_quiz.pojo.AnswerRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "AnswerRecordMapper")
public interface AnswerRecordMapper {

    AnswerRecord byWxIdAndQid(String wx_id, Integer qId);
    List<AnswerRecord> listByWxIdAndQid(String wx_id, Integer qId);

    void updateAnswer(AnswerRecordVo answerRecordVo);
}
