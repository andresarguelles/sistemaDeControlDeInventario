import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Libro> libros = new ArrayList<>();
    public static List<Venta> ventas = new ArrayList<>();
    public static final int porcentajeDeGanancia = 20;
    public static double ganancias = 0;
    public static double totalEnCuenta = 0;

    public static void consultarInventario(){
        System.out.println();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static void registrarVenta(Libro libro, int cantidad){
        ganancias += (libro.getPrecio()*((double)porcentajeDeGanancia)/100)* cantidad;
        totalEnCuenta += libro.getPrecio()*cantidad;
        ventas.add(new Venta(ventas.size()+1, libro, cantidad));
    }

    public static void comprarLibro(){
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese el id del libro:");
        int id = scanner.nextInt();
        System.out.print("Ingrese la cantidad de libros a comprar: ");
        int cantidadDeLibros = scanner.nextInt();
        Libro libro = libros.get(id - 1);

        if(libro.comprarLibro(cantidadDeLibros)){
            System.out.println("Tu compra ha sido exitosa");
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Cantidad: " + cantidadDeLibros);
            System.out.println("Total a pagar: " + libro.getPrecio() * cantidadDeLibros);
            registrarVenta(libro, cantidadDeLibros);
        } else {
            System.out.println("Error: No hay inventario disponible");
        }
    }

    public static void buscarLibro(){
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        for (Libro libro : libros) {
            if(libro.getTitulo().equals(titulo)){
                System.out.println(libro);
            }
        }
    }

    public static void agregarLibro(){
        Scanner scanner = new java.util.Scanner(System.in);
        scanner.nextLine();
        System.out.println("Inrgesa el titulo del libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.println("Ingresa el año de publicacion del libro: ");
        String publicacionAnio = scanner.nextLine();
        System.out.println("Ingresa la categoria del libro: ");
        String categoria = scanner.nextLine();
        System.out.println("Ingresa el inventario del libro: ");
        int inventario = scanner.nextInt();
        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();
        libros.add(new Libro(libros.size() + 1, titulo, autor, publicacionAnio, categoria, inventario, precio));
    }

    public static void mostrarVentas(){
        for (Venta venta : ventas) {
            System.out.println(venta);
        }
    }

    public static void mostrarMenu(){
        int opcion;
        System.out.println("\n\tBienvenido a MiGestorDeLibros");

        do {
            System.out.println("\nTotal en cuenta: " + totalEnCuenta);
            System.out.println("Ganancias: " + ganancias + "\n");

            System.out.println("1. Consultar inventario");
            System.out.println("2. Buscar libro por titulo");
            System.out.println("3. Comprar libro por id");
            System.out.println("4. Agregar libro");
            System.out.println("5. Mostrar ventas");
            System.out.println("6. Salir\n");
            System.out.print("Seleccione una opcion: ");

            Scanner scanner = new java.util.Scanner(System.in);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarInventario();
                    break;
                case 2:
                    buscarLibro();
                    break;
                case 3:
                    comprarLibro();
                    break;
                case 4:
                    agregarLibro();
                    break;
                case 5:
                    mostrarVentas();
                    break;
                case 6:
                    System.out.println("Gracias por usar MiGestorDeLibros");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while(opcion != 6);
    }

    public static void main(String[] args) {
        libros.add(new Libro(1, "El Gran Gatsby", "F.Scott Fitzgerald", "1925", "Ficcion", 20, 15.99));
        libros.add(new Libro(2, "Cosmos", "Carl Sagan", "1980", "Ciencia", 10, 19.99));

        mostrarMenu();
    }




}