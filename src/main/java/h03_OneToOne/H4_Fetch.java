package h03_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Kisi.class)
				.addAnnotatedClass(H2_Gunluk.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		
		//1) id=101 olan kisinin bilgilerini getir
		
		System.out.println("1. soru: " + session.get(H1_Kisi.class, 101));
		System.out.println("======================================================");
		
		//2) id=12 olan gunlugun bilgilerini getirelim
		
		System.out.println("2. sorunun cevabi : "+session.get(H2_Gunluk.class, 12));
		
		tx.commit();

	}

}
