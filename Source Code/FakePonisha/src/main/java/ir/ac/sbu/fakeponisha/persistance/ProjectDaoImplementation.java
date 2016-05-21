package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProjectDaoImplementation implements ProjectDao {

    private EntityManagerFactory emf;
    

    @Override
    public List<Project> getAllProjects() {
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<Project> allProjects = em.createNamedQuery("Project.findAll", Project.class);
        return allProjects.getResultList();
    }

    @Override
    public Project getProject(int projectId) {
        EntityManager em;
        em = getEntityManager(emf);
        TypedQuery<Project> project = em.createNamedQuery("Project.findByProjectId", Project.class);
        project.setParameter(1, projectId);
        try {
            return project.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return project.getResultList().get(0);
        }
        
    }


    @Override
    public void insertProject(Project project) {
        EntityManager em;
        em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private EntityManager getEntityManager(EntityManagerFactory emf) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }
}
