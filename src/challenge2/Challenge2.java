/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package challenge2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DOLPHIX ELECTRONICS
 */
public class Challenge2 {
    
    public static double calcSeasonA(){
        return (650 * 40)/100;
    }

   public static ArrayList<String> calculateEarningsAndPaymentsSeasonB(int[] months) {
        ArrayList<String> earningsAndPayments = new ArrayList<>();
        double monthlyPay = 78 * 21;
        double feesToPayToXYZ = monthlyPay * 0.391;
        
        for (int i = 0; i < months.length; i++) {
            double discount = (6 - months[i]) * 0.07;
            double discountedFees = feesToPayToXYZ * (1 - discount);
            double earnings = monthlyPay - discountedFees;
            
            if (discountedFees / (months[i] * 21) > 950) {
                earningsAndPayments.add("N/A");
                try {
                    throw  new Exception("Cannot pay beyond 950");
                } catch (Exception ex) {
                    Logger.getLogger(Challenge2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String result = String.format("%.0f ⇔ %.0f", earnings, discountedFees);
                earningsAndPayments.add(result);
            }
        }
        
        return earningsAndPayments;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Season A recruits pay to XYZ: "+calcSeasonA());
           int[] months = {5, 6, 4, 2};
        ArrayList<String> results = calculateEarningsAndPaymentsSeasonB(months);

        for (String result : results) {
            System.out.println(result);
        }
    }
    
}
