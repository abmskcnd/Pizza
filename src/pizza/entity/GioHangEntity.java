package pizza.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Transactional
@Entity
@Table(name="GioHang")
public class GioHangEntity {
	@Id
	@GeneratedValue
	@Column(name="id_giohang")
	private String id_giohang;
	@ManyToOne
	@JoinColumn(name="iduser")
	private TaiKhoanEntity user;
	@OneToMany(mappedBy="gh",fetch = FetchType.EAGER)
	private Collection<CTGHEntity> ghs;
	@Column(name="total")
	private int total;
	@Column(name="tt")
	private boolean tt;
	public String getId_giohang() {
		return id_giohang;
	}
	public void setId_giohang(String id_giohang) {
		this.id_giohang = id_giohang;
	}
	public TaiKhoanEntity getUser() {
		return user;
	}
	public void setUser(TaiKhoanEntity user) {
		this.user = user;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isTt() {
		return tt;
	}
	public void setTt(boolean tt) {
		this.tt = tt;
	}
	public Collection<CTGHEntity> getGhs() {
		return ghs;
	}
	public void setGhs(Collection<CTGHEntity> ghs) {
		this.ghs = ghs;
	}



	
	
	
}
