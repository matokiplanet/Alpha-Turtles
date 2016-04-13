import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Project2 extends JFrame implements ActionListener{

   int totalmatches = 2;

   //get number of matches from actionperformed
   
   JLabel matchesreport = new JLabel(matchesfound + "matches found");
   JLabel add(matchesreport,BorderLayout.WEST);
   
   //how many matches left/ if they win
   
   int matchesleft = (totalmatches - matchesfound) 
   
   if matchesleft == 0{
   
      JLabel matchesleftreport = new JLabel("YOU FOUND ALL THE MATCHES");
      }
   else {
   
      JLabel matchesleftreport = new JLabel(matchesleft + "matches to go");
      }
      
   JLabel add(matchesleftreport,BorderLayout.EAST)
      }

}//class