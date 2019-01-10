/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.ITCertificatesDAL;
import em.dto.ItCertificates;
import em.dto.ItCertificates;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class ITCertificateBLL {
    ITCertificatesDAL dal = new ITCertificatesDAL();
    
    public List<ItCertificates> readItCertificatesBll() {
        List<ItCertificates> listItCertificates = new ArrayList<>();
        listItCertificates = dal.readITCertificates();
        return listItCertificates;
    }
    public ItCertificates findItCertificatesBll(int id) {
        ItCertificates itCert = new ItCertificates();
        itCert = dal.findItCertificates(id);
        return itCert;
    }
    public int addNewItCertificatesDAL(ItCertificates model) {

        try {
            dal.addNewItCertificates(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editItCertificatesDAL(ItCertificates itCerts) {
        try {
           
            dal.editItCertificates(itCerts);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteItCertificatesDAL(int ID) {
            try {
                dal.deleteItCertificates(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
