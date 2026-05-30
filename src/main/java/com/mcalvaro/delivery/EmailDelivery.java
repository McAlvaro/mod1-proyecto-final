package com.mcalvaro.delivery;

import java.util.HexFormat;

import com.mcalvaro.report.Report;

public class EmailDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {
        System.out.println("Delivering to email" +
                " - filename: " + report.getFileName() + ", mime type: " + report.getMimeType() +
                ", content: " + HexFormat.of().formatHex(report.getContent()));
    }

}
