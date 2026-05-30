package com.mcalvaro;

import java.util.List;

import com.mcalvaro.decorator.CompressionDecorator;
import com.mcalvaro.decorator.EncryptionDecorator;
import com.mcalvaro.decorator.HeaderDecorator;
import com.mcalvaro.decorator.WatermarkDecorator;
import com.mcalvaro.delivery.ApiDelivery;
import com.mcalvaro.delivery.EmailDelivery;
import com.mcalvaro.delivery.SharedFolderDelivery;
import com.mcalvaro.processor.BasicProcessor;
import com.mcalvaro.processor.DetailedProcessor;
import com.mcalvaro.processor.EncryptProcessor;
import com.mcalvaro.report.CsvReportCreator;
import com.mcalvaro.report.ExcelReportCreator;
import com.mcalvaro.report.PdfReportCreator;

public class ReportProcessFactory {

    public static ReportProcess createFor(UserType userType) {
        return switch (userType) {
            case EXECUTIVE -> new ExecutiveReportProcess(
                    new BasicProcessor(),
                    new PdfReportCreator(),
                    new EmailDelivery(),
                    List.of(HeaderDecorator::new));
            case AUDITOR -> new AuditorReportProcess(
                    new EncryptProcessor(),
                    new ExcelReportCreator(),
                    new SharedFolderDelivery(),
                    List.of(WatermarkDecorator::new, EncryptionDecorator::new));
            case ANALYST -> new AnalystReportProcess(
                    new DetailedProcessor(),
                    new CsvReportCreator(),
                    new ApiDelivery(),
                    List.of(HeaderDecorator::new, CompressionDecorator::new));
        };
    }
}
