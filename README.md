# FinanTech Solutions - Sistema Automático de Reportes

## 1. Descripción del Proyecto

Este proyecto implementa el motor central para la generación, transformación y entrega automática de reportes de indicadores financieros. El diseño está enfocado en la flexibilidad, permitiendo soportar múltiples formatos, niveles de procesamiento y canales de entrega según el perfil del usuario (Ejecutivo, Auditor, Analista).

## 2. Enlace al Repositorio

**GitHub:** [Repo-Proyecto](https://github.com/McAlvaro/mod1-proyecto-final)

## 3. Patrones de Diseño Aplicados y Justificación

Para resolver los requerimientos garantizando un bajo acoplamiento y alta cohesión y permitiendo extender el sistema sin modificar el código existente, se aplicaron los siguientes patrones de diseño:

### 3.1. Strategy (Comportamiento)

- **Dónde se aplica:**
  - Procesamiento de datos: Interfaz `Processor` (con implementaciones `BasicProcessor`, `DetailedProcessor`, `EncryptProcessor`).
  - Canales de entrega: Interfaz `Deliverable` (con implementaciones `EmailDelivery`, `SharedFolderDelivery`, `ApiDelivery`).
- **Justificación:** El requerimiento exigía que las lógicas de procesamiento y los mecanismos de entrega fueran intercambiables según el usuario y sin alterar el flujo principal. Strategy permite encapsular estas familias de algoritmos y pasarlas al contexto de forma polimórfica.

### 3.2. Factory Method (Creacional)

- **Dónde se aplica:** Interfaz `ReportFactory` y sus creadores concretos (`PdfReportCreator`, `ExcelReportCreator`, `CsvReportCreator`), los cuales instancian los productos concretos que implementan la interfaz `Report`.
- **Justificación:** Se necesitaba desacoplar el flujo de orquestación de la instanciación de los formatos de archivo. Usando la variante basada en interfaces del Factory Method, el sistema pide un reporte a la fábrica sin acoplarse a clases concretas como `PdfReport`. Esto permite que el día de mañana se agregue un nuevo formato (ej. `JsonReport`) creando solo su clase y su Factory, sin tocar código central.

### 3.3. Decorator (Estructural)

- **Dónde se aplica:** Clase abstracta `ReportDecorator` y sus especializaciones (`HeaderDecorator`, `WatermarkDecorator`, `EncryptionDecorator`, `CompressionDecorator`).
- **Justificación:** El sistema debía soportar mejoras _opcionales_ y _combinables_ (encabezados, cifrado, etc.). El patrón Decorator permite envolver dinámicamente un objeto `Report` en tiempo de ejecución, agregando o alterando el comportamiento de su método `getContent()` de forma transparente para el consumidor final.

### 3.4. Template Method (Comportamiento)

- **Dónde se aplica:** Clase abstracta `BaseReportProcess` y su método `final void execute(String rawData)`.
- **Justificación:** Garantiza el principio de Responsabilidad Única (SRP) centralizando el esqueleto del algoritmo (procesar → instanciar reporte → aplicar decoradores → entregar) en un solo lugar. Las subclases concretas (`ExecutiveReportProcess`, `AuditorReportProcess`, etc.) no alteran el orden, simplemente reciben mediante inyección de dependencias (DIP) qué estrategias exactas utilizar en ese flujo.

### 3.5. Simple Factory / Inyección de Dependencias

- **Dónde se aplica:** `ReportProcessFactory`.
- **Justificación:** Centraliza la composición de todas las piezas. Es el único lugar del sistema que tiene la responsabilidad de saber qué procesador, qué fábrica, qué decoradores y qué delivery le corresponde a cada tipo de usuario (`UserType`), entregando un `ReportProcess` listo para ser ejecutado.

## 4. Cómo levantar el proyecto

Este proyecto es una aplicación Java gestionada con Maven. Requiere **JDK 21** y **Maven 3.9+**.

### Compilar el código:

```bash
mvn clean compile
```

### Ejecutar la demostración:

El archivo `Main.java` contiene una simulación de los flujos para Ejecutivo, Auditor y Analista usando un JSON de prueba. Para ejecutarlo:

```bash
mvn exec:java -Dexec.mainClass="com.mcalvaro.Main"
```

### Empaquetar (Generar JAR):

```bash
mvn clean package
```

