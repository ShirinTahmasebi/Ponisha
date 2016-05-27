package ir.ac.sbu.springponisha.dao.model;

import ir.ac.sbu.springponisha.dao.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T11:31:49")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, Integer> companyId;
    public static volatile SingularAttribute<Company, User> userOwner;
    public static volatile SingularAttribute<Company, String> companySite;
    public static volatile SingularAttribute<Company, String> companyName;
    public static volatile SingularAttribute<Company, String> companyAddress;

}