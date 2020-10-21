package DBMS.IMT2017030_AIRLINE_PASSENGER;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;




public class System {
	public <T> List<T> loadAllData(Class<T> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    
	    return data;
	  }
	private ArrayList<PASSENGER> passengers = new ArrayList<PASSENGER>();
	private ArrayList<ADMIN> admins = new ArrayList<ADMIN>();
	public ArrayList<ADMIN> getAdmins() {
		
		return admins;
	}

	public void setAdmins(ArrayList<ADMIN> admins) {
		this.admins = admins;
	}
	private ArrayList<AIRLINE_RESERVATION> airline_RESERVATIONs = new ArrayList<AIRLINE_RESERVATION>();
	private ArrayList<TICKET> tickets = new ArrayList<TICKET>();
	private Session session;
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public System() {
		
	}
	
	public System(Session session) {
		this.session = session;
		passengers = new ArrayList<PASSENGER>(session.createCriteria(PASSENGER.class).list());
		admins = new ArrayList<ADMIN>(session.createCriteria(ADMIN.class).list());
		airline_RESERVATIONs = new ArrayList<AIRLINE_RESERVATION>(session.createCriteria(AIRLINE_RESERVATION.class).list());
		tickets = new ArrayList<TICKET>(session.createCriteria(TICKET.class).list());
		
		}

	public PASSENGER create_passenger(String passenger_name, String phone, int age, int pincode, char gender, String address,
		String city, String state, String nationality, String departure_time, String destination) {
		PASSENGER passenger = new PASSENGER(passenger_name,phone,age,pincode,gender,address,city,state,nationality,departure_time,destination);
		
		Transaction tx = session.beginTransaction();
		session.save(passenger);
		session.persist(passenger);
		passengers.add(passenger);
		tx.commit();
		return passenger;
	}
	
	
	public ADMIN create_admin(String admin_name, String system_phone) {
	  ADMIN admin = new ADMIN(admin_name,system_phone);
	  Transaction tx = session.beginTransaction();
	  session.save(admin);
	  session.persist(admin);
	  tx.commit();
	  admins.add(admin);
	  return admin;
	}
	
	public AIRLINE_RESERVATION create_reservation(ADMIN admin,PASSENGER passenger, String reservation_date, int seat_price) {
		AIRLINE_RESERVATION airline_RESERVATION = new AIRLINE_RESERVATION(reservation_date,seat_price);
		airline_RESERVATION.setPassenger(passenger);
		airline_RESERVATION.setAdmin(admin);
 		passenger.setReservations(airline_RESERVATION);
		admin.setReservations(airline_RESERVATION);
		Transaction tx = session.beginTransaction();
		session.save(airline_RESERVATION);
		session.persist(airline_RESERVATION);
		tx.commit();
		airline_RESERVATIONs.add(airline_RESERVATION);
		return airline_RESERVATION;
	}
	public TICKET create_ticket(String destination, String seat_number, String departure_time, String ticket_class,
			AIRLINE_RESERVATION airline_reservation) {
			TICKET ticket = new TICKET(destination,seat_number,departure_time,ticket_class,airline_reservation);
			airline_reservation.setTickets(ticket);
			ticket.setAirline_reservation(airline_reservation);
			Transaction tx = session.beginTransaction();
			session.save(ticket);
			session.persist(ticket);
			tx.commit();
			tickets.add(ticket);
			return ticket;
			}
	
	public void delete(Class<?> class_name,int id) {
			Transaction tx = session.beginTransaction();
			Object element = session.load(class_name,id);
			
			if(class_name == ADMIN.class) admins.remove(element);
			else if(class_name == PASSENGER.class) passengers.remove(element);
			else if(class_name == AIRLINE_RESERVATION.class) { 
				((AIRLINE_RESERVATION)element).getAdmin().getReservations().remove(element);
				((AIRLINE_RESERVATION)element).getPassenger().getReservations().remove(element);
				airline_RESERVATIONs.remove(element);}
			else if(class_name == TICKET.class) { 
				((TICKET)element).getAirline_reservation().getTickets().remove(element);
				tickets.remove(element);}
			session.delete(element);
			tx.commit();
	}
	
	public Object load(Class<?> class_name,int id){
		Transaction tx = session.beginTransaction();
		Object element = session.load(class_name,id);
		tx.commit();
		return element;
	}
	public ADMIN nonndxadmin(int id,String name,String Phone) {
	for(ADMIN admin: admins) {
		if(id == -1) {
			if(admin.getAdmin_name().contentEquals(name) && admin.getSystem_phone().equals(Phone)) {
				return admin;
			}
		}
		else {
			if(admin.getAdmin_id()==id) {
				return admin;
			}
		}
	}
	return null;
	}
	public PASSENGER nonndxpass(int id,String name,String Phone) {
		for(PASSENGER passenger: passengers) {
			if(id == -1) {
				if(passenger.getPassenger_name().contentEquals(name) && passenger.getPhone().equals(Phone)) {
					return passenger;
				}
			}
			else {
				if(passenger.getPasseneger_id()==id) {
					return passenger;
				}
			}
		}
		return null;
		}
	public int book_ticket(PASSENGER passenger,ADMIN admin,int price,String seat,String ticket_class) {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String timing = sdf.format(cal.getTime());
        AIRLINE_RESERVATION reservation = create_reservation(admin, passenger,timing, price);
		TICKET ticket = create_ticket(passenger.getDestination(), seat, passenger.getDeparture_time(), ticket_class,reservation);
		return ticket.getTicket_id();
	}
	public static <T> T getLastElement(final Set<T> elements) {
	    T lastElement = null;
	    if(elements != null)
	    for (T element : elements) {
	        lastElement = element;
	    }
	    
	    return lastElement;
	}
	
}
