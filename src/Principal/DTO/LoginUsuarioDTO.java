
package Principal.DTO;


public class LoginUsuarioDTO {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public int getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(int login) {
        this.login = login;
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    private int id;
    private int login;
    private int usuario;
}
