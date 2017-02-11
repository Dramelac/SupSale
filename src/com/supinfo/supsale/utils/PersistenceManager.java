package com.supinfo.supsale.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private PersistenceManager(){}

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        }
        return emf;
    }

    public static EntityManager getEntityManager(){
        if(em == null){
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }

    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen()){
            emf.close();
        }
        if(em != null && em.isOpen()){
            em.close();
        }
    }
}
