package sensor_priority.Com.multi.nw;

import java.awt.geom.Line2D;
import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import sensor_priority.Com.multi.nw.graph1;

public class probality {

	
	public probality()
	{
		int node=0;
		int node1=0;
		 Connection conn = null;
	  		try
	  	    {
	  	    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  			conn=DriverManager.getConnection("jdbc:odbc:secure");
	  			Statement st=conn.createStatement();
	  			Statement st1=conn.createStatement();
	  		 String abc="SELECT COUNT(*) FROM net4";
	  			String str= "SELECT (SUM(xpos) - xpos) as Difference FROM net4";
//	  			ResultSet rs1 = st.executeQuery(str);
	  			int n;
	  			int n1;
	  			int temp=0;
	  			int temp1=0;
	  			ResultSet rs = st1.executeQuery("SELECT xpos,ypos,node FROM net4 WHERE (ID+1)");
	  			while(rs.next())
	  			{
	  				int nod=rs.getInt("node");
	  				node=rs.getInt("xpos");
	  				node1=rs.getInt("ypos");
	  				n=node-temp;
	  				n1=node1-temp1;
	  				temp=temp+n;
	  				temp1=temp1+n;
	  				int pro= (n+n1)%100;
//	  				System.out.println("node" +nod);
//	  				System.out.println("proba" +pro);
	  				new graph1(pro,nod);
	  				
//	  				System.out.println("Node" +n);
	  			  			
//	  			ResultSet rs1 = st.executeQuery("select xpos,ypos from net4 where node="+node+"");
//	  			int xpos=0;
//	  			int xpos1=0;
//	  			int temp=0;
//	  				while(rs1.next()) {
//	  				
//	  					if(node==1){
//	  					xpos = rs1.getInt("xpos");
//	  				int ypos = rs1.getInt("ypos");
//	  			
//	  					}
//	  					if(node==2)
//	  					{
//	  					 xpos1=rs1.getInt("xpos");
//	  					
//	  					}
//	  					
////	  				new graph1(xpos);		
//	  				}
	  			}
	  	    }
	  	    catch(Exception ex)
	  	    {
	  	     ex.printStackTrace();	
	  	    }
	}

	public static void main(String[] args) {
		
		new probality();
	}
}
