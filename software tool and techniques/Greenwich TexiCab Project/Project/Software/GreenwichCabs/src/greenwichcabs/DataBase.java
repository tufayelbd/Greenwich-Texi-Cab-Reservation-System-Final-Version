/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static greenwichcabs.detailsPage.resultSet;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSet2;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DataBase {

    static final String DATABASE_URL = "jdbc:mysql://localhost/greenwich_cabs";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    static Connection connection = null; // manages connection
    static Statement statement = null; // query statement
    static ResultSet resultSet = null;
    private Object rollField;
    private Object brk;
    Connection condb;

    public DataBase() throws SQLException {
        getConnection();
    }

    void getConnection() {

        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connect Hoise...");
      // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");

        } catch (SQLException e) {
            System.err.println("Connection Error");
            JOptionPane.showMessageDialog(null, "Open XAMPP Then Try AgainZXX");
            loginPage ob = new loginPage();
            ob.setVisible(true);

        }
    }

   

    
    void insertJourneydata(String driver_id,String journeyDate,String pickup_Point, String dst_Point, String pasnName, String pasnPhone, String fare_cost, String tips, String account, String time2) {
    
        
        double total1=0;

        double total2=0;   
        int total_job=0;
     try{
         
         
         
         
         String sql_1= "select * from earning_details where driver_id = '" + driver_id  + "' And journey_date= '" + journeyDate + "'";
         
         //this.dispose();
         ResultSet rs = statement.executeQuery(sql_1);
         if (rs.next()) {
             String id = rs.getString("id");

             
             String job = rs.getString("job");
             String earning1 = rs.getString("fare_cost");
                String earning2 = rs.getString("additional_tips");
                double Newearning1=(Double.parseDouble(fare_cost));
                int temp_job=Integer.parseInt(job);
                total_job=temp_job+1;
                double Newearning2=(Double.parseDouble(tips));
                total1=  (Double.parseDouble(earning1)+Newearning1);
                 
                total2=  (Double.parseDouble(earning2)+Newearning2);
                
                    String newQuntity1 = String.valueOf(total1);
                
                    String newQuntity2 = String.valueOf(total2);
                
                  String sqly = "update earning_details set driver_id = '" + driver_id + "', journey_date = '" + journeyDate + "',fare_cost = '" + newQuntity1 + "', additional_tips = '" + newQuntity2 + "', job = '" + total_job + "' where driver_id= '" + driver_id + "' And journey_date= '" + journeyDate + "'";

                        statement.executeUpdate(sqly);
                    String sql = "INSERT INTO temp_data (driver_id,journey_date,pickup_point,destination_point,passenger_name,passenger_phone,fare_cost,additional_tips,account_name,journey_time) VALUES " + "('" + driver_id + "','" + journeyDate + "', '" + pickup_Point + "','" + dst_Point + "', '" + pasnName + "','" + pasnPhone + "', '" + fare_cost + "','" + tips + "', '" + account + "', '" + time2 + "');";
             System.out.println("Nichay    Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
             statement.executeUpdate(sql);
             
              JOptionPane.showMessageDialog(null,"A Journey Booked for"+pasnName+"At : "+time2+" Date: "+journeyDate);
                 System.out.println("UPdate");
             
         }else{
         
          try{
              String sql = "INSERT INTO temp_data (driver_id,journey_date,pickup_point,destination_point,passenger_name,passenger_phone,fare_cost,additional_tips,account_name,journey_time) VALUES " + "('" + driver_id + "','" + journeyDate + "', '" + pickup_Point + "','" + dst_Point + "', '" + pasnName + "','" + pasnPhone + "', '" + fare_cost + "','" + tips + "', '" + account + "', '" + time2 + "');";
         System.out.println("Nichay    Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
             statement.executeUpdate(sql);
             String sql2 = "INSERT INTO earning_details (driver_id,journey_date,fare_cost,additional_tips,job) VALUES " + "('" + driver_id + "','" + journeyDate + "', '" + fare_cost + "','" + tips +"','" + "1"+ "');";
             System.out.println("Nichay    Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
             statement.executeUpdate(sql2);
             
             System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
             // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");
              JOptionPane.showMessageDialog(null,"A Journey Booked for \n Name: "+pasnName+" \n Time : "+time2+"\n Date: "+journeyDate);
              
         } catch (SQLException ex) {
             System.out.println("Boss Someting Rong Hogadcvfxvx");
         }
         
         }
         
         
         
        
         
         
         
     } catch (SQLException ex) {
                    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
     
    
    
    }

    void ScearchDate(String ScearchDate) {
  
    
    
  
        try {
            double total_fare=0;
            double TempTotal_fare=0;
            int job=0;
            int total_job=0;
            
            String sql22 = "select * from temp_data where journey_date = '" + ScearchDate + "'";
       
            //this.dispose();
            ResultSet rs = statement.executeQuery(sql22);
      while (rs.next()) {
                total_job=total_job+1;
               // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                // this.dispose(); 
                System.out.println("SQL Succesfully Executed 1 ");
                                String id = rs.getString("id");
                String driver_id = rs.getString("driver_id");
                     System.out.println("driver_id"+driver_id); 
                     
                     
                     
                      
                      String sql2 = "select * from temp_data where driver_id = '" + driver_id  + "' And journey_date= '" + ScearchDate + "'";
                ResultSet resultSet2 = statement.executeQuery(sql2);
            //this.dispose();
            while (resultSet2.next())  {
            
             
              
             System.out.println("SQL Succesfully Executed     000000000000 ");
               
            }
              
               
            }  
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter A valid Customer Phone Number !!!!!!");
            System.out.println("ERROR " + ex);
        }
        
      
    
    
    }

    void ScearchByDate(String ScearchDate) {
     
     try {
            double total_fare=0;
            double TempTotal_fare=0;
            
            double TempTotal_tips=0;
            
            double total_job=0;
            
            String sql22 = "select * from earning_details where journey_date = '" + ScearchDate + "'";
       
            //this.dispose();
            ResultSet rs = statement.executeQuery(sql22);
      while (rs.next()) {
                total_job=total_job+1;
               // JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                // this.dispose(); 
                System.out.println("SQL Succesfully Executed 1 ");
                                String id = rs.getString("id");
                String driver_id = rs.getString("driver_id");
                String date = rs.getString("journey_date");
                String fare_cost = rs.getString("fare_cost");
                String tips_cost = rs.getString("additional_tips");
                String job = rs.getString("job");
                String percentage = rs.getString("NOt Calculate");
                
                double tempJob = Double.parseDouble(job);
         
                double tempFare_cost = Double.parseDouble(fare_cost);
                
                double tempTips_cost = Double.parseDouble(tips_cost);
                
                TempTotal_fare=TempTotal_fare+tempFare_cost;
         
                total_job=total_job+tempJob;
                TempTotal_tips=TempTotal_tips+tempTips_cost;

                System.out.println("driver_id"+driver_id); 
                
              //  DefaultTableModel model= (DefaultTableModel)dataTable.getModel();

                Object rowData[] = {driver_id,fare_cost,percentage,job};
             
                           //   dataTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                 //    model.addRow(rowData);
                   //  JOptionPane.showMessageDialog(null,"Sorry");
          


      }
      
      
            
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR Exceptions  !!!!!!");
            System.out.println("ERROR " + ex);
        }
        
      
    
    
    
    }
 
     
 
 
 
    

    
    
/****************************************Stock Sale Page Query END******************************************************/
}


      