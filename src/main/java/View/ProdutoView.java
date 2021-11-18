package View;

import Controller.ProdutoController;
import Model.Produto;

import java.util.*;

public class ProdutoView {

    ProdutoController pc = new ProdutoController();

    public void criaTabela(){
        pc.criaTabela();
    }

    public void cadastrar(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Produto produto = new Produto();

        System.out.println("Informe o nome do produto");
        produto.setNome(entrada.next());

        System.out.println("Informe o valor do produto");
        produto.setValor(entrada.nextDouble());

        System.out.println("Informe a quantidade de items do produto");
        produto.setQuantidade(entrada.nextInt());

        pc.cadastrar(produto);
    }

    public void mostrarProduto(){
        List<Produto> lpd = pc.listarProdutos();
        for(int i = 0;i < lpd.size();i++){
            System.out.println(lpd.get(i).toMostra());
        }
    }

    public Produto selecionaProduto(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Selecione o Produto:");
        this.mostrarProduto();

        Produto produto = pc.selecionaPeloId(entrada.nextInt());

        System.out.println("O produto selecionado foi:");
        System.out.println(produto.toMostra());

        return produto;
    }

    public void editarProduto(Produto produto){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Editar Produto:\n");

        System.out.println("Escolha o que você quer editar: ");

        System.out.println("1-Nome;2-Valor;3-Quantidade;");

        switch (entrada.nextInt()){
            case 1:
                produto.setNome(entrada.next());
                break;
            case 2:
                produto.setValor(entrada.nextDouble());
                break;
            case 3:
                produto.setQuantidade(entrada.nextInt());
                break;
            default:
                System.out.println("Opção invalida");
        }

        pc.editarProduto(produto);

        System.out.println("Produto Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                this.editarProduto(produto);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }

    public void deletarProduto(Produto produto){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Tem certeza que deseja deletar o produto?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                pc.deletaProduto(produto);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }

    }
}
