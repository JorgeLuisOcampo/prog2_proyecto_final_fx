package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.builder;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;

    public Persona(String nombre, String apellidos, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
}
