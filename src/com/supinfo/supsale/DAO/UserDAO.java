package com.supinfo.supsale.DAO;

import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserDAO {

    public static void addUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
    }

    public static String getPasswordByName(String username){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = (Query) em.createQuery("SELECT u.password FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        return ((String) query.getResultList().get(0));

    }

}
