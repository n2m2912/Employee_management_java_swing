/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import em.dto.Jobs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import em.dto.Jobs;
import java.sql.SQLException;

/**
 *
 * @author manng
 */
public class JobsDAL {
    private static SessionFactory factory;
     public List<Jobs> readJobs() {
        List jobs = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Jobs.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            jobs = session.createQuery("FROM Jobs").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return jobs;
    }
     public Jobs findJobs(int id) {
        Jobs job = new Jobs();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Jobs.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            job = (Jobs)session.get(Jobs.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return job;
    }
     
     public void addNewJobs(Jobs job) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Jobs.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(job);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editJobs(Jobs job) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Jobs.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Jobs joba ;
        try{
            tx=session.beginTransaction();
            joba = (Jobs)session.get(Jobs.class,job.getId());
            joba.setJobName(job.getJobName());
            session.update(joba);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteJobs(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Jobs.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Jobs job = (Jobs)session.get(Jobs.class,ID);
            session.delete(job);
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
