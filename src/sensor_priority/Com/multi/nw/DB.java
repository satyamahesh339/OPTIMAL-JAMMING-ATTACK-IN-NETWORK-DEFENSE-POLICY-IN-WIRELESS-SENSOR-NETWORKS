package sensor_priority.Com.multi.nw;
import java.sql.*;
public class DB
{
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	static Connection getConnection()
	{
		Connection conn = null;
		try
	    {
	    	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//	conn=DriverManager.getConnection("jdbc:odbc:secure");
		//	conn.setAutoCommit(true);
                
                
                
String url="jdbc:mysql://localhost:3306/secure";
Class.forName("com.mysql.jdbc.Driver");
conn =DriverManager.getConnection(url,"root","root");
Statement st=conn.createStatement();				
	    }
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	    }
	    return conn;
	}
	public static ResultSet getResultSet(Connection con,String query)
	{
		try
		{
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();	
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		return rs;
	}
	
	public static void executeUpdate(Connection con,String query)
	{
		try
	    {
	    	//System.out.println ("QUERY IS %%%%%%%%%%%%%%% "+query);
	    	Statement pstmt = con.createStatement();
			int result = pstmt.executeUpdate(query);
			if(result>0)
			{
				System.out.println ("%%%%%%%%%% INSERTED SUCCESSFULLY %%%%%%%%%%%"+result);
			}
			else
			{
				Global.showMessage("Error in Update","Error",0);
				System.out.println(" *************** ERROR IN UPDATE *************************** ");
			}
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	    	//close(null,pstmt,null);
	    }
	}
	
	public static void refresh(Connection con)
	{
		try
		{
			Statement stmt = con.createStatement();	
			//stmt.executeUpdate("delete from net1");			
			//stmt.executeUpdate("delete from net2");			
		//	stmt.executeUpdate("delete from net3");			
			stmt.executeUpdate("delete from nodelog");
                        stmt.executeUpdate("delete from process");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs)
	{
		try
	    {
	    	if(con!=null)
	    		con.close();
	    	if(stmt!=null)
	    	    stmt.close();
	    	if(rs!=null)
	    		rs.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public static void initialize(Connection con)
	{
            try
	    {
	    	Statement stmt = con.createStatement();
	
		//	stmt.executeUpdate("delete from net1");
		//	stmt.executeUpdate("delete from net2");
		//	stmt.executeUpdate("delete from net3");
			stmt.executeUpdate("delete from nodelog");
                       stmt.executeUpdate("delete from process");
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public static int getRoutes(Connection connection){
		int route = 0;
		try {
			ResultSet rs = getResultSet(connection,"select max(route) from actual");
			while(rs.next()){
				route = rs.getInt(1);
				System.out.println("Total Routes : "+route);
			}
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	    return route;
	}
	
	public static void main(String args[]) {
    	System.out.println(" getConnection() "+getConnection());
    }
}
