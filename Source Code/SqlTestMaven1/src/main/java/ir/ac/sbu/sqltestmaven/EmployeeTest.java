/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.sqltestmaven;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Shirin
 */
public class EmployeeTest {
 
    
    private static EntityManager em;
 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
 
        createEmployee(15, "Saint", "Peter", "Engineering");
//        createEmployee(5, "Jack", " Dorsey", "Imaginea");
//        createEmployee(6, "Sam", "Fox", "Imaginea");
 
    }
 
    private static void createEmployee(int id, String firstName, String lastName, String dept) {
        em.getTransaction().begin();
        Employeeee emp = new Employeeee(id, firstName, lastName, dept);
        em.persist(emp);
        em.getTransaction().commit();
    }
    
}

