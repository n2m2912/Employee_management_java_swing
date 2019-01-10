/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.EmployeeTypes;
import em.dto.Employees;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import em.dto.EmployeeTypes;
import java.sql.SQLException;
/**
 *
 * @author manng
 */
public class EmployeeTypesDAL {
    private static SessionFactory factory;
     public List<EmployeeTypes> readEmployeeTypes() {
        List empType = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(EmployeeTypes.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            empType = session.createQuery("FROM EmployeeTypes").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return empType;
    }
     public EmployeeTypes findEmployeeTypes(int id) {
        EmployeeTypes emTy = new EmployeeTypes();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(EmployeeTypes.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            emTy = (EmployeeTypes)session.get(EmployeeTypes.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return emTy;
    }
     
     public void addNewEmployeeTypes(EmployeeTypes emTy) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(EmployeeTypes.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(emTy);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editEmployeeTypes(EmployeeTypes emTy) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(EmployeeTypes.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        EmployeeTypes emTya ;
        try{
            tx=session.beginTransaction();
            emTya = (EmployeeTypes)session.get(EmployeeTypes.class,emTy.getId());
            emTya.setTypeName(emTy.getTypeName());
            session.update(emTya);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteEmployeeTypes(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(EmployeeTypes.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            EmployeeTypes emTy = (EmployeeTypes)session.get(EmployeeTypes.class,ID);
            session.delete(emTy);
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
