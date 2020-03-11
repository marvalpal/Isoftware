package blastGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

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
	public JRadioButton ProteinButton;
	public JRadioButton NucleotidButton;
	
	//ComboBox
	//public ArrayList<String> options = new ArrayList<String>();
	public String[] options= {};
	public JComboBox<String> comboOfOptions;
	
	//TextField para el porcentaje
	public JTextField tb;
	
	//Boton makequery
	public JButton bQuery;
	
	public JTextArea textArea;
	
	public MiPanel() {
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
	    
	    constraints.anchor= GridBagConstraints.WEST;
	    constraints.insets = new Insets(20, 20, 20, 20);
		
		//Botones radio
		ProteinButton = new JRadioButton("Protein") ;
		NucleotidButton = new JRadioButton("Nuecleotid") ;
		
		ButtonGroup group = new ButtonGroup ( ) ;
		group.add(ProteinButton);
		group.add(NucleotidButton);
		ProteinButton.setSelected(true);
		
		
		//ComboBox
		//String[] aux=options.toArray(String[]::new);
		comboOfOptions = new JComboBox<String>(options);
		comboOfOptions.setEditable(true);
		
		//TextField para el porcentaje
		JLabel lb=new JLabel("Percentaje",JLabel.CENTER) ;
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setFont(new Font("TimesRoman",Font.PLAIN, 15));
		tb= new JTextField("Default string" , 20) ;
		
		//Boton makequery
		bQuery = new JButton("Make query");
		
		//textArea para el resultado
		textArea = new JTextArea(10,50) ;
		JPanel p= new JPanel();
		JScrollPane scrollPane = new JScrollPane(textArea) ;
		p.add(scrollPane);
		
		constraints.gridx=0;
	    constraints.gridy=0;
	    constraints.gridwidth=1;
	    constraints.gridheight=1;
	    this.add(ProteinButton, constraints);
	    
	    constraints.gridx=0;
	    constraints.gridy=1;
	    constraints.gridwidth=1;
	    constraints.gridheight=1;
	    this.add(NucleotidButton, constraints);
	    
	    constraints.gridx=1;
	    constraints.gridy=0;
	    constraints.gridwidth=2;
	    constraints.gridheight=2;
	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.weighty = 1.0;
	    this.add(comboOfOptions, constraints);
	    constraints.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

	    
	    constraints.gridx=0;
	    constraints.gridy=2;
	    constraints.gridwidth=1;
	    constraints.gridheight=1;
	    this.add(lb, constraints);
	    
	    constraints.gridx=1;
	    constraints.gridy=2;
	    constraints.gridwidth=1;
	    constraints.gridheight=1;
	    this.add(tb, constraints);
	    
	    constraints.gridx=0;
	    constraints.gridy=3;
	    constraints.gridwidth=1;
	    constraints.gridheight=1;
	    this.add(bQuery, constraints);
	    
	    constraints.gridx=0;
	    constraints.gridy=4;
	    constraints.gridwidth=3;
	    constraints.gridheight=3;
	    this.add(p, constraints);
		
		
	}

}
