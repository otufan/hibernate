package h07_crudProje;

public class Main {

	public static void main(String[] args) {


		CrudMethodlar method=new CrudMethodlar();
		
		method.sessionFactoryOlustur();
		
		//veri tabanina personel ekle methodu cagrilacak ve personel eklenecek
		//method.personelEkle("Selman", "Sari", 12000);
		//method.personelEkle("Meryem", "Kara", 7700);
		//method.personelEkle("Lokman", "Ates", 8900);
		
		
		//method.personelSilme(1);
		//method.maasUpdate(8, 9900);
		
		method.sil();
		method.allPersonel();
		
		
	}
	
	
	
}
