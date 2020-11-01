/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogModel;

import WorkoutModel.WorkoutList;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jamyangtamang
 * 
 * 
 * LogEntrys are instances of 
 * the data for log entries
 */
public class LogModel {
    private static LogModel Log;
    private ArrayList<LogEntry> logEntries;
    /**
     * @param log is a reference of the log that the model will be linked to
     * @param logEntries An ArrayList of all the entry that were made  
     */
    private LogModel(){
         logEntries = new ArrayList();
    }
    
    
    public LogEntry getEntry(int i){
        return logEntries.get(i);
    }
    
    public void addEntry(String date, String name, String status){
        LogEntry add = new LogEntry(date, name, status);
        logEntries.add(add);
    }
    
    public int getSize(){
        return logEntries.size();
    }

    /** 
     * 
     * @return an instance for the LogModel as it is static
     */
    public static LogModel getInstance(){
        if(Log == null)
            return Log = new LogModel();
        else
            return Log;
    }
    
    /**
     * loads data from file which is in Json and adds it into the log entries
     * If log.txt isn't found it creates a new log.txt with no entries
     */
    public void loadFromFile(){
        try{
            FileReader fr = new FileReader("data/log.txt");
            BufferedReader br = new BufferedReader(fr);
            JsonParser jparser = new JsonParser();
            JsonElement rootElement = jparser.parse(br);
            if(rootElement.getAsJsonObject() != null){
                JsonObject logEntryObject = rootElement.getAsJsonObject();

                JsonElement entryList = logEntryObject.get("Entries");
                JsonArray allWorkouts = entryList.getAsJsonArray();
                Gson gson = new Gson();
                LogEntry[] l = gson.fromJson(entryList, LogEntry[].class);
                logEntries.clear();
                Collections.addAll(logEntries, l);
            }
        }catch (IOException ex) {
            saveToLogFile();
            loadFromFile();
        }
    }
    
    /**
     * 
     * @return a string that contains the log Entires in Json format
     */
    public String getAsJSON() {
        Gson gson = new Gson();
        String logEntriesJson = gson.toJson(logEntries);
        StringBuilder sb = new StringBuilder();
        sb.append("{\nEntries: ");
        sb.append(logEntriesJson);
        sb.append("\n}");
        return sb.toString();
    }
    
    /**
     * Saves the logentries to log.txt in Json format
     */
    public boolean saveToLogFile() {
        String sFullJsonForThis = this.getAsJSON();

        try {
            FileWriter fw = new FileWriter("data/log.txt");
            fw.write(sFullJsonForThis);
            fw.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(WorkoutList.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
