package ir.ac.sbu.springponisha.service;

import ir.ac.sbu.springponisha.dao.model.RequestedProjects;
import java.util.List;

/**
 *
 * @author Shirin
 */
public interface RequestedProjectsDao {

    /**
     *
     * @return
     */
    public List<RequestedProjects> getAllRequests();

    /**
     *
     * @param requestId
     * @return
     */
    public RequestedProjects getRequestedProject(int requestId);
    
    /**
     *
     * @param request
     */
    public void insertRequest(RequestedProjects request);

    /**
     *
     * @param requestedProjects
     */
    public void updateRequest(RequestedProjects requestedProjects);
}
