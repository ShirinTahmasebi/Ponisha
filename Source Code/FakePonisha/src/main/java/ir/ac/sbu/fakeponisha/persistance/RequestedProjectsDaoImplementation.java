/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.RequestedProjects;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Shirin
 */
public class RequestedProjectsDaoImplementation implements RequestedProjectsDao {

    private EntityManagerFactory emf;

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
        EntityManager em;
        em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(request);
        em.getTransaction().commit();
    }

    @Override
    public void updateRequest(RequestedProjects requestedProjects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private EntityManager getEntityManager(EntityManagerFactory emf) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }

}
