package giovanni_565123.agrosatalert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "satelites")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "agencia", nullable = false, length = 100)
    private String agencia;

    @Column(name = "altitude_km", nullable = false)
    private Double altitudeKm;

    @Column(name = "data_lancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(name = "status_operacional", nullable = false, length = 50)
    private String statusOperacional;

    @OneToMany(mappedBy = "satelite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlertaClimatico> alertas;

    public Satelite() {
    }

    public Satelite(String nome, String agencia, Double altitudeKm, LocalDate dataLancamento,
            String statusOperacional) {
        this.nome = nome;
        this.agencia = agencia;
        this.altitudeKm = altitudeKm;
        this.dataLancamento = dataLancamento;
        this.statusOperacional = statusOperacional;
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

    public List<AlertaClimatico> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaClimatico> alertas) {
        this.alertas = alertas;
    }
}