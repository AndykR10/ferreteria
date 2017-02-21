package tienda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que lleva el control de inventario sobre los productos y sus operaciones.
 * 
 * @author Andy Alducin
 * @version 0.1
 */
public class Inventario {
  
  private List<Producto> productos;
  private final Teclado teclado;
  private final ArchivoObjeto archivo;
  
  public Inventario() {
    productos = new ArrayList<>();
    teclado = new Teclado();
    archivo = new ArchivoObjeto();
  }
  

  public void agregarProducto() {
    System.out.print("Clave: #");
    int clave = teclado.leerEntero();
    if (existeProducto(clave)) {
      System.out.println("El producto ya existe en el inventario.");
      return;
    }
    System.out.print("Nombre: ");
    String nombre = teclado.leerCadena();
    System.out.print("Descripcion: ");
    String descripcion = teclado.leerCadena();
    System.out.print("Precio de compra: $");
    double precioCompra = teclado.leerDouble();
    System.out.print("Existencias: ");
    int existencias = teclado.leerEntero();
    System.out.print("Unidad: ");
    String unidad = teclado.leerCadena();
    productos.add(new Producto(clave, nombre, descripcion, precioCompra, existencias, unidad));
  }
  

  public void eliminarProducto() {
    System.out.print("Clave: #");
    int clave = teclado.leerEntero();
    Iterator<Producto> it = productos.iterator();
    while(it.hasNext()) {
      if (it.next().getClave() == clave) {
        it.remove();
        System.out.println("Producto eliminado del inventario exitosamente.");
        return;
      }
    }
    System.out.println("El producto no existe en el inventario.");
  }
  

  public void venderProducto(){
    System.out.println("Clave del producto que desea vender: #");
    int clave = teclado.leerEntero();
    Iterator<Producto> it = productos.iterator();
    while(it.hasNext()){
      Producto producto = it.next();
        if (it.next().getClave() == clave){
          double precioVenta;
          double aux;
          precioVenta = producto.getPrecioCompra();
          aux = precioVenta/2;
          precioVenta=precioVenta+aux;
          System.out.println("El producto cuesta: "+ precioVenta);
          System.out.println("Desea comprarlo? 1.Si       2.No");
          int desicion = teclado.leerEntero();
            if(desicion == 1){
              it.remove();
              System.out.println("Compra exitosa");
              
            }
        }else System.out.println("No esiste el producto");
        
    }

  }
  
  
  public void editarProducto() {
    System.out.print("Clave: #");
    int clave = teclado.leerEntero();
    Iterator<Producto> it = productos.iterator();
    while(it.hasNext()) {
      Producto producto = it.next();
      if (producto.getClave() == clave) {
        System.out.print("Nombre [" + producto.getNombre() + "]: ");
        String nombre = teclado.leerCadena();
        if (!"".equals(nombre)) {
          producto.setNombre(nombre);
        }
        System.out.print("Descripcion [" + producto.getDescripcion()+ "]: ");
        String descripcion = teclado.leerCadena();
        if (!"".equals(descripcion)) {
          producto.setDescripcion(descripcion);
        }
        System.out.print("Precio de compra [$" + producto.getPrecioCompra()+ "]: ");
        double precioCompra = teclado.leerDouble();
        if (precioCompra != 0) {
          producto.setPrecioCompra(precioCompra);
        }
        System.out.print("Existencias [" + producto.getExistencias()+ "]: ");
        int existencias = teclado.leerEntero();
        if (existencias != 0) {
          producto.setExistencias(existencias);
        }
        System.out.print("Unidad [" + producto.getTipoUnidad()+ "]: ");
        String unidad = teclado.leerCadena();
        if (!"".equals(unidad)) {
          producto.setTipoUnidad(unidad);
        }
        return;
      }
    }
    System.out.println("El producto no existe en el inventario.");
  }
  

  public void buscarProducto(int tipo) {
    switch(tipo) {
      case 1:
        buscarProductoClave();
        break;
      case 2:
        buscarProductoNombre();
        break;
      case 3:
        buscarProductoDescripcion();
        break;
      default:
        System.out.println("Opcion invalida.");
        break;
    }
  }
  
  
  private void buscarProductoClave() {
    System.out.print("Clave: #");
    int clave = teclado.leerEntero();
    for (Producto producto : productos) {
      if (producto.getClave() == clave) {
        mostrarProducto(producto);
        return;
      }
    }
    System.out.println("No existe producto con tal clave en el inventario.");
  }
  
  
  private void buscarProductoNombre() {
    System.out.print("Nombre: ");
    String nombre = teclado.leerCadena();
    for (Producto producto : productos) {
      if (producto.getNombre().equals(nombre)) {
        mostrarProducto(producto);
        return;
      }
    }
    System.out.println("No existe producto con tal nombre en el inventario.");
  }
  

  private void buscarProductoDescripcion() {
    System.out.print("Descripcion: ");
    String descripcion = teclado.leerCadena();
    for (Producto producto : productos) {
      if (producto.getDescripcion().equals(descripcion)) {
        mostrarProducto(producto);
        return;
      }
    }
    System.out.println("No existe producto con tal descripcion en el inventario.");
  }
  

  private void mostrarProducto(Producto producto) {
    System.out.println("Clave: #" + producto.getClave());
    System.out.println("Nombre: " + producto.getNombre());
    System.out.println("Descripcion: " + producto.getDescripcion());
    System.out.println("Precio de compra: $" + producto.getPrecioCompra());
    System.out.println("Existencias: " + producto.getExistencias());
    System.out.println("Unidad: " + producto.getTipoUnidad());
  }
  

  private boolean existeProducto(int clave) {
    for (Producto producto : productos) {
      if (producto.getClave() == clave) {
        return true;
      }
    }
    return false;
  }
  

  public void calcularCostoInventario() {
    int numProductos = 0;
    int numExistencias = 0;
    double costos = 0;
    for (Producto producto : productos) {
      numProductos++;
      numExistencias += producto.getExistencias();
      costos += producto.getPrecioCompra();
    }
    System.out.println("En el inventario tiene:");
    System.out.println("***** " + numProductos + " productos diferentes *****");
    System.out.println("de los cuales se tiene " + numExistencias + " existencias");
    System.out.println("con un valor de $" + costos + " en total.");
  }
  

  public void guardarProductos() {
    archivo.guardar(productos);
  }
  
  public void cargarProductos() {
    List productosArchivo = archivo.cargar();
    if (productosArchivo != null) {
      productos = productosArchivo;
      System.out.println("Productos cargados correctamente.");
    }
  }
}
