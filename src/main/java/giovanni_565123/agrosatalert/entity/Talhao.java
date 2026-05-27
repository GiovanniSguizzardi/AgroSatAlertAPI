package giovanni_565123.agrosatalert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_talhao")
public class Talhao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cultura", nullable = false, length = 100)
    private String cultura;

    @Column(name = "area_hectares", nullable = false)
    private Double areaHectares;

    @Column(name = "localizacao", nullable = false, length = 200)
    private String localizacao;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "talhao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.List<AlertaClimatico> alertas;

    // Construtores
    public Talhao() {
    }

    public Talhao(String nome, String cultura, Double areaHectares, String localizacao, LocalDate dataCadastro) {
        this.nome = nome;
        this.cultura = cultura;
        this.areaHectares = areaHectares;
        this.localizacao = localizacao;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
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

    public java.util.List<AlertaClimatico> getAlertas() {
        return alertas;
    }

    public void setAlertas(java.util.List<AlertaClimatico> alertas) {
        this.alertas = alertas;
    }
}