/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Religions;
import em.dto.Religions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author manng
 */
public class ReligionsDAL {
    private static SessionFactory factory;
     public List<Religions> readReligions() {
        List rel = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Religions.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            rel = session.createQuery("FROM Religions").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return rel;
    }
     public Religions findReligions(int id) {
        Religions religion = new Religions();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Religions.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            religion = (Religions)session.get(Religions.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return religion;
    }
     
     public void addNewReligions(Religions religion) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Religions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(religion);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editReligions(Religions religion) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Religions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Religions religiona ;
        try{
            tx=session.beginTransaction();
            religiona = (Religions)session.get(Religions.class,religion.getId());
            religiona.setReligionName(religion.getReligionName());
            session.update(religiona);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteReligions(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Religions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Religions religion = (Religions)session.get(Religions.class,ID);
            session.delete(religion);
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
