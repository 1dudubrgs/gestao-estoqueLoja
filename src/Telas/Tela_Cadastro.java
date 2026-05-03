/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;

import Classes.Cliente;
import Classes.Pessoa;
import Classes.Usuario;
import DAOs.PessoaDAO;
import DAOs.UsuarioDAO;
import Sistema.Calendario;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardobp
 */
public class Tela_Cadastro {
    public static void main(PessoaDAO bancoPessoas, UsuarioDAO bancoUsuarios, Calendario calendario) {
        boolean sair = false;
        boolean sairCPF = false;
        boolean sairLogin = false;
        
        String inputNome = "";
        String inputDataNascimento = "";
        String inputCPF = "";
        String inputLogin = "";
        String inputSenha = "";
        
        while(!sair){
            inputNome = JOptionPane.showInputDialog("Digite o seu nome (ENTER para cancelar):");
            if(!inputNome.equals("")){
                inputDataNascimento = JOptionPane.showInputDialog("Digite a sua data de nascimento (ENTER para cancelar)\nESCREVA DA SEGUINTE FORMA: (ano-mes-dia):");
                if(!inputDataNascimento.equals("")){
                    while(!sairCPF){
                        inputCPF = JOptionPane.showInputDialog("Digite o seu CPF (ENTER para cancelar):\nESCREVA DA SEGUINTE FORMA: 000.000.00-00");
                        if(!bancoPessoas.jaExiste(inputCPF) && (!inputCPF.equals(""))){
                            while(!sairLogin){
                                inputLogin = JOptionPane.showInputDialog("Digite o seu Login (ENTER para cancelar):");
                                if(!bancoUsuarios.loginExistente(inputLogin) && (!inputLogin.equals(""))){
                                    inputSenha = JOptionPane.showInputDialog("Digite a sua senha (ENTER para cancelar):");
                                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!\nVoltando para a tela inicial...");
                                    sair = true;
                                    sairLogin = true;
                                    
                                    Pessoa novaPessoa = new Pessoa(inputNome, LocalDate.parse(inputDataNascimento), inputCPF, calendario.getDataHoje(), bancoPessoas);
                                    Usuario novoUsuario = new Cliente(novaPessoa, inputLogin, inputSenha, calendario.getDataHoje(), bancoUsuarios);
                                }
                                else if(inputLogin.equals("")){
                                    JOptionPane.showMessageDialog(null, "Cancelando cadastro...");
                                    sair = true;
                                    sairLogin = true;
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Login já usado! Tente novamente");
                                }
                            }
                            sairCPF = true;
                        }
                        else if(inputCPF.equals("")){
                            JOptionPane.showMessageDialog(null, "Cancelando cadastro...");
                            sair = true;
                            sairCPF = true;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "CPF já existe! Tente novamente");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelando cadastro...");
                    sair = true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Cancelando cadastro...");
                sair = true;
            }
        }
    }
}
