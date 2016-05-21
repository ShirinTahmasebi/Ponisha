/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.fakeponisha.persistance;

import ir.ac.sbu.fakeponisha.model.RequestedProjects;
import ir.ac.sbu.fakeponisha.model.User;
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
     * @param userId
     * @return
     */
    public RequestedProjects getRequestedProject(int requestId);
    
    /**
     *
     * @param user
     */
    public void insertRequest(RequestedProjects request);

    /**
     *
     * @param user
     */
    public void updateRequest(RequestedProjects requestedProjects);
}
