package dao;
/*
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import entity.Cource;
import entity.Student;

public class AdmissionService<Admission, Course>
{
	  private SessionFactory factory = new Configuration().configure().buildSessionFactory();

	    public void addStudent(Student s) { }
	    public void addCourse(Cource c) { }
	    public void admitStudent(Student s, Cource c) {  }
	    public void getStudentById(int id) { }
	    public void getCourseById(int id) {  }
	    public void listAdmissions() { }
	    public void listCourses() {  }

}
*/


import entity.Admission;
import entity.Course;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AdmissionService {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addStudent(Student s) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
        }
    }

    public void addCourse(Course c) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(c);
            tx.commit();
        }
    }

    public void admitStudent(Student s, Course c) {
        Admission admission = new Admission();
        admission.setStudent(s);
        admission.setCourse(c);
        admission.setAdmissionDate(java.time.LocalDate.now());

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(admission);
            tx.commit();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = factory.openSession()) {
            return session.find(Student.class, id);
        }
    }

    public Course getCourseById(int id) {
        try (Session session = factory.openSession()) {
            return session.find(Course.class, id);
        }
    }

    public List<Admission> listAdmissions() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Admission", Admission.class).list();
        }
    }

    public List<Course> listCourses() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        }
    }
}
