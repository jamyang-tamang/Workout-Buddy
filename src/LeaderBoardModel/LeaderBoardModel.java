/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaderBoardModel;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author jamyangtamang
 * 
 * LeaderBoardModel is a static object that   
 * contains instances of the LeaderBoardEntry
 * in an ArrayList of LeaderBoardEntry
 * 
 */
public class LeaderBoardModel {
    private static LeaderBoardModel leaderboardmodel = null;
    private static ArrayList<LeaderBoardEntry> leadEntries = null;
    /**
     * @param leaderboardmodel LeaderBoardModel there can only be one for each user
     * @param leadEntries The ArrayList containing all the LeaderBoard Entries              
     */
    
    private LeaderBoardModel(){
        leadEntries = new ArrayList();
    }
    
    /**
     * @return the LeaderBoardModel
     *         if it is null, makes a new LeaderBoardModel
     */
    public static LeaderBoardModel getInstance(){
        if(leaderboardmodel == null){
            leaderboardmodel = new LeaderBoardModel();
            return leaderboardmodel;
        }
        else
            return leaderboardmodel;
    }
    
    /**
     * @return the LeaderBoardEntry at a given index
     * 
     * @param index the index of the entry from the leadEntries 
     *        array list that needs to be returned
     */
    public LeaderBoardEntry getLeaderBoardEntry(int index){
        return leadEntries.get(index);
    }
    
    /**
     * adds an entry to the leadEntries
     * @param entry the instance of LeaderBoardEntry to be added to leadEntires
     */
    public void addEntry(LeaderBoardEntry entry){
        leadEntries.add(entry);
    }
    
    /**
     * @return size of leadEntries 
     */
    public int getSize() {
        return leadEntries.size();
    }
    
    /** 
     * @return the entries in Json Format
     */
    public String getAsJSON() {
        Gson gson = new Gson();
        String workoutListJson = gson.toJson(leadEntries);
        StringBuilder sb = new StringBuilder();
        sb.append("{\nEntries: ");
        sb.append(workoutListJson);
        sb.append("\n}");
        return sb.toString();
    }

}
