package ir.ac.sbu.springponisha.dao.model;

import ir.ac.sbu.springponisha.dao.model.RequestedProjects;
import ir.ac.sbu.springponisha.dao.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T11:31:49")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, User> userCreator;
    public static volatile ListAttribute<Project, RequestedProjects> requestedProjectsList;
    public static volatile SingularAttribute<Project, String> neededSkills;
    public static volatile SingularAttribute<Project, String> projectDescription;
    public static volatile SingularAttribute<Project, String> projectName;
    public static volatile SingularAttribute<Project, String> deadline;
    public static volatile SingularAttribute<Project, Integer> projectId;
    public static volatile SingularAttribute<Project, String> budget;

}