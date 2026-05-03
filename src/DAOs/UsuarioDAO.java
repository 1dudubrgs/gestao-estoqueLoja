/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Usuario;

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
    
    public Usuario getUsuário(String login, String senha){
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
