package com.mcalvaro.delivery;

import java.util.HexFormat;

import com.mcalvaro.report.Report;

public class ApiDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {
        System.out.println("Delivering to API - filename: " + report.getFileName() +
                ", mime type: " + report.getMimeType() + ", content: " + HexFormat.of().formatHex(report.getContent()));
    }

}
