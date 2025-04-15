package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model;

public abstract class InicioSesion {
    private String contrasenia;
    private String email;
    private String palabraSecreta;

    public InicioSesion(String contrasenia, String email, String palabraSecreta) {
        this.contrasenia = contrasenia;
        this.email = email;
        this.palabraSecreta = palabraSecreta;
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
    /**
     * metodo para obtener la palabra secreta
     * @return
     */
    public String getPalabraSecreta() {return palabraSecreta;}
    /**
     * metodo para setear la palabra secreta
     * @param palabraSecreta
     */
    public void setPalabraSecreta(String palabraSecreta) {this.palabraSecreta = palabraSecreta;}
}

