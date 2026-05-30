package com.mcalvaro;

import com.mcalvaro.decorator.HeaderDecorator;
import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.delivery.EmailDelivery;
import com.mcalvaro.processor.BasicProcessor;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.PdfReportCreator;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class ExecutiveReportProcess implements ReportProcess {

    @Override
    public void execute(String rawData) {
        Processor processor = new BasicProcessor();
        ReportFactory reportFactory = new PdfReportCreator();
        Deliverable delivery = new EmailDelivery();

        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);
        report = new HeaderDecorator(report);

        delivery.deliver(report);
    }

}
