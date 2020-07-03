package org.asfoor;
import java.io.File;

import javax.swing.*;

public class LabelController {
    public void setPath(JLabel label, File inputFile){
        label.setText(inputFile.getPath());
    }
    
    public void setInvalid(JLabel label){
        label.setText("*invalid input*");
    }
    
    public void setRemoved(JLabel label){
        label.setText("Blanke Seiten wurden entfernt.");
    }
    
    public void setNoBlanks(JLabel label){
        label.setText("Keine blanken Seiten gefunden.");
    }
    
}