package com.mcalvaro.report;

public class CsvReport implements Report {

    private final byte[] content;

    public CsvReport(byte[] content) {
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        return content;
    }

    @Override
    public String getFileName() {
        return "report.csv";
    }

    @Override
    public String getMimeType() {
        return "text/csv";
    }

}
