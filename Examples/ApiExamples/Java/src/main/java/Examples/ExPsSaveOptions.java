package Examples;

//////////////////////////////////////////////////////////////////////////
// Copyright (c) 2001-2024 Aspose Pty Ltd. All Rights Reserved.
//
// This file is part of Aspose.Words. The source code in this file
// is only intended as a supplement to the documentation, and is provided
// "as is", without warranty of any kind, either expressed or implied.
//////////////////////////////////////////////////////////////////////////

import com.aspose.words.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ExPsSaveOptions extends ApiExampleBase {
    @Test(dataProvider = "useBookFoldPrintingSettingsDataProvider")
    public void useBookFoldPrintingSettings(boolean renderTextAsBookFold) throws Exception {
        //ExStart
        //ExFor:PsSaveOptions
        //ExFor:PsSaveOptions.SaveFormat
        //ExFor:PsSaveOptions.UseBookFoldPrintingSettings
        //ExSummary:Shows how to save a document to the Postscript format in the form of a book fold.
        Document doc = new Document(getMyDir() + "Paragraphs.docx");

        // Create a "PsSaveOptions" object that we can pass to the document's "Save" method
        // to modify how that method converts the document to PostScript.
        // Set the "UseBookFoldPrintingSettings" property to "true" to arrange the contents
        // in the output Postscript document in a way that helps us make a booklet out of it.
        // Set the "UseBookFoldPrintingSettings" property to "false" to save the document normally.
        PsSaveOptions saveOptions = new PsSaveOptions();
        {
            saveOptions.setSaveFormat(SaveFormat.PS);
            saveOptions.setUseBookFoldPrintingSettings(renderTextAsBookFold);
        }

        // If we are rendering the document as a booklet, we must set the "MultiplePages"
        // properties of the page setup objects of all sections to "MultiplePagesType.BookFoldPrinting".
        for (Section s : doc.getSections()) {
            s.getPageSetup().setMultiplePages(MultiplePagesType.BOOK_FOLD_PRINTING);
        }

        // Once we print this document on both sides of the pages, we can fold all the pages down the middle at once,
        // and the contents will line up in a way that creates a booklet.
        doc.save(getArtifactsDir() + "PsSaveOptions.UseBookFoldPrintingSettings.ps", saveOptions);
        //ExEnd
    }

    @DataProvider(name = "useBookFoldPrintingSettingsDataProvider")
    public static Object[][] useBookFoldPrintingSettingsDataProvider() {
        return new Object[][]
                {
                        {false},
                        {true},
                };
    }
}
