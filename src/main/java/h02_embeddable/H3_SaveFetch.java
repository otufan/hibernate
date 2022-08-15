package h02_embeddable;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_SaveFetch {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").
		addAnnotatedClass(H1_Ogrenci.class).buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		H2_Dersler ders1=new H2_Dersler("Muzik", "Matematik");
		
		H1_Ogrenci ogr1=new H1_Ogrenci(111, "Adem Sakir", 87, ders1);
		
		session.save(ogr1);
		
		H1_Ogrenci ogr2=new H1_Ogrenci(222, "Isa Yildiz", 92, new H2_Dersler("Beden", "Fizik") );
		
		session.save(ogr2); 
		
		// Fetch islemi
		
		//System.out.println(session.get(H1_Ogrenci.class, 111));
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Silmek istediginiz numarayi giriniz : ");
		
		int no=scan.nextInt();
		
		session.delete(session.get(H1_Ogrenci.class, no));
		
		session.get(H1_Ogrenci.class, 222).setOgrId(333);
		
		
		tx.commit();
		sf.close();
		session.close();
		scan.close();
	}

}
