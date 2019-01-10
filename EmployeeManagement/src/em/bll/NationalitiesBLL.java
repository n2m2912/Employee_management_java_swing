/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.NationalitiesDAL;
import em.dto.Nationalities;
import em.dto.Nationalities;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class NationalitiesBLL {
    NationalitiesDAL dal = new NationalitiesDAL();
    
    public List<Nationalities> readNationalitiesBll() {
        List<Nationalities> listNationalities = new ArrayList<>();
        listNationalities = dal.readNationalities();
        return listNationalities;
    }
    public Nationalities findNationalitiesBll(int id) {
        Nationalities nationality = new Nationalities();
        nationality = dal.findNationalities(id);
        return nationality;
    }
    public int addNewNationalitiesDAL(Nationalities model) {

        try {
            dal.addNewNationalities(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm  thành công");
            return 1;  // thanh cong 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editNationalitiesDAL(Nationalities nationalitys) {
        try {
           
            dal.editNationalities(nationalitys);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteNationalitiesDAL(int ID) {
            try {
                dal.deleteNationalities(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
