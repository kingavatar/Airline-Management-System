package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class AdminControl extends Composite {
	private Text text;
	private StackLayout parentLayout;
	private ADMIN admin;
	private System sys;
	private Label lbladminid;
	public System getSys() {
		return sys;
	}

	public void setSys(System sys) {
		this.sys = sys;
	}

	public ADMIN getAdmin() {
		return admin;
	}

	public void setAdmin(ADMIN admin) {
		this.admin = admin;
		lbladminid.setText("ID : "+String.valueOf(admin.getAdmin_id()));
	}

	public StackLayout getParentLayout() {
		return parentLayout;
	}

	public void setParentLayout(StackLayout parentLayout) {
		this.parentLayout = parentLayout;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AdminControl(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent;
		setLayout(new GridLayout(9, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		TitleLabel.setText("Admin Control");
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
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		lbladminid = new Label(this, SWT.NONE);
		lbladminid.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lbladminid.setText("ID  : ");
		
		final Label passidLabel = new Label(this, SWT.NONE);
		passidLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		passidLabel.setText("Passenger ID");
		new Label(this, SWT.NONE);
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnCancel.setText("Cancel Flight");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Button btnSearchPassengerDetails = new Button(this, SWT.NONE);
		btnSearchPassengerDetails.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnSearchPassengerDetails.setText("Search Passenger Details");
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final List list = new List(this, SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(this, SWT.NONE);
		
		btnCancel.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   if(admin.getReservations().size()>0) {
		    		   java.util.List<AIRLINE_RESERVATION> reservations = new ArrayList<AIRLINE_RESERVATION>(admin.getReservations());
		    		   for(AIRLINE_RESERVATION reservation : reservations) {
		    			   if(reservation.getTickets().size()>0) {
		    				   for(TICKET ticket : reservation.getTickets()) {
		    					   sys.delete(TICKET.class,ticket.getTicket_id());
		    				   }
		    			   }
		    			   sys.delete(AIRLINE_RESERVATION.class,reservation.getReservation_id());
		    		   }
		    	   }
		    	   list.removeAll();
		    	   list.add("All Reservations are Cancelled");
		    	   passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			      }
			    });
		btnSearchPassengerDetails.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	  PASSENGER passenger = null;
		    	  if(!text.getText().equals("")) {
		    		  try {
		    		  passenger = sys.nonndxpass(Integer.parseInt(text.getText()), null,null);}
		    		  catch (java.lang.NumberFormatException e) {
		    			  list.removeAll();
			    		  list.add("Please enter VALID passenger ID");
			    		  passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
					}
		    		  if(passenger!=null) {
		    			  passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    			  list.removeAll();
		    			  list.add("ID : "+String.valueOf(passenger.getPasseneger_id()));
		    			  list.add("Name : "+passenger.getPassenger_name());
		    			  list.add("Gender : "+passenger.getGender());
		    			  list.add("Age : "+passenger.getAge());
		    			  list.add("Phone : "+passenger.getPhone());
		    			  list.add("Address : "+passenger.getAddress());
		    			  list.add("City : "+passenger.getCity());
		    			  list.add("Nationality : "+passenger.getNationality());
		    			  list.add("State : "+passenger.getState());
		    			  list.add("Pincode : "+passenger.getPincode());
		    		  }
		    		  else {
		    			  list.removeAll();
			    		  list.add("Please enter VALID passenger ID");
			    		  passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		  }
		    	  }
		    	  else {
		    		  list.removeAll();
		    		  list.add("Please enter passenger ID");
		    		  passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    	  }
			      }
			    });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
