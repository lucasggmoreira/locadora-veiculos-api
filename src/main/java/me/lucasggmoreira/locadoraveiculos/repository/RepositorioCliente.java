package me.lucasggmoreira.locadoraveiculos.repository;

import me.lucasggmoreira.locadoraveiculos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {
}
