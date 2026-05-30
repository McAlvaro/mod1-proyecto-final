package com.mcalvaro.report;

public class CsvReport implements Report {

    @Override
    public byte[] getContent() {
        return new byte[0];
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
