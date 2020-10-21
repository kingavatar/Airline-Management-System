package DBMS.IMT2017030_AIRLINE_PASSENGER;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "PASSENGER", uniqueConstraints = @UniqueConstraint(columnNames = {"passenger_name","phone"}))
public class PASSENGER {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id",unique = true, nullable = false)
	private int passeneger_id;
	@Column(name = "passenger_name" , length=30)
	private String passenger_name;
	@Column(name = "phone" , length=13)
	private String phone;
	@Column(name = "age")
	private int age;
	@Column(name = "pincode")
	private int pincode;
	@Column(name = "gender")
	private char gender;
	@Column(name = "address", length = 100)
	private String address;
	@Column(name = "city" , length=30)
	private String city;
	@Column(name = "state" , length=30)
	private String state;
	@Column(name = "nationality" , length=30)
	private String nationality;
	@Column(name = "departure_time" , length=30)
	private String departure_time;
	@Column(name = "destination" , length=30)
	private String destination;
	
	public PASSENGER() {
		
	}
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=AIRLINE_RESERVATION.class)
	@JoinColumn(name = "passenger_id", referencedColumnName="passenger_id")
	private Set<AIRLINE_RESERVATION> reservations= new HashSet<AIRLINE_RESERVATION>();


	public Set<AIRLINE_RESERVATION> getReservations() {
		return reservations;
	}

	public void setReservations(AIRLINE_RESERVATION reservation) {
		this.reservations.add(reservation);
	}

	public PASSENGER(String passenger_name, String phone, int age, int pincode, char gender, String address,
			String city, String state, String nationality, String departure_time, String destination) {
		
		this.passenger_name = passenger_name;
		this.phone = phone;
		this.age = age;
		this.pincode = pincode;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.nationality = nationality;
		this.departure_time = departure_time;
		this.destination = destination;
	}

	public int getPasseneger_id() {
		return passeneger_id;
	}

	public void setPasseneger_id(int passeneger_id) {
		this.passeneger_id = passeneger_id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}

