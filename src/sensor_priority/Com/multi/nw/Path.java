package sensor_priority.Com.multi.nw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Path {
	public static int[] getNearestNodeInfo(Connection con, int sourceNode, int destinationNode, int destinationNodeX, int destinationNodeY,int clust0,int clust0x,int clust0y,int clust1,int clus1x,int clus1y,int clust2,int clus2x,int clus2y) {
		int nearest = 0;
                int nearest1 = 0;
		//String query = "SELECT * FROM NET4 WHERE NODE NOT IN("+destinationNode+","+sourceNode+")";
		int sum = destinationNodeX + destinationNodeY;
		int tempSum = 0;
		int temp = 0;
		int nearestX = 0;
		int nearestY = 0;
                int nearest1X = 0;
		int nearest1Y = 0;
		int difference = 0,hxpos=0,hypos=0,hpos=0;
		int count  = 0;
                String grp="",grp1="",bs="";
                int ch1x=0,ch1y=0,ch2x=0,ch2y=0;
                
                
                
          
		String query = "SELECT * FROM nodelog WHERE NODE NOT IN("+destinationNode+","+sourceNode+")";
		//int sum = destinationNodeX + destinationNodeY;
		//int tempSum = 0;
		//int temp = 0;
		//int nearestX = 0;
		//int nearestY = 0;
		//int difference = 0;
		//int count  = 0;
		try {
			ResultSet rs = DB.getResultSet(con, query);
			while(rs.next()) {
				++count;
				int node = rs.getInt("NODE");
				int xpos = rs.getInt("XPOS");
				int ypos = rs.getInt("YPOS");
				tempSum = (xpos+ypos);
				if(tempSum>sum)
					difference = tempSum - sum;
				else if(sum>tempSum || sum==tempSum)
					difference = sum - tempSum;
				System.out.println("path if condition" +difference);
				if(count==1) {
					//nearestX = xpos;
					//nearestY = ypos;
					//nearest = node;
					//temp = difference;
                                        
                                        hxpos = xpos;
					hypos = ypos;
					hpos = node;
					temp = difference;
                                        
                                        
                                        
				}	
				System.out.println(node+" is Node -> difference "+difference+" sum "+sum+" temp "+temp);
				if(count>1 && temp>difference) {
					/*nearestX = xpos;
					nearestY = ypos;
					nearest = node;
					temp = difference;
                                        * 
                                        * */
                                    
                                     hxpos = xpos;
					hypos = ypos;
					hpos = node;
					temp = difference;
                                        
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//int[] arr = {nearest,nearestX,nearestY};
	//	return arr;
                
                
                
              //  JOptionPane.showMessageDialog(null,"Message Received Successfully..."+hpos);
                
                
                
                //int[] arr,arr1;
		try {
                    
                    
                    //ch1
                     String qry="select * from nodelog where node="+sourceNode+"";
                     ResultSet rs = DB.getResultSet(con, qry);
                     //ArrayList als=new ArrayList();
                     while(rs.next())
                     {
                         grp=rs.getString("cluster");
                         //als.add(rs.getString("node"));
                     }
                     
                     String qry1="select * from nodelog where node="+destinationNode+"";
                     ResultSet rs1 = DB.getResultSet(con, qry1);
                     ArrayList als1=new ArrayList();
                     while(rs1.next())
                     {
                         grp1=rs1.getString("cluster");
                         als1.add(rs1.getString("node"));
                     }
                     
                     //String cc="";
                     Random r=new Random();
                   //  int gg=r.nextInt(als.size());
                     
                     //  JOptionPane.showMessageDialog(null,"Message Received Successfully..."+als.size());
                     //als1.get(gg);
                  //   String qq="select * from nodelog where node="+sourceNode+" and node="+ als1.get(gg) +"";
                  //   ResultSet qqr=DB.getResultSet(con, qq);
                  //   if(qqr.next())
                  /*   {
                         hpos=Integer.parseInt(qqr.getString("nodename"));
                         hxpos=Integer.parseInt(qqr.getString("xpos"));
                         hypos=Integer.parseInt(qqr.getString("ypos"));
                     }
                     
                    */ 
                     if (grp.equals(grp1))
                     {
                         if(grp.equals("Cluster0"))
                         {
                             nearest=clust0;
                             nearestX=clust0x;
                             nearestY=clust0y;
                             
                         }
                         else if(grp.equals("Cluster1"))
                         {
                             nearest=clust2;
                             nearestX=clus2x;
                             nearestY=clus2y;
                         }
                        else if(grp.equals("Cluster2"))
                         {
                             nearest=clust1;
                             nearestX=clus1x;
                             nearestY=clus1y;
                         }
                      /*   else if(grp.equals("Cluster3"))
                         {
                             nearest=clust2;
                             nearestX=clus2x;
                             nearestY=clus2y;
                         }
                        */ 
                         //int[] arr = {nearest,nearestX,nearestY};
                         int[] arr = {nearest,nearestX,nearestY,hpos,hxpos,hypos};
		         return arr;
                     }
                     else if(!(grp.equals(grp1)))
                     {
                         if (grp.equals("Cluster0") && grp1.equals("Cluster1"))  
                          {
                             /*nearest=clust1;
                             nearestX=clus1x;
                             nearestY=clus1y;
                             nearest1=clust2;
                             nearest1X=clus2x;
                             nearest1Y=clus2y;
                             * */
                              nearest=clust0;
                             nearestX=clust0x;
                             nearestY=clust0y;
                             nearest1=clust1;
                             nearest1X=clus1x;
                             nearest1Y=clus1y;
                              
                              
                              
                          }
                         else if (grp.equals("Cluster0") && grp1.equals("Cluster2"))  
                          {
                             nearest=clust0;
                             nearestX=clust0x;
                             nearestY=clust0y;
                             nearest1=clust2;
                             nearest1X=clus2x;
                             nearest1Y=clus2y;
                          }
                          else if (grp.equals("Cluster0") && grp1.equals("Cluster3"))  
                          {
                             nearest=clust0;
                             nearestX=clust0x;
                             nearestY=clust0y;
                             nearest1=clust2;
                             nearest1X=clus2x;
                             nearest1Y=clus2y;
                          }
                         
                         else if (grp.equals("Cluster1") && grp1.equals("Cluster2"))  
                          {
                             nearest=clust1;
                             nearestX=clus1x;
                             nearestY=clus1y;
                             nearest1=clust2;
                             nearest1X=clus2x;
                             nearest1Y=clus2y;
                         
                         
                          }
                          else if (grp.equals("Cluster2") && grp1.equals("Cluster1"))  
                          {
                             nearest=clust2;
                             nearestX=clus2x;
                             nearestY=clus2y;
                             nearest1=clust1;
                             nearest1X=clus1x;
                             nearest1Y=clus1y;
                          }
                          int[] arr1 = {nearest,nearestX,nearestY,nearest1,nearest1X,nearest1Y,hpos,hxpos,hypos};
		          return arr1;
                     }
		/*	while(rs.next()) {
				++count;
				int node = rs.getInt("NODE");
				int xpos = rs.getInt("XPOS");
				int ypos = rs.getInt("YPOS");
				tempSum = (xpos+ypos);
				if(tempSum>sum)
					difference = tempSum - sum;
				else if(sum>tempSum || sum==tempSum)
					difference = sum - tempSum;
				System.out.println("path if condition" +difference);
				if(count==1) {
					nearestX = xpos;
					nearestY = ypos;
					nearest = node;
					temp = difference;
				}	
				System.out.println(node+" is Node -> difference "+difference+" sum "+sum+" temp "+temp);
				if(count>1 && temp>difference) {
					nearestX = xpos;
					nearestY = ypos;
					nearest = node;
					temp = difference;
				}
			}*/
                
                
		}
                 catch (Exception e) {
			e.printStackTrace();
		}
		 int[] arr2 = {nearest,nearestX,nearestY,nearest1,nearest1X,nearest1Y};
		 return arr2;
	}
}
