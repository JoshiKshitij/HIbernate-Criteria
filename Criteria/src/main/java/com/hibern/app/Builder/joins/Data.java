package com.hibern.app.Builder.joins;

import java.io.File;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hibern.app.Department;
import com.hibern.app.Employee;
import com.hibern.app.Laptop;

public class Data {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure(new File("src/hibernate.cfg.xml"));

		Session session = configuration.buildSessionFactory().openSession();
		session.beginTransaction();

		Department hr = new Department(3, "HR department");
		Employee empHr1 = new Employee("pooja Joshi", 2, hr);
		Laptop empHr1Lapi1 = new Laptop("lenevo extreem", "8 gb", empHr1);
		empHr1.getLaptops().add(empHr1Lapi1);

		Employee empHr2 = new Employee("deep", 4, hr);
		Laptop empHr2Lapi2 = new Laptop("lenevo carbon", "8 gb", empHr2);
		Laptop empHr2Lapi3 = new Laptop("asus zenbook", "4 gb", empHr2);
		empHr2.getLaptops().add(empHr2Lapi2);
		empHr2.getLaptops().add(empHr2Lapi3);

		Employee empHr3 = new Employee("vikul soodan", 1, hr);
		Laptop empHr3Lapi4 = new Laptop("apple mac", "12 gb", empHr3);
		empHr3.getLaptops().add(empHr3Lapi4);

		hr.getEmps().addAll(Arrays.asList(empHr1, empHr2, empHr3));
		//--------------------------------------------------------------------
		Department develpoment = new Department(6, "Development department");
		
		Employee empDevelopment1 = new Employee("Kshitij Joshi", 2 ,develpoment);
		Laptop empDevelopment1Lapi1 = new Laptop("lenevo extreem", "8 gb", empDevelopment1);
		empDevelopment1.getLaptops().add(empDevelopment1Lapi1);
		
		Employee empDevelopment2 = new Employee("rahul shrma", 5 ,develpoment);
		Laptop empDevelopment2Lapi1 = new Laptop("lenevo extreem", "8 gb", empDevelopment2);
		empDevelopment2.getLaptops().add(empDevelopment2Lapi1);
		
		Employee empDevelopment3 = new Employee("kartik rao", 1,develpoment);
		Laptop empDevelopment3Lapi1 = new Laptop("asus probook", "12 gb", empDevelopment3);
		empDevelopment3.getLaptops().add(empDevelopment3Lapi1);
		Laptop empDevelopment3Lapi2 = new Laptop("lenevo thinkpad", "16 gb", empDevelopment3);
		empDevelopment3.getLaptops().add(empDevelopment3Lapi2);
		Laptop empDevelopment3Lapi3 = new Laptop("lenevo extreem", "8 gb", empDevelopment3);
		empDevelopment3.getLaptops().add(empDevelopment3Lapi3);
		
		Employee empDevelopment4 = new Employee("vinod das", 1.5,develpoment);
		Laptop empDevelopment4Lapi1 = new Laptop("lenevo extreem", "8 gb", empDevelopment4);
		empDevelopment4.getLaptops().add(empDevelopment4Lapi1);
		
		
		Employee empDevelopment5 = new Employee("kirti jaswal", 3,develpoment);
		Laptop empDevelopment5Lapi1 = new Laptop("aser idea", "8 gb", empDevelopment5);
		empDevelopment5.getLaptops().add(empDevelopment5Lapi1);
		Laptop empDevelopment5Lapi2 = new Laptop("apple pro", "8 gb", empDevelopment5);
		empDevelopment5.getLaptops().add(empDevelopment5Lapi2);
		
		Employee empDevelopment6 = new Employee("ram raman", 6,develpoment);
		Laptop empDevelopment6Lapi1 = new Laptop("lenevo extreem", "16 gb", empDevelopment6);
		empDevelopment6.getLaptops().add(empDevelopment6Lapi1);
		
		develpoment.getEmps().addAll(Arrays.asList(empDevelopment1 ,empDevelopment2 , empDevelopment3,
				empDevelopment4, empDevelopment5, empDevelopment6));

		//--------------------------------------------------------------------------------
		Department testing = new Department(4, "Testing department");
		Employee empTesting1 = new Employee("hema raturi", 4,testing);
		Laptop empTesting1Lapi1 = new Laptop("lenevo thinkpad", "16 gb", empTesting1);
		empTesting1.getLaptops().add(empTesting1Lapi1);
		
		Employee empTesting2 = new Employee("shubham joshi", 2,testing);
		Laptop empTesting2Lapi1 = new Laptop("apple mac", "16 gb", empTesting2);
		empTesting2.getLaptops().add(empTesting2Lapi1);
		
		Employee empTesting3 = new Employee("aryan das", 5,testing);
		Laptop empTesting3Lapi1 = new Laptop("asus zenbook s", "16 gb", empTesting3);
		empTesting3.getLaptops().add(empTesting3Lapi1);
		
		Employee empTesting4 = new Employee("vivek rawan", 3,testing);
		Laptop empTesting4Lapi1 = new Laptop("lenevo extreem", "16 gb", empTesting4);
		empTesting4.getLaptops().add(empTesting4Lapi1);
		
		
		testing.getEmps().addAll(Arrays.asList(empTesting1 , empTesting2 ,empTesting3 , empTesting4));
		
		
		
		
		session.save(hr);
		session.save(develpoment);
		session.save(testing);
		
		session.getTransaction().commit();
	}

}
