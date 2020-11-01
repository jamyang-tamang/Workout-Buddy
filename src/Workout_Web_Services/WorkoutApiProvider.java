/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workout_Web_Services;
import WorkoutModel.Exercise;
import com.google.gson.Gson;
import staticData.MuscleGroup;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import staticData.DialogBoxIcon;

/**
 *
 * @author jamyangtamang
 * Provides access to the wger database
 * Gives exercises for each muscle group and their icons and description
 */

public class WorkoutApiProvider {
    private final static String exerciseUrl = "https://wger.de/api/v2/exercise/?format=json&language=2";
    private final static String iconUrl = "https://wger.de/api/v2/exerciseimage/?format=json&";
    private static int pageNo;
    private int msclGrp;
    private static ArrayList<Exercise> arrayex;
    private static String allExerciesJson;
    private static String sFullJsonForThis;
   
    /**
     * Returns the exercise for each muscle group by sending the URL
     * Goes through each page and parses through the muscle group for 7 page numbers
     * if the muscle group doesn't have 7 page numbers a file not found exception is
     * sent back and pageNo gets set to 7 ending the parsing
     * Also checks for repeated exercises and prevents the exercise from being added to 
     * the exercise array if it already exists
     * @param muscleGrp
     * @return 
     */
    public static WorkoutApiProvider getExercises(MuscleGroup muscleGrp){
        try {
            WorkoutApiProvider exercises = new WorkoutApiProvider();
            exercises.msclGrp = muscleGrp.getMuscleNumber();
            exercises.arrayex = new ArrayList();
            for(pageNo = 1; pageNo < 7; pageNo++){
                URL oracle = new URL(exerciseUrl +"&page=" + pageNo + "&muscles=" + exercises.msclGrp);
                URLConnection connection = oracle.openConnection();
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder sb = new StringBuilder();
                    while ((inputLine = in.readLine()) != null)
                        sb.append(inputLine);
                    in.close();

                    String jsonResponseFromServer = sb.toString();
                    JsonParser jparser = new JsonParser();
                    JsonElement jElemRoot = jparser.parse(jsonResponseFromServer);
                    JsonObject jObjRoot = jElemRoot.getAsJsonObject();

                    JsonArray jArrExercise = jObjRoot.getAsJsonArray("results");
                    ArrayList<JsonObject> jobjExerciseBlocks = new ArrayList();

                    for(int i = 0; i < jArrExercise.size(); i++){
                            String name = jArrExercise.get(i).getAsJsonObject().get("name").getAsString();
                            int id = jArrExercise.get(i).getAsJsonObject().get("id").getAsInt();
                            String description = jArrExercise.get(i).getAsJsonObject().get("description").getAsString();
                            if(!(exercises.arrayex.size() > 1 && (exercises.arrayex.get(exercises.arrayex.size()-1).getName().contains(name)))){
                                Exercise givenExercise = new Exercise(name, 0, 0, 0, muscleGrp.getMuscleName(), description, id);
                                exercises.arrayex.add(givenExercise);
                            }
                    }
                } 
                catch(FileNotFoundException e){
                    pageNo = 7;
                }
            }
            return exercises;
        }
        catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "You are unable to connect to the server right now!", "Server Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);           
        } 
        catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "You are unable to connect to the server right now!", "Server Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);          
        }
        return null;
    }
    
    /**
     * Converts the api data into json format
     * and saves it in a file with the exercise name
     */
    public static String getAsJSON(MuscleGroup muscle) {
        Gson gson = new Gson();
        allExerciesJson = gson.toJson(
        WorkoutApiProvider.getExercises(muscle).getExercises());
        StringBuilder sb = new StringBuilder();
        sb.append("{\n"+ muscle.getMuscleName() + ":");
        sb.append(allExerciesJson);
        sb.append("\n}");
        return sb.toString();
    }
    
    /**
     * updates the workouts from the locally cached file that
     * contains Json information about each exercise gotten
     * from the WGER api, by re-downloading the api's information
     * to the cached file
     */
    public static boolean saveToFile(MuscleGroup muscle) {
        sFullJsonForThis = WorkoutApiProvider.getAsJSON(muscle);
        try {
            FileWriter fw = new FileWriter("data/" + muscle.getMuscleName() +".txt");
            fw.write(sFullJsonForThis);
            fw.close();
            return true;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable to create new file default.txt", "Writing Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);
            return false;
        }
    }
    
    /**
     * loads the workouts from the locally cached file that
     * contains Json information about each exercise gotten
     * from the WGER api
     */
    public static ArrayList<Exercise> loadFromFile(String file, MuscleGroup muscle){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            JsonParser jparser = new JsonParser();
            JsonElement rootElement = jparser.parse(br);
            JsonObject workoutListObject = rootElement.getAsJsonObject();
            
            JsonElement workoutList = workoutListObject.get(muscle.getMuscleName());
            JsonArray allWorkouts = workoutList.getAsJsonArray();
            Gson gson = new Gson();
            Exercise[] w = gson.fromJson(workoutList, Exercise[].class);
            ArrayList<Exercise> exercises = new ArrayList();
            Collections.addAll(exercises, w);
            return exercises;
            
        }catch (IOException ex) {
            saveToFile(muscle);
            loadFromFile("data/" + muscle.getMuscleName() + ".txt", muscle);
        }
        return null;
    }
    
    public int getMuscleGrp(){
        return msclGrp;
    }
    
    public ArrayList<Exercise> getExercises(){
        return arrayex;
    }
    
    /**
     * uses the exercise apiId to get the icons for the exercise
     * If no image is found returns no image, which will trigger the
     * default image to be set in the exercise panel
     */
    public static String getIconURLString(int apiId){
        try {
            URL oracle = new URL(iconUrl +"&exercise=" + apiId);
            URLConnection connection;
            connection = oracle.openConnection();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();

            String jsonResponseFromServer = sb.toString();
            JsonParser jparser = new JsonParser();
            JsonElement jElemRoot = jparser.parse(jsonResponseFromServer);
            JsonObject jObjRoot = jElemRoot.getAsJsonObject();

            JsonArray jExerciseURLArray = jObjRoot.getAsJsonArray("results");
            JsonObject image = new JsonObject();
            if(jExerciseURLArray.size() > 0){
                return jExerciseURLArray.get(1).getAsJsonObject().get("image").getAsString();
            }
            else
                return "no Image";
            
        }
        catch (MalformedURLException ex) {
                return "no Image";
        } 
        catch (IOException ex) {
                return "no Image";
        }
    }
}
