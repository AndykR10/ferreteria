package tienda;

/**
 * Clase para el manejo de los menús.
 * 
 * @author Andy Alducin
 * @version 0.1
 */
public class Menu {
  
  private final Teclado teclado;
  private final Inventario productos;

  
  public Menu() {
    teclado = new Teclado();
    productos = new Inventario();
  }
  

  public void mostrarMenu() {
    System.out.println("Ferreteria");
    System.out.println("1.- Agregar producto");
    System.out.println("2.- Eliminar producto");
    System.out.println("3.- Editar producto");
    System.out.println("4.- Buscar producto");
    System.out.println("5.- Calcular costo de inventario");
    System.out.println("6.- Guardar productos");
    System.out.println("7.- Cargar productos");
    System.out.println("8.- Vender producto");
    System.out.println("0.- Salir");
  }
  

  private void mostrarMenuBusqueda() {
    System.out.println("Elija una opción:");
    System.out.println("1.- Clave");
    System.out.println("2.- Nombre");
    System.out.println("3.- Descripcion");
  }
  
 
  public int leerOpcion() {
    System.out.print("Elige una opcion: ");
    return teclado.leerEntero();
  }
  
  public void realizarOperacion(int opcion) {
    switch(opcion) {
      case 1:
        productos.agregarProducto();
        break;
      case 2:
        productos.eliminarProducto();
        break;
      case 3:
        productos.editarProducto();
        break;
      case 4:
        mostrarMenuBusqueda();
        productos.buscarProducto(leerOpcion());
        break;
      case 5:
        productos.calcularCostoInventario();
        break;
      case 6:
        productos.guardarProductos();
        break;
      case 7:
        productos.cargarProductos();
        break;
      case 8:
        productos.venderProducto();
        break;
      case 0:
        break;
      default:
        System.out.println("Vuelva a intentarlo");
        break;
    }
  }
}
