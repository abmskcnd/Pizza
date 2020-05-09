package pizza.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name="CTGH")
public class CTGHEntity {
	@Id
	@GeneratedValue
	@Column(name="id_ctgh")
	private String id_ctgh;
	@ManyToOne
	@JoinColumn(name="idgh")
	private GioHangEntity gh;
	@ManyToOne
	@JoinColumn(name="idpizza")
	private PizzaEntity pizza;
	@ManyToOne
	@JoinColumn(name="idkt")
	private KichThuocEntity kt;
	@Column(name="sl")
	private int sl;
	public String getId_ctgh() {
		return id_ctgh;
	}
	public void setId_ctgh(String id_ctgh) {
		this.id_ctgh = id_ctgh;
	}
	public GioHangEntity getGh() {
		return gh;
	}
	public void setGh(GioHangEntity gh) {
		this.gh = gh;
	}
	public PizzaEntity getPizza() {
		return pizza;
	}
	public void setPizza(PizzaEntity pizza) {
		this.pizza = pizza;
	}
	public KichThuocEntity getKt() {
		return kt;
	}
	public void setKt(KichThuocEntity kt) {
		this.kt = kt;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	
	
	
	
	
	
}
