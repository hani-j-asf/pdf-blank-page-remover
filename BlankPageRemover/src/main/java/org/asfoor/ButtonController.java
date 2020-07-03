package org.asfoor;
import com.google.common.io.Files;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ButtonController {

    public boolean runButton_ActionPerformed(ActionEvent evt, File input) throws IOException {
        boolean blank = false;
        PDDocument document = PDDocument.load(input);
        PDFRenderer renderedDoc = new PDFRenderer(document);
        for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
            if(BlankDetector.isBlank(renderedDoc.renderImage(pageNumber))) {
                blank = true;
            }
        }
        if(blank == true){
            for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
                if(BlankDetector.isBlank(renderedDoc.renderImage(pageNumber))) {
                    document.removePage(pageNumber);
                    pageNumber--;
                }
            }
            document.save(new File(input.getParent() +  "\\" + Files.getNameWithoutExtension(input.getName()) + "_noBlanks.pdf" ));
        }
        document.close();
        return blank;
    }
}