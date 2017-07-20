import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class worldbank extends JFrame{
	JLabel label1;
	JTextField textfield1,textfield2,textfield3,textfield4,textfield5,
	textfield6,textfield7,textfield8,textfield9,textfield10;
	JButton button1,button2,button3;
	JTextArea textarea1,textarea2,textarea3;
	JPanel panel1,panel2,panel3;
	JScrollPane scroll;
	
	double svalue1,svalue3;
	
	public worldbank(){
		super("Prevent Flood, Save Sea Water");
		JTabbedPane pane=new JTabbedPane();
		panel1=new JPanel();
		Box box=Box.createVerticalBox();
		
		box.add(panel1);
		
		panel1.setBackground(Color.CYAN);
		
		
		
		textfield3=new JTextField("Enter the carbon(iv)oxide value in kt");
		textfield3.setEditable(false);
		panel1.add(textfield3);
		textfield4=new JTextField("0",10);
		panel1.add(textfield4);
		String note="Note:\n Enter the carbon(iv)oxide value based on\n the number of day(s) you wish to calculate.";
		textarea1=new JTextArea(note);
		textarea1.setEditable(false);
		panel1.add(textarea1);
		button1=new JButton("Calculate sea level rise");
		button1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						
							
						
						if(event.getSource()==button1){
							try{
								final double value1=0.005;
								final double value2=2.55;
							String number1=textfield4.getText();
							double num1=Double.parseDouble(number1);
							double svalue=num1*value1;
							svalue1=svalue/value2;
							}catch(NumberFormatException e){}
							
							textfield5.setText(String.format(""+svalue1));
							
						}
					}
				}
		
		);
		panel1.add(button1);
		
		textfield5=new JTextField("0",15);
		textfield5.setEditable(false);
		panel1.add(textfield5);
		textfield6=new JTextField("Enter the depth of the sea in millimetres(mm)");
		textfield6.setEditable(false);
		panel1.add(textfield6);
		textfield7=new JTextField(10);
		panel1.add(textfield7);
		textfield8=new JTextField("Enter the volume of the sea in cubic kilometres(km3)");
		textfield8.setEditable(false);
		panel1.add(textfield8);
		textfield9=new JTextField(20);
		panel1.add(textfield9);
		label1=new JLabel("Click on this button to calculate the amount of water to be drained");
		panel1.add(label1);
		button3=new JButton("Volume to be drained");
		button3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						if(event.getSource()==button3){
							try{
								String number4=textfield5.getText();
								double num4=Double.parseDouble(number4);
								String number2=textfield9.getText();
								double num2=Double.parseDouble(number2);
								double svalue2=num4*num2;
								String number3=textfield7.getText();
								double num3=Double.parseDouble(number3);
								svalue3=svalue2/num3;
							}catch(NumberFormatException ee){}
							textfield10.setText(String.format(""+svalue3+"km3"));
						}
					}
				}
		);
		panel1.add(button3);
		textfield10=new JTextField(20);
		textfield10.setEditable(false);
		panel1.add(textfield10);
		
		//Second panel
		
		panel2=new JPanel();
		panel2.setBackground(Color.CYAN);
		
		String about=
				"High concentration of carbon(IV)oxide in the atmosphere causes global warming which causes higher temperatures\n" +
				"in the atmosphere that leads to irregular rainfall and rise in sea level.Rise in sea level can lead to flooding\n" +
				"especially in developing countries. However,we can prevent/reduce flooding by predicting the level of sea rise\n" +
				"based on the value of carbon(IV)oxide for a period of time. The level of carbon(IV)oxide correlates according to\n" +
				"research findings, with the level of sea rise. This app prompts the user to drain\n" +
				"off  excess sea water (which can be treated and used for agriculture or other purposes) in order to prevent\n" +
				"floodiing that may result from this projected excess water flowing out of its banks.\n\n" +
				"The level of sea rise is calculated based on the Carbon(IV)oxide values gotten from the WorldBank datasets.\n" +
				"Carbon(IV)oxide values of 2007 and 2008 from 33 African countries was used. According to Wikipedia, sea level rises\n" +
				"globally at a rate of 1.7+/-0.3mm over 1950 to 2009. This fact is also used in calculating the projected sea rise level.\n" +
				"In order to calculate the voulme of sea water to be drained, the volume as well as the depth of sea is needed\n" +
				"and thus, the user is requested to enter these values in the spaces allocated for them.\n" +
				"Click on the EXIT button to leave this app.    ";
		
		textarea2=new JTextArea(about);
		textarea2.setEditable(false);
		panel2.add(textarea2);
		
		button2=new JButton("EXIT");
		button2.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent event){
							if(event.getSource()==button2){
								System.exit(0);
							}
						}
					}
		
		);
		panel2.add(button2);
		
		panel3=new JPanel();
		String message=
				"This app calculates the projected sea level rise and thus the volume of sea water to be\n" +
				"to be drained. You are required to enter the value of carbon(iv)oxide (kt) estimated and also,\n" +
				"the volume and depth of the sea. However, the values of the volume and depth of sea should\n" +
				"be constant i.e., it should be the 'original' volume and depth of the sea. For instance, if\n" +
				"you wish to calculate the sea level rise and thus volume of sea water to be drained from \n" +
				"the Gulf sea, you should enter the values of the depth and volume of this sea based on\n" +
				"last measurement. In essence, you are not required to measure the depth and volume of the\n" +
				"sea each time you wish to use this app. Just enter the previous measurements.\n" +
				"In the first editable textfield, you are required to enter the value of carbon(iv)oxide\n" +
				"which should be calculated based on the atmosphere surrounding the sea. Then click on\n" +
				"'Calculate sea level' button to calculate the sea rise level. The value which in mm, is\n" +
				"shown in the first textfield at the second line. To determine to the volume of sea water to\n" +
				"drain, you should enter the volume and depth of the sea and click on the 'Volume to be drained'\n" +
				"button to get the volume of sea water to be drained.     " ;
		textarea3=new JTextArea(message);
		scroll=new JScrollPane(textarea3);
		panel3.add(scroll);
		pane.addTab("Main Tab",null,panel1,null);
		pane.addTab("About",null,panel2,null);
		pane.addTab("How To Use",null,panel3,null);
		add(pane);
		
	}

}
public class $test1 extends JFrame{



		public static void main(String []args){
			worldbank my_test=new worldbank();
			
			my_test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			my_test.setSize(800,400);
			my_test.setVisible(true);
			