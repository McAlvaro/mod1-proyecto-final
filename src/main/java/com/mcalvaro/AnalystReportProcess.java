package com.mcalvaro;

import com.mcalvaro.decorator.CompressionDecorator;
import com.mcalvaro.decorator.HeaderDecorator;
import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class AnalystReportProcess implements ReportProcess {

    private final Processor processor;
    private final ReportFactory reportFactory;
    private final Deliverable delivery;

    public AnalystReportProcess(Processor processor, ReportFactory reportFactory, Deliverable delivery) {
        this.processor = processor;
        this.reportFactory = reportFactory;
        this.delivery = delivery;
    }

    @Override
    public void execute(String rawData) {
        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);

        report = new HeaderDecorator(report);
        report = new CompressionDecorator(report);

        delivery.deliver(report);
    }

}
