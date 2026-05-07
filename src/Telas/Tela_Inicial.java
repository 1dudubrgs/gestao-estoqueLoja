/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import Classes.Administrador;
import Classes.Carrinho;
import Classes.Cliente;
import Classes.Itens_Carrinho;
import DAOs.PessoaDAO;
import Classes.Pessoa;
import Classes.Produto;
import Classes.Usuario;
import DAOs.ProdutosDAO;
import DAOs.UsuarioDAO;
import DAOs.CarrinhoDAO;
import DAOs.Itens_CarrinhoDAO;
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
        
        //CRIANDO PESSOAS ADMIN
        Pessoa pessoaAdmin1 = new Pessoa("Eduardo Borges Pereira", LocalDate.of(2007, Month.JANUARY, 22), "185.824.286-00", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaAdmin2 = new Pessoa("Felipe Lara Facin", LocalDate.of(2007, Month.APRIL, 18), "000.000.000-00", sistemaCalendario.getDataHoje(), bancoPessoas);
        
        //CRIANDO PESSOAS CLIENTE
        Pessoa pessoaCliente1 = new Pessoa("Frederica Santos Batista", LocalDate.of(1982, Month.FEBRUARY, 14), "321.555.402-20", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaCliente2 = new Pessoa("a", LocalDate.of(2007, Month.JANUARY, 22), "111.111.111-11", sistemaCalendario.getDataHoje(), bancoPessoas);
        Pessoa pessoaCliente3 = new Pessoa("b", LocalDate.of(2007, Month.APRIL, 18), "222.222.222-22", sistemaCalendario.getDataHoje(), bancoPessoas);
        
        //CRIANDO USUARIOS ADMIN
        Usuario admin1 = new Administrador(pessoaAdmin1, "admin1", "AcessarLoja", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Usuario admin2 = new Administrador(pessoaAdmin2, "admin2", "AcessarLoja", sistemaCalendario.getDataHoje(), bancoUsuarios);
        
        //CRIANDO USUARIOS CLIENTE
        Usuario cliente1 = new Cliente(pessoaCliente1, "frederica", "123", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Cliente cliente2 = new Cliente(pessoaCliente2, "a", "a", sistemaCalendario.getDataHoje(), bancoUsuarios);
        Cliente cliente3 = new Cliente(pessoaCliente3, "b", "b", sistemaCalendario.getDataHoje(), bancoUsuarios);
        
        //CRIANDO PRODUTOS
        Produto produto1 = new Produto(10, "a", "a", 10.10, sistemaCalendario.getDataHoje(), bancoProdutos);
        Produto produto2 = new Produto(20, "b", "b", 20.20, sistemaCalendario.getDataHoje(), bancoProdutos);
        
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
                                Tela_Usuarios.main(bancoUsuarios.UsuárioLogin(inputLog, inputSenha), sistemaCalendario, bancoPessoas, bancoUsuarios, bancoProdutos, bancoCarrinhos, bancoItens_Carrinho);
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
