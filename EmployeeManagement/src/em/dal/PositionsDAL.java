/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import em.dto.Positions;
import em.dto.Positions;
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
public class PositionsDAL {
    private static SessionFactory factory;
     public List<Positions> readPositions() {
        List pos = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Positions.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            pos = session.createQuery("FROM Positions").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return pos;
    }
     
     public Positions findPositions(int id) {
        Positions position = new Positions();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Positions.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            position = (Positions)session.get(Positions.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return position;
    }
     
     public void addNewPositions(Positions position) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Positions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(position);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editPositions(Positions position) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Positions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Positions positiona ;
        try{
            tx=session.beginTransaction();
            positiona = (Positions)session.get(Positions.class,position.getId());
            positiona.setPositionName(position.getPositionName());
            session.update(positiona);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deletePositions(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Positions.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Positions position = (Positions)session.get(Positions.class,ID);
            session.delete(position);
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
