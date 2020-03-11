package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import blast.BlastController;

public class ControladorEventos implements ActionListener{
	

	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	private char queryType='p';
    private float prct;
    private String qSeq;
	private MiPanel miPanel;
	
	/*
	 * Cuando se escribe un nuevo valor en el ComboBox editable, el ActionCommand del evento generado es "comboBoxEdited" y 
	 * cuando se cambia la selección el ActionCommand es "comboBoxChanged". Hace falta pulsar el retorno de carro para que el 
	 * ComboBox acepte la nueva opción escrita. En ese caso se generan los dos eventos comboBoxChanged y comboBoxEdited.
	 */
	public ControladorEventos(MiPanel mp) {
		miPanel=mp;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == miPanel.ProteinButton) {
			queryType='p';
		}
		if (e.getSource() == miPanel.NucleotidButton) {
			queryType='n';
		}
		if (e.getSource() == miPanel.NucleotidButton) {
			queryType='n';
		}
		if (e.getSource() == miPanel.comboOfOptions) {
			Object selected = miPanel.comboOfOptions.getSelectedItem();
            String command = e.getActionCommand();
            // Detect whether the action command is "comboBoxEdited"
            // or "comboBoxChanged"
            if ("comboBoxEdited".equals(command)) {
            	miPanel.comboOfOptions.addItem(selected.toString());
            } else if ("comboBoxChanged".equals(command)) {
               qSeq=(String) selected;
            }
		}
		if(e.getSource()==miPanel.bQuery) {
			BlastController bCnt = new BlastController();
			try{
				prct=Float.valueOf(miPanel.tb.getText());
				qSeq=miPanel.comboOfOptions.getSelectedItem().toString();
				String result = bCnt.blastQuery(queryType, dataBaseFile, 
						dataBaseIndexes, (float) prct, qSeq);
				miPanel.textArea.setText(result);
			} catch(Exception exc){
				System.out.println("Error en la llamada: " + exc.toString());
			}
		}
	}
	

}
