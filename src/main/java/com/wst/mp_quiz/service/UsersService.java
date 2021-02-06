package com.wst.mp_quiz.service;

import com.wst.mp_quiz.dao.UsersMapper;
import com.wst.mp_quiz.entity.Users;
import com.wst.mp_quiz.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    public Users findByWx(String wx_id){
        return usersMapper.findByWxId(wx_id);
    }

    public void registerOrUpdate(Student student){
        Users byWxId = usersMapper.findByWxId(student.getOpenId());
        if(byWxId==null){
            usersMapper.insert(student);
        }else if(byWxId.getId()!=null){
            student.setNumber(byWxId.getId());
            usersMapper.update(student);
        }
    }
}
