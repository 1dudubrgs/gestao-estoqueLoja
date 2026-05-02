/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author eduardobp
 */
public class Entregas {
    private int id;
    //id_pedido
    private String status;
    private String transportadora;
    private int codigo_rastreio;
    private LocalDate data_envio;
    private LocalDate data_entrega;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
}
