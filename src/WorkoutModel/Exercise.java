/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkoutModel;

/**
 *
 * @author jamyangtamang
 * Keeps track of information about an exercise
 */
public class Exercise {
    private String name;
    private int set;
    private int rep;
    private double weight;
    private String description;
    private String muscleGroup;
    private int apiId;
    
    /**
     * 
     * @param name name of the exercise
     * @param set number of sets the user needs to do 
     * @param rep number of reps that the user need to do
     * @param weight amount of weight that the user needs to lift
     * @param muscleGroup muscle group that the exercise targets
     * @param description description of the exercise
     * @param apiId apiId is used by the wger api to get the specific icon for the exercise
     */
    public Exercise(String name, int set, int rep, double weight, String muscleGroup, String description, int apiId){
        this.name = name;
        this.set = set;
        this.rep = rep;
        this.weight = weight;
        this.muscleGroup = muscleGroup;
        this.description = description;
        this.apiId = apiId;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the set
     */
    public int getSet() {
        return set;
    }

    /**
     * @param set the set to set
     */
    public void setSet(int set) {
        this.set = set;
    }
    
    /**
     * @return the rep
     */
    public int getRep() {
        return rep;
    }

    /**
     * @param rep the rep to set
     */
    public void setRep(int rep) {
        this.rep = rep;
    }
    
    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the muscleGroup
     */
    public String getMuscleGroup() {
        return muscleGroup;
    }

    /**
     * @param muscleGroup the muscleGroup to set
     */
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    
    public int getapiId(){
        return apiId;
    }
    
    public void setapiId(int id){
        this.apiId= id;
    }

}
