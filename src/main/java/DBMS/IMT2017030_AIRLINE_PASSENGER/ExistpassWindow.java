package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class ExistpassWindow extends Composite {
	private Text passid;
	private Text name;
	private Text phone;
	private String types = "Passenger";
	private Label title=null;
	private Label id=null;
	private FirstWindow back_parent;
	private System sys;
	public FirstWindow getBack_parent() {
		return back_parent;
	}

	public void setBack_parent(FirstWindow back_parent) {
		this.back_parent = back_parent;
		sys = back_parent.getSystem();
	}



	public void settypes(String type) {
		this.types = type;
		if(this.title != null && this.id!=null) {
			title.setText("Enter "+types+" Details");
			id.setText(types+" ID");
		}
	}



	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ExistpassWindow(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent;
		setLayout(new GridLayout(3, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 14, SWT.BOLD));
		TitleLabel.setText("Enter "+types+" Details");
		title = TitleLabel;
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final Label passidLabel = new Label(this, SWT.NONE);
		passidLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		passidLabel.setText(types+" ID");
		id=passidLabel;
		
		passid = new Text(this, SWT.BORDER);
		passid.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label lblOr = new Label(this, SWT.NONE);
		lblOr.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblOr.setText("OR");
		new Label(this, SWT.NONE);
		
		final Label lblName = new Label(this, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		name = new Text(this, SWT.BORDER);
		name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		
		final Label lblPhone = new Label(this, SWT.NONE);
		lblPhone.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblPhone.setText("Phone Number");
		
		phone = new Text(this, SWT.BORDER);
		phone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final Label lblInfo = new Label(this, SWT.NONE);
		lblInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblInfo.setText("");
		lblInfo.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		new Label(this, SWT.NONE);
		
		Button btnback = new Button(this, SWT.NONE);
		btnback.setText("Back");
		btnback.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = back_parent.getParent_layout(); 
		    	   layout.topControl = back_parent;
			        parentshell.layout();
			      }
			    });
		
		Button btnnext = new Button(this, SWT.NONE);
		btnnext.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnnext.setText("Next");
		btnnext.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = back_parent.getParent_layout(); 
		    	   if(types.equalsIgnoreCase("Passenger")) {
		    	   int id= -1;
		    	   try {
		    	   if(!passid.getText().equals("")) id = Integer.parseInt(passid.getText());
		    	   }
		    	   catch (java.lang.NumberFormatException e) {
						lblInfo.setText("*Please Enter Integer Values");
						lblInfo.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
					}
		    	   if(id != -1 || (!name.getText().equals("") && !phone.getText().equals(""))) {
		    	   PASSENGER passenger = sys.nonndxpass(id, name.getText(), phone.getText());
		    	   if(passenger!=null) {
		    	   passeneger_control pControl= new passeneger_control(parentshell, SWT.NONE);
		    	   pControl.setPassenger(passenger);
		    	   pControl.setstLayout(layout);
		    	   pControl.setSystem(sys);
		    	   layout.topControl = pControl;
		    	   parentshell.layout();}
		    	   else{
		    	   lblInfo.setText("*Please Enter Valid Values into ID or Name or Phone"); 	
		    	   }
		    	   }
		    	   else {
		    		   lblInfo.setText("*Please Enter Values into ID or Name or Phone");
		    		   if(passid.getText().equals("")) passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		   if(!passid.getText().equals("")) passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    		   if(name.getText().equals("")) lblName.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		   if(!name.getText().equals("")) lblName.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    		   if(phone.getText().equals("")) lblPhone.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		   if(!phone.getText().equals("")) lblPhone.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    	   }   
		    	   }
		    	   else {
		    		   AdminControl aControl = new AdminControl(parentshell, SWT.NONE);
		    		   int id= -1;
		    		   try {
			    	   if(!passid.getText().equals("")) id = Integer.parseInt(passid.getText());
		    		   }
		    		   catch (java.lang.NumberFormatException e) {
							lblInfo.setText("*Please Enter Integer Values");
							lblInfo.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
						}
		    		   if(id != -1 || (!name.getText().equals("") && !phone.getText().equals("")))
		    		   {ADMIN admin = sys.nonndxadmin(id, name.getText(), phone.getText());
		    		   if(admin!=null) {
		    		   aControl.setAdmin(admin);
			    	   aControl.setParentLayout(layout);
			    	   aControl.setSys(sys);
			    	   layout.topControl = aControl;
			    	   parentshell.layout();}
			    	   else{
			    	   	 lblInfo.setText("*Please Enter Valid Values into ID or Name or Phone"); 
			    	   }
			    	   }
		    		else {
		    			lblInfo.setText("*Please Enter Values into ID or Name or Phone");
		    			if(passid.getText().equals("")) passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
			    		   if(!passid.getText().equals("")) passidLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			    		   if(name.getText().equals("")) lblName.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
			    		   if(!name.getText().equals("")) lblName.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			    		   if(phone.getText().equals("")) lblPhone.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
			    		   if(!phone.getText().equals("")) lblPhone.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
					}   
		    	   }
		      }
			    });
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
