/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.DepartmentsDAL;
import em.dto.Departments;
import em.dto.Employees;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class DepartmentBLL {
    DepartmentsDAL dal = new DepartmentsDAL();
    
    public List<Departments> readDepartmentBll() {
        List<Departments> listDepartment = new ArrayList<>();
        listDepartment = dal.readDepartments();
        return listDepartment;
    }
    
    public Departments findDepartmentsBll(int id) {
        Departments department = new Departments();
        department = dal.findDepartments(id);
        return department;
    }
    public int addNewDepartmentseDAL(Departments model) {

        try {
            dal.addNewDepartments(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editDepartmentsDAL(Departments departments) {
        try {
           
            dal.editDepartments(departments);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deleteDepartmentsDAL(int ID) {
            try {
                dal.deleteDepartments(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
