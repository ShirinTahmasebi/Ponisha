package ir.ac.sbu.fakeponisha.model;

import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.RequestedProjectsPK;
import ir.ac.sbu.fakeponisha.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-20T21:20:47")
@StaticMetamodel(RequestedProjects.class)
public class RequestedProjects_ { 

    public static volatile SingularAttribute<RequestedProjects, RequestedProjectsPK> requestedProjectsPK;
    public static volatile SingularAttribute<RequestedProjects, Project> project;
    public static volatile SingularAttribute<RequestedProjects, User> user;

}