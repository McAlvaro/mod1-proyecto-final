package com.mcalvaro.report;

public class PdfReport implements Report {

    private final byte[] content;

    public PdfReport(byte[] content) {
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        return content;
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
