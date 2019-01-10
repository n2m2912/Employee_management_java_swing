/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.EmployeeDAL;
import em.dto.Employees;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author manng
 */
public class EmployeeBLL {
    EmployeeDAL dal = new EmployeeDAL();
    
    public List<Employees> readEmployeeBll() {
        List<Employees> listEmployee = new ArrayList<>();
        listEmployee = dal.readEmployee();
        return listEmployee;
    }
    public int addNewEmployeeDAL(Employees employeeModel) {

        try {
            dal.addNewEmployee(employeeModel); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public Employees findEmployeeBll(String id) {
        Employees employee = new Employees();
        employee = dal.findEmployee(id);
        return employee;
    }
    
    public int editEmployeeDAL(Employees employeeModel) {
        try {
           
            dal.editEmployee(employeeModel);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteEmployeeDAL(String ID) {
            try {
                dal.deleteEmployee(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
