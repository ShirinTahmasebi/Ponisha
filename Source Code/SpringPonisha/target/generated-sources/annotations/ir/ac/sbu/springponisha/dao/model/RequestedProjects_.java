package ir.ac.sbu.springponisha.dao.model;

import ir.ac.sbu.springponisha.dao.model.Project;
import ir.ac.sbu.springponisha.dao.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T11:31:49")
@StaticMetamodel(RequestedProjects.class)
public class RequestedProjects_ { 

    public static volatile SingularAttribute<RequestedProjects, Integer> requestId;
    public static volatile SingularAttribute<RequestedProjects, String> price;
    public static volatile SingularAttribute<RequestedProjects, String> description;
    public static volatile SingularAttribute<RequestedProjects, String> deadline;
    public static volatile SingularAttribute<RequestedProjects, Project> projectId;
    public static volatile SingularAttribute<RequestedProjects, User> userId;

}