/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.springponisha.dao;

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
