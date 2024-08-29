package me.lucasggmoreira.locadoraveiculos.controllers.cliente;

import me.lucasggmoreira.locadoraveiculos.exceptions.ClienteJaExistenteException;
import me.lucasggmoreira.locadoraveiculos.exceptions.DadoInvalidoException;
import me.lucasggmoreira.locadoraveiculos.models.Cliente;
import me.lucasggmoreira.locadoraveiculos.repository.RepositorioCliente;
import me.lucasggmoreira.locadoraveiculos.repository.RepositorioVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/{id}")
public class ControladorID {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Autowired
    private RepositorioVeiculo repositorioVeiculo;

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente json) {
        return null;
    }

    @GetMapping
    public ResponseEntity listarCliente(@PathVariable long id){
        return ResponseEntity.ok(new Cliente(repositorioCliente.getReferenceById(id)));
    }



}
