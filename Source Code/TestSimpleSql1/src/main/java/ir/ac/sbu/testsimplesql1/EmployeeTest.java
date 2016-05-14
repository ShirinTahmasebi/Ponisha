/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.testsimplesql1;
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
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeeeeService");
        em = emf.createEntityManager();
 
        createEmployee(12, "Saint", "Peter", "Engineering");
        createEmployee(13, "Jack", " Dorsey", "Imaginea");
        createEmployee(14, "Sam", "Fox", "Imaginea");
 
    }
 
    private static void createEmployee(int id, String firstName, String lastName, String dept) {
        em.getTransaction().begin();
        Employee emp = new Employee();
        emp.setId(id);
        emp.setFistName(firstName);
        emp.setLastName(lastName);
        emp.setDept(dept);
        
        em.persist(emp);
        em.getTransaction().commit();
    }
}