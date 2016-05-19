/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.User;
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
     * @param projectName
     * @return
     */
    public User getProject(String projectName);

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
