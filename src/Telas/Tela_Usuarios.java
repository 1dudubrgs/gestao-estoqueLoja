package Telas;

import Classes.Carrinho;
import Classes.Produto;
import Classes.Usuario;
import DAOs.CarrinhoDAO;
import DAOs.PessoaDAO;
import DAOs.ProdutosDAO;
import DAOs.UsuarioDAO;
import Sistema.Calendario;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduardobp
 */
public class Tela_Usuarios {

    public static void main(Usuario user, Calendario calendario, PessoaDAO bancoPessoas, UsuarioDAO bancoUsuarios, ProdutosDAO bancoProdutos, CarrinhoDAO bancoCarrinhos) {

        String tipoUser = user.getTipo();

        if (tipoUser.equals("ADMINISTRADOR")) {
            String inputPainelA = "";
            String painelAdmin
                    = "!PAINEL DE ADMISTRADOR!\n\nSeja bem vindo, " + user.getPessoa().getNome() + "!\n\n Selecione uma das ações abaixo:\n\n"
                    + """
            1 - Manejar Cupons
            2 - Manejar Entregas
            3 - Movimentação do Estoque
            4 - Manejar Pedidos
            5 - Manejar Pessoas
            6 - Manejar Usuários
            7 - Manejar Produtos
            8 - Alterar Data Atual do Sistema
            9 - Relatório de vendas
            10 - Relatório de Pedidos
            11 - Relatório de Faturamento
            12 - Deslogar
            """;

            while (!inputPainelA.equals("12")) {
                inputPainelA = JOptionPane.showInputDialog(painelAdmin);
                switch (inputPainelA) {
                    case "1" -> {
                    }
                    case "2" -> {
                    }
                    case "3" -> {
                    }
                    case "4" -> {
                    }
                    case "5" -> {
                        JOptionPane.showMessageDialog(null, bancoPessoas.toString());
                    }
                    case "6" -> {
                        JOptionPane.showMessageDialog(null, bancoUsuarios.toString());
                    }
                    case "7" -> {
                        String inputProdutos = "";
                        
                        while(!inputProdutos.equals("5")){
                            inputProdutos = JOptionPane.showInputDialog(
                                    """
                                    Selecione uma das opções:
                                    
                                    1 - Adicionar novo produto
                                    2 - Editar um produto
                                    3 - Listar os produtos
                                    4 - Remover um produto
                                    5 - Sair
                                    """);
                            
                            switch (inputProdutos) {
                                case "1" -> {
                                    String quantidade = "";
                                    int quantidadeInt = -1;
                                    String nome = "";
                                    String descricao = "";
                                    String preco = "";
                                    double precoD = -1;

                                    while (quantidadeInt < 0) {
                                        quantidade = JOptionPane.showInputDialog("Insira a quantidade do novo produto (ENTER para sair)");

                                        if (!quantidade.equals("")) {
                                            quantidadeInt = Integer.parseInt(quantidade);
                                            if (quantidadeInt < 0) {
                                                JOptionPane.showMessageDialog(null, "Insira um valor valido!");
                                            }

                                            nome = JOptionPane.showInputDialog("Insira o nome do novo produto (ENTER para sair)");

                                            if (!nome.equals("")) {
                                                descricao = JOptionPane.showInputDialog("Insira a descrição do novo produto (ENTER para sair)");

                                                if (!descricao.equals("")) {
                                                    while (precoD < 0) {
                                                        preco = JOptionPane.showInputDialog("Insira o preço do novo produto (ENTER para sair)");

                                                        if (!preco.equals("")) {
                                                            precoD = Double.parseDouble(preco);
                                                            if (precoD < 0) {
                                                                JOptionPane.showMessageDialog(null, "Insira um valor valido!");
                                                            } else {
                                                                Produto novoProduto = new Produto(quantidadeInt, nome, descricao, precoD, calendario.getDataHoje(), bancoProdutos);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                                            precoD = 0;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                            quantidadeInt = 0;
                                        }
                                    }
                                }
                                case "2" -> {
                                    boolean vazio = bancoProdutos.estaVazio();
                                    
                                    if (!vazio) {
                                        boolean pararID = false;

                                        while (!pararID) {
                                            String id = JOptionPane.showInputDialog("Digite o ID do produto a ser alterado (ENTER para sair)");
                                            if (!id.equals("")) {
                                                int idINT = Integer.parseInt(id);
                                                if (bancoProdutos.pesquisarProduto(idINT) != null) {
                                                    pararID = true;

                                                    boolean pararAlteracao = false;
                                                    while (!pararAlteracao) {
                                                        String opcAlteracao = JOptionPane.showInputDialog("""
                                                                                Qual dos atributos você deseja alterar? (ENTER para sair)
                                                                                
                                                                                1 - Quantidade
                                                                                2 - Nome
                                                                                3 - Descrição
                                                                                4 - Preço
                                                                                """);

                                                        if (!opcAlteracao.equals("")) {
                                                            int opcAlteracaoINT = Integer.parseInt(opcAlteracao);

                                                            switch (opcAlteracaoINT) {
                                                                case 1 -> {
                                                                    boolean pararQuantidade = false;

                                                                    while (!pararQuantidade) {
                                                                        String novaQuantidade = JOptionPane.showInputDialog("Digite a nova quantidade do produto (ENTER para sair)");
                                                                        if (!novaQuantidade.equals("")) {
                                                                            int novaQuantidadeINT = Integer.parseInt(novaQuantidade);
                                                                            if (novaQuantidadeINT < 0) {
                                                                                JOptionPane.showMessageDialog(null, "Valor inserido inválido! Tente novamente.");
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
                                                                                bancoProdutos.pesquisarProduto(idINT).setQuantidade(novaQuantidadeINT);
                                                                                pararQuantidade = true;
                                                                                pararAlteracao = true;
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                            pararAlteracao = true;
                                                                            pararQuantidade = true;
                                                                        }
                                                                    }
                                                                }
                                                                case 2 -> {
                                                                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome do produto (ENTER para sair)");
                                                                    if (!novoNome.equals("")) {
                                                                        JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                                                                        bancoProdutos.pesquisarProduto(idINT).setNome(novoNome);
                                                                        pararAlteracao = true;
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                        pararAlteracao = true;
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição do produto (ENTER para sair)");
                                                                    if (!novaDescricao.equals("")) {
                                                                        JOptionPane.showMessageDialog(null, "Descrição alterada com sucesso!");
                                                                        bancoProdutos.pesquisarProduto(idINT).setDescricao(novaDescricao);
                                                                        pararAlteracao = true;
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                        pararAlteracao = true;
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    boolean pararPreco = false;

                                                                    while (!pararPreco) {
                                                                        String novoPreco = JOptionPane.showInputDialog("Digite o novo preço do produto (ENTER para sair)");
                                                                        if (!novoPreco.equals("")) {
                                                                            double novoPrecoDOUBLE = Double.parseDouble(novoPreco);
                                                                            if (novoPrecoDOUBLE < 0) {
                                                                                JOptionPane.showMessageDialog(null, "Valor inserido inválido! Tente novamente.");
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "Preço alterado com sucesso!");
                                                                                bancoProdutos.pesquisarProduto(idINT).setPreco_venda(novoPrecoDOUBLE);
                                                                                pararPreco = true;
                                                                                pararAlteracao = true;
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                            pararAlteracao = true;
                                                                            pararPreco = true;
                                                                        }
                                                                    }
                                                                }
                                                                default ->
                                                                    JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                            pararAlteracao = true;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ID não encontrado, tente novamente.");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                pararID = true;
                                            }
                                        }
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Nao há produtos para alterar!");
                                }
                                case "3" -> {JOptionPane.showMessageDialog(null, bancoProdutos.toString(0));}
                                case "4" -> {
                                    
                                    boolean vazio = bancoProdutos.estaVazio();
                                    
                                    if(!vazio){
                                        String opc = JOptionPane.showInputDialog(null, "Digite o ID do produto que deseja remover (ENTER para sair)");
                                 
                                        if(!opc.equals("")){
                                            int opcInt = Integer.parseInt(opc);
                                            while(!opc.equals("") && !bancoProdutos.removerProduto(opcInt)){
                                                opc = JOptionPane.showInputDialog(null, "Digite o ID do produto que deseja remover (ENTER para sair)");

                                                if(!opc.equals("")){
                                                    opcInt = Integer.parseInt(opc);
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Cancelando exclusão de produto...");
                                                }
                                            }
                                        }
                                        else
                                            JOptionPane.showMessageDialog(null, "Cancelando exclusão de produto...");
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Nao ha produtos a ser removidos!");
                                }
                                case "5" -> {}
                                default -> JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                            }
                        }
                    }
                    case "8" -> {
                    }
                    case "9" -> {
                    }
                    case "10" -> {
                    }
                    case "11" -> {
                        
                    }
                    case "12" -> {
                        JOptionPane.showMessageDialog(null, "Deslogando...");
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "Insira uma opção válida!");
                }
            }
        }
        else{
            String inputPainelC = "";
            String painelCliente
                    = "Seja bem vindo, " + user.getPessoa().getNome() + "!\n\n Selecione uma das ações abaixo:\n\n"
                    + """
            1 - Manejar Carrinho
            2 - Ver Produtos à venda
            3 - Relatório de Pedidos
            4 - Deslogar
            """;

            while (!inputPainelC.equals("4")) {
                inputPainelC = JOptionPane.showInputDialog(painelCliente);
                switch (inputPainelC) {
                    case "1" -> {
                        //Ao finalizar gera um PEDIDO,  ITENS_PEDIDO e MOVIMENTACAO_ESTOQUE
                        boolean vazio = bancoCarrinhos.estaVazio();
                        String resp = "";
                                    
                        if (!vazio) {

                            while (!resp.equals("0")) {
                                resp = JOptionPane.showInputDialog(null, bancoCarrinhos.toString() + """
                                                                    \n\nSelecione uma das ações abaixo: (ENTER para sair)

                                                                    1 - Editar carrinho
                                                                    2 - Finalizar carrinho
                                                                    3 - Cancelar carrinho
                                                                    0 - Sair do carrinho                      
                                                                    """);
                                
                                switch (resp) {
                                    case "1" -> {}
                                    case "2" -> {}
                                    case "3" -> {}
                                    case "0" -> {JOptionPane.showMessageDialog(null, "Saindo do carrinho...");}
                                    default -> JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente");
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null, bancoCarrinhos.toString());;
                    }
                    case "2" -> {
                        boolean vazio = bancoProdutos.estaVazio();
                                    
                        if (!vazio) {
                            boolean pararID = false;

                            while (!pararID) {
                                String id = JOptionPane.showInputDialog(null, bancoProdutos.toString(1) + "\n\nDigite o ID do produto que deseja comprar (ENTER para sair)");
                                if (!id.equals("")) {
                                    int idINT = Integer.parseInt(id);
                                    if (bancoProdutos.pesquisarProduto(idINT) != null && bancoProdutos.pesquisarProduto(idINT).isAtivo()) {
                                        pararID = true;

                                        boolean pararCompra = false;
                                        while (!pararCompra) {
                                            String opcCompra = JOptionPane.showInputDialog("""
                                                                    Selecione uma das ações abaixo: (ENTER para sair)

                                                                    1 - Adicionar ao carrinho
                                                                    2 - Comprar diretamente
                                                                    """);

                                            if (!opcCompra.equals("")) {
                                                int opcCompraINT = Integer.parseInt(opcCompra);

                                                switch (opcCompraINT) {
                                                    case 1 -> {
                                                        //É criado um  ITENS_CARRINHO
                                                        if(!bancoCarrinhos.jaExiste(user.getId())){
                                                            Carrinho novoCarrinho = new Carrinho(user, calendario.getDataHoje(), bancoCarrinhos);
                                                        }
                                                        pararCompra = true;
                                                    }
                                                    case 2 -> {
                                                        //Gera um PEDIDO,  ITENS_PEDIDO e MOVIMENTACAO_ESTOQUE
                                                        pararCompra = true;
                                                    }
                                                    default ->
                                                        JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando compra de produto...");
                                                pararCompra = true;
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ID não encontrado, tente novamente.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cancelando compra de produto...");
                                    pararID = true;
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null, bancoProdutos.toString(1));;
                        
                    }
                    case "3" -> {
                    }
                    case "4" -> {JOptionPane.showMessageDialog(null, "Deslogando..");}
                    default ->
                        JOptionPane.showMessageDialog(null, "Insira uma opção válida!");
                }
            }
        }
    }
}
