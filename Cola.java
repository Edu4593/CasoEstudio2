public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
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