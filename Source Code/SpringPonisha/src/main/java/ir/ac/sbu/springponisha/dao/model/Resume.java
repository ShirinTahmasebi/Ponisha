/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.dao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Shirin
 */
@Entity
@Table(name = "resume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resume.findAll", query = "SELECT r FROM Resume r"),
    @NamedQuery(name = "Resume.findByResumeId", query = "SELECT r FROM Resume r WHERE r.resumeId = :resumeId"),
    @NamedQuery(name = "Resume.findByResumeDescription", query = "SELECT r FROM Resume r WHERE r.resumeDescription = :resumeDescription")})
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resumeId")
    private Integer resumeId;
    @Size(max = 255)
    @Column(name = "resumeDescription")
    private String resumeDescription;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "resumeId")
    @Fetch(FetchMode.SUBSELECT)
    private List<ResumeItem> resumeItemList;
    @OneToOne(mappedBy = "resumeId")
    private User user;

    public Resume() {
    }

    public Resume(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeDescription() {
        return resumeDescription;
    }

    public void setResumeDescription(String resumeDescription) {
        this.resumeDescription = resumeDescription;
    }

    @XmlTransient
    public List<ResumeItem> getResumeItemList() {
        return resumeItemList;
    }

    public void setResumeItemList(List<ResumeItem> resumeItemList) {
        this.resumeItemList = resumeItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resumeId != null ? resumeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resume)) {
            return false;
        }
        Resume other = (Resume) object;
        if ((this.resumeId == null && other.resumeId != null) || (this.resumeId != null && !this.resumeId.equals(other.resumeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.ac.sbu.springponisha.dao.model.Resume[ resumeId=" + resumeId + " ]";
    }

}
