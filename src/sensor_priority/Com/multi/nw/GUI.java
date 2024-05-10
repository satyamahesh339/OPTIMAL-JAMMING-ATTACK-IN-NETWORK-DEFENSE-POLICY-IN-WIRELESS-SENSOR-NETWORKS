package sensor_priority.Com.multi.nw;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class GUI extends JFrame
{
	static final long serialVersionUID = 3;
	public static JDesktopPane jdp;
	public Dimension dim;
	public JMenuBar jmb;
	public JLabel messagelabel,senderlabel,receiverlabel,time;
	public static JTextField jt1,jt2,jt3;
	public JTextField messagetext,sendertext,receivertext;
	public int x=0,numbers=0,val1=0,val2=0,val3=0,val4=0,val5=0,count1=0,count2=0;
	public String c1,node_v,nodess,messages;
	public int xpos1=0,ypos1=0,nodenumber=0;	
	public JMenu process,features,alg;
	public JMenuItem start,draw,refresh,redraw,chooser,exit,move,history,help,login,nodeinfo,incbat,decbat;
	public JMenuItem srlg,tree,edge;
	public JLabel details;
	public JPanel pan,pan1;
	public static JPanel baseStationPanel;
	public static JPanel plot[];
        public static int nodenum=1;
	public JButton but,but1;
	public boolean flag=false,flag1=false;
	public Connection con;
	public int sourceNode,destinationNode,moveNode,temp,totalNodes;
	String message;
	static JLabel lbl;
	Global global;
	JButton button,dis;
	String numberofnodes;
        String nodename,clustername;
	JSpinner js;
	static JTextField jtf[];
	static JTextArea jta,baseStationJta;
	Color color;
	JLabel nl[];
//	static Dynamic dynamic;

	public static String dataTypeOptions[] = {
	  	"Choose Network Here","WSN"
	};  		
	
	protected void errorMessage(String m) {
		JOptionPane.showMessageDialog(null,m,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	protected void warningMessage(String m) {
		JOptionPane.showMessageDialog(null,m,"Warning",JOptionPane.WARNING_MESSAGE);
	}
	
	protected void plainMessage(String m) {
		JOptionPane.showMessageDialog(null,m,"For Your Information",JOptionPane.PLAIN_MESSAGE);
	}

	protected void plainMessage(String m,Icon icon) {
		JOptionPane.showMessageDialog(null,m,"For Your Information",JOptionPane.PLAIN_MESSAGE,icon);
	}
	
	public static void assign(JMenuItem menuitem,char c)
	{
		menuitem.setAccelerator(KeyStroke.getKeyStroke(c,java.awt.Event.CTRL_MASK,false));
		menuitem.setFont(Global.menuitem_font); 
		menuitem.setBackground(Global.menuitem_bg_clr);
		menuitem.setForeground(Global.menuitem_fore_clr);
		menuitem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(new Color(92,102,136),new Color(216,219,228)),""));
		menuitem.setFont(Global.menuitem_font);
	}
	
	public static void forMenu(JMenu menu,char c)
	{
		menu.setBorder(BorderFactory.createLoweredBevelBorder());
		menu.setBackground(Global.menu_bg_clr);
		menu.setForeground(Global.menu_fore_clr);
		menu.setMnemonic(c);
	}
	
	public static void forMenuBar(JMenuBar jmb)
	{
		jmb.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
		jmb.setBackground(Global.menubar_bg_clr);
		jmb.setForeground(Global.menubar_fore_clr);
	}
	
	public static void desktop(JDesktopPane jdp,Color color)
	{
		jdp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"SIMULATION REGION"));
		jdp.setLayout(null);
	    jdp.setToolTipText("Location to Plot the nodes");
		jdp.setBackground(color);	
	}
	
	public static void textbox(JTextField jtf)
	{
		jtf.setBackground(new Color(201,219,231));
		jtf.setBorder(BorderFactory.createLineBorder(Color.orange));
		jtf.setFont(new Font("Arial",Font.BOLD,10));
		jtf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.DARK_GRAY)));
	}
	
	public static void textarea(JTextArea jtf)
	{
		jtf.setBackground(Color.BLACK);
		jtf.setForeground(Color.WHITE);
		jtf.setBorder(BorderFactory.createLineBorder(Color.orange));
		jtf.setFont(new Font("Verdana",Font.BOLD,12));
		jtf.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.DARK_GRAY)));
	}
	
	public static void radioButton(JRadioButton radio,char c)
	{
		radio.setBorder(BorderFactory.createLoweredBevelBorder());
		radio.setBackground(Global.menu_bg_clr);
		radio.setForeground(Global.menu_fore_clr);
	}
	
	public static void button(JButton but,String value)
	{
		but.setToolTipText(value);
		but.setBackground(new Color(43,46,75));
		but.setForeground(new Color(213,215,231));
	}
	
	public static void label(JLabel label)
	{
		label.setFont(new Font("ARIAL",Font.BOLD,10));
		label.setForeground(Color.white);
	}


	public static void main(String args[])
	{
		JColorChooser.showDialog(null,"Choose Color for your Network Map ",Color.gray);
	}
}

