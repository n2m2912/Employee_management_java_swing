/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.bll;

import em.dal.JobsDAL;
import em.dto.Jobs;
import em.dto.Jobs;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author manng
 */
public class JobBLL {
    JobsDAL dal = new JobsDAL();
    
    public List<Jobs> readJobsBll() {
        List<Jobs> listJobs = new ArrayList<>();
        listJobs = dal.readJobs();
        return listJobs;
    }
    public Jobs findJobsBll(int id) {
        Jobs job = new Jobs();
        job = dal.findJobs(id);
        return job;
    }
    public int addNewJobsDAL(Jobs model) {

        try {
            dal.addNewJobs(model); // ham insert 
            JOptionPane.showMessageDialog(null, "Thêm thành công");
            return 1;  // thanh cong 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    public int editJobsDAL(Jobs jobs) {
        try {
           
            dal.editJobs(jobs);
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa  thất bại!!.ERROR:"+ex);
            return 0;
        }
    }
    
    public void deleteJobsDAL(int ID) {
            try {
                dal.deleteJobs(ID);
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Xóa  thất bại!!.ERROR:"+ex);
            }
        

    }
}
