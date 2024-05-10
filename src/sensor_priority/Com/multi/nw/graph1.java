package sensor_priority.Com.multi.nw;
import java.awt.Color;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class graph1
{
	private JButton bg;
	
	public graph1()
    {     
    	final JFrame f = new JFrame();
    	bg=new JButton("close");
    	bg.setBounds(5,5, 100,25);
    	bg.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
    			f.setVisible(false);
    		}
    		
    		
    	});
    	f.add(bg);
   
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new GraphPanel11());
        f.setSize(750,450);
        f.setLocation(200,200);
        f.setVisible(true);
    }
	public graph1(int a,int b)
	{
		System.out.println("Xpos "+a );
		System.out.println("Ypos "+b );
		
		

		
	}
	public static void main(String[] args) {
		new graph1();
	}
	

}
	class GraphPanel11 extends JPanel
	{
	   
	 
	   public void paintComponent(Graphics g) { 
	          Graphics2D g2 = (Graphics2D) g;
	          Connection conn = null;
	          int node=0;
	  		int node1=0;
	  		
	          
	  		try
	  	    {
	  			 int n;
		  			int n1;
		  			int temp=0;
		  			int temp1=0;
		          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		  			conn=DriverManager.getConnection("jdbc:odbc:secure");
		  			Statement st=conn.createStatement();
		  			Statement st1=conn.createStatement();	
//	  	    	
//	  			ResultSet rs1 = st.executeQuery("select * from net4 order by node asc");
//	  			
//	  				while(rs1.next()) {
//	  				int node2 = rs1.getInt("node");
//	  				String nod=String.valueOf(node2);
//	  				int xpos = rs1.getInt("xpos");
//	  				int ypos = rs1.getInt("ypos");
//	  				
//	  				 Line2D lin1 = new Line2D.Float(xpos, ypos, 100, 360);
//	  				 g2.drawString("Node"+nod, xpos, ypos);
//	  				g2.draw(lin1);
//	  				System.out.println("Node" +node2);
//	  				System.out.println("Xop" +xpos);
//	  				System.out.println("Yop" +ypos);
	  								
	  					        
		  			
		  			ResultSet rs = st1.executeQuery("SELECT xpos,ypos,node FROM net4 WHERE (ID)");
		  			while(rs.next())
		  			{
		  				int nod1=rs.getInt("node");
		  				String Npos=String.valueOf(nod1);
		  				node=rs.getInt("xpos");
		  				node1=rs.getInt("ypos");
		  				n=node-temp;
		  				n1=node1-temp1;
		  				temp=temp+n;
		  				temp1=temp1+n;
		  				int pro= (n+n1)%100;
		  				
		  				
		  				Line2D lin2 = new Line2D.Float(node, node1, 100, 360);
//		  				g2.drawString("Node"+Npos  , node, node1);
		  				int p=0;
		  				p=nod1;
		  				
		  				  				
		  				int XNpos=10;
		  				int YNpos=20;
		  				XNpos=XNpos+node;
		  				YNpos=YNpos+node1;
		  				
		  				g2.drawString("Node "+Npos, node, node1);
		  				
		  				g2.drawString(" Speed :"+pro , XNpos, YNpos);
		  				g2.draw(lin2);
		  				
		  				System.out.println("node" +Npos);
		  				System.out.println("proba" +pro);
	  	    }
//	  				}
	  	    }
	  	    catch(Exception ex)
	  	    {
	  	     ex.printStackTrace();	
	  	    }
	        
              Line2D lin2 = new Line2D.Float(40, 50, 40, 400);
	          Line2D lin3 = new Line2D.Float(40, 400, 750, 400);
		          
	         
	         g2.drawString("Node Y", 0, 60);
	         g2.drawString("Node X", 700, 415);
	         g2.draw(lin2);
	         g2.draw(lin3);
	      }
	
	    }
	
	    
	       
	  
	         

