/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.ResumeItem;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Shirin
 */
public class ResumeItemDaoImplementation implements ResumeItemDao {

    private static EntityManager em;

    @Override
    public List<ResumeItem> getAllResumeItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResumeItem getResumeItem(int resumeItemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertResumeItem(ResumeItem resumeItem) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(resumeItem);
        em.getTransaction().commit();

    }

    @Override
    public void updateResumeItem(ResumeItem resmueItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
