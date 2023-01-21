/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.browser.BrowserFactory;
import com.teamdev.jxbrowser.engine.Engine;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static greenwichcabs.DataBase.statement;
import static greenwichcabs.journey.resultSet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Abid
 */
public class detailsPage extends javax.swing.JFrame {

    private static final DecimalFormat df = new DecimalFormat("0.00");
              private JButton btn[]=new JButton[10];
    /**
     * Creates new form temp
     * 
     * public JFrame frame;
     */ 
              

    public detailsPage() {
        initComponents();
       //  String text="<html>";
        //text+="Hello<br>";
        //text+="AM<br>";
        //text+="Tufa<br>";
        //text+="JLabel";
      //  label.setText(text);
      
      
  JLabel lbOne= new JLabel("Label one");
JLabel lbTwo = new JLabel("Label two");
//StockPanel
 
 
  

     getConnection();
     
             dateShow();

        timeShow();
        //SelectedMod();
        
        
         Date date1 = new Date();
date.setDate(date1);
dataTable1.setVisible(true);
 timeLabel.setVisible(true);
dateLabel.setVisible(true);

  
 
  //StockPanel.setVisible(false);
    
        String ScearchDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();
        System.out.println("Date : "+ScearchDate);
        //  DataBase ob = new DataBase();
        //   ob.ScearchByDate(ScearchDate);
        scearchData(ScearchDate);
    }
     static final String DATABASE_URL = "jdbc:mysql://localhost/greenwich_cabs";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    static Connection connection = null; // manages connection
    static Statement statement = null; // query statement
    static ResultSet resultSet = null;
    private Object rollField;
    private Object brk;
    Connection condb;

 

    void getConnection() {

        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connect Hoise...");
      // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");

        } catch (SQLException e) {
            System.err.println("Connection Error");
            JOptionPane.showMessageDialog(null, "Open XAMPP Then Try Again");
            loginPage ob = new loginPage();
            ob.setVisible(true);

        }
        
        
        
         
   //map.pack();
    }

    
        public void dateShow() {

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy");
        dateLabel.setText(s.format(d));

        
           }

    public void timeShow() {

      new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                timeLabel.setText(s.format(d));

            }

        }
        ).start();

    }
      private void scearchData(String ScearchDate) {
      
      
        try {
            double total_expected=0;
            double total_fare=0;
            double TempTotal_fare=0;
            
            double TempTotal_tips=0;
            
            int total_job=0;
                    System.out.println("UP");
            String sql22 = "select * from earning_details where journey_date = '" + ScearchDate + "'";
       
            //this.dispose();
            ResultSet rs = statement.executeQuery(sql22);
            while (rs.next()) {
                
                    System.out.println("Execution");
              
                // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                // this.dispose(); 
                System.out.println("SQL Succesfully Executed 1 ");
                String id = rs.getString("id");
                String driver_id = rs.getString("driver_id");
                String date = rs.getString("journey_date");
                String fare_cost = rs.getString("fare_cost");
                String tips_cost = rs.getString("additional_tips");
                String job = rs.getString("job");
                String percentage =("NOt Calculate");
                
                double tempJob = Double.parseDouble(job);
         
                double tempFare_cost = Double.parseDouble(fare_cost);
                
                double tempTips_cost = Double.parseDouble(tips_cost);
                
                
                TempTotal_fare=tempTips_cost+tempFare_cost;
         
                total_job=(int) (total_job+tempJob);
               // TempTotal_tips=TempTotal_tips+tempTips_cost;
              
                String expectedPerDriver= df.format((0.20)*TempTotal_fare);
                
               total_fare=total_fare+TempTotal_fare;
               
               if(tempJob>0){
             
                  Object rowData[] = {driver_id,TempTotal_fare,expectedPerDriver,job};
                  DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
                  model.addRow(rowData);
                
               }
                    
                
               
             
                //   dataTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                //  JOptionPane.showMessageDialog(null,"Sorry");
                
            }
            //(new DecimalFormat("##.##").format(i2))
        
            String expectedOnTotal=df.format((0.20)*total_fare);
                System.out.println(total_fare+"TempTotal_fare"+TempTotal_fare);
                
                l2.setText( String.valueOf(total_fare)+" £");
                
                 l4.setText( String.valueOf(total_job));
                 
                 
                 l6.setText( String.valueOf(expectedOnTotal)+" £");
                 
                 
                  System.out.println("Last JOB "+total_job);
                
                
                
        
        } catch (SQLException ex) {
                
                    System.out.println("Error");
            Logger.getLogger(detailsPage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        frame1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dataTable2 = new javax.swing.JTable();
        StockPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataTable1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        mapPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        src2 = new javax.swing.JButton();
        searchItem = new javax.swing.JComboBox<>();
        jTextField20 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Greenwich Cab Details ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1010, 30));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAlignmentX(0.0F);
        jSeparator1.setAlignmentY(0.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1220, 10));

        jLabel20.setText("Greenwich,London.");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 180, 20));

        jLabel25.setText("Contact: +4407######");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 150, 20));

        jLabel27.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Greenwich Cabs");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 330, 70));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel9MouseDragged(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("-");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 1212, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 1270, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Abid\\Documents\\NetBeansProjects\\GreenwichCabs\\src\\Image\\cab2.gif")); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 60));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        frame1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        frame1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        frame1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 3, 270, -1));

        jLabel31.setText("                                ");
        frame1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 390, 10));

        dataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver", "Start At", "From", "Destination"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(dataTable2);

        frame1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 350, 250));

        StockPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        StockPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("           ");
        StockPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 210, -1));

        l5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l5.setText("Expected % of the day");
        StockPanel.add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 230, 40));

        l2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l2.setText("£ 1026.40");
        StockPanel.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 230, 40));

        l3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l3.setText("Total jobs of the day");
        StockPanel.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 230, 40));

        l1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l1.setText("Total Earn of The day");
        StockPanel.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 230, 40));

        l6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l6.setText("£ 205.80");
        StockPanel.add(l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 230, 40));

        l4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l4.setText("109");
        StockPanel.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 230, 40));

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel.setText("10:10:10");
        StockPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, -1));

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        timeLabel.setText("10:10:10");
        StockPanel.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, -1));

        l7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l7.setText("Today");
        StockPanel.add(l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 18));

        jLabel3.setText("Greenwich Cas's System");
        StockPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 414, 240, 20));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver", "Taking", "%", "Job Done"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        dataTable1.setViewportView(dataTable);

        StockPanel.add(dataTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 680, 290));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mapPanelLayout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(242, 242, 242))
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapPanelLayout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StockPanel.add(mapPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        date.setDateFormatString("yyyy-MM-dd");

        src2.setText("Search");
        src2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                src2ActionPerformed(evt);
            }
        });

        searchItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Driver Id", "Check All" }));

        jTextField20.setBackground(new java.awt.Color(0, 0, 0));
        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(null);

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Check The Driver and cab location at this moment by Their Id ");

        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Home");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Clear ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(src2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(257, 257, 257)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(searchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(frame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(src2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(frame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton8)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseDragged

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        //  loginForm ob=new loginForm();
        // ob.setExtendedState(loginForm.ICONIFIED);
        // ob.setState(ICONIFIED);
        this.setState(loginPage.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void src2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_src2ActionPerformed

              
DefaultTableModel model2= (DefaultTableModel)dataTable2.getModel();
 
   

   model2.setRowCount(0);
        DefaultTableModel model;
        model = (DefaultTableModel)dataTable.getModel();
        
        model.setRowCount(0);

        // TODO add your handling code here:

        System.out.println("ASS");

        String ScearchDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();
        System.out.println("Date : "+ScearchDate);
        //  DataBase ob = new DataBase();
        //   ob.ScearchByDate(ScearchDate);
        scearchData(ScearchDate);
        //   scearchData(ScearchDate);
    }//GEN-LAST:event_src2ActionPerformed

    private void dataTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dataTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        //Cab Name, Driver Id, Check All
        
        
                      
DefaultTableModel model2= (DefaultTableModel)dataTable.getModel();
               
 model2.setRowCount(0);
   
 
        DefaultTableModel model= (DefaultTableModel)dataTable2.getModel();

        model.setRowCount(0);

        String name = searchItem.getSelectedItem().toString();
        System.out.println(name);

        if(name=="Driver Id"){
            System.out.println("1");
            String ScearchDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();

            String DriverId=jTextField20.getText();
            if(DriverId.equals("")){

                JOptionPane.showMessageDialog(null, "Put a Valid Driver Id ");

                int tempID = Integer.valueOf(DriverId);

                if(tempID<=0){

                    JOptionPane.showMessageDialog(null, "Put a Valid Driver Id ");
                }
            }else{
                scearchCabsID(DriverId,ScearchDate);
            }
        }else{

            System.out.println("3");

            String ScearchDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();
            System.out.println("Date : "+ScearchDate);
            //  DataBase ob = new DataBase();
            //   ob.ScearchByDate(ScearchDate);
            scearchCabsAll(ScearchDate);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
this.dispose();
        loginPage ob=new loginPage();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

 // TODO add your handling code here:
    Toolkit tkp = StockPanel.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    StockPanel.print(g);
    g.dispose();
    pjp.end();


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        allPage ob =new allPage();
        ob.setVisible(true);
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
              
DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
              
DefaultTableModel model2= (DefaultTableModel)dataTable2.getModel();
 model.setRowCount(0);
   

   model2.setRowCount(0);



l2.setText("");
l4.setText("");
l6.setText("");

  

 


    }//GEN-LAST:event_jButton9ActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dataTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(detailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detailsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel StockPanel;
    private javax.swing.JTable dataTable;
    private javax.swing.JScrollPane dataTable1;
    private javax.swing.JTable dataTable2;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel frame1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JComboBox<String> searchItem;
    private javax.swing.JButton src2;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    private void scearchCabsAll(String ScearchDate) { 

       
      
        
        try {
            String sql22 = "select * from temp_data where journey_date = '" + ScearchDate + "'";
            
            //this.dispose();
            ResultSet rs = statement.executeQuery(sql22);
            while (rs.next()) {
              
                 String Driver = rs.getString("driver_id");
              
                
                String date = rs.getString("journey_date");

                String pickupPoint = rs.getString("pickup_point");                
                
                String destinationPoint = rs.getString("destination_point");   
              // JLabel jlabel = new JLabel("This is a label");
//    jlabel.setFont(new Font("Verdana",1,20));
 //   frame1.add(jlabel);#
 
 String time=rs.getString("journey_time"); ;
 
 
   
   
    Object rowData[] = {Driver,time,pickupPoint,destinationPoint};
               
                    
                DefaultTableModel model= (DefaultTableModel)dataTable2.getModel();
                model.addRow(rowData);
   
    
       } 

        
        } catch (SQLException ex) {
            Logger.getLogger(detailsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    private void scearchCabsID(String DriverId, String ScearchDate) {
    
    
    
      try {
            String sql22 = "select * from temp_data where driver_id = '" + DriverId  + "' And journey_date= '" + ScearchDate + "'";
            
            //this.dispose();
            ResultSet rs = statement.executeQuery(sql22);
            while (rs.next()) {
              
                 String Driver = rs.getString("driver_id");
              
                
                String date = rs.getString("journey_date");

                String pickupPoint = rs.getString("pickup_point");                
                
                String destinationPoint = rs.getString("destination_point");   
              // JLabel jlabel = new JLabel("This is a label");journey_time
//    jlabel.setFont(new Font("Verdana",1,20));
 //   frame1.add(jlabel);#
 String time=rs.getString("journey_time"); ;
 
   
   
    Object rowData[] = {Driver,time,pickupPoint,destinationPoint};
               
                    
                DefaultTableModel model= (DefaultTableModel)dataTable2.getModel();
                model.addRow(rowData);
   
    
       } 

        
        } catch (SQLException ex) {
            Logger.getLogger(detailsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    }

  

