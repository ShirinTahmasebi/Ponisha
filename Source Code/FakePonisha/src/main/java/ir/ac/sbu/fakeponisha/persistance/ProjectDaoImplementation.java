package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.User;
import ir.ac.sbu.fakeponisha.utils.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProjectDaoImplementation implements ProjectDao {

    private static EntityManager em;

    @Override
    public List<Project> getAllProjects() {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        em = emf.createEntityManager();
        TypedQuery<Project> allProjects = em.createNamedQuery("Project.findAll", Project.class);
        return allProjects.getResultList();
    }

    @Override
    public Project getProject(int projectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getProject(String projectName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertProject(Project project) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory(Tag.PERSISTANCE_UNIT_NAME);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    @Override
    public void updateProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
