//Josue Alejandro Yaquian Sarceño   3190-22-7332
import io.reactivex.rxjava3.core.Observable;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int start = Integer.parseInt(validarEntrada("Ingrese el valor de inicio: ",1,255));
        int n = Integer.parseInt(validarEntrada("Ingrese la cantidad: ", 1, 255));

        asciiTable(start, n).subscribe(
            pair -> System.out.println("ASCII: " + pair[0] + ", Carácter: " + (char)(int)pair[1]),
            Throwable::printStackTrace,
            () -> System.out.println("Tabla completada.")
        );
    }

    public static String validarEntrada(String mensaje, int min, int max) {
        String entrada;
        int valor;

        do {
            entrada = JOptionPane.showInputDialog(mensaje);
            try {
                valor = Integer.parseInt(entrada);
                if (valor < min || valor > max) {
                    JOptionPane.showMessageDialog(null, "Error: el valor debe estar entre " + min + " y " + max);
                } else {
                    return entrada;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: entrada no válida");
            }
        } while (true);
    }

    public static Observable<Integer[]> asciiTable(int start, int n) {
        return Observable.range(start, n)
            .map(value -> new Integer[]{value, value})
            .takeWhile(pair -> pair[0] <= 255);
    }
}
