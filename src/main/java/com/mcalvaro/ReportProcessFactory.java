package com.mcalvaro;

public class ReportProcessFactory {

    public static ReportProcess createFor(UserType userType) {
        return switch (userType) {
            case EXECUTIVE -> new ExecutiveReportProcess();
            case AUDITOR -> new AuditorReportProcess();
            case ANALYST -> new AnalystReportProcess();
        };
    }
}
