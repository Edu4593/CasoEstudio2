import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Extraer elemento");
            System.out.println("3. Obtener el primer elemento de la cola");
            System.out.println("4. Obtener el último elemento de la cola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar: ");
                    Object elemento = scanner.next();
                    cola.insertar(elemento);
                    System.out.println("Elemento insertado.");
                    cola.mostrar();
                    break;
                case 2:
                    Object extraido = cola.extraer();
                    if (extraido != null) {
                        System.out.println("Elemento extraído: " + extraido);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    cola.mostrar();
                    break;
                case 3:
                    Object primero = cola.obtenerPrimero();
                    if (primero != null) {
                        System.out.println("Primer elemento: " + primero);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 4:
                    Object ultimo = cola.obtenerUltimo();
                    if (ultimo != null) {
                        System.out.println("Último elemento: " + ultimo);
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}