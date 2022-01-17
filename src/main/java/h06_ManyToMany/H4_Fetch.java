package h06_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(H1_Ogrenci.class).addAnnotatedClass(H2_Kitap.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//1) id si 1111 olan ogrenciyi getir
		System.out.println("===============1111 olan ogrencinin bilgileri================");
		System.out.println(session.get(H1_Ogrenci.class, 1111));
		
		
		
		//2) id si 101 olan kitabi getir
		
		System.out.println("===============101 no lu kitap bilgileri================");
		System.out.println(session.get(H2_Kitap.class, 101));
		
		//kendi sorum
		
		System.out.println("===============******************************================");
		System.out.println("Sonuc :" + session.get(H2_Kitap.class, 101).getStudents());
		
		
		//3) adi "math book" olan kitabi getir
		
		String hqlQuery1=	"FROM H2_Kitap k WHERE k.book='math book'";//her turlu tablolara isim vermeliyiz
		
		Object sonuc = session.createQuery(hqlQuery1).getSingleResult();
		 
		
		 //normalde getResultList(); ile liste seklinde getiriliyordu ama
														// tek satir icin bu sekilde yazdirilabilir
		
		System.out.println("==============================Math Book bilgileri with HQL ile ================");
		System.out.println(session.createQuery(hqlQuery1).getSingleResult());
		
		//4)Adı "Ali Can" olan öğrenciyi getirin. Kitapları da görmek istiyorum.HQL yazıyoruz, from classismi yazılır.
				//herşey isteniyorsa select* gerek yok
		
		String hqlQuery2="FROM H1_Ogrenci o WHERE o.name='ali can'";
		
		System.out.println("==============================Ali Can bilgileri with HQL ile ================");
		System.out.println(session.createQuery(hqlQuery2).getSingleResult());
		
		//5)sadece student isimlerini getir
		
		String hqlQuery3="SELECT o.name FROM H1_Ogrenci o";
		
		System.out.println("==============================student isimleri with HQL ile ================");
		System.out.println(session.createQuery(hqlQuery3).getResultList());
		
		//6) kitap isimlerini getir
		
		String hqlQuery4="SELECT k.book FROM H2_Kitap k";
		
		System.out.println("==============================Kitap isimleri with HQL ile ================");
		System.out.println(session.createQuery(hqlQuery4).getResultList());
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
