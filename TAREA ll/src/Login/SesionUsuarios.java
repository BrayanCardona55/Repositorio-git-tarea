package Login;
public class SesionUsuarios {
    private static SesionUsuarios instancia;
    private String usuario;
    private String rol;

    // Constructor privado para evitar instanciación desde fuera
    private SesionUsuarios() {}

    // Método para obtener la instancia única de la clase (Singleton)
    public static SesionUsuarios getInstancia() {
        if (instancia == null) {
    instancia = new SesionUsuarios();  // Crea una nueva instancia si no existe
}
return instancia;  // Devuelve la instancia
    }

    // Método para iniciar sesión, guardando el usuario y rol
    public void iniciarSesion(String usuario, String rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    // Metodos para obtener el usuario y rol
    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol;
    }

    // Metodos para establecer el usuario y rol 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}