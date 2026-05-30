package com.mcalvaro.delivery;

import com.mcalvaro.report.Report;

public class ApiDelivery implements Deliverable {

    @Override
    public void deliver(Report report) {
        System.out.println("Delivering to API");
    }

}
