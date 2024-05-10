package sensor_priority.Com.multi.nw;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;
public class NodePlotting extends GUI
{	
	private static final long serialVersionUID = 3l;
	static JTextArea val;
	private String table,c,a;
	private int networkId;
	private Random r = new Random();
	int key = Global.ACCESS_KEY,cl=0,cls=0;
	Statement stmt = null;
	public NodePlotting(String table,int networkId,String type)
	{	
		this.table = table;
		this.networkId = networkId;
		//this.setUndecorated(true);	
		Container c=getContentPane();
		try
	    {
	    	con = DB.getConnection();
	    	//DB.initialize(con);
	    	stmt = con.createStatement();
	    	global = Global.getObject();
	    }	
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	    }
		this.setTitle("Project Set Up Window for ".toUpperCase()+type);
		
		c.setLayout(null);
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		jdp=new JDesktopPane();
		jdp.setBounds(0,50,dim.width-10,572);
		jdp.setLayout(null);
		jdp.setBackground(new Color(102,204,255));
		//adding menubar
		jmb=new JMenuBar();
		GUI.forMenuBar(jmb);
		jmb.setBorder(BorderFactory.createLoweredBevelBorder());
		//adding menu
		setJMenuBar(jmb);
		process=new JMenu("Main Menu");
		process.setMnemonic('m');
	//	features=new JMenu("Edit");
		//GUI.forMenu(features,'e');
		jmb.add(process);
		//adding menuitem in process menu
		start=new JMenuItem("Create Nodes");
		start.addActionListener(new starting());
		GUI.assign(start,'C');
		process.add(start);
		draw=new JMenuItem("Simulation Window");
		GUI.assign(draw,'B');
		process.add(draw);
		
		draw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new UserInterface();
				} catch (Exception e2) {
					e2.printStackTrace();
				} 	
			}
		});
		
		exit=new JMenuItem("Exit",new ImageIcon("Images//exit.gif"));
		exit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),"Enjoy"));
		GUI.assign(exit,'Q');
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,"Do you want to Exit from the Project ?","Confirmation",JOptionPane.YES_NO_OPTION);
				if(option==0) 
					System.exit(0);
				else
					JOptionPane.showMessageDialog(null,"Please Continue......","Thank you",JOptionPane.PLAIN_MESSAGE); 	
			}
		});
		
		
		process.add(exit);
		pan=new JPanel();
		pan.setLayout(new FlowLayout());
		pan.setBounds(0,0,dim.width,50);
		pan.setBackground(Color.black);
		
		but=new JButton("GO BACK");
		but.setSize(100,30);
		//button(but, "Click here to go to main form");
		pan.add(but);
		
		button=new JButton("CLEAR NODES IN ALL NETWORK");
		button.setSize(200,30);
		//button(but, "Click here to go to main form");
		pan.add(button);
		
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new SetUpFrame();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DB.initialize(con);
				plainMessage("Successfully cleared nodes in all network");
			}
		});
		
		details=new JLabel("PLOT THE NODES HERE");
		details.setFont(new Font("Verdana",Font.BOLD,15));
		details.setBounds(50,150,900,200);
		jdp.add(details);
		c.add(pan);
		c.add(jdp);
		
		pan1=new JPanel();
		pan1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Status Bar",1,2,new Font("Arial",Font.BOLD,12),Color.orange));
		pan1.setLayout(null);
		pan1.setBounds(0,dim.height-140,dim.width,80);
		pan1.setBackground(new Color(111,112,105));
		c.add(pan1);
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jsp.setBounds(118,14,500,60);
		GUI.textarea(jta);
		jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.DARK_GRAY)));
		pan1.add(jsp);
		
		
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	
		//actions
	
	  	GUI.desktop(jdp,Global.backgroundColour);
		GUI.forMenu(process,'m');
		GUI.forMenuBar(jmb);
		//end actions
		setLocation(0,0);
		setSize(dim);
		setJMenuBar(jmb);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(0);
	}
	
	
	private void clearAll()
	{
		try
	    {
	    	refresh.setEnabled(true);	
			draw.setEnabled(false);
			start.setEnabled(true);
			messagetext.setEnabled(true);
			sendertext.setEnabled(true);
			receivertext.setEnabled(true);
			but.setEnabled(true);
			messagetext.setText("");
			sendertext.setText("");
			receivertext.setText("");
			but.setEnabled(true);
			jdp.setToolTipText("");
			System.out.println("UserInterface.RUN "+UserInterface.RUN);
			for(int i=1;i<plot.length;i++){
				plot[i].setBackground(Global.nodesColour);
				plot[i].setToolTipText("");
			}
			dis.setVisible(false);
			Global.TOTAL_PATHS = 2;
	    }
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	    }
	}
	
	public class refreshing implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
				clearAll();
			}
		
	}
	public class starting implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
				if(table.equals("nodelog"))
					//warningMessage("Suggestion: Please plot atleast 7 nodes & 1 node for base station among them");
				details.setVisible(false);
				jdp.removeAll();
				numberofnodes=JOptionPane.showInputDialog(null,"Please Enter number of nodes");
                                 cl=0;
                                         
                                        
                                
				if(!numberofnodes.equals(""))
                                	numbers=Integer.parseInt(numberofnodes);	
                                
                                 c=JOptionPane.showInputDialog(null,"Please Enter number of cluster");
                                    cls=Integer.parseInt(c);
                                                         a="";
				
				if(numberofnodes==null || numberofnodes.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter the Number of nodes you want to plot","Input Needed as whole number!",JOptionPane.WARNING_MESSAGE);
				}
				else if(numberofnodes.length()>2)
				{
					JOptionPane.showMessageDialog(null,"Invalid Input Please enter atlest two nodes","Error!",JOptionPane.ERROR_MESSAGE);
				}
				else if(numbers<=Global.MAXIMUM_NODES)
				{
					jta.append(numberofnodes+" Nodes plotted for transaction \n");
					totalNodes = Integer.parseInt(numberofnodes.trim());
					start.setEnabled(false);
					plot=new JPanel[numbers+1];
					x=1;
					jdp.removeAll();
                                       //   JOptionPane.showMessageDialog(null,"Number "+numbers +" "+cls);
                                          
                                                                cl=numbers/cls;
                                                                //JOptionPane.showMessageDialog(null,"DDD"+cl);
					jdp.addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent me)
						{
							try
							{
							if(x > numbers)
							{	
								start.setEnabled(false);
							}else
							{
								int xpos=me.getX();
								int ypos=me.getY();
								int prohability = r.nextInt(4);
								int hackerKey = r.nextInt(1000);
                                                                int power=r.nextInt(75);
								int toBeAdd = 0;
                                                               
                                                                
                                                               
                                                                if(x<=cl)
                                                                {
                                                                    cls=0;
                                                                    
                                                                }
                                                                else if((x>=(cl+1)) && (x<=(cl+cl)))
                                                                {
                                                                    cls=1;
                                                                }
                                                                else
                                                                {
                                                                    cls=2;
                                                                }
                                                                        //.nextInt(Integer.parseInt(c));
                                                                a="Cluster"+cls;
								if(prohability==1 || prohability==2)
									toBeAdd = hackerKey;
								else
									toBeAdd = key;
								//String query = "insert into "+table+"(node,xpos,ypos,capacity,accesskey) values("+x+","+xpos+","+ypos+","+networkId+","+toBeAdd+"
String query = "insert into "+table+" (id,nodename,xpos,ypos,power,node,cluster) values("+x+","+x+","+xpos+","+ypos+","+power+","+x+",'"+a+"')";
								stmt.executeUpdate(query);
								//stmt.executeUpdate("update basestation set accesskey="+key);
							//	Thread.sleep(500);
								paintcompenents();
								JOptionPane.showMessageDialog(null,"Node "+x+"\t is ready","Success",JOptionPane.UNDEFINED_CONDITION);
							}
							x++;
							}catch(Exception gs)
							{
								JOptionPane.showMessageDialog(null,"Error in MouseAction\n"+gs);
								gs.printStackTrace();
							
							}
						}
					});
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Numbers must be less than "+Global.MAXIMUM_NODES,"Try Again!",JOptionPane.WARNING_MESSAGE);
			}
			}
		
	}
	//draw the nodes using the energy level 
	public void paintcompenents()
	{
		try
		{
			int k=1;
			ResultSet rty=DB.getResultSet(con,"select * from "+table+"");
		 	while(rty.next())
		 	{
				k=rty.getInt("node");
				int xx=rty.getInt("xpos");
				int yy=rty.getInt("ypos");
				plot[k]=new JPanel();
				plot[k].setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"Node"+k,2,3,new Font("Arial",Font.BOLD,8),Color.white));
				plot[k].setLayout(null);
				plot[k].setBounds(xx,yy,Global.nodeWidth,Global.nodeHeight);
				plot[k].setBackground(Global.tempNodesColour);
				jdp.add(plot[k]);
				Thread.sleep(200);
		  }
		  jdp.setToolTipText("");
		}
		catch(Exception r)
		{
			r.printStackTrace();
		}
	}

	public class stoping implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			paintcompenents();	
			draw.setEnabled(false);
			start.setEnabled(false);
			refresh.setEnabled(true);
			messagetext.setEnabled(true);
			sendertext.setEnabled(true);
			receivertext.setEnabled(true);
		}
		
	}
	
	static void log(String data)
	{
		jta.append(data+"\n");
	}
	
	public static void main(String args[])
	{
		try {
			new NodePlotting("net1",1,"INFRASTRUT");
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
}
