/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shirin
 */
@Entity
@Table(name = "requestedProjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestedProjects.findAll", query = "SELECT r FROM RequestedProjects r"),
    @NamedQuery(name = "RequestedProjects.findByRequestId", query = "SELECT r FROM RequestedProjects r WHERE r.requestId = :requestId"),
    @NamedQuery(name = "RequestedProjects.findByPrice", query = "SELECT r FROM RequestedProjects r WHERE r.price = :price"),
    @NamedQuery(name = "RequestedProjects.findByDeadline", query = "SELECT r FROM RequestedProjects r WHERE r.deadline = :deadline"),
    @NamedQuery(name = "RequestedProjects.findByDescription", query = "SELECT r FROM RequestedProjects r WHERE r.description = :description")})
public class RequestedProjects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requestId")
    private Integer requestId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "deadline")
    private String deadline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @OneToOne(optional = false)
    private User userId;

    public RequestedProjects() {
    }

    public RequestedProjects(Integer requestId) {
        this.requestId = requestId;
    }

    public RequestedProjects(Integer requestId, String price, String deadline, String description) {
        this.requestId = requestId;
        this.price = price;
        this.deadline = deadline;
        this.description = description;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestedProjects)) {
            return false;
        }
        RequestedProjects other = (RequestedProjects) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.ac.sbu.fakeponisha.model.RequestedProjects[ requestId=" + requestId + " ]";
    }
    
}
