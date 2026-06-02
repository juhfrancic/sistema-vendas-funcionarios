package org.example.Controller;

import org.example.DTOs.FuncionarioRequestDTO;
import org.example.Models.FuncionarioModel;
import org.example.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<?> CadastrarFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequest){
        try {
            if(funcionarioRequest == null)
                System.out.println("Não é possível cadastrar funcionario");
            service.CadastrarFuncionario(funcionarioRequest);
            return ResponseEntity.ok().build();
        }
        catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarFuncionario(@PathVariable int id) {
        try {
            FuncionarioModel funcionario = service.BuscarFuncionario(id);
            if (funcionario == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(funcionario);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
