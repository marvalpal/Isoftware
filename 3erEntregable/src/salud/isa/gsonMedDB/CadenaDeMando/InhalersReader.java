package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class InhalersReader extends ElementoJSonReader{
private static final String INHALER_TAGNAME = "inhalers";
	
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	
	private static final String FIELD_SEPARATOR = ";";

	public InhalersReader(ElementoJSonReader s) {
		super(s);
	}
	
	public StringBuffer readfile(JsonReader reader,String name) throws IOException{
		//String name = reader.nextName();
		StringBuffer inhalerData = new StringBuffer();
		if (name.equals(INHALER_TAGNAME)) {
			inhalerData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				inhalerData.append(readInhalerEntry(reader)).append("\n");
				reader.endObject();
			}
			inhalerData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				inhalerData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}
		
		return inhalerData;
	}

	// Parses the contents of a rescue medicine presentation entry
	private String readInhalerEntry(JsonReader reader) throws IOException {
		String inhName = null;
		String image = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				inhName = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				image = reader.nextString();
			} else {
				reader.skipValue();
			}

		}
		return inhName + FIELD_SEPARATOR + image;
	}
}
