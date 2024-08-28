package me.lucasggmoreira.locadoraveiculos.controllers.cliente;

import me.lucasggmoreira.locadoraveiculos.models.Cliente;
import me.lucasggmoreira.locadoraveiculos.repository.RepositorioCliente;
import me.lucasggmoreira.locadoraveiculos.repository.RepositorioVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ControladorGeral {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Autowired
    private RepositorioVeiculo repositorioVeiculo;

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente json){
        Cliente novoCliente = new Cliente(json);
        repositorioCliente.save(novoCliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso! ID do cliente: " + novoCliente.getId());
    }


    @GetMapping
    public ResponseEntity listarClientes(){
        Iterable<Cliente> clientes = repositorioCliente.findAll();
        if (repositorioCliente.findAll().isEmpty()) return ResponseEntity.badRequest().body("O banco de dados de clientes está vazio!");
        return ResponseEntity.ok(clientes);
    }



}
