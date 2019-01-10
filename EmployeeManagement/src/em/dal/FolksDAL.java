/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Folks;
import em.dto.Employees;
import em.dto.Folks;
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
public class FolksDAL {
    private static SessionFactory factory;
     public List<Folks> readFolks() {
        List folks = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Folks.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            folks = session.createQuery("FROM Folks").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return folks;
    }
     
     public Folks findFolks(int id) {
        Folks folk = new Folks();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Folks.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            folk = (Folks)session.get(Folks.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return folk;
    }
     
     public void addNewFolks(Folks folk) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Folks.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(folk);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editFolks(Folks folk) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Folks.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Folks folka ;
        try{
            tx=session.beginTransaction();
            folka = (Folks)session.get(Folks.class,folk.getId());
            folka.setFolkName(folk.getFolkName());
            session.update(folka);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteFolks(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Folks.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Folks folk = (Folks)session.get(Folks.class,ID);
            session.delete(folk);
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
