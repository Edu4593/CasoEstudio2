import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar elemento.");
            System.out.println("2. Extraer elemento. Se elimina de la cola.");
            System.out.println("3. Obtener el primer elemento de la cola. Se muestra su valor, sin extraerlo.");
            System.out.println("4. Obtener el último elemento de la cola. Se muestra su valor, sin extraerlo.");
            System.out.println("5. Obtener el elemento de la cola en la posición que indique el usuario. Se muestra su valor, sin extraerlo.");
            System.out.println("6. ¿La cola está vacía? En esta opción solo se indica SI o NO.");
            System.out.println("7. Tamaño actual de la cola. Número de elementos.");
            System.out.println("8. Mostrar todos los elementos de la cola. Desde el primer elemento hasta el último.");
            System.out.println("9. Vaciar cola.");
            System.out.println("10. Terminar.");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Error: Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar: ");
                    Object elemento = scanner.nextLine();
                    cola.insertar(elemento);
                    System.out.println("Elemento insertado.");
                    break;
                case 2:
                    Object extraido = cola.extraer();
                    if (extraido != null) {
                        System.out.println("Elemento extraído: " + extraido);
                    } else {
                        System.out.println("Error: La cola está vacía.");
                    }
                    break;
                case 3:
                    Object primero = cola.obtenerPrimero();
                    if (primero != null) {
                        System.out.println("Primer elemento: " + primero);
                    } else {
                        System.out.println("Error: La cola está vacía.");
                    }
                    break;
                case 4:
                    Object ultimo = cola.obtenerUltimo();
                    if (ultimo != null) {
                        System.out.println("Último elemento: " + ultimo);
                    } else {
                        System.out.println("Error: La cola está vacía.");
                    }
                    break;

                case 5:
                    if (cola.estaVacia()) {
                        System.out.println("Error: La cola está vacía. No hay elementos que mostrar.");
                        break;
                    }
                    System.out.print("Ingrese la posición del elemento (1 a " + cola.obtenerTamano() + "): ");
                    try {
                        int posicion = scanner.nextInt();
                        scanner.nextLine();
                        Object elementoPos = cola.obtenerElementoEnPosicion(posicion);

                        if (elementoPos != null) {
                            System.out.println("Elemento en posición " + posicion + ": " + elementoPos);
                        } else {
                            System.out.println("Error: Posición fuera de rango (1-" + cola.obtenerTamano() + ").");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar un número entero válido para la posición.");
                        scanner.nextLine();
                    }
                    break;

                case 6:
                    String estado = cola.estaVacia() ? "SÍ" : "NO";
                    System.out.println("¿La cola está vacía? Respuesta: " + estado);
                    break;

                case 7:
                    int tamano = cola.obtenerTamano();
                    String sufijo = (tamano == 1) ? " elemento." : " elementos.";
                    System.out.println("Tamaño actual de la cola: " + tamano + sufijo);
                    break;

                case 8:
                    System.out.println("Opción 8 (Mostrar todos) pendiente de implementación con el formato solicitado.");
                    // Aquí iría el código de la opción 8
                    break;

                case 9:
                    System.out.println("Opción 9 (Vaciar cola) pendiente de implementación.");
                    // Aquí iría el código de la opción 9
                    break;

                case 10:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}