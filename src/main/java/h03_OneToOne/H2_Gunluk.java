package h03_OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gunlukler")
public class H2_Gunluk {   // PARENT

	
	@Id
	private int no;
	
	private String owner;

	@OneToOne
	@JoinColumn(name="kisi_id") // foreign key hangi isimle gozukecegine burada karar verdik
	private H1_Kisi kisi;
	
	public H2_Gunluk() {}
	
	public H2_Gunluk(int no, String owner) {
		super();
		this.no = no;
		this.owner = owner;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public H1_Kisi getKisi() {
		return kisi;
	}

	public void setKisi(H1_Kisi kisi) {
		this.kisi = kisi;
	}

	@Override
	public String toString() {
		return "H2_Gunluk [no=" + no + ", owner=" + owner + ", kisi=" + kisi + "]";
	}
	
	
	
}
