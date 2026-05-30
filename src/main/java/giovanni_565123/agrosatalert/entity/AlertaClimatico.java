package giovanni_565123.agrosatalert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alertas_climaticos")
public class AlertaClimatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_alerta", nullable = false, length = 100)
    private String tipoAlerta;

    @Column(name = "severidade", nullable = false)
    private Integer severidade;

    @Column(name = "impacto_estimado", nullable = false)
    private Double impactoEstimado;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "talhao_id", nullable = false)
    private Talhao talhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satelite_id", nullable = false)
    private Satelite satelite;

    public AlertaClimatico() {
    }

    public AlertaClimatico(String tipoAlerta, Integer severidade, Double impactoEstimado, LocalDate dataEvento,
            String status, Talhao talhao, Satelite satelite) {
        this.tipoAlerta = tipoAlerta;
        this.severidade = severidade;
        this.impactoEstimado = impactoEstimado;
        this.dataEvento = dataEvento;
        this.status = status;
        this.talhao = talhao;
        this.satelite = satelite;
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

    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    public Satelite getSatelite() {
        return satelite;
    }

    public void setSatelite(Satelite satelite) {
        this.satelite = satelite;
    }
}