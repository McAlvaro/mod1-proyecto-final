package com.mcalvaro;

import com.mcalvaro.decorator.HeaderDecorator;
import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class ExecutiveReportProcess implements ReportProcess {

    private final Processor processor;
    private final ReportFactory reportFactory;
    private final Deliverable delivery;

    public ExecutiveReportProcess(Processor processor, ReportFactory reportFactory, Deliverable delivery) {
        this.processor = processor;
        this.reportFactory = reportFactory;
        this.delivery = delivery;
    }

    @Override
    public void execute(String rawData) {
        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);
        report = new HeaderDecorator(report);

        delivery.deliver(report);
    }

}
