import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Libro> libros = inicializarLibros();
        Pedido pedido = null;
        CarritoDeCompra carrito = new CarritoDeCompra(new ArrayList<>(), 0.0);

        while (true) {
            System.out.println("Tienda de libros online");
            System.out.println("1. Mostrar lista de libros disponibles");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Ver carrito de compra");
            System.out.println("4. Realizar pedido");
            System.out.println("5. Modificar cantidad de libros en el carrito");
            System.out.println("6. Eliminar libro del carrito");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarLibros(libros);
                    break;
                case 2:
                    buscarLibroPorTitulo(scanner, libros);
                    break;
                case 3:
                    mostrarCarrito(carrito);
                    break;
                case 4:
                    realizarPedido(scanner, libros, carrito);
                    break;
                case 5:
                    modificarCantidadLibro(scanner, carrito);
                    break;
                case 6:
                    eliminarLibro(carrito);
                    break;
                case 7:
                    System.out.println("Gracias por visitarnos!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static List<Libro> inicializarLibros() {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Ficción", 20.0);
        Libro libro2 = new Libro("1984", "George Orwell", "Ciencia ficción", 15.0);
        Libro libro3 = new Libro("El principito", "Antonie S.", "Infantil", 12.0);

        List<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        return libros;
    }

    private static void mostrarLibros(List<Libro> libros) {
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private static void buscarLibroPorTitulo(Scanner scanner, List<Libro> libros) {
        System.out.print("Introduzca el título del libro a buscar: ");
        scanner.nextLine();
        String titulo = scanner.nextLine();
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) { //Verifica si el título del libro es igual al título buscado
                System.out.println("Libro encontrado:");
                System.out.println(libro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void mostrarCarrito(CarritoDeCompra carrito) {
        System.out.println("Libros en el carrito:");
        List<Libro> librosEnCarrito = carrito.getLibros();
        for (Libro libro : librosEnCarrito) {
            System.out.println(libro);
        }
        System.out.println("Precio total del carrito: " + carrito.calcularPrecioTotal());
    }

    private static void realizarPedido(Scanner scanner, List<Libro> libros, CarritoDeCompra carrito) {
        mostrarLibros(libros);
        System.out.println("Seleccione los libros que desea añadir al carrito (introduzca el número de libro): ");
        System.out.println("Ingrese 0 para terminar la selección.");

        while (true) {
            System.out.print("Libro seleccionado: ");
            int seleccion = scanner.nextInt();

            if (seleccion == 0) {
                break;
            } else if (seleccion < 1 || seleccion > libros.size()) {
                System.out.println("Número de libro no válido. Por favor, seleccione un número válido.");
            } else {
                Libro libroSeleccionado = libros.get(seleccion - 1);
                carrito.agregarLibro(libroSeleccionado);
                System.out.println("Libro '" + libroSeleccionado.getTitulo() + "' añadido al carrito.");
            }
        }

        System.out.println("Pedido realizado correctamente.");
    }

    private static void modificarCantidadLibro(Scanner scanner, CarritoDeCompra carrito) {
        System.out.println("Libros en el carrito:");
        mostrarCarrito(carrito);

        System.out.print("Introduzca el título del libro que desea modificar: ");
        scanner.nextLine();
        String titulo = scanner.nextLine();

        System.out.print("Introduzca la nueva cantidad: ");
        int cantidad = scanner.nextInt();

        for (Libro libro : carrito.getLibros()) {
            if (libro.getTitulo().equals(titulo)) {
                carrito.modificarCantidadLibro(libro, cantidad);
                System.out.println("Cantidad modificada correctamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado en el carrito.");
    }

    private static void eliminarLibro(CarritoDeCompra carrito) {
        System.out.println("Libros en el carrito:");
        mostrarCarrito(carrito);

        System.out.print("Introduzca el título del libro que desea eliminar: ");
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.nextLine();

        for (Libro libro : carrito.getLibros()) {
            if (libro.getTitulo().equals(titulo)) {
                carrito.eliminarLibro(libro);
                System.out.println("Libro eliminado del carrito.");
                return;
            }
        }
        System.out.println("Libro no encontrado en el carrito.");
    }
}
