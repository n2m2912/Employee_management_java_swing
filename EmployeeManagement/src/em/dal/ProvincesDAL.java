/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Provinces;
import em.dto.Provinces;
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
public class ProvincesDAL {
    private static SessionFactory factory;
     public List<Provinces> readProvinces() {
        List prov = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Provinces.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            prov = session.createQuery("FROM Provinces").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return prov;
    }
     public Provinces findProvinces(int id) {
        Provinces province = new Provinces();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Provinces.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            province = (Provinces)session.get(Provinces.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return province;
    }
     
     public void addNewProvinces(Provinces province) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Provinces.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(province);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editProvinces(Provinces province) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Provinces.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Provinces provincea ;
        try{
            tx=session.beginTransaction();
            provincea = (Provinces)session.get(Provinces.class,province.getId());
            provincea.setProvinceName(province.getProvinceName());
            session.update(provincea);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteProvinces(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Provinces.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Provinces province = (Provinces)session.get(Provinces.class,ID);
            session.delete(province);
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
