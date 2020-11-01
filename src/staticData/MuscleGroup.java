/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticData;

/**
 *
 * @author jamyangtamang
 * This is an enumeration of each muscle class, and returns the number related to each muscle group
 */
public class MuscleGroup {
    private int muscleNumber;
    public static MuscleGroup BICEPS = new MuscleGroup("BICEPS");
    public static MuscleGroup SHOULDER = new MuscleGroup("SHOULDER");
    public static MuscleGroup OBLIQUE = new MuscleGroup("OBLIQUE");
    public static MuscleGroup OBLIQUE_2 = new MuscleGroup("OBLIQUE_2");
    public static MuscleGroup CHEST = new MuscleGroup("CHEST");
    public static MuscleGroup CHEST_2 = new MuscleGroup("CHEST_2");
    public static MuscleGroup TRICEP = new MuscleGroup("TRICEP");
    public static MuscleGroup AB = new MuscleGroup("AB");
    public static MuscleGroup CALF = new MuscleGroup("CALF");
    public static MuscleGroup CALF_2 = new MuscleGroup("CALF_2");
    public static MuscleGroup GLUTE = new MuscleGroup("GLUTE");
    public static MuscleGroup TRAP = new MuscleGroup("TRAP");
    public static MuscleGroup QUAD = new MuscleGroup("QUAD");
    public static MuscleGroup HAMSTRING = new MuscleGroup("HAMSTRING");
    public static MuscleGroup BACK = new MuscleGroup("BACK");

    private String myType;
    
    private MuscleGroup(String type){
        myType = type;
        if(type=="BICEPS"){
            muscleNumber = 1;
        }
        else if(type=="SHOULDER"){
            muscleNumber = 2;
        }
        else if(type=="OBLIQUE"){
            muscleNumber = 3;
        }
        else if(type=="OBLIQUE_2"){
            muscleNumber = 14;
        }
        else if(type=="CHEST"){
            muscleNumber = 4;
        }
        else if(type=="CHEST_2"){
            muscleNumber = 13;
        }
        else if(type=="TRICEP"){
            muscleNumber = 5;
        }
        else if(type=="AB"){
            muscleNumber = 6;
        }
        else if(type=="CALF"){
            muscleNumber = 7;
        }
        else if(type=="CALF_2"){
            muscleNumber = 15;
        }
        else if(type=="GLUTE"){
            muscleNumber = 8;
        }
        else if(type=="TRAP"){
            muscleNumber = 9;
        }
        else if(type=="QUAD"){
            muscleNumber = 10;
        }
        else if(type=="HAMSTRING"){
            muscleNumber = 11;
        }
        else if(type=="BACK"){
            muscleNumber = 12;
        }
    }
    
    public String getMuscleName(){
        return myType;
    }
    
    public int getMuscleNumber(){
        return muscleNumber;
    }
    
    public boolean isType(MuscleGroup otherType){
        return otherType.myType.equals(this.myType);
    }
}
