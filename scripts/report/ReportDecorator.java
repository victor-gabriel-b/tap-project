package report;

public abstract class ReportDecorator extends Report {
    protected Report decoratedReport;

    public ReportDecorator(Report decoratedReport) {
        this.decoratedReport = decoratedReport;
    }

    @Override
    public void generateReport() {
        decoratedReport.generateReport();
    }

    @Override
    protected void saveReport() {
        decoratedReport.saveReport();
    }
}
