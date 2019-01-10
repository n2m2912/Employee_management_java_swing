/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import em.dto.Knowledges;
import em.dto.Knowledges;
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
public class KnowledgesDAL {
    private static SessionFactory factory;
     public List<Knowledges> readKnowledges() {
        List know = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Knowledges.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            know = session.createQuery("FROM Knowledges").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return know;
    }
     public Knowledges findKnowledges(int id) {
        Knowledges knowledge = new Knowledges();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Knowledges.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            knowledge = (Knowledges)session.get(Knowledges.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return knowledge;
    }
     
     public void addNewKnowledges(Knowledges knowledge) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Knowledges.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(knowledge);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editKnowledges(Knowledges knowledge) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Knowledges.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Knowledges knowledgea ;
        try{
            tx=session.beginTransaction();
            knowledgea = (Knowledges)session.get(Knowledges.class,knowledge.getId());
            knowledgea.setKnowledgeName(knowledge.getKnowledgeName());
            session.update(knowledgea);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteKnowledges(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Knowledges.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Knowledges knowledge = (Knowledges)session.get(Knowledges.class,ID);
            session.delete(knowledge);
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
