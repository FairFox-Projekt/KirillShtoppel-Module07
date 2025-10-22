public class TemplateExecution {
    public static void main(String[] args) {
        ReportGenerator pdf = new PdfReport();
        ReportGenerator excel = new ExcelReport();
        ReportGenerator html = new HtmlReport();

        pdf.generateReport();
        System.out.println();
        excel.generateReport();
        System.out.println();
        html.generateReport();
    }
}