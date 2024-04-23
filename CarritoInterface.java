import java.util.List;
interface CarritoInterface {
    //Método para agregar un libro al carrito
    void agregarLibro(Libro libro);

    //Método para modificar la cantidad de un libro
    //Puede lanzar una excepción SinLibros si la cantidad es inválida
    void modificarCantidadLibro(Libro libro, int cantidad) throws CarritoDeCompra.SinLibros;

    //Método para eliminar un libro del carrito
    void eliminarLibro(Libro libro);

    //Método para calcular el precio total de los libros en el carrito
    double calcularPrecioTotal();

    //Método para obtener la lista de libros en el carrito
    List<Libro> getLibros();
}
