package com.mcalvaro.decorator;

import com.mcalvaro.report.Report;

public class WatermarkDecorator extends ReportDecorator {

    public WatermarkDecorator(Report report) {
        super(report);
    }

    @Override
    public byte[] getContent() {
        return addWatermark(super.getContent());
    }

    private byte[] addWatermark(byte[] content) {
        System.out.println("Adding watermark");
        return content;
    }

}
