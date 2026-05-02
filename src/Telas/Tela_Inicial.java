/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import DAOs.PessoaDAO;
import Entidades.Pessoa;
import Entidades.Usuario;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;
/**
 *
 * @author eduardobp
 */
public class Tela_Inicial {
    public static void main(String[] args) { 
        
        //INSTANCIANDO DAOs
        PessoaDAO bancoPessoas = new PessoaDAO(new Pessoa[100]);
        
        //CRIANDO PESSOAS ADMIN;
        Pessoa pessoaAdmin1 = new Pessoa("Eduardo Borges Pereira", LocalDate.of(2007, Month.JANUARY, 22), "185-824-286-00", bancoPessoas);
        Pessoa pessoaAdmin2 = new Pessoa("Felipe Lara Facin", LocalDate.of(2007, Month.APRIL, 18), "000-000-000.00", bancoPessoas);
        
        //CRIANDO USUARIOS ADMIN
        
        
        String resp = "";
        String menu_I = """
                        Seja bem vindo a nossa loja!
                        
                        Selecione uma das opções abaixo:
                        
                        1 - Consultar Lista de Pedidos
                        2 - Fazer login
                        0 - Sair""";
        
        String msgLogin = """
                            Por favor, insira o username da conta (login):
                            """;
        
        String msgSenha = """
                            Por favor, insira a senha da sua conta:
                            """;
        
        String inputLogin, inputSenha;
      
        while(!"0".equals(resp)){
            resp = JOptionPane.showInputDialog(menu_I);
            switch (resp) {
                case "1" -> JOptionPane.showMessageDialog(null, "1");
                case "2" -> {inputLogin = JOptionPane.showInputDialog(msgLogin);
                             inputSenha = JOptionPane.showInputDialog(msgSenha);}
                default -> JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente");
            }
        }
    }
}
