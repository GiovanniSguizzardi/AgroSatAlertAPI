package giovanni_565123.agrosatalert.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ProdutorRequest {

    @NotBlank(message = "Nome é obrigatorio")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "CPF é obrigatorio")
    @Size(min = 11, max = 14, message = "CPF invalido")
    private String cpf;

    @NotBlank(message = "Email é obrigatorio")
    @Email(message = "Email invalido")
    private String email;

    @NotBlank(message = "Telefone é obrigatorio")
    @Size(min = 10, max = 20, message = "Telefone invalido")
    private String telefone;

    @NotNull(message = "Data de cadastro é obrigatoria")
    @PastOrPresent(message = "Data de cadastro nao pode ser futura")
    private LocalDate dataCadastro;

    public ProdutorRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}