/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaderBoardModel;

/**
 * @author jamyangtamang
 * 
 * 
 * LeaderBoardEntries are instances of 
 * the data for leader board entries
 * @implements Comparable interface that allows entires 
 *             to be compared based on a specific field
 * 
 */
public class LeaderBoardEntry implements Comparable<LeaderBoardEntry>{
    
    private String userName;
    private String exerciseName;
    private double oneRepMax;
    /**
     * @param userName The user that this entry belongs to
     * @param exerciseName The exercise that this entry is for
     * @param oneRepMax The weight that is lifted by 
     *                  this user for the exercise                 
     */
    
    /**
     * Initializes the LeaderBoardEntry
     */
    public LeaderBoardEntry(String name, String exerciseName, double weight){
        this.userName = name;
        this.exerciseName = exerciseName;
        oneRepMax = weight;
    }
    
   /**
    * @return name of user who made this Entry's 
    */
    public String getUserName(){
        return userName;
    }
    
   /**
    * @return name of exercise that this entry is for
    */
    public String getExerciseName(){
        return exerciseName;
    }
    
   /**
    * @return the weight that the user lifted for this entry
    */ 
    public double getOneRepMax(){
        return oneRepMax;
    }

    @Override
    /**
     * @resource https://dzone.com/articles/sorting-java-arraylist
     * @returns the entry after 
     * implemented the compare() which will be used by the LeaderBoardSorter class
     * method that will allow sorting 
     * LeaderBoardEntries by OneRepMaxValues in descending order
     */
    public int compareTo(LeaderBoardEntry someEntry) {
        return (this.getOneRepMax() < someEntry.getOneRepMax() ? -1:
            (this.getOneRepMax() == someEntry.getOneRepMax() ? 0 : 1)); 
    }
}
