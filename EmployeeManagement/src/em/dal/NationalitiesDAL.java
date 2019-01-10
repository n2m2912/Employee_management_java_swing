/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import em.dto.Nationalities;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import em.dto.Nationalities;
import java.sql.SQLException;
/**
 *
 * @author manng
 */
public class NationalitiesDAL {
    private static SessionFactory factory;
     public List<Nationalities> readNationalities() {
        List nation = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Nationalities.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            nation = session.createQuery("FROM Nationalities").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return nation;
    }
     
     public Nationalities findNationalities(int id) {
        Nationalities nationality = new Nationalities();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Nationalities.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            nationality = (Nationalities)session.get(Nationalities.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return nationality;
    }
     
     public void addNewNationalities(Nationalities nationality) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Nationalities.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(nationality);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editNationalities(Nationalities nationality) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Nationalities.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Nationalities nationalitya ;
        try{
            tx=session.beginTransaction();
            nationalitya = (Nationalities)session.get(Nationalities.class,nationality.getId());
            nationalitya.setNationalityName(nationality.getNationalityName());
            session.update(nationalitya);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteNationalities(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Nationalities.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Nationalities nationality = (Nationalities)session.get(Nationalities.class,ID);
            session.delete(nationality);
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
