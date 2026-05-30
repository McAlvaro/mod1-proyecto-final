package com.mcalvaro.report;

public class CsvReportCreator implements ReportFactory {

    @Override
    public Report createReport(String processedData) {
        System.out.println("Creating CSV report");
        return new CsvReport();
    }

}
