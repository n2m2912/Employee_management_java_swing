/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.PositionsDAL;
import em.dto.Positions;
import em.dto.Positions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class PositionBLL {
    PositionsDAL dal = new PositionsDAL();
    
    public List<Positions> readPositionsBll() {
        List<Positions> listPositions = new ArrayList<>();
        listPositions = dal.readPositions();
        return listPositions;
    }
    
    public Positions findPositionsBll(int id) {
        Positions position = new Positions();
        position = dal.findPositions(id);
        return position;
    }
    public int addNewPositionsDAL(Positions model) {

        try {
            dal.addNewPositions(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editPositionsDAL(Positions positions) {
        try {
           
            dal.editPositions(positions);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deletePositionsDAL(int ID) {
            try {
                dal.deletePositions(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
