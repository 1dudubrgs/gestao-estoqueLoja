/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import javax.swing.JOptionPane;
/**
 *
 * @author eduardobp
 */
public class Tela_Inicial {
    public static void main(String[] args) {
        String resp = "";
        String menu_I = """
                        Seja bem vindo ao nosso estoque!
                        
                        Selecione uma das opções abaixo:
                        
                        1 - Consultar Lista de Pedidos
                        2 - Fazer login
                        0 - Sair""";
      
        while(!"0".equals(resp)){
            resp = JOptionPane.showInputDialog(menu_I);
            switch (resp) {
                case "1" -> JOptionPane.showMessageDialog(null, "1");
                case "2" -> Tela_Login.main(args);
                case "0" -> {}
                default -> JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente");
            }
        }
    }
}
