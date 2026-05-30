package com.mcalvaro.decorator;

import com.mcalvaro.report.Report;

public abstract class ReportDecorator implements Report {

    protected Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public byte[] getContent() {
        return report.getContent();
    }

    @Override
    public String getFileName() {
        return report.getFileName();
    }

    @Override
    public String getMimeType() {
        return report.getMimeType();
    }

}
