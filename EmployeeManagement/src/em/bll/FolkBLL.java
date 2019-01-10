/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.FolksDAL;
import em.dto.Folks;
import em.dto.Folks;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class FolkBLL {
    FolksDAL dal = new FolksDAL();
    
    public List<Folks> readFolksBll() {
        List<Folks> listFolks = new ArrayList<>();
        listFolks = dal.readFolks();
        return listFolks;
    }
     public Folks findFolksBll(int id) {
        Folks folk = new Folks();
        folk = dal.findFolks(id);
        return folk;
    }
    public int addNewFolksDAL(Folks model) {

        try {
            dal.addNewFolks(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editFolksDAL(Folks folks) {
        try {
           
            dal.editFolks(folks);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deleteFolksDAL(int ID) {
            try {
                dal.deleteFolks(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
