package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;

import com.sun.xml.bind.v2.runtime.unmarshaller.UnmarshallingContext.State;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Event;

public class PassengerWindow extends Composite {
	private Text NameText;
	private Text PhoneText;
	private Text AgeText;
	private Text PincodeText;
	private Text AddressText;
	private Text CityText;
	private Text StateText;
	private Text NationalityText;
	private Text DepartureTimeText;
	private Text DestinationText;
	private System systemcla;
	private StackLayout parent_layout;
	private FirstWindow back_parent;
	public FirstWindow getBack_parent() {
		return back_parent;
	}

	public void setBack_parent(FirstWindow back_parent) {
		this.back_parent = back_parent;
		systemcla = back_parent.getSystem();
	}
	public StackLayout getParent_layout() {
		return parent_layout;
	}

	public void setParent_layout(StackLayout parent_layout) {
		this.parent_layout = parent_layout;
	}

	public System getSystem() {
		return systemcla;
	}

	public void setSystem(System system) {
		this.systemcla = system;
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PassengerWindow(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent; 
		setLayout(new GridLayout(2, false));
		final Composite shell= parent;
		final Composite composite = this;
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 12, SWT.BOLD));
		TitleLabel.setText("Passengers Details");
		final Label NameLabel = new Label(this, SWT.NONE);
		NameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		NameLabel.setText("Name");
		
		NameText = new Text(this, SWT.BORDER);
		NameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label PhoneLabel = new Label(this, SWT.NONE);
		PhoneLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		PhoneLabel.setText("Phone");
		
		PhoneText = new Text(this, SWT.BORDER);
		PhoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label AgeLabel = new Label(this, SWT.NONE);
		AgeLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		AgeLabel.setText("Age");
		
		AgeText = new Text(this, SWT.BORDER);
		AgeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label PincodeLabel = new Label(this, SWT.NONE);
		PincodeLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		PincodeLabel.setText("Pincode");
		
		PincodeText = new Text(this, SWT.BORDER);
		PincodeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label GenderLabel = new Label(this, SWT.NONE);
		GenderLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		GenderLabel.setText("Gender");
		
		final Combo GenderCombo = new Combo(this, SWT.NONE);
		GenderCombo.setItems(new String[] {"M", "F ", "O"});
		GenderCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label AddressLabel = new Label(this, SWT.NONE);
		AddressLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		AddressLabel.setText("Address");
		
		AddressText = new Text(this, SWT.BORDER | SWT.MULTI);
		AddressText.setFont(SWTResourceManager.getFont("Noto Sans", 9, SWT.NORMAL));
		AddressText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		new Label(this, SWT.NONE);
		
		final Label CityLabel = new Label(this, SWT.NONE);
		CityLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		CityLabel.setText("City");
		
		CityText = new Text(this, SWT.BORDER);
		CityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label StateLabel = new Label(this, SWT.NONE);
		StateLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		StateLabel.setText("State");
		
		StateText = new Text(this, SWT.BORDER);
		StateText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label NationalityLabel = new Label(this, SWT.NONE);
		NationalityLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		NationalityLabel.setText("Nationality");
		
		NationalityText = new Text(this, SWT.BORDER);
		NationalityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label DepartureTimeLabel = new Label(this, SWT.NONE);
		DepartureTimeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		DepartureTimeLabel.setText("Departure Time");
		
		DepartureTimeText = new Text(this, SWT.BORDER);
		DepartureTimeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label DestinationLabel = new Label(this, SWT.NONE);
		DestinationLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		DestinationLabel.setText("Destination");
		
		DestinationText = new Text(this, SWT.BORDER);
		DestinationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		          switch (e.type) {
		          case SWT.Selection:
		        	  StackLayout layout = back_parent.getParent_layout(); 
			    	   layout.topControl = back_parent;
				        parentshell.layout();
		            break;
		          }
		        }
		      });
		
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		          switch (e.type) {
		          case SWT.Selection:
		            if(!NameText.getText().equals("") && !PhoneText.getText().equals("") && !AgeText.getText().equals("") && 
		            	!PincodeText.getText().equals("") && !AddressText.getText().equals("") && !CityText.getText().equals("")  &&
		            	!StateText.getText().equals("") && !NationalityText.getText().equals("")&& !DepartureTimeText.getText().equals("") 
		            	&& !DestinationText.getText().equals("") && !GenderCombo.getText().equals("")) {
		            PASSENGER passenger = systemcla.create_passenger(NameText.getText(), PhoneText.getText(), Integer.parseInt(AgeText.getText()), 
		            		Integer.parseInt(PincodeText.getText()),GenderCombo.getText().charAt(0), AddressText.getText(), CityText.getText(),
		            		StateText.getText(), NationalityText.getText(), DepartureTimeText.getText(), DestinationText.getText());
		            StackLayout layout = back_parent.getParent_layout(); 
			    	passeneger_control pControl = new passeneger_control(parentshell, SWT.NONE);
			    	pControl.setPassenger(passenger);
			    	pControl.setstLayout(layout);
			    	pControl.setSystem(systemcla);
		            layout.topControl = pControl;
				    parentshell.layout();}
		            else {
		            	if(NameText.getText().equals("")) NameLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		            	if(!NameText.getText().equals("")) NameLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		            	if(PhoneText.getText().equals("")) PhoneLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		            	if(!PhoneText.getText().equals("")) PhoneLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		            	if(AgeText.getText().equals("")) AgeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		            	if(!AgeText.getText().equals("")) AgeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(PincodeText.getText().equals("")) PincodeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!PincodeText.getText().equals("")) PincodeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(GenderCombo.getText().equals("")) GenderLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!GenderCombo.getText().equals("")) GenderLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(AddressText.getText().equals("")) AddressLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!AddressText.getText().equals("")) AddressLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(CityText.getText().equals("")) CityLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!CityText.getText().equals("")) CityLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(StateText.getText().equals("")) StateLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!StateText.getText().equals("")) StateLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(NationalityText.getText().equals("")) NationalityLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!NationalityText.getText().equals("")) NationalityLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(DepartureTimeText.getText().equals("")) DepartureTimeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!DepartureTimeText.getText().equals("")) DepartureTimeLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				        if(DestinationText.getText().equals("")) DestinationLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
				        if(!DestinationText.getText().equals("")) DestinationLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		            }
		            break;
		          }
		        }
		      });
		btnOk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnOk.setText("       OK        ");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
}
