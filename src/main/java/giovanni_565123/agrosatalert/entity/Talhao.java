package giovanni_565123.agrosatalert.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "talhoes")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtor_id", nullable = false)
    private Produtor produtor;

    @OneToMany(mappedBy = "talhao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlertaClimatico> alertas;

    public Talhao() {
    }

    public Talhao(String nome, String cultura, Double areaHectares, String localizacao, LocalDate dataCadastro,
            Produtor produtor) {
        this.nome = nome;
        this.cultura = cultura;
        this.areaHectares = areaHectares;
        this.localizacao = localizacao;
        this.dataCadastro = dataCadastro;
        this.produtor = produtor;
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

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public List<AlertaClimatico> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaClimatico> alertas) {
        this.alertas = alertas;
    }
}