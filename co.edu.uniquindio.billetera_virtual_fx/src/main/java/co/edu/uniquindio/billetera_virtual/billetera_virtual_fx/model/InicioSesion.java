package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public abstract class InicioSesion {
    private String contrasenia;
    private String email;


    public InicioSesion(String contrasenia, String email) {
        this.contrasenia = contrasenia;
        this.email = email;

    }
    protected InicioSesion() {
    }
    /**
     * Metodo para obtener la contraseña para iniciar sesion
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
     * Metodo para modificar la contraseña para iniciar sesion
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /**
     * Metodo para obtener el email
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * metodo para setear el email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

