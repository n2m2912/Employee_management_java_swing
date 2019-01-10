/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.ProvincesDAL;
import em.dto.Provinces;
import em.dto.Provinces;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class ProvinceBLL {
    ProvincesDAL dal = new ProvincesDAL();
    
    public List<Provinces> readProvincesBll() {
        List<Provinces> listProvinces = new ArrayList<>();
        listProvinces = dal.readProvinces();
        return listProvinces;
    }
    public Provinces findProvincesBll(int id) {
        Provinces province = new Provinces();
        province = dal.findProvinces(id);
        return province;
    }
    public int addNewProvincesDAL(Provinces model) {

        try {
            dal.addNewProvinces(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editProvincesDAL(Provinces provinces) {
        try {
           
            dal.editProvinces(provinces);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteProvincesDAL(int ID) {
            try {
                dal.deleteProvinces(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
