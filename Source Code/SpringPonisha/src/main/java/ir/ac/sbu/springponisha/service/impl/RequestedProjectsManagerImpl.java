package ir.ac.sbu.springponisha.service.impl;

import ir.ac.sbu.springponisha.dao.RequestedProjectsDao;
import ir.ac.sbu.springponisha.dao.model.RequestedProjects;
import ir.ac.sbu.springponisha.service.RequestedProjectsManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shirin
 */
@Service
public class RequestedProjectsManagerImpl implements RequestedProjectsManager {

    @Autowired
    RequestedProjectsDao requestedProjectsDao;

    @Override
    public List<RequestedProjects> getAllRequests() {
        return requestedProjectsDao.getAllRequests();
    }

    @Override
    public RequestedProjects getRequestedProject(int requestId) {
        return requestedProjectsDao.getRequestedProject(requestId);
    }

    @Override
    @Transactional
    public void insertRequest(RequestedProjects request) {
        requestedProjectsDao.insertRequest(request);
    }

    @Override
    @Transactional
    public void updateRequest(RequestedProjects requestedProjects) {
        requestedProjectsDao.updateRequest(requestedProjects);
    }

}
