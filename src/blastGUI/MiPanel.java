package blastGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MiPanel extends JPanel {
	
	private JRadioButton ProteinButton;
	private JRadioButton NucleotidButton;
	
	//ComboBox
	//public ArrayList<String> options = new ArrayList<String>();
	private JComboBox<String> comboOfOptions;
	
	//TextField para el porcentaje
	private JTextField tb;
	
	//Boton makequery
	private JButton bQuery;
	
	private JTextArea textArea;
	
	public MiPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.getHSBColor(173, 20, 77));
		
		GridBagConstraints constraints = new GridBagConstraints();
	    
	    constraints.anchor= GridBagConstraints.WEST;
	    constraints.insets = new Insets(20, 20, 20, 20);
		
		//Botones radio
		ProteinButton = new JRadioButton("Protein") ;
		ProteinButton.setBackground(Color.getHSBColor(173, 20, 77));
		NucleotidButton = new JRadioButton("Nuecleotid") ;
		NucleotidButton.setBackground(Color.getHSBColor(173, 20, 77));
		
		ButtonGroup group = new ButtonGroup ( ) ;
		group.add(ProteinButton);
		group.add(NucleotidButton);
		ProteinButton.setSelected(true);
		
		
		//ComboBox
		//String[] aux=options.toArray(String[]::new);
		comboOfOptions = new JComboBox<String>();
		comboOfOptions.setEditable(true);
		
		//TextField para el porcentaje
		JLabel lb=new JLabel("Percentaje",JLabel.CENTER) ;
		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setFont(new Font("TimesRoman",Font.PLAIN, 15));
		tb= new JTextField("" , 20) ;
		
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
	
	public JComboBox<String> getComboBox() {
		return comboOfOptions;
	}
	public JRadioButton getProteinButton() {
		return ProteinButton;
	}
	public JRadioButton getNucleotidButton() {
		return  NucleotidButton;
	}
	
	public JTextField getTextField() {
		return tb;
	}
	
	public JButton getbQuery(){
		return bQuery;
	}
	
	public void setTextArea(String s) {
		textArea.setText(s);
		
	}
	

}
