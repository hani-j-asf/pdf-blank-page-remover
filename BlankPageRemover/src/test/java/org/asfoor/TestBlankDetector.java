package org.asfoor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBlankDetector {

	BufferedImage whiteImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	BufferedImage blackImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	Color whiteColor = new Color(255, 255, 255);
	Color blackColor = new Color(0, 0, 0);

	@BeforeEach
	public void init() {
		int white = whiteColor.getRGB();
		int black = blackColor.getRGB();
		whiteImage.setRGB(0, 0, white);
		blackImage.setRGB(0, 0, black);
	}

	@Test
	public void testIsBlank_notBlank() throws IOException {
		assertEquals(false, BlankDetector.isBlank(blackImage));
	}

	@Test
	public void testIsBlank_blank() throws IOException {
		assertEquals(true, BlankDetector.isBlank(whiteImage));
	}
}
