package DBMS.IMT2017030_AIRLINE_PASSENGER;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

public class AdminWindow extends Composite {
	private Text NameText;
	private Text PhoneText;
	private FirstWindow back_parent;
	private System sys;
	public FirstWindow getBack_parent() {
		return back_parent;
	}

	public void setBack_parent(FirstWindow back_parent) {
		this.back_parent = back_parent;
		sys = back_parent.getSystem();
	}
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public AdminWindow(Composite parent, int style) {
		super(parent, style);
		final Composite parentshell = parent; 
		final AdminWindow me = this;
		setLayout(new GridLayout(2, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label TitleLabel = new Label(this, SWT.NONE);
		TitleLabel.setFont(SWTResourceManager.getFont("Noto Sans", 12, SWT.BOLD));
		TitleLabel.setText("Admin Details");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final Label NameLabel = new Label(this, SWT.NONE);
		NameLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		NameLabel.setText("Name");
		
		NameText = new Text(this, SWT.BORDER);
		NameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	
		final Label PhoneLabel = new Label(this, SWT.NONE);
		PhoneLabel.setText("System Phone");
		PhoneLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		PhoneText = new Text(this, SWT.BORDER);
		PhoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		final Label lblInfo = new Label(this, SWT.NONE);
		lblInfo.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		lblInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCancel.setText("Cancel");
		btnCancel.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = back_parent.getParent_layout();
		    	   layout.topControl = back_parent;
			        parentshell.layout();
			      }
			    });
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnOk.setText("        Ok         ");
		btnOk.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   StackLayout layout = back_parent.getParent_layout();
		    	   if(!NameText.getText().equals("") && !PhoneText.getText().equals("")) {
		    	   ADMIN admin = sys.create_admin(NameText.getText(), PhoneText.getText());
		    	   AdminControl aControl = new AdminControl(parentshell, SWT.NONE);
		    	   aControl.setParentLayout(layout);
		    	   aControl.setAdmin(admin);
		    	   aControl.setSys(sys);
		    	   layout.topControl = aControl;
			        parentshell.layout();}
		    	   else {
		    		   lblInfo.setText("*Please Enter Values into Name and Phone Columns");
		    		   if(NameText.getText().equals("")) NameLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    	       if(!NameText.getText().equals("")) NameLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
				       if(PhoneText.getText().equals("")) PhoneLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_RED));
		    		   if(!PhoneText.getText().equals("")) PhoneLabel.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		    	   }
			      }
			    });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
