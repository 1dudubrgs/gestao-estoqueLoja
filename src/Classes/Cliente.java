/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.UsuarioDAO;
import java.time.LocalDate;

/**
 *
 * @author Família
 */
public class Cliente extends Usuario{
    
    public Cliente(Pessoa pessoa, String login, String senha, LocalDate data_criacao, UsuarioDAO bancoUsuarios) {
        super(pessoa, login, senha, data_criacao, bancoUsuarios);
        super.setTipo("CLIENTE");
    }
}
