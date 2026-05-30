package com.mcalvaro.report;

public class PdfReportCreator implements ReportFactory {

    @Override
    public Report createReport(String processedData) {
        System.out.println("Creating PDF report");
        return new PdfReport(processedData.getBytes());
    }

}
