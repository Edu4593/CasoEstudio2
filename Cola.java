public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    // Método para insertar un elemento en la cola
    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        this.tamano++;
    }

    // Método para extraer un elemento de la cola
    public Object extraer() {
        if (frente == null) {
            return null;
        }
        Object dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        this.tamano--;
        return dato;
    }

    // Método para obtener el primer elemento sin extraerlo
    public Object obtenerPrimero() {
        return (frente != null) ? frente.dato : null;
    }

    // Método para obtener el último elemento sin extraerlo
    public Object obtenerUltimo() {
        return (fin != null) ? fin.dato : null;
    }

    // Método para obtener el elemento de la cola en la posición que indique el usuario
    public Object obtenerElementoEnPosicion(int posicion) {
        if (posicion < 1 || posicion > this.tamano) {
            return null;
        }

        Nodo actual = frente;
        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    // ¿La cola está vacía? (Opción 6)
    public boolean estaVacia() {
        return frente == null;
    }

    // Tamaño actual de la cola
    public int obtenerTamano() {
        return this.tamano;
    }

    // Método para mostrar la cola
    public void mostrar() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.print(actual.dato + (actual.siguiente != null ? "-->" : "-->Null"));
            actual = actual.siguiente;
        }
        System.out.println();
    }
}