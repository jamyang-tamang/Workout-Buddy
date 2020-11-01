/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticData;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jamyangtamang
 * 
 * This is a enumeration of icons so that whenever JOption Panes use icons
 * I use these enumerations to reffer to the icons.
 * 
 * link to icons:
 * Error - https://www.dreamstime.com/vector-pixel-art-broken-dumbbell-isolated-cartoon-image143803617
 * Attention - https://www.hiclipart.com/free-transparent-background-png-clipart-iuwmq
 * Workout - https://oneymca.org/wp-content/uploads/Whole-body-workout-icon.jpg
 * Issues - https://www.shutterstock.com/image-vector/crossed-dumbbells-silhouette-isolated-on-white-1248510892
 * Loading - https://giphy.com/gifs/loading-52qtwCtj9OLTi
 */
public class DialogBoxIcon {
   
   
   public final static ImageIcon ERROR = new ImageIcon(new ImageIcon("icons/broken.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

   public final static ImageIcon ATTENTION = new ImageIcon(new ImageIcon("icons/attention.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
   
   public final static ImageIcon WORKOUT = new ImageIcon(new ImageIcon("icons/workout.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
   
   public final static ImageIcon ISSUE = new ImageIcon(new ImageIcon("icons/issue.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

   public final static ImageIcon LOADING = new ImageIcon("icons/loading.gif");
   
}
