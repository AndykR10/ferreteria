package tienda;

/**
 * Clase principal.
 * 
 * @author Andy Alducin
 * @version 0.1
 */
public class Ferreteria {
 
  public static void main(String[] args) {
    Menu menuPrincipal = new Menu();
    int opcion;
    do {
      menuPrincipal.mostrarMenu();
      opcion = menuPrincipal.leerOpcion();
      menuPrincipal.realizarOperacion(opcion);
    } while (opcion != 0);
  }
}
