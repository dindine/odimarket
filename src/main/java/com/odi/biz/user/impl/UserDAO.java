package com.odi.biz.user.impl;

import com.odi.biz.user.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
    private static final int NOTHING_ADAPTED = 0;
    @Autowired
    private SqlSessionTemplate sqlSession;

    public UserVO findById(String id) {
        return sqlSession.selectOne("UserDAO.findById", id);
    }

    public UserVO findOne(String id, String password) {
        UserVO user = new UserVO();
        user.setCust_id(id);
        user.setCust_pwd(password);

        return sqlSession.selectOne("UserDAO.findOne", user);
    }

    public void save(UserVO user) {
        if (sqlSession.selectOne("UserDAO.findById", user.getCust_id()) == null) {
            sqlSession.insert("UserDAO.save", user);
        }
    }

    public UserVO nick(String id) {
        return sqlSession.selectOne("UserDAO.findById", id);

    }

    public boolean update(UserVO user) {
        return sqlSession.update("UserDAO.update", user) > NOTHING_ADAPTED;
    }

    public boolean delete(String id) {
        return sqlSession.delete("UserDAO.delete", id) > NOTHING_ADAPTED;
    }
}