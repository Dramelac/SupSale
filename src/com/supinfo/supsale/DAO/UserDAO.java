package com.supinfo.supsale.DAO;

import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {

    public static void addUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
    }

    public static void updateUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
        em.close();
    }

    public static String getPasswordByName(String username){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u.password FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        List result = query.getResultList();
        return (result.size() == 0) ? "" : ((String) result.get(0));
    }

    public static User getUserByName(String username){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        List result = query.getResultList();
        return (result.size() == 0) ? null : ((User) result.get(0));
    }

    public static User getUserById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(User.class, id);
    }

    public static long getUserCount(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM User");
        return (long) query.getSingleResult();
    }

}
