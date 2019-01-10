/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dal;

import em.dto.Employees;
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
public class EmployeeDAL {
    private static SessionFactory factory;
     public List<Employees> readEmployee() {
        List emps = new ArrayList();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Employees.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            emps = session.createQuery("FROM Employees").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return emps;
    }
     
     public void addNewEmployee(Employees emp) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Employees.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(emp);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }

    }
     
     public Employees findEmployee(String id) {
        Employees emp = new Employees();
        Session session;
        factory = new Configuration().configure().addAnnotatedClass(Employees.class).buildSessionFactory();
        session = factory.openSession();
        Transaction tx = null;
        int row = 0;
        try {
            tx = session.beginTransaction();
            emp = (Employees)session.get(Employees.class,id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
            return emp;
    }
     
     public void editEmployee(Employees emp) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Employees.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        Employees empE ;
        try{
            tx=session.beginTransaction();
            empE = (Employees)session.get(Employees.class,emp.getId());
            empE.setFullName(emp.getFullName());
            empE.setSecretName(emp.getSecretName());
            empE.setGender(emp.getGender());
            empE.setMaritalStatus(emp.getMaritalStatus());
            empE.setMobileNumber(emp.getMobileNumber());
            empE.setPhoneNumber(emp.getPhoneNumber());
            empE.setEmail(emp.getEmail());
            empE.setDateOfBirth(emp.getDateOfBirth());
            empE.setPlaceOfBirth(emp.getPlaceOfBirth());
            empE.setPronvinceID(emp.getPronvinceID());
            empE.setIdentityNumber(emp.getIdentityNumber());
            empE.setDateOfIDRegistered(emp.getDateOfIDRegistered());
            empE.setPlaceOfIDRegistered(emp.getPlaceOfIDRegistered());
            empE.setHomeTown(emp.getHomeTown());
            empE.setAddress(emp.getAddress());
            empE.setTemporaryResidence(emp.getTemporaryResidence());
            empE.setEmployeeTypeID(emp.getEmployeeTypeID());
            empE.setStartWorkingDate(emp.getStartWorkingDate());
            empE.setDepartmentID(emp.getDepartmentID());
            empE.setJobID(emp.getJobID());
            empE.setPositionID(emp.getPositionID());
            empE.setBasicSalary(emp.getBasicSalary());
            empE.setCoefficient(emp.getCoefficient());
            empE.setSalary(emp.getSalary());
            empE.setAllowance(emp.getAllowance());
            empE.setLabourNumber(emp.getLabourNumber());
            empE.setDateOfLabourRegistered(emp.getDateOfLabourRegistered());
            empE.setPlaceOfLabourRegistered(emp.getPlaceOfLabourRegistered());
            empE.setBankAccount(emp.getBankAccount());
            empE.setBank(emp.getBank());
            empE.setKnowledgeID(emp.getKnowledgeID());
            empE.setCertificateID(emp.getCertificateID());
            empE.setForeignLanguageID(emp.getForeignLanguageID());
            empE.setiTCertificateID(emp.getiTCertificateID());
            empE.setFolkID(emp.getFolkID());
            empE.setNationalityID(emp.getNationalityID());
            empE.setReligionID(emp.getReligionID());
            session.update(empE);
            tx.commit();
        }catch (HibernateException ex) {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
     
     public void deleteEmployee(String ID) throws SQLException {
        factory = new Configuration().configure().addAnnotatedClass(Employees.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Employees emp = (Employees)session.get(Employees.class,ID);
            session.delete(emp);
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
