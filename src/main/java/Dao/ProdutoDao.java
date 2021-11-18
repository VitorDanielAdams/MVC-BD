package Dao;

import ConnectionFactory.ConnectionFactory;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
        "idProduto INT PRIMARY KEY AUTO_INCREMENT," +
        "nome VARCHAR(30) NOT NULL," +
        "valor DECIMAL(10,2)," +
        "quantidade INTEGER (11));";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void gravarNoBd(Produto produto){
        String sql = "INSERT INTO produtos " +
        "(nome, valor, quantidade) " +
        "VALUES (?,?,?)";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                produto.setId_Produto(resultSet.getInt(1));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listaProdutos(){
        String sql = "SELECT * FROM produtos";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Produto> lpd = new ArrayList<>();

            while (resultSet.next()){
                Produto produto = new Produto();

                produto.setId_Produto(resultSet.getInt("idProduto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setValor(resultSet.getDouble("valor"));
                produto.setQuantidade(resultSet.getInt("quantidade"));

                lpd.add(produto);
            }

            return lpd;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Produto selecionaById(int id){
        String sql = "SELECT * FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setId_Produto(resultSet.getInt("idProduto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setValor(resultSet.getDouble("valor"));
                produto.setQuantidade(resultSet.getInt("quantidade"));

                return produto;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editar(Produto produto){
        String sql = "UPDATE produtos SET nome = ?, valor = ?, quantidade = ? WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId_Produto());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void removeProdutoDoBd(Produto produto){
        String sql = "DELETE FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getId_Produto());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
