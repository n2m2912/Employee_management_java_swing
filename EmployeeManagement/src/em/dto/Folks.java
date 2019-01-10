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
@Table(name = "folks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Folks.findAll", query = "SELECT f FROM Folks f")
    , @NamedQuery(name = "Folks.findById", query = "SELECT f FROM Folks f WHERE f.id = :id")
    , @NamedQuery(name = "Folks.findByFolkName", query = "SELECT f FROM Folks f WHERE f.folkName = :folkName")})
public class Folks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Folk_Name")
    private String folkName;
    @OneToMany(mappedBy = "folkID")
    private Collection<Employees> employeesCollection;

    public Folks() {
    }

    public Folks(Integer id, String folkName) {
        this.id = id;
        this.folkName = folkName;
    }

    public Folks(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolkName() {
        return folkName;
    }

    public void setFolkName(String folkName) {
        this.folkName = folkName;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Folks(String folkName) {
        this.folkName = folkName;
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
        if (!(object instanceof Folks)) {
            return false;
        }
        Folks other = (Folks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Folks[ id=" + id + " ]";
    }
    
}
