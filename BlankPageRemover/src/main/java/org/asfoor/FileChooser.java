package org.asfoor;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileChooser {
    public File chooseFile() {
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        fc.setFileFilter(filter);
        int response = fc.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }
}