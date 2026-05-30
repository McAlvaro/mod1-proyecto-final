package com.mcalvaro.delivery;

import com.mcalvaro.report.Report;

public class EmailDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {
        System.out.println("Delivering to email" +
                " - filename: " + report.getFileName() + ", mime type: " + report.getMimeType() +
                ", content: " + report.getContent());
    }

}
