package com.supinfo.supsale.DAL;
import com.supinfo.supsale.entity.Advert;
import com.supinfo.supsale.entity.Categorie;
import com.supinfo.supsale.entity.User;
import com.supinfo.supsale.utils.PersistenceManager;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

public class AdvertDAO {

    public static void updateAdvert(Advert advert){
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(advert);
        et.commit();
        em.close();
    }

    public static List<Advert> getAllAdvertsOrderByPublishDate(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT a FROM Advert a ORDER BY a.publishDate DESC ");
        List<Advert> adverts = (List<Advert>)query.getResultList();
        return adverts;
    }

    public static List<Advert> getTenAdvertsOrderByPublishDate(){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT  a FROM Advert a ORDER BY a.publishDate DESC");
        query.setMaxResults(10);
        List<Advert> adverts = (List<Advert>)query.getResultList();
        return adverts;
    }

    public static Advert getAdvertById(int id){
        EntityManager em = PersistenceManager.getEntityManager();
        return em.find(Advert.class, id);
    }

    public static void removeAdvertByAdvert(Advert ad){
        PersistenceManager.getEntityManager().close();
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

    public static Advert getAndCheck(int id, int userID) throws NotFoundException, IOException, IllegalAccessException {
        Advert advert = AdvertDAO.getAdvertById(id);
        if (advert == null){
            throw new NotFoundException("Advert no found");
        } else if (advert.getOwner().getId() != userID){
            throw new IllegalAccessException("You dont have access to this advert");
        }
        return advert;
    }

    public static List<Advert> searchFullText(String txt){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT a FROM Advert a where a.name LIKE :txt OR a.description LIKE :txt OR a.owner.username LIKE :txt");
        query.setParameter("txt","%"+txt+"%");
        return (List<Advert>)query.getResultList();
    }

    public static List<Advert> searchByCategorie(Categorie search){
        EntityManager em = PersistenceManager.getEntityManager();
        Query  query = em.createQuery("SELECT a FROM Advert a where a.categorie = :filter");
        query.setParameter("filter", search);
        return (List<Advert>)query.getResultList();
    }
}
