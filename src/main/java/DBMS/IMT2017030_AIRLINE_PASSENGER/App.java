package DBMS.IMT2017030_AIRLINE_PASSENGER;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//Roll Number : IMT2017030 Name: Saikiran Reddy
public class App 
{
    public static void main( String[] args )
    {
    		Configuration cfg = new Configuration().configure()
    				.addAnnotatedClass(PASSENGER.class)
    				.addAnnotatedClass(ADMIN.class)
    				.addAnnotatedClass(AIRLINE_RESERVATION.class)
    				.addAnnotatedClass(TICKET.class);
    		SessionFactory factory = cfg.buildSessionFactory();
		    Session session = factory.openSession();
		    System sys = new System(session);
		    Display display = new Display();
		    Shell shell = new Shell(display,SWT.SHELL_TRIM & (~SWT.MAX));
		    shell.setSize(250, 500);
		    shell.setLayout(new GridLayout(1,false));
		    final Composite contentPanel = new Composite(shell, SWT.BORDER);
//		    contentPanel.setBounds(100, 10, 680, 590);
		    final StackLayout layout = new StackLayout();
		    
		    contentPanel.setLayout(layout);
		    final FirstWindow welcomewin = new FirstWindow(contentPanel, SWT.NONE); 
		    layout.topControl = welcomewin;
		    welcomewin.setParent_layout(layout);
		    welcomewin.setSystem(sys);
		    
		    final PassengerWindow passwin = new PassengerWindow(contentPanel, SWT.NONE);
		   
//		    final AdminWindow adminwin  = new AdminWindow(contentPanel, SWT.NONE);
		    Button pageButton = new Button(shell, SWT.PUSH );
		    pageButton.setText("Home");
//		    pageButton.setBounds(10, 10, 80, 25);
		    pageButton.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,false,false));
		    pageButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		        layout.topControl = welcomewin;
		        contentPanel.layout();
		      }
		    });
		   
		    shell.pack();
		    shell.open();
		    while(!shell.isDisposed()) {
		    	if(!display.readAndDispatch()) {
		    		display.sleep();
		    	}
		    	
		    }
		    display.dispose();
		    session.close();
		    factory.close();
    }
}
