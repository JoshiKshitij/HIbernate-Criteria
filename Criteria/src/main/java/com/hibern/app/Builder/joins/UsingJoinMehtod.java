package com.hibern.app.Builder.joins;

import java.io.File;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hibern.app.Department;

public class UsingJoinMehtod {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));

		Session session = configuration.buildSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

		Root<Department> fromDept = query.from(Department.class);
		
		// variavle name will used in joins
		Join<Object, Object> join = fromDept.join("emps");

		query.multiselect(fromDept, join);

		List<Object[]> list = session.createQuery(query).list();
		
		

	}

}
