package ir.ac.sbu.springponisha.dao.model;

import ir.ac.sbu.springponisha.dao.model.Resume;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T10:58:05")
@StaticMetamodel(ResumeItem.class)
public class ResumeItem_ { 

    public static volatile SingularAttribute<ResumeItem, Integer> itemId;
    public static volatile SingularAttribute<ResumeItem, String> itemName;
    public static volatile SingularAttribute<ResumeItem, Resume> resumeId;
    public static volatile SingularAttribute<ResumeItem, String> itemDescription;
    public static volatile SingularAttribute<ResumeItem, String> itemLevel;

}