package giovanni_565123.agrosatalert.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class TalhaoRequest {

    @NotBlank(message = "Nome é obrigatorio")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Cultura é obrigatoria")
    @Size(min = 2, max = 100, message = "Cultura deve ter entre 2 e 100 caracteres")
    private String cultura;

    @NotNull(message = "Area em hectares é obrigatoria")
    @Positive(message = "Area em hectares deve ser maior que zero")
    private Double areaHectares;

    @NotBlank(message = "Localizacao é obrigatoria")
    @Size(min = 2, max = 200, message = "Localizacao deve ter entre 2 e 200 caracteres")
    private String localizacao;

    @NotNull(message = "Data de cadastro é obrigatoria")
    @PastOrPresent(message = "Data de cadastro nao pode ser futura")
    private LocalDate dataCadastro;

    @NotNull(message = "ID do produtor é obrigatorio")
    private Long produtorId;

    public TalhaoRequest() {
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
}