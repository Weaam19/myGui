
import javax.swing.*;        
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities; /*to turn chart into jpg*/
import org.jfree.chart.ChartFactory; /* creates pie chart*/
import org.jfree.data.general.DefaultPieDataset; /*define the data for pie chart*/
import java.io.File;
import org.jfree.chart.ChartPanel;

class HelloWorldSwing  {
  int N1, N2; //global variables for button clickcs
  
  public void createAndShowGUI() {
    // create all the elements
    JFrame frame = new JFrame("HelloWorld");
    JLabel label = new JLabel("Hello World");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = getFileMenu(); //uses the method to create a menu
    JButton Button1 = new JButton("Button 1");
    JButton Button2 = new JButton("Button 2");
    JButton Button3 = new JButton("Save");
    JButton Button4 = new JButton("Update Chart");
    JTextField Input = new JTextField(20);
    JPanel Pane = new JPanel();
    JLabel L = new JLabel("Text:");
    
    N1=0; 
    N2=0;
    //actions for the buttons
    Button1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  N1++;
	  Input.setText("button 1 was clicked "+N1+" times");
	}
      });
    
    Button2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  N2++;
	  Input.setText("button 2 was clicked "+N2+" times");
	}
      });
    Button3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  try {
	    //Creating a file 
	    File file = new File("TextFIELD.txt");
	    BufferedWriter outfile = new BufferedWriter(new FileWriter(file,true));
	    outfile.write("It says: ");
	    String text = Input.getText();
	    outfile.write(text+System.getProperty("line.separator"));
	    outfile.close();	    
	  }
	  catch(FileNotFoundException l) {
	    Input.setText("File not found.");
	  }
	  catch(NullPointerException j){
	    Input.setText("Null.");
	  }
	  catch(IOException k){
	    Input.setText("IO Exception.");            
	  }
	  Input.setText("Saved");
	}
      });
    //create pie chart
    DefaultPieDataset PieChart = new DefaultPieDataset();
    PieChart.setValue("Button 1", N1);
    PieChart.setValue("Button 2", N2);
    JFreeChart chart=ChartFactory.createPieChart("Buttons clicked",PieChart,true,true,false);
    ChartPanel chartpanel = new ChartPanel(chart);
    //button 4 action

    Button4.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  PieChart.setValue("Button 1", N1);
	  PieChart.setValue("Button 2", N2);
	  chartpanel.repaint();
	}
      });
        
    
    menuBar.add(menu);
//positions of elements    
    Pane.setLayout(null);
    Pane.add(L);
    L.setLocation(10,10);
    L.setSize(50,20);
    
    Pane.add(Input);
    Input.setLocation(10,30);
    Input.setSize(230,20);
    
    Pane.add(Button1);
    Button1.setLocation(10,60);
    Button1.setSize(110,20);
    
    Pane.add(Button2);
    Button2.setLocation(130,60);
    Button2.setSize(110,20);
    
    Pane.add(Button3);
    Button3.setLocation(10,100);
    Button3.setSize(70,20);
    
    Pane.add(Button4);
    Button4.setLocation(100,100);
    Button4.setSize(140,20);
    
    Pane.add(chartpanel);
    chartpanel.setLocation(10,150);
    chartpanel.setSize(230,230);
    // add everything to the frame  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(50,50,250,420);
    frame.getContentPane().add(label);
    frame.getContentPane().add(menuBar);
    
    frame.getContentPane().add(Pane, BorderLayout.CENTER);
    frame.setJMenuBar(menuBar);
    frame.setVisible(true);  
  }
// mathod for creating a menu  
  private  JMenu getFileMenu() {
    JMenu myMenu = new JMenu("File");
    JMenuItem myItem = new JMenuItem("Open");
    myMenu.add(myItem);
    myItem = new JMenuItem("Close");
    myMenu.add(myItem);
    myMenu.addSeparator();
    myItem = new JMenuItem("Exit");
    myMenu.add(myItem);
    return myMenu;
  }
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    /* javax.swing.SwingUtilities.invokeLater(new Runnable() {
       public void run() {
       createAndShowGUI();
       }
       });*/
    (new HelloWorldSwing()).createAndShowGUI();
  }
}
// the comment inside main is a "proper" way to create class and execuete it. I used more simple one here since i don't really understand the purpose of the other one."
