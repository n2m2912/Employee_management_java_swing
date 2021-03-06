/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.gui;

import em.gui.EmployeeList;
import javax.swing.*;

/**
 *
 * @author Tu
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btEmployee = new javax.swing.JButton();
        btDepart = new javax.swing.JButton();
        btCertificate = new javax.swing.JButton();
        btEmployeeType = new javax.swing.JButton();
        btFolk = new javax.swing.JButton();
        btForeignLanguage = new javax.swing.JButton();
        btITCertificate = new javax.swing.JButton();
        btJob = new javax.swing.JButton();
        btKnowledge = new javax.swing.JButton();
        btNationality = new javax.swing.JButton();
        btPosition = new javax.swing.JButton();
        btProvince = new javax.swing.JButton();
        btReligion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btEmployee.setText("Nhân viên");
        btEmployee.setFocusable(false);
        btEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEmployee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeActionPerformed(evt);
            }
        });
        jToolBar1.add(btEmployee);

        btDepart.setText("Phòng ban");
        btDepart.setFocusable(false);
        btDepart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDepart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepartActionPerformed(evt);
            }
        });
        jToolBar1.add(btDepart);

        btCertificate.setText("Bằng cấp");
        btCertificate.setFocusable(false);
        btCertificate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCertificate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCertificateActionPerformed(evt);
            }
        });
        jToolBar1.add(btCertificate);

        btEmployeeType.setText("Loại nhân viên");
        btEmployeeType.setFocusable(false);
        btEmployeeType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEmployeeType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEmployeeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmployeeTypeActionPerformed(evt);
            }
        });
        jToolBar1.add(btEmployeeType);

        btFolk.setText("Dân tộc");
        btFolk.setFocusable(false);
        btFolk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFolk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFolk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFolkActionPerformed(evt);
            }
        });
        jToolBar1.add(btFolk);

        btForeignLanguage.setText("Ngoại ngữ");
        btForeignLanguage.setFocusable(false);
        btForeignLanguage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btForeignLanguage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btForeignLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btForeignLanguageActionPerformed(evt);
            }
        });
        jToolBar1.add(btForeignLanguage);

        btITCertificate.setText("Bằng tin học");
        btITCertificate.setFocusable(false);
        btITCertificate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btITCertificate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btITCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btITCertificateActionPerformed(evt);
            }
        });
        jToolBar1.add(btITCertificate);

        btJob.setText("Công việc");
        btJob.setFocusable(false);
        btJob.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btJob.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJobActionPerformed(evt);
            }
        });
        jToolBar1.add(btJob);

        btKnowledge.setFocusable(false);
        btKnowledge.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btKnowledge.setLabel("Học vấn");
        btKnowledge.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btKnowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKnowledgeActionPerformed(evt);
            }
        });
        jToolBar1.add(btKnowledge);

        btNationality.setText("Quốc tịch");
        btNationality.setFocusable(false);
        btNationality.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNationality.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNationalityActionPerformed(evt);
            }
        });
        jToolBar1.add(btNationality);

        btPosition.setText("Vị trí");
        btPosition.setFocusable(false);
        btPosition.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPosition.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPositionActionPerformed(evt);
            }
        });
        jToolBar1.add(btPosition);

        btProvince.setText("Tỉnh");
        btProvince.setFocusable(false);
        btProvince.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProvince.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProvinceActionPerformed(evt);
            }
        });
        jToolBar1.add(btProvince);

        btReligion.setText("Tôn giáo");
        btReligion.setFocusable(false);
        btReligion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btReligion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btReligion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReligionActionPerformed(evt);
            }
        });
        jToolBar1.add(btReligion);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeActionPerformed
        new EmployeeList().setVisible(true);
    }//GEN-LAST:event_btEmployeeActionPerformed

    private void btDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepartActionPerformed
        // TODO add your handling code here:
        new DepartmentList().setVisible(true);
    }//GEN-LAST:event_btDepartActionPerformed

    private void btCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCertificateActionPerformed
        // TODO add your handling code here:
        new CertificateList().setVisible(true);
    }//GEN-LAST:event_btCertificateActionPerformed

    private void btEmployeeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmployeeTypeActionPerformed
        // TODO add your handling code here:
        new EmployeeTypeList().setVisible(true);
    }//GEN-LAST:event_btEmployeeTypeActionPerformed

    private void btFolkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFolkActionPerformed
        // TODO add your handling code here:
        new FolkList().setVisible(true);
    }//GEN-LAST:event_btFolkActionPerformed

    private void btForeignLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btForeignLanguageActionPerformed
        // TODO add your handling code here:
        new ForeignLanguageList().setVisible(true);
    }//GEN-LAST:event_btForeignLanguageActionPerformed

    private void btITCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btITCertificateActionPerformed
        // TODO add your handling code here:
        new ITCertificateList().setVisible(true);
    }//GEN-LAST:event_btITCertificateActionPerformed

    private void btJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJobActionPerformed
        // TODO add your handling code here:
        new JobList().setVisible(true);
    }//GEN-LAST:event_btJobActionPerformed

    private void btKnowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKnowledgeActionPerformed
        // TODO add your handling code here:
        new KnowledgeList().setVisible(true);
    }//GEN-LAST:event_btKnowledgeActionPerformed

    private void btNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNationalityActionPerformed
        // TODO add your handling code here:
        new NationalityList().setVisible(true);
    }//GEN-LAST:event_btNationalityActionPerformed

    private void btPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPositionActionPerformed
        // TODO add your handling code here:
        new PositionList().setVisible(true);
    }//GEN-LAST:event_btPositionActionPerformed

    private void btProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProvinceActionPerformed
        // TODO add your handling code here:
        new ProvinceList().setVisible(true);
    }//GEN-LAST:event_btProvinceActionPerformed

    private void btReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReligionActionPerformed
        // TODO add your handling code here:
        new ReligionList().setVisible(true);
    }//GEN-LAST:event_btReligionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCertificate;
    private javax.swing.JButton btDepart;
    private javax.swing.JButton btEmployee;
    private javax.swing.JButton btEmployeeType;
    private javax.swing.JButton btFolk;
    private javax.swing.JButton btForeignLanguage;
    private javax.swing.JButton btITCertificate;
    private javax.swing.JButton btJob;
    private javax.swing.JButton btKnowledge;
    private javax.swing.JButton btNationality;
    private javax.swing.JButton btPosition;
    private javax.swing.JButton btProvince;
    private javax.swing.JButton btReligion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
