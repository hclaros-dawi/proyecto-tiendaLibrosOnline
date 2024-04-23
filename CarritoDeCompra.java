import java.util.List;
import java.util.ArrayList;
public class CarritoDeCompra implements CarritoInterface {
    private List<Libro> libros; //Declara una lista de libros
    private double precioTotal; //Declara el precio de los libros

    //Constructor del objeto CarritoDeCompra, inicializa los valores de
    //sus atributos (libros y precioTotal)
    public CarritoDeCompra(List<Libro> libros, double precioTotal) {
        this.libros = new ArrayList<>(); //Declaro una lista de libros
        this.precioTotal = 0.0;
    }

    //Declara la clase excepción SinLibros
    class SinLibros extends Exception {
        SinLibros(String s){ //Dentro de la clase se define un constructor
            super (s);
        }
    }

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro); //Añade un libro a la lista de ñibros
        precioTotal += libro.getPrecio(); //Guarda el precio del libro en la variable precioTotal
    }
    @Override
    public void modificarCantidadLibro(Libro libro, int cantidad) {
        try {
            if (cantidad <= 0) {
                //Si la cantidad es inválida, lanza la excepción SinLibros con ese mensaje
                throw new SinLibros("La cantidad de libros debe ser mayor que cero");
            }
        } catch (Exception e) {
            //Imprime un mensaje de error de la excepción dada
            System.out.println("Error: " + e.getMessage());
        }
    }
    @Override
    public void eliminarLibro(Libro libro) {
        libros.remove(libro); //Elimina un libro de la lista de libros
        precioTotal -= libro.getPrecio(); //Guarda el precio del libro en la variable precioTotal
    }
    @Override
    public double calcularPrecioTotal() {
        return precioTotal;
    }
    @Override
    public List<Libro> getLibros() {
        //Devuelve la lista de libros actualmente en el carrito
        return libros;
    }
}
