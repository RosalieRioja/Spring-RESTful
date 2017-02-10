package com.dao;

import com.model.*;

import java.util.*;
import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

	private static SessionFactory factory;

	public PersonDao() {
		try {
			factory = new Configuration().configure().buildSessionFactory(); 
		}
		catch (Throwable ex) {
			System.err.println("Failed to create a sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public boolean addPerson(Person person) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try {
			tx = session.beginTransaction();
			session.save(person);
			tx.commit();

			success = true;
		}
		catch(HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : addPerson");
		}
		finally {	
			session.close();
		}

		return success;
	}

	public List<Person> listPersons() {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		List<Person> people = null;
		
		try {
			tx = session.beginTransaction();
			people = session.createQuery("FROM Person").list();
			tx.commit();
			success = true;
		}
		catch (HibernateException | NullPointerException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Exception : listPersons");
		}
		finally {
			session.close();
		}
		System.out.println(people.size());
		return people;
	}

	public List<Person> listPersonsCriteria(String sort) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		List<Person> people = null;
		Criteria cr = null;

		try {
			tx = session.beginTransaction();
			cr = session.createCriteria(Person.class, "person");
			
			if(sort == "asc") {
				cr.addOrder(Order.asc("GWA"));
			}
			if(sort == "desc") {
				cr.addOrder(Order.desc("GWA"));
			}
			people = cr.list();
			tx.commit();
			success = true;
		}
		catch (HibernateException | NullPointerException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Exception : listPersonsCriteria");
		}
		finally {
			session.close();
		}

		System.out.println(people.size());
		return people;
	}

	public List<Person> listPersonsQuery(String sort, String column) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		List<Person> people = null;

		try {
			tx = session.beginTransaction();
			people = session.createQuery("FROM Person ORDER BY " + column + " " + sort).list();
			tx.commit();
			success = true;
		}
		catch (HibernateException | NullPointerException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Exception : listPersonsCriteria");
		}
		finally {
			session.close();
		}

		System.out.println(people.size());
		return people;
	}

	public Person getPerson(int personID){
		Person person = null;
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			person = (Person)session.get(Person.class, personID);
			tx.commit();
		}
		catch(HibernateException | NullPointerException | IllegalArgumentException e) {
			//e.printStackTrace();
			//System.out.println("Exception : getPerson");
		}
		finally {
			session.close();

			if(person == null) {
				System.out.println("Person Id does not exist.");
			}
		}
		
		return person;
	}

	public boolean updatePerson(Person updatedPerson){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try{
			tx = session.beginTransaction();
			session.update(updatedPerson);
			tx.commit();
			success = true;
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Hibernate exception : updatePerson");
		}
		finally {
			session.close();
		}

		return success;
	}

	public boolean deletePerson(int personID){
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;

		try{
			tx = session.beginTransaction();
			Person person = (Person)session.get(Person.class, personID);
			session.delete(person);
			tx.commit();
			success = true;
		}
		catch (HibernateException | IllegalArgumentException e) {
			if (tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Person Id does not exist.");
		}
		finally {
			session.close();
		}

		return success;
	}

	//================================================================

	public Roles getRole(int roleID){
		Roles role = null;
		Session session = factory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			role = (Roles)session.get(Roles.class, roleID);
			tx.commit();
		}
		catch(HibernateException | NullPointerException | IllegalArgumentException e) {
			//e.printStackTrace();
			//System.out.println("Exception : getRole");
		}
		finally {
			session.close();

			if(role == null) {
				System.out.println("Role Id does not exist.");
			}
		}
		
		return role;
	}

	public List<Roles> listRoles() {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean success = false;
		List<Roles> roles = null;
		
		try {
			tx = session.beginTransaction();
			roles = session.createQuery("FROM Roles").list();
			tx.commit();
			success = true;
		}
		catch (HibernateException | NullPointerException e) {
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
			System.out.println("Exception : listRoles");
		}
		finally {
			session.close();
		}

		return roles;
	}

}