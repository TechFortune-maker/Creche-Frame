
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.tut.creche.Child;


public class CrecheGUI extends JFrame{
      
    //panels 
    private JPanel namePn1;
    private JPanel genderPn1;
    private JPanel nameAndGenderCombinedPn1;
    private JPanel textCommentsPn1;
    private JPanel buttonsAndDetailsCombined;
    private JPanel buttonsPn1;
    private JPanel mainPn1;
    
    
    //Labels 
    private JLabel nameLb1;
    private JLabel genderLb1;
    
    
    //Text fields
    private JTextField nameTextFld;
    
    //Text Area
    private JTextArea textArea;
    
    //Scroll Pane
    private JScrollPane scrollPane;
    //Radion buttons 
    
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    
    //Buttons 
    
    private JButton registerKiddie;
    private JButton displayKiddies;
    
    //Create a button group 
    
    private ButtonGroup buttonGrp;
    
    //create a list
    private ArrayList<Child> childs;

    
    public CrecheGUI() {
        
        setTitle("CRECHE 4 YOUR KIDDIE");
        setSize(400,450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create a list for childs
        childs = new ArrayList<>();
        
        
        //Create panels 
        namePn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameAndGenderCombinedPn1 = new JPanel(new BorderLayout());

        buttonsPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textCommentsPn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsAndDetailsCombined = new JPanel(new BorderLayout());

        mainPn1 = new JPanel(new BorderLayout());

        //Create labels 
        nameLb1 = new JLabel("Name: ");
        genderLb1 = new JLabel("Gender: ");
        
        
        //Create text field 
        nameTextFld = new JTextField(15);
      
        
        //Create Radio buttons 
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        
        //Add those button to a button group 
        
        buttonGrp = new ButtonGroup();
        
        buttonGrp.add(maleButton);
        buttonGrp.add(femaleButton);
        
        //Create Buttons 
        
        registerKiddie = new JButton("Register Kiddie");
        registerKiddie.addActionListener(new RegisterKiddiesBtnListener());
        
        displayKiddies = new JButton("Display Kiddies");
        displayKiddies.addActionListener(new DisplayAllKiddiesBtnListener());
        
        //Create Text Area
        
        textArea = new JTextArea(15,35);
        textArea.setEditable(false);
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //add components to the panel 
        namePn1.add(nameLb1);
        namePn1.add(nameTextFld);
        
        genderPn1.add(genderLb1);
        genderPn1.add(maleButton);
        genderPn1.add(femaleButton);

        buttonsPn1.add(registerKiddie);
        buttonsPn1.add(displayKiddies);
        
        textCommentsPn1.add(scrollPane);
        
        nameAndGenderCombinedPn1.add(namePn1, BorderLayout.NORTH);
        nameAndGenderCombinedPn1.add(genderPn1, BorderLayout.CENTER);
        
        buttonsAndDetailsCombined.add(nameAndGenderCombinedPn1, BorderLayout.NORTH);
        buttonsAndDetailsCombined.add(buttonsPn1, BorderLayout.CENTER);
        

        mainPn1.add(buttonsAndDetailsCombined, BorderLayout.NORTH);
        mainPn1.add(textCommentsPn1, BorderLayout.CENTER);
        
        add(mainPn1);
        pack();
        
        setVisible(true);

    }
    private class RegisterKiddiesBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          //read data
          
          String name = nameTextFld.getText();
          String gender = "Male";
           
          if(femaleButton.isSelected()){
             gender = "Female";
          }
          
  
         // create a child
        
           Child child = new Child(name,gender);
           childs.add(child);
           
           //add confirmation message to the text area
           textArea.setText("The kid has successfully added");
           
           //clear all text fields 
           nameTextFld.setText("");
           buttonGrp.clearSelection();
           
           //set focus back to the name text field
           nameTextFld.setFocusable(true);
           
        }

    }
    private class DisplayAllKiddiesBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //clear the text before displaying a new content
            textArea.setText("");
            
            for (int i = 0; i < childs.size(); i++) {
                  
                 textArea.append(childs.get(i) + "\n");
            }
 
        }

    }

}
