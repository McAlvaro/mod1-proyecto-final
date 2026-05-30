package com.mcalvaro.decorator;

import com.mcalvaro.report.Report;

public class CompressionDecorator extends ReportDecorator {

    public CompressionDecorator(Report report) {
        super(report);
    }

    @Override
    public byte[] getContent() {
        return compress(super.getContent());
    }

    private byte[] compress(byte[] content) {
        System.out.println("Compressing");
        return content;
    }

}
