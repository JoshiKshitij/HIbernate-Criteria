package com.hibern.app;

import java.io.File;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure(new File("src/hibernate.cfg.xml"));
        
        // test weather hibernate is working or not
        Session session = configuration.buildSessionFactory().openSession();
       
        session.beginTransaction();
        for (int i = 0; i < 10; i++) {
        	
        	NumberFormat nf = NumberFormat.getInstance();
        	nf.setMaximumFractionDigits(2);
        	String per = nf.format((new Random().nextDouble()+30 +new Random().nextInt(65)));
        	Student s1 = new Student( (char)(i+65) + "", Double.parseDouble(per) , ""+ (new Random().nextInt(5)+5));
		session.save(s1);
        }
        
        session.getTransaction().commit();
        session.getSessionFactory().close();
        session.close();
        
        
    }
}
