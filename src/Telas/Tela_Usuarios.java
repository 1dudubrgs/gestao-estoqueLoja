package Telas;

import Classes.Carrinho;
import Classes.Cliente;
import Classes.Pessoa;
import Classes.Itens_Carrinho;
import Classes.Produto;
import Classes.Usuario;
import DAOs.CarrinhoDAO;
import DAOs.Itens_CarrinhoDAO;
import DAOs.PessoaDAO;
import DAOs.ProdutosDAO;
import DAOs.UsuarioDAO;
import Sistema.Calendario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eduardobp
 */
public class Tela_Usuarios {

    public static void main(Usuario user, Calendario calendario, PessoaDAO bancoPessoas, UsuarioDAO bancoUsuarios, ProdutosDAO bancoProdutos, CarrinhoDAO bancoCarrinhos, Itens_CarrinhoDAO bancoItens_Carrinho) {

        String tipoUser = user.getTipo();

        if (tipoUser.equals("ADMINISTRADOR")) {
            String inputPainelA = "";
            String painelAdmin
                    = "!PAINEL DE ADMISTRADOR!\n\nSeja bem vindo, " + user.getPessoa().getNome() + "!\n\n Selecione uma das ações abaixo:\n\n"
                    + """
            1 - Manejar Cupons
            2 - Manejar Entregas
            3 - Movimentação do Estoque
            4 - Manejar Pedidos
            5 - Manejar Pessoas
            6 - Manejar Usuários
            7 - Manejar Produtos
            8 - Alterar Data Atual do Sistema
            9 - Relatório de vendas
            10 - Relatório de Pedidos
            11 - Relatório de Faturamento
            12 - Deslogar
            """;

            while (!inputPainelA.equals("12")) {
                inputPainelA = JOptionPane.showInputDialog(painelAdmin);
                switch (inputPainelA) {
                    case "1" -> {
                    }
                    case "2" -> {
                    }
                    case "3" -> {
                    }
                    case "4" -> {
                    }
                    case "5" -> {
                        boolean pararManejar = false;
                        while(!pararManejar){
                            
                            String opcaoMPessoas = JOptionPane.showInputDialog("Selecione o que deseja manejar:\n\n" +
                                    """
                                    1 - Adicionar uma nova pessoa
                                    2 - Editar uma pessoa
                                    3 - Listar pessoas
                                    4 - Remover uma pessoa
                                    5 - Sair
                                    """
                            );
                            
                            switch(opcaoMPessoas){
                                case "1" -> {
                                    String nomePessoa = JOptionPane.showInputDialog("Digite o nome da nova pessoa (ENTER para sair):");
                                    if(!nomePessoa.equals("")){
                                        DateTimeFormatter diaMESano = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento da nova pessoa (ENTER para sair)\nModelo para inserir: Dia/Mes/Ano:");
                                        if(!dataNascimento.equals("")){
                                            LocalDate dataNascimentoDATA = LocalDate.parse(dataNascimento, diaMESano);
                                            boolean pararCPF = false;
                                            
                                            while(!pararCPF){
                                                String novoCpf = JOptionPane.showInputDialog("Digite o CPF da nova pessoa (ENTER para sair):\nModelo para inserir: 000.000.000-00");
                                                if(!novoCpf.equals("")){
                                                    if(!bancoPessoas.jaExisteCPF(novoCpf)){
                                                        Pessoa novaPessoa = new Pessoa(nomePessoa, dataNascimentoDATA, novoCpf, calendario.getDataHoje(), bancoPessoas);
                                                        pararCPF = true;
                                                        JOptionPane.showMessageDialog(null, "Pessoa criada com sucesso!");
                                                    }
                                                    else{
                                                        JOptionPane.showMessageDialog(null, "CPF ja existe! Tente novamente.");
                                                    }
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Cancelando criação de pessoa...");
                                                    pararCPF = true;
                                                }
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Cancelando criação de pessoa...");
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Cancelando criação de pessoa...");
                                    }
                                }
                                case "2" -> {
                                    boolean pararID = false;
                                    
                                    while(!pararID){
                                        String id = JOptionPane.showInputDialog("Digite o ID da pessoa a ser editada (ENTER para cancelar):");
                                        if(!id.equals("") && !(id.equals("1") || id.equals("2"))){
                                            int idINT = Integer.parseInt(id);
                                            if(bancoPessoas.jaExisteID(idINT)){
                                                pararID = true;
                                                Pessoa pessoa = bancoPessoas.retornarPessoaID(idINT);
                                                boolean pararAtributoEditar = false;
                                    
                                    while(!pararAtributoEditar){
                                        String atributoEditar = JOptionPane.showInputDialog("Selecione qual atributo deseja editar:\n\n" + 
                                                """
                                                1 - Editar Nome
                                                2 - Editar Data de nascimento
                                                3 - Editar CPF
                                                4 - Sair
                                                """);

                                        switch(atributoEditar){
                                            case "1" -> {
                                                String novoNome = JOptionPane.showInputDialog("Digite o novo nome da pessoa (ENTER para cancelar):");
                                                if (!novoNome.equals("")) {
                                                    pessoa.setNome(novoNome);
                                                    pessoa.setData_modificacao(calendario.getDataHoje()); 
                                                    JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Cancelando mudança de nome...");
                                                }
                                            }
                                            case "2" -> {
                                                DateTimeFormatter diaMESano = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                String novoNascimento = JOptionPane.showInputDialog("Digite a nova data de nascimento da pessoa (ENTER para cancelar):\nSiga o modelo dd/MM/aaaa");
                                                if (!novoNascimento.equals("")) {
                                                    LocalDate novoNascimentoDATE = LocalDate.parse(novoNascimento, diaMESano);
                                                    pessoa.setNascimento(novoNascimentoDATE);
                                                    pessoa.setData_modificacao(calendario.getDataHoje());
                                                    JOptionPane.showMessageDialog(null, "Data de nascimento alterada com sucesso!");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Cancelando edição de data de nascimento...");
                                                }
                                            }
                                            case "3" -> {

                                                boolean pararCPF = false;

                                                while (!pararCPF) {
                                                    String novoCPF = JOptionPane.showInputDialog("Digite o novo CPF da pessoa (ENTER para sair):\nSiga o modelo 000.000.000-00");
                                                    if (!novoCPF.equals("")) {
                                                        if (!bancoPessoas.jaExisteCPF(novoCPF)) {
                                                            pessoa.setCpf(novoCPF);
                                                            pessoa.setData_modificacao(calendario.getDataHoje());
                                                            pararCPF = true;

                                                            JOptionPane.showMessageDialog(null, "CPF alterado com sucesso!");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "CPF já existe! Tente novamente");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Cancelando mudança de CPF...");
                                                        pararCPF = true;

                                                    }
                                                }
                                            }
                                            case "4" -> {pararAtributoEditar = true;}
                                            default -> {}
                                        }
                                    }
                                            }
                                    
                                        }
                                        else if(id.equals("1") || id.equals("2")){
                                            JOptionPane.showMessageDialog(null, "Não é possivel alterar uma pessoa Super Adminsitradora! Tente novamente.");
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Cancelando edição de pessoa...");
                                            pararID = true;
                                        }
                                    }
                                }
                                case "3" -> {JOptionPane.showMessageDialog(null, bancoPessoas.toString());}
                                case "4" -> {
                                    boolean pararID = false;
                                    while(!pararID){
                                        String idRemover = JOptionPane.showInputDialog("Digite o ID da pessoa a ser removida");
                                        if(!idRemover.equals("")){
                                            int idRemoverINT = Integer.parseInt(idRemover);
                                            if(bancoPessoas.jaExisteID(idRemoverINT) && idRemoverINT != 1 && idRemoverINT != 2){
                                                bancoPessoas.removerPessoaID(idRemoverINT);
                                                pararID = true;
                                                JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
                                            }
                                            else if(idRemoverINT == 1 || idRemoverINT == 2){
                                                JOptionPane.showMessageDialog(null, "Não é possível remover pessoas Super Usuários! Tente novamente.");
                                            }
                                            
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Cancelando remoção de pessoa...");
                                            pararID = true;
                                        }
                                    }
                                }
                                case "5" -> {pararManejar = true;}
                                default -> {JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");}
                            }
                        }
                    }
                    case "6" -> {
                        String inputUsuarios = "";
                        
                        while(!inputUsuarios.equals("5")){
                            inputUsuarios = JOptionPane.showInputDialog(
                                    """
                                    Selecione uma das opções:
                                    
                                    1 - Adicionar novo usuário
                                    2 - Editar um usuário
                                    3 - Listar os usuários
                                    4 - Remover um usuário
                                    5 - Sair
                                    """);
                            
                            switch (inputUsuarios) {
                                case "1" -> {
                                    boolean pararID = false;
                                    
                                    while(!pararID){
                                        String IDdono = JOptionPane.showInputDialog("Digite o ID do dono do novo usuário (ENTER para sair):");
                                        if(!IDdono.equals("")){
                                            int IDdonoINT = Integer.parseInt(IDdono);
                                            if(bancoPessoas.jaExisteID(IDdonoINT)){
                                                Pessoa donoUsuário = bancoPessoas.retornarPessoaID(IDdonoINT);
                                                
                                                if(!bancoUsuarios.PessoaJaCadastrada(donoUsuário)){
                                                pararID = true;
                                                boolean pararLogin = false;
                                                
                                                    while(!pararLogin){
                                                        String login = JOptionPane.showInputDialog("Digite o login do novo usuário (ENTER para sair):");
                                                        if(!login.equals("")){
                                                            if(!bancoUsuarios.loginExistente(login)){
                                                                pararLogin = true;
                                                                String senha = JOptionPane.showInputDialog("Digite a senha do novo usuário (ENTER para sair):");
                                                                if(!senha.equals("")){
                                                                    Usuario novoUsuario = new Cliente(donoUsuário, login, senha, calendario.getDataHoje(), bancoUsuarios);
                                                                }
                                                                else{
                                                                    JOptionPane.showMessageDialog(null, "Cancelando criação de usuário...");
                                                                    pararLogin = true;
                                                                }
                                                            }
                                                            else{
                                                                JOptionPane.showMessageDialog(null, "O Login já está sendo usado! Tente novamente.");
                                                            }
                                                        }
                                                        else{
                                                            JOptionPane.showMessageDialog(null, "Cancelando criação de usuário...");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                           JOptionPane.showMessageDialog(null, "Cancelando criação de usuário...");
                                           pararID = true;
                                        }
                                    }
                                }
                                case "2" -> {
                                    boolean pararID = false;
                                    
                                    while(!pararID){
                                        String id = JOptionPane.showInputDialog("Digite o ID do usuário a ser editado (ENTER para cancelar):");
                                        if(!id.equals("") && !(id.equals("1") || id.equals("2") || id.equals(Integer.toString(user.getId())))){
                                            int idINT = Integer.parseInt(id);
                                            if(bancoUsuarios.IDUsuarioExiste(idINT)){
                                                pararID = true;
                                                Usuario usuario = bancoUsuarios.ProcurarUsuarioID(idINT);
                                                boolean pararEdicao = false;
                                                
                                                while(!pararEdicao){
                                                    String opcEditar = JOptionPane.showInputDialog("Escolha o atributo que deseja editar do usuário\n\n" + 
                                                            """
                                                            1 - Alterar o dono do usuário
                                                            2 - Editar Login
                                                            3 - Editar Senha
                                                            4 - Promover a administrador
                                                            5 - Sair
                                                            """
                                                            + "\n"
                                                            );

                                                    switch (opcEditar) {
                                                        case "1" -> {
                                                            boolean pararIdNovaPessoa = false;
                                                            
                                                            while(!pararIdNovaPessoa){
                                                                String idNovaPessoa = JOptionPane.showInputDialog("Digite o ID da nova pessoa (ENTER para sair):");
                                                                if(!idNovaPessoa.equals("")){
                                                                    int idNovaPessoaINT = Integer.parseInt(idNovaPessoa);
                                                                    if(bancoPessoas.jaExisteID(idNovaPessoaINT)){
                                                                        Pessoa novaDonaUsuario = bancoPessoas.retornarPessoaID(idNovaPessoaINT);
                                                                        if(!bancoUsuarios.PessoaJaCadastrada(novaDonaUsuario)){
                                                                            usuario.setPessoa(novaDonaUsuario);
                                                                            usuario.setData_modificacao(calendario.getDataHoje());
                                                                            pararIdNovaPessoa = true;
                                                                        }
                                                                    }
                                                                }
                                                                else{
                                                                    JOptionPane.showMessageDialog(null, "Cancelando mudança de dono do usuário...");
                                                                    pararIdNovaPessoa = true;
                                                                }
                                                            }
                                                        }
                                                        case "2" -> {
                                                            boolean pararLogin = false;
                                                            
                                                            while(!pararLogin){
                                                                String novoLogin = JOptionPane.showInputDialog("Digite o novo login do usuário: ");
                                                                if(!novoLogin.equals("")){
                                                                    if(!bancoUsuarios.loginExistente(novoLogin)){
                                                                        usuario.setLogin(novoLogin);
                                                                        usuario.setData_modificacao(calendario.getDataHoje());
                                                                        pararLogin = true;
                                                                    }
                                                                    else{
                                                                        JOptionPane.showMessageDialog(null, "O Login já existe! Tente novamente.");
                                                                    }
                                                                }
                                                                else{
                                                                    JOptionPane.showMessageDialog(null, "Cancelando mudança de login do usuário...");
                                                                    pararLogin = true;
                                                                }
                                                            }
                                                            
                                                        }
                                                        case "3" -> {
                                                            String novaSenha = JOptionPane.showInputDialog("Digite a nova senha do usuário (ENTER para sair):");
                                                            if(!novaSenha.equals("")){
                                                                usuario.setSenha(novaSenha);
                                                                usuario.setData_modificacao(calendario.getDataHoje());
                                                            }
                                                            else{
                                                                JOptionPane.showMessageDialog(null, "Cancelando mudança de senha do usuário...");
                                                            }
                                                        }
                                                        case "4" -> {
                                                            if(usuario.getTipo() == "CLIENTE"){
                                                                usuario.setTipo("ADMINISTRADOR");
                                                                usuario.setData_modificacao(calendario.getDataHoje());
                                                                JOptionPane.showMessageDialog(null, "O usuário foi promovido a administrador do sistema!");
                                                            }
                                                            else{
                                                                JOptionPane.showMessageDialog(null, "Este usuário já é um administrador!");
                                                            }
                                                        }
                                                        case "5" -> {pararEdicao = true;}
                                                        default -> JOptionPane.showMessageDialog(null, "Valor inserido não está entre as opções! Tente novamente.");
                                                    }
                                                }
                                            }
                                        }
                                        else if(id.equals("1") || id.equals("2")){
                                            JOptionPane.showMessageDialog(null, "Não é possível alterar usuários Super Administradores!\n\nTente novamente.");
                                        }
                                        else if(id.equals(Integer.toString(user.getId()))){
                                            JOptionPane.showMessageDialog(null, "Não é possível editar usuário atualmente logado! Tente novamente.");
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Cancelando edição de usuário...");
                                            pararID = true;
                                        }
                                    }
                                }
                                case "3" -> {JOptionPane.showMessageDialog(null, bancoUsuarios.toString());}
                                case "4" -> {
                                    boolean pararIDuser = false;
                                    while(!pararIDuser){
                                        String IDuser = JOptionPane.showInputDialog("Digite o ID do usuário que deseja remover (ENTER para cancelar):");
                                        if(!IDuser.equals("")){
                                            int IDuserINT = Integer.parseInt(IDuser);
                                            if(bancoUsuarios.IDUsuarioExiste(IDuserINT)){
                                                if(bancoUsuarios.ProcurarUsuarioID(IDuserINT).getId() != 1 && bancoUsuarios.ProcurarUsuarioID(IDuserINT).getId() != 2 && bancoUsuarios.ProcurarUsuarioID(IDuserINT).getId() != user.getId()){
                                                    bancoUsuarios.RemoverUsuario(bancoUsuarios.ProcurarUsuarioID(IDuserINT));
                                                    pararIDuser = true;
                                                }
                                                else if(bancoUsuarios.ProcurarUsuarioID(IDuserINT).getId() == 1 || bancoUsuarios.ProcurarUsuarioID(IDuserINT).getId() == 2){
                                                    JOptionPane.showMessageDialog(null, "Não é possivel remover Super Administradores! Tente novamente.");
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Não é possível remover um usuário logado! Tente novamente.");
                                                }
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Não existe um usuário com este ID! Tente novamente.");
                                            }
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Cancelando remoção de usuário...");
                                            pararIDuser = true;
                                        }
                                    }
                                }
                                case "5" -> {}
                                default -> JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                            }
                        }
                    }
                    case "7" -> {
                        String inputProdutos = "";
                        
                        while(!inputProdutos.equals("5")){
                            inputProdutos = JOptionPane.showInputDialog(
                                    """
                                    Selecione uma das opções:
                                    
                                    1 - Adicionar novo produto
                                    2 - Editar um produto
                                    3 - Listar os produtos
                                    4 - Remover um produto
                                    5 - Sair
                                    """);
                            
                            switch (inputProdutos) {
                                case "1" -> {
                                    String quantidade = "";
                                    int quantidadeInt = -1;
                                    String nome = "";
                                    String descricao = "";
                                    String preco = "";
                                    double precoD = -1;

                                    while (quantidadeInt < 0) {
                                        quantidade = JOptionPane.showInputDialog("Insira a quantidade do novo produto (ENTER para sair)");

                                        if (!quantidade.equals("")) {
                                            quantidadeInt = Integer.parseInt(quantidade);
                                            if (quantidadeInt < 0) {
                                                JOptionPane.showMessageDialog(null, "Insira um valor valido!");
                                            }

                                            nome = JOptionPane.showInputDialog("Insira o nome do novo produto (ENTER para sair)");

                                            if (!nome.equals("")) {
                                                descricao = JOptionPane.showInputDialog("Insira a descrição do novo produto (ENTER para sair)");

                                                if (!descricao.equals("")) {
                                                    while (precoD < 0) {
                                                        preco = JOptionPane.showInputDialog("Insira o preço do novo produto (ENTER para sair)");

                                                        if (!preco.equals("")) {
                                                            precoD = Double.parseDouble(preco);
                                                            if (precoD < 0) {
                                                                JOptionPane.showMessageDialog(null, "Insira um valor valido!");
                                                            } else {
                                                                Produto novoProduto = new Produto(quantidadeInt, nome, descricao, precoD, calendario.getDataHoje(), bancoProdutos);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                                            precoD = 0;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Cancelando criação de produto...");
                                            quantidadeInt = 0;
                                        }
                                    }
                                }
                                case "2" -> {
                                    boolean vazio = bancoProdutos.estaVazio();
                                    
                                    if (!vazio) {
                                        boolean pararID = false;

                                        while (!pararID) {
                                            String id = JOptionPane.showInputDialog("Digite o ID do produto a ser alterado (ENTER para sair)");
                                            if (!id.equals("")) {
                                                int idINT = Integer.parseInt(id);
                                                if (bancoProdutos.pesquisarProduto(idINT) != null) {
                                                    pararID = true;

                                                    boolean pararAlteracao = false;
                                                    while (!pararAlteracao) {
                                                        String opcAlteracao = JOptionPane.showInputDialog("""
                                                                                Qual dos atributos você deseja alterar? (ENTER para sair)
                                                                                
                                                                                1 - Quantidade
                                                                                2 - Nome
                                                                                3 - Descrição
                                                                                4 - Preço
                                                                                """);

                                                        if (!opcAlteracao.equals("")) {
                                                            int opcAlteracaoINT = Integer.parseInt(opcAlteracao);

                                                            switch (opcAlteracaoINT) {
                                                                case 1 -> {
                                                                    boolean pararQuantidade = false;

                                                                    while (!pararQuantidade) {
                                                                        String novaQuantidade = JOptionPane.showInputDialog("Digite a nova quantidade do produto (ENTER para sair)");
                                                                        if (!novaQuantidade.equals("")) {
                                                                            int novaQuantidadeINT = Integer.parseInt(novaQuantidade);
                                                                            if (novaQuantidadeINT < 0) {
                                                                                JOptionPane.showMessageDialog(null, "Valor inserido inválido! Tente novamente.");
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
                                                                                bancoProdutos.pesquisarProduto(idINT).setQuantidade(novaQuantidadeINT);
                                                                                bancoProdutos.pesquisarProduto(idINT).setData_modificacao(calendario.getDataHoje());
                                                                                pararQuantidade = true;
                                                                                pararAlteracao = true;
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                            pararAlteracao = true;
                                                                            pararQuantidade = true;
                                                                        }
                                                                    }
                                                                }
                                                                case 2 -> {
                                                                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome do produto (ENTER para sair)");
                                                                    if (!novoNome.equals("")) {
                                                                        JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                                                                        bancoProdutos.pesquisarProduto(idINT).setNome(novoNome);
                                                                        bancoProdutos.pesquisarProduto(idINT).setData_modificacao(calendario.getDataHoje());
                                                                        pararAlteracao = true;
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                        pararAlteracao = true;
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    String novaDescricao = JOptionPane.showInputDialog("Digite a nova descrição do produto (ENTER para sair)");
                                                                    if (!novaDescricao.equals("")) {
                                                                        JOptionPane.showMessageDialog(null, "Descrição alterada com sucesso!");
                                                                        bancoProdutos.pesquisarProduto(idINT).setDescricao(novaDescricao);
                                                                        bancoProdutos.pesquisarProduto(idINT).setData_modificacao(calendario.getDataHoje());
                                                                        pararAlteracao = true;
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                        pararAlteracao = true;
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    boolean pararPreco = false;
                                                                    if (!bancoCarrinhos.estaTodosVazio() && bancoItens_Carrinho.pesquisarTodosItens_Carrinho(idINT) != null && bancoItens_Carrinho.pesquisarTodosItens_Carrinho(idINT).getId_produto() == idINT){
                                                                        JOptionPane.showMessageDialog(null, "O preço está congelado.");
                                                                    } else {
                                                                        while (!pararPreco) {
                                                                            String novoPreco = JOptionPane.showInputDialog("Digite o novo preço do produto (ENTER para sair)");
                                                                            if (!novoPreco.equals("")) {
                                                                                double novoPrecoDOUBLE = Double.parseDouble(novoPreco);
                                                                                if (novoPrecoDOUBLE < 0) {
                                                                                    JOptionPane.showMessageDialog(null, "Valor inserido inválido! Tente novamente.");
                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(null, "Preço alterado com sucesso!");
                                                                                    bancoProdutos.pesquisarProduto(idINT).setPreco_venda(novoPrecoDOUBLE);
                                                                                    bancoProdutos.pesquisarProduto(idINT).setData_modificacao(calendario.getDataHoje());
                                                                                    pararPreco = true;
                                                                                    pararAlteracao = true;
                                                                                }
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                                                pararAlteracao = true;
                                                                                pararPreco = true;
                                                                            }
                                                                        }
                                                                    }
                                                                    
                                                                }
                                                                default ->
                                                                    JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                            pararAlteracao = true;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ID não encontrado, tente novamente.");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando alteração de produto...");
                                                pararID = true;
                                            }
                                        }
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Nao há produtos para alterar!");
                                }
                                case "3" -> {JOptionPane.showMessageDialog(null, bancoProdutos.toString(0));}
                                case "4" -> {
                                    
                                    boolean vazio = bancoProdutos.estaVazio();
                                    
                                    if(!vazio){
                                        String opc = JOptionPane.showInputDialog(null, "Digite o ID do produto que deseja remover (ENTER para sair)");
                                 
                                        if(!opc.equals("")){
                                            int opcInt = Integer.parseInt(opc);
                                            while(!opc.equals("") && !bancoProdutos.removerProduto(opcInt)){
                                                opc = JOptionPane.showInputDialog(null, "Digite o ID do produto que deseja remover (ENTER para sair)");

                                                if(!opc.equals("")){
                                                    opcInt = Integer.parseInt(opc);
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Cancelando exclusão de produto...");
                                                }
                                            }
                                        }
                                        else
                                            JOptionPane.showMessageDialog(null, "Cancelando exclusão de produto...");
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null, "Nao ha produtos a ser removidos!");
                                }
                                case "5" -> {}
                                default -> JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                            }
                        }
                    }
                    case "8" -> {
                        DateTimeFormatter dataDiaMesAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                
                        String novaData = JOptionPane.showInputDialog(
                                "Data atual do sistema: " + calendario.getDataHoje().format(dataDiaMesAno) +
                                "\n\nDigite a nova data do sistema (ENTER para sair):\nSiga o seguinte modelo: Dia/Mes/Ano");
                        if(!novaData.equals("")){
                            LocalDate novaDataSistema = LocalDate.parse(novaData, dataDiaMesAno);
                            calendario.setDataHoje(novaDataSistema);
                            JOptionPane.showMessageDialog(null, "Data alterada com sucesso!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cancelando alteração de data do sistema...");
                        }
                    }
                    case "9" -> {
                    }
                    case "10" -> {
                    }
                    case "11" -> {
                        
                    }
                    case "12" -> {
                        JOptionPane.showMessageDialog(null, "Deslogando...");
                    }
                    default ->
                        JOptionPane.showMessageDialog(null, "Insira uma opção válida!");
                }
            }
        }
        else{
            String inputPainelC = "";
            String painelCliente
                    = "Seja bem vindo, " + user.getPessoa().getNome() + "!\n\n Selecione uma das ações abaixo:\n\n"
                    + """
            1 - Manejar Carrinho
            2 - Ver Produtos à venda
            3 - Relatório de Pedidos
            4 - Deslogar
            """;

            while (!inputPainelC.equals("4")) {
                inputPainelC = JOptionPane.showInputDialog(painelCliente);
                switch (inputPainelC) {
                    case "1" -> {
                        //Ao finalizar gera um PEDIDO,  ITENS_PEDIDO e MOVIMENTACAO_ESTOQUE
                        boolean vazio = bancoCarrinhos.estaVazio(user.getId());
                        String resp = "";
                                    
                        if (!vazio) {

                            while (!resp.equals("0") && !resp.equals("3")) {
                                resp = JOptionPane.showInputDialog(null, bancoItens_Carrinho.toString(1, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()) + """
                                                                    \n\nSelecione uma das ações abaixo: (ENTER para sair)

                                                                    1 - Remover itens do carrinho
                                                                    2 - Finalizar carrinho
                                                                    3 - Cancelar carrinho
                                                                    0 - Sair do carrinho                      
                                                                    """);
                                
                                switch (resp) {
                                    case "1" -> {
                                        boolean pararID = false;

                                        while (!pararID) {
                                            String id = JOptionPane.showInputDialog(null, bancoItens_Carrinho.toString(1, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()) + "\n\nDigite o ID do produto que deseja remover (ENTER para sair)");
                                            if (!id.equals("")) {
                                                int idINT = Integer.parseInt(id);
                                                if (bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()) != null && bancoItens_Carrinho.jaExiste(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId())) {
                                                    pararID = true;

                                                    boolean pararRemoção = false;
                                                    while (!pararRemoção) {
                                                        String opcQuantidade = JOptionPane.showInputDialog("""
                                                                                Digite a quantidade do produto a ser removido: (ENTER para sair)""");

                                                        if (!opcQuantidade.equals("")) {
                                                            int opcQuantidadeINT = Integer.parseInt(opcQuantidade);

                                                            if (opcQuantidadeINT <= bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getQuantidade() && opcQuantidadeINT > 0) {
                                                                JOptionPane.showMessageDialog(null, "Produto Removido.");
                                                                
                                                                if(opcQuantidadeINT == bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getQuantidade()){
                                                                    bancoProdutos.retornarProduto(idINT, bancoCarrinhos, bancoItens_Carrinho, user.getId(), opcQuantidadeINT);
                                                                    bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setQuantidade(bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getQuantidade()-opcQuantidadeINT);
                                                                    bancoCarrinhos.pesquisarCarrinho(user.getId()).setData_modificacao(calendario.getDataHoje());
                                                                    bancoItens_Carrinho.removerItens_Carrinho(bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getId());
                                                                }else{
                                                                    bancoProdutos.retornarProduto(idINT, bancoCarrinhos, bancoItens_Carrinho, user.getId(), opcQuantidadeINT);
                                                                    bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setQuantidade(bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getQuantidade()-opcQuantidadeINT);
                                                                    bancoCarrinhos.pesquisarCarrinho(user.getId()).setData_modificacao(calendario.getDataHoje());
                                                                    bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setData_modificacao(calendario.getDataHoje());
                                                                }
                                                                if(bancoItens_Carrinho.estaVazio(bancoCarrinhos.pesquisarCarrinho(user.getId()).getId())){
                                                                    bancoCarrinhos.removerCarrinho(bancoCarrinhos.pesquisarCarrinho(user.getId()).getId());
                                                                    resp = "0";
                                                                }
                                                                pararRemoção = true;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Cancelando remoção de produto...");
                                                            pararRemoção = true;
                                                        }
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ID não encontrado, tente novamente.");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando remoção de produto...");
                                                pararID = true;
                                            }
                                        }
                                    }
                                    case "2" -> {}
                                    case "3" -> {
                                        bancoProdutos.retornarProdutos(bancoCarrinhos, bancoItens_Carrinho, user.getId());
                                        bancoCarrinhos.pesquisarCarrinho(user.getId()).setData_modificacao(calendario.getDataHoje());
                                        bancoCarrinhos.pesquisarCarrinho(user.getId()).setStatus("Cancelado");
                                        JOptionPane.showMessageDialog(null, "Cancelando carrinho...");
                                    }
                                    case "0" -> {JOptionPane.showMessageDialog(null, "Saindo do carrinho...");}
                                    default -> JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente");
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Não há itens no carrinho!");
                    }
                    case "2" -> {
                        boolean vazio = bancoProdutos.estaVazio();
                                    
                        if (!vazio) {
                            boolean pararID = false;

                            while (!pararID) {
                                String id = JOptionPane.showInputDialog(null, bancoProdutos.toString(1) + "\n\nDigite o ID do produto que deseja comprar (ENTER para sair)");
                                if (!id.equals("")) {
                                    int idINT = Integer.parseInt(id);
                                    if (bancoProdutos.pesquisarProduto(idINT) != null && bancoProdutos.pesquisarProduto(idINT).isAtivo()) {
                                        pararID = true;

                                        boolean pararCompra = false;
                                        while (!pararCompra) {
                                            String opcQuantidade = JOptionPane.showInputDialog("""
                                                                    Digite a quantidade do produto a ser comprado: (ENTER para sair)""");

                                            if (!opcQuantidade.equals("")) {
                                                int opcQuantidadeINT = Integer.parseInt(opcQuantidade);

                                                if (opcQuantidadeINT <= bancoProdutos.pesquisarProduto(idINT).getQuantidade() && opcQuantidadeINT > 0) {
                                                    String opcCompra = JOptionPane.showInputDialog("""
                                                                            Selecione uma das ações abaixo: (ENTER para sair)

                                                                            1 - Adicionar ao carrinho
                                                                            2 - Comprar diretamente
                                                                            """);

                                                    if (!opcCompra.equals("")) {
                                                        int opcCompraINT = Integer.parseInt(opcCompra);

                                                        switch (opcCompraINT) {
                                                            case 1 -> {
                                                                if(!bancoCarrinhos.jaExiste(user.getId())){
                                                                    Carrinho novoCarrinho = new Carrinho(user, calendario.getDataHoje(), bancoCarrinhos);
                                                                    Itens_Carrinho novoItens_Carrinho = new Itens_Carrinho(novoCarrinho, bancoProdutos.pesquisarProduto(idINT), opcQuantidadeINT, calendario.getDataHoje(), bancoItens_Carrinho);
                                                                } else {
                                                                    bancoCarrinhos.pesquisarCarrinho(user.getId()).setData_modificacao(calendario.getDataHoje());
                                                                    if(bancoItens_Carrinho.jaExiste(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId())){
                                                                        bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setQuantidade(bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).getQuantidade()+opcQuantidadeINT);
                                                                        bancoProdutos.pesquisarProduto(idINT).setQuantidade(bancoProdutos.pesquisarProduto(idINT).getQuantidade() - opcQuantidadeINT);
                                                                        bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setData_modificacao(calendario.getDataHoje());
                                                                    }else{
                                                                        Itens_Carrinho novoItens_Carrinho = new Itens_Carrinho(bancoCarrinhos.pesquisarCarrinho(user.getId()), bancoProdutos.pesquisarProduto(idINT), opcQuantidadeINT, calendario.getDataHoje(), bancoItens_Carrinho);
                                                                        bancoItens_Carrinho.pesquisarItens_Carrinho(idINT, bancoCarrinhos.pesquisarCarrinho(user.getId()).getId()).setData_modificacao(calendario.getDataHoje());
                                                                    }
                                                                }
                                                                pararCompra = true;
                                                            }
                                                            case 2 -> {
                                                                //Gera um PEDIDO,  ITENS_PEDIDO e MOVIMENTACAO_ESTOQUE
                                                                pararCompra = true;
                                                            }
                                                            default ->
                                                                JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Cancelando compra de produto...");
                                                        pararCompra = true;
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Insira um valor válido!");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Cancelando compra de produto...");
                                                pararCompra = true;
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ID não encontrado, tente novamente.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cancelando compra de produto...");
                                    pararID = true;
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null, bancoProdutos.toString(1));
                        
                    }
                    case "3" -> {
                    }
                    case "4" -> {JOptionPane.showMessageDialog(null, "Deslogando..");}
                    default ->
                        JOptionPane.showMessageDialog(null, "Insira uma opção válida!");
                }
            }
        }
    }
}
