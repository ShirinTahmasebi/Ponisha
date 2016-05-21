/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.Resume;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ResumeDaoImplementation implements ResumeDao {

    private EntityManagerFactory emf;

    @Override
    public List<Resume> getAllResumes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resume getResume(int resumeId) {
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<Resume> resume = em.createNamedQuery("Resume.findByResumeId", Resume.class);
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
        EntityManager em;
        em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(resume);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateResume(Resume resume) {
    }

    private EntityManager getEntityManager(EntityManagerFactory emf) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }
}
