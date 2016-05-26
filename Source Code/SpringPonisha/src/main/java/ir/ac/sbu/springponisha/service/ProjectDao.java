package ir.ac.sbu.springponisha.service;

import ir.ac.sbu.springponisha.dao.model.Project;
import java.util.List;

/**
 *
 * @author Shirin
 */
public interface ProjectDao {

    /**
     *
     * @return
     */
    public List<Project> getAllProjects();

    /**
     *
     * @param projectId
     * @return
     */
    public Project getProject(int projectId);

    /**
     *
     * @param project
     */
    public void insertProject(Project project);

    /**
     *
     * @param project
     */
    public void updateProject(Project project);
}
