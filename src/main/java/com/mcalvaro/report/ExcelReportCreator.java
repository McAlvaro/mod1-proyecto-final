package com.mcalvaro.report;

public class ExcelReportCreator implements ReportFactory {

    @Override
    public Report createReport(String processedData) {
        System.out.println("Creating Excel report");
        return new ExcelReport(processedData.getBytes());
    }

}
