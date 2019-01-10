/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.KnowledgesDAL;
import em.dto.Knowledges;
import em.dto.Knowledges;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class KnowledgeBLL {
    KnowledgesDAL dal = new KnowledgesDAL();
    
    public List<Knowledges> readKnowledgesBll() {
        List<Knowledges> listKnowledges = new ArrayList<>();
        listKnowledges = dal.readKnowledges();
        return listKnowledges;
    }
    
    public Knowledges findKnowledgesBll(int id) {
        Knowledges knowledge = new Knowledges();
        knowledge = dal.findKnowledges(id);
        return knowledge;
    }
    public int addNewKnowledgesDAL(Knowledges model) {

        try {
            dal.addNewKnowledges(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editKnowledgesDAL(Knowledges knowledges) {
        try {
           
            dal.editKnowledges(knowledges);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deleteKnowledgesDAL(int ID) {
            try {
                dal.deleteKnowledges(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
