package sensor_priority.Com.multi.nw;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.Random;

import javax.swing.*;
class MoveNode1 extends Thread {
	JDesktopPane jdp;
	JPanel lbl;
	int packets;
	Connection con = DB.getConnection();
	String table;
	JPanel p;
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	MoveNode1(JDesktopPane jdp){
		this.jdp = jdp;
	}
	public void run() {
		send();
	}
	
	private void send() {
		 try {
			Thread.sleep(500);
                        
                      
			ResultSet rs = DB.getResultSet(con,"select * from "+getTable()+" order by node asc");
			while(rs.next()){				
				long startTime = System.currentTimeMillis();
				System.out.println(" Start Time "+startTime);
				int node = rs.getInt("node");
				int xpos = rs.getInt("xpos");
				int ypos = rs.getInt("ypos");
				int key = rs.getInt("accesskey");
				if(Global.ACCESS_KEY!=key) {
					DB.executeUpdate(con, "update "+getTable()+" set status='BLOCKED' where node="+node);
					UserInterface.baseStationJta.append("Node:"+node+" is blocked \n");
				} else {
					DB.executeUpdate(con, "update "+getTable()+" set status='VALID' where node="+node);
					UserInterface.baseStationJta.append("Node:"+node+" is accepted \n");
				}
				/*JPanel pan = new JPanel();
				pan.setBorder(BorderFactory.createRaisedBevelBorder());
				pan.setBounds((UserInterface.baseStationPanel.getX()+100),
						(UserInterface.baseStationPanel.getY()+100),
						Global.moveNodeWidth,Global.moveNodeHeight);
				pan.setBackground(Global.tempNodesColour);
				jdp.add(pan);
				Thread.sleep(1000);
				pan.setBounds(0,0,0,0);
				jdp.remove(pan);
				*/
				/*p =new JPanel();
				p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				p.setLayout(null);*/
				/*int lineNo = 0;
				for(int i=UserInterface.baseStationPanel.getY()+100;i<ypos;i++) {
					p.setBounds((UserInterface.baseStationPanel.getX()+100),i,Global.moveNodeWidth,
							Global.moveNodeHeight);
					lineNo = i;
				}
				for(int i=UserInterface.baseStationPanel.getX()+100;i<xpos;i++) {
					p.setBounds(i,lineNo,Global.moveNodeWidth,
							Global.moveNodeHeight);
				}*/
				MoveComponent1 mv = new MoveComponent1(jdp,xpos,ypos,table);
				if(mv.checkStatus()) {
					
				}
				mv.join();
				/*p.setBackground(Global.tempNodesColour);
				jdp.add(p);
				Thread.sleep(500);
				p.setBounds(0,0,0,0);
				jdp.remove(p);*/
				long endTime = System.currentTimeMillis();
				System.out.println(" End Time "+endTime);
				System.out.println(" Difference Time ************* "+(endTime-startTime));
			}
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }

	}
        
}

class MoveComponent1 extends Thread {
	JDesktopPane mvp;
	int xpos;
	int ypos;
	JPanel panel;
	String table;
	boolean flag = false;
	MoveComponent1(JDesktopPane p,int xpos,int ypos,String table) {
		this.mvp = p;
		this.xpos = xpos;
		this.ypos = ypos;
		this.table = table;
		start();
	}
	public synchronized void run() {
		try {
			int lineNo = 0;
			for(int i=UserInterface.baseStationPanel.getY()+100;i<ypos;i++) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds((UserInterface.baseStationPanel.getX()+100),i,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(10);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
				lineNo = i;
			}
			for(int i=UserInterface.baseStationPanel.getX()+100;i<xpos;i++) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,lineNo,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(10);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}
			/*for(int i=ypos;i>UserInterface.baseStationPanel.getX()+100;i--) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,lineNo,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(50);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}*/
			for(int i=xpos;i>UserInterface.baseStationPanel.getX()+100;i--) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,(UserInterface.baseStationPanel.getY()+100),Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(20);
				if(table.equals("net1")) {
					Random r = new Random();
					if(r.nextInt(5)==0) {
						flag = true;
						Thread.sleep(50);
					}
				}
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	boolean checkStatus() {
		try {
			if(flag && "net1".equals(table)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

class MoveTimeComponent1 extends Thread {
	JDesktopPane mvp;
	int xpos;
	int ypos;
	JPanel panel;
	MoveTimeComponent1(JDesktopPane p,int xpos,int ypos) {
		this.mvp = p;
		this.xpos = xpos;
		this.ypos = ypos;
		start();
	}
	public synchronized void run() {
		try {
			int lineNo = 0;
			for(int i=UserInterface.baseStationPanel.getY()+100;i<ypos;i++) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds((UserInterface.baseStationPanel.getX()+100),i,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(10);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
				lineNo = i;
			}
			for(int i=UserInterface.baseStationPanel.getX()+100;i<xpos;i++) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,lineNo,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(10);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}
			/*for(int i=ypos;i>UserInterface.baseStationPanel.getX()+100;i--) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,lineNo,Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(50);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}*/
			for(int i=xpos;i>UserInterface.baseStationPanel.getX()+100;i--) {
				panel = new JPanel();
				panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1,Global.nodesColour,Color.GRAY),"",2,3,new Font("Arial",Font.BOLD,8),Color.white));
				panel.setLayout(null);
				panel.setBounds(i,(UserInterface.baseStationPanel.getY()+100),Global.moveNodeWidth,
						Global.moveNodeHeight);
				panel.setBackground(Global.tempNodesColour);
				mvp.add(panel);
				Thread.sleep(20);
				panel.setBounds(0,0,0,0);
				mvp.remove(panel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

