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
@Table(name = "knowledges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Knowledges.findAll", query = "SELECT k FROM Knowledges k")
    , @NamedQuery(name = "Knowledges.findById", query = "SELECT k FROM Knowledges k WHERE k.id = :id")
    , @NamedQuery(name = "Knowledges.findByKnowledgeName", query = "SELECT k FROM Knowledges k WHERE k.knowledgeName = :knowledgeName")})
public class Knowledges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Knowledge_Name")
    private String knowledgeName;
    @OneToMany(mappedBy = "knowledgeID")
    private Collection<Employees> employeesCollection;

    public Knowledges() {
    }

    public Knowledges(Integer id, String knowledgeName) {
        this.id = id;
        this.knowledgeName = knowledgeName;
    }

    public Knowledges(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public Knowledges(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
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
        if (!(object instanceof Knowledges)) {
            return false;
        }
        Knowledges other = (Knowledges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Knowledges[ id=" + id + " ]";
    }
    
}
