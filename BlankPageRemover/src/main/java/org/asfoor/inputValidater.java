package org.asfoor;
import java.io.File;

public class inputValidater {

	public static boolean validateInput(File input) {
		if (input != null && input.getName().endsWith(".pdf")) {
			return true;
		} else {
			return false;
		}
	}
}
