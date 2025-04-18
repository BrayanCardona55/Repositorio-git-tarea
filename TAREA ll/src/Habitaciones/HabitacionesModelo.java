package Habitaciones;
public class HabitacionesModelo {
    private int id;
    private String nombre;
    private String tipo;
    private double precio;
    private String estado;

    // Constructor con id para casos donde ya existe en la BD
    public HabitacionesModelo(int id, String nombre, String tipo, double precio, String estado) {
        this.id = id;
        this.nombre = nombre != null ? nombre : "";
        this.tipo = tipo != null ? tipo : "";
        this.precio = precio;
        this.estado = estado != null ? estado : "Disponible";  // Valor predeterminado
    }

    // Constructor sin id para nuevos registros
    public HabitacionesModelo(String nombre, String tipo, double precio, String estado) {
        this(0, nombre, tipo, precio, estado); 
    }

    // Constructor vacio para instanciar sin datos iniciales
    public HabitacionesModelo() {
        this.id = 0;
        this.nombre = "";
        this.tipo = "";
        this.precio = 0.0;
        this.estado = "Disponible"; 
    }

    // Validacion de datos
    public boolean esValido() {
        return !nombre.isEmpty() && !tipo.isEmpty() && precio > 0 && esEstadoValido();
    }

    // Metodo para validar si el estado es valido
    private boolean esEstadoValido() {
        return estado.equals("Disponible") || estado.equals("Ocupada") || estado.equals("Mantenimiento");
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre : "";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo != null ? tipo : "";
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio > 0 ? precio : 0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado != null && esEstadoValido()) {
            this.estado = estado;
        }
    }

    // Metodo toString para depuracion
    @Override
    public String toString() {
        return "HabitacionesModelo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }
}