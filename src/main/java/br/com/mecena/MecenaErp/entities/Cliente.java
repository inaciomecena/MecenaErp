package br.com.mecena.MecenaErp.entities;

import br.com.mecena.MecenaErp.entities.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;


@Entity
@Table(name = "CB_CLIENTE")
public class Cliente {

    @Id
//    AUTO - gerado de forma automatica
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column
    private String email;
    @Column
    private Integer idade;
    @Column
    private Status status;
    @Column
    private String endereco;
    @Column
    private String Cep;
    @Column
    private String celular;
    @Column
    String Numero;
    @Column
    String Bairro;
    @Column
    String Cidade;
    @Column
    String Uf;
    @Column
    private String criadoPeloUsuario;
    @Column
    @CreationTimestamp
    private String criadoDataEHora;
    @Column
    private String editadoPeloUsuario;
    @Column
    @UpdateTimestamp
    private String editadoDataEHora;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String uf) {
        Uf = uf;
    }

    public String getCriadoPeloUsuario() {
        return criadoPeloUsuario;
    }

    public void setCriadoPeloUsuario(String criadoPeloUsuario) {
        this.criadoPeloUsuario = criadoPeloUsuario;
    }

    public String getCriadoDataEHora() {
        return criadoDataEHora;
    }

    public void setCriadoDataEHora(String criadoDataEHora) {
        this.criadoDataEHora = criadoDataEHora;
    }

    public String getEditadoPeloUsuario() {
        return editadoPeloUsuario;
    }

    public void setEditadoPeloUsuario(String editadoPeloUsuario) {
        this.editadoPeloUsuario = editadoPeloUsuario;
    }

    public String getEditadoDataEHora() {
        return editadoDataEHora;
    }

    public void setEditadoDataEHora(String editadoDataEHora) {
        this.editadoDataEHora = editadoDataEHora;
    }
}