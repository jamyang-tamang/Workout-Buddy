/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workout_Web_Services;

import LeaderBoardModel.LeaderBoardEntry;
import LeaderBoardModel.LeaderBoardModel;
import LeaderBoardModel.LeaderBoardSorter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import staticData.DialogBoxIcon;

/**
 *
 * @author jamyangtamang
 * Allows the user to access the laderBoardModel which is hosted on a server
 * the link to access the server data http://localhost:8000/leaderBoard/get
 * This initializes a server
 */
public class LeaderBoardDataProvider {
    private static LeaderBoardModel leaderBoardModel = null;
    final static String Url = "http://localhost:8000/leaderBoard/get";
    private static ArrayList<LeaderBoardEntry> specificModel;
    
    public static void startWebServices(LeaderBoardModel leaderBoardModel) throws IOException{
        LeaderBoardDataProvider.leaderBoardModel = leaderBoardModel;
        specificModel = new ArrayList();
        
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),2);
        
        HandleLeaderBoardSerialization leaderBoardGetHandler = new HandleLeaderBoardSerialization();
        server.createContext("/leaderBoard/get", leaderBoardGetHandler);
        server.setExecutor(null);
        server.start();
    }
    
    /**
     * 
     * Allows for the pulling of data from the server
     * returns an array list of LeaderBoardEntry with 
     * all the LeaderBoardEntries
     * If the database is empty or the user is unable to connect
     * displays a dialog box saying so
     */
        public static ArrayList<LeaderBoardEntry> getData(String specifiedExercise){
            specificModel.clear();
            try {
            URL oracle = new URL(Url);
            URLConnection connection = oracle.openConnection();
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
                    
                    JsonArray jArrEntries = jObjRoot.getAsJsonArray("Entries");
                    ArrayList<JsonObject> jobjExerciseBlocks = new ArrayList();
                    for(int i = 0; i < jArrEntries.size(); i++){
                            String exerciseName = jArrEntries.get(i).getAsJsonObject().get("exerciseName").getAsString();
                            if(exerciseName.equals(specifiedExercise)){
                                String userName = jArrEntries.get(i).getAsJsonObject().get("userName").getAsString();
                                Double orm = jArrEntries.get(i).getAsJsonObject().get("oneRepMax").getAsDouble();
                                LeaderBoardEntry entry = new LeaderBoardEntry(userName, exerciseName, orm);
                                specificModel.add(entry);  
                            }
                    }
            LeaderBoardSorter leaderBoardSorter = new LeaderBoardSorter(specificModel);         
            ArrayList<LeaderBoardEntry> sortedLeaderBoard = leaderBoardSorter.getSortedListByORM();  
            return sortedLeaderBoard;
        }
        catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "You are unable to connect to the server right now!", "Server Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);           
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database has nothing new to read!", "Database Error", JOptionPane.WARNING_MESSAGE ,DialogBoxIcon.ISSUE);           
        }
        return null;
    }        
    
        
   static private class HandleLeaderBoardSerialization implements HttpHandler{
        public void handle(HttpExchange t) throws IOException {
            SendResponse(leaderBoardModel.getAsJSON(),t);
        }        
    }   
    
    static private void SendResponse(String response, HttpExchange t) throws IOException{
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();       
    }
}
