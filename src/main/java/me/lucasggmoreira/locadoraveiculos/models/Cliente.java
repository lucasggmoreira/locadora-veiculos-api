package me.lucasggmoreira.locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.lucasggmoreira.locadoraveiculos.exceptions.ClienteJaExistenteException;
import me.lucasggmoreira.locadoraveiculos.repository.RepositorioCliente;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Setter
@Getter
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToMany
    @JoinTable(name = "cliente_veiculo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_id"))
    private List<Veiculo> historico;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cnh;





    public Cliente() {

    }

    public Cliente(Cliente cliente, RepositorioCliente repositorio) {
        if (cliente.getId() != null) this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        for (int i = 0; i < repositorio.findAll().size(); i++) {
            Cliente clienteCadastrado = repositorio.findAll().get(i);
            if (clienteCadastrado.getTelefone().equals(cliente.getTelefone())){
                throw new ClienteJaExistenteException("Esse telefone já foi utilizado!");
            }
            if (clienteCadastrado.getEmail().equals(cliente.getEmail())){
                throw new ClienteJaExistenteException("Esse email já foi utilizado!");
            }
            if (clienteCadastrado.getCnh().equals(cliente.getCnh())){
                throw new ClienteJaExistenteException("Esse CNH já foi utilizado!");
            }
        }
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.cnh = cliente.getCnh();
    }

    public Cliente(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.cnh = cliente.getCnh();
    }
}
