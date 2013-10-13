package com.perevillega.eia.dao;

import com.perevillega.eia.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List searchUsers(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.ilike("name", name + "%"));
        return criteria.list();
    }

    public List getAllUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    public long save(User user) {
        return (Long) sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    public void delete(int id) {
        User user = getById(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
