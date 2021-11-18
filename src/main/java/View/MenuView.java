package View;

import Controller.ProdutoController;
import Model.Produto;

import java.util.Scanner;

public class MenuView {
    public void menu(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ProdutoView pv = new ProdutoView();

        pv.criaTabela();

        System.out.println("Selecione uma opção:");

        System.out.println("------------------------");
        System.out.println("  1 - Cadastrar Produto ");
        System.out.println("  2 - Mostrar Produto   ");
        System.out.println("  3 - Editar Produto    ");
        System.out.println("  4 - Deletar Produto    ");
        System.out.println("------------------------");

        switch (entrada.nextInt()){
            case 1:
                pv.cadastrar();
                this.menu();
                break;
            case 2:
                pv.mostrarProduto();
                this.menu();
                break;
            case 3:
                pv.editarProduto(pv.selecionaProduto());
                this.menu();
                break;
            case 4:
                pv.deletarProduto(pv.selecionaProduto());
                this.menu();
                break;
            default:
                System.out.println("Opção invalida");
        }

    }
}
