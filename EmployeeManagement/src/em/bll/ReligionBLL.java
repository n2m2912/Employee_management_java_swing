/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.ReligionsDAL;
import em.dto.Religions;
import em.dto.Religions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class ReligionBLL {
    ReligionsDAL dal = new ReligionsDAL();
    
    public List<Religions> readReligionsBll() {
        List<Religions> listReligionse = new ArrayList<>();
        listReligionse = dal.readReligions();
        return listReligionse;
    }
    public Religions findReligionsBll(int id) {
        Religions religion = new Religions();
        religion = dal.findReligions(id);
        return religion;
    }
    public int addNewReligionsDAL(Religions model) {

        try {
            dal.addNewReligions(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editReligionsDAL(Religions religions) {
        try {
           
            dal.editReligions(religions);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deleteReligionsDAL(int ID) {
            try {
                dal.deleteReligions(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
