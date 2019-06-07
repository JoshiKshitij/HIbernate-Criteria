package com.hibern.app.Builder.tupleUse;

import java.io.File;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibern.app.Student;

public class UseOfTuple {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

		CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

		Root<Student> from = query.from(Student.class);

		
		query.multiselect(
				from.get("id"), from.get("name"), from.get("stdClass"), from.get("percentage"));

		/*session.createQuery(query).list().forEach(tup -> {
			System.out.println(
					tup.get(0) + "\t" + tup.get(1) 
					+ "\t" + tup.get(2) 
					+ "\t" + tup.get(3));
		});*/
		
		List<Tuple> list = session.createQuery(query).list();
		for (Tuple tuple : list) {
		
			System.out.println((int)tuple.get(from.get("id") ) + 
					"\t"+ (String)tuple.get(from.get("name") ) );
			
		}

	}

}
