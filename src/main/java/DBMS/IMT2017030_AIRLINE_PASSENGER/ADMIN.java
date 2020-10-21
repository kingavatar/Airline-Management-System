package DBMS.IMT2017030_AIRLINE_PASSENGER;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ADMIN" , uniqueConstraints = @UniqueConstraint(columnNames = {"admin_name","system_phone"}))
public class ADMIN {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id" ,unique = true, nullable = false)
	private int admin_id;
	@Column(name = "admin_name", length = 30)
	private String admin_name;
	@Column(name = "system_phone", length = 13)
	private String system_phone;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AIRLINE_RESERVATION.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "admin_id", referencedColumnName="admin_id")
	private Set<AIRLINE_RESERVATION> reservations = new HashSet<AIRLINE_RESERVATION>();


	public Set<AIRLINE_RESERVATION> getReservations() {
		return reservations;
	}

	public void setReservations(AIRLINE_RESERVATION reservation) {
		this.reservations.add(reservation);
	}
	public ADMIN() {
		
	}
	
	public ADMIN(String admin_name, String system_phone) {
		
		this.admin_name = admin_name;
		this.system_phone = system_phone;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getSystem_phone() {
		return system_phone;
	}
	public void setSystem_phone(String system_phone) {
		this.system_phone = system_phone;
	}
	
}
