package cineapp;

import javax.swing.JOptionPane;

public class CineApp {

    private static String[][] asientos;
    private static String nombrePelicula;

    public static void main(String[] args) {
        asientos = new String[6][6]; // Matriz de 6x6 para los asientos porque si no es demasiado grande
        nombrePelicula = "Kill Bill 2 By Quentin Tarantino"; // Aunque tambien Pulp Fiction es muy buena x si la quiere ver profe

        boolean continuar = true; // Boolean para la ejecucion el menu
        while (continuar) {
            String[] opciones = {"Mostrar asientos y película", "Modificar nombre de la película", "Asignar asiento", "Salir"}; // para las opciones del programa
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "------Menú principal del cine------", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    mostrarAsientos();
                    break;
                case 1:
                    modificarNombrePelicula();
                    break;
                case 2:
                    asignarAsiento();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema");
                    continuar = false; // entonces el bucle del menu se deja de ejecutar y termina el programa 
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void mostrarAsientos() {
        // Etiquetas para las columnas (A a F)
        String columnas = "     A    B    C    D    E    F\n";// etiquetas para las columnas (de la A a F porque es una sala de dimesion 6x6)
        StringBuilder mensaje = new StringBuilder("Asientos del CINE:\n"); // para construir el mensaje con las filas numeradas y las columnas etiquetadas
        for (int i = 0; i < asientos.length; i++) { // recorre filas
            mensaje.append(i + 1).append(" "); // filas numeradas para mas facil 
            for (int j = 0; j < asientos[i].length; j++) { //recorre columna
                if (asientos[i][j] == null) {
                    mensaje.append(" [ ] "); // asiento vacío y ademas los espacios es para que se vea mejor 
                } else {
                    mensaje.append(" [X] "); // asiento ocupado
                }
                mensaje.append(" ");
            }
            mensaje.append("\n");
        }
        mensaje.append(columnas); // agregar las etiquetas de las columnas igual para mejor visualizacion
        mensaje.append("Película: ").append(nombrePelicula);
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private static void modificarNombrePelicula() {
        nombrePelicula = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la película:");
        JOptionPane.showMessageDialog(null, "Nombre de la película modificado exitosamente.");
    }

    private static void asignarAsiento() {
        int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila del asiento (1-6):")) - 1; // se le resta 1 pq la matriz empieza con 0 
        int columna = JOptionPane.showInputDialog(null, "Ingrese la columna del asiento (A-F):").toUpperCase().charAt(0) - 'A'; // 

        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna] == null) { // primero ve si hay asientos disponibles
                asientos[fila][columna] = "X"; // marcar el asiento como ocupado asi mas facil
                JOptionPane.showMessageDialog(null, "Asiento asignado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El asiento seleccionado ya está ocupado."); // si esta ocupado entonces no se añade nada
            }
        } else {
            JOptionPane.showMessageDialog(null, "El asiento seleccionado no existe."); // por si acaso
        }
    }
}
