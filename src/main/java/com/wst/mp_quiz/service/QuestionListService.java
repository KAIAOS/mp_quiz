package com.wst.mp_quiz.service;

import com.wst.mp_quiz.entity.QuestionList;
import com.wst.mp_quiz.pojo.QuestionListVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionListService {
    public List<QuestionListVo> getOption(List<QuestionList> list) {

        List<QuestionListVo> result = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            QuestionListVo questionListVo = new QuestionListVo();
            questionListVo=list.get(i);
            result.add(questionListVo);
        }

        for (int i=0;i<list.size();i++){
            String question_options = list.get(i).getQuestion_options();
            int IndexA = question_options.indexOf("A");
            int IndexB = question_options.indexOf("B");
            int IndexC = question_options.indexOf("C");
            int IndexD = question_options.indexOf("D");
            String A = question_options.substring(IndexA,IndexB);
            result.get(i).setTitleA(A);
            String B = question_options.substring(IndexB,IndexC);
            result.get(i).setTitleB(B);
            String C = question_options.substring(IndexC,IndexD);
            result.get(i).setTitleC(C);
            String D = question_options.substring(IndexD);
            result.get(i).setTitleD(D);
        }
        

        return result;
    }
}
