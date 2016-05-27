package ir.ac.sbu.springponisha.service.impl;

import ir.ac.sbu.springponisha.dao.ProjectDao;
import ir.ac.sbu.springponisha.dao.model.Project;
import ir.ac.sbu.springponisha.service.ProjectManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectManagerImpl implements ProjectManager{

    @Autowired
    ProjectDao projectDao;
    
    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public Project getProject(int projectId) {
        return projectDao.getProject(projectId);
    }

    @Override
    @Transactional
    public void insertProject(Project project) {
        projectDao.insertProject(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }
    
}
