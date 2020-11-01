/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Sends back the date of the exercise
 * This class is used when the user completes or fails to 
 * complete a workout that they started.
 * @author jamyangtamang
 */
public class DateInfo {
    
    private static Date date;
    private static Calendar calendar;
    private static String fullDate;
    
    public static String getDate(){
        calendar = Calendar.getInstance();
        date = calendar.getTime();
        fullDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return fullDate;
    }
        
    
}
