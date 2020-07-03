package org.asfoor;

import org.junit.jupiter.api.Test;
import java.io.File;

import javax.swing.JLabel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLabelController {
    LabelController lc = new LabelController();
    JLabel label = new JLabel();

    @Test
    public void testSetPath() {
        File f = new File("main\\resources\\Test.pdf");
        lc.setPath(label, f);
        assertEquals("main\\resources\\Test.pdf", label.getText());
    }

    @Test
    public void testSetInvalid(){
        lc.setInvalid(label);
        assertEquals("*invalid input*", label.getText());
    }

    @Test
    public void testSetRemoved(){
        lc.setRemoved(label);
        assertEquals("Blanke Seiten wurden entfernt.", label.getText());
    }

    @Test
    public void testSetNoBlanks(){
        lc.setNoBlanks(label);
        assertEquals("Keine blanken Seiten gefunden.", label.getText());
    }
}