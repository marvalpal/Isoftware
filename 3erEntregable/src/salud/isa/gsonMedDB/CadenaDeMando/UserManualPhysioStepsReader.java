package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class UserManualPhysioStepsReader extends ElementoJSonReader {

	private static final String MANUALPHYSIOSTEPS_TAGNAME = "userManualPhysioSteps";
	private static final String TITLE_FIELD_TAGNAME = "stepTitle";
	private static final String IMAGE_FIELD_TAGNAME = "stepImage";
	private static final String TEXTE_FIELD_TAGNAME = "stepText";
	private static final String PHYSIOREF_FIELD_TAGNAME = "physioRef";

	private static final String FIELD_SEPARATOR = ";";
	
	public UserManualPhysioStepsReader(ElementoJSonReader s) {
	                      		super(s);
	                      	}

	public StringBuffer readfile(JsonReader reader, String name) throws IOException {

		StringBuffer manualPyshioStepsData = new StringBuffer();

		if (name.equals(MANUALPHYSIOSTEPS_TAGNAME)) {
			manualPyshioStepsData.append(name + "\n" + "\n");
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				manualPyshioStepsData.append(readPhysioStepEntry(reader)).append("\n");
				reader.endObject();
			}
			manualPyshioStepsData.append("\n");
			reader.endArray();
		} else {
			if (sig != null) {
				manualPyshioStepsData.append(super.readfile(reader, name));
			} else {
				reader.skipValue();
				System.err.println("Category " + name + " not processed.");
			}
		}

		return manualPyshioStepsData;
	}

	// Parses the contents of a medicine.
	private String readPhysioStepEntry(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
		String stepTitle = null;
		String stepImage = null;
		String text = null;
		String physioRef = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(TITLE_FIELD_TAGNAME)) {
				stepTitle = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				stepImage = reader.nextString();
			}else if (name.equals(TEXTE_FIELD_TAGNAME)) {
				text = reader.nextString();
			}else if (name.equals(PHYSIOREF_FIELD_TAGNAME)) {
				physioRef = reader.nextString();
			}else {
				reader.skipValue();
			}
		}

		return stepTitle + FIELD_SEPARATOR + stepImage + FIELD_SEPARATOR + text + FIELD_SEPARATOR + physioRef ;
	}

}
