package com.mcalvaro;

import com.mcalvaro.decorator.EncryptionDecorator;
import com.mcalvaro.decorator.WatermarkDecorator;
import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.delivery.SharedFolderDelivery;
import com.mcalvaro.processor.EncryptProcessor;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.ExcelReportCreator;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class AuditorReportProcess implements ReportProcess {

    @Override
    public void execute(String rawData) {
        Processor processor = new EncryptProcessor();
        ReportFactory reportFactory = new ExcelReportCreator();
        Deliverable delivery = new SharedFolderDelivery();

        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);

        report = new WatermarkDecorator(report);
        report = new EncryptionDecorator(report);

        delivery.deliver(report);

    }

}
