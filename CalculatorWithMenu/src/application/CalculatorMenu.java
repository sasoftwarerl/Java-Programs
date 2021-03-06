package application;

/*
 *Objective:  A calculator application that utilizes the java GUI Libraries with 5 different layout options
 *and different look and feels. This Calculator utilizes the JMenu objects to change the look of the calculator.
 */

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CalculatorMenu {
	//Objects for the GUI
	private JFrame frame;
	private JTextField output; //The display used to show the result after an arithmetic operation
	private String holdString; //temporarily stores the operation and displays it to the user in the history label
	private Double result; //holds the final result after an arithmetic operation and is displayed on the JTextField output
	private String OperationType; //specifies the type of arithmetic operation indicated by a string
	private Boolean isDefaultZero; //a flag that checks if default value on output is zero, when any number btn is pressed switch value wit zero
	private DecimalFormat df; //assigns proper formatting of values outputted as decimal to the textfield
	private UIManager.LookAndFeelInfo looksNfeelType[]; // look and feels
	private ButtonGroup group; //groups all radio buttons for the look and feel
	private JLabel currOplbl; //a label that just holds text, this has no functional purpose
	private JButton sqrtBTN; //Square root button which performs the action of squaring a number
	private JButton powBTN; //Power button which performs the action of getting the power of a value
	private JButton modBTN; //Uses modulas symbol but button performs the action of getting the percentage of a value
	private JButton cancelBTN; //button that clears all data inputted
	private JButton divideBTN; //Division button which performs the action of dividing two numbers
	private JButton num0; // a button that prints 0 on textfield
	private JButton num1; // a button that prints 1 on textfield
	private JButton num2; // a button that prints 2 on textfield
	private JButton num3; // a button that prints 3 on textfield
	private JButton num4; // a button that prints 4 on textfield
	private JButton num5; // a button that prints 5 on textfield
	private JButton num6; // a button that prints 6 on textfield
	private JButton num7; // a button that prints 7 on textfield
	private JButton num8; // a button that prints 8 on textfield
	private JButton num9; // a button that prints 9 on textfield
	private JButton deciBTN; // a button that prints a period on textfield
	private JButton subtBTN; //Subtraction button which performs the action of subtracting two numbers
	private JButton addBTN; //Addition button which performs the action of adding two numbers
	private JButton multiplyBTN; //Multiplication button which performs the action of multiplying two numbers
	private JButton equalsBTN; //equals button validates the arthimetic expression the user has inputted in the calculator
	private int numero; //assigns JRadio by number type starting from 0
	private JMenuBar menuBar; //A the main menu for the calculator
	private JMenu mnNewMenu; // A Sub menu in the Main menu that contains Preference and Menu option Exit
	private JMenu mnPreference; //A Sub menu that holds the separate options menus and menuitems to change layout and look-and-feel 
	private JMenuItem mntmExit; //A menu item that exits the program
	private JMenu mnLayouts; //The layouts menu that assigns different layout options
	private JMenu mnLookFeel; //the look-and-feel menu that assigns different look-and-feels
	private JMenuItem mntmLayout; //JMenuitem under the layout Menu, mnLayouts, which sets the calculator to box layout
	private JMenuItem mntmLayout_1; //JMenuitem under the layout Menu, mnLayouts, which sets the calculator to flow layout
	private JMenuItem mntmLayout_2; //JMenuitem under the layout Menu, mnLayouts, which sets the calculator to absolute layout
	private JMenuItem mntmLayout_3; //JMenuitem under the layout Menu, mnLayouts, which sets the calculator to grid layout
	private JMenuItem mntmLayout_4; //JMenuitem under the layout Menu, mnLayouts, which sets the calculator to gridbag layout
	
	//Sets up box layout for calculator
	private void setBoxLayout() {
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 420);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setVisible(true);
		frame.validate();
	} //end method setBoxLayout
	
	//Sets up flow layout for calculator
	private void setFlowLayout() {
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 220);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.validate();
	}//end method setFlowLayout
	
	/*
	 * Sets up Absolute layout for calculator, 
	 * but since everything has to be precise, precise values were chosen for 
	 * the positioning of each object using setBounds
	*/
	private void setAbsolute() {
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 340);
		output.setBounds(10, 34, 364, 26);
		currOplbl.setBounds(10, 9, 364, 14);
		sqrtBTN.setBounds(10, 70, 80, 32);
		powBTN.setBounds(100, 70, 80, 32);
		modBTN.setBounds(192, 70, 80, 32);
		cancelBTN.setBounds(284, 70, 80, 32);
		divideBTN.setBounds(284, 113, 80, 32);
		num0.setBounds(100, 242, 80, 32);
		num1.setBounds(10, 199, 80, 32);
		num2.setBounds(100, 199, 80, 32);
		num3.setBounds(192, 199, 80, 32);
		num4.setBounds(10, 156, 80, 32);
		num5.setBounds(100, 156, 80, 32);
		num6.setBounds(192, 156, 80, 32);
		num7.setBounds(10, 113, 80, 32);
		num8.setBounds(100, 113, 80, 32);
		num9.setBounds(192, 113, 80, 32);
		deciBTN.setBounds(10, 242, 80, 32);
		subtBTN.setBounds(284, 199, 80, 32);
		addBTN.setBounds(284, 242, 80, 32);
		multiplyBTN.setBounds(284, 156, 80, 32);
		equalsBTN.setBounds(192, 242, 80, 32);
		frame.setVisible(true);
		frame.validate();
	}//end method setAbsolute
	
	//Sets up grid layout for calculator
	private void setGridLayout() {
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 420);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		frame.setVisible(true);
		frame.validate();	
	}//end method setGridLayout
	
	//Sets up gridbag layout for calculator
	private void setGridBagLayout() {
		frame.getContentPane().setLayout(null);	
		frame.getContentPane().removeAll();
		frame.setJMenuBar(null);
		initialize(); //initialize 
		frame.setVisible(true);
		frame.setBounds(100, 100, 374, 349);
		frame.validate();					
	}//end method setGridLayout
	
	/**
	 *  Main method to start the Java application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorMenu window = new CalculatorMenu(); //create the application
					window.frame.setVisible(true); //set the application to visible so it appears on screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end method main

	/**
	 * Constructor, Creates GUI
	 */
	public CalculatorMenu() {
		//initialize frame
		frame = new JFrame();
		frame.setBounds(100, 100, 374, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		isDefaultZero = true; //if user enters any value, it replaces it with zero
		
		//---------------------
		result = 0.00; //on start of application, the default value is 0
		OperationType = ""; //operation type should be defaulted on start since nothing is happening
		//this is used to prevent scientific notation results during arithmetic operations
		df = new DecimalFormat("#"); 
        df.setMaximumFractionDigits(8);
        looksNfeelType = UIManager.getInstalledLookAndFeels(); // get all installed look-and-feels
		initialize(); //setup GUI
     	
	}// end constructor

	/**
	 * Initialize frame and its components
	 */
	private void initialize() {
		
		//assign constraints for gridbaglayout of frame
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{102, 80, 84, 90, 0};
		gridBagLayout_1.rowHeights = new int[]{20, 24, 41, 40, 41, 40, 38, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout_1);
		
		//Menu Bar creation here
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//create Jmenus and place them in the JMenu bar menuBar
		mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
				
		mnPreference = new JMenu("Preference");
		mnNewMenu.add(mnPreference);
				
		mnLayouts = new JMenu("Layouts");
		mnPreference.add(mnLayouts);
		
		//menu item that assigns gridbag layout
		mntmLayout = new JMenuItem("GridBag Layout");
		mntmLayout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setGridBagLayout();
			}//end method actionPerformed
		});// end action listener
		mnLayouts.add(mntmLayout);
		
		//menu item that assigns flow layout
		mntmLayout_1 = new JMenuItem("Flow Layout");
		mntmLayout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  setFlowLayout();
			}//end method actionPerformed
		});// end action listener
		mnLayouts.add(mntmLayout_1);
		
		//menu item that assigns grid layout
		mntmLayout_2 = new JMenuItem("Grid Layout");
		mntmLayout_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGridLayout();
			}//end method actionPerformed
		});// end action listener
		mnLayouts.add(mntmLayout_2);
		
		//menu item that assigns absolute layout
		mntmLayout_3 = new JMenuItem("Absolute");
		mntmLayout_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	             setAbsolute();
			}//end method actionPerformed
		});// end action listener
		mnLayouts.add(mntmLayout_3);
		
		//menu item that assigns box layout
		mntmLayout_4 = new JMenuItem("BoxLayout");
		mntmLayout_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	     		setBoxLayout();
			}//end method actionPerformed
		});// end action listener
		mnLayouts.add(mntmLayout_4);
				
		mnLookFeel = new JMenu("Look & Feel"); //creates menu for Look and Feel
		mnPreference.add(mnLookFeel); //add look and feel menu to Main preference menu
		
		//This menu item exits the program
		mntmExit = new JMenuItem("Exit"); //create menu item with text Exit
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //exit program
			}
		});
		mnNewMenu.add(mntmExit); //place exit menu item on menu
		
		//Generate Look and feel JMenuItems on JMenu
		numero = 0; //assigns JMenuItem by number type starting from 0
		//loop through look-and-feel array and create JMenuItems corresponding to them 
		for(int i = 0; i < looksNfeelType.length;i++){
			//Sets up JMenut items to JMenu Look and Feel and assigns look and feel choices
			JMenuItem LFOpButton = new JMenuItem("L&F" + numero);
			LFOpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//if menu item is clicked apply look-and-feel based on number value
						setLookAndFeel(Integer.parseInt(LFOpButton.getText().substring(3))); 
				} //end method actionPerformed 
			});// end action listener
			mnLookFeel.add(LFOpButton); //Add JMenuItem to JMenu look and feel
			numero = numero+1;		
		}// end for loop which creates look-and-feel JRadioButtons
		
		
		//This label shows the current operation the user is doing, and is placed above the output textfield
		currOplbl = new JLabel("");
		currOplbl.setForeground(Color.GRAY);
		currOplbl.setHorizontalAlignment(SwingConstants.RIGHT);
		//assign constraints for gridbaglayout for operations label
		GridBagConstraints gbc_currOplbl = new GridBagConstraints();
		gbc_currOplbl.fill = GridBagConstraints.BOTH;
		gbc_currOplbl.insets = new Insets(0, 0, 5, 0);
		gbc_currOplbl.gridwidth = 4;
		gbc_currOplbl.gridx = 0;
		gbc_currOplbl.gridy = 0;
		
		
		//add all objects
		frame.getContentPane().add(currOplbl, gbc_currOplbl);
		
		//A displays that outputs the result after an operation is done by the user 
		output = new JTextField();
		output.setText("0");
		output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		output.setHorizontalAlignment(SwingConstants.RIGHT);
		//assign constraints for gridbaglayout for JTextfield output
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.fill = GridBagConstraints.BOTH;
		gbc_output.insets = new Insets(0, 0, 5, 0);
		gbc_output.gridwidth = 4;
		gbc_output.gridx = 0;
		gbc_output.gridy = 1;
		output.setColumns(10);
		frame.getContentPane().add(output, gbc_output);
		
		
		//Squares the value of the number inserted by the user stored in the jtextfield output
		 sqrtBTN = new JButton("Sqrt");
		 sqrtBTN.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
		 		holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
		 		currOplbl.setText(holdString);
		 		String SQR = "\u221A";//sqrt symbol
		 		currOplbl.setText(SQR + currOplbl.getText() + " ");
		 		result = Math.sqrt(result);
		 		output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
		 		OperationType = ""; //set operation type to nothing
		 	}// end method actionPerformed
		 });// end action listener
		 //assign constraints for gridbaglayout for square root button
		 GridBagConstraints gbc_sqrtBTN = new GridBagConstraints();
		 gbc_sqrtBTN.fill = GridBagConstraints.BOTH;
		 gbc_sqrtBTN.insets = new Insets(0, 0, 5, 5);
		 gbc_sqrtBTN.gridx = 0;
		 gbc_sqrtBTN.gridy = 2;
		 frame.getContentPane().add(sqrtBTN, gbc_sqrtBTN);
		 
			
		/*
		 * Sets operation type to power, and takes two inputs, one for the value, the other is inputted 
		* after to get the value of the power
		*/
		powBTN = new JButton("Pow");
		powBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " ^");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "pow"; //Operation type is set to pow, the code below does the actual calculation
			}// end method actionPerformed
		});//end action listener
		//assign constraints for gridbaglayout for power button
		GridBagConstraints gbc_powBTN = new GridBagConstraints();
		gbc_powBTN.fill = GridBagConstraints.BOTH;
		gbc_powBTN.insets = new Insets(0, 0, 5, 5);
		gbc_powBTN.gridx = 1;
		gbc_powBTN.gridy = 2;
		frame.getContentPane().add(powBTN, gbc_powBTN);
		
		/*
		 Example scenario of how the percent button does the calculation works:
		 It works similarly to the windows calculators percentage button.
			percent = 5% = 5/100
			
			scenario 1:
			500 * percent
			=500 * 5%
			=500 * 0.05 
			=25
			
			scenario 2:
			2 + 5% = 0.1 <=> 2 * 5% = 0.1
		 */
		modBTN = new JButton("%");
		modBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = result * (Double.parseDouble(output.getText()))/100; //get percentage of value in textfield, then convert to double for calculations
				output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
				OperationType = ""; //set operation type to nothing
				currOplbl.setText(""); 
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
			}// end method actionPerformed
		});
		//assign constraints for gridbaglayout for percentage button
		GridBagConstraints gbc_modBTN = new GridBagConstraints();
		gbc_modBTN.fill = GridBagConstraints.BOTH;
		gbc_modBTN.insets = new Insets(0, 0, 5, 5);
		gbc_modBTN.gridx = 2;
		gbc_modBTN.gridy = 2;
		frame.getContentPane().add(modBTN, gbc_modBTN);
		
		//Cancel or clears all operations and defaults all variables
		 cancelBTN = new JButton("C");
		 cancelBTN.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		//set calculator back to default state
		 		result = 0.00;
		 		holdString = "";
		 		currOplbl.setText("");
		 		output.setText("0");
		 		isDefaultZero = true;
		 		OperationType = "";
		 	}// end method actionPerformed
		 });//end actionlistener
		 //assign constraints for gridbaglayout for cancel button
		 GridBagConstraints gbc_cancelBTN = new GridBagConstraints();
		 gbc_cancelBTN.fill = GridBagConstraints.BOTH;
		 gbc_cancelBTN.insets = new Insets(0, 0, 5, 0);
		 gbc_cancelBTN.gridx = 3;
		 gbc_cancelBTN.gridy = 2;
		 frame.getContentPane().add(cancelBTN, gbc_cancelBTN);
		
				 
		/*
		* Sets operation type to divide, which takes two inputs, one after the other, one for the value,
		* the other is inputted after to divide with
		*/
		divideBTN = new JButton("/");
		divideBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " /");
				output.setText("0"); 
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "divi"; //Operation type is set to divide, the code below does the actual calculation
			}// end method actionPerformed
		});//end actionListener
		//assign constraints for gridbaglayout for divide button
		GridBagConstraints gbc_divideBTN = new GridBagConstraints();
		gbc_divideBTN.fill = GridBagConstraints.BOTH;
		gbc_divideBTN.insets = new Insets(0, 0, 5, 0);
		gbc_divideBTN.gridx = 3;
		gbc_divideBTN.gridy = 3;
		frame.getContentPane().add(divideBTN, gbc_divideBTN);
				 	 
	/*---------------------------------All Number Buttons----------------------------------------------------------- */	 	 
		//Button that outputs 0 to textfield
		 num0 = new JButton("0");
		 num0.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		output.setText(output.getText() + "0");
		 	}// end method actionPerformed
		 });//end actionListener
		 //assign constraints for gridbaglayout for number 0 button
		 GridBagConstraints gbc_num0 = new GridBagConstraints();
		 gbc_num0.fill = GridBagConstraints.BOTH;
		 gbc_num0.insets = new Insets(0, 0, 0, 5);
		 gbc_num0.gridx = 1;
		 gbc_num0.gridy = 6;
		 frame.getContentPane().add(num0, gbc_num0);
		 
		 	 	//Button that outputs 1 to textfield
		 	 	 num1 = new JButton("1");
		 	 	 num1.addActionListener(new ActionListener() {
		 	 	 	public void actionPerformed(ActionEvent arg0) {
		 	 	 		//if current value contains 0, replace it with this input
		 	 	 		if(isDefaultZero == true) 
		 	 	 		{
		 	 	 			output.setText("1");
		 	 	 			isDefaultZero = false;
		 	 	 		}
		 	 	 		else{
		 	 	 			output.setText(output.getText() + "1");
		 	 	 		}
		 	 	 	}// end method actionPerformed
		 	 	 });//end actionListener
		 	 	 //assign constraints for gridbaglayout for number 1 button
		 	 	 GridBagConstraints gbc_num1 = new GridBagConstraints();
		 	 	 gbc_num1.fill = GridBagConstraints.BOTH;
		 	 	 gbc_num1.insets = new Insets(0, 0, 5, 5);
		 	 	 gbc_num1.gridx = 0;
		 	 	 gbc_num1.gridy = 5;
		 	 	 frame.getContentPane().add(num1, gbc_num1);
		 	 	 
				 //Button that outputs 2 to textfield
			 	 num2 = new JButton("2");
			 	 num2.addActionListener(new ActionListener() {
			 	 	public void actionPerformed(ActionEvent arg0) {
			 	 		//if current value contains 0, replace it with this input
			 	 		if(isDefaultZero == true)
			 	 		{
			 	 			output.setText("2");
			 	 			isDefaultZero = false;
			 	 		}
			 	 		else{
			 	 			output.setText(output.getText() + "2");
			 	 		}// end method actionPerformed
			 	 	}// end method actionPerformed
			 	 });//end actionListener		 	 	 
		 	 //assign constraints for gridbaglayout for number 2 button
		 	 GridBagConstraints gbc_num2 = new GridBagConstraints();
		 	 gbc_num2.fill = GridBagConstraints.BOTH;
		 	 gbc_num2.insets = new Insets(0, 0, 5, 5);
		 	 gbc_num2.gridx = 1;
		 	 gbc_num2.gridy = 5;
		 	 frame.getContentPane().add(num2, gbc_num2);
		 	 
				//Button that outputs 3 to textfield
			 num3 = new JButton("3");
			 num3.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		//if current value contains 0, replace it with this input
			 		if(isDefaultZero == true)
			 		{
			 			output.setText("3");
			 			isDefaultZero = false;
			 		}
			 		else{
			 			output.setText(output.getText() + "3");
			 		}
			 	}// end method actionPerformed
			 });//end actionListener		 	 
		 //assign constraints for gridbaglayout for number 7 button
		 GridBagConstraints gbc_num3 = new GridBagConstraints();
		 gbc_num3.fill = GridBagConstraints.BOTH;
		 gbc_num3.insets = new Insets(0, 0, 5, 5);
		 gbc_num3.gridx = 2;
		 gbc_num3.gridy = 5;
		 frame.getContentPane().add(num3, gbc_num3);
		 
			 	 		//Button that outputs 4 to textfield
			 	 		 num4 = new JButton("4");
			 	 		 num4.addActionListener(new ActionListener() {
			 	 		 	public void actionPerformed(ActionEvent arg0) {
			 	 		 		//if current value contains 0, replace it with this input
			 	 		 		if(isDefaultZero == true)
			 	 		 		{
			 	 		 			output.setText("4");
			 	 		 			isDefaultZero = false;
			 	 		 		}
			 	 		 		else{
			 	 		 			output.setText(output.getText() + "4");
			 	 		 		}
			 	 		 	}// end method actionPerformed
			 	 		 });//end actionListener
			 	 		 //assign constraints for gridbaglayout for number 4 button
			 	 		 GridBagConstraints gbc_num4 = new GridBagConstraints();
			 	 		 gbc_num4.fill = GridBagConstraints.BOTH;
			 	 		 gbc_num4.insets = new Insets(0, 0, 5, 5);
			 	 		 gbc_num4.gridx = 0;
			 	 		 gbc_num4.gridy = 4;
			 	 		 frame.getContentPane().add(num4, gbc_num4);
			 	 		 
			 	 	 	//Button that outputs 5 to textfield
					 	 num5 = new JButton("5");
					 	 num5.addActionListener(new ActionListener() {
					 	 	public void actionPerformed(ActionEvent arg0) {
					 	 		//if current value contains 0, replace it with this input
					 	 		if(isDefaultZero == true)
					 	 		{
					 	 			output.setText("5");
					 	 			isDefaultZero = false;
					 	 		}
					 	 		else{
					 	 			output.setText(output.getText() + "5");
					 	 		}
					 	 	}// end method actionPerformed
					 	 });//end actionListener 
			 	 //assign constraints for gridbaglayout for number 5 button
			 	 GridBagConstraints gbc_num5 = new GridBagConstraints();
			 	 gbc_num5.fill = GridBagConstraints.BOTH;
			 	 gbc_num5.insets = new Insets(0, 0, 5, 5);
			 	 gbc_num5.gridx = 1;
			 	 gbc_num5.gridy = 4;
			 	 frame.getContentPane().add(num5, gbc_num5);
			 
			 	//Button that outputs 6 to textfield
				 num6 = new JButton("6");
				 num6.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent arg0) {
				 		//if current value contains 0, replace it with this input
				 		if(isDefaultZero == true)
				 		{
				 			output.setText("6");
				 			isDefaultZero = false;
				 		}
				 		else{
				 			output.setText(output.getText() + "6");
				 		}
				 	}// end method actionPerformed
				 });//end actionListener
			 //assign constraints for gridbaglayout for number 6 button
			 GridBagConstraints gbc_num6 = new GridBagConstraints();
			 gbc_num6.fill = GridBagConstraints.BOTH;
			 gbc_num6.insets = new Insets(0, 0, 5, 5);
			 gbc_num6.gridx = 2;
			 gbc_num6.gridy = 4;
			 frame.getContentPane().add(num6, gbc_num6);
			 
			 
			  //Button that outputs 7 to textfield
			  num7 = new JButton("7");
			  num7.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent arg0) {
			  		//if current value contains 0, replace it with this input
			  		if(isDefaultZero == true)
			  		{
			  			output.setText("7");
			  			isDefaultZero = false;
			  		}
			  		else{
			  			output.setText(output.getText() + "7");
			  		}
			  	}// end method actionPerformed
			  });// end action listener
			  //assign constraints for gridbaglayout of number 7 button
			  GridBagConstraints gbc_num7 = new GridBagConstraints();
			  gbc_num7.fill = GridBagConstraints.BOTH;
			  gbc_num7.insets = new Insets(0, 0, 5, 5);
			  gbc_num7.gridx = 0;
			  gbc_num7.gridy = 3;
			  frame.getContentPane().add(num7, gbc_num7);
			 
			 //Button that outputs 8 to textfield
			  num8 = new JButton("8");
			  num8.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent arg0) {
			  		//if current value contains 0, replace it with this input
			  		if(isDefaultZero == true)
			  		{
			  			output.setText("8");
			  			isDefaultZero = false;
			  		}
			  		else{
			  			output.setText(output.getText() + "8");
			  		}
			  	}// end method actionPerformed
			  });//end actionListener
			  //assign constraints for gridbaglayout for number 8 button
			  GridBagConstraints gbc_num8 = new GridBagConstraints();
			  gbc_num8.fill = GridBagConstraints.BOTH;
			  gbc_num8.insets = new Insets(0, 0, 5, 5);
			  gbc_num8.gridx = 1;
			  gbc_num8.gridy = 3;
			  frame.getContentPane().add(num8, gbc_num8);
			
				//Button that outputs 9 to textfield
				 num9 = new JButton("9");
				 num9.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent arg0) {
				 		//if current value contains 0, replace it with this input
				 		if(isDefaultZero == true)
				 		{
				 			output.setText("9");
				 			isDefaultZero = false;
				 		}
				 		else{
				 			output.setText(output.getText() + "9");
				 		}
				 	}// end method actionPerformed
				 });//end actionListener
				 //assign constraints for gridbaglayout for number 9 button
				 GridBagConstraints gbc_num9 = new GridBagConstraints();
				 gbc_num9.fill = GridBagConstraints.BOTH;
				 gbc_num9.insets = new Insets(0, 0, 5, 5);
				 gbc_num9.gridx = 2;
				 gbc_num9.gridy = 3;
				 frame.getContentPane().add(num9, gbc_num9);
	/*---------------------------------All Number Buttons----------------------------------------------------------- */	 
				
		/*
		* Sets operation type to multiplication, which takes two inputs one after the other, one for the value, 
		* the other is inputted after to subtract with
		*/
		multiplyBTN = new JButton("*");
		multiplyBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText());  //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " *");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "multi";  //Operation type is set to multiply, the code below does the actual calculation
			}// end method actionPerformed
		});//end actionListener
		//assign constraints for gridbaglayout for multiplication button
		GridBagConstraints gbc_multiplyBTN = new GridBagConstraints();
		gbc_multiplyBTN.fill = GridBagConstraints.BOTH;
		gbc_multiplyBTN.insets = new Insets(0, 0, 5, 0);
		gbc_multiplyBTN.gridx = 3;
		gbc_multiplyBTN.gridy = 4;
		frame.getContentPane().add(multiplyBTN, gbc_multiplyBTN);
		
		/*
		 * Sets operation type to subtraction, which takes two inputs one after the other, one for the value, 
		 * the other is inputted after to subtract with
		*/
		subtBTN = new JButton("-");
		subtBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText(); //hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " -");
				output.setText("0");
				isDefaultZero = true;//Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "sub"; //Operation type is set to subtract, the code below does the actual calculation
			}// end method actionPerformed
		});			
		//assign constraints for gridbaglayout of subtract button
		GridBagConstraints gbc_subtBTN = new GridBagConstraints();
		gbc_subtBTN.fill = GridBagConstraints.BOTH;
		gbc_subtBTN.insets = new Insets(0, 0, 5, 0);
		gbc_subtBTN.gridx = 3;
		gbc_subtBTN.gridy = 5;
		frame.getContentPane().add(subtBTN, gbc_subtBTN);
		
		/*
		 * Sets operation type to addition, which takes two inputs one after the other, one for the value, 
		 * the other is inputted after to subtract with
		*/		
		addBTN = new JButton("+");
		addBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(output.getText()); //convert number in textfield to double for calculations
				holdString = output.getText();//hold current input and show it in current operations label, currOPlbl
				currOplbl.setText(holdString);
				currOplbl.setText(currOplbl.getText() + " +");
				output.setText("0");
				isDefaultZero = true; //Default back to 0 so user can input any num value to replace it, including 0
				OperationType = "add"; //Operation type is set to add, the code below does the actual calculation
			}// end method actionPerformed
		});//end actionListener
		//assign constraints for gridbaglayout for addition button
				GridBagConstraints gbc_addBTN = new GridBagConstraints();
				gbc_addBTN.fill = GridBagConstraints.BOTH;
				gbc_addBTN.gridx = 3;
				gbc_addBTN.gridy = 6;
				frame.getContentPane().add(addBTN, gbc_addBTN);
				
				//Most arithmitic operations are done here, then outputted on JTextfield output based on the operation type
				equalsBTN = new JButton("=");
				equalsBTN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//If operation type is addition, add value from result then output it
						if(OperationType.equals("add")){
							//df.format allows us to prevent outputting scientific notation
							result = result + Double.parseDouble(output.getText());
							output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
							OperationType = "";
							currOplbl.setText("");
							isDefaultZero = true;
						}
						//If operation type is subtraction, subtract value from result then output it
						else if(OperationType.equals("sub")){
							result = result - Double.parseDouble(output.getText());
							output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
							OperationType = "";
							currOplbl.setText("");
							isDefaultZero = true;
						}
						//If operation type is multiplication, multiply value from result then output it
						else if(OperationType.equals("multi")){
							result = result * Double.parseDouble(output.getText());
							output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
							OperationType = "";
							currOplbl.setText("");
							isDefaultZero = true;
						}
						//If operation type is division, divide value from result then output it
						else if(OperationType.equals("divi")){
							result = result / Double.parseDouble(output.getText());
							output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
							OperationType = "";
							currOplbl.setText("");
							isDefaultZero = true;
						}
						//If operation type is power, output power of a value based on the input from the user
						else if(OperationType.equals("pow")){
							result = Math.pow(result, Double.parseDouble(output.getText()));
							output.setText(String.valueOf(df.format(result))); //convert double back to string and show result
							OperationType = "";
							currOplbl.setText("");
							isDefaultZero = true;
						}
					}// end method actionPerformed
				});//end actionListener
				//assign constraints for gridbaglayout for equals button
				GridBagConstraints gbc_equalsBTN = new GridBagConstraints();
				gbc_equalsBTN.fill = GridBagConstraints.BOTH;
				gbc_equalsBTN.insets = new Insets(0, 0, 0, 5);
				gbc_equalsBTN.gridx = 2;
				gbc_equalsBTN.gridy = 6;
				frame.getContentPane().add(equalsBTN, gbc_equalsBTN);
						 
						 	//Button that outputs . to textfield, but only one can inputted to prevent awkward number typing
						 	 deciBTN = new JButton(".");
						 	 deciBTN.addActionListener(new ActionListener() {
						 	 	public void actionPerformed(ActionEvent e) {
						 	 		//if a . does not showing up in the output text (from previous arithmetic operations), then user can input a .
						 	 		if(!output.getText().contains(".")){
						 	 			output.setText(output.getText() + ".");
						 	 			isDefaultZero = false;
						 	 		}// end method actionPerformed
						 	 	}// end method actionPerformed
						 	 });//end actionListener
						 	 //assign constraints for gridbaglayout for . button
						 	 GridBagConstraints gbc_deciBTN = new GridBagConstraints();
						 	 gbc_deciBTN.fill = GridBagConstraints.BOTH;
						 	 gbc_deciBTN.insets = new Insets(0, 0, 0, 5);
						 	 gbc_deciBTN.gridx = 0;
						 	 gbc_deciBTN.gridy = 6;
						 	 frame.getContentPane().add(deciBTN, gbc_deciBTN);
				
	}// end method initialize
	
	// Assign the Look and Feel of the GUI
	private void setLookAndFeel(int value)
	{
		try 
		{
			// set look and feel 
			UIManager.setLookAndFeel( looksNfeelType[value].getClassName() );
						 
			// update all the components after setting look and feel
			SwingUtilities.updateComponentTreeUI( frame );
						
		} // end try
		catch ( Exception exception )
		{
			JOptionPane.showMessageDialog(frame, "Look and feel " + (value+1) + " is not available.","Error", JOptionPane.ERROR_MESSAGE);
			//exception.printStackTrace();
			group.clearSelection(); //if L&F is not found, clear selection to avoid repeating errors
						
		} // end catch
	} // end method setLookAndFeel
}// end class Calculator
