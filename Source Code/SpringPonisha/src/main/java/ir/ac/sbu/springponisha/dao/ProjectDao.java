/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.dao;

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
