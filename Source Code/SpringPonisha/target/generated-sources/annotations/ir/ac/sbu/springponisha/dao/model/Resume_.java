package ir.ac.sbu.springponisha.dao.model;

import ir.ac.sbu.springponisha.dao.model.ResumeItem;
import ir.ac.sbu.springponisha.dao.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T11:31:49")
@StaticMetamodel(Resume.class)
public class Resume_ { 

    public static volatile SingularAttribute<Resume, String> resumeDescription;
    public static volatile SingularAttribute<Resume, Integer> resumeId;
    public static volatile ListAttribute<Resume, ResumeItem> resumeItemList;
    public static volatile SingularAttribute<Resume, User> user;

}