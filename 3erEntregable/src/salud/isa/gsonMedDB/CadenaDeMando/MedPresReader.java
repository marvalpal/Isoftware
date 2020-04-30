package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class MedPresReader extends ElementoJSonReader{
	
	protected static final String MEDPRES_TAGNAME = "medicinePresentations";
	
	private static final String MEDREF_FIELD_TAGNAME = "medicineRef";
	private static final String ACTINGREF_FIELD_TAGNAME = "activeIngRef";
	private static final String INHREF_FIELD_TAGNAME = "inhalerRef";
	private static final String DOSE_FIELD_TAGNAME = "dose";
	private static final String POSOLOGY_FIELD_TAGNAME = "posologyRef";
	
	private static final String FIELD_SEPARATOR = ";";

	public MedPresReader(ElementoJSonReader s) {
		super(s);
	}
	
	public StringBuffer readfile(JsonReader reader,String name) throws IOException{
		//String name = reader.nextName();
		StringBuffer MedicinePresentationData = new StringBuffer();
		if (name.equals(MEDPRES_TAGNAME)) {
			MedicinePresentationData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				MedicinePresentationData.append(readMedicinePresentationEntry(reader)).append("\n");
				reader.endObject();
			}
			MedicinePresentationData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				MedicinePresentationData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}
		
		return MedicinePresentationData;
	}

	// Parses the contents of a rescue medicine presentation entry
	private String readMedicinePresentationEntry(JsonReader reader) throws IOException {
		String medRef = null;
		String aiRef = null;
		String inhRef = null;
		String dose = null;
		String posRef=null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(MEDREF_FIELD_TAGNAME)) {
				medRef = reader.nextString();
			} else if (name.equals(ACTINGREF_FIELD_TAGNAME)) {
				aiRef = reader.nextString();
			} else if (name.equals(INHREF_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				inhRef = new String(res);
			} else if (name.equals(DOSE_FIELD_TAGNAME)) {
				StringBuffer res = new StringBuffer();
				reader.beginArray();
				while (reader.hasNext()) {
					res.append(reader.nextString()).append(",");
				}
				reader.endArray();
				res.deleteCharAt(res.length() - 1);
				dose = new String(res);
			} else if (name.equals(POSOLOGY_FIELD_TAGNAME)) {

				JsonToken jString=JsonToken.STRING;
				if(reader.peek().equals((jString))) {
					posRef = reader.nextString();
				}else{
					
					StringBuffer res = new StringBuffer();
					reader.beginArray();
					while (reader.hasNext()) {
						res.append(reader.nextString()).append(",");
					}
					reader.endArray();
					res.deleteCharAt(res.length() - 1);
					posRef = new String(res);

				}
			}else {
				reader.skipValue();
			}

		}
		return medRef + FIELD_SEPARATOR + aiRef + FIELD_SEPARATOR + inhRef + FIELD_SEPARATOR + dose + FIELD_SEPARATOR + posRef;
	}
}
