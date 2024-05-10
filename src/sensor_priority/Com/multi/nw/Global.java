package sensor_priority.Com.multi.nw;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Global
{
	private static Global object = null;
	public static int TOTAL_PATHS = 2;
	public static int TOTAL_NODES = 0;
        public static int cnt = 0;
	public static int THRESHOLD = 5;
	public static final int MAX_HANDLE = 10;
	public static final int DEFAULT_THRESHOLD = 5;
	public static final int CLUSTERS = 4;
	public static String ENCRYPTED_DIR = "Encrypted";
	public static String DES_FILE_NAME = "des.txt";
	public static String HASH_FILE_NAME = "hash.txt";
	public static String anionHolder = "";
	public static String DELIMETER = "|";
	public static int GRAPH_WIDTH = 800;
	public static Color PROGRESS_COLOR = new Color(124,113,228);
	
	public static void createDir(String name) {
		try {
	    	File f = new File(name);			
	    	if(!f.exists()) {
	    		f.mkdir();
	    	}
	    } catch(Exception e) {
	      e.printStackTrace();			
	    }	
	}
	
	public static void createEncryptedFile(String path,String content) {
		try {
	    	FileWriter fw = new FileWriter(path,true);
	    	fw.write(content);
	    	fw.close();			
	    } catch(Exception e) {
	      e.printStackTrace();			
	    }	
	}
	
	
	
	public static void clearDir(String dirName) {
		try {
	    	File f=new File(dirName);
	    	if(f.exists()) {
	    		if(f.listFiles()!=null && f.listFiles().length>0) {
	    			for(int i=0;i<f.listFiles().length;i++) {
	    				f.listFiles()[i].delete();
	    			}
	    			System.out.println("_________ File(S) are deleted in the Dir ____ "+dirName);
	    		}				
	    	} 
	    	
	    } catch(Exception e) {
	      e.printStackTrace();			
	    }	
	}
	
	private Global()
	{
		
	}
	public static Global getObject()
	{
		if(object==null)
		{
			object = new Global();
		}
		return object;
	}
	
	public static String validate(JTextField obj) {
		if(obj.getText().trim().equals("")) {
			return "Please enter the input";
		}
		return null;
	}
	
	/*public static String getAuthorInfo()
	{
		StringBuffer author = new StringBuffer();
		author.append(" \n");
		author.append(" AUTHOR      \t: Conrad Technology\n");
		author.append(" DEGREE      \t: M.E.,\n");
		author.append(" TITLE       \t: "+TITLE+" \n");
	
		author.append(" DATE        \t: 00-00-2009\n");
		author.append(" YEAR \t: 2008-2009\n");	
		author.append(" \n Guide : \n");	
		return author.toString();
	}
        * */
	public static final String INFO_TITLE = "LDTS";
	public static final String TITLE = "LDTS";
	public static int MAXIMUM_NODES = 25;
	public static final int nodeWidth 			= 35;
	public static final int nodeBigWidth		= 80;
	public static final int nodeHeight 			= 35;
	public static final int moveNodeWidth		= 50;
	public static final int moveNodeHeight		= 30;
	public static final Color LOW_BATTER_NODE_COLOR = new Color(56,45,34);
	public static final int RESET_ENERGY = 1000;
	public static final int ENERGY_CONSUMPTION = 50;
	public static int START_TIME =0;
	public static int THRES_HOLD_TIME = 1;
	public static int ACCESS_KEY = 10;
	public static int NODE_DISTANCE_THRESHOLD = 200;
	public static Color BLOCKED_NODE_COLOR = Color.BLACK; 
        public static Color ATTACKER_NODE_COLOR = Color.red; 
	  
	public static Color nodesColour 		= new Color(116,134,114);
	public static Color tempNodesColour 		= new Color(116,134,214);
    public static Color backgroundColour  = new Color(195,215,230);//190,216,250
    public static final Color menubar_bg_clr 	= new Color(81,88,102);
    public static final Color menubar_fore_clr 	= new Color(226,219,235);
    public static final Color menuitem_bg_clr 	= new Color(79,99,119);
	public static final Color menuitem_fore_clr	= Color.WHITE;//new Color(215,214,226);
    public static final Color menu_bg_clr  		= new Color(113,161,227);
    public static final Color menu_fore_clr		= Color.LIGHT_GRAY;
    public static final Font menuitem_font		= new Font("Arial",Font.ITALIC,12);  
    public static final Color route_nodes_color = Color.GREEN;
    public static final Color SLEEPING_NODE_COLOR = Color.PINK;
    public static final Color PACKETS_COLOR = new Color(102,0,204);
    public static final Color PATH_CUT_COLOR = new Color(205,0,158);
    public static int speed = 5;
    
    public static final Color ROUTE1_COLOR = Color.RED;
    public static final Color ROUTE2_COLOR = Color.GREEN;
    public static final Color ROUTE3_COLOR = Color.BLUE;
    
    public static final Color BANDWIDTH_COLOR = new Color(0,128,128);
	
	static void showMessage(String message,String title,int type)
	{
		JOptionPane.showMessageDialog(null,message,title,type);
	}
	
	static int getPackets(String message){
		byte b[] = message.getBytes();
		int length = b.length;
		if(length>1 && length<20){
			return 6;
		} else if(length>=20 && length<60){
			return 12;
		} else if(length>=60 && length<120){
			return 18;
		} else {
			return 24;
		}
	}
	
	public static int getPackets2(String message)
	{
		byte b[] = message.getBytes();
		int length = b.length;
		int totalPackets = 0;
		System.out.println("Length "+b.length);
		if(length>4)
		{
			totalPackets = (int)length/4;
		}
		else
		{
			totalPackets = 1;
		}
		return totalPackets;
	}
	
	public static void main(String args[]) {
    	try {

		}
	    catch(Exception e){
	      e.printStackTrace();
	    }		
    }
    static void test(int routes,int distance){
    	try {
    		String query = "select * from actual where route not in("+routes+") and distance>"+distance+"";
    		ResultSet rs1 = DB.getResultSet(DB.getConnection(),query);
			while(rs1.next()){
				int route = rs1.getInt("distance");
				int path = rs1.getInt("route");
				System.out.println("node "+rs1.getInt("node")+" distance "+route+" : "+path);	
			}	    
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
    }	
}
