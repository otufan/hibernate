package h03_OneToOne;





import java.util.Arrays;
import java.util.List;

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
		
		//3) gunluk class indaki tum verileri sorgula
		
		/*for (int i = 12; i < 14; i++) {
			//Tercih edilmeyen yol....
			System.out.println(session.get(H2_Gunluk.class, i));
		}*/
		
		List<Object[] > liste= session.createQuery("from H1_Kisi k join H2_Gunluk g on  k.kisiId=g.kisi").getResultList();

		liste.stream().forEach(t-> System.out.println(Arrays.toString(t))); 
		
		
		//3) Kisiler ve Gunlukler tablolarindaki ortak olan (one to one ile birebir bağladığımız) kayıtların,
		// Kisi adi, gunluk yazisi(yazilar) ve kisi yası (kisiYas) bilgilerini sorgulayiniz.
		
		
		String sorgu="SELECT k.kisi_ad, g.owner, k.kisiYas FROM kisiler k INNER JOIN gunlukler g on k.kisi_id=g.kisi_no";
		
		List<Object[]> sonuc=session.createSQLQuery(sorgu).getResultList();
		
		for (Object[] each : sonuc) {
			System.out.println(Arrays.toString(each));
		}
		
		
		tx.commit();
		sf.close();
		session.close();

	}

}
