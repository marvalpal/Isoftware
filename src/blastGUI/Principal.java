package blastGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	private static PrintWriter writer=null;
	
	private static void createAndShowGUI ( )  {
	//Create and set up the window.
		JFrame frame = new JFrame("Blast") ;
		frame . setDefaultCloseOperation(JFrame . EXIT_ON_CLOSE) ;
		
		MiPanel panelPrincipal=new MiPanel();
		ControladorEventos controladorPanel=new ControladorEventos(panelPrincipal);
		ControladorEventos c2=new ControladorEventos(panelPrincipal);

		panelPrincipal.bQuery.addActionListener(controladorPanel);
		panelPrincipal.NucleotidButton.addActionListener(controladorPanel);
		panelPrincipal.ProteinButton.addActionListener(controladorPanel);
		//panelPrincipal.bQuery.addActionListener(controladorPanel);
		 
		frame.getContentPane().add(panelPrincipal) ;
		
		//Display the window.
		frame . pack ( ) ;
		frame . setVisible(true) ;
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax . swing . SwingUtilities . invokeLater(new Runnable ( ) {
			public void run ( ) {
				createAndShowGUI ( ) ;
			}
		} ) ;
	}

}
