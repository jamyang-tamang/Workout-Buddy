/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkoutGui;

import LogGui.Log;
import LeaderboardGui.LeaderBoardFrame;
import staticData.DialogBoxIcon;
import WorkoutModel.Workout;
import WorkoutModel.WorkoutList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jamyangtamang
 */
public class WorkoutBuddyGui extends javax.swing.JFrame {
    private final WorkoutList workoutList;
    private DefaultTableModel model;
    
    public WorkoutBuddyGui() {
        ImageIcon img = new ImageIcon("icons/addExcercise.jpg");
        this.setTitle("Workout Buddy");
        workoutList = WorkoutList.getInstance();
        initComponents();
        
        workoutList.loadFromFile("data/default.txt");
        if(workoutList.getSize() < 1)
            workoutList.loadFromFile("data/Sample.txt");
        for(int i = 0; i < workoutList.getSize(); i++){
            WorkoutPanel panel = new WorkoutPanel(workoutList.getWorkout(i), this, workoutList);
            jtpWorkouts.addTab(workoutList.getWorkout(i).getName(), panel);
            panel.loadTable();
        }
    }
    
    public void renameTab(String input){
        jtpWorkouts.setTitleAt(jtpWorkouts.getSelectedIndex(), input);
        workoutList.getWorkout(jtpWorkouts.getSelectedIndex()).setName(input);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Title = new javax.swing.JLabel();
        jtpWorkouts = new javax.swing.JTabbedPane();
        addWorkoutBtn = new javax.swing.JButton();
        removeWorkoutBtn = new javax.swing.JButton();
        renameWorkoutBtn = new javax.swing.JButton();
        logBtn = new javax.swing.JButton();
        ldrBoard = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Bangla Sangam MN", 1, 16)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Workout Buddy");
        Title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jtpWorkouts.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtpWorkouts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addWorkoutBtn.setText("Add Workout");
        addWorkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkoutBtnActionPerformed(evt);
            }
        });

        removeWorkoutBtn.setText("Remove this Workout");
        removeWorkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWorkoutBtnActionPerformed(evt);
            }
        });

        renameWorkoutBtn.setText("Rename this Workout");
        renameWorkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameWorkoutBtnActionPerformed(evt);
            }
        });

        logBtn.setText("Log");
        logBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBtnActionPerformed(evt);
            }
        });

        ldrBoard.setText("LeaderBoard");
        ldrBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ldrBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(renameWorkoutBtn)
                                .addGap(18, 18, 18)
                                .addComponent(addWorkoutBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeWorkoutBtn)
                            .addComponent(ldrBoard, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtpWorkouts, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logBtn)
                    .addComponent(ldrBoard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameWorkoutBtn)
                    .addComponent(addWorkoutBtn)
                    .addComponent(removeWorkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpWorkouts, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addWorkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkoutBtnActionPerformed
        String name = (String) JOptionPane.showInputDialog(null, "What would you like to name this workout?", "Add Workout", JOptionPane.QUESTION_MESSAGE, DialogBoxIcon.WORKOUT, null, "");
        if(name != null){
            Workout workout = new Workout(name);
            workoutList.addWorkout(workout);
            WorkoutPanel panel = new WorkoutPanel(workout, this, workoutList);
            jtpWorkouts.addTab(workout.getName(), panel);
            workoutList.saveToFile();
        }
    }//GEN-LAST:event_addWorkoutBtnActionPerformed

    private void removeWorkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWorkoutBtnActionPerformed
        if(jtpWorkouts.getSelectedIndex() > -1){
            workoutList.removeWorkout(jtpWorkouts.getSelectedIndex());
            jtpWorkouts.remove(jtpWorkouts.getSelectedIndex());
            workoutList.saveToFile();
        }
        else    
            JOptionPane.showMessageDialog(null, "You have no workouts to remove!", "No Workouts", JOptionPane.WARNING_MESSAGE, DialogBoxIcon.ISSUE);
    }//GEN-LAST:event_removeWorkoutBtnActionPerformed

    private void renameWorkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameWorkoutBtnActionPerformed
        if(jtpWorkouts.getSelectedIndex() > -1){
            String input= (String) JOptionPane.showInputDialog(null, "Please enter the name you wanna give this workout!", "RenameWorkout", JOptionPane.QUESTION_MESSAGE, DialogBoxIcon.WORKOUT, null, "");
            if(input != null){
                this.renameTab(input);
                workoutList.getWorkout(jtpWorkouts.getSelectedIndex()).setName(input); 
                workoutList.saveToFile();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "You have no workout to rename!", "No Workouts", JOptionPane.WARNING_MESSAGE, DialogBoxIcon.ISSUE);
    }//GEN-LAST:event_renameWorkoutBtnActionPerformed

    private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed
        Log.getLog(this);
        Log.makeVisible();
        this.setVisible(false);
    }//GEN-LAST:event_logBtnActionPerformed

    private void ldrBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ldrBoardActionPerformed
        LeaderBoardFrame.getLeaderBoard(this);
        this.setVisible(false);
        LeaderBoardFrame.makeVisible();
    }//GEN-LAST:event_ldrBoardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton addWorkoutBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jtpWorkouts;
    private javax.swing.JButton ldrBoard;
    private javax.swing.JButton logBtn;
    private javax.swing.JButton removeWorkoutBtn;
    private javax.swing.JButton renameWorkoutBtn;
    // End of variables declaration//GEN-END:variables
}
