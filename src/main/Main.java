/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import WorkoutGui.WorkoutBuddyGui;
import LeaderBoardModel.LeaderBoardModel;
import Workout_Web_Services.LeaderBoardDataProvider;
import java.io.IOException;

/**
 *
 * @author jamyangtamang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            new WorkoutBuddyGui().setVisible(true);
            try {
                LeaderBoardDataProvider.startWebServices(LeaderBoardModel.getInstance());
            } catch (IOException ex) {
                System.out.println("Server already up");
            }
    }
    
}
