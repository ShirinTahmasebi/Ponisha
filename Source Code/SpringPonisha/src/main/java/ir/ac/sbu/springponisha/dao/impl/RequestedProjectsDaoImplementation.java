/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.dao.impl;

import ir.ac.sbu.springponisha.dao.RequestedProjectsDao;
import ir.ac.sbu.springponisha.dao.model.RequestedProjects;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RequestedProjectsDaoImplementation implements RequestedProjectsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RequestedProjects> getAllRequests() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RequestedProjects getRequestedProject(int requestId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRequest(RequestedProjects request) {
        entityManager.persist(request);
    }

    @Override
    public void updateRequest(RequestedProjects requestedProjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
