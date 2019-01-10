/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import em.dto.Certificates;
import em.dto.Certificates;
import java.sql.SQLException;
/**
 *
 * @author manng
 */
public class CertificatesDAL {
    private static SessionFactory factory;
     public List<Certificates> readCertificates() {
        List certs = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Certificates.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            certs = session.createQuery("FROM Certificates").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return certs;
    }
     
     public Certificates findCertificates(int id) {
        Certificates cert = new Certificates();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Certificates.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            cert = (Certificates)session.get(Certificates.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return cert;
    }
     
     public void addNewCertificates(Certificates cert) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Certificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(cert);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public void editCertificates(Certificates cert) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Certificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Certificates certa ;
        try{
            tx=session.beginTransaction();
            certa = (Certificates)session.get(Certificates.class,cert.getId());
            certa.setCertificateName(cert.getCertificateName());
            session.update(certa);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteCertificates(int ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Certificates.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Certificates cert = (Certificates)session.get(Certificates.class,ID);
            session.delete(cert);
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
