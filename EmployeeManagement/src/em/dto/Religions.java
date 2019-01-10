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
@Table(name = "religions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religions.findAll", query = "SELECT r FROM Religions r")
    , @NamedQuery(name = "Religions.findById", query = "SELECT r FROM Religions r WHERE r.id = :id")
    , @NamedQuery(name = "Religions.findByReligionName", query = "SELECT r FROM Religions r WHERE r.religionName = :religionName")})
public class Religions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Religion_Name")
    private String religionName;
    @OneToMany(mappedBy = "religionID")
    private Collection<Employees> employeesCollection;

    public Religions() {
    }

    public Religions(Integer id) {
        this.id = id;
    }

    public Religions(Integer id, String religionName) {
        this.id = id;
        this.religionName = religionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Religions(String religionName) {
        this.religionName = religionName;
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
        if (!(object instanceof Religions)) {
            return false;
        }
        Religions other = (Religions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Religions[ id=" + id + " ]";
    }
    
}
