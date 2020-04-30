package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class MedicinesReader extends ElementoJSonReader {

	private static final String MEDICINES_TAGNAME = "medicines";
	private static final String NAME_FIELD_TAGNAME = "name";

	public MedicinesReader(ElementoJSonReader s) {
		super(s);
	}

	public StringBuffer readfile(JsonReader reader,String name) throws IOException{

		StringBuffer medicineData = new StringBuffer();

		if (name.equals(MEDICINES_TAGNAME)){
			medicineData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				medicineData.append(readMedicineEntry(reader)).append("\n");
				reader.endObject();
			}
			medicineData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				medicineData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}


		return medicineData;
	}

	// Parses the contents of a medicine.
	private String readMedicineEntry(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String medName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				medName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}

		return medName;
	}
}
