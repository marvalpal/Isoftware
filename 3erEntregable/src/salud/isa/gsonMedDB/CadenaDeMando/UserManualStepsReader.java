package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class UserManualStepsReader extends ElementoJSonReader{
	
	private static final String MANUALSTEPS_TAGNAME = "userManualSteps";
	private static final String TITLE_FIELD_TAGNAME = "stepTitle";
	private static final String IMAGE_FIELD_TAGNAME = "stepImage";
	private static final String TEXTE_FIELD_TAGNAME = "stepText";
	private static final String INHALERREF_FIELD_TAGNAME = "inhalerRef";

	private static final String FIELD_SEPARATOR = ";";
	
	public UserManualStepsReader(ElementoJSonReader s) {
	                      		super(s);
	                      	}

	public StringBuffer readfile(JsonReader reader, String name) throws IOException {

		StringBuffer manualStepsData = new StringBuffer();

		if (name.equals(MANUALSTEPS_TAGNAME)) {
			manualStepsData.append(name + "\n" + "\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				manualStepsData.append(readPhysioStepEntry(reader)).append("\n");
				reader.endObject();
			}
			manualStepsData.append("\n");
			reader.endArray();
		} else {
			if (sig != null) {
				manualStepsData.append(super.readfile(reader, name));
			} else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}

		return manualStepsData;
	}

	// Parses the contents of a medicine.
	private String readPhysioStepEntry(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String stepTitle = null;
		String stepImage = null;
		String text = null;
		String inhalerRef = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(TITLE_FIELD_TAGNAME)) {
				stepTitle = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				stepImage = reader.nextString();
			}else if (name.equals(TEXTE_FIELD_TAGNAME)) {
				text = reader.nextString();
			}else if (name.equals(INHALERREF_FIELD_TAGNAME)) {
				inhalerRef = reader.nextString();
			}else {
				reader.skipValue();
			}
		}

		return stepTitle + FIELD_SEPARATOR + stepImage + FIELD_SEPARATOR + text + FIELD_SEPARATOR + inhalerRef ;
	}


}
