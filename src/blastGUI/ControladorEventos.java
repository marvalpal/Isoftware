package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;

import blast.BlastController;

public class ControladorEventos implements ActionListener{
	

	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	private char queryType='p';
    private float prct;
    private String qSeq;
	private MiPanel miPanel;
	private List<String> aux= new ArrayList<String>();
	
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
		if (e.getSource() == miPanel.getProteinButton()) {
			queryType='p';
		}
		if (e.getSource() == miPanel.getNucleotidButton()) {
			queryType='n';

            JDialog d = new JDialog();
            JLabel l = new JLabel("Warning: La comparación de nucleótidos no está implementada."); 
  
            d.add(l); 
  
            d.setSize(400, 100); 
            d.setVisible(true); 
            d.setLocationRelativeTo(null);
		}
		if (e.getSource() == miPanel.getComboBox()) {
			Object selected = miPanel.getComboBox().getSelectedItem();
            String command = e.getActionCommand();
            if ("comboBoxEdited".equals(command)) {
            	for(int i=0;i<miPanel.getComboBox().getItemCount();i++) {
            		aux.add(miPanel.getComboBox().getItemAt(i));
            	}
            	if(!aux.contains(selected.toString())) {
            		miPanel.getComboBox().addItem(selected.toString());
            	}
            } else if ("comboBoxChanged".equals(command)) {
               qSeq=(String) selected;
            }
		}
		if(e.getSource()==miPanel.getbQuery()) {
			BlastController bCnt = new BlastController();
			try{
				prct=Float.valueOf(miPanel.getTextField().getText());
				String result = bCnt.blastQuery(queryType, dataBaseFile, 
						dataBaseIndexes, (float) prct, qSeq);
				miPanel.setTextArea(result);
			} catch(Exception exc){
				System.out.println("Error en la llamada: " + exc.toString());
			}
		}
	}
	

}
