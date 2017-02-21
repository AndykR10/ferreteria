package tienda;

import java.util.*;

/**
 * Clase que permite capturar la entrada del sistema, por defecto, el teclado.
 *
 * @author Andy Alducin
 * @version 0.1
 */
public class Teclado {

  private final Scanner sc;


  public Teclado() {
    sc = new Scanner(System.in);
  }

  
  public int leerEntero() {
    int entero = sc.nextInt();
    sc.nextLine();
    return entero;
  }


  public double leerDouble() {
    return sc.nextDouble();
  }
  

  public String leerCadena() {
    return sc.nextLine();
  }
}
