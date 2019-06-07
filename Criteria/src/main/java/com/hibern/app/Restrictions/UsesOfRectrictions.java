package com.hibern.app.Restrictions;

import java.io.File;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibern.app.Student;

public class UsesOfRectrictions {

	public static Student fetchStudentByName(Session session, String name) {
		Criteria criteria = session.createCriteria(Student.class);
		Criteria data = criteria.add(Restrictions.like("name", name));

		return (Student) data.uniqueResult();
	}

	public static List<Student> fetchStudentByNameOrPercentage(Session session, String name, double percentage) {
		Criteria criteria = session.createCriteria(Student.class);
		Criteria data = criteria.add(Restrictions.or(Restrictions.like("name", name),
			Restrictions.between("percentage", percentage, 100.00)));
				
		return data.list();
	}

	@SuppressWarnings("deprecation")
	public static List<Student> fetchAllStudent(Session session) {
		Criteria criteria = session.createCriteria(Student.class);
		return criteria.list();
	}

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));

		Session session = configuration.buildSessionFactory().openSession();

		// System.out.println(fetchStudentByName(session, "C"));
		// fetchAllStudent(session).forEach(s -> System.out.println(s));
		fetchStudentByNameOrPercentage(session, "", 50.00).forEach(s -> System.out.println(s));
		;
	}
}
