import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class MemoryGameReport extends MemoryGameGUI{
 
public static void main(){
 int numberofMatches = 2; 
 int numberofAttempts = 2;
 int attemptsallowed = 8;
 int attemptsleftvar = 8;
 int totalmatches = 2;
 String numberofmatches = "";

 NumberofMatches(numberofMatches);
 System.out.println(numberofmatches);
 AttemptsLeft(numberofAttempts,attemptsallowed,attemptsleftvar);
 WinOrNoWin(numberofMatches,totalmatches);
}//main
 
   public static String NumberofMatches (int numberofMatches){
         return (numberofMatches + "matches found");
   }//Number of Matches
   
   public static String AttemptsLeft (int numberofAttempts,int attemptsallowed,int attemptsleftvar){
      attemptsleftvar = attemptsallowed - numberofAttempts;
      return (attemptsleftvar + "attempts left");
   }//AttemptsLeft
      
   public static String WinOrNoWin (int numberofMatches,int totalmatches){
      if (totalmatches == numberofMatches){
         return("YOU WIN");
         }
      else{
         return("KEEP GOING");
         }
   }//WinOrNoWin
   
}//class