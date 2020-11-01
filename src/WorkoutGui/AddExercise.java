/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkoutGui;

import Workout_Web_Services.WorkoutApiProvider;
import staticData.DialogBoxIcon;
import WorkoutModel.Exercise;
import staticData.MuscleGroup;
import WorkoutModel.Workout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;


/**
 *
 * @author jamyangtamang
 * Allows user to add exercises to their workouts
 */
public class AddExercise extends javax.swing.JFrame {
    protected WorkoutPanel workoutPanel;
    protected Workout workout;
    protected String name;
    protected int set;
    protected int rep;
    protected double weight;
    protected String muscleGroup;
    protected WorkoutApiProvider provided;
    protected String description;
    protected int apiId;
    protected Object[] options = {"OK","NO"};
    protected int weightOption;
    protected static HashMap< String, ArrayList<Exercise>> exerciseCache;
    protected ArrayList<Exercise> exerciseArray;
    protected String key;
    private Thread updateExercises;
    
    /**
     * Creates new form AddExercise
     * @param workoutPanel keeps a reference to the workoutPanel where this exercise is going to tbe added
     * @param workoutName keeps a reference to the workout that this workout is being added to
     */
    
    public AddExercise(WorkoutPanel workoutPanel, Workout workoutName) {
        this.workoutPanel = workoutPanel; 
        this.workout = workoutName;
        AddExercise.exerciseCache = new HashMap();
        this.exerciseArray = new ArrayList();
        initComponents();
        submissionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submissionBtnActionPerformed(evt);
            }
        });
        updateExercises = new Thread(new RunnableClass());
        this.setTitle("Add Exercise");
        msclGrp.addItem("Chest");
        msclGrp.addItem("Back");
        msclGrp.addItem("Biceps");
        msclGrp.addItem("Triceps");
        msclGrp.addItem("Glutes");
        msclGrp.addItem("Abs");
        msclGrp.addItem("Shoulder");
        msclGrp.addItem("Calves");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfTitle = new javax.swing.JTextField();
        numberOfReps = new javax.swing.JTextField();
        numberOfSets = new javax.swing.JTextField();
        submissionBtn = new javax.swing.JButton();
        weightInput = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        exerciseName = new javax.swing.JComboBox<>();
        msclGrp = new javax.swing.JComboBox<>();
        msclGrpLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        setsLbl = new javax.swing.JLabel();
        repsLbl = new javax.swing.JLabel();
        weightLbl = new javax.swing.JLabel();
        updateExerciseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfTitle.setEditable(false);
        jtfTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfTitle.setText("Enter The Following Details");
        jtfTitle.setActionCommand("<Not Set>");

        numberOfReps.setText("Please Enter the Number of Reps");
        numberOfReps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberOfRepsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numberOfRepsFocusLost(evt);
            }
        });

        numberOfSets.setText("Please Enter the Number of Sets");
        numberOfSets.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numberOfSets.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberOfSetsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numberOfSetsFocusLost(evt);
            }
        });

        submissionBtn.setText("OK");

        weightInput.setText("Please Enter the Weight you're lifting");
        weightInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                weightInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                weightInputFocusLost(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        exerciseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BenchPress", "Squat", "Deadlift", "BicepCurls" }));

        msclGrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msclGrpActionPerformed(evt);
            }
        });

        msclGrpLbl.setText("Muscle Group");

        nameLbl.setText("Exercise Name");

        setsLbl.setText("Sets");

        repsLbl.setText("Reps");

        weightLbl.setText("Weight");

        updateExerciseBtn.setText("Get Latest exercises");
        updateExerciseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExerciseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(repsLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numberOfReps, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(setsLbl)
                                .addGap(52, 52, 52)
                                .addComponent(numberOfSets, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(msclGrpLbl)
                            .addComponent(nameLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exerciseName, 0, 316, Short.MAX_VALUE)
                            .addComponent(msclGrp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(weightLbl)
                        .addGap(40, 40, 40)
                        .addComponent(weightInput, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateExerciseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(submissionBtn)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msclGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msclGrpLbl))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exerciseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfSets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setsLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfReps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repsLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weightLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(weightInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submissionBtn)
                            .addComponent(backBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateExerciseBtn)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * It checks the user input to see if its valid
     * If any of the inputs are invalid handles adds to a string builder that
     * states the issues with input and shows it
     * @return validity status
     */
    protected boolean checkInputs(String set, String rep, String weight){
        boolean status = true;
        StringBuilder sb = new StringBuilder();
        try{
            this.set = Integer.parseInt(set);
            if (this.set < 0) {
                throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
           }
        }
        catch(NumberFormatException nfe){
            numberOfSets.setBackground(Color.RED);
            status = false;
            sb.append("Improper set value!\n");
        }catch (IllegalArgumentException e) {
               numberOfSets.setBackground(Color.RED);
               status = false;
               sb.append("Can't have negetive sets!\n");
        }
        
        try{
            this.rep = Integer.parseInt(rep);
            if (this.rep < 0) {
                throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
           }
            
        }
        catch(NumberFormatException nfe){
           numberOfReps.setBackground(Color.RED);
           status = false;
           sb.append("Improper rep value!\n");
        }
        catch (IllegalArgumentException e) {
               numberOfReps.setBackground(Color.RED);
               status = false;
               sb.append("Can't have negetive reps!\n");
        }
        
        try{
           if(weight.equals("0") || weight.equals("Please Enter the Weight you're lifting") || weight.equals("")){
                this.weight = 0;
                weightInput.setBackground(Color.YELLOW);
                if(status == true){
                    weightOption = JOptionPane.showOptionDialog(null ,"You have no weight input, it will be set to 0!","Weight Input", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, DialogBoxIcon.ISSUE,options,options[0]); //default button title              
                    if(weightOption == 0)
                        status = true;
                    else
                        status = false;
                }
                else
                    sb.append("Improper weight value, if not entered it will be set to 0!\n");
           }
           else{
            this.weight = Double.parseDouble(weight);
            if (this.rep < -1) {
                throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
            }
           }
       }
       catch(NumberFormatException nfe){
           weightInput.setBackground(Color.RED);
           status = false;
           sb.append("Improper weight input!\n");
       }
        catch (IllegalArgumentException e) {
               weightInput.setBackground(Color.RED);
               status = false;
               sb.append("Can't have negetive weight!\n");
        }
        if(sb.toString().isBlank())
            return status;
        
        JOptionPane.showMessageDialog(null,sb.toString(),"Input Issues",JOptionPane.INFORMATION_MESSAGE, DialogBoxIcon.ISSUE);  
        return false;
    }
    
    private void numberOfSetsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberOfSetsFocusGained
        numberOfSets.setBackground(Color.WHITE);
        if(numberOfSets.getText().equals("Please Enter the Number of Sets"))
            numberOfSets.setText("");
    }//GEN-LAST:event_numberOfSetsFocusGained

    private void numberOfRepsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberOfRepsFocusGained
        numberOfReps.setBackground(Color.WHITE);
        if(numberOfReps.getText().equals("Please Enter the Number of Reps"))    
            numberOfReps.setText("");
    }//GEN-LAST:event_numberOfRepsFocusGained

    private void weightInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weightInputFocusGained
        weightInput.setBackground(Color.WHITE);
        if(weightInput.getText().equals("Please Enter the Weight you're lifting"))
            weightInput.setText("");
    }//GEN-LAST:event_weightInputFocusGained

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        workoutPanel.makeGuiVisible();
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed
    
    /**
     * Loads the exercises getting it from the saved JSon files 
     * based on the muscle group that the user selected
     * @param evt 
     */
    private void msclGrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msclGrpActionPerformed
        switch(msclGrp.getSelectedItem().toString())
        {
            case "Chest":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/CHEST.txt", MuscleGroup.CHEST);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;

            case "Back":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/BACK.txt", MuscleGroup.BACK);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;

            case "Biceps":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/BICEPS.txt", MuscleGroup.BICEPS);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;
                
            case "Triceps":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/TRICEP.txt", MuscleGroup.TRICEP);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;
                
            case "Glutes":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/GLUTE.txt", MuscleGroup.GLUTE);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;

            case "Abs":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/AB.txt", MuscleGroup.AB);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;
                
            case "Shoulder":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/SHOULDER.txt", MuscleGroup.SHOULDER);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;

            case "Calves":
                exerciseName.removeAllItems();
                exerciseArray = WorkoutApiProvider.loadFromFile("data/CALF.txt", MuscleGroup.CALF);
                for(int i = 0; i < exerciseArray.size(); i++)
                    exerciseName.addItem(exerciseArray.get(i).getName());
                break;
        }
    }//GEN-LAST:event_msclGrpActionPerformed

    private void numberOfSetsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberOfSetsFocusLost
        if(numberOfSets.getText().equals(""))
            numberOfSets.setText("Please Enter the Number of Sets");
    }//GEN-LAST:event_numberOfSetsFocusLost

    private void numberOfRepsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberOfRepsFocusLost
        if(numberOfReps.getText().equals(""))
            numberOfReps.setText("Please Enter the Number of Reps");
    }//GEN-LAST:event_numberOfRepsFocusLost

    private void weightInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weightInputFocusLost
        if(weightInput.getText().equals(""))
            weightInput.setText("Please Enter the Weight you're lifting");
    }//GEN-LAST:event_weightInputFocusLost

    private void updateExerciseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExerciseBtnActionPerformed
        updateExercises.start();
        while(updateExercises.isAlive()){
                JOptionPane.showMessageDialog(null,"Please wait while exercises get updated.","Upating Exercise",JOptionPane.WARNING_MESSAGE, DialogBoxIcon.LOADING); 
        }
    }//GEN-LAST:event_updateExerciseBtnActionPerformed

   
    /**
     * Class that is used by the thread that updates exercises for each muscle group
     */
    private class RunnableClass implements Runnable{
        @Override
        public synchronized void run() {
            WorkoutApiProvider.saveToFile(MuscleGroup.CHEST);
            WorkoutApiProvider.saveToFile(MuscleGroup.BACK);
            WorkoutApiProvider.saveToFile(MuscleGroup.BICEPS);
            WorkoutApiProvider.saveToFile(MuscleGroup.TRICEP);
            WorkoutApiProvider.saveToFile(MuscleGroup.GLUTE);
            WorkoutApiProvider.saveToFile(MuscleGroup.AB);
            WorkoutApiProvider.saveToFile(MuscleGroup.SHOULDER);
            WorkoutApiProvider.saveToFile(MuscleGroup.CALF);
            updateExercises.stop();
        }
        
    }
    /** 
     * When clicked on the muscle groups it submits the user entered data 
     * as a new entry to the workout that it is for
     * calls the check input to verify that the data is valid
     * pulss up the workoutPanel and deletes this menu
     * @param evt event trigger
     */
    protected void submissionBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if((checkInputs(numberOfSets.getText(), numberOfReps.getText(), weightInput.getText()))){
            name = (String) exerciseName.getSelectedItem();
            muscleGroup = (String) msclGrp.getSelectedItem().toString();
            description = exerciseArray.get(exerciseName.getSelectedIndex()).getDescription();
            apiId = exerciseArray.get(exerciseName.getSelectedIndex()).getapiId();
            Exercise exercise = new Exercise(name, set, rep, weight, muscleGroup, description, apiId);
            workoutPanel.addExercise(exercise);
            workoutPanel.updateTable(workout.getNumExercise()- 1);
            workoutPanel.makeGuiVisible();
            this.dispose();
        }
         
    }      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    protected javax.swing.JComboBox<String> exerciseName;
    private javax.swing.JTextField jtfTitle;
    protected javax.swing.JComboBox<String> msclGrp;
    private javax.swing.JLabel msclGrpLbl;
    private javax.swing.JLabel nameLbl;
    protected javax.swing.JTextField numberOfReps;
    protected javax.swing.JTextField numberOfSets;
    private javax.swing.JLabel repsLbl;
    private javax.swing.JLabel setsLbl;
    protected javax.swing.JButton submissionBtn;
    private javax.swing.JButton updateExerciseBtn;
    protected javax.swing.JTextField weightInput;
    private javax.swing.JLabel weightLbl;
    // End of variables declaration//GEN-END:variables
}