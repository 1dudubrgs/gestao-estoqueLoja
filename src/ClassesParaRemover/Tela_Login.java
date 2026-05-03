/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesParaRemover;

import javax.swing.JOptionPane;

/**
 *
 * @author eduardobp
 */
public class Tela_Login {
    public static void main(String[] args) {
        String loginMsg = """
                          Por favor, insira seu login:
                          """;
        
        String senhaMsg = """
                          Por favor, insira a sua senha:
                          """;
        
        String resp = JOptionPane.showInputDialog(loginMsg);
    }
}
