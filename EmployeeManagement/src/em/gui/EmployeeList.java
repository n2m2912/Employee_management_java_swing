/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package em.gui;

import em.bll.*;
import em.dto.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAT
 */
public class EmployeeList extends javax.swing.JFrame implements WindowListener{

    public static JButton btE;
    public static JTable tbEm ;
    String btName="";
    Employees emp;
    String id = "";
    DefaultTableModel model;
    EmployeeBLL bll = new EmployeeBLL();
    PositionBLL posBll = new PositionBLL();
    EmployeeTypeBLL emTyBll = new EmployeeTypeBLL();
    DepartmentBLL depBll = new DepartmentBLL();
    /** Creates new form EmployeeList */
    public EmployeeList() {
        initComponents();
        setInfoDialog();
        loadData();
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
        tbEm = tbEmployees;
        btE = btEdit;
    }
    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btPrint = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmployees = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(835, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/em/images/addPeople.png"))); // NOI18N
        btNew.setText("Thêm ");
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btNew);
        jToolBar1.add(jSeparator1);

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/em/images/editPeople.png"))); // NOI18N
        btEdit.setText("Sửa");
        btEdit.setFocusable(false);
        btEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btEdit);
        jToolBar1.add(jSeparator2);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/em/images/delete item.png"))); // NOI18N
        btDelete.setText("Xóa");
        btDelete.setFocusable(false);
        btDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btDelete);
        jToolBar1.add(jSeparator3);

        btPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/em/images/printLarge.png"))); // NOI18N
        btPrint.setText("In");
        btPrint.setFocusable(false);
        btPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btPrint);
        jToolBar1.add(jSeparator4);

        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/em/images/logoutLarge.png"))); // NOI18N
        btExit.setText("Thoát");
        btExit.setFocusable(false);
        btExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jToolBar1.add(btExit);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 80));

        tbEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Họ tên", "Giới tính", "Năm sinh", "Email", "SĐT"
            }
        ));
        tbEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmployees);
        if (tbEmployees.getColumnModel().getColumnCount() > 0) {
            tbEmployees.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbEmployees.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbEmployees.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 830, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        Employee emGui= new Employee();
        emGui.setVisible(true);
    }//GEN-LAST:event_btNewActionPerformed

    private void tbEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmployeesMouseClicked
        // TODO add your handling code here:
        int row = tbEmployees.getSelectedRow();
        id = tbEmployees.getModel().getValueAt(row, 0).toString();
        btEdit.setEnabled(true);
        btDelete.setEnabled(true);
    }//GEN-LAST:event_tbEmployeesMouseClicked

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        Employee empFrame = new Employee(id);
        empFrame.setVisible(true);
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Xác nhận xóa ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            int row = tbEmployees.getSelectedRow();
            id = tbEmployees.getModel().getValueAt(row, 0).toString();
            bll.deleteEmployeeDAL(id);
            model = (DefaultTableModel) tbEmployees.getModel();
            model.removeRow(row);
        }
        btEdit.setEnabled(false);
        btDelete.setEnabled(false);
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btExitActionPerformed

    public void loadData(){
        int row = 0;
        DefaultTableModel model = (DefaultTableModel) tbEmployees.getModel();
        List emps = bll.readEmployeeBll();
        for (Iterator iterator = emps.iterator(); iterator.hasNext();) {
            Employees emp = (Employees) iterator.next();
            model.addRow(new Object[0]);
            model.setValueAt(emp.getId(), row, 0);
            model.setValueAt(emp.getFullName(), row, 1);
            if(emp.getGender())
                model.setValueAt("Nữ", row, 2);
            else
                model.setValueAt("Nam", row, 2);
            
            SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
            if(emp.getDateOfBirth()== null){
                model.setValueAt(emp.getDateOfBirth(),row,3);
            }else
                model.setValueAt(mdyFormat.format(emp.getDateOfBirth()),row,3);
            
            model.setValueAt(emp.getEmail(),row,4);
            model.setValueAt(emp.getMobileNumber(),row,5);
            row++;
        } 
    }
    
    
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
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbEmployees;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
