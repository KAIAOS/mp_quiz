package com.wst.mp_quiz.pojo;

import lombok.Data;

@Data
public class AnswerRecordVo {
    private String unique_index;
    private  String wx_id;
    private  Integer group_id;
    private  Integer question_id;
    private String answer;
}
