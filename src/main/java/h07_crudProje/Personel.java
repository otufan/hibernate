package h07_crudProje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personel")
public class Personel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //id 1 den baslayarak otomatik artmasi icin kullanilacak anotasyon (onerilen)
	private long id;
	
	private String ad;
	private String soyad;
	private int maas;
	
	
	public Personel() {
		
	}


	public Personel(String ad, String soyad, int maas) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.maas = maas;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public String getSoyad() {
		return soyad;
	}


	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}


	public int getMaas() {
		return maas;
	}


	public void setMaas(int maas) {
		this.maas = maas;
	}


	@Override
	public String toString() {
		return "Personel Bilgileri: [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", maas=" + maas + "]";
	}
	
	
	
	
	
	
	
	
	

}
