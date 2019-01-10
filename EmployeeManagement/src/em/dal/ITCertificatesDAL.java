/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.ItCertificates;
import em.dto.ItCertificates;
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
public class ITCertificatesDAL {
    private static SessionFactory factory;
     public List<ItCertificates> readITCertificates() {
        List itCert = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(ItCertificates.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            itCert = session.createQuery("FROM ItCertificates").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return itCert;
    }
     public ItCertificates findItCertificates(int id) {
        ItCertificates itCert = new ItCertificates();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(ItCertificates.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            itCert = (ItCertificates)session.get(ItCertificates.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return itCert;
    }
     
     public void addNewItCertificates(ItCertificates itCert) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ItCertificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(itCert);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editItCertificates(ItCertificates itCert) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ItCertificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        ItCertificates itCerta ;
        try{
            tx=session.beginTransaction();
            itCerta = (ItCertificates)session.get(ItCertificates.class,itCert.getId());
            itCerta.setITName(itCert.getITName());
            session.update(itCerta);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteItCertificates(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(ItCertificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            ItCertificates itCert = (ItCertificates)session.get(ItCertificates.class,ID);
            session.delete(itCert);
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
