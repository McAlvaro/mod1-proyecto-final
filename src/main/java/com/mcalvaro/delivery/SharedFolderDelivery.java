package com.mcalvaro.delivery;

import com.mcalvaro.report.Report;

public class SharedFolderDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {
        report.getContent();
        System.out.println("Delivering to shared folder");
    }

}
