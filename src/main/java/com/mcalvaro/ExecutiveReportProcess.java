package com.mcalvaro;

import java.util.List;
import java.util.function.Function;

import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class ExecutiveReportProcess implements ReportProcess {

    private final Processor processor;
    private final ReportFactory reportFactory;
    private final Deliverable delivery;
    private final List<Function<Report, Report>> decorators;

    public ExecutiveReportProcess(Processor processor, ReportFactory reportFactory, Deliverable delivery,
                                  List<Function<Report, Report>> decorators) {
        this.processor = processor;
        this.reportFactory = reportFactory;
        this.delivery = delivery;
        this.decorators = decorators;
    }

    @Override
    public void execute(String rawData) {
        String data = processor.process(rawData);
        Report report = reportFactory.createReport(data);

        for (var decorator : decorators) {
            report = decorator.apply(report);
        }

        delivery.deliver(report);
    }

}
