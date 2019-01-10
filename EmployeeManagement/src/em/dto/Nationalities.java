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
@Table(name = "nationalities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationalities.findAll", query = "SELECT n FROM Nationalities n")
    , @NamedQuery(name = "Nationalities.findById", query = "SELECT n FROM Nationalities n WHERE n.id = :id")
    , @NamedQuery(name = "Nationalities.findByNationalityName", query = "SELECT n FROM Nationalities n WHERE n.nationalityName = :nationalityName")})
public class Nationalities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nationality_Name")
    private String nationalityName;
    @OneToMany(mappedBy = "nationalityID")
    private Collection<Employees> employeesCollection;

    public Nationalities(Integer id, String nationalityName) {
        this.id = id;
        this.nationalityName = nationalityName;
    }

    public Nationalities() {
    }

    public Nationalities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
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
        if (!(object instanceof Nationalities)) {
            return false;
        }
        Nationalities other = (Nationalities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Nationalities(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    @Override
    public String toString() {
        return "test.Nationalities[ id=" + id + " ]";
    }
    
}
