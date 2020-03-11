package blastGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MiPanel extends JPanel {
	/*
	private JLabel labelUsername = new JLabel("Enter username: ");
	private JLabel labelPassword = new JLabel("Enter password: ");
	private JTextField textUsername = new JTextField(20);
	private JPasswordField fieldPassword = new JPasswordField(20);
	private JButton buttonLogin = new JButton("Login");
	
	public MiPanel() {
		JPanel newPanel = new JPanel(new GridBagLayout());
	
    
    GridBagConstraints constraints = new GridBagConstraints();
    
    constraints.anchor= GridBagConstraints.WEST;
    constraints.insets = new Insets(10, 10, 10, 10);
     
    // add components to the panel
    constraints.gridx = 0;
    constraints.gridy = 0;     
    newPanel.add(labelUsername, constraints);

    constraints.gridx = 1;
    newPanel.add(textUsername, constraints);
     
    constraints.gridx = 0;
    constraints.gridy = 1;     
    newPanel.add(labelPassword, constraints);
     
    constraints.gridx = 1;
    newPanel.add(fieldPassword, constraints);
     
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    constraints.anchor = GridBagConstraints.CENTER;
    newPanel.add(buttonLogin, constraints);

     
    // set border for the panel
    newPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Login Panel"));
	}*/
	public MiPanel() {
		this.setLayout(new GridLayout(3,1));
		
		//Botones radio
		JRadioButton ProteinButton = new JRadioButton("Protein") ;
		JRadioButton NucleotidButton = new JRadioButton("Nuecleotid") ;
		
		ButtonGroup group = new ButtonGroup ( ) ;
		group.add(ProteinButton);
		group.add(NucleotidButton);
		ProteinButton.setSelected(true);
		
		
		//ComboBox
		String[] options= {};
		JComboBox<String> comboOfOptions = new JComboBox<String>(options);
		comboOfOptions.setEditable(true);
		
		//TextField para el porcentaje
		JTextField tb= new JTextField("Default string" , 20) ;
		
		//Boton makequery
		JButton b1 = new JButton("Make query");
		
		//textArea para el resultado
		JTextArea textArea = new JTextArea(20,70) ;
		JPanel p= new JPanel();
		JScrollPane scrollPane = new JScrollPane(textArea) ;
		p.add(scrollPane);
		
		
	}

}
