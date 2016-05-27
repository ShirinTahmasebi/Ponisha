package ir.ac.sbu.springponisha.dao.impl;

import ir.ac.sbu.springponisha.dao.ResumeDao;
import ir.ac.sbu.springponisha.dao.model.Resume;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeDaoImplementation implements ResumeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Resume> getAllResumes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resume getResume(int resumeId) {
        TypedQuery<Resume> resume = entityManager.createNamedQuery("Resume.findByResumeId", Resume.class);
        resume.setParameter(1, resumeId);
        try {
            return resume.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return resume.getResultList().get(0);
        }
    }

    @Override
    public void insertResume(Resume resume) {
        entityManager.persist(resume);
    }

    @Override
    public void updateResume(Resume resume) {
    }
}
