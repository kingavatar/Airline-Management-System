package DBMS.IMT2017030_AIRLINE_PASSENGER;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.eclipse.swt.widgets.Button;

public class ReservationWindow extends Composite {

	private StackLayout parent_layout;
	private System sys;
	final private Combo Admincombo;
	private passeneger_control back_parent;
	
	public System getSys() {
		return sys;
	}

	public void setSys(System sys) {
		this.sys = sys;
		ArrayList<String> names = new ArrayList<String>();
		for(ADMIN admin : sys.getAdmins()) {
			names.add(admin.getAdmin_name());
		}
		String[] strnames = new String[names.size()];
		strnames = names.toArray(strnames);
		this.Admincombo.setItems(strnames);
	}

	public StackLayout getstLayout() {
		return parent_layout;
	}

	public passeneger_control getBack_parent() {
		return back_parent;
	}

	public void setBack_parent(passeneger_control back_parent) {
		this.back_parent = back_parent;
	}

	public void setstLayout(StackLayout layout) {
		this.parent_layout = layout;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ReservationWindow(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent;
		setLayout(new GridLayout(3, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 12, SWT.BOLD));
		TitleLabel.setText("Ticket Details");
		new Label(this, SWT.NONE);
		
		Label AdminLabel = new Label(this, SWT.NONE);
		AdminLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		AdminLabel.setText("Admin");
		
		Admincombo = new Combo(this, SWT.NONE);
		Admincombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		final Label ClassLabel = new Label(this, SWT.NONE);
		ClassLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		ClassLabel.setText("Class");
		
		final Combo Classcombo = new Combo(this, SWT.NONE);
		Classcombo.setItems(new String[] {"Economy", "Premium"});
		Classcombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		final Label PriceLabel = new Label(this, SWT.NONE);
		PriceLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		PriceLabel.setText("Price");
		
		final Combo Pricecombo = new Combo(this, SWT.NONE);
		Pricecombo.setItems(new String[] {"100", "420", "1500"});
		Pricecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		final Label SeatLabel = new Label(this, SWT.NONE);
		SeatLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		SeatLabel.setText("Seat");
		
		final Combo Seatcombo = new Combo(this, SWT.NONE);
		Seatcombo.setItems(new String[] {"win", "non"});
		Seatcombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(this, SWT.NONE);
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setText("Cancel");
		
		Button btnBook = new Button(this, SWT.NONE);
		btnBook.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnBook.setText("Book");
		
		btnBook.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	  if(!Pricecombo.getText().equals("") && !Seatcombo.getText().equals("") && !Classcombo.getText().equals(""))
		    	  {sys.book_ticket(back_parent.getPassenger(),sys.getAdmins().get(Admincombo.getItemCount()-1),
		    			  Integer.parseInt(Pricecombo.getText()),Seatcombo.getText(), Classcombo.getText());
		    	  back_parent.getPassenger();  
		    	  parent_layout.topControl = back_parent;
			        parentshell.layout();
			      }
		    	  else {
		    		  if(Pricecombo.getText().equals("")) PriceLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		  if(Seatcombo.getText().equals("")) SeatLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		  if(Classcombo.getText().equals("")) ClassLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		  if(!Pricecombo.getText().equals("")) PriceLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    		  if(!Seatcombo.getText().equals("")) SeatLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    		  if(!Classcombo.getText().equals("")) ClassLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    	  }
		      }
			    });
		btnCancel.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {  
		    	   parent_layout.topControl = back_parent;
			        parentshell.layout();
			      }
			    });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
