package org.example.Controller;

import org.example.DTO.VendaRequestDTO;
import org.example.Model.VendaModel;
import org.example.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @PostMapping
    public void CadastrarVenda(@RequestBody VendaRequestDTO venda){
        try{
            service.CadastrarVenda(venda);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @GetMapping
    public ResponseEntity<?> BuscarVendas() {
        try {
            return ResponseEntity.ok(service.BuscarVendas());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
