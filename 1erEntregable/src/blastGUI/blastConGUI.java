package blastGUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import blast.BlastController;

public class blastConGUI {

	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	private static PrintWriter writer=null;
	
	private static void createAndShowGUI ( )  {
	//Create and set up the window.
		JFrame frame = new JFrame("Blast") ;
		frame.setLayout(new GridLayout( 5 , 1 ) ) ;
		JPanel p1= new JPanel();
		p1.setLayout(new GridLayout(1,2));
		frame . setDefaultCloseOperation(JFrame . EXIT_ON_CLOSE) ;
		 
		
		//Creación de archivo de secuencias introducidas para el combobox
		
		 /*try {
			writer= new PrintWriter("Opciones.txt","UTF-8");
		} catch (Exception e) {
		      System.out.println("Ups...Algo ha salido mal.");
		    }*/
		 List<String> lines = Collections.emptyList(); 
		    try
		    { 
		      lines = 
		       Files.readAllLines(Paths.get("Opciones.txt"), StandardCharsets.UTF_8); 
		    } 
		  
		    catch (IOException e) 
		    { 		  
		      // do something 
		    	System.out.println("Ups...Algo ha salido mal.");
		    } 
		
		
		
		//String[] options = {"a","b","c"};//Aquí van las secuencias que ya he introducido antes
		String[] options=lines.stream().toArray(String[]::new);
		System.out.println(lines.toString());
		JComboBox<String> comboOfOptions = new JComboBox<String>(options);
		comboOfOptions.setEditable(true);
		comboOfOptions.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				writer.println("The first line");
				} 
			}) ;
		
		
		//comboOfOptions.addActionListener(this);
		
		
		//Creación de botones
		JRadioButton ProteinButton = new JRadioButton("Protein") ;
		JRadioButton NucleotidButton = new JRadioButton("Nuecleotid") ;
		
		ButtonGroup group = new ButtonGroup ( ) ;
		group.add(ProteinButton);
		group.add(NucleotidButton);
		ProteinButton.setSelected(true);
		p1.add(ProteinButton);
		p1.add(NucleotidButton);
		
		JTextField tb= new JTextField("Default string" , 20) ;
		JButton b1 = new JButton("Make query");
		
		//Text area
		
		JTextArea textArea = new JTextArea(20,70) ;
		JPanel p= new JPanel();
		JScrollPane scrollPane = new JScrollPane(textArea) ;
		//p.add(textArea);
		p.add(scrollPane);
		
		frame.getContentPane().add(p1) ;
		frame.getContentPane().add(comboOfOptions) ;
		frame.getContentPane().add(tb);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(p);
		
		//Display the window.
		frame . pack ( ) ;
		frame . setVisible(true) ;
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String args[]){
		javax . swing . SwingUtilities . invokeLater(new Runnable ( ) {
			public void run ( ) {
				createAndShowGUI ( ) ;
			}
		} ) ;
		/*BlastController bCnt = new BlastController();
		try{
			String result = bCnt.blastQuery('p', dataBaseFile, 
					dataBaseIndexes, (float) 0.9, "GKGKGKGKGK");
			System.out.println(result);
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}*/
	}
}