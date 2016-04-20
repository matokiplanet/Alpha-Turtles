import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Lauren Calderella 
// Final (4/20)

public class MemoryGameModel extends GameModel{

   //Declare stuff
   public ImageIcon [] images = new ImageIcon[16];
   public ImageIcon coverimage = new ImageIcon("watermelon.jpg");
   
   boolean match = false;
   int choice1;
   int choice2;
   int numberOfCardsFlipped = 0;
   int numberOfMatches = 0;
   int numberOfAttempts = 0;
     
   public MemoryGameModel(){
      images[0] = new ImageIcon("Dog1.jpg");
      images[1] = new ImageIcon("Dog1.jpg");
      images[2] = new ImageIcon("Dog2.jpg");
      images[3] = new ImageIcon("Dog2.jpg");
      images[4] = new ImageIcon("Dog3.jpg");
      images[5] = new ImageIcon("Dog3.jpg");
      images[6] = new ImageIcon("Dog4.jpg");
      images[7] = new ImageIcon("Dog4.jpg");
      images[8] = new ImageIcon("Dog5.jpg");
      images[9] = new ImageIcon("Dog5.jpg");
      images[10] = new ImageIcon("Dog6.jpg");
      images[11] = new ImageIcon("Dog6.jpg");
      images[12] = new ImageIcon("Dog7.jpg");
      images[13] = new ImageIcon("Dog7.jpg");
      images[14] = new ImageIcon("Dog0.jpg");
      images[15] = new ImageIcon("Dog0.jpg");
      
      for (int i = 0; i < images.length; i++){
         Random random = new Random();
         int randomNumber = random.nextInt(images.length);
         ImageIcon imgIcon = images[i];
         ImageIcon randomPick = images[randomNumber];
         images[i] = randomPick;
         images[randomNumber] = imgIcon;
      }
   } 

//_____________________________________________________________________________________________________________
        
        
   @Override
      boolean gameOverStatus(){
      return true;
   }
        
   @Override
   ImageIcon get(int i){
      return images[i];
   } 
        
   @Override
      int getRows(){
      return 4;
   }
        
   @Override
      int getCols(){
      return 4;
   } 
        
   @Override
      void display(){
      for (int i = 0; i < images.length; i++){
         ImageIcon imgIcon = images[i];
         System.out.print(imgIcon.getDescription() + "\t"); 
         if (i == 1){
            System.out.println();
         }   
      }
   } 

   @Override  
   public String reportWinner(){
      String str;
      if (numberOfMatches == 8){
         str = "You Won";
      }
      else{
         str = "Attempts: "+ numberOfAttempts + " Matches: " + numberOfMatches;
      }
      return str;
   }  

//_____________________________________________________________________________________________________________


   //TAKE TURN
   public void takeTurn(int i){
      numberOfCardsFlipped++;
      if (numberOfCardsFlipped % 2 == 0){
         choice2 = i;
         if(images[choice2].getDescription().equals(images[choice1].getDescription())){
            match = true; 
            numberOfMatches++;
         } 
         else{
            match = false;
         }
      }
      
      else{
         match = false;
         choice1 = i;
         numberOfAttempts++;
         return;
      }
      
      
      // System.out.println("Choice 1: " + images[choice1].getDescription());
//       System.out.println("Choice 2: " + images[choice2].getDescription());
//       System.out.println("Number of Matches: " + numberOfMatches);
//       System.out.println("Number of Attempts: " + numberOfAttempts);

   } // close takeTurn

//_____________________________________________________________________________________________________________

   public boolean getMatch(){
      return match;
   }
//_____________________________________________________________________________________________________________
   
   public ImageIcon getImage(int i){
      return images[i];
   }
//_____________________________________________________________________________________________________________


   public int getAttempts(int numberOfAttempts){
      return numberOfAttempts;
      }
//_____________________________________________________________________________________________________________
      
   public int getMatches(int numberOfMatches){
      return numberOfMatches;
      }
//_____________________________________________________________________________________________________________
      
} // close class 
