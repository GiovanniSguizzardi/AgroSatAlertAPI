package giovanni_565123.agrosatalert.dto.response;

import java.time.LocalDate;

public class AlertaClimaticoResponse {

    private Long id;
    private String tipoAlerta;
    private Integer severidade;
    private Double impactoEstimado;
    private LocalDate dataEvento;
    private String status;
    private Long talhaoId;
    private String talhaoNome;
    private Long sateliteId;
    private String sateliteNome;

    public AlertaClimaticoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTalhaoNome() {
        return talhaoNome;
    }

    public void setTalhaoNome(String talhaoNome) {
        this.talhaoNome = talhaoNome;
    }

    public Long getSateliteId() {
        return sateliteId;
    }

    public void setSateliteId(Long sateliteId) {
        this.sateliteId = sateliteId;
    }

    public String getSateliteNome() {
        return sateliteNome;
    }

    public void setSateliteNome(String sateliteNome) {
        this.sateliteNome = sateliteNome;
    }
}
