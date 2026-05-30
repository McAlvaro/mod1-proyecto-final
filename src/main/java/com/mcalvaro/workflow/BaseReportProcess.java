package com.mcalvaro.workflow;

import java.util.List;
import java.util.function.Function;

import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public abstract class BaseReportProcess implements ReportProcess {

    protected abstract Processor getProcessor();

    protected abstract ReportFactory getReportFactory();

    protected abstract List<Function<Report, Report>> getDecorators();

    protected abstract Deliverable getDeliverable();

    @Override
    public final void execute(String rawData) {
        String data = getProcessor().process(rawData);
        Report report = getReportFactory().createReport(data);

        for (var decorator : getDecorators()) {
            report = decorator.apply(report);
        }

        getDeliverable().deliver(report);
    }
}
