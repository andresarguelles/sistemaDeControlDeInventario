public class Libro {
    private final int id;
    private final String titulo;
    private final String autor;
    private final String publicacionAnio;
    private final String categoria;
    private final double precio;
    private int inventario;


    public Libro(int id, String titulo, String autor, String publicacionAnio, String categoria, int inventario, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.publicacionAnio = publicacionAnio;
        this.categoria = categoria;
        this.inventario = inventario;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean comprarLibro(int cantidad){
        if(this.inventario >= cantidad){
            this.inventario-= cantidad;
            return true;
        }
        return false;
    }

   @Override
    public String toString(){
        return "ID: " + this.id + ", " +
                "Titulo: " + this.titulo + ", " +
                "Autor: " + this.autor + ", " +
                "Año de publicacion: " + this.publicacionAnio + ", " +
                "Categoria: " + this.categoria + ", " +
                "Inventario: " + this.inventario + ", " +
                "Precio: " + this.precio;
    }
}
