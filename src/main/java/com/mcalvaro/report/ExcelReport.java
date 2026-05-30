package com.mcalvaro.report;

public class ExcelReport implements Report {

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    @Override
    public String getFileName() {
        return "report.xlsx";
    }

    @Override
    public String getMimeType() {
        return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    }

}
