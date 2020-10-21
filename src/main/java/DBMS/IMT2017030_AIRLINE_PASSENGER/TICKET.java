package DBMS.IMT2017030_AIRLINE_PASSENGER;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class TICKET {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id",unique = true, nullable = false)
	private int ticket_id;
	@Column(name = "destination" , length=30)
	private String destination;
	@Column(name = "seat_number" , length=5)
	private String seat_number;
	@Column(name = "departure_time" , length=30)
	private String departure_time;
	@Column(name = "ticket_class" , length=15)
	private String ticket_class;
	
	
	public TICKET() {
		
	}
	public TICKET(String destination, String seat_number, String departure_time, String ticket_class,
			AIRLINE_RESERVATION airline_reservation) {
		this.destination = destination;
		this.seat_number = seat_number;
		this.departure_time = departure_time;
		this.ticket_class = ticket_class;
		this.airline_reservation = airline_reservation;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reservation_id")
	private AIRLINE_RESERVATION airline_reservation;
	
	public AIRLINE_RESERVATION getAirline_reservation() {
		return airline_reservation;
	}
	public void setAirline_reservation(AIRLINE_RESERVATION airline_reservation) {
		this.airline_reservation = airline_reservation;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getTicket_class() {
		return ticket_class;
	}
	public void setTicket_class(String ticket_class) {
		this.ticket_class = ticket_class;
	}
	

}
