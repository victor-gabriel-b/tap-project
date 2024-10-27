package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FooterDecorator extends ReportDecorator {
    public FooterDecorator(Report decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public void generateReport() {
        super.generateReport();
        addFooter();
    }

    private void addFooter() {
        try {
            FileWriter writer = new FileWriter("Report.html", true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("<footer>");
            bw.newLine();
            bw.write("<p>Relatório gerado em: " + java.time.LocalDate.now() + "</p>");
            bw.newLine();
            bw.write("</footer>");
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}