/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

/**
 *
 * @author Abid
 */
public class GreenwichCabs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try {
            
            splash Splash=new splash();
        Splash.setVisible(true);
        
            for(int i=0;i<=100;i++){
            Thread.sleep(30);
            
            Splash.loadingNumber.setText(Integer.toString(i)+"%");
            Splash.loadingBar.setValue(i);
            
        loginPage firstPanel=new loginPage();
            
            if(i==100){
                Splash.setVisible(false);
            
            firstPanel.setVisible(true);
            
            
            }
            }
        } catch (Exception e) {
        }
    
}
}