package com.hibern.app.Builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hibern.app.Student;

public class CriteriaBuilderUse {

	// these methods are available in criterai api from JPA
	// query.select(selection);
	// query.from(entityClass);
	// query.where(restriction);
	// query.groupBy(grouping);
	// query.having(restriction);
	// query.orderBy(o);

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));

		
		Session session = configuration.buildSessionFactory().openSession();

		// selectStudentByPercentageGreaterThanFilled(session, 50.0).forEach(s ->
		// System.out.println(s));
		
		System.out.println("excution started");
		//Object[] array = selectNameAndPercentageById(session, 9);
		
		
		System.out.println(selectMaxPercentage(session));
		session.getSessionFactory().close();
		session.close();

	}
	
	

	private static double selectMaxPercentage(Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		
		Root<Student> from = query.from(Student.class);
		
		query.select(builder.max(from.get("percentage")));
		
		return session.createQuery(query).uniqueResult();
	}



	private static Object[]  selectNameAndPercentageById(Session session, int id) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
		
		Root<Student> root = query.from(Student.class);
		
		query.multiselect( root.get("name"),root.get("percentage") )
		.where(builder.equal(root.get("id") , id));
				
		Object[] obj  = session.createQuery(query).uniqueResult();
		return obj;
	}

	static List<Student> selectStudentByPercentageGreaterThanFilled(Session session, double per) {

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);

		Root<Student> from = query.from(Student.class);

		query.select(from).where(builder.greaterThan(from.get("percentage"), per));

		query.where(builder.greaterThan(from.get("percentage"), 123));

		Query<Student> result = session.createQuery(query);
		return result.list();
	}

	private static Student selectStudentByNanme(Session session, String name) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);

		Root<Student> from = query.from(Student.class);
		CriteriaQuery<Student> select = query.select(from);

		query.where(builder.equal(from.get("name"), name));

		Query<Student> result = session.createQuery(select);
		Student ans = result.uniqueResult();

		return ans;
	}

	private static List<Student> selectAllStudentds(Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);

		Root<Student> from = query.from(Student.class);
		CriteriaQuery<Student> select = query.select(from);

		List<Student> list = session.createQuery(select).list();

		return list;
	}

}
