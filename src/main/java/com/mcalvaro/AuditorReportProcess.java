package com.mcalvaro;

import java.util.List;
import java.util.function.Function;

import com.mcalvaro.delivery.Deliverable;
import com.mcalvaro.processor.Processor;
import com.mcalvaro.report.Report;
import com.mcalvaro.report.ReportFactory;

public class AuditorReportProcess extends BaseReportProcess {

    private final Processor processor;
    private final ReportFactory reportFactory;
    private final Deliverable delivery;
    private final List<Function<Report, Report>> decorators;

    public AuditorReportProcess(Processor processor, ReportFactory reportFactory, Deliverable delivery,
                                List<Function<Report, Report>> decorators) {
        this.processor = processor;
        this.reportFactory = reportFactory;
        this.delivery = delivery;
        this.decorators = decorators;
    }

    @Override
    protected Processor getProcessor() {
        return processor;
    }

    @Override
    protected ReportFactory getReportFactory() {
        return reportFactory;
    }

    @Override
    protected List<Function<Report, Report>> getDecorators() {
        return decorators;
    }

    @Override
    protected Deliverable getDeliverable() {
        return delivery;
    }
}
