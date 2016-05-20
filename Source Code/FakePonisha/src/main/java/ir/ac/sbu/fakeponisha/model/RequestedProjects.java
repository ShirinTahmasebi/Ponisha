/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @NamedQuery(name = "RequestedProjects.findByProjectId", query = "SELECT r FROM RequestedProjects r WHERE r.requestedProjectsPK.projectId = :projectId"),
    @NamedQuery(name = "RequestedProjects.findByUserId", query = "SELECT r FROM RequestedProjects r WHERE r.requestedProjectsPK.userId = :userId")})
public class RequestedProjects implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequestedProjectsPK requestedProjectsPK;
    @JoinColumn(name = "projectId", referencedColumnName = "projectId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public RequestedProjects() {
    }

    public RequestedProjects(RequestedProjectsPK requestedProjectsPK) {
        this.requestedProjectsPK = requestedProjectsPK;
    }

    public RequestedProjects(int projectId, int userId) {
        this.requestedProjectsPK = new RequestedProjectsPK(projectId, userId);
    }

    public RequestedProjectsPK getRequestedProjectsPK() {
        return requestedProjectsPK;
    }

    public void setRequestedProjectsPK(RequestedProjectsPK requestedProjectsPK) {
        this.requestedProjectsPK = requestedProjectsPK;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        hash += (requestedProjectsPK != null ? requestedProjectsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestedProjects)) {
            return false;
        }
        RequestedProjects other = (RequestedProjects) object;
        if ((this.requestedProjectsPK == null && other.requestedProjectsPK != null) || (this.requestedProjectsPK != null && !this.requestedProjectsPK.equals(other.requestedProjectsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.ac.sbu.fakeponisha.model.RequestedProjects[ requestedProjectsPK=" + requestedProjectsPK + " ]";
    }
    
}
