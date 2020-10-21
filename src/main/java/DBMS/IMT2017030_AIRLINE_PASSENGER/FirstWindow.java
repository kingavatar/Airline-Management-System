package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class FirstWindow extends Composite {
	private StackLayout parent_layout;
	private System systems;
	
	public System getSystem() {
		return systems;
	}

	public void setSystem(System system) {
		this.systems = system;
	}

	public StackLayout getParent_layout() {
		return parent_layout;
	}

	public void setParent_layout(StackLayout parent_layout) {
		this.parent_layout = parent_layout;
	}
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FirstWindow(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent;
		final FirstWindow me = this;
		setFont(SWTResourceManager.getFont("Noto Sans", 14, SWT.NORMAL));
		setLayout(new GridLayout(1, false));
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 14, SWT.BOLD));
		TitleLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		TitleLabel.setText("Welcome To Airline Passenger Management System");
		new Label(this, SWT.NONE);
		
		Group ButtonsGroup = new Group(this, SWT.NONE);
		ButtonsGroup.setLayout(new GridLayout(4, false));
		ButtonsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		
		Button createpassButton = new Button(ButtonsGroup, SWT.NONE);
		createpassButton.setText("Create Passenger");
		createpassButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(ButtonsGroup, SWT.NONE);
		
		Button passButton = new Button(ButtonsGroup, SWT.NONE);
		passButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		passButton.setText("Existing Passenger");
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		new Label(ButtonsGroup, SWT.NONE);
		
		Button createAdminButton = new Button(ButtonsGroup, SWT.NONE);
		createAdminButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		createAdminButton.setText("Create Admin");
		new Label(ButtonsGroup, SWT.NONE);
		
		Button adminButton = new Button(ButtonsGroup, SWT.NONE);
		adminButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		adminButton.setText("Existing Admin");

		createAdminButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = me.getParent_layout(); 
		    	    AdminWindow adminWindow = new AdminWindow(parentshell, SWT.NONE);
		    	    adminWindow.setBack_parent(me);
		    	    layout.topControl =adminWindow;
			        parentshell.layout();
			      }
			    });
		createpassButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = me.getParent_layout(); 
		    	    PassengerWindow passengerWindow= new PassengerWindow(parentshell, SWT.NONE);
		    	    passengerWindow.setBack_parent(me);
		    	    layout.topControl = passengerWindow;
		    	    parentshell.layout();
			      }
			    });
		passButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = me.getParent_layout(); 
		    	   ExistpassWindow existpassWindow =  new ExistpassWindow(parentshell, SWT.NONE);
		    	   existpassWindow.setBack_parent(me);		    	  
		    	   layout.topControl = existpassWindow;
			       parentshell.layout();
			      }
			    });
		adminButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = me.getParent_layout(); 
		    	   ExistpassWindow existpassWindow =  new ExistpassWindow(parentshell, SWT.NONE);
		    	   existpassWindow.settypes("Admin");
		    	   existpassWindow.setBack_parent(me);
		    	   layout.topControl = existpassWindow;
			       parentshell.layout();
			      }
			    });
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
