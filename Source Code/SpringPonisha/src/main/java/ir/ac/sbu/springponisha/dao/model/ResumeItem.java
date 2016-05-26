/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.dao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shirin
 */
@Entity
@Table(name = "resumeItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumeItem.findAll", query = "SELECT r FROM ResumeItem r"),
    @NamedQuery(name = "ResumeItem.findByItemId", query = "SELECT r FROM ResumeItem r WHERE r.itemId = :itemId"),
    @NamedQuery(name = "ResumeItem.findByItemName", query = "SELECT r FROM ResumeItem r WHERE r.itemName = :itemName"),
    @NamedQuery(name = "ResumeItem.findByItemLevel", query = "SELECT r FROM ResumeItem r WHERE r.itemLevel = :itemLevel"),
    @NamedQuery(name = "ResumeItem.findByItemDescription", query = "SELECT r FROM ResumeItem r WHERE r.itemDescription = :itemDescription")})
public class ResumeItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemId")
    private Integer itemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "itemLevel")
    private String itemLevel;
    @Size(max = 255)
    @Column(name = "itemDescription")
    private String itemDescription;
    @JoinColumn(name = "resumeId", referencedColumnName = "resumeId")
    @ManyToOne(optional = false)
    private Resume resumeId;

    public ResumeItem() {
    }

    public ResumeItem(Integer itemId) {
        this.itemId = itemId;
    }

    public ResumeItem(Integer itemId, String itemName, String itemLevel) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemLevel = itemLevel;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(String itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Resume getResumeId() {
        return resumeId;
    }

    public void setResumeId(Resume resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResumeItem)) {
            return false;
        }
        ResumeItem other = (ResumeItem) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.ac.sbu.springponisha.dao.model.ResumeItem[ itemId=" + itemId + " ]";
    }
    
}
