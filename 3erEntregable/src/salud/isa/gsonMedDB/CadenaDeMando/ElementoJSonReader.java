package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ElementoJSonReader {
	
	protected ElementoJSonReader sig;

	public ElementoJSonReader(ElementoJSonReader s) {
		sig=s;
	}
	
	public StringBuffer readfile(JsonReader reader,String name) throws IOException{
		return sig.readfile(reader,name);
	}
}
