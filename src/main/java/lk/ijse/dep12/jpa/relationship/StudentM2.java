package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Enroll;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author : L.H.J
 * @File: HelloJpa
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-07-23, Tuesday
 **/
public class StudentM2 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();


                Student s001 = em.find(Student.class, "S001");
                Student s002 = em.find(Student.class, "S002");


                Course c001 = em.find(Course.class, "C001");
                Enroll e001 = new Enroll("Malsha", Date.valueOf(LocalDate.now()), s002, c001);

                em.persist(e001);

                transaction.commit();

            }catch (Throwable t){
                transaction.rollback();
                t.printStackTrace();
            }
        }
    }
}
