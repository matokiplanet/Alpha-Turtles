import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//My portion of the group project

public class MemoryGameModel extends GameModel{

   //Declare stuff
   private ImageIcon [] images = new ImageIcon[4];
   private ImageIcon coverimage = new ImageIcon("watermelon.jpg");
   
   boolean match = false;
   int attempts = 0;
   int choice1;
   int choice2;
   int numberOfCardsFlipped;
   int numberOfMatches = 0;
   int numberOfAttempts = 0;
   
     
   public MemoryGameModel(){
      images[0] = new ImageIcon("Dog1.jpg");
      images[1] = new ImageIcon("Dog1.jpg");
      images[2] = new ImageIcon("Dog2.jpg");
      images[3] = new ImageIcon("Dog2.jpg");
      //Shuffle
      /*for (int i = 0; i < images.length; i++){
         Random random = new Random();
         int randomNumber = random.nextInt(4);
         ImageIcon imgIcon = images[i];
         ImageIcon randomPick = images[randomNumber];
         images[i] = randomPick;
         images[randomNumber] = imgIcon;
      }*/
   }
      //@Override
   //void takeTurn(int t){
   // }

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

//_____________________________________________________________________________________________________________


   //TAKE TURN
   public void takeTurn(int i){
      numberOfCardsFlipped++;
   
      if (numberOfCardsFlipped % 2 == 0){
         choice2 = i;
         System.out.println(images[choice2].getDescription());
         System.out.println(images[choice1].getDescription());
      
         if(images[choice2].getDescription() == images[choice1].getDescription()){
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
      }
            
   }//close takeTurn

//_____________________________________________________________________________________________________________

   public boolean getMatch(){
      return match;
   }
   
   
  public ImageIcon getImage(int i){
      return images[i];
  }

}//close class


//_____________________________________________________________________________________________________________



class Thing{
   public static void main(String[] args){
      MemoryGameModel mg = new MemoryGameModel();
      mg.display();
      System.out.println(mg.match);
      
      mg.takeTurn(0);
      mg.takeTurn(3); 
      
      System.out.println(mg.match); 
   }
}
