/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package em.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "employee_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTypes.findAll", query = "SELECT e FROM EmployeeTypes e")
    , @NamedQuery(name = "EmployeeTypes.findById", query = "SELECT e FROM EmployeeTypes e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeTypes.findByTypeName", query = "SELECT e FROM EmployeeTypes e WHERE e.typeName = :typeName")})
public class EmployeeTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Type_Name")
    private String typeName;
    @OneToMany(mappedBy = "employeeTypeID")
    private Collection<Employees> employeesCollection;

    public EmployeeTypes() {
    }

    public EmployeeTypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeTypes(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeTypes(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTypes)) {
            return false;
        }
        EmployeeTypes other = (EmployeeTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.EmployeeTypes[ id=" + id + " ]";
    }
    
}
