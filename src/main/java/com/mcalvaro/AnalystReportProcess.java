package com.mcalvaro;

import com.mcalvaro.decorator.CompressionDecorator;
import com.mcalvaro.decorator.HeaderDecorator;
import com.mcalvaro.delivery.ApiDelivery;
import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.DetailedProcessor;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.CsvReportCreator;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class AnalystReportProcess implements ReportProcess {

    @Override
    public void execute(String rawData) {

        Processor processor = new DetailedProcessor();
        ReportFactory reportFactory = new CsvReportCreator();
        Deliverable delivery = new ApiDelivery();

        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);

        report = new HeaderDecorator(report);
        report = new CompressionDecorator(report);

        delivery.deliver(report);
    }

}
