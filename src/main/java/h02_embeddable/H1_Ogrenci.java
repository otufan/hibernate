package h02_embeddable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ogrenciler")
public class H1_Ogrenci {
	
	@Id
	private int ogrId;
	private String Ad;
	private int ogrNot;
	
	private H2_Dersler dersler;
	
	public H1_Ogrenci() {}

	public H1_Ogrenci(int ogrId, String ad, int ogrNot, H2_Dersler dersler) {
		super();
		this.ogrId = ogrId;
		Ad = ad;
		this.ogrNot = ogrNot;
		this.dersler = dersler;
	}

	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getAd() {
		return Ad;
	}

	public void setAd(String ad) {
		Ad = ad;
	}

	public int getOgrNot() {
		return ogrNot;
	}

	public void setOgrNot(int ogrNot) {
		this.ogrNot = ogrNot;
	}

	public H2_Dersler getDersler() {
		return dersler;
	}

	public void setDersler(H2_Dersler dersler) {
		this.dersler = dersler;
	}

	@Override
	public String toString() {
		return "H1_Ogrenci [ogrId=" + ogrId + ", Ad=" + Ad + ", ogrNot=" + ogrNot + ", dersler=" + dersler + "]";
	}
	
	
}
