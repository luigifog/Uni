package uo.mp.vehicles.ui;

import uo.mp.util.Console;
import uo.mp.vehicles.file.InvalidFormatException;

public class Menu {
	private String[] options = {
			"Load a file",
			"Add vehicle",
			"Remove vehicle",
			"Save to file",
			"Import from zip",
			"Export to zip",
			"",
			"Show vehicles by brand",
			"Show vehicles by age",
			"",
			"Compute total taxes",
		};
		
	public int readOption() throws InvalidFormatException {
		return Console.readInteger("Option");
	}

	public void show() {
		int i = 1;
		for(String line: options) {
			if ( "".equals(line) ) {
				Console.println("");
				continue;
			}
			
			Console.printf("\t%2d- %s\n", i++, line);
		}
		Console.printf("\n\t%2d- %s\n", 0, "Exit");
	}

}
