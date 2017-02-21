package tienda;

import java.io.*;
import java.util.*;

/**
 * Clase que lleva el control de Archivos.
 * 
 * @author Andy Alduccin
 * @version 0.1
 */
public class ArchivoObjeto{
  
  private FileOutputStream salida;
  private ObjectOutputStream salida2;
  private FileInputStream entrada1;
  private ObjectInputStream entrada2;
  

  public ArchivoObjeto() {
    salida = null;
    salida2 = null;
    entrada1 = null;
    entrada2 = null;
  }

  public void guardar(List productos) {
    try {
      salida = new FileOutputStream("Ferreteria");
      salida2 = new ObjectOutputStream(salida);
      salida2.writeObject(productos);
      salida2.close();
      salida.close();
      System.out.println("Productos guardado");
    } catch(FileNotFoundException e) {
      System.out.println("error: " + e.getLocalizedMessage());
    } catch(IOException e) {
      System.out.println("error: " + e.getLocalizedMessage());
    }
  }
  

  public List cargar() {
    List productos = null;
    try {
      entrada1 = new FileInputStream("Ferreteria");
      entrada2 = new ObjectInputStream(entrada1);
      productos = (List) entrada2.readObject();
      entrada2.close();
      entrada1.close();
    } catch(FileNotFoundException e) {
      System.out.println("error: " + e.getLocalizedMessage());
    } catch(IOException | ClassNotFoundException e) {
      System.out.println("error: " + e.getLocalizedMessage());
    }
    return productos;
  }
}
