/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstdlate file, choose Tools | Tstdlates
 * and open the tstdlate in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zucrem
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student std1 = new Student(1, "John", 4.0);
       Student std2 = new Student(2, "Marry", 3.5);
       StudentTable.insertStudent(std1);
       StudentTable.insertStudent(std2);
//       Student std;
//       std = StudentTable.findStudentById(1);
//       if (std != null) {
//           std.setName("Jack");
//           StudentTable.removeStudent(std);
//           StudentTable.updateStudent(std);
//       }
       //List<Student> stdList = StudentTable.findStudentByName("Marry"); 
       List<Student> stdList = StudentTable.findAllStudent();
       printAllStudent(stdList);
    }
    public static void printAllStudent(List<Student> stdloyeeList) {
        for(Student std : stdloyeeList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
