package giovanni_565123.agrosatalert.dto.response;

import java.time.LocalDate;

public class SateliteResponse {

    private Long id;
    private String nome;
    private String agencia;
    private Double altitudeKm;
    private LocalDate dataLancamento;
    private String statusOperacional;

    public SateliteResponse() {
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
