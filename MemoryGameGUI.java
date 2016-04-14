import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.awt.Font; 
public class MemoryGameGUI extends JFrame implements ActionListener{
       
   private final int WINDOW_WIDTH = 410;  // Window width
   private final int WINDOW_HEIGHT = 410; // Window height
   private int rows=2;
   private int cols = 2; 
   private JButton [] doors  = new JButton[4];
   //private  MemoryGame;
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
   
      //MemoryGame mg = new MemoryGame(); 
      //rows = MemoryGame.getRows(); 
      //cols = MemoryGame.getCols();
      
      /**********detailed set up of the Panel (GridLayot)************/               
      Panel pDoors = new Panel();
      pDoors.setLayout(new GridLayout(rows,cols)); 
      ImageIcon coverimage = new ImageIcon("watermelon.jpg");
      for(int i=0;i<4;i++){
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
  /*int i=0
  while(source != doors[i])
      i++;
      */
  //first half of turn   
  mg.takeTurn(0);
  source.setImage(mg.get(0));
  //second half of turn 
  mg.takeTurn(1);
  source.setImage(mg.get(1));
  
  //if(mg.getMatch())
  
  //doors[i].setIcon(dealGame.get(i));
  //result.setText(dealGame.reportWinner());
   
   }// main
 
} // 
