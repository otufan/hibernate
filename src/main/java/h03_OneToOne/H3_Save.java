package h03_OneToOne;

public class H3_Save {

	public static void main(String[] args) {
						
		//gunluk tablosuna girilecek veriler icin objeler olusturuldu
		H2_Gunluk gunluk1 = new H2_Gunluk(11, "Mehmet'in Gunlugu");
		H2_Gunluk gunluk2 = new H2_Gunluk(12, "Alinin Gunlugu");
		H2_Gunluk gunluk3 = new H2_Gunluk(13, "Tayyarın Gunlugu");
		H2_Gunluk gunluk4 = new H2_Gunluk(14, "Osman ın Gunlugu");
		
		//kisiler tablosuna girilecek veriler icin objeler olsuturuldu
		H1_Kisi kisi1 = new H1_Kisi(101, "Mehmet Can", 45);
		H1_Kisi kisi2 = new H1_Kisi(102, "Ali Han", 49);
		H1_Kisi kisi3 = new H1_Kisi(103, "Tayyar Tan", 36);
		
		
		gunluk1.setKisi(kisi1);
		gunluk2.setKisi(kisi2);
		gunluk3.setKisi(kisi3);
		gunluk3.setKisi(null);

	}

}
