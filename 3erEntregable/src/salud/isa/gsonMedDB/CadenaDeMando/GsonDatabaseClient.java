package salud.isa.gsonMedDB.CadenaDeMando;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try {
			DatabaseJSonReader dbjp = new DatabaseJSonReader();
			ElementoJSonReader cadenaDeMando = new UserManualStepsReader(new UserManualPhysioStepsReader(
					new PosologiesReader(new MedPresReader(new InhalersReader(new PhysiotherapiesReader(
							new ActiveIngReader(new RescuedMedPresReader(new MedicinesReader(null)))))))));

			try {
				System.out.println(dbjp.parse
						("./resources/datos.json", cadenaDeMando));
			} finally {
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
