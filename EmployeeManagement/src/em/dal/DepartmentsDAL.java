/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import em.dto.Departments;
import em.dto.Employees;
import java.sql.SQLException;
/**
 *
 * @author manng
 */
public class DepartmentsDAL {
    private static SessionFactory factory;
     public List<Departments> readDepartments() {
        List depart = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Departments.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            depart = session.createQuery("FROM Departments").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return depart;
    }
     
     public Departments findDepartments(int id) {
        Departments derp = new Departments();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Departments.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            derp = (Departments)session.get(Departments.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return derp;
    }
     
     public void addNewDepartments(Departments derp) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Departments.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(derp);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editDepartments(Departments derp) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Departments.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Departments derpa ;
        try{
            tx=session.beginTransaction();
            derpa = (Departments)session.get(Departments.class,derp.getId());
            derpa.setDepartmentName(derp.getDepartmentName());
            session.update(derpa);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteDepartments(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Departments.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Departments derp = (Departments)session.get(Departments.class,ID);
            session.delete(derp);
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
