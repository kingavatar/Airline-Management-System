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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AIRLINE_RESERVATION")
public class AIRLINE_RESERVATION {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id",unique = true, nullable = false)
	private int reservation_id;
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=TICKET.class,cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "reservation_id", referencedColumnName="reservation_id")
	private Set<TICKET> tickets = new HashSet<TICKET>();
	public Set<TICKET> getTickets() {
		return tickets;
	}
	public void setTickets(TICKET ticket) {
		this.tickets.add(ticket);
	}

	@Column(name = "reservation_date",length=10)
	private String reservation_date;
	@Column(name = "seat_price",length=5)
	private int seat_price;
	@ManyToOne
	@JoinColumn(name="passenger_id")
	private PASSENGER passenger;
	public PASSENGER getPassenger() {
		return passenger;
	}
	public void setPassenger(PASSENGER passenger) {
		this.passenger = passenger;
	}
	@ManyToOne
	@JoinColumn(name="admin_id")
	private ADMIN admin;
	public ADMIN getAdmin() {
		return admin;
	}
	public void setAdmin(ADMIN admin) {
		this.admin = admin;
	}
	public AIRLINE_RESERVATION() {
		
	}
	public AIRLINE_RESERVATION(String reservation_date, int seat_price) {
		this.reservation_date = reservation_date;
		this.seat_price = seat_price;
		
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public int getSeat_price() {
		return seat_price;
	}
	public void setSeat_price(int seat_price) {
		this.seat_price = seat_price;
	}
	
	
}
