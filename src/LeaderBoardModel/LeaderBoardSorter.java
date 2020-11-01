/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaderBoardModel;

import java.util.ArrayList; 
import java.util.Collections;   


/**
 *
 * @author jamyangtamang
 *  @resource https://dzone.com/articles/sorting-java-arraylist
 * 
 * Allows for sorting of the learderboard in desired format
 */
public class LeaderBoardSorter {
    ArrayList<LeaderBoardEntry> leaderBoard = new ArrayList<>();       
    /**
     * @param leaderBoard array lift of sorted leaderboardmodel's arraylist of entires
     */
    
    public LeaderBoardSorter(ArrayList<LeaderBoardEntry> leaderBoard) {         
        this.leaderBoard = leaderBoard;     
    }       
    
    /**
     * Sorts the leaderboard in descending order of one rep maxes
     * @return the sorted leaderboard
     */
    public ArrayList<LeaderBoardEntry> getSortedListByORM() {         
        Collections.sort(leaderBoard, Collections.reverseOrder());         
    return leaderBoard;     
  } 
}
