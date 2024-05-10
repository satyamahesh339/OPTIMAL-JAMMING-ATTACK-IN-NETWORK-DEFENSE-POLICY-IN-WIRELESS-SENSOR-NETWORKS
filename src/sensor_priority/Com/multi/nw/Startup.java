package sensor_priority.Com.multi.nw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Random;

public class Startup extends JFrame
{
	private static final long serialVersionUID = 3l;
	public static JTextArea jta;
	static JPanel panel,err[];
	JPanel main;
	JScrollPane jsp;
	Container c;
	JButton send,clear;
	String serverIp;
	static JCheckBox jcb;
	String processor;
	static JLabel lbl1,lbl2;
	JMenuBar jmb;
	JMenu menu;
	JMenuItem upload,cls;
	Connection con = DB.getConnection();
	public Startup() throws Exception
	{
	  super(" Intrusion Detection ");
	  Global.ACCESS_KEY = new Random().nextInt(1000);
//	  DB.executeUpdate(con, "update basestation set accesskey="+Global.ACCESS_KEY);
	  DB.initialize(con);
	  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	  c = getContentPane();
	  c.setBackground(Color.darkGray);
	  c.setLayout(null);
	  panel= new JPanel();
	  panel.setBounds(10,10,320,290);
	  panel.setBackground(Color.LIGHT_GRAY);
	  panel.setLayout(null);
	  c.add(panel);
	 
	  jta = new JTextArea();
	  jta.setForeground(new Color(103,119,130));
	  jta.setLineWrap(true);
	  jta.setFont(new Font("Italic",Font.BOLD,14));
	  jta.setEditable(false);
	  jsp = new JScrollPane(jta);
	  jsp.setBorder(BorderFactory.createTitledBorder("------- Welcome Screen -------"));
	  jsp.setBounds(10,10,300,200);
	  jta.setText("Intrusion Detection");
	  panel.add(jsp);

	  clear = new JButton("Exit");
	  GUI.button(clear,"Exit");
	  clear.addActionListener(new Exit());
	  clear.setBackground(Color.GRAY);
	  clear.setForeground(Color.white);
	  clear.setBounds(5,265,310,20);
	  panel.add(clear);
	  
	  jmb = new JMenuBar();
	   setJMenuBar(jmb);
	   
	   menu = new JMenu("Main Menu");
	   jmb.add(menu);
	  
	   cls = new JMenuItem("Set Up Frame");
	   menu.add(cls);
	   
	   upload = new JMenuItem("Simulation Window");
	   menu.add(upload);
	   
	   GUI.forMenuBar(jmb);
	   GUI.forMenu(menu,'M');
	   GUI.assign(cls,'C');
	   GUI.assign(upload,'U');
	  
	
	  cls.addActionListener(new Clear());
	  upload.addActionListener(new Uploads());
	  
	  main = new JPanel();
	  main.setBackground(Color.white);
	  main.setLayout(new FlowLayout());
	  main.setBounds(5,215,350,50);
	  panel.add(main);
	  
	  err = new JPanel[12];
	  for(int i=0;i<err.length;i++) {
	  	err[i] = new JPanel();
	  	err[i].setBorder(BorderFactory.createRaisedBevelBorder());
	  	main.add(err[i]);
	  }
	 
	  setSize(350,350);
	  setLocation(300,200);
	  setVisible(true);
	  setResizable(false);
	  setDefaultCloseOperation(3);
	}
	
	public class Clear implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				dispose();
				new SetUpFrame();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				System.exit(0);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public class Uploads implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				dispose();
				new UserInterface();
			}
			catch(Exception e1) 
			{
					e1.printStackTrace();
			}
		}
	}

	public static void main(String args[])  throws Exception
	{
		new Startup();
		for(int i=0;i<11;i++) {
			err[i].setBackground(Color.red);
			Thread.sleep(200);
			err[i].setBackground(Color.gray);
		}
		
	}
	
}
