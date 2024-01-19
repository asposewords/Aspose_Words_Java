package DocsExamples.LINQ_Reporting_Engine;

import DocsExamples.DocsExamplesBase;
import TestData.Common;
import TestData.TestClasses.ContractTestClass;
import TestData.TestClasses.ManagerTestClass;
import org.testng.annotations.Test;
import com.aspose.words.Document;
import com.aspose.words.ReportingEngine;

@Test
public class Tables extends DocsExamplesBase
{
    @Test
    public void inTableAlternateContent() throws Exception
    {
        //ExStart:InTableAlternateContent
        Document doc = new Document(getMyDir() + "ReportingEngine.Total.Java.docx");

        ReportingEngine engine = new ReportingEngine();
        engine.getKnownTypes().add(ContractTestClass.class);

        engine.buildReport(doc, Common.getContracts(), "Contracts");

        doc.save(getArtifactsDir() + "ReportingEngine.InTableAlternateContent.docx");
        //ExEnd:InTableAlternateContent
    }

    @Test
    public void inTableMasterDetail() throws Exception
    {
        //ExStart:InTableMasterDetail
        Document doc = new Document(getMyDir() + "ReportingEngine.TestNestedDataTable.Java.docx");

        ReportingEngine engine = new ReportingEngine();
        engine.getKnownTypes().add(ManagerTestClass.class);
        engine.getKnownTypes().add(ContractTestClass.class);

        engine.buildReport(doc, Common.getManagers(), "Managers");

        doc.save(getArtifactsDir() + "ReportingEngine.InTableMasterDetail.docx");
        //ExEnd:InTableMasterDetail
    }

    @Test
    public void inTableWithFilteringGroupingSorting() throws Exception
    {
        //ExStart:InTableWithFilteringGroupingSorting
        Document doc = new Document(getMyDir() + "Reporting engine template.Table with filtering.Java.docx");

        ReportingEngine engine = new ReportingEngine();
        engine.getKnownTypes().add(ContractTestClass.class);

        engine.buildReport(doc, Common.getContracts(), "contracts");

        doc.save(getArtifactsDir() + "ReportingEngine.InTableWithFilteringGroupingSorting.docx");
        //ExEnd:InTableWithFilteringGroupingSorting
    }
}
