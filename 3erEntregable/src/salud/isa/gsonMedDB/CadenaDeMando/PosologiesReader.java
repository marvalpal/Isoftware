package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class PosologiesReader extends ElementoJSonReader{
	
	private static final String POSOLOGIES_TAGNAME = "posologies";
	private static final String POSOLOGIES_FIELD_TAGNAME = "description";

	public PosologiesReader(ElementoJSonReader s) {
		super(s);
	}

	public StringBuffer readfile(JsonReader reader,String name) throws IOException{

		StringBuffer posologyData = new StringBuffer();

		if (name.equals(POSOLOGIES_TAGNAME)){
			posologyData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				posologyData.append(readPosologyEntry(reader)).append("\n");
				reader.endObject();
			}
			posologyData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				posologyData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}


		return posologyData;
	}

	// Parses the contents of a medicine.
	private String readPosologyEntry(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String medName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(POSOLOGIES_FIELD_TAGNAME)) {
				medName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}

		return medName;
	}

}
