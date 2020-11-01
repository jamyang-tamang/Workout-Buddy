/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkoutModel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import staticData.DialogBoxIcon;

/**
 *
 * @author jamyangtamang
 * Keeps track of all the workouts that the user has within
 */
public class WorkoutList{
    private static WorkoutList list = null;
    private ArrayList<Workout> workouts = null;

    private WorkoutList() {
        workouts = new ArrayList();
    }
    
    public static WorkoutList getInstance(){
        if(list == null)
            return list = new WorkoutList();
        else
            return list;
    }

    public void removeWorkout(int i){
        workouts.remove(i);
    }
    
    public Workout getWorkout(int i){
        return workouts.get(i);
    }
    
    public void addWorkout(Workout e){
        workouts.add(e);
    }
    
    public int getSize(){
        return workouts.size();
    }
    
    /** loads from a file
     * if the file fails to load calls save to file which saves data to a default file 
     * creating the file, while simultaneously loading a Sample file
     * @param file 
     */
    public void loadFromFile(String file){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            JsonParser jparser = new JsonParser();
            JsonElement rootElement = jparser.parse(br);
            JsonObject workoutListObject = rootElement.getAsJsonObject();
            
            JsonElement workoutList = workoutListObject.get("Workouts");
            JsonArray allWorkouts = workoutList.getAsJsonArray();
            Gson gson = new Gson();
            Workout[] w = gson.fromJson(workoutList, Workout[].class);
            workouts.clear();
            Collections.addAll(workouts, w);
        }catch (IOException ex) {
            saveToFile();
            loadFromFile("data/Sample.txt");
        }
    }
    
    /**
     * @return the data of the Workoutlist in Json format
     */
    public String getAsJSON() {
        Gson gson = new Gson();
        String workoutListJson = gson.toJson(workouts);
        StringBuilder sb = new StringBuilder();
        sb.append("{\nWorkouts: ");
        sb.append(workoutListJson);
        sb.append("\n}");
        return sb.toString();
    }
    
    /**
     * Saves the workout to the file default
     */
    public boolean saveToFile() {
        String sFullJsonForThis = this.getAsJSON();
        try {
            FileWriter fw = new FileWriter("data/default.txt");
            fw.write(sFullJsonForThis);
            fw.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to create new file default.txt", "Writing Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);
            return false;
        }
    }
}