import javax.swing.JOptionPane;

public class Practica3Semana10 {
    private String nombre;
    private String pastor;
    private int numFeligreses;
    private Feligres[] feligreses;

    // Construcctor para inicializar los datos de la iglesia
    public Practica3Semana10(String nombre, String pastor, int numFeligreses) {
        this.nombre = nombre;
        this.pastor = pastor;
        this.numFeligreses = numFeligreses;
        this.feligreses = new Feligres[numFeligreses];
    }

    // Metodo para agregar feligresess a la iglesia
    public void agregarFeligres(int i, String nombre, String cedula, double diezmo) {
        this.feligreses[i] = new Feligres(nombre, cedula, diezmo);
    }

    // Metodos para calcular diferentes montos
    public double calcularMontoTotal() {
        double montoTotal = 0;
        for (int i = 0; i < this.numFeligreses; i++) {
            montoTotal += this.feligreses[i].getDiezmo();
        }
        return montoTotal;
    }

    public double calcularMontoMunicipalidad() {
        return this.calcularMontoTotal() * 0.09;
    }

    public double calcularMontoComedor() {
        return this.calcularMontoTotal() * 0.21;
    }

    public double calcularMontoPastor() {
        return this.calcularMontoTotal() * 0.7;
    }

    // Metodos para alistar a los feligresses
    public String listarFeligresesConDiezmoCero() {
        String lista = "";
        for (int i = 0; i < this.numFeligreses; i++) {
            if (this.feligreses[i].getDiezmo() == 0) {
                lista += this.feligreses[i].getNombre() + " - " + this.feligreses[i].getCedula() + "\n";
            }
        }
        return lista;
    }

    public String listarFeligresesConDiezmoMayorACienMil() {
        String lista = "";
        for (int i = 0; i < this.numFeligreses; i++) {
            if (this.feligreses[i].getDiezmo() > 100000) {
                lista += this.feligreses[i].getNombre() + " - " + this.feligreses[i].getCedula() + "\n";
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        String nombreIglesia = JOptionPane.showInputDialog("Ingrese el nombre de la iglesia:");
        String nombrePastor = JOptionPane.showInputDialog("Ingrese el nombre del pastor:");
        int numFeligreses = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de feligreses:"));

        Practica3Semana10 iglesia = new Practica3Semana10(nombreIglesia, nombrePastor, numFeligreses);

        for (int i = 0; i < numFeligreses; i++) {
            String nombreFeligres = JOptionPane.showInputDialog("Ingrese el nombre del feligrés " + (i + 1) + ":");
            String cedulaFeligres = JOptionPane.showInputDialog("Ingrese la cédula del feligrés " + (i + 1) + ":");
            double diezmoFeligres = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el diezmo del feligrés " + (i + 1) + ":"));
            iglesia.agregarFeligres(i, nombreFeligres, cedulaFeligres, diezmoFeligres);
        }

        String informe = "Informe de la iglesia " + iglesia.nombre + ":\n\n";
        informe += "Monto total de ganancias de la iglesia: " + iglesia.calcularMontoTotal() + "\n";
        informe += "Monto para la municipalidad infraestructura: " + iglesia.calcularMontoMunicipalidad() + "\n";
        informe += "Monto para el comedor municipal: " + iglesia.calcularMontoComedor() + "\n";
        informe += "Monto de ganancia para el pastor: " + iglesia.calcularMontoPastor() + "\n";

        // print  el resultadoi
        JOptionPane.showMessageDialog(null, informe);
    }
}
