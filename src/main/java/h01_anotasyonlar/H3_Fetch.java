package h01_anotasyonlar;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Fetch {

	public static void main(String[] args) {
		
	SessionFactory sf=new Configuration().
			configure("hibernate.cfg.xml").
			addAnnotatedClass(H1_Sehir.class).buildSessionFactory();
	
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
		
	//sehir_tablosundan istenilen id li kisiyi getir
	

	//System.out.println(session.get(H1_Sehir.class,37)); 
	//H1_Sehir [sehirPlaka=37, sehirAdi=Istanbul, sehirNufus=10000000]

	System.out.println(session.get(H1_Sehir.class,35).getSehirNufus());
	// 2500000 <---- izmirin nufusunu istedik
	
	session.get(H1_Sehir.class,35).setSehirAdi("Adana");
	
	tx.commit();
	sf.close();
	session.close();
	}

}
