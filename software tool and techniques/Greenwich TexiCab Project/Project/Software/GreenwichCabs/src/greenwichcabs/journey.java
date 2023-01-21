/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import static greenwichcabs.DataBase.resultSet;
import static greenwichcabs.DataBase.statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Abid
 */
public class journey extends javax.swing.JFrame {

    /**
     * Creates new form journey
     */
    public journey() {
        initComponents();
    
    
     getConnection();
     
             dateShow();
 
 Date date1 = new Date();
date.setDate(date1);

         
        timeShow();
        //SelectedMod();
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
       
        } catch (SQLException e) {
            System.err.println("Connection Error");
            loginPage ob = new loginPage();
            ob.setVisible(true);

        }
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
    
    
   // Connection Con=null;
    //Statement St=null;
    //ResultSet Rs=null;
    //java.util.Date FDate,EDate;
    public void scearchData(String ScearchID){
        
        System.out.println("1");
     
            //String sql="Selelct * from temp_data";
        
            //statement = (Statement) connection.createStatement();
        //resultSet = statement.executeQuery(sql);
        // dataTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        
        
        
        
        
        try {
            String sql = "select * from temp_data where passenger_phone = '" + ScearchID + "'";
            resultSet = statement.executeQuery(sql);
            //this.dispose();
            if (resultSet.next()) {
               // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                // this.dispose(); 
				System.out.println("SQL Succesfully Executed");
                                String id = resultSet.getString("id");
                String driver_id = resultSet.getString("driver_id");
                String date = resultSet.getString("journey_date");
                String pickup_point = resultSet.getString("pickup_point");
                String destination_point = resultSet.getString("destination_point");
                String passenger_name = resultSet.getString("passenger_name");
 
                String passenger_phone = resultSet.getString("passenger_phone");
                String fare_cost = resultSet.getString("fare_cost");
                
                String tips = resultSet.getString("additional_tips");
                String account_name = resultSet.getString("account_name");
 
 
                DefaultTableModel model= (DefaultTableModel)dataTable.getModel();

                Object rowData[] = {driver_id,date,pickup_point,destination_point,passenger_name,passenger_phone,fare_cost,tips,account_name};
             
                           //   dataTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                             model.addRow(rowData);
                            System.out.println(passenger_name);
                             
            } else {
                 JOptionPane.showMessageDialog(null, "Please Enter A valid Customer Phone Number !!!!!!");
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter A valid Customer Phone Number !!!!!!");
            System.out.println("ERROR " + ex);
        }
        
    
    }
      private void deleteData(String ScearchID) {
   
      
        String sql2 = "Delete from temp_data where passenger_phone = '" + ScearchID + "'";
        try {
            statement.executeUpdate(sql2);
                 DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
                search_id.setText("");
                 model.setRowCount(0);
            JOptionPane.showMessageDialog(null, "Data Delete Successfully !!!!!!");
         
           
           
        } catch (SQLException ex) {
            Logger.getLogger(journey.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Please Enter A valid Customer Phone Number !!!!!!");
           
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
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        picUpPoint = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        destinationPoint = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passengerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fareCost = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        additionalTips = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        passengerPhone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        accountName = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        driverId = new javax.swing.JComboBox<>();
        minutes = new javax.swing.JComboBox<>();
        hour = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        saveData = new javax.swing.JButton();
        scearchBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        search_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("-");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        timeLabel.setText("10:10:10");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dateLabel.setText("10:10:10");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel15.setText("Greenwich,London.");

        jLabel16.setText("Contact: +4407######");

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Greenwich Cabs");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver Id ", "Date", "Time", "Pick Up Point", "Destination Point", "Passenger Name", "Passenger Phone", "Fare cost", "Additional Tips ", "Account"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataTable);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setForeground(new java.awt.Color(255, 51, 204));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setInheritsPopupMenu(true);

        jLabel2.setText("Picup Point");

        picUpPoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                picUpPointKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                picUpPointKeyTyped(evt);
            }
        });

        jLabel3.setText("Destination Point");

        destinationPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationPointActionPerformed(evt);
            }
        });
        destinationPoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                destinationPointKeyTyped(evt);
            }
        });

        jLabel4.setText("Driver's ID");

        jLabel5.setText("Passenger's Name");

        passengerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passengerNameKeyTyped(evt);
            }
        });

        jLabel6.setText("Fare Cost");

        fareCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fareCostKeyTyped(evt);
            }
        });

        jLabel17.setText("Additional Tips ");

        additionalTips.setText("0");
        additionalTips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                additionalTipsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                additionalTipsMouseEntered(evt);
            }
        });
        additionalTips.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                additionalTipsKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                additionalTipsKeyTyped(evt);
            }
        });

        jLabel18.setText("Passenger's Phone    (+440 )");

        passengerPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengerPhoneActionPerformed(evt);
            }
        });
        passengerPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passengerPhoneKeyTyped(evt);
            }
        });

        jLabel19.setText("Account name");

        accountName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default(NO Account )", "Shirley", "Greenwich", "Beany" }));

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Save Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("Hour");

        jLabel11.setText("Minutes");

        driverId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        driverId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Driver", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        minutes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        minutes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "3940", "41", "42", "43", "44", "45", "46", "47", "48.49.50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        hour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("£");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("£");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(picUpPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destinationPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driverId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(fareCost, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passengerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(passengerName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(additionalTips, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hour, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(picUpPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(destinationPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passengerName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passengerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fareCost, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(driverId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(additionalTips, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(55, 55, 55)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );

        saveData.setText("Confirmed ");
        saveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataActionPerformed(evt);
            }
        });

        scearchBtn.setText("Search");
        scearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scearchBtnActionPerformed(evt);
            }
        });

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Set Time if different time journey");

        jLabel12.setText("   ");

        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(416, 416, 416))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(771, Short.MAX_VALUE)
                            .addComponent(search_id, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(scearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(101, 101, 101)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(515, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(470, 470, 470)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(516, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Abid\\Documents\\NetBeansProjects\\GreenwichCabs\\src\\Image\\cab2.gif")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(156, 156, 156)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        //  loginForm ob=new loginForm();
        // ob.setExtendedState(loginForm.ICONIFIED);
        // ob.setState(ICONIFIED);
        this.setState(loginPage.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void saveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataActionPerformed
 
               String minute=minutes.getSelectedItem().toString();
               String hours=hour.getSelectedItem().toString();
                     
                  DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
if(model.getRowCount()==0){
    
                JOptionPane.showMessageDialog(null, "Table Empty.. ! Insert Data First");
    
    
}else{


     if (hours.equals("00")){
         try {
             
               String pickup_Point=picUpPoint.getText();
               String time=timeLabel.getText();
               
               String journeyDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();
               String dst_Point=destinationPoint.getText();
               
               String driver_id=driverId.getSelectedItem().toString();
               
               String pasnName=passengerName.getText();
               String pasnPhone=passengerPhone.getText();
               String fare_cost=fareCost.getText();
               
               String tips=additionalTips.getText();
              String account = accountName.getSelectedItem().toString();
               
               
                ///this.dispose();
                DataBase db = new DataBase();
               db.insertJourneydata(driver_id,journeyDate,pickup_Point,dst_Point,pasnName,pasnPhone,fare_cost,tips,account,time);
                //  JOptionPane.showMessageDialog(null,"Sorry");
                
                
               // paymentPage ob=new paymentPage();
                //ob.setVisible(true);
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Sorry Someting wrong..!.");
                
            }
            
        }else{
         try {
             String pickup_Point=picUpPoint.getText();
             String time=hours+":"+minute;
             String journeyDate= ((JTextField) date.getDateEditor().getUiComponent()).getText();
             String dst_Point=destinationPoint.getText();
             
             String driver_id=driverId.getSelectedItem().toString();
             
             String pasnName=passengerName.getText();
             String pasnPhone=passengerPhone.getText();
             String fare_cost=fareCost.getText();
             
             String tips=additionalTips.getText();
             String account = accountName.getSelectedItem().toString();
             
             
             ///this.dispose();
             DataBase db = new DataBase();
             db.insertJourneydata(driver_id,journeyDate,pickup_Point,dst_Point,pasnName,pasnPhone,fare_cost,tips,account,time);
             //  JOptionPane.showMessageDialog(null,"Sorry");
         } catch (SQLException ex) {
             Logger.getLogger(journey.class.getName()).log(Level.SEVERE, null, ex);
         }
                
        }
 
     
     
     

     Calendar calendar = Calendar.getInstance();

date.setCalendar(calendar);


picUpPoint.setText("");
               
 dateLabel.setText("");
           destinationPoint.setText("");

driverId.setSelectedIndex(0);
               
      passengerName.setText("");
passengerPhone.setText("");
fareCost.setText("");
      search_id.setText("");
additionalTips.setText("0");
accountName.setSelectedIndex(0);

hour.setSelectedIndex(0);

minutes.setSelectedIndex(0);               
 



   model.setRowCount(0);



    
}
     
        
        
        
        
//journey page=new journey();

//picUpPoint.setText("");
               
//dateLabel.setText("");
//destinationPoint.setText("");

//driverId.getSelectedItem().toString();
//passengerName.setText("");
//passengerPhone.setText("");
//fareCost.setText("");
//search_id.setText("");
//additionalTips.setText("");
//accountName2.getSelectedItem().toString();
               
//DefaultTableModel model= (DefaultTableModel)dataTable.getModel();




  // model.setRowCount(0);
    }//GEN-LAST:event_saveDataActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         // TODO add your handling code here:
         
         
       DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
        if(model.getRowCount()>0){
    
                JOptionPane.showMessageDialog(null, "Table Empty.. ! Insert Data First");
    
    
}else{
        
               String minute=minutes.getSelectedItem().toString();
               String hours=hour.getSelectedItem().toString();
                     
  String time="oo";
     if (hours.equals("00")){
     
                  time=timeLabel.getText();
     }else{
         time=hours+":"+minute;  
     }
        
               String pickup_Point=picUpPoint.getText();
               
               String journeyDate=dateLabel.getText();
               String dst_Point=destinationPoint.getText();
               
               String driver_id=driverId.getSelectedItem().toString();
                
               String pasnName=passengerName.getText();
               String fare_cost=fareCost.getText();
               
               String tips=additionalTips.getText();
              String account = accountName.getSelectedItem().toString();
               
               String pasnPhone=passengerPhone.getText();
               if(driver_id.equals("Select Driver")){
               JOptionPane.showMessageDialog(null,"Select Driver Id Please!");
               }
               else if(pickup_Point.equals("")){
               JOptionPane.showMessageDialog(null,"Please select a valid pickup point..!");
               }
               else if(pickup_Point.matches("[0-9]+")){
               JOptionPane.showMessageDialog(null,"Please select a valid pickup point..!");
               }
               else if(dst_Point.equals("")){
               JOptionPane.showMessageDialog(null,"Please select a valid destination point..!");
               }
               else if(dst_Point.matches("[0-9]+")){
               JOptionPane.showMessageDialog(null,"Please select a valid destination point..!");
               }else if(dst_Point.equals(pickup_Point)){
                 JOptionPane.showMessageDialog(null,"Destination point and pickup point must be different!");
                 
               }
               else if(pasnPhone.length() <10 && pasnPhone.length() >10){
                JOptionPane.showMessageDialog(null,"Please select a valid phone number..!");
               }
               else if(fare_cost.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter  fare Cost...\n Thank You!");
               }
               else if(Integer.parseInt(fare_cost)<5){
               JOptionPane.showMessageDialog(null,"Please enter minimum Fare Cost at least £5 ...\n Thank You!");
               } else if(tips.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter  tips at least 0 ...\n Thank You!");
               }else{
                   
                   
               
                Object rowData[] = {driver_id,journeyDate,time,pickup_Point,dst_Point,pasnName,pasnPhone,fare_cost,tips,account};
             
                           //   dataTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                     model.addRow(rowData);
               }      //  JOptionPane.showMessageDialog(null,"Sorry");
               }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void scearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scearchBtnActionPerformed
        // TODO add your handling code here:
        
               String ScearchID=search_id.getText();
        
          scearchData(ScearchID);
        
        
        
        
    }//GEN-LAST:event_scearchBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            this.dispose();
            loginPage ob =new loginPage();
            ob.setVisible(true);

        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Calendar calendar = Calendar.getInstance();

date.setCalendar(calendar);


picUpPoint.setText("");
               
 dateLabel.setText("");
           destinationPoint.setText("");

driverId.setSelectedIndex(0);
               
      passengerName.setText("");
passengerPhone.setText("");
fareCost.setText("");
      search_id.setText("");
additionalTips.setText("0");
accountName.setSelectedIndex(0);

hour.setSelectedIndex(0);

minutes.setSelectedIndex(0);               
DefaultTableModel model= (DefaultTableModel)dataTable.getModel();




   model.setRowCount(0);








        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        allPage ob=new allPage();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         
        
         DefaultTableModel model= (DefaultTableModel)dataTable.getModel();
if(model.getRowCount()==0){
    
                JOptionPane.showMessageDialog(null, "Please!  Search Passenger First With valid Phone Number !");
    
    
}else{
  
   // System.out.println("Selected: " + selectedData);
    int row = dataTable.getSelectedRow();
    String pickUp_point=null;
    String destination_point=null;
    String driver_id=null;
    String date=null;
    String passenger_phone=null;
    String fare_cost=null;
    String tips=null;
    
int column = dataTable.getColumnCount();
 // Declaring an array of student
        DataArray[] TempArray;
  
        // Allocating memory for 2 objects
        // of type student
        TempArray = new DataArray[10];
        
  ArrayList<String> scripts = new ArrayList<String>();
for(int i = 0; i < column; i++) {
   
     scripts.add((String) dataTable.getValueAt(row, i));
   
} 


    driver_id=scripts.get(0);
    
    date=scripts.get(1);
       pickUp_point=scripts.get(2);
    
     destination_point=scripts.get(3);
    
    passenger_phone=scripts.get(5);
    fare_cost=scripts.get(6);;
   
 // JOptionPane.showMessageDialog(null, dataTable.getValueAt(row, i)+"DATRA111"+driver_id);
        tips =scripts.get(7);
 
 
deleteData(driver_id,date,pickUp_point,destination_point,passenger_phone,fare_cost,tips);
}
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void picUpPointKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_picUpPointKeyPressed

 

        // TODO add your handling code here:
    }//GEN-LAST:event_picUpPointKeyPressed

    private void picUpPointKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_picUpPointKeyTyped




        

// TODO add your handling code here:
    }//GEN-LAST:event_picUpPointKeyTyped

    private void passengerPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passengerPhoneKeyTyped

// TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
           // evt.consume();
            
            JOptionPane.showMessageDialog(null, "Opps \n Enter a Valid Number !");
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_passengerPhoneKeyTyped

    private void additionalTipsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_additionalTipsKeyTyped

        
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "OPPS!");
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_additionalTipsKeyTyped

    private void fareCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fareCostKeyTyped


        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
           
            JOptionPane.showMessageDialog(null, " OPPS!\n Enter Numeric value for Fare cost");
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_fareCostKeyTyped

    private void additionalTipsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_additionalTipsMouseEntered

     


        // TODO add your handling code here:
    }//GEN-LAST:event_additionalTipsMouseEntered

    private void additionalTipsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_additionalTipsKeyPressed

 

        // TODO add your handling code here:
    }//GEN-LAST:event_additionalTipsKeyPressed

    private void additionalTipsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_additionalTipsMouseClicked

   additionalTips.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_additionalTipsMouseClicked

    private void destinationPointKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destinationPointKeyTyped


 
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationPointKeyTyped

    private void passengerNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passengerNameKeyTyped


        char enter = evt.getKeyChar();
        if((Character.isDigit(enter))){
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "OPPS!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_passengerNameKeyTyped

    private void destinationPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationPointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationPointActionPerformed

    private void passengerPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengerPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passengerPhoneActionPerformed

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
            java.util.logging.Logger.getLogger(journey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(journey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(journey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(journey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new journey().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountName;
    private javax.swing.JTextField additionalTips;
    private javax.swing.JTable dataTable;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField destinationPoint;
    private javax.swing.JComboBox<String> driverId;
    private javax.swing.JTextField fareCost;
    private javax.swing.JComboBox<String> hour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> minutes;
    private javax.swing.JTextField passengerName;
    private javax.swing.JTextField passengerPhone;
    private javax.swing.JTextField picUpPoint;
    private javax.swing.JButton saveData;
    private javax.swing.JButton scearchBtn;
    private javax.swing.JTextField search_id;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    private void deleteData(String driver_id, String date, String pickUp_point, String destination_point, String passenger_phone, String fare_cost, String tips) {
   
      System.out.println("greenwichcabs.journey.COST()"+passenger_phone+fare_cost);
    
    
    
        System.out.println("greenwichcabs.journey.deleteData()"+driver_id+date+pickUp_point+destination_point+passenger_phone+fare_cost);
    
    String tempDate=date;
        System.out.println("Date"+date);
    
        try {
          
            String sql = "select * from temp_data where driver_id= '" + driver_id + "' And journey_date= '" + date + "' And pickup_point= '" + pickUp_point +"' And destination_point= '" + destination_point +"' And passenger_phone= '" + passenger_phone + "' And fare_cost= '" + fare_cost + "'";

            System.out.println("gr 1"+tempDate);
          //  String sql = "select * from temp_data where driver_id = '" + driver_id + "AND journey_date = '" + date + "AND pickup_point = '" + pickUp_point + "AND destination_point = '" + destination_point+"AND passenger_phone = '" + passenger_phone +"AND fare_cost = '" + fare_cost + "'";
            resultSet = statement.executeQuery(sql);
            //this.dispose();
            if(resultSet.next()){
           
                 String sql2 = "Delete from temp_data where driver_id= '" + driver_id + "' And journey_date= '" + date + "' And pickup_point= '" + pickUp_point +"' And destination_point= '" + destination_point +"' And passenger_phone= '" + passenger_phone + "' And fare_cost= '" + fare_cost + "'";
statement.executeUpdate(sql2);
                     
                  
                  
                  
                  
                  
                  //************************//
                  
                  double total=0;
                  double total2=0;
                  
            double total_fare=0;
            double TempTotal_fare=0;
            
            double TempTotal_tips=0;
            
            double total_job=0;
             
           String SQL22 = "select * from earning_details where driver_id = '" + driver_id + "' And journey_date= '" + tempDate + "'";
         
            //this.dispose();
            ResultSet rs = statement.executeQuery(SQL22);
      if (rs.next()) {
                
               // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                // this.dispose(); 
                System.out.println("SQL Succesfully Executed 1 ");
                        String id = rs.getString("id");
                String driver_id1 = rs.getString("driver_id");
                String date1 = rs.getString("journey_date");
                String fare_cost1 = rs.getString("fare_cost");
                String tips_cost1 = rs.getString("additional_tips");
                String job = rs.getString("job");
               // String percentage = rs.getString("NOt Calculate");
                
                double tempJob = Double.parseDouble(job);
         
                double tempFare_cost = Double.parseDouble(fare_cost1);
                
                double tempTips_cost = Double.parseDouble(tips_cost1);
                total2=  tempTips_cost-(Double.parseDouble(tips));
                 total_job=tempJob-1;
                    String newQuntity2 = String.valueOf(total2);
                 total=(tempFare_cost+tempTips_cost)-(Double.parseDouble(fare_cost));
                
              String sqly = "update earning_details set driver_id = '" + driver_id + "', journey_date = '" + date + "',fare_cost = '" + total + "', additional_tips = '" + newQuntity2 + "', job = '" + total_job + "' where driver_id= '" + driver_id + "' And journey_date= '" + date + "'";

                        statement.executeUpdate(sqly);
                    

                 JOptionPane.showMessageDialog(null, "Journey Details Delete successfully !!!!!!");
           
                     
                  
              //  DefaultTableModel model= (DefaultTableModel)dataTable.getModel();

                


      }
      
      
            
                  //************************************//
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
            } else {
                 JOptionPane.showMessageDialog(null, "Please Enter A valid Customer Phone Number !!!!!!");
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " jjjjjjjjjjjj!!");
            System.out.println("ERROR " + ex);
        }
        
    
    
    
    


picUpPoint.setText("");
               
 dateLabel.setText("");
           destinationPoint.setText("");

driverId.getSelectedItem().toString();               
      passengerName.setText("");
passengerPhone.setText("");
fareCost.setText("");
      search_id.setText("");
additionalTips.setText("");
accountName.getSelectedItem().toString();
               
DefaultTableModel model= (DefaultTableModel)dataTable.getModel();




   model.setRowCount(0);


    
    }

    private static class DataArray {

        public DataArray() {
        }
    }    
    }
 
        
  
