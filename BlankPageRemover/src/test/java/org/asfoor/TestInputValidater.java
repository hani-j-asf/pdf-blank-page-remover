package org.asfoor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import org.junit.jupiter.api.Test;

public class TestInputValidater {

	File inputPDF = new File("Good.pdf");
	File inputDocx = new File("False.docx");
	
	@Test
	public void testValidateInput_wrongFormat() {
		assertEquals(false, inputValidater.validateInput(inputDocx));
	}
	
	@Test
	public void testValidateInput_null() {
		assertEquals(false, inputValidater.validateInput(null));
	}
	
	@Test
	public void testValidateInput_right() {
		assertEquals(true,inputValidater.validateInput(inputPDF));
	}
}
