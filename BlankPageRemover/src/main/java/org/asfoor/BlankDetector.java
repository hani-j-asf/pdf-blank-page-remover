package org.asfoor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BlankDetector {
    public static Boolean isBlank(BufferedImage pageImage) throws IOException {
        BufferedImage bufferedImage = pageImage;
        long count = 0;
        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();
        Double areaFactor = (width * height) * 1.00;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = new Color(bufferedImage.getRGB(x, y));
                if (c.getRed() == c.getGreen() && c.getRed() == c.getBlue() && c.getRed() >= 248) {
                    count++;
                }
            }
        }
        if (count >= areaFactor) {
            return true;
        }
        return false;
    }
}