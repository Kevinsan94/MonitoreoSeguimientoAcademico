package com.upb.backend.webapp;

import com.upb.backend.entity.Admin;
import com.upb.backend.entity.Notes;
import com.upb.backend.entity.Student;
import com.upb.backend.entity.Teacher;

import javax.persistence.*;
import java.util.List;

public class Database {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.
            createEntityManagerFactory("backend");

    public Database(){
    }

    public Boolean verifiedAdmin(String username, String pass){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Boolean verified = false;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Admin admin = manager.find(Admin.class, username);

            if (admin!=null){
                verified = admin.getPassword().equals(pass);
            }
            else{
                return false;
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return  verified;
    }

    public Boolean verifiedTeacher(int username, String pass){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Boolean verified = false;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Teacher tea = manager.find(Teacher.class, username);

            if (tea!=null){
                verified = tea.getPassword().equals(pass);
            }
            else{
                return false;
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return  verified;
    }
    public Boolean verifiedStudent(int username, String pass){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Boolean verified = false;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Student stu = manager.find(Student.class, username);

            if (stu!=null){
                verified = stu.getPassword().equals(pass);
            }
            else{
                return false;
            }

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return  verified;
    }

    public List<Student> getAllStudents() {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Student> students = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            TypedQuery<Student> query = manager.createQuery("select e from Student e", Student.class);
            students = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return students;
    }

    public Student getStudent(int id) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Student stu = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            stu = manager.find(Student.class, id);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return stu;
    }

    public void createStudent(Student stu) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(stu);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }


    public void deleteStudent(int id) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Student stu = manager.find(Student.class, id);
            manager.remove(stu);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }


    public void updateStudent(int id, String name, String lastname, int telefono, String email, String pass) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Student stu = manager.find(Student.class, id);
            stu.setName(name);
            stu.setLastname(lastname);
            stu.setNumber(telefono);
            stu.setEmail(email);
            stu.setPassword(pass);
            manager.persist(stu);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }


    public void insertNotes(int id, String materia, int p1,int p2, int p3) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Notes n = new Notes();
            n.setStudent_id(id);
            n.setMateria(materia);
            n.setP1(p1);
            n.setP2(p2);
            n.setP3(p3);
            n.setFinal_note();
            manager.persist(n);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public List<Notes> getNotes(int id) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Notes> notes = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            TypedQuery<Notes> query = manager.createQuery("SELECT e from Notes e WHERE student_id LIKE "+ id, Notes.class);
            notes = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return notes;
    }

    public List<Teacher> getAllTeachers() {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<Teacher> teachers = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            TypedQuery<Teacher> query = manager.createQuery("select e from Teacher e", Teacher.class);
            teachers = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return teachers;
    }

    public Teacher getTeacher(int id) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Teacher tea = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            tea = manager.find(Teacher.class, id);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return tea;
    }

    public void createTeacher(Teacher tea) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(tea);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }


    public void deleteTeacher(int id) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Teacher tea = manager.find(Teacher.class, id);
            manager.remove(tea);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }


    public void updateTeacher(int id, String name, String lastname, int telefono, String email, String pass) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Teacher tea = manager.find(Teacher.class, id);
            tea.setName(name);
            tea.setLast_name(lastname);
            tea.setNumber(telefono);
            tea.setEmail(email);
            tea.setPassword(pass);
            manager.persist(tea);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }
}