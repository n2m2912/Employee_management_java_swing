/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.ForeignLanguagesDAL;
import em.dto.ForeignLanguages;
import em.dto.ForeignLanguages;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class ForeignLanguageBLL {
    ForeignLanguagesDAL dal = new ForeignLanguagesDAL();
    
    public List<ForeignLanguages> readForeignLanguagesBll() {
        List<ForeignLanguages> listForeignLanguages = new ArrayList<>();
        listForeignLanguages = dal.readForeignLanguages();
        return listForeignLanguages;
    }
    
     public ForeignLanguages findForeignLanguagesBll(int id) {
        ForeignLanguages fLang = new ForeignLanguages();
        fLang = dal.findForeignLanguages(id);
        return fLang;
    }
    public int addNewForeignLanguagesDAL(ForeignLanguages model) {

        try {
            dal.addNewForeignLanguages(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editForeignLanguagesDAL(ForeignLanguages fLangs) {
        try {
           
            dal.editForeignLanguages(fLangs);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteForeignLanguagesDAL(int ID) {
            try {
                dal.deleteForeignLanguages(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
