package org.example.Service;

import org.example.DTO.FuncionarioResponseDTO;
import org.example.DTO.VendaRequestDTO;
import org.example.DTO.VendaResponseDTO;
import org.example.Model.VendaModel;
import org.example.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String FUNCIONARIO_API = "http://localhost:8082/funcionario/";

    public void CadastrarVenda(VendaRequestDTO venda) {
        if(venda.quantidade <= 0){
            System.out.println("Quantidade inválida, a quantidade deve seer maior que zero!");
            return;
        }

        try {
            restTemplate.getForObject(FUNCIONARIO_API + venda.idFuncionario, Object.class);
        } catch (Exception e) {
            System.out.println("Funcionário não encontrado: " + venda.idFuncionario);
            return;
        }

        VendaModel novaVenda = new VendaModel(
                0,
                venda.descricao,
                LocalDate.now(),
                venda.nomeProduto,
                venda.valorProduto,
                venda.quantidade,
                venda.idFuncionario
        );

        repository.CadastrarVenda(novaVenda);
    }

    public List<VendaResponseDTO> BuscarVendas() {
        List<VendaModel> vendas = repository.BuscarVendas();
        List<VendaResponseDTO> response = new ArrayList<>();

        for (VendaModel venda : vendas) {
            FuncionarioResponseDTO funcionario = null;
            try {
                funcionario = restTemplate.getForObject(
                        FUNCIONARIO_API + venda.idFuncionario,
                        FuncionarioResponseDTO.class
                );
            } catch (Exception e) {
                System.out.println("Erro ao buscar funcionário: " + venda.idFuncionario);
            }

            response.add(new VendaResponseDTO(venda, funcionario));
        }
        return response;
    }
}
