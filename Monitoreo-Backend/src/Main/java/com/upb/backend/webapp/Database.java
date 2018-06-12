package com.upb.backend.webapp;

import com.upb.backend.entity.Notes;
import com.upb.backend.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Database {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.
            createEntityManagerFactory("backend");

    public Database(){
    }

    public Boolean verifiedUser(int username, String pass){
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        Boolean verified = false;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Student stu = manager.find(Student.class, username);
            if (stu!=null){
                verified = stu.getPassword().equals(pass);
            } else{
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
        // Create an EntityManager
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


    public void insertNotes(int id, int p1,int p2, int p3) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

//notas
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Notes n = new Notes();
            n.setId(id);
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
}