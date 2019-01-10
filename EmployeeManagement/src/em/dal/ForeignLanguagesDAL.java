/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import em.dto.ForeignLanguages;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import em.dto.ForeignLanguages;
import java.sql.SQLException;
/**
 *
 * @author manng
 */
public class ForeignLanguagesDAL {
    private static SessionFactory factory;
     public List<ForeignLanguages> readForeignLanguages() {
        List fLang = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(ForeignLanguages.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            fLang = session.createQuery("FROM ForeignLanguages").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return fLang;
    }
     
      public ForeignLanguages findForeignLanguages(int id) {
        ForeignLanguages fLang = new ForeignLanguages();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(ForeignLanguages.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            fLang = (ForeignLanguages)session.get(ForeignLanguages.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return fLang;
    }
     
     public void addNewForeignLanguages(ForeignLanguages fLang) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ForeignLanguages.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(fLang);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editForeignLanguages(ForeignLanguages fLang) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ForeignLanguages.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        ForeignLanguages fLanga ;
        try{
            tx=session.beginTransaction();
            fLanga = (ForeignLanguages)session.get(ForeignLanguages.class,fLang.getId());
            fLanga.setLanguageName(fLang.getLanguageName());
            session.update(fLanga);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteForeignLanguages(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ForeignLanguages.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            ForeignLanguages fLang = (ForeignLanguages)session.get(ForeignLanguages.class,ID);
            session.delete(fLang);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
}
