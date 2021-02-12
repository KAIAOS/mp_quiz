package com.wst.mp_quiz.pojo;

import lombok.Data;

@Data
public class QuestionListVo {

    private Integer id;
    private Integer group_id;
    private String question_title;
    private Integer question_id;
    private Integer question_type;
    private String question_options;
    private String titleA;
    private String titleB;
    private String titleC;
    private String titleD;
}
