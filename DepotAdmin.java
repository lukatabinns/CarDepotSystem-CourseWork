import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DepotAdmin 
{
    private Date date;
    private Depot depoVehicle;
    
    private void setupDepot(){
       depoVehicle = new Depot("null","null","null","null", new Fuel("null"),0);
       Vehicle V2 = depoVehicle;
       depoVehicle.addVehicle(new Car("BobMart","567890","Volvo","04/06/2014", new Fuel("diesel"),6000));
       depoVehicle.addVehicle(new Car("BobMart","988754","Fiat","15/08/2015", new Fuel("diesel"),6000));
       depoVehicle.addVehicle(new Car("BobMart","465783","BMW","12/052014", new Fuel ("petrol"), 8000));
       depoVehicle.addVehicle(new Car("BobMart","348709","Ford","13/08/2014",new Fuel ("petrol"), 3000));
       depoVehicle.addVehicle(new Car("BobMart","145367","Lexus","18/08/2015",new Fuel ("diesel"), 2000));
       
    }
               
    private JFrame Depot;
    private JMenu Vehicles;
    private JMenu searchVehicle;    
    private JMenu rentVehicle;    
    private JMenu returnVehicle;
    private JMenuItem vehicles1;
    private JMenuItem searchVehicle1;
    private JMenuItem rentVehicle1;
    private JMenuItem returnVehicle1; 
    private JTextArea textArea;
    private JMenuBar menubar;
    private JList vList;
    private vehicles1 listener;
    private searchVehicles1 listener1;
    private rentVehicles1 listener2;
    private returnVehicles1 listener3;
    private JLabel repeatLabel;
    private JTextField inputText;
    private JPanel textPanel;
    public DepotAdmin(){
    //creating the frame to place the menu bar
    Depot = new JFrame ("Depot");
    //creating the menubar to place the menu items
    menubar = new JMenuBar();
    //set the menu bar in the frame
    Depot.setJMenuBar(menubar);
    //set the menus on the menu bar
    Vehicles = new JMenu ("vehicles");
    menubar.add(Vehicles);
    searchVehicle = new JMenu ("search");
    menubar.add(searchVehicle);
    rentVehicle = new JMenu ("rent");
    menubar.add(rentVehicle);
    returnVehicle = new JMenu ("return");
    menubar.add(returnVehicle);
    //set the menu items on the menues
    vehicles1 = new JMenuItem ("Vehicle List");
    Vehicles.add(vehicles1);
    searchVehicle1 = new JMenuItem ("Search Vehicle");
    searchVehicle.add(searchVehicle1);
    rentVehicle1 = new JMenuItem ("Rent Vehicle");
    rentVehicle.add(rentVehicle1);
    returnVehicle1 = new JMenuItem ("Return Vehicle");
    returnVehicle.add(returnVehicle1);
    //data display section
    textArea = new JTextArea(70,70);
    textPanel = new JPanel();
    //add textarea to panel
    textPanel.add(textArea);
    textPanel.setBackground(Color.blue);
    //add panel to frame
    Depot.add((textPanel),BorderLayout.CENTER);
    //listeners to respond to click by user
    listener = new vehicles1();
    listener1 = new searchVehicles1();
    listener2 = new rentVehicles1();
    listener3 = new returnVehicles1();
    vehicles1.addActionListener(listener);
    searchVehicle1.addActionListener(listener1);
    rentVehicle1.addActionListener(listener2);
    returnVehicle1.addActionListener(listener3);
    //set the size of the frame
    Depot.setSize(600,600);
    Depot.setLocationRelativeTo(null);
    //set the visibility of the frame
    Depot.setVisible(true);
    //prevent the running the the program on exit
    Depot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setupDepot(); 
    
   }
    
    public class vehicles1 implements ActionListener{

        public void actionPerformed(ActionEvent e){
                                                                                                 
                     if ( e.getSource() == vehicles1){
                     textArea.append(depoVehicle.toString()+"\n"+"\n");
                              
                     }
                     
        }
     
    }
    
           
    public class searchVehicles1 implements ActionListener{

        public void actionPerformed(ActionEvent e){
                            
                        Vehicle v = null;
                        String make = JOptionPane.showInputDialog(null,"Enter vehicle make");
                  if (e.getSource()==searchVehicle1)
                  {
                     for( int i = 0; i < depoVehicle.vehicleNumbers(); i++ )
                     {
                         v = depoVehicle.getVehicle(i);
                           if(v.getMake().equals(make))
                           {
                             textArea.append(v.toString()+"\n");
                           }
                       
                       }          
                  }
                     
           }   

    }
    
    
    public class rentVehicles1 implements ActionListener{

        public void actionPerformed(ActionEvent e){
        
                        Date date = new Date();
                        String r = "ReturnDate";
                        String code = JOptionPane.showInputDialog(null,"Enter vehicle code");
                        Vehicle v = null;
                  if (e.getSource()==rentVehicle1)
                  {
                     for( int i = 0; i < depoVehicle.vehicleNumbers(); i++ )
                      {
                         v = depoVehicle.getVehicle(i);
                            if(v.getCode().equals(code))
                            {
                             textArea.append(v.toString()+ r + ": "+ date.toString()+"\n"+"\n");
                            }
                        
                      }          
                 }  
           }
    }
    
    public class returnVehicles1 implements ActionListener{


        public void actionPerformed(ActionEvent e){
        
                        Date date = new Date();
                        String back = "Vehicle has returned successfully";
                        String r = "ReturnDate";
                        String code = JOptionPane.showInputDialog(null,"Enter vehicle code");
                        Vehicle v = null;
                    if (e.getSource()==returnVehicle1)
                    {
                       for( int i = 0; i < depoVehicle.vehicleNumbers(); i++ )
                       {
                         v = depoVehicle.getVehicle(i);
                             if(v.getCode().equals(code))
                             {
                             textArea.append(v.toString()+ r + ": "+ date.toString()+" " + back + "\n");
                             }
                       
                       }          
                   }
           
           }
    }
    
}
