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
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author NAT
 */
public class Employee extends javax.swing.JFrame {

    String btName = "";
    String id = "";
    DefaultTableModel model;
    EmployeeBLL employeeBLL = new EmployeeBLL();
    CertificatesBLL  certificatesBLL = new CertificatesBLL();
    DepartmentBLL departmentBLL = new DepartmentBLL();
    EmployeeTypeBLL employeeTypeBLL = new EmployeeTypeBLL();
    FolkBLL folkBLL = new FolkBLL();
    ForeignLanguageBLL foreignLanguageBLL = new ForeignLanguageBLL();
    ITCertificateBLL iTCertificateBLL = new ITCertificateBLL();
    JobBLL jobBLL = new JobBLL();
    KnowledgeBLL knowledgeBLL = new KnowledgeBLL();
    NationalitiesBLL nationalitiesBLL = new NationalitiesBLL();
    PositionBLL positionBLL = new PositionBLL();
    ProvinceBLL provinceBLL = new ProvinceBLL();
    ReligionBLL religionBLL = new ReligionBLL();
    
    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        setInfoDialog();
        txtEmID.setEnabled(true);
        initData();
    }

    
    public Employee(String id) {
        this.id = id;
        btName="Edit";
        
        initComponents();
        setInfoDialog();
        initData();
        loadEmployee(id);
        txtEmID.setEnabled(false);
    }
    
    public void loadEmployee(String id){
        Employees emp = employeeBLL.findEmployeeBll(id);
        txtEmID.setText(emp.getId());
        txtFullName.setText(emp.getFullName());
        txtSecretName.setText(emp.getSecretName());
        if(emp.getGender())
            ckbGender.setSelected(true);
        else
            ckbGender.setSelected(false);
        if(emp.getMaritalStatus())
            ckbMaritalStatus.setSelected(true);
        else
            ckbMaritalStatus.setSelected(false);
        txtMobileNumber.setText(emp.getMobileNumber());
        txtPhoneNumber.setText(emp.getPhoneNumber());
        txtEmail.setText(emp.getEmail());
        jdcDateOfBirth.setDate(emp.getDateOfBirth());
        txtPlaceOfBirth.setText(emp.getPlaceOfBirth());
        cbProvince.setSelectedIndex(emp.getPronvinceID().getId()-1);
        txtIdentityNumber.setText(emp.getIdentityNumber());
        jdcDateOfIDRegister.setDate(emp.getDateOfIDRegistered());
        txtPlaceOfRegister.setText(emp.getPlaceOfIDRegistered());
        txtHomeTown.setText(emp.getHomeTown());
        txtAddress.setText(emp.getHomeTown());
        txtTemporaryResidence.setText(emp.getTemporaryResidence());
        cbEmployeeType.setSelectedIndex(emp.getEmployeeTypeID().getId()-1);
        jdcStartWorkingDate.setDate(emp.getStartWorkingDate());
        cbDepartment.setSelectedIndex(emp.getDepartmentID().getId()-1);
        cbJob.setSelectedIndex(emp.getJobID().getId()-1);
        cbPosition.setSelectedIndex(emp.getPositionID().getId()-1);
        if(emp.getBasicSalary()==null){
            txtBasicSalary.setText("");
        }else
            txtBasicSalary.setText(emp.getBasicSalary().toString());
        if(emp.getCoefficient() == null){
            txtCoefficient.setText("");
        }else
            txtCoefficient.setText(emp.getCoefficient().toString());
         if(emp.getSalary() == null){
            txtSalary.setText("");
        }else
            txtSalary.setText(emp.getSalary().toString());
         if(emp.getAllowance() == null){
            txtAllowance.setText("");
        }else
            txtAllowance.setText(emp.getAllowance().toString());
        txtLabourNumber.setText(emp.getLabourNumber());
        jdcDateOfLabourRegistered.setDate(emp.getDateOfLabourRegistered());
        txtPlaceOfLabourRegistered.setText(emp.getPlaceOfLabourRegistered());
        txtBankAccount.setText(emp.getBankAccount());
        txtBank.setText(emp.getBank());
        cbKnowledge.setSelectedIndex(emp.getKnowledgeID().getId()-1);
        cbCertificate.setSelectedIndex(emp.getCertificateID().getId()-1);
        cbForeighnLanguage.setSelectedIndex(emp.getForeignLanguageID().getId()-1);
        cbITCertificate.setSelectedIndex(emp.getiTCertificateID().getId()-1);
        cbFolk.setSelectedIndex(emp.getFolkID().getId()-1);
        cbNationality.setSelectedIndex(emp.getNationalityID().getId()-1);
        cbReligion.setSelectedIndex(emp.getReligionID().getId()-1);
    }
    
    public  void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);        
        setResizable(false);
    }
    
    public void initData(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        List<Provinces> listProvinces = provinceBLL.readProvincesBll();
        for (Iterator iterator = listProvinces.iterator(); iterator.hasNext();) {
            Provinces prov = (Provinces)iterator.next();
            model.addElement(new Item(prov.getId(),prov.getProvinceName()));
        }
        cbProvince.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<EmployeeTypes> listEmployeeTypes = employeeTypeBLL.readEmployeeTypeBll();
        for (Iterator iterator = listEmployeeTypes.iterator(); iterator.hasNext();) {
             EmployeeTypes emType = (EmployeeTypes)iterator.next();
             model.addElement(new Item(emType.getId(),emType.getTypeName()));
        }
        cbEmployeeType.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Departments> listDepartments = departmentBLL.readDepartmentBll();
        for (Iterator iterator = listDepartments.iterator(); iterator.hasNext();) {
             Departments departs = (Departments)iterator.next();
             model.addElement(new Item(departs.getId(),departs.getDepartmentName()));
        }
        cbDepartment.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Jobs> listJobs = jobBLL.readJobsBll();
        for (Iterator iterator = listJobs.iterator(); iterator.hasNext();) {
             Jobs jobs = (Jobs)iterator.next();
             model.addElement(new Item(jobs.getId(),jobs.getJobName()));
        }
        cbJob.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Positions> listPositions = positionBLL.readPositionsBll();
        for (Iterator iterator = listPositions.iterator(); iterator.hasNext();) {
             Positions positions = (Positions)iterator.next();
             model.addElement(new Item(positions.getId(),positions.getPositionName()));
        }
         cbPosition.setModel(model);
        
         
        model = new DefaultComboBoxModel();
        List<Knowledges> listKnowledges = knowledgeBLL.readKnowledgesBll();
        for (Iterator iterator = listKnowledges.iterator(); iterator.hasNext();) {
             Knowledges knowledges = (Knowledges)iterator.next();
             model.addElement(new Item(knowledges.getId(),knowledges.getKnowledgeName()));
        }
        cbKnowledge.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Certificates> listCertificates = certificatesBLL.readCertificateBll();
        for (Iterator iterator = listCertificates.iterator(); iterator.hasNext();) {
             Certificates certificates = (Certificates)iterator.next();
             model.addElement(new Item(certificates.getId(),certificates.getCertificateName()));
        }
        cbCertificate.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<ForeignLanguages> listForeignLanguages = foreignLanguageBLL.readForeignLanguagesBll();
        for (Iterator iterator = listForeignLanguages.iterator(); iterator.hasNext();) {
             ForeignLanguages foreignLanguages = (ForeignLanguages)iterator.next();
             model.addElement(new Item(foreignLanguages.getId(),foreignLanguages.getLanguageName()));
        }
        cbForeighnLanguage.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<ItCertificates> listItCertificates = iTCertificateBLL.readItCertificatesBll();
        for (Iterator iterator = listItCertificates.iterator(); iterator.hasNext();) {
             ItCertificates itCertificates = (ItCertificates)iterator.next();
             model.addElement(new Item(itCertificates.getId(),itCertificates.getITName()));
        }
        cbITCertificate.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Folks> listFolks = folkBLL.readFolksBll();
        for (Iterator iterator = listFolks.iterator(); iterator.hasNext();) {
             Folks folks = (Folks)iterator.next();
             model.addElement(new Item(folks.getId(),folks.getFolkName()));
        }
        cbFolk.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Nationalities> listNationalities = nationalitiesBLL.readNationalitiesBll();
        for (Iterator iterator = listNationalities.iterator(); iterator.hasNext();) {
             Nationalities nationalities = (Nationalities)iterator.next();
             model.addElement(new Item(nationalities.getId(),nationalities.getNationalityName()));
        }
        cbNationality.setModel(model);
        
        model = new DefaultComboBoxModel();
        List<Religions> listReligions = religionBLL.readReligionsBll();
        for (Iterator iterator = listReligions.iterator(); iterator.hasNext();) {
             Religions religions = (Religions)iterator.next();
             model.addElement(new Item(religions.getId(),religions.getReligionName()));
        }
        cbReligion.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtBasicSalary = new javax.swing.JTextField();
        txtLabourNumber = new javax.swing.JTextField();
        txtBankAccount = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCoefficient = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtPlaceOfLabourRegistered = new javax.swing.JTextField();
        txtBank = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtAllowance = new javax.swing.JTextField();
        jdcDateOfLabourRegistered = new com.toedter.calendar.JDateChooser();
        jdcStartWorkingDate = new com.toedter.calendar.JDateChooser();
        cbEmployeeType = new javax.swing.JComboBox<>();
        cbDepartment = new javax.swing.JComboBox<>();
        cbPosition = new javax.swing.JComboBox<>();
        cbJob = new javax.swing.JComboBox<>();
        cbKnowledge = new javax.swing.JComboBox<>();
        cbCertificate = new javax.swing.JComboBox<>();
        cbForeighnLanguage = new javax.swing.JComboBox<>();
        cbFolk = new javax.swing.JComboBox<>();
        cbNationality = new javax.swing.JComboBox<>();
        cbITCertificate = new javax.swing.JComboBox<>();
        cbReligion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtEmID = new javax.swing.JTextField();
        txtMobileNumber = new javax.swing.JTextField();
        txtIdentityNumber = new javax.swing.JTextField();
        txtHomeTown = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtTemporaryResidence = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtPlaceOfBirth = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtSecretName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPlaceOfRegister = new javax.swing.JTextField();
        ckbGender = new javax.swing.JCheckBox();
        ckbMaritalStatus = new javax.swing.JCheckBox();
        jdcDateOfBirth = new com.toedter.calendar.JDateChooser();
        jdcDateOfIDRegister = new com.toedter.calendar.JDateChooser();
        cbProvince = new javax.swing.JComboBox<>();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 520));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 180));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel17.setBackground(new java.awt.Color(0, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Thông tin công việc");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Loại nhân viên (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel18, gridBagConstraints);

        jLabel19.setText("Công việc (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Mức lương CB (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Số sổ lao động");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel21, gridBagConstraints);

        jLabel22.setText("TK.Ngân hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Học vấn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel23, gridBagConstraints);

        jLabel24.setText("Ngoại ngữ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel24, gridBagConstraints);

        jLabel25.setText("Dân tộc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel25, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtBasicSalary, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtLabourNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtBankAccount, gridBagConstraints);

        jLabel26.setText("Ngày vào làm (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel26, gridBagConstraints);

        jLabel27.setText("Hệ số (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel27, gridBagConstraints);

        jLabel28.setText("Ngày cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel28, gridBagConstraints);

        jLabel29.setText("Quốc tịch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel29, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtCoefficient, gridBagConstraints);

        jLabel30.setText("Phòng ban (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel30, gridBagConstraints);

        jLabel31.setText("Chức vụ (*)");
        jLabel31.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel31, gridBagConstraints);

        jLabel32.setText("Mức lương");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel32, gridBagConstraints);

        jLabel33.setText("Nơi cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel33, gridBagConstraints);

        jLabel34.setText("Ngân hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel34, gridBagConstraints);

        jLabel35.setText("Bằng cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel35, gridBagConstraints);

        jLabel36.setText("Tin học");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel36, gridBagConstraints);

        jLabel37.setText("Tôn giáo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel37, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtPlaceOfLabourRegistered, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtBank, gridBagConstraints);

        txtSalary.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtSalary, gridBagConstraints);

        jLabel38.setText("Phụ cấp lương");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jLabel38, gridBagConstraints);

        txtAllowance.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(txtAllowance, gridBagConstraints);

        jdcDateOfLabourRegistered.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jdcDateOfLabourRegistered, gridBagConstraints);

        jdcStartWorkingDate.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jdcStartWorkingDate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbEmployeeType, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbDepartment, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbPosition, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbJob, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbKnowledge, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbCertificate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbForeighnLanguage, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbFolk, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbNationality, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbITCertificate, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(cbReligion, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 211));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel39.setBackground(new java.awt.Color(0, 255, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Thông tin cá nhân");
        jLabel39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel39, gridBagConstraints);

        jLabel40.setText("Mã nhân viên (*)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel40, gridBagConstraints);

        jLabel41.setText("Di động");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel41, gridBagConstraints);

        jLabel42.setText("Ngày sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel42, gridBagConstraints);

        jLabel43.setText("CMND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel43, gridBagConstraints);

        jLabel44.setText("Quê quán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel44, gridBagConstraints);

        jLabel45.setText("Địa chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel45, gridBagConstraints);

        jLabel46.setText("Tạm trú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel46, gridBagConstraints);

        jLabel47.setText("Họ tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel47, gridBagConstraints);

        jLabel48.setText("Điện thoại nhà");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel48, gridBagConstraints);

        jLabel49.setText("Nơi sinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel49, gridBagConstraints);

        jLabel50.setText("Ngày cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel50, gridBagConstraints);

        txtEmID.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtEmID, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtMobileNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtIdentityNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtHomeTown, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtAddress, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtTemporaryResidence, gridBagConstraints);

        txtFullName.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtFullName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtPhoneNumber, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtPlaceOfBirth, gridBagConstraints);

        jLabel51.setText("Bí danh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel51, gridBagConstraints);

        jLabel52.setText("Địa chỉ email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Tỉnh thành");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel53, gridBagConstraints);

        jLabel54.setText("Nơi cấp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jLabel54, gridBagConstraints);

        txtSecretName.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtSecretName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(txtPlaceOfRegister, gridBagConstraints);

        ckbGender.setBackground(new java.awt.Color(153, 255, 255));
        ckbGender.setText("Nữ");
        ckbGender.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(ckbGender, gridBagConstraints);

        ckbMaritalStatus.setBackground(new java.awt.Color(153, 255, 255));
        ckbMaritalStatus.setText("Có gia đình");
        ckbMaritalStatus.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(ckbMaritalStatus, gridBagConstraints);

        jdcDateOfBirth.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jdcDateOfBirth, gridBagConstraints);

        jdcDateOfIDRegister.setDateFormatString("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jdcDateOfIDRegister, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(cbProvince, gridBagConstraints);

        btSave.setBackground(new java.awt.Color(0, 255, 0));
        btSave.setText("Lưu");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(255, 0, 0));
        btCancel.setText("Hủy");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(553, Short.MAX_VALUE)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(475, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        Boolean error = false;
        String idEm = txtEmID.getText();
        if(idEm.length()>=5){
             JOptionPane.showMessageDialog(null, "Id <= 4 ký tự");
             error = true;
        }
        if(idEm.isEmpty()){
            JOptionPane.showMessageDialog(null, "Id không được rỗng");
            error = true;
        }
        if( btName == ""){
            for (int i=0;i<EmployeeList.tbEm.getRowCount();i++){
                if(idEm.equals(EmployeeList.tbEm.getModel().getValueAt(i,0).toString())){
                    JOptionPane.showMessageDialog(null, "Id đã tồn tại");
                    error = true;  
                }
            }
        }
        
        String fullName = txtFullName.getText();
        if(fullName.matches(".*\\d+.*")){
            JOptionPane.showMessageDialog(null, "Tên không chứa số");
            error = true;
        }
        if(fullName.isEmpty()){
            JOptionPane.showMessageDialog(null, "Tên không được rỗng");
            error = true;
        }
        String secretName = txtSecretName.getText();
        Boolean gender = ckbGender.isSelected();
        Boolean mariatalStatus = ckbMaritalStatus.isSelected();
        String mobileNumber = txtMobileNumber.getText();
        if(mobileNumber.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "SDT không chứa chữ cái");
            error = true;
        }
        String phoneNumber = txtPhoneNumber.getText();
        if(phoneNumber.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "SDT không chứa chữ cái");
            error = true;
        }
        Date dateOfBirth = null;
        String email = txtEmail.getText();
        if(jdcDateOfBirth.getDate() == null){
             dateOfBirth = null;
        }else {
             dateOfBirth = jdcDateOfBirth.getDate();
        }
        String placeOfBirth = txtPlaceOfBirth.getText();
        Item item = (Item) cbProvince.getSelectedItem();
        Provinces province = new Provinces(item.getId());
        
        String identityNumber = txtIdentityNumber.getText();
        if(mobileNumber.matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "CMND không chứa chữ cái");
            error = true;
        }
         Date dateOfIDRegistered = null;
        if(jdcDateOfIDRegister.getDate() == null){
             dateOfIDRegistered = null;
        }else{
             dateOfIDRegistered = jdcDateOfIDRegister.getDate();
        }
        String placeOfIDRegistered = txtPlaceOfRegister.getText();
        String homeTown = txtHomeTown.getText();
        String address = txtAddress.getText();
        String temporaryResidence = txtTemporaryResidence.getText();
        item = (Item) cbEmployeeType.getSelectedItem();
        EmployeeTypes employeeType = new EmployeeTypes(item.getId());
        Date startWorkingDate = null;
        if(jdcStartWorkingDate.getDate() == null){
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu không được rỗng");
            error = true;
        }else{
            startWorkingDate = jdcStartWorkingDate.getDate();
        }
        item = (Item) cbDepartment.getSelectedItem();
        Departments department = new Departments(item.getId());
        item = (Item) cbJob.getSelectedItem();
        Jobs job = new Jobs(item.getId());
        item = (Item) cbPosition.getSelectedItem();
        Positions position = new Positions(item.getId());
        BigInteger basicSalary = BigInteger.valueOf(0);
        if(txtBasicSalary.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lương cơ bản không được rỗng");
            error = true;
        }else if(txtBasicSalary.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Số tiền không chứa chữ cái");
            error = true;
        }else {
              basicSalary = BigInteger.valueOf(Integer.valueOf(txtBasicSalary.getText()));
        }
        Float coefficient = 0f;
        if(txtCoefficient.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Số tiền không chứa chữ cái");
            error = true;
        }else if(txtCoefficient.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Hệ số không được rỗng");
            error = true;
        }else{
            coefficient = Float.valueOf(txtCoefficient.getText());
        }
         BigInteger salary = BigInteger.valueOf(0);
        if(txtSalary.getText().isEmpty()){
            salary = BigInteger.valueOf(0);
        } else if(txtSalary.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Số tiền không chứa chữ cái");
            error = true;
        } else{
             salary = BigInteger.valueOf(Integer.valueOf(txtSalary.getText()));
        }
         BigInteger allowance = BigInteger.valueOf(0);
         if(txtAllowance.getText().isEmpty()){
            allowance = BigInteger.valueOf(0);
        } else if(txtAllowance.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Số tiền không chứa chữ cái");
            error = true;
        } else{
             allowance = BigInteger.valueOf(Integer.valueOf(txtAllowance.getText()));
        }
        Date dateOfLabourRegistered=null;
        String labourNumber = txtLabourNumber.getText();
         if(jdcDateOfLabourRegistered.getDate() == null){
            dateOfLabourRegistered = null;
        }else{
            dateOfLabourRegistered = jdcDateOfLabourRegistered.getDate();
         }
         
        String placeOfLabourRegistered = txtPlaceOfLabourRegistered.getText();
        String bankAccount = txtBankAccount.getText();
        if(txtBankAccount.getText().matches("[a-zA-Z]+")){
            JOptionPane.showMessageDialog(null, "Tài khoản không chứa chữ cái");
            error = true;
        }
        String bank = txtBank.getText();
        item = (Item) cbKnowledge.getSelectedItem();
        Knowledges knowledge = new Knowledges(item.getId());
        item = (Item) cbCertificate.getSelectedItem();
        Certificates certificate = new Certificates(item.getId());
        item = (Item) cbForeighnLanguage.getSelectedItem();
        ForeignLanguages foreignLaguage = new ForeignLanguages(item.getId());
        item = (Item) cbITCertificate.getSelectedItem();
        ItCertificates iTCertificate = new ItCertificates(item.getId());
        item = (Item) cbFolk.getSelectedItem();
        Folks folk = new Folks(item.getId());
        item = (Item) cbNationality.getSelectedItem();
        Nationalities nationality =new Nationalities(item.getId());
        item = (Item) cbReligion.getSelectedItem();
        Religions religion = new Religions(item.getId());
        
        Employees employeeModel = new Employees(idEm,fullName,secretName,gender,mariatalStatus,mobileNumber,phoneNumber,email,dateOfBirth,placeOfBirth,province,identityNumber,dateOfIDRegistered,placeOfIDRegistered,homeTown,address,temporaryResidence,employeeType,startWorkingDate,department,job,position,basicSalary,coefficient,salary,allowance,labourNumber,dateOfLabourRegistered,placeOfLabourRegistered,bankAccount,bank,knowledge,foreignLaguage,folk,certificate,iTCertificate,nationality,religion);
        if(btName == "" && !error){
            employeeBLL.addNewEmployeeDAL(employeeModel);
            editTableData(employeeModel,btName);
        }
        else if(btName == "Edit" && !error){
            
            employeeBLL.editEmployeeDAL(employeeModel);
            editTableData(employeeModel,btName);
        }
         
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    public void editTableData(Employees emp,String btName){
        int row = 0; 
        DefaultTableModel model = (DefaultTableModel) EmployeeList.tbEm.getModel();
        if (btName == "Edit"){
            row = EmployeeList.tbEm.getSelectedRow();
        }
        if (btName ==""){
            row = EmployeeList.tbEm.getRowCount();
            model.addRow(new Object[0]);
        }
        model.setValueAt(emp.getId(), row, 0);
        model.setValueAt(emp.getFullName(), row, 1);
        if(emp.getGender())
            model.setValueAt("Nữ", row, 2);
        else
            model.setValueAt("Nam", row, 2);
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(emp.getDateOfBirth()==null){
            model.setValueAt(emp.getDateOfBirth(), row, 3);
        }else{
            model.setValueAt(mdyFormat.format(emp.getDateOfBirth()), row, 3);
        }
        model.setValueAt(emp.getPlaceOfBirth(),row,4);
        EmployeeList.btE.setEnabled(false);
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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox<String> cbCertificate;
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbEmployeeType;
    private javax.swing.JComboBox<String> cbFolk;
    private javax.swing.JComboBox<String> cbForeighnLanguage;
    private javax.swing.JComboBox<String> cbITCertificate;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JComboBox<String> cbKnowledge;
    private javax.swing.JComboBox<String> cbNationality;
    private javax.swing.JComboBox<String> cbPosition;
    private javax.swing.JComboBox<String> cbProvince;
    private javax.swing.JComboBox<String> cbReligion;
    private javax.swing.JCheckBox ckbGender;
    private javax.swing.JCheckBox ckbMaritalStatus;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdcDateOfBirth;
    private com.toedter.calendar.JDateChooser jdcDateOfIDRegister;
    private com.toedter.calendar.JDateChooser jdcDateOfLabourRegistered;
    private com.toedter.calendar.JDateChooser jdcStartWorkingDate;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAllowance;
    private javax.swing.JTextField txtBank;
    private javax.swing.JTextField txtBankAccount;
    private javax.swing.JTextField txtBasicSalary;
    private javax.swing.JTextField txtCoefficient;
    private javax.swing.JTextField txtEmID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtHomeTown;
    private javax.swing.JTextField txtIdentityNumber;
    private javax.swing.JTextField txtLabourNumber;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPlaceOfBirth;
    private javax.swing.JTextField txtPlaceOfLabourRegistered;
    private javax.swing.JTextField txtPlaceOfRegister;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSecretName;
    private javax.swing.JTextField txtTemporaryResidence;
    // End of variables declaration//GEN-END:variables
}
