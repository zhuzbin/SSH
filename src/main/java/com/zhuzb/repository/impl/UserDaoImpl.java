package com.zhuzb.repository.impl;

import com.zhuzb.entity.Resource;
import com.zhuzb.entity.User;
import com.zhuzb.repository.BaseDao;
import com.zhuzb.repository.UserDao;
import com.zhuzb.util.SessionConfig;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Repository
public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao {

    @Override
    public void createUser(final User user) {
        super.getSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        super.getSession().update(user);
    }

    public void deleteUser(Long userId) {
        super.getSession().delete(userId);
    }

    @Override
    public User findOne(Long userId) {
        return (User) super.getSession().get(User.class,userId);
    }

    @Override
    public List<User> findAll() {
        String hql = "select u from User u";
        Query query = super.getSession().createQuery(hql);
        return query.list();
    }


    @Override
    public User findByUsername(String username) {
        String hql = "select u from User u where u.username = ? ";
        Query query = super.getSession().createQuery(hql).setString(0,username);
        List<User> userList = query.list();
        if(userList!=null&&userList.size() > 0) {
            User u = userList.get(0);
            System.out.println(u);
            return u;
        }
        return null;
    }
}
