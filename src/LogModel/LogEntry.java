/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogModel;

/**
 *
 * @author jamyangtamang
 * 
 * 
 * LogEntrys are instances of 
 * the data for log entries
 */
public class LogEntry {
    
    private String workoutName;
    private String date;
    private String status;
    /**
     * @param wokroutName WorkoutName for this entry
     * @param date The date in which this entry was made
     * @param status Weather the workout was complete or not it could have been            
     */
    
    public LogEntry(String date, String name, String status){
        this.workoutName = name;
        this.date = date;
        this.status = status;
    }
    
    public String getName(){
        return workoutName;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setName(String name){
        this.workoutName = name;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
