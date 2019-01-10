/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manng
 */
@Entity
@Table(name="employees")
public class Employees implements Serializable{
    @Id
    @Column(name = "ID")
    @Basic(optional = false)
    private String id;
    @Column(name = "Full_Name")
    @Basic(optional = false)
    private String fullName;
    @Column(name = "Secret_Name")
    private String secretName;
    @Column(name = "Gender")
    private Boolean gender;
    @Column(name = "Marital_Status")
    private Boolean maritalStatus;
    @Column(name = "Mobile_Number")
    private String mobileNumber;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "Date_Of_Birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "Place_Of_Birth")
    private String placeOfBirth;
    @JoinColumn(name = "Pronvince_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Provinces.class)
    private Provinces pronvinceID;
    @Column(name = "Identity_Number")
    private String identityNumber;
    @Column(name = "Date_Of_ID_Registered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIDRegistered;
    @Column(name = "Place_Of_ID_Registered")
    private String placeOfIDRegistered;
    @Column(name = "Home_Town")
    private String homeTown;
    @Column(name = "Address")
    private String address;
    @Column(name = "Temporary_Residence")
    private String temporaryResidence;
    @JoinColumn(name = "Employee_Type_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = EmployeeTypes.class)
    @Basic(optional = false)
    private EmployeeTypes employeeTypeID;
    @Column(name = "Start_Working_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    private Date startWorkingDate;
    @JoinColumn(name = "Department_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Departments.class)
    @Basic(optional = false)
    private Departments departmentID;
    @JoinColumn(name = "Job_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Jobs.class)
    @Basic(optional = false)
    private Jobs jobID;
    @JoinColumn(name = "Position_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Positions.class)
    @Basic(optional = false)
    private Positions positionID;
    @Column(name = "Basic_Salary")
    @Basic(optional = false)
    private BigInteger basicSalary;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Coefficient")
    @Basic(optional = false)
    private Float coefficient;
    @Column(name = "Salary")
    private BigInteger salary;
    @Column(name = "Allowance")
    private BigInteger allowance;
    @Column(name = "Labour_Number")
    private String labourNumber;
    @Column(name = "Date_Of_Labour_Registered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfLabourRegistered;
    @Column(name = "Place_Of_Labour_Registered")
    private String placeOfLabourRegistered;
    @Column(name = "Bank_Account")
    private String bankAccount;
    @Column(name = "Bank")
    private String bank;
    @JoinColumn(name = "Knowledge_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Knowledges.class)
    private Knowledges knowledgeID;
    @JoinColumn(name = "Foreign_Language_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = ForeignLanguages.class)
    private ForeignLanguages foreignLanguageID;
    @JoinColumn(name = "Folk_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Folks.class)
    private Folks folkID;
    @JoinColumn(name = "Certificate_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Certificates.class)
    private Certificates certificateID;
    @JoinColumn(name = "IT_Certificate_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = ItCertificates.class)
    private ItCertificates iTCertificateID;
    @JoinColumn(name = "Nationality_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Nationalities.class)
    private Nationalities nationalityID;
    @JoinColumn(name = "Religion_ID", referencedColumnName = "ID")
    @ManyToOne(targetEntity = Religions.class)
    private Religions religionID;

    public Employees() {
    }

    public Employees(String id, String fullName, String secretName, Boolean gender, Boolean maritalStatus, String mobileNumber, String phoneNumber, String email, Date dateOfBirth, String placeOfBirth, Provinces pronvinceID, String identityNumber, Date dateOfIDRegistered, String placeOfIDRegistered, String homeTown, String address, String temporaryResidence, EmployeeTypes employeeTypeID, Date startWorkingDate, Departments departmentID, Jobs jobID, Positions positionID, BigInteger basicSalary, Float coefficient, BigInteger salary, BigInteger allowance, String labourNumber, Date dateOfLabourRegistered, String placeOfLabourRegistered, String bankAccount, String bank, Knowledges knowledgeID, ForeignLanguages foreignLanguageID, Folks folkID, Certificates certificateID, ItCertificates iTCertificateID, Nationalities nationalityID, Religions religionID) {
        this.id = id;
        this.fullName = fullName;
        this.secretName = secretName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.mobileNumber = mobileNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.pronvinceID = pronvinceID;
        this.identityNumber = identityNumber;
        this.dateOfIDRegistered = dateOfIDRegistered;
        this.placeOfIDRegistered = placeOfIDRegistered;
        this.homeTown = homeTown;
        this.address = address;
        this.temporaryResidence = temporaryResidence;
        this.employeeTypeID = employeeTypeID;
        this.startWorkingDate = startWorkingDate;
        this.departmentID = departmentID;
        this.jobID = jobID;
        this.positionID = positionID;
        this.basicSalary = basicSalary;
        this.coefficient = coefficient;
        this.salary = salary;
        this.allowance = allowance;
        this.labourNumber = labourNumber;
        this.dateOfLabourRegistered = dateOfLabourRegistered;
        this.placeOfLabourRegistered = placeOfLabourRegistered;
        this.bankAccount = bankAccount;
        this.bank = bank;
        this.knowledgeID = knowledgeID;
        this.foreignLanguageID = foreignLanguageID;
        this.folkID = folkID;
        this.certificateID = certificateID;
        this.iTCertificateID = iTCertificateID;
        this.nationalityID = nationalityID;
        this.religionID = religionID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Provinces getPronvinceID() {
        return pronvinceID;
    }

    public void setPronvinceID(Provinces pronvinceID) {
        this.pronvinceID = pronvinceID;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getDateOfIDRegistered() {
        return dateOfIDRegistered;
    }

    public void setDateOfIDRegistered(Date dateOfIDRegistered) {
        this.dateOfIDRegistered = dateOfIDRegistered;
    }

    public String getPlaceOfIDRegistered() {
        return placeOfIDRegistered;
    }

    public void setPlaceOfIDRegistered(String placeOfIDRegistered) {
        this.placeOfIDRegistered = placeOfIDRegistered;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTemporaryResidence() {
        return temporaryResidence;
    }

    public void setTemporaryResidence(String temporaryResidence) {
        this.temporaryResidence = temporaryResidence;
    }

    public EmployeeTypes getEmployeeTypeID() {
        return employeeTypeID;
    }

    public void setEmployeeTypeID(EmployeeTypes employeeTypeID) {
        this.employeeTypeID = employeeTypeID;
    }

    public Date getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(Date startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public Departments getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Departments departmentID) {
        this.departmentID = departmentID;
    }

    public Jobs getJobID() {
        return jobID;
    }

    public void setJobID(Jobs jobID) {
        this.jobID = jobID;
    }

    public Positions getPositionID() {
        return positionID;
    }

    public void setPositionID(Positions positionID) {
        this.positionID = positionID;
    }

    public BigInteger getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigInteger basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public BigInteger getAllowance() {
        return allowance;
    }

    public void setAllowance(BigInteger allowance) {
        this.allowance = allowance;
    }

    public String getLabourNumber() {
        return labourNumber;
    }

    public void setLabourNumber(String labourNumber) {
        this.labourNumber = labourNumber;
    }

    public Date getDateOfLabourRegistered() {
        return dateOfLabourRegistered;
    }

    public void setDateOfLabourRegistered(Date dateOfLabourRegistered) {
        this.dateOfLabourRegistered = dateOfLabourRegistered;
    }

    public String getPlaceOfLabourRegistered() {
        return placeOfLabourRegistered;
    }

    public void setPlaceOfLabourRegistered(String placeOfLabourRegistered) {
        this.placeOfLabourRegistered = placeOfLabourRegistered;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Knowledges getKnowledgeID() {
        return knowledgeID;
    }

    public void setKnowledgeID(Knowledges knowledgeID) {
        this.knowledgeID = knowledgeID;
    }

    public ForeignLanguages getForeignLanguageID() {
        return foreignLanguageID;
    }

    public void setForeignLanguageID(ForeignLanguages foreignLanguageID) {
        this.foreignLanguageID = foreignLanguageID;
    }

    public Folks getFolkID() {
        return folkID;
    }

    public void setFolkID(Folks folkID) {
        this.folkID = folkID;
    }

    public Certificates getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(Certificates certificateID) {
        this.certificateID = certificateID;
    }

    public ItCertificates getiTCertificateID() {
        return iTCertificateID;
    }

    public void setiTCertificateID(ItCertificates iTCertificateID) {
        this.iTCertificateID = iTCertificateID;
    }

    public Nationalities getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(Nationalities nationalityID) {
        this.nationalityID = nationalityID;
    }

    public Religions getReligionID() {
        return religionID;
    }

    public void setReligionID(Religions religionID) {
        this.religionID = religionID;
    }
}
