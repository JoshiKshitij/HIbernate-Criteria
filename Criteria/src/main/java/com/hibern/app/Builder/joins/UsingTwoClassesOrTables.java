package com.hibern.app.Builder.joins;

import java.io.File;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibern.app.ClassLocation;
import com.hibern.app.Student;

public class UsingTwoClassesOrTables {

	// Student and ClassLocation the dont have any relationship

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		

		CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

		Root<Student> fromStudent = query.from(Student.class);
		Root<ClassLocation> fromLocation = query.from(ClassLocation.class); 

		query.multiselect(fromStudent.get("name"),
				fromStudent.get("stdClass"),
					fromLocation.get("location"), 
						fromLocation.get("stdName"))
		.where(builder.equal(fromStudent.get("stdClass"),
				     fromLocation.get("stdName")));
		
		session.createQuery(query).list().forEach(tup -> {
			System.out.println(tup.get(0) + "\t" + tup.get(1) + "\t" + tup.get(2)+ "\t" + tup.get(3));
		});

	}

}
