package sensor_priority.Com.multi.nw;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableColumn;

public class UserInterface extends GUI {
	static final long serialVersionUID = 3; 
	int shortestRoute;
	public static String RUN = "MULTIPATH";
        ///private int cnt=0;
	static JTextArea val;
	int cluster = 0;
	int tot = 0,power=0;
	int routeNo = 1;
	ImageIcon icon = new ImageIcon("Images//nodes//ipp_0005.gif");
	SpinnerModel jsm;
	JSpinner js;
	String dataType,msg;
	
	private	JButton         button,history,dis;
	private	JLabel          label,label1,label2;
	private	JPanel          topPanel;
	String algorithm = "";
	String type;
	int trnId = 0;
	int singleLink = 0;
	int multipleLink = 0;
	int work = 0;
	int protection = 0;
	int time = 0;
	Container c;
	String message,atkmsg;
	int sourceNode;
	int destinationNode;
	int baseStationNumber;
	boolean sensorFlag = false;
	public UserInterface()
	{	
		//this.setUndecorated(true);
		c = getContentPane();
		try
	    {
	    	con = DB.getConnection();
	    	//DB.initialize(con);
	    	//DB.refresh(con);
	    	global = Global.getObject();
	    	Global.clearDir(Global.ENCRYPTED_DIR);
	    }	
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	    }
		this.setTitle(Global.TITLE);
		try
		{
		//create and start the database 
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		}catch(Exception mm)
		{
			System.out.println(mm.toString());
		}
		c.setLayout(null);
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		jdp=new JDesktopPane();
		jdp.setBounds(0,50,dim.width-10,572);
		jdp.setLayout(null);
		jdp.setBackground(new Color(102,204,255));
		//adding menubar
		jmb=new JMenuBar();
		GUI.forMenuBar(jmb);
		//adding menu
		process=new JMenu("Main Menu");
		process.setMnemonic('m');
		
		features=new JMenu("Edit");
//		GUI.forMenu(features,'e');
		
	
		
		//adding menuitem in process menu
		start=new JMenuItem("Set Up Frame");
		nodeinfo=new JMenuItem("Node Info");
                incbat=new JMenuItem("Battery Power");
            //    decbat=new JMenuItem("Decrease Battery Power");
		//refresh=new JMenuItem("Refresh");
		redraw=new JMenuItem("ReDraw");
		
		
		chooser=new JMenuItem("Color Chooser",new ImageIcon("Images//colors.jpg"));
		chooser.setToolTipText("Enjoy Color Chooser");
		chooser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),"Color Picker"));
		chooser.setMnemonic('C');
		
	
		
		help=new JMenuItem("HELP",new ImageIcon("Images//HelpCenter.gif"));
		help.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),""));
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,1));
		help.setFont(Global.menuitem_font); 
		help.setBackground(Global.menuitem_bg_clr);
		help.setForeground(Global.menuitem_fore_clr);
		help.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),""));
		help.setFont(Global.menuitem_font);
		
		exit=new JMenuItem("Exit",new ImageIcon("Images//exit.gif"));
		exit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),"Enjoy"));
		GUI.assign(exit,'Q');
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null,"Do you want to Exit from the Project?","Confirmation",JOptionPane.YES_NO_OPTION);
				if(option==0) 
					System.exit(0);
				else
					JOptionPane.showMessageDialog(null,"Please Continue......","Thank you",JOptionPane.PLAIN_MESSAGE); 	
			}
		});
		
		process.add(start);
	        process.add(nodeinfo);
                //process.add(incbat);
             //   process.add(decbat);
		//                process.add(refresh);
		process.add(redraw);
		process.add(exit);
	
		features.add(chooser);
		features.add(help);
		jmb.add(process);
	
		jmb.add(features);
		
		pan=new JPanel();
		pan.setLayout(new FlowLayout());
		pan.setBounds(0,0,dim.width,50);
                //pan.setBounds(0,0,50,20);
		pan.setBackground(Color.black); 
		jsm = new SpinnerListModel(dataTypeOptions);
		  ChangeListener cl = new ChangeListener()
		  {
		  	public void stateChanged(ChangeEvent ee)
		  	{
		  		SpinnerModel spm = (SpinnerModel)ee.getSource();
		  		dataType = (String)spm.getValue();
		  		
				 
				 	try {
							String table = "";
							if(dataType.trim()=="INFRASTRUT") {
								sensorFlag = false;
								table = "net1";
								plot=new JPanel[30];
								nl = new JLabel[30];
								jdp.removeAll();
								jdp.repaint();
								log("INFRASTRUT is the selected network");
								Thread.sleep(500);
								createNodes(table);
								sendertext.setEditable(false);
								setBaseStation();
							} else if(dataType.trim()=="NODECENTRIC") {
								sensorFlag = false;
								table = "net2";
								plot=new JPanel[30];
								nl = new JLabel[30];
								icon = new ImageIcon("Images//nodes//BD14866_.GIF");
								log("NODECENTRIC is the selected network");
								jdp.removeAll();
								jdp.repaint();
								Thread.sleep(500);
								createNodes(table);
								sendertext.setEditable(false);
								setBaseStation();
							} else if(dataType.trim()=="SENSOR") {
								sensorFlag = false;
								table = "net3";
								plot=new JPanel[30];
								nl = new JLabel[30];
								icon = new ImageIcon("Images//nodes//BD14578_.GIF");
								log("SENSOR is the selected network");
								jdp.removeAll();
								jdp.repaint();
								Thread.sleep(500);
								createNodes(table);
								//setBaseStation();
								warningMessage("Suggestion: Enter the Base Station Node no. & press enter key to assign the Base Station");
								senderlabel.setForeground(Color.WHITE);
								senderlabel.setText("Sink");
								sendertext.setEditable(true);
								sendertext.setBackground(Color.WHITE);
							} else if(dataType.trim()=="WSN") {
								sensorFlag = false;
								//table = "net4";
                                                                table = "nodelog";
								plot=new JPanel[30];
								nl = new JLabel[30];
								//icon = new ImageIcon("Images//nodes//BD10301_.GIF");
								log("WSN is the selected network");
								jdp.removeAll();
								jdp.repaint();
								Thread.sleep(500);
								senderlabel.setForeground(Color.WHITE);
								senderlabel.setText("Source Node");
								sendertext.setEditable(true);
								sendertext.setBackground(Color.WHITE);
								createNodes(table);
								setBaseStation();
							} 
				    } catch(Exception e){
				      e.printStackTrace();
				      JOptionPane.showMessageDialog(null,"Error in getting nodes "+e.toString());
				    }
				 
				 
				 ////////////////
		  	}
		  };
	  
	   jsm.addChangeListener(cl);
	  
	  js = new JSpinner(jsm);
	  try {
	  	
	  } catch(Exception e) {
	    e.printStackTrace();			
	  }	
	  
	  js.setBackground(Color.BLUE);
	  js.setForeground(Color.red);
	  js.setVisible(true);
				
		help.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try {
					new Help();
			    }
			    catch(Exception e){
			      e.printStackTrace();
			    }	
			}
		});
		
		messagelabel=new JLabel("Message");
		messagetext=new JTextField(10);
	
		pan.add(js);
		pan.add(messagelabel);
		pan.add(messagetext);
		senderlabel=new JLabel("Sink");
		sendertext=new JTextField(3);
		senderlabel.setForeground(Color.LIGHT_GRAY);
		sendertext.setEditable(false);
		sendertext.setBackground(Color.LIGHT_GRAY);
		
	
		
		sendertext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try {
					if(plot!=null){
						try {
							baseStationNumber = Integer.parseInt(sendertext.getText().trim());
							plot[baseStationNumber].setBackground(Color.white);
							sendertext.setEditable(false);
							sendertext.setBackground(Color.LIGHT_GRAY);
							senderlabel.setForeground(Color.LIGHT_GRAY);
							sensorFlag = true;
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Please enter the valid Base Station No.");
						}
					} else {
						JOptionPane.showMessageDialog(null,"Please plot the Nodes in the Network");
					}
			    }
			    catch(Exception e){
			      e.printStackTrace();
			    }	
			}
		});
	
		but=new JButton();
		but.setIcon(new ImageIcon("Images//Send.jpg"));
		//but.setRolloverIcon(new ImageIcon("green.gif"));
		but.setSize(100,30);
		but.addActionListener(new send());
		pan.add(senderlabel);
		pan.add(sendertext);
	
		button=new JButton("Attacker");
		button.setSize(150,30);
		button.setVisible(true);
		pan.add(but);
		//pan.add(button);
		
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				
			
                            msg=JOptionPane.showInputDialog(null,"Message to be Included");
			}
			
		}
		);
		
		
		messagelabel.setForeground(Color.yellow);
		senderlabel.setForeground(Color.LIGHT_GRAY);
	
		
		
		details=new JLabel("Position verification window");
		details.setFont(new Font("Verdana",Font.BOLD,15));
		details.setBounds(200,100,900,200);
		jdp.add(details);
		c.add(pan);
		c.add(jdp);
		pan1=new JPanel();
		pan1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Status Bar",1,2,new Font("Arial",Font.BOLD,12),Color.orange));
		pan1.setLayout(null);
		pan1.setBounds(0,dim.height-140,dim.width,80);
		pan1.setBackground(Global.menubar_bg_clr);
		c.add(pan1);
		
	
		
	
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setEditable(false);
		jta.setLineWrap(true);
		jsp.setBounds(170,14,600,60);
		GUI.textarea(jta);
		jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.DARK_GRAY)));
		pan1.add(jsp);
		
	
	
		//actions
		start.addActionListener(new starting());
                nodeinfo.addActionListener(new nodeinfo());
               incbat.addActionListener(new incbat());
               //decbat.addActionListener(new decbat());
		
		//refresh.addActionListener(new refreshing());
		chooser.addActionListener(new ColorChooser());
		
		//repaint the interface
		redraw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent se)
			{
				dispose();
				new UserInterface();
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				
			}
		});
		
		jdp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				//jdp.setToolTipText(e.getX()+":"+e.getY());
			}	
		 });
		
	 
	  	GUI.desktop(jdp,Global.backgroundColour);
		
		GUI.forMenu(process,'m');
		GUI.forMenuBar(jmb);
		jmb.setBorder(BorderFactory.createLoweredBevelBorder());
		GUI.assign(start,'1');
	            GUI.assign(nodeinfo,'2');
                    GUI.assign(incbat,'3');
		//GUI.assign(refresh,'4');
		GUI.assign(redraw,'4');
		GUI.assign(chooser,'C');
	
		GUI.textbox(messagetext);
	
		
		GUI.button(but,"Click Here to Send");
		
	
		//end actions
		setLocation(0,0);
		setSize(dim);
		setJMenuBar(jmb);
		setResizable(false);
		setDefaultCloseOperation(0);
		setVisible(true);
	}
	
	private void setBaseStation() {
		baseStationPanel=new JPanel();
		baseStationPanel.setLayout(null);
		baseStationPanel.setBounds(5,20,200,200);
		baseStationPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"Sink",2,3,new Font("Arial",Font.BOLD,12),Color.DARK_GRAY));
		jdp.add(baseStationPanel);
		
		/*baseStationJta = new JTextArea();
		baseStationJta.setBackground(Color.lightGray);
		baseStationJta.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(baseStationJta);
		jsp.setBounds(5,20,180,70);*/
                icon = new ImageIcon("Images//sinknode.PNG");
                JLabel bstation=new JLabel(icon);
                bstation.setBounds(5,20,180,150);
                baseStationPanel.add(bstation);
	}
	
	private synchronized void createNodes(String table) {
		try {
	    		Thread.sleep(500);
				
                       //String qry="select max(node) maxnode from "+table+" group by cluster where cluster='Cluster1'";
                        
                        
                        String qry3="select max(power) AS maxnode from nodelog where cluster='Cluster0'";        
                        ResultSet rr3=DB.getResultSet(con,qry3);
                        int nn3=0;
                                if (rr3.next())                        
                                {
                                 nn3=rr3.getInt("maxnode");
                                }
                                System.out.println("MAX POWER Cluster1 "+nn3);
                       
                        String qry="select max(power) AS maxnode from nodelog where cluster='Cluster1'";        
                        ResultSet rr=DB.getResultSet(con,qry);
                        int nn=0;
                                if (rr.next())                        
                                {
                                 nn=rr.getInt("maxnode");
                                }
                                System.out.println("MAX POWER Cluster1 "+nn);
                       
                         String qry1="select max(power) AS maxnode from nodelog where cluster='Cluster2'";        
                        ResultSet rr1=DB.getResultSet(con,qry1);
                        int nn1=0;
                                if (rr1.next())                        
                                {
                                 nn1=rr1.getInt("maxnode");
                                }
                                System.out.println("MAX POWER Cluster 2 "+nn1);
                        
                                
                                
                                
                         
                                String query = "select * from "+table;
				//System.out.println(" QUERY : "+query);
				ResultSet rty=DB.getResultSet(con,query);
                                String name="";
                                String cluster="";
				int k=1;
			 	while(rty.next())
			 	{
					k=rty.getInt("node");
					int xx=rty.getInt("xpos");
					int yy=rty.getInt("ypos");
                                        name=rty.getString("nodename");
                                        cluster=rty.getString("cluster");
                                        power=rty.getInt("power");
                                        if(cluster.equals("Cluster0"))
                                        {
                                        
                                            if(power==nn3)
                                            {
                                                icon = new ImageIcon("Images//nodes//dark-red-circle.PNG");
                                                plot[k]=new JPanel();
                                                nl[k] = new JLabel(icon);
                                                plot[k].setLayout(null);
                                                plot[k].setBackground(Global.backgroundColour);
                                                plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
                                               // nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                                 nl[k].setBounds(2,2,50,Global.nodeHeight);
                                                nl[k].setText(String.valueOf(k));
                                                //nl[k].setText(String.valueOf(name));
                                                nl[k].setFont(new Font("Arial",Font.BOLD,12));
                                                plot[k].add(nl[k]);
                                                jdp.add(plot[k]);
                                                Thread.sleep(10);
                                                String msg=String.valueOf(power);
                                                                plot[k].setToolTipText("Cluster Head 0 Power "+msg);
                                                   StringBuffer msg1=new StringBuffer();
                                               String qry101="select * from nodelog where cluster='Cluster0'  order by power desc";
                                                ResultSet rs101=DB.getResultSet(con,qry101);
                                                while(rs101.next())
                                                {
                                                    msg1.append("Cluster Member 0"+" "+rs101.getString("nodename")+" "+rs101.getString("power")+"  ");
                                                }
                                                 plot[k].setToolTipText("Cluster Head 0 Power "+msg+" "+msg1.toString());
                                               
                                                
                                            }
                                            else
                                            {
                                                icon = new ImageIcon("Images//nodes//BD10298_.GIF");
                                                plot[k]=new JPanel();
                                                nl[k] = new JLabel(icon);
                                                plot[k].setLayout(null);
                                                plot[k].setBackground(Global.backgroundColour);
                                                plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
                                                //nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                                nl[k].setBounds(2,2,50,Global.nodeHeight);
                                                nl[k].setText(String.valueOf(k));
                                                //nl[k].setText(String.valueOf(name));
                                                nl[k].setFont(new Font("Arial",Font.BOLD,12));
                                                plot[k].add(nl[k]);
                                                jdp.add(plot[k]);
                                                Thread.sleep(10);
                                                String msg=String.valueOf(power);
                                                plot[k].setToolTipText("Cluster 0 Member Power "+msg);
                                            }
                                        }
                                        else if(cluster.equals("Cluster1"))
                                        {
                                        
                                            if(power==nn)
                                            {
                                                icon = new ImageIcon("Images//nodes//dark-red-circle.PNG");
                                                plot[k]=new JPanel();
                                                nl[k] = new JLabel(icon);
                                                plot[k].setLayout(null);
                                                plot[k].setBackground(Global.backgroundColour);
                                                plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
                                               // nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                                 nl[k].setBounds(2,2,50,Global.nodeHeight);
                                                nl[k].setText(String.valueOf(k));
                                                //nl[k].setText(String.valueOf(name));
                                                nl[k].setFont(new Font("Arial",Font.BOLD,12));
                                                plot[k].add(nl[k]);
                                                jdp.add(plot[k]);
                                                Thread.sleep(10);
                                                String msg=String.valueOf(power);
                                                StringBuffer msg1=new StringBuffer();
                                                String qry101="select * from nodelog where cluster='Cluster1' order by power desc";
                                                ResultSet rs101=DB.getResultSet(con,qry101);
                                                while(rs101.next())
                                                {
                                                    msg1.append("Cluster Member 1"+" "+rs101.getString("nodename")+" "+rs101.getString("power")+"\n");
                                                }
                                                
                                                
                                                                plot[k].setToolTipText("Cluster Head 1 Power "+msg+"\n"+msg1.toString());
                                            }
                                            else
                                            {
                                                icon = new ImageIcon("Images//nodes//BD10301_.GIF");
                                                plot[k]=new JPanel();
                                                nl[k] = new JLabel(icon);
                                                plot[k].setLayout(null);
                                                plot[k].setBackground(Global.backgroundColour);
                                                plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
                                                //nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                                nl[k].setBounds(2,2,50,Global.nodeHeight);
                                                nl[k].setText(String.valueOf(k));
                                                //nl[k].setText(String.valueOf(name));
                                                nl[k].setFont(new Font("Arial",Font.BOLD,12));
                                                plot[k].add(nl[k]);
                                                jdp.add(plot[k]);
                                                Thread.sleep(10);
                                                String msg=String.valueOf(power);
                                                plot[k].setToolTipText("Cluster 1 Member Power "+msg);
                                            }
                                        }
                                        else if(cluster.equals("Cluster2"))
                                        {
                                            if(power==nn1)
                                            {
                                                icon = new ImageIcon("Images//nodes//dark-red-circle.PNG");
                                                plot[k]=new JPanel();
                                                nl[k] = new JLabel(icon);
                                                plot[k].setLayout(null);
                                                plot[k].setBackground(Global.backgroundColour);
                                                plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
                                               // nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                                 nl[k].setBounds(2,2,50,Global.nodeHeight);
                                                nl[k].setText(String.valueOf(k));
                                                //nl[k].setText(String.valueOf(name));
                                                nl[k].setFont(new Font("Arial",Font.BOLD,12));
                                                plot[k].add(nl[k]);
                                                jdp.add(plot[k]);
                                                String msg=String.valueOf(power);
                                                
                                                StringBuffer msg1=new StringBuffer();
                                                String qry101="select * from nodelog where cluster='Cluster2'  order by power desc";
                                                ResultSet rs101=DB.getResultSet(con,qry101);
                                                while(rs101.next())
                                                {
                                                    msg1.append("Cluster Member 2"+" "+rs101.getString("nodename")+" "+rs101.getString("power")+"  ");
                                                }
                                                 plot[k].setToolTipText("Cluster Head 2 Power "+msg+" "+msg1.toString());
                                                Thread.sleep(10);
                                            }
                                            else
                                            {
                                        icon = new ImageIcon("Images//nodes//BD10297_.GIF");
                                        plot[k]=new JPanel();
					nl[k] = new JLabel(icon);
					plot[k].setLayout(null);
					plot[k].setBackground(Global.backgroundColour);
					plot[k].setBounds(xx,yy,(Global.nodeWidth+10),(Global.nodeHeight+10));
					//nl[k].setBounds(2,2,Global.nodeWidth,Global.nodeHeight);
                                         nl[k].setBounds(2,2,50,Global.nodeHeight);
					nl[k].setText(String.valueOf(k));
                                        //nl[k].setText(String.valueOf(name));
					nl[k].setFont(new Font("Arial",Font.BOLD,12));
					plot[k].add(nl[k]);
					jdp.add(plot[k]);
                                        String msg=String.valueOf(power);
                                                plot[k].setToolTipText("Cluster 2 Member Power "+msg);
					Thread.sleep(10);  
                                            }
                                        }
			  }
			  jdp.setToolTipText("");
					
	    } catch(Exception e) {
	      e.printStackTrace();			
	    }	
	}
	

	private void clearAll()
	{
		try
	    {
	    	
                        refresh.setEnabled(true);	
			//draw.setEnabled(false);
			start.setEnabled(true);
			messagetext.setEnabled(true);
			sendertext.setEnabled(true);
			receivertext.setEnabled(true);
			but.setEnabled(true);
			messagetext.setText("");
			sendertext.setText("");
			receivertext.setText("");
			but.setEnabled(true);
			DB.refresh(con);
			jdp.setToolTipText("");
			Thread.sleep(100);
		
			jdp.setBackground(Global.backgroundColour);
		
			Global.clearDir(Global.ENCRYPTED_DIR);
			Global.TOTAL_PATHS = 2;
			algorithm = "";
			label.setText("");
			val.setText("");
			label1.setText("Work");
			label2.setText("Protection");
			for(int i=1;i<plot.length;i++) {
				if(plot[i]!=null)
					plot[i].setBackground(Global.backgroundColour);
			}
			if("WSN".equals(dataType) || "SENSOR".equals(dataType)){
				senderlabel.setForeground(Color.WHITE);
				sendertext.setBackground(Color.WHITE);
				sendertext.setEditable(true);
			}
			baseStationJta.setText("");
                  
                
                new UserInterface();
	    }
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	    }
	}
	
	
	
	//refresh the interface items
	/*public class refreshing implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
				clearAll();
			}
		
	}*/
	public class starting implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				try {
					new SetUpFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
         public class incbat implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
                            new MainWindow().setVisible(true);
			}
		
	}
        
        
        public class nodeinfo implements ActionListener
	{
			public void actionPerformed(ActionEvent ae)
			{
				/*dispose();
				try {
					new SetUpFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
                                * */
                                String clus[]={"--Select--","Cluster1","Cluster2","Cluster3"};
                                Object clussel=JOptionPane.showInputDialog(null,"Select Cluster","Cluster Selection",JOptionPane.QUESTION_MESSAGE,null,clus,null);
                                clustername=(String)clussel;
                                
                                if(clustername.equals("--Select--"))
                                {
                                    JOptionPane.showMessageDialog(null,"Select Cluster ");
                                }
                                else
                                {
                                     if(clustername.equals("Cluster1"))      
                                     {
                                         clustername="Cluster1";
                                     }
                                     else if(clustername.equals("Cluster2"))
                                     {
                                         clustername="Cluster2";
                                     }
                                     else if(clustername.equals("Cluster3"))
                                     {
                                         clustername="Cluster3";
                                     }
                                      Vector columnNames = new Vector();
                                      Vector data = new Vector();
                                      JPanel p=new JPanel();
                                      try {
                                        /*   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            con = DriverManager.getConnection("jdbc:odbc:secure");
                                            * 
                                            * */
                                          
                                          
String url="jdbc:mysql://localhost:3306/secure";
Class.forName("com.mysql.jdbc.Driver");
con =DriverManager.getConnection(url,"root","root");

                                            String sql = "Select * from process where cluster='"+clustername+"'";
                                            Statement stmt = con.createStatement();
                                            ResultSet rs = stmt.executeQuery( sql );
                                            ResultSetMetaData md = rs.getMetaData();
                                            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++){
                    row.addElement( rs.getObject(i) );
                }
                data.addElement( row );
            }
            rs.close();
            stmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        TableColumn col;
        for (int i = 0; i < table.getColumnCount(); i++) {
            col = table.getColumnModel().getColumn(i);
            col.setMaxWidth(250);
        }
        JScrollPane scrollPane = new JScrollPane( table );
        p.add( scrollPane );
        JFrame f=new JFrame();
        f.add(p);
        f.setSize(600,400);
        f.setVisible(true); 
        
                                     
                                 }
                            
                            
			}
	}
	
        
        
        
	public class stoping implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			draw.setEnabled(false);
			start.setEnabled(false);
			refresh.setEnabled(true);
			messagetext.setEnabled(true);
			sendertext.setEnabled(true);
			receivertext.setEnabled(true);
			log("Simulation is started in the Network ! ");
		}
		
	}
	
	public class send implements ActionListener
	{
            
            
			public void actionPerformed(ActionEvent se)
			{
                            
                            
				if(messagetext.getText().trim().equals("")) {
					warningMessage("Please enter the Message");
					return;
				}
				message = messagetext.getText().trim();
                                atkmsg=message+""+msg;                                
                                
                                
				if(dataType.trim()=="INFRASTRUT") {
					sendInfrastrut();
				} else if(dataType.trim()=="NODECENTRIC") {
					sendNodeCentric();
				} else if(dataType.trim()=="SENSOR") {
					if(sensorFlag)
						sendSensor();
					else
						errorMessage("Please enter the Base Station Sensor Node");
				} else if(dataType.trim()=="WSN") {
				                     sendAdhoc();
                                  
					button.setVisible(true);
				}
			}
		
	}
	
	private void sendInfrastrut(){
		try {
			MoveNode mv = new MoveNode(jdp,plot);
			mv.setMessage(message);
			mv.setTable("net1");
			mv.start();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	private void sendNodeCentric(){
		try {
			MoveNode mv = new MoveNode(jdp,plot);
			mv.setMessage(message);
			mv.setTable("net2");
			mv.start();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	private void sendSensor(){
		try {
			MoveNode mv = new MoveNode(jdp,plot);
			mv.setMessage(message);
			mv.setTable("net3");
			mv.setSensorBaseStationNode(baseStationNumber);
			int[] pixels = new int[2];
			pixels[0] = plot[baseStationNumber].getX();
			pixels[1] = plot[baseStationNumber].getY();
			mv.setPixels(pixels);
			mv.start();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	private void sendAdhoc() {
		try {
			if(!sendertext.getText().trim().equals("")) {
				try {
					int sourceNode = Integer.parseInt(sendertext.getText().trim());
					String node = JOptionPane.showInputDialog(null, "Please enter the destination node to send the request");
					int destinationNode = Integer.parseInt(node);
					MoveNode mv = new MoveNode(jdp,plot);
					mv.setMessage(message);
                                        mv.setattacker(atkmsg);
					mv.setTable("nodelog");
					mv.setSourceNode(sourceNode);
					mv.setDestinationNode(destinationNode);
					int[] pixels = new int[2];
					pixels[0] = plot[sourceNode].getX();
					pixels[1] = plot[sourceNode].getY();
					mv.setPixels(pixels);
                                      //  JOptionPane.showMessageDialog(null,"Global Count"+ Global.cnt);
                                        //JOptionPane.showMessageDialog(null,"Global Count ++"+ Global.cnt++);
                                       // JOptionPane.showMessageDialog(null,"++ Global Count "+ ++Global.cnt);
                                        int cnt=Global.cnt++;
                                       //  JOptionPane.showMessageDialog(null,"Global Count ***"+ cnt);
                           // errorMessage("VAL of cnt "+ cnt);
                            if(cnt >=0 && cnt<3)
                            {
                          //  MoveNode mv = new MoveNode(jdp,plot);
                            mv.setcnt(cnt);
                            }
                            else
                            {
                               Global.cnt=0;
                            }
                                        //errorMessage("ttrtrtr"+ );
					mv.start();
                                        
				} catch (Exception e) {
					errorMessage("Not a valid number");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void log(String data){
		jta.append(data+"\n");
	}
		
		
	
	public static void main(String args[])
	{
		try {
			new UserInterface();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
		
	public class ColorChooser implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			Color color = JColorChooser.showDialog(null,"Choose Color As Your Wish For SIMULATION NETWORK "+numbers,Color.gray);
			jdp.setBackground(color);		
			if(plot!=null) {
				for(int i=1;i<plot.length;i++) {
					if(plot[i]!=null)
						plot[i].setBackground(color);	
				}	
			}
			Global.backgroundColour = color;
		}
	}			
}

