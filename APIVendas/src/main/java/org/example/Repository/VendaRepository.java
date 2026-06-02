package org.example.Repository;

import org.example.Connection.ConnectionFactory;
import org.example.Model.VendaModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VendaRepository {

    public void CadastrarVenda(VendaModel venda){
        String sql = """
                INSERT INTO Venda
                (descricao, dataVenda, nomeProduto, valorProduto, quantidade, valorTotalVenda, idFuncionario)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try(Connection connection = ConnectionFactory.GetConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, venda.descricao);
            statement.setDate(2, Date.valueOf(venda.dataVenda));
            statement.setString(3, venda.nomeProduto);
            statement.setDouble(4, venda.valorProduto);
            statement.setInt(5, venda.quantidade);
            statement.setDouble(6, venda.valorTotalVenda);
            statement.setInt(7, venda.idFuncionario);

            statement.executeUpdate();
            System.out.println("Venda cadastrada com sucesso!");
        }
        catch (SQLException ex){
        ex.printStackTrace();
        }
    }

    public List<VendaModel> BuscarVendas() {
        String sql = "SELECT * FROM Venda";
        List<VendaModel> vendas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.GetConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                VendaModel venda = new VendaModel(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDate("dataVenda").toLocalDate(),
                        rs.getString("nomeProduto"),
                        rs.getDouble("valorProduto"),
                        rs.getInt("quantidade"),
                        rs.getInt("idFuncionario")
                );
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendas;
    }
}
