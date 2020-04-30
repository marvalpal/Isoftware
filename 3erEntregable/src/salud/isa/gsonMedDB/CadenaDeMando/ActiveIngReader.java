package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ActiveIngReader extends ElementoJSonReader{
	private static final String ACTIVEING_TAGNAME = "activeIngredients";
	private static final String NAME_FIELD_TAGNAME = "name";
	
	public ActiveIngReader(ElementoJSonReader s) {
		super(s);
	}

	public StringBuffer readfile(JsonReader reader,String name) throws IOException{

		StringBuffer activeIngData = new StringBuffer();

		if (name.equals(ACTIVEING_TAGNAME)){
			activeIngData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				activeIngData.append( readActiveIngredientEntry(reader)).append("\n");
				reader.endObject();
			}
			activeIngData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				activeIngData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}


		return activeIngData;
	}

	// Parses the contents of a medicine.
	private String readActiveIngredientEntry(JsonReader reader) throws IOException {
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
