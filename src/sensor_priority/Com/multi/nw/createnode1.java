/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor_priority.Com.multi.nw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
/**
 *
 * @author Elcot
 */
public class createnode1 extends javax.swing.JFrame {
int r;
    /**
     * Creates new form createnode1
     */
    public createnode1() {
        initComponents();
        try
        {
            
            Connection con;
            Statement st;
             String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="select (v) from value";
               ResultSet rs=st.executeQuery(qry);
               if(rs.next())
               {
                  r=Integer.parseInt(rs.getString("v")); 
                  System.out.println(r);
               }
               if(r<=10)
               {
                   
               
            if(r==2)
            {
            jTextField6.setEnabled(false);
            jTextField7.setEnabled(false);
            jTextField8.setEnabled(false);
            jTextField10.setEnabled(false);
            jTextField9.setEnabled(false);
            jTextField11.setEnabled(false);
            jTextField12.setEnabled(false);
            jTextField13.setEnabled(false);
            jTextField14.setEnabled(false);
            jTextField15.setEnabled(false);
            jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false);
            }
            if(r==3)
            {
                 jTextField8.setEnabled(false);
            jTextField10.setEnabled(false);
            jTextField9.setEnabled(false);
            jTextField11.setEnabled(false);
            jTextField12.setEnabled(false);
            jTextField13.setEnabled(false);
            jTextField14.setEnabled(false);
            jTextField15.setEnabled(false);
            jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false);
            }
            if(r==4)
            {
               jTextField9.setEnabled(false);
            jTextField11.setEnabled(false);
            jTextField12.setEnabled(false);
            jTextField13.setEnabled(false);
            jTextField14.setEnabled(false);
            jTextField15.setEnabled(false);
            jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==5)
            {
                jTextField12.setEnabled(false);
            jTextField13.setEnabled(false);
            jTextField14.setEnabled(false);
            jTextField15.setEnabled(false);
            jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==6)
            {
                 jTextField14.setEnabled(false);
            jTextField15.setEnabled(false);
            jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==7)
            {
                jTextField16.setEnabled(false);
            jTextField17.setEnabled(false);
            jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==8)
            {
                 jTextField18.setEnabled(false);
            jTextField19.setEnabled(false);
            jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==9)
            {
                jTextField20.setEnabled(false);
            jTextField21.setEnabled(false); 
            }
            if(r==10)
            {
                
            }
               }
               else
               {
                   System.out.println();
               }
        }
        catch(Exception ex)
        {
            
        }
        }
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setText("Enter Node Name");

        jLabel2.setText("Neighbour Node Name");

        jLabel3.setText("Distence Values");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField16)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField21))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
             if(r==2)
            { 
                try
                {
               
               String nm=jTextField1.getText();
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
            
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error");
                }
            }
             if(r==3)
            { 
                try
                {
               
               String nm=jTextField1.getText();  
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
            
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node5+"','"+node6+"')";
           st.executeUpdate(qry2);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
        if(r==4)
            { 
                try
                {
               
               String nm=jTextField1.getText(); 
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
           
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
        if(r==5)
            { 
                try
                {
               String nm=jTextField1.getText(); 
               
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
          String node9=jTextField9.getText();
          String node10=jTextField11.getText();
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
            String qry3="i  nsert into node(nd,name,value) values('"+nm+"','"+node9+"','"+node10+"')";
           st.executeUpdate(qry3);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
        if(r==6)
            { 
                try
                {
               
                String nm=jTextField1.getText(); 
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
          String node9=jTextField9.getText();
          String node10=jTextField11.getText();
          String node11=jTextField12.getText();
          String node12=jTextField13.getText();
          
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
           String qry3="insert into node(nd,name,value) values('"+nm+"','"+node9+"','"+node10+"')";
           st.executeUpdate(qry3);
           String qry4="insert into node(nd,name,value) values('"+nm+"','"+node11+"','"+node12+"')";
           st.executeUpdate(qry4);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
        if(r==7)
            { 
                try
                {
               
                String nm=jTextField1.getText(); 
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
          String node9=jTextField9.getText();
          String node10=jTextField11.getText();
          String node11=jTextField12.getText();
          String node12=jTextField13.getText();
          String node13=jTextField14.getText();
          String node14=jTextField15.getText();
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
           String qry3="insert into node(nd,name,value) values('"+nm+"','"+node9+"','"+node10+"')";
           st.executeUpdate(qry3);
           String qry4="insert into node(nd,name,value) values('"+nm+"','"+node11+"','"+node12+"')";
           st.executeUpdate(qry4);
            String qry5="insert into node(nd,name,value) values('"+nm+"','"+node13+"','"+node14+"')";
           st.executeUpdate(qry5);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }

        if(r==9)          
{ 
                try
                {
               
               String nm=jTextField1.getText(); 
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
          String node9=jTextField9.getText();
          String node10=jTextField11.getText();
          String node11=jTextField12.getText();
          String node12=jTextField13.getText();
          String node13=jTextField14.getText();
          String node14=jTextField15.getText();
          String node15=jTextField16.getText();
          String node16=jTextField17.getText();
          String node17=jTextField18.getText();
          String node18=jTextField19.getText();
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
           String qry3="insert into node(nd,name,value) values('"+nm+"','"+node9+"','"+node10+"')";
           st.executeUpdate(qry3);
           String qry4="insert into node(nd,name,value) values('"+nm+"','"+node11+"','"+node12+"')";
           st.executeUpdate(qry4);
            String qry5="insert into node(nd,name,value) values('"+nm+"','"+node13+"','"+node14+"')";
           st.executeUpdate(qry5);
           String qry6="insert into node(nd,name,value) values('"+nm+"','"+node15+"','"+node16+"')";
           st.executeUpdate(qry6);
           String qry7="insert into node(nd,name,value) values('"+nm+"','"+node17+"','"+node18+"')";
           st.executeUpdate(qry7);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
        if(r==9)          
{ 
                try
                {
               
               String nm=jTextField1.getText(); 
          String node1=jTextField2.getText();
          String node2=jTextField3.getText();
          String node3=jTextField4.getText();
          String node4=jTextField5.getText();
          String node5=jTextField6.getText();
          String node6=jTextField7.getText();
          String node7=jTextField8.getText();
          String node8=jTextField10.getText();
          String node9=jTextField9.getText();
          String node10=jTextField11.getText();
          String node11=jTextField12.getText();
          String node12=jTextField13.getText();
          String node13=jTextField14.getText();
          String node14=jTextField15.getText();
          String node15=jTextField16.getText();
          String node16=jTextField17.getText();
          String node17=jTextField18.getText();
          String node18=jTextField19.getText();
          String node19=jTextField20.getText();
          String node20=jTextField21.getText();
            Connection con;
          Statement st;
                      String url;
        url = "jdbc:mysql://localhost:3306/ldts";

       Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","root");
            st=con.createStatement();
            String qry="insert into node(nd,name,value) values('"+nm+"','"+node1+"','"+node2+"')";
           st.executeUpdate(qry);
           String qry1="insert into node(nd,name,value) values('"+nm+"','"+node4+"','"+node3+"')";
           st.executeUpdate(qry1);
           String qry2="insert into node(nd,name,value) values('"+nm+"','"+node7+"','"+node8+"')";
           st.executeUpdate(qry2);
           String qry3="insert into node(nd,name,value) values('"+nm+"','"+node9+"','"+node10+"')";
           st.executeUpdate(qry3);
           String qry4="insert into node(nd,name,value) values('"+nm+"','"+node11+"','"+node12+"')";
           st.executeUpdate(qry4);
            String qry5="insert into node(nd,name,value) values('"+nm+"','"+node13+"','"+node14+"')";
           st.executeUpdate(qry5);
           String qry6="insert into node(nd,name,value) values('"+nm+"','"+node15+"','"+node16+"')";
           st.executeUpdate(qry6);
           String qry7="insert into node(nd,name,value) values('"+nm+"','"+node17+"','"+node18+"')";
           st.executeUpdate(qry7);
           String qry8="insert into node(nd,name,value) values('"+nm+"','"+node19+"','"+node20+"')";
           st.executeUpdate(qry8);
            }
                
                catch(Exception ex)
                {
                    System.out.println("error"+ex);
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
        //new createnode().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(createnode1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createnode1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createnode1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createnode1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createnode1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
