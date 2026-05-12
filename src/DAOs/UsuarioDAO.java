/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Pessoa;
import Classes.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardobp
 */
public class UsuarioDAO {
    private Usuario[] listaUsuarios;

    public UsuarioDAO(Usuario[] usuario){
        this.listaUsuarios = usuario;
    }
    
    public void adicionarUsuario(Usuario usuario){
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] == null){
                this.listaUsuarios[i] = usuario;
                i = this.listaUsuarios.length;
            }
        }
    }
    
    public boolean loginExistente (String login){
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null){
                if(this.listaUsuarios[i].getLogin().equals(login)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean senhaExistente (String senha){
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null){
                if(this.listaUsuarios[i].getSenha().equals(senha)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public Usuario UsuárioLogin(String login, String senha){
        Usuario usuarioRetornar = null;
        
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null){
                if(this.listaUsuarios[i].getSenha().equals(senha) && this.listaUsuarios[i].getLogin().equals(login)){
                    usuarioRetornar = this.listaUsuarios[i];
                    i = this.listaUsuarios.length;
                }
            }
        }
        return usuarioRetornar;
    }
    
    public boolean PessoaJaCadastrada(Pessoa pessoa){
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null && this.listaUsuarios[i].getPessoa().equals(pessoa)){
                JOptionPane.showMessageDialog(null, "A pessoa inserida já possui um usuário!");
                return true;
            }
        }
        
        return false;
    }
    
    public boolean IDUsuarioExiste(int ID){
        for(int i = 0; i<this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null && this.listaUsuarios[i].getId() == ID)
                return true;
        }
        
        JOptionPane.showMessageDialog(null, "O ID inserido não existe! Tente novamente");
        return false;
    }
    
    public Usuario ProcurarUsuarioID (int ID){
        for(int i = 0; i<this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null && this.listaUsuarios[i].getId() == ID)
                return this.listaUsuarios[i];
        }
        return null;
    }
    
    public void RemoverUsuario(Usuario usuario){
        for(int i = 0; i < this.listaUsuarios.length; i++){
            if(this.listaUsuarios[i] != null && this.listaUsuarios[i].equals(usuario)){
                this.listaUsuarios[i] = null;
                JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso!");
                i = this.listaUsuarios.length;
            }
        }
    }

    @Override
    public String toString() {
        String string = "Usuários registrados no Sistema:\n\n";
        int cont = 0;
        
        for (Usuario index : listaUsuarios) {
            if(index == null)
                cont++;
        }
           
        if(cont != this.listaUsuarios.length){
            for (Usuario index : listaUsuarios) {
                if(index != null)
                    string += index + "\n\n"; 
            }
        }
        else
            string += "Não há usuários registrados no sistema!";
        
        return string;
    }
}
