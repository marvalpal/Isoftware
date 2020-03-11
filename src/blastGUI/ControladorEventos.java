package blastGUI;

import java.awt.event.ActionListener;

public class ControladorEventos implements ActionListener{
	private MiPanel miPanel;
	
	/*
	 * Cuando se escribe un nuevo valor en el ComboBox editable, el ActionCommand del evento generado es "comboBoxEdited" y 
	 * cuando se cambia la selección el ActionCommand es "comboBoxChanged". Hace falta pulsar el retorno de carro para que el 
	 * ComboBox acepte la nueva opción escrita. En ese caso se generan los dos eventos comboBoxChanged y comboBoxEdited.
	 */
	public ControladorEventos(MiPanel mp) {
		miPanel=mp;
	}
	

}
