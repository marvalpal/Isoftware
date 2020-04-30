package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class PhysiotherapiesReader extends ElementoJSonReader{
	private static final String PHYSIO_TAGNAME = "physiotherapies";
	
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	
	private static final String FIELD_SEPARATOR = ";";

	public PhysiotherapiesReader(ElementoJSonReader s) {
		super(s);
	}
	
	public StringBuffer readfile(JsonReader reader,String name) throws IOException{
		//String name = reader.nextName();
		StringBuffer physioData = new StringBuffer();
		if (name.equals(PHYSIO_TAGNAME)) {
			physioData.append(name+"\n"+"\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				physioData.append(readRescueMedicinePresentationEntry(reader)).append("\n");
				reader.endObject();
			}
			physioData.append("\n");
			reader.endArray();
		}else {
			if(sig!=null) {
				physioData.append(super.readfile(reader,name));
			}else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}
		
		return physioData;
	}

	// Parses the contents of a rescue medicine presentation entry
	private String readRescueMedicinePresentationEntry(JsonReader reader) throws IOException {
		String phyName = null;
		String image = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				phyName = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				image = reader.nextString();
			} else {
				reader.skipValue();
			}

		}
		return phyName + FIELD_SEPARATOR + image;
	}
}
