package com.mcalvaro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import com.mcalvaro.decorator.*;
import com.mcalvaro.delivery.*;
import com.mcalvaro.processor.*;
import com.mcalvaro.report.*;

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

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== FinanTech Report System ===");
            System.out.println("1. Generar Reporte de Ejecutivo");
            System.out.println("2. Generar Reporte de Auditor");
            System.out.println("3. Generar Reporte de Analista");
            System.out.println("4. Crear Reporte Personalizado (Custom)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.println("\n=== Executive Report ===");
                    ReportProcessFactory.createFor(UserType.EXECUTIVE).execute(rawData);
                }
                case "2" -> {
                    System.out.println("\n=== Auditor Report ===");
                    ReportProcessFactory.createFor(UserType.AUDITOR).execute(rawData);
                }
                case "3" -> {
                    System.out.println("\n=== Analyst Report ===");
                    ReportProcessFactory.createFor(UserType.ANALYST).execute(rawData);
                }
                case "4" -> ejecutarReporteCustom(scanner, rawData);
                case "5" -> salir = true;
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }
        scanner.close();
        System.out.println("Saliendo del sistema...");
    }

    private static void ejecutarReporteCustom(Scanner scanner, String rawData) {
        System.out.println("\n--- Configurando Reporte Personalizado ---");

        System.out.print("Formato (1.PDF, 2.Excel, 3.CSV): ");
        String formatOpt = scanner.nextLine();
        ReportFactory factory = switch (formatOpt) {
            case "2" -> new ExcelReportCreator();
            case "3" -> new CsvReportCreator();
            default -> new PdfReportCreator();
        };

        System.out.print("Procesamiento (1.Básico, 2.Detallado, 3.Encriptado): ");
        String procOpt = scanner.nextLine();
        Processor processor = switch (procOpt) {
            case "2" -> new DetailedProcessor();
            case "3" -> new EncryptProcessor();
            default -> new BasicProcessor();
        };

        System.out.print("Decoradores (separados por coma, ej: 1,3 | 1.Header, 2.Watermark, 3.Encrypt, 4.Compress, 0.Ninguno): ");
        String decOpt = scanner.nextLine();
        List<Function<Report, Report>> decorators = new ArrayList<>();
        if (!decOpt.trim().equals("0") && !decOpt.trim().isEmpty()) {
            String[] tokens = decOpt.split(",");
            for (String token : tokens) {
                switch (token.trim()) {
                    case "1" -> decorators.add(HeaderDecorator::new);
                    case "2" -> decorators.add(WatermarkDecorator::new);
                    case "3" -> decorators.add(EncryptionDecorator::new);
                    case "4" -> decorators.add(CompressionDecorator::new);
                }
            }
        }

        System.out.print("Canal (1.Email, 2.Carpeta compartida, 3.API): ");
        String delOpt = scanner.nextLine();
        Deliverable delivery = switch (delOpt) {
            case "2" -> new SharedFolderDelivery();
            case "3" -> new ApiDelivery();
            default -> new EmailDelivery();
        };

        System.out.println("\n=== Custom Report ===");
        ReportProcess customProcess = new CustomReportProcess(processor, factory, delivery, decorators);
        customProcess.execute(rawData);
    }
}
