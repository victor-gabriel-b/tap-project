package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HeaderDecorator extends ReportDecorator {
    public HeaderDecorator(Report decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public void generateReport() {
        super.generateReport();
        addHeader();
    }

    private void addHeader() {
        try {
            FileWriter writer = new FileWriter("Report.html", true);
            BufferedWriter bw = new BufferedWriter(writer);

            bw.write("<header>");
            bw.newLine();
            bw.write("<h1>Relatório de Logins</h1>");
            bw.newLine();
            bw.write("</header>");
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
