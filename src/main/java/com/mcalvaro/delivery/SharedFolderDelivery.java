package com.mcalvaro.delivery;

import com.mcalvaro.report.Report;

public class SharedFolderDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {

        System.out.println("Delivering to shared folder - filename: " + report.getFileName() + ", mime type: "
                + report.getMimeType() +
                ", content: " + report.getContent());
    }

}
