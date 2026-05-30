package com.mcalvaro.report;

public class PdfReport implements Report {

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    @Override
    public String getFileName() {
        return "report.pdf";
    }

    @Override
    public String getMimeType() {
        return "application/pdf";
    }

}
