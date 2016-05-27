package ir.ac.sbu.springponisha.dao.impl;

import ir.ac.sbu.springponisha.dao.ProjectDao;
import ir.ac.sbu.springponisha.dao.model.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDaoImplementation implements ProjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Project> getAllProjects() {
        TypedQuery<Project> allProjects = entityManager.createNamedQuery("Project.findAll", Project.class);
        return allProjects.getResultList();
    }

    @Override
    public Project getProject(int projectId) {
        TypedQuery<Project> project = entityManager.createNamedQuery("Project.findByProjectId", Project.class);
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
        entityManager.persist(project);
    }

    @Override
    public void updateProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
