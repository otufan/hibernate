package h07_crudProje;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class CrudMethodlar {

	private static SessionFactory sf;
			
			
	public void sessionFactoryOlustur() {
		
		try {
			
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Personel.class);
		
		sf = con.buildSessionFactory();
		
		
		
		
		} catch (Throwable e) {
			//oturum açmak veya yanlış gidebilecek her şeyi kesinlikle ele almak 
            //istediğiniz bir iş parçacığının en yüksek "tümünü yakala" düzeyi
			System.out.println("Session Factory olusurken hata olustu"+e);
			
			throw new ExceptionInInitializerError(e); //tercihen bunu ya da usttekini 
		}
				
		}
	
	// veri tabanina bir personel ekleyen method (insert)

	public void personelEkle(String ad, String soyad, int maas) {
		
			Session session = sf.openSession();
		
			Transaction tx = session.beginTransaction();
			try {
				Personel personel=new Personel(ad, soyad, maas);
				session.save(personel);
				
				tx.commit();
				System.out.println("============***********=================");
				System.out.println("Veriler basarali bir sekilde kaydedildi");
			} catch (HibernateException e) {
				if (tx!=null) {tx.rollback();}
				else {
					e.printStackTrace(); //exception olan satiri uzun ve aciklamali bir sekilde getirir
				}
				
			}
			
			finally {//herhalurka yani catch olsun olmasin calistirir bu blogu
				session.close();
			}
		
			}
	
	//veri tabanindan bir personeli silen method (Delete)
	
	public void personelSilme(long ID) { // long primitive data türlerinde null eklenemedigi icin Long data turu de burada tercih edilebilir
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Personel personel = session.get(Personel.class, ID);
		try {if (personel==null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("Girilen "+ ID + " numarali personel bulunmamaktadir");
			
		} else { session.delete(personel);
		tx.commit();
		System.out.println("Girilen "+ ID + " numarali personel DATABASE den silinmistir");
		System.out.println("Silinen personel bilgileri : " + personel);

		}
			
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			else {
				e.printStackTrace(); //exception olan satiri uzun ve aciklamali bir sekilde getirir
			}
			
		}
		
		finally {//herhalurka yani catch olsun olmasin calistirir bu blogu
			session.close();
		}
						
	}
	
	//id ile bir kaydin maas bilgisini guncelleyen method (Update)
	
	public void maasUpdate(long ID, int maas) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Personel personel = session.get(Personel.class, ID);
		
		try {if (personel==null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("Girilen "+ ID + " numarali personel bulunmamaktadir");
			
		} else { personel.setMaas(maas);
		tx.commit();
		System.out.println("Girilen "+ ID + " numarali personelin maasi guncellenmistir");
		System.out.println("Maasi guncellenen personel bilgileri : " + personel);
		
		}
			
		} catch (HibernateException e) {
			if (tx!=null) {tx.rollback();}
			else {
				e.printStackTrace(); //exception olan satiri uzun ve aciklamali bir sekilde getirir
			}
			
		}
		
		finally {//herhalurka yani catch olsun olmasin calistirir bu blogu
			session.close();
		}
		
		}
	
	//veritabanindan tum kayitlari listeleyen method (READ) *butun kisilerin listesini getirmek JPA ile uzun surer.
	// Bu nedenle HQL ile getirmek mantiklidir... FROM Personel yeterli olmaktadir.

		public void allPersonel() {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			try {
				List<Personel> personel = session.createQuery("from Personel").getResultList(); //Java da olan sekliyle buyuk kucuk harf duyarli
				
				personel.stream().forEach(t->System.out.println(t));
				
			} catch (HibernateException e) {
				if (tx!=null) {tx.rollback();}
				else {
					e.printStackTrace(); //exception olan satiri uzun ve aciklamali bir sekilde getirir
				}
				
			}
			
			finally {//herhalurka yani catch olsun olmasin calistirir bu blogu
				session.close();
			}
			
		}
		
		public void sil() {
			
			
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
		   Scanner scan=new Scanner(System.in);
		   System.out.println("lütfen silmek istediğiniz kişinin id sini giriniz");
		   long no =scan.nextLong();

			
	      Personel personel = session.get(Personel.class, no);
				
				if(personel == null) {
					System.out.println(no + " nolu kisinin kaydi bulunamamistir.");
				}else {
					session.delete(personel);
					tx.commit(); //önce silinmeyi kaydet sonra syso ile göster
					System.out.println(no + " nolu kisinin kaydi silinmistir.");
				}
				scan.close();
				session.close();
		}

}
