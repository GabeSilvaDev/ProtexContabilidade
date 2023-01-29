package Principal.DTO;

public class DespezaDTO {

    /**
     * @return the idFeito
     */
    public int getIdFeito() {
        return idFeito;
    }

    /**
     * @param idFeito the idFeito to set
     */
    public void setIdFeito(int idFeito) {
        this.idFeito = idFeito;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

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
     * @return the despeza
     */
    public String getDespeza() {
        return despeza;
    }

    /**
     * @param despeza the despeza to set
     */
    public void setDespeza(String despeza) {
        this.despeza = despeza;
    }

    /**
     * @return the valorGasto
     */
    public double getValorGasto() {
        return valorGasto;
    }

    /**
     * @param valorGasto the valorGasto to set
     */
    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private int id;
    private String despeza;
    private double valorGasto;
    private String descricao;
    private double valorTotal;
    private int idFeito;
}
