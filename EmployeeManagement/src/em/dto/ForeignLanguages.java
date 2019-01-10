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
@Table(name = "foreign_languages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForeignLanguages.findAll", query = "SELECT f FROM ForeignLanguages f")
    , @NamedQuery(name = "ForeignLanguages.findById", query = "SELECT f FROM ForeignLanguages f WHERE f.id = :id")
    , @NamedQuery(name = "ForeignLanguages.findByLanguageName", query = "SELECT f FROM ForeignLanguages f WHERE f.languageName = :languageName")})
public class ForeignLanguages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Language_Name")
    private String languageName;
    @OneToMany(mappedBy = "foreignLanguageID")
    private Collection<Employees> employeesCollection;

    public ForeignLanguages() {
    }

    public ForeignLanguages(Integer id, String languageName) {
        this.id = id;
        this.languageName = languageName;
    }

    public ForeignLanguages(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public ForeignLanguages(String languageName) {
        this.languageName = languageName;
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
        if (!(object instanceof ForeignLanguages)) {
            return false;
        }
        ForeignLanguages other = (ForeignLanguages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.ForeignLanguages[ id=" + id + " ]";
    }
    
}
