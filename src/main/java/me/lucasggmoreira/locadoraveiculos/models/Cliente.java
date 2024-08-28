package me.lucasggmoreira.locadoraveiculos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cnh;




    public Cliente() {

    }

    public Cliente(Cliente cliente) {
        if (cliente.getId() != null) this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.cnh = cliente.getCnh();
    }


}
