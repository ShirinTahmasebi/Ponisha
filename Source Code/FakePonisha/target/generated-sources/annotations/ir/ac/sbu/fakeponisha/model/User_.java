package ir.ac.sbu.fakeponisha.model;

import ir.ac.sbu.fakeponisha.model.Company;
import ir.ac.sbu.fakeponisha.model.Project;
import ir.ac.sbu.fakeponisha.model.RequestedProjects;
import ir.ac.sbu.fakeponisha.model.Resume;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-21T20:20:57")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Project> projectList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> gender;
    public static volatile ListAttribute<User, RequestedProjects> requestedProjectsList;
    public static volatile SingularAttribute<User, Resume> resumeId;
    public static volatile SingularAttribute<User, String> city;
    public static volatile SingularAttribute<User, String> userFirstLastName;
    public static volatile SingularAttribute<User, Company> company;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> birthDate;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}