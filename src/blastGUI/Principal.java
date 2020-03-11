package blastGUI;

import javax.swing.JFrame;

public class Principal {
	
	private static void createAndShowGUI ( )  {
	//Create and set up the window.
		JFrame frame = new JFrame("Blast") ;
		frame . setDefaultCloseOperation(JFrame . EXIT_ON_CLOSE) ;
		
		MiPanel panelPrincipal=new MiPanel();
		ControladorEventos controladorPanel=new ControladorEventos(panelPrincipal);

		panelPrincipal.bQuery.addActionListener(controladorPanel);
		panelPrincipal.NucleotidButton.addActionListener(controladorPanel);
		panelPrincipal.ProteinButton.addActionListener(controladorPanel);
		panelPrincipal.comboOfOptions.addActionListener(controladorPanel);
		 
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
