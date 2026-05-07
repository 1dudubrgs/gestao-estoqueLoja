/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.CarrinhoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author eduardobp
 */
public class Carrinho {
    private int id;
    private int id_usuario;
    private String status; //ABERTO, FECHADO, CANCELADO, EXPIRADO
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    
    public Carrinho(Usuario usuario, LocalDate data_criacao, CarrinhoDAO bancoCarrinhos) {
        this.id = cont++;
        this.id_usuario = usuario.getId();
        this.status = "Aberto";
        this.data_criacao = data_criacao;
        this.data_modificacao = this.data_criacao;
        bancoCarrinhos.adicionarCarrinho(this);
    }

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }

    @Override
    public String toString() {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatada = data_criacao.format(FormaData);
        String ModificacaoFormatada = data_modificacao.format(FormaData);
        
        return "ID = " + id + "\nID do Usuário(a) = " + id_usuario + "\nStatus = " + status + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada;
    }
}
