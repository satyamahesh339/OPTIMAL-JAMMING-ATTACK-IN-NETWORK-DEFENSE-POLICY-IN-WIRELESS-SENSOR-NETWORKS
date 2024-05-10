package sensor_priority.Com.multi.nw;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

class SetUpFrame extends JFrame
{
	Container con;
	JPanel p;
	JLabel title;
	JTextArea image;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg;
	JSpinner js;
	MaskFormatter mask;
	JFormattedTextField nodes;
	JLabel lbl;
	private static final long serialVersionUID = 3l;
	public SetUpFrame()throws Exception
	{
	//	this.setUndecorated(true);
		con=getContentPane();
		con.setBackground(Global.backgroundColour);
		con.setLayout(new BorderLayout());
		
		JLabel lbl = new JLabel(" PROJECT SETUP");
		con.add(lbl,BorderLayout.NORTH);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBorder(BorderFactory.createRaisedBevelBorder());
		p.setBackground(Global.tempNodesColour);
		con.add(p,BorderLayout.CENTER);
		
		r1=new JRadioButton("INFRASTRUT");
		r2=new JRadioButton("NODECENTRIC");
		r3=new JRadioButton("SENSOR");
		r4=new JRadioButton("WSN");
		
		r1.setBounds(60,20,220,30);
		r2.setBounds(60,80,220,30);
		r3.setBounds(60,140,220,30);
		r4.setBounds(60,50,220,30);
		
		r1.setBackground(Global.backgroundColour);
		r2.setBackground(Global.backgroundColour);
		r3.setBackground(Global.backgroundColour);
		r4.setBackground(Global.backgroundColour);
		
		r1.setForeground(Color.DARK_GRAY);
		r2.setForeground(Color.DARK_GRAY);
		r3.setForeground(Color.DARK_GRAY);
		r4.setForeground(Color.DARK_GRAY);
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		
	//	p.add(r1);
	//	p.add(r2);
	//	p.add(r3);
		p.add(r4);
		
		JButton b = new JButton("SETUP AND CLOSE");
		GUI.button(b,"Close Me");
		con.add(b,BorderLayout.SOUTH);
		this.setResizable(true);
		this.setTitle(" SETUP FRAME ");
		
		
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(r1.isSelected()==true){
					new NodePlotting("net1",1,"INFRASTRUT");
					dispose();
					
				}	
				else if(r2.isSelected()==true){
					new NodePlotting("net2",2,"NODECENTRIC");
					dispose();
				}
				
				else if(r3.isSelected()==true){
					new NodePlotting("net3",3,"SENSOR");
					dispose();
				} 
				
				else if(r4.isSelected()==true){
					new NodePlotting("nodelog",4,"WSN");
					dispose();
				}
					
				else
				    JOptionPane.showMessageDialog(null,"Please select one run option","Warning",JOptionPane.WARNING_MESSAGE);	
			}
		});
		
		setDefaultCloseOperation(0);
		setSize(350,200);
		setVisible(true);
		setLocation(350,250);	
		
	}
	public static void main(String args[])throws Exception
	{
		new SetUpFrame();
	}
}
