/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import Classes.Administrador;
import Classes.Carrinho;
import Classes.Cliente;
import Classes.Itens_Carrinho;
import Classes.Pedido;
import DAOs.PessoaDAO;
import Classes.Pessoa;
import Classes.Produto;
import Classes.Usuario;
import Classes.Cupom;
import Classes.Entregas;
import Classes.Itens_Pedido;
import Classes.Movimentacao_Estoque;
import DAOs.CuponsDAO;
import DAOs.ProdutosDAO;
import DAOs.UsuarioDAO;
import DAOs.CarrinhoDAO;
import DAOs.EntregasDAO;
import DAOs.Itens_CarrinhoDAO;
import DAOs.Itens_PedidoDAO;
import DAOs.Movimentacao_EstoqueDAO;
import DAOs.PedidosDAO;
import Sistema.Calendario;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;
/**
 *
 * @author eduardobp
 */
public class Tela_Inicial {
    public static void main(String[] args) { 
        
        Calendario sistemaCalendario = new Calendario();
        
        //INSTANCIANDO DAOs
        PessoaDAO bancoPessoas = new PessoaDAO(new Pessoa[100]);
        UsuarioDAO bancoUsuarios = new UsuarioDAO(new Usuario[100]);
        ProdutosDAO bancoProdutos = new ProdutosDAO(new Produto[100]);
        CarrinhoDAO bancoCarrinhos = new CarrinhoDAO(new Carrinho[100]);
        Itens_CarrinhoDAO bancoItens_Carrinho = new Itens_CarrinhoDAO(new Itens_Carrinho[100]);
        PedidosDAO bancoPedidos = new PedidosDAO(new Pedido[100]);
        CuponsDAO bancoCupons = new CuponsDAO(new Cupom[100]);
        Itens_PedidoDAO bancoItens_Pedido = new Itens_PedidoDAO(new Itens_Pedido[100]);
        Movimentacao_EstoqueDAO bancoMovimentacao_Estoque = new Movimentacao_EstoqueDAO(new Movimentacao_Estoque[100]);
        EntregasDAO bancoEntregas = new EntregasDAO(new Entregas[100]);
        
                //CRIANDO PESSOAS ADMIN
        Pessoa pessoaAdmin1 = new Pessoa("Eduardo Borges Pereira", LocalDate.of(2007, Month.JANUARY, 22), "185.824.286-00", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaAdmin2 = new Pessoa("Felipe Lara Facin", LocalDate.of(2007, Month.APRIL, 18), "673.265.843-39", sistemaCalendario.getDataHoje(), bancoPessoas);
        
        //CRIANDO PESSOAS CLIENTE
        Pessoa pessoaCliente1 = new Pessoa("Frederica Santos Batista", LocalDate.of(1982, Month.FEBRUARY, 14), "321.555.402-20", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaCliente2 = new Pessoa("Caio Lima Chagas", LocalDate.of(1984, Month.DECEMBER, 25), "111.111.111-11", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaCliente3 = new Pessoa("Renato Augusto Galhos", LocalDate.of(1999, Month.SEPTEMBER, 10), "222.222.222-22", sistemaCalendario.getDataHoje(), bancoPessoas);
        
        //CRIANDO USUARIOS ADMIN
        Usuario admin1 = new Administrador(pessoaAdmin1, "admin1", "AcessarLoja", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Usuario admin2 = new Administrador(pessoaAdmin2, "admin2", "AcessarLoja", sistemaCalendario.getDataHoje(), bancoUsuarios);
        
        //CRIANDO USUARIOS CLIENTE
        Usuario cliente1 = new Cliente(pessoaCliente1, "frederica", "123", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Usuario cliente2 = new Cliente(pessoaCliente2, "caio", "123", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Usuario cliente3 = new Cliente(pessoaCliente3, "renato", "123", sistemaCalendario.getDataHoje(), bancoUsuarios);
        
        //CRIANDO PRODUTOS
        Produto produto1 = new Produto(10, "Mouse", "Um mouse muito bom.", 10.00, sistemaCalendario.getDataHoje(), bancoProdutos);
        Produto produto2 = new Produto(20, "Teclado", "Esse teclado é massa.", 20.30, sistemaCalendario.getDataHoje(), bancoProdutos);
        
        //CRIANDO CUPONS
        Cupom cupom1 = new Cupom("cupomF", "Fixo", 5, 15, LocalDate.of(2026, Month.DECEMBER, 11), sistemaCalendario.getDataHoje(), bancoCupons);
        Cupom cupom2 = new Cupom("cupomP", "Percentual", 0.10, 8, LocalDate.of(2026, Month.DECEMBER, 10), sistemaCalendario.getDataHoje(), bancoCupons);
        
        //CRIANDO CARRINHOS
        Carrinho carrinho1 = new Carrinho(cliente1, sistemaCalendario.getDataHoje(), bancoCarrinhos);
        Carrinho carrinho2 = new Carrinho(cliente2, sistemaCalendario.getDataHoje(), bancoCarrinhos);
        
        //CRIANDO ITENS_CARRINHO
        Itens_Carrinho itensCarrinho1 = new Itens_Carrinho(carrinho1, produto1, 3, sistemaCalendario.getDataHoje(), bancoItens_Carrinho);
        Itens_Carrinho itensCarrinho2 = new Itens_Carrinho(carrinho2, produto1, 1, sistemaCalendario.getDataHoje(), bancoItens_Carrinho);
        Itens_Carrinho itensCarrinho3 = new Itens_Carrinho(carrinho2, produto2, 10, sistemaCalendario.getDataHoje(), bancoItens_Carrinho);
        
        //CRIANDO PEDIDOS
        Pedido pedido1 = new Pedido(3, 1, 20, "Pix", sistemaCalendario.getDataHoje(), bancoPedidos);
        Pedido pedido2 = new Pedido(3, 2, 10, "Boleto", sistemaCalendario.getDataHoje(), bancoPedidos);
        Pedido pedido3 = new Pedido(4, 1, 40.60, "Cartão de Crédito", sistemaCalendario.getDataHoje(), bancoPedidos);
        
        //CRIANDO ITENS_PEDIDO
        Itens_Pedido itensPedido1 = new Itens_Pedido(1, 1, 2, 10.00, sistemaCalendario.getDataHoje(), bancoItens_Pedido);
        Itens_Pedido itensPedido2 = new Itens_Pedido(2, 1, 1, 10.00, sistemaCalendario.getDataHoje(), bancoItens_Pedido);
        Itens_Pedido itensPedido3 = new Itens_Pedido(3, 2, 2, 20.30, sistemaCalendario.getDataHoje(), bancoItens_Pedido);
        
        //CRIANDO MOVIMENTACOES_ESTOQUE
        Movimentacao_Estoque movimentacaoEstoque1 = new Movimentacao_Estoque(1, 3, 10.00, "Entrada", sistemaCalendario.getDataHoje(), bancoMovimentacao_Estoque);
        Movimentacao_Estoque movimentacaoEstoque2 = new Movimentacao_Estoque(1, 10, 10.00, "Ajuste", sistemaCalendario.getDataHoje(), bancoMovimentacao_Estoque);
        Movimentacao_Estoque movimentacaoEstoque3 = new Movimentacao_Estoque(2, 5, 20.30, "Saída", sistemaCalendario.getDataHoje(), bancoMovimentacao_Estoque);
        
        String resp = "";
        String menu_I = """
                        Seja bem vindo a nossa loja!
                        
                        Selecione uma das opções abaixo:
                        
                        1 - Consultar Lista de Produtos à venda
                        2 - Fazer login
                        3 - Realizar Cadastro
                        0 - Sair""";
        
        /*String msgLogin = """
                            Por favor, insira o username da conta (login):
                            """;
        
        String msgSenha = """
                            Por favor, insira a senha da sua conta:
                            """;
        
        String inputLogin, inputSenha;*/
      
        while(!resp.equals("0")){
            /*
            1 -> Consulta de Produtos
            2 -> Login
            3 -> Cadastro
            */
            
            resp = JOptionPane.showInputDialog(menu_I);
            switch (resp) {
                case "1" -> {JOptionPane.showMessageDialog(null, bancoProdutos.toString(1));}
                case "2" -> {
                    int opc = 0;
                    String inputSenha;
                    boolean sair = false;
                    
                    
                    while(!sair){
                        String inputLog = JOptionPane.showInputDialog(
                                """
                                                             Por favor, insira o seu login (ENTER para cancelar):
                                                             """);

                        if (bancoUsuarios.loginExistente(inputLog)) {
                            inputSenha = JOptionPane.showInputDialog("""
                                                    Por favor, insira a senha (ENTER para cancelar):
                                                    """);

                            if (bancoUsuarios.senhaExistente(inputSenha)) {
                                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                                Tela_Usuarios.main(bancoUsuarios.UsuárioLogin(inputLog, inputSenha), sistemaCalendario, bancoPessoas, bancoUsuarios, bancoProdutos, bancoCarrinhos, bancoItens_Carrinho, bancoPedidos, bancoCupons, bancoItens_Pedido, bancoMovimentacao_Estoque, bancoEntregas);
                                sair = true;
                            } else if (inputSenha.equals("")) {
                                JOptionPane.showMessageDialog(null, "Cancelando o login...");
                                sair = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Senha inserida inválida! Tente novamente.");
                            }

                        }
                        else if(inputLog.equals("")){
                            JOptionPane.showMessageDialog(null, "Cancelando o login...");
                            sair = true;
                        }
                        else {
                            opc = JOptionPane.showConfirmDialog(null, "Login inexistente, deseja cadastrar um usuário?", "", JOptionPane.YES_NO_OPTION);

                            if (opc == 0) {
                                Tela_Cadastro.main(bancoPessoas, bancoUsuarios, sistemaCalendario);
                                sair = true;
                            }
                            else {
                                int tentarNovamente = JOptionPane.showConfirmDialog(null, "Tentar novamente?", "", JOptionPane.YES_NO_OPTION);
                                if(tentarNovamente == 1)
                                    sair = true;
                            }
                        }
                    }
                }
                case "3" -> {Tela_Cadastro.main(bancoPessoas, bancoUsuarios, sistemaCalendario);}
                case "0" -> {JOptionPane.showMessageDialog(null, "Saindo do programa...");}
                default -> JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente");
            }
        }
    }
}
