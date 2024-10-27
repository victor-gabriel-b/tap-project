package report;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(Report decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public void generateReport() {
        super.generateReport();
        exportToPdf();
    }

    private void exportToPdf() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
            document.open();
            document.add(new Paragraph("Relatório de Logins"));
            document.add(new Paragraph("Login, Id, UserId, Date and Time"));
            for (int i = 1; i <= loginList.size(); i++) {
                document.add(new Paragraph(i + ", " + loginList.get(i - 1).getId() + ", " + loginList.get(i - 1).getUserId() + ", " + loginList.get(i - 1).getDataHora()));
            }
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
