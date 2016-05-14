/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.sqltestmaven2;

import java.io.IOException;
import java.util.Calendar;
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
public class HibernateSessionFactoryListener extends HttpServlet{

    private static EntityManager em;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee();//id, firstName, lastName, dept);
        emp.setId(5);
        emp.setName("Shirin");
        emp.setRole("developer");
        emp.setInsertTime(Calendar.getInstance().getTime());
        
        em.persist(emp);
        em.getTransaction().commit();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        doGet(req, resp);
    }
    
    
    
}
