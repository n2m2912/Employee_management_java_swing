/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.CertificatesDAL;
import em.dto.Certificates;
import em.dto.Certificates;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class CertificatesBLL {
    CertificatesDAL dal = new CertificatesDAL();
    
    public List<Certificates> readCertificateBll() {
        List<Certificates> listCert = new ArrayList<>();
        listCert = dal.readCertificates();
        return listCert;
    }
    public Certificates findCertificatesBll(int id) {
        Certificates certificates = new Certificates();
        certificates = dal.findCertificates(id);
        return certificates;
    }
    public int addNewCertificateseDAL(Certificates model) {

        try {
            dal.addNewCertificates(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            return 0;
        }
    }
    public int editCertificatesDAL(Certificates certificatess) {
        try {
            dal.editCertificates(certificatess);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại");
            return 0;
        }
    }
    
    public void deleteCertificatesDAL(int ID) {
            try {
                dal.deleteCertificates(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại");
            }
        

    }
}
