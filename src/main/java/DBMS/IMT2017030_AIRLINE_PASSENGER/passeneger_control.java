package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.eclipse.swt.widgets.List;

public class passeneger_control extends Composite {
	private StackLayout stlayout;
	private PASSENGER passenger;
	private Label lblpassid;
	private Label lblpassname;
	public PASSENGER getPassenger() {
		return passenger;
	}
	private System systems;
	public System getSystem() {
		return systems;
	}

	public void setSystem(System system) {
		this.systems = system;
	}

	public void setPassenger(PASSENGER passenger) {
		this.passenger = passenger;
		lblpassid.setText("ID : "+String.valueOf(passenger.getPasseneger_id()));
		lblpassname.setText("NAME : "+passenger.getPassenger_name());
	}

	public StackLayout getstLayout() {
		return stlayout;
	}

	public void setstLayout(StackLayout layout) {
		this.stlayout = layout;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public passeneger_control(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent;
		final passeneger_control me = this;
		setLayout(new GridLayout(9, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 10, SWT.BOLD));
		TitleLabel.setText("PASSENEGER WINDOW");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Button btnbook = new Button(this, SWT.NONE);
		btnbook.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnbook.setText("Book Ticket");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		lblpassid = new Label(this, SWT.NONE);
		lblpassid.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblpassid.setText("ID : ");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Button btnCheckTicketStatus = new Button(this, SWT.NONE);
		btnCheckTicketStatus.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnCheckTicketStatus.setText("Check Ticket Status");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		lblpassname = new Label(this, SWT.NONE);
		lblpassname.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblpassname.setEnabled(false);
		lblpassname.setText("NAME : ");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Button btnCancelTicket = new Button(this, SWT.NONE);
		btnCancelTicket.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, false, 1, 1));
		btnCancelTicket.setText("Cancel Ticket");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final List Ticketlist = new List(this, SWT.BORDER);
		Ticketlist.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		btnbook.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   ReservationWindow reWindow = new ReservationWindow(parentshell, SWT.NONE);
		    	   reWindow.setBack_parent(me);
		    	   reWindow.setstLayout(stlayout);
		    	   reWindow.setSys(systems);
		    	   stlayout.topControl = reWindow;
			       parentshell.layout();
			      }
			    });
	   btnCancelTicket.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   AIRLINE_RESERVATION airline_RESERVATION = System.getLastElement(passenger.getReservations());
		    	   TICKET ticket = null;
		    	   if(airline_RESERVATION != null)
		    	   ticket = System.getLastElement(airline_RESERVATION.getTickets());
		    	   if(ticket != null)
		    	   systems.delete(TICKET.class, ticket.getTicket_id());
		    	   else {
		    		   Ticketlist.removeAll();
				       Ticketlist.add("No tickets to Cancel");
		    	   }
		    	   if(System.getLastElement(passenger.getReservations()) != null)
		    	   {
		    		   int res_id = System.getLastElement(passenger.getReservations()).getReservation_id();
		    	   systems.delete(AIRLINE_RESERVATION.class,System.getLastElement(passenger.getReservations()).getReservation_id());
		    	   Ticketlist.add("Cancelled RES ID: "+Integer.toString(res_id));}
		      }
			    });
	   btnCheckTicketStatus.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	  if(passenger.getReservations().size()>0) {
		    		  AIRLINE_RESERVATION airline_RESERVATION = System.getLastElement(passenger.getReservations());
		    		 TICKET ticket = System.getLastElement(airline_RESERVATION.getTickets());   
		    	  	if(ticket != null) {
		    	  		Ticketlist.removeAll();
		    		 Ticketlist.add("ID : "+String.valueOf(ticket.getTicket_id()));
					Ticketlist.add("Seat No : "+ticket.getSeat_number());
					Ticketlist.add("Class : "+ticket.getTicket_class());
					Ticketlist.add("Departure_Time : "+ticket.getDeparture_time());
					Ticketlist.add("Destination : "+ticket.getDestination());
		    	  	}
		    	  	else {
		    	  		  Ticketlist.removeAll();
				    	  Ticketlist.add("Book a Ticket");
				      }
		    	  }	
		    	  else {
		    		  Ticketlist.removeAll();
		    	  Ticketlist.add("Book a Ticket");
		      }
					}
		    });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
