/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.sqltestmaven;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employeeee {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fistName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dept")
    private String dept;

    public Employeeee(){

    }

    public Employeeee(int id, String firstName, String lastName, String dept){
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDept(dept);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}