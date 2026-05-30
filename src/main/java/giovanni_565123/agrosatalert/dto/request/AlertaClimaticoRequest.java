package giovanni_565123.agrosatalert.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AlertaClimaticoRequest {

    @NotBlank(message = "Tipo de alerta é obrigatorio")
    @Size(min = 2, max = 100, message = "Tipo de alerta deve ter entre 2 e 100 caracteres")
    private String tipoAlerta;

    @NotNull(message = "Severidade é obrigatoria")
    @Min(value = 1, message = "Severidade minima é 1")
    @Max(value = 10, message = "Severidade maxima é 10")
    private Integer severidade;

    @NotNull(message = "Impacto estimado é obrigatorio")
    @Positive(message = "Impacto estimado deve ser maior que zero")
    private Double impactoEstimado;

    @NotNull(message = "Data do evento é obrigatoria")
    @PastOrPresent(message = "Data do evento nao pode ser futura")
    private LocalDate dataEvento;

    @NotBlank(message = "Status é obrigatorio")
    @Size(min = 2, max = 50, message = "Status deve ter entre 2 e 50 caracteres")
    private String status;

    @NotNull(message = "ID do talhao é obrigatorio")
    private Long talhaoId;

    @NotNull(message = "ID do satelite é obrigatorio")
    private Long sateliteId;

    public AlertaClimaticoRequest() {
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public Integer getSeveridade() {
        return severidade;
    }

    public void setSeveridade(Integer severidade) {
        this.severidade = severidade;
    }

    public Double getImpactoEstimado() {
        return impactoEstimado;
    }

    public void setImpactoEstimado(Double impactoEstimado) {
        this.impactoEstimado = impactoEstimado;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTalhaoId() {
        return talhaoId;
    }

    public void setTalhaoId(Long talhaoId) {
        this.talhaoId = talhaoId;
    }

    public Long getSateliteId() {
        return sateliteId;
    }

    public void setSateliteId(Long sateliteId) {
        this.sateliteId = sateliteId;
    }
}
