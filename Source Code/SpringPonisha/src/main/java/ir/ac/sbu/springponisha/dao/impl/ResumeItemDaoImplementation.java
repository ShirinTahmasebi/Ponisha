package ir.ac.sbu.springponisha.dao.impl;

import ir.ac.sbu.springponisha.dao.ResumeItemDao;
import ir.ac.sbu.springponisha.dao.model.ResumeItem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeItemDaoImplementation implements ResumeItemDao {

    @PersistenceContext
    private EntityManager entityManager;

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
        entityManager.persist(resumeItem);
    }

    @Override
    public void updateResumeItem(ResumeItem resmueItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
