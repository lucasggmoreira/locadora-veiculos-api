package me.lucasggmoreira.locadoraveiculos.repository;

import me.lucasggmoreira.locadoraveiculos.models.Cliente;
import me.lucasggmoreira.locadoraveiculos.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVeiculoCliente extends JpaRepository<Cliente, Veiculo> {
}
