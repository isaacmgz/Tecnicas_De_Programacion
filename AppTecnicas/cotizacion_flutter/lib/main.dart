import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

/// Clase principal que configura la aplicación.
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Cotización de Consultoría',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const CotizacionScreen(),
    );
  }
}

/// Pantalla principal de la aplicación donde se ingresan los datos y se muestra el resultado.
class CotizacionScreen extends StatefulWidget {
  const CotizacionScreen({super.key});

  @override
  State<CotizacionScreen> createState() => _CotizacionScreenState();
}

class _CotizacionScreenState extends State<CotizacionScreen> {
  final clienteController =
      TextEditingController(); // Controlador para el campo de texto del nombre del cliente.
  final tarifaController =
      TextEditingController(); // Controlador para el campo de texto de la tarifa por hora.
  final horasController =
      TextEditingController(); // Controlador para el campo de texto de las horas trabajadas.
  final infraestructuraController =
      TextEditingController(); // Controlador para el campo de texto del costo de infraestructura.
  final viaticosController =
      TextEditingController(); // Controlador para el campo de texto del costo de viáticos.
  final gastosController =
      TextEditingController(); // Controlador para el campo de texto de otros gastos.

  String resultado = "";

  /// Método que realiza el cálculo del costo de la consultoría basado en las fórmulas proporcionadas y actualiza el estado con el resultado.
  void calcularCotizacion() {
    String cliente = clienteController.text;
    double tarifa = double.tryParse(tarifaController.text) ?? 0;
    int horas = int.tryParse(horasController.text) ?? 0;
    double infraestructura =
        double.tryParse(infraestructuraController.text) ?? 0;
    double viaticos = double.tryParse(viaticosController.text) ?? 0;
    double gastos = double.tryParse(gastosController.text) ?? 0;

    Consultoria consultoria = Consultoria(
      cliente,
      tarifa,
      horas,
      infraestructura,
      viaticos,
      gastos,
    );

    setState(() {
      resultado = consultoria.mostrarDetalles();
    });
  }

  /// Método que construye un campo de texto con una etiqueta y un controlador.
  Widget buildTextField(String label, TextEditingController controller) {
    return TextField(
      controller: controller,
      decoration: InputDecoration(labelText: label),
      keyboardType: TextInputType.number,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Cotización de Consultoría')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: clienteController,
              decoration: const InputDecoration(labelText: 'Cliente'),
            ),
            buildTextField('Tarifa por Hora', tarifaController),
            buildTextField('Horas Trabajadas', horasController),
            buildTextField('Costo Infraestructura', infraestructuraController),
            buildTextField('Viáticos', viaticosController),
            buildTextField('Otros Gastos', gastosController),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: calcularCotizacion,
              child: const Text('Calcular Cotización'),
            ),
            const SizedBox(height: 20),
            Text(resultado, style: const TextStyle(fontSize: 16)),
          ],
        ),
      ),
    );
  }
}

/// Clase que representa una consultoría con atributos como cliente, tarifa por hora, horas trabajadas, infraestructura, viáticos y otros gastos.
class Consultoria {
  String cliente;
  double tarifaPorHora;
  int horasTrabajadas;
  double infraestructura;
  double viaticos;
  double gastos;

  Consultoria(
    this.cliente,
    this.tarifaPorHora,
    this.horasTrabajadas,
    this.infraestructura,
    this.viaticos,
    this.gastos,
  );

  /// Cálculo del costo base
  double calcularCostoBase() =>
      (tarifaPorHora * horasTrabajadas) + infraestructura + viaticos + gastos;

  /// Cálculo del riesgo
  double calcularRiesgo() => calcularCostoBase() * 0.10;

  /// Cálculo de la retención en la fuente
  double retencionFuente() => (calcularCostoBase() + calcularRiesgo()) * 0.11;

  /// Cálculo de la retención de impuestos
  double retencionImpuestos() => (retencionFuente() * 0.01);

  /// Cálculo de los impuestos totales
  double calcularImpuestos() =>
      (calcularCostoBase() + calcularRiesgo()) * 0.19 +
      retencionFuente() +
      retencionImpuestos();

  /// Cálculo del costo total
  double calcularTotal() =>
      calcularCostoBase() + calcularRiesgo() + calcularImpuestos();

  /// Conversión a JSON
  Map<String, dynamic> toJson() {
    return {
      'cliente': cliente,
      'tarifaPorHora': tarifaPorHora,
      'horasTrabajadas': horasTrabajadas,
      'infraestructura': infraestructura,
      'viaticos': viaticos,
      'gastos': gastos,
      'costoBase': calcularCostoBase(),
      'riesgo': calcularRiesgo(),
      'impuestos': calcularImpuestos(),
      'costoTotal': calcularTotal(),
    };
  }

  /// Mostrar detalles
  String mostrarDetalles() {
    Map<String, dynamic> datos = toJson();

    return "📌 Cotización de Consultoría\n\n" +
        "Cliente: ${datos['cliente']}\n" +
        "Tarifa por Hora: \$${datos['tarifaPorHora']}\n" +
        "Horas Trabajadas: ${datos['horasTrabajadas']}\n" +
        "Infraestructura: \$${datos['infraestructura']}\n" +
        "Viáticos: \$${datos['viaticos']}\n" +
        "Otros Gastos: \$${datos['gastos']}\n" +
        "Costo Base: \$${datos['costoBase']}\n" +
        "Riesgo (10%): \$${datos['riesgo']}\n" +
        "Impuestos: \$${datos['impuestos']}\n" +
        "💰 Costo Total: \$${datos['costoTotal']}";
  }
}
