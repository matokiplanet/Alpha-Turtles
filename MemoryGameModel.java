import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//My portion of the group project

public class MemoryGameModel extends GameModel{

   //Declare stuff
   private ImageIcon [] images = new ImageIcon[4];
   boolean match = false;
   boolean noMatch = false;
   int attempts = 0;
   int choice1;
   int choice2;
   int numberOfCardsFlipped;
   
     
   public MemoryGameModel(){
      images[0] = new ImageIcon("Dog1.jpg");
      images[1] = new ImageIcon("Dog1.jpg");
      images[2] = new ImageIcon("Dog2.jpg");
      images[3] = new ImageIcon("Dog2.jpg");
      //Shuffle
      for (int i = 0; i < images.length; i++){
         Random random = new Random();
         int randomNumber = random.nextInt(4);
         ImageIcon imgIcon = images[i];
         ImageIcon randomPick = images[randomNumber];
         images[i] = randomPick;
         images[randomNumber] = imgIcon;
      }
   }
   
//    if imgageName.equals("Dog1.jpg") && other imageName.equals("Dog1.jpg"){
//    
   //@Override
   //void takeTurn(int t){
   // }
        
        
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
      return 2;
   }
        
   @Override
      int getCols(){
      return 2;
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
      String reportWinner(){
      return "";
   }  

   public static void main(String[] args){
      MemoryGameModel mg = new MemoryGameModel();
      mg.display();
   }

   //TAKE TURN
   public void takeTurn(int i){
      numberOfCardsFlipped++;
   
      if (numberOfCardsFlipped / 2 == 0){
         choice2 = i;
         if(images[choice2] == images[choice1]){
            match = true;
         } 
      }
      
      else{
         choice1 = i;
      }
   }//close takeTurn



}//close class
