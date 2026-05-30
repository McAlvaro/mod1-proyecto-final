package com.mcalvaro;

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
                    new EmailDelivery()
            );
            case AUDITOR -> new AuditorReportProcess(
                    new EncryptProcessor(),
                    new ExcelReportCreator(),
                    new SharedFolderDelivery()
            );
            case ANALYST -> new AnalystReportProcess(
                    new DetailedProcessor(),
                    new CsvReportCreator(),
                    new ApiDelivery()
            );
        };
    }
}
