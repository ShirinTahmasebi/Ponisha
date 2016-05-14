/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.testsimplesql2;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shirin
 */
public class EmployeeInsertController extends HttpServlet{

    private static EntityManager em;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
 
        createEmployee(1, "Saint", "Peter", "Engineering");
        createEmployee(2, "Jack", " Dorsey", "Imaginea");
        createEmployee(3, "Sam", "Fox", "Imaginea");
 
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
