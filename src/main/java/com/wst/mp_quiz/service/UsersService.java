package com.wst.mp_quiz.service;

import com.wst.mp_quiz.dao.UsersMapper;
import com.wst.mp_quiz.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    public Users findByWx(String wx_id){
        return usersMapper.findByWxId(wx_id);
    }
}
