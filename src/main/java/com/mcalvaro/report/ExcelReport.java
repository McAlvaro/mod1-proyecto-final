package com.mcalvaro.report;

public class ExcelReport implements Report {

    private final byte[] content;

    public ExcelReport(byte[] content) {
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        return content;
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
