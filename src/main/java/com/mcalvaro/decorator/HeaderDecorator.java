package com.mcalvaro.decorator;

import com.mcalvaro.report.Report;

public class HeaderDecorator extends ReportDecorator {

    public HeaderDecorator(Report report) {
        super(report);
    }

    @Override
    public byte[] getContent() {
        return addHeader(super.getContent());
    }

    private byte[] addHeader(byte[] content) {
        System.out.println("Adding header");

        return content;
    }

}
