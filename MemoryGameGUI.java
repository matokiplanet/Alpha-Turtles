import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.awt.Font; 
public class MemoryGameGUI extends JFrame implements ActionListener{
       
   private final int WINDOW_WIDTH = 800;  // Window width
   private final int WINDOW_HEIGHT = 800; // Window height
   private int rows= 4;
   private int cols = 4; 
   private JButton [] doors  = new JButton[16];
   public  MemoryGameModel mg;
   private String filler = "   "; 
   private JLabel result; 

  
   public MemoryGameGUI(){
      /*****************whole frame set up BorderLayout****************/
      // Set the window title, ize and close behavious
      setTitle("Memory Game");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set layout and borders 
      setLayout(new BorderLayout());
      JLabel banner = new JLabel("Let's get ready to play a Memory Game!");
      add(banner,BorderLayout.NORTH); 
      add(new JLabel(filler),BorderLayout.EAST);
      add(new JLabel(filler),BorderLayout.WEST);
      result = new JLabel(filler);  
      add(result,BorderLayout.SOUTH);
   
      mg = new MemoryGameModel(); 
      rows = mg.getRows(); 
      cols = mg.getCols();
      
      /**********detailed set up of the Panel (GridLayot)************/               
      Panel pDoors = new Panel();
      pDoors.setLayout(new GridLayout(rows,cols)); 
      ImageIcon coverimage = new ImageIcon("watermelon.jpg");
      for(int i=0;i<16;i++){
         String doorNumber = i+1+""; 
         doors[i] = new JButton(coverimage);  
         doors[i].setFont(new Font("Comic Sans", Font.ITALIC, 32));
         doors[i].addActionListener(this);
         pDoors.add(doors[i]);  
      }  
      add(pDoors,BorderLayout.CENTER); 
         
      setVisible(true);
   }
   
   
   
   public void actionPerformed(ActionEvent ae){
   
      JButton source = (JButton)ae.getSource();
   
   //Find out which button was pushed
      int i=0;
      while(source != doors[i])
         i++;
     //take turns
      mg.takeTurn(i);
      source.setIcon(mg.get(i));

   //check match Nikki Zhang and McKenzie Lewis 
   
   //if first time flipping 
      if(mg.numberOfAttempts==1){
         
         doors[i].setIcon(mg.get(i));
      }//if
   
   // if match (new image appears) 
      if(mg.getMatch() == true && mg.numberOfAttempts>1 && mg.numberOfAttempts%2.0==0){
         
         doors[i].setIcon(mg.get(i));
         doors[i].removeActionListener(this);
                
      }//if
          
      // if false (odd number first half turn)
      if(mg.getMatch() == false && mg.numberOfAttempts>1 && mg.numberOfAttempts%2.0==1){
         
         doors[i].setIcon(mg.coverimage);
        
      }//if
   
   //if false (flip back)
      if(mg.getMatch() == false && mg.numberOfAttempts>1 && mg.numberOfAttempts%2.0==0 ){
         doors[i].setIcon(mg.coverimage);
      }//if
   
         
      result.setText(mg.reportWinner());
     
   
 }// main
 
 
} //
