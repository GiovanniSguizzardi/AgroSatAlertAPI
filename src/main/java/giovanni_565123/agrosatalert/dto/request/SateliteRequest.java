package giovanni_565123.agrosatalert.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class SateliteRequest {

    @NotBlank(message = "Nome é obrigatorio")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Agencia é obrigatoria")
    @Size(min = 2, max = 100, message = "Agencia deve ter entre 2 e 100 caracteres")
    private String agencia;

    @NotNull(message = "Altitude é obrigatoria")
    @Positive(message = "Altitude deve ser maior que zero")
    private Double altitudeKm;

    @NotNull(message = "Data de lancamento é obrigatoria")
    @PastOrPresent(message = "Data de lancamento nao pode ser futura")
    private LocalDate dataLancamento;

    @NotBlank(message = "Status operacional é obrigatorio")
    @Size(min = 2, max = 50, message = "Status deve ter entre 2 e 50 caracteres")
    private String statusOperacional;

    public SateliteRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getAltitudeKm() {
        return altitudeKm;
    }

    public void setAltitudeKm(Double altitudeKm) {
        this.altitudeKm = altitudeKm;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getStatusOperacional() {
        return statusOperacional;
    }

    public void setStatusOperacional(String statusOperacional) {
        this.statusOperacional = statusOperacional;
    }
}
