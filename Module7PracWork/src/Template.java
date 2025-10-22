abstract class ReportGenerator {
    public void generateReport() {
        collectData();
        formatData();
        createFile();
        saveFile();
    }
    protected abstract void collectData();
    protected abstract void formatData();
    protected abstract void createFile();
    protected abstract void saveFile();
}

class PdfReport extends ReportGenerator {
    protected void collectData() {
        System.out.println("Collecting data for PDF.");
    }
    protected void formatData() {
        System.out.println("Formatting data for PDF.");
    }
    protected void createFile() {
        System.out.println("Creating PDF file.");
    }
    protected void saveFile() {
        System.out.println("Saving PDF file.");
    }
}

class ExcelReport extends ReportGenerator {
    protected void collectData() {
        System.out.println("Collecting data for Excel.");
    }
    protected void formatData() {
        System.out.println("Formatting data for Excel.");
    }
    protected void createFile() {
        System.out.println("Creating Excel file.");
    }
    protected void saveFile() {
        System.out.println("Saving Excel file.");
    }
}
class HtmlReport extends ReportGenerator {
    protected void collectData() {
        System.out.println("Collecting data for HTML.");
    }
    protected void formatData() {
        System.out.println("Formatting data for HTML.");
    }
    protected void createFile() {
        System.out.println("Creating HTML file.");
    }
    protected void saveFile() {
        System.out.println("Saving HTML file.");
    }
}
