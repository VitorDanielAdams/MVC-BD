package Controller;

import Dao.ProdutoDao;
import Model.Produto;

import java.util.List;

public class ProdutoController {

    public void criaTabela(){
        ProdutoDao pd = new ProdutoDao();
        pd.criaTabela();
    }

    public void cadastrar(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.gravarNoBd(produto);
    }

    public List<Produto> listarProdutos(){
        ProdutoDao pd = new ProdutoDao();
        return pd.listaProdutos();
    }

    public Produto selecionaPeloId(int id){
        ProdutoDao pd = new ProdutoDao();
        return pd.selecionaById(id);
    }

    public void editarProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.editar(produto);
    }

    public void deletaProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.removeProdutoDoBd(produto);
    }
}
