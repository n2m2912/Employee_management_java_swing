/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.EmployeeTypesDAL;
import em.dto.EmployeeTypes;
import em.dto.EmployeeTypes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class EmployeeTypeBLL {
    EmployeeTypesDAL dal = new EmployeeTypesDAL();
    
    public List<EmployeeTypes> readEmployeeTypeBll() {
        List<EmployeeTypes> listEmployeeType = new ArrayList<>();
        listEmployeeType = dal.readEmployeeTypes();
        return listEmployeeType;
    }
    
    public EmployeeTypes findEmployeeTypesBll(int id) {
        EmployeeTypes tmTy = new EmployeeTypes();
        tmTy = dal.findEmployeeTypes(id);
        return tmTy;
    }
    public int addNewEmployeeTypeseDAL(EmployeeTypes model) {

        try {
            dal.addNewEmployeeTypes(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editEmployeeTypesDAL(EmployeeTypes tmTys) {
        try {
           
            dal.editEmployeeTypes(tmTys);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteEmployeeTypesDAL(int ID) {
            try {
                dal.deleteEmployeeTypes(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
