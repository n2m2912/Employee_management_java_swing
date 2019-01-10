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
@Table(name = "it_certificates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItCertificates.findAll", query = "SELECT i FROM ItCertificates i")
    , @NamedQuery(name = "ItCertificates.findById", query = "SELECT i FROM ItCertificates i WHERE i.id = :id")
    , @NamedQuery(name = "ItCertificates.findByITName", query = "SELECT i FROM ItCertificates i WHERE i.iTName = :iTName")})
public class ItCertificates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IT_Name")
    private String iTName;
    @OneToMany(mappedBy = "iTCertificateID")
    private Collection<Employees> employeesCollection;

    public ItCertificates() {
    }

    public ItCertificates(Integer id, String iTName) {
        this.id = id;
        this.iTName = iTName;
    }

    public ItCertificates(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getITName() {
        return iTName;
    }

    public void setITName(String iTName) {
        this.iTName = iTName;
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
        if (!(object instanceof ItCertificates)) {
            return false;
        }
        ItCertificates other = (ItCertificates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.ItCertificates[ id=" + id + " ]";
    }

    public ItCertificates(String iTName) {
        this.iTName = iTName;
    }
    
}
