package sensor_priority.Com.multi.nw;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Help extends JFrame
{
	private static final long serialVersionUID = 3l;
	Container con;
	JTextArea jta;
	JScrollPane jsp;
	JButton download,browse;
	String data;
	String append;
	int color;
	public Help()
	{
		con=getContentPane();
		con.setLayout(new BorderLayout());
		jta=new JTextArea();
		jta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Help Screen",2,3,new Font("Verdana",Font.BOLD,14),Color.YELLOW));
		jta.setBackground(Color.GRAY);
		jta.setForeground(Color.white);
		jta.setEditable(false);
		jta.setFont(new Font("Times New Roman",Font.BOLD,16)); 
		jsp=new JScrollPane(jta);
		con.add(jsp,BorderLayout.CENTER);
		
		download=new JButton("Exit from Help Screen");
		con.add(download,BorderLayout.SOUTH);
		download.setBackground(Color.BLACK);
		download.setForeground(Color.white);
		browse=new JButton("Change Color to See Help Screen");
		con.add(browse,BorderLayout.NORTH);
		browse.setBackground(Color.BLACK);
		browse.setForeground(Color.white);
		setSize(1000,700);
		setVisible(true);
	//	setDefaultCloseOperation(3);
		
		try
	    {
	    	FileInputStream fis=new FileInputStream("Images//Help.txt");
		    int size=fis.available();
			char ch[]=new char[size];
			for(int i=0;i<size;i++)
			{
			  ch[i]=(char)fis.read();
			}	
			data=String.valueOf(ch);
			jta.setText(data);
	    }
	    catch(Exception ex)
	    {
	     ex.printStackTrace();	
	     jta.append("No Help Information found....Please Check your Images folder");
	    }
		
		  
		
		browse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				++color;
					if(color==1){
						jta.setBackground(Color.BLACK);
						jta.setForeground(Color.white);
					}else if(color==2){
						jta.setBackground(Color.GRAY);
						jta.setForeground(Color.yellow);
					}else if(color==3){
						jta.setBackground(new Color(189,199,231));
						jta.setForeground(new Color(92,87,105));
					}else if(color==4){
						jta.setBackground(new Color(152,130,176));
						jta.setForeground(new Color(224,217,231));
					}else{
						color=0;
					}

					
			}
		});
		
		download.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();	
			}
		});
	}
	public static void main(String args[])
	{
		new Help();
	}
}