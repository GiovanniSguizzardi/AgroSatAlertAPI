package giovanni_565123.agrosatalert.dto.response;

import java.time.LocalDate;

public class TalhaoResponse {

    private Long id;
    private String nome;
    private String cultura;
    private Double areaHectares;
    private String localizacao;
    private LocalDate dataCadastro;
    private Long produtorId;
    private String produtorNome;

    public TalhaoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public Double getAreaHectares() {
        return areaHectares;
    }

    public void setAreaHectares(Double areaHectares) {
        this.areaHectares = areaHectares;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getProdutorId() {
        return produtorId;
    }

    public void setProdutorId(Long produtorId) {
        this.produtorId = produtorId;
    }

    public String getProdutorNome() {
        return produtorNome;
    }

    public void setProdutorNome(String produtorNome) {
        this.produtorNome = produtorNome;
    }
}