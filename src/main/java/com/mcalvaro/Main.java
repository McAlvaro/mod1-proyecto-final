package com.mcalvaro;

public class Main {
    public static void main(String[] args) {

        String rawData = """
                {
                    "company": "FinanTech Solutions",
                    "period": "2026-Q1",
                    "revenue": 1250000,
                    "expenses": 980000,
                    "profit": 270000,
                    "employees": 150
                }
                """;

        System.out.println("=== Executive Report ===");
        ReportProcess executiveReportProcess = ReportProcessFactory.createFor(UserType.EXECUTIVE);
        executiveReportProcess.execute(rawData);

        System.out.println("\n=== Auditor Report ===");
        ReportProcess auditorReportProcess = ReportProcessFactory.createFor(UserType.AUDITOR);
        auditorReportProcess.execute(rawData);

        System.out.println("\n=== Analyst Report ===");
        ReportProcess analystReportProcess = ReportProcessFactory.createFor(UserType.ANALYST);
        analystReportProcess.execute(rawData);
    }
}
