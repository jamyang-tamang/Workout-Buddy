/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkoutModel;

import java.util.ArrayList;

/**
 *
 * @author jamyangtamang
 * keeps a list of all the exercises for the specific workout
 */
public class Workout {
    private String name;
    private ArrayList<Exercise> exercises;
    
    public Workout(String name){
        this.name = name;
        exercises = new ArrayList<Exercise>();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }
    
    public Exercise getExercise(int index){
        return exercises.get(index);
    }
    
    public void deleteExercise(int index){
        exercises.remove(index);
    }
    
    public ArrayList<Exercise> getWorkout(){
        return exercises;
    }
    
    public int getNumExercise(){
        return exercises.size();
    }
}
