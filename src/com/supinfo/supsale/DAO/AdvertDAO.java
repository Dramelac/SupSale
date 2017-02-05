package com.supinfo.supsale.DAO;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class AdvertDAO {

    public static void addAdvert(Advert advert){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(advert);
        et.commit();
        em.close();
    }

    public static void updateAdvert(Advert advert){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(advert);
        et.commit();
        em.close();
    }

    public static List<Advert> getAllAdvertByUser(User user){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = (Query) em.createQuery("SELECT a FROM Advert a where a.owner = :usertest");
        query.setParameter("usertest",user);
        List<Advert> adverts = (List<Advert>)query.getResultList();
        return adverts;
    }

    public static Advert getAdvertById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(Advert.class, id);
    }

    public static void removeAdvertByAdvert(Advert ad){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.contains(ad) ? ad : em.merge(ad));
        et.commit();
        em.close();
    }

    public static long getAdvertCount(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query query = em.createQuery("SELECT count(*) FROM Advert");
        return (long) query.getSingleResult();
    }
}
