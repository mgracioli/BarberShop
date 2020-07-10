/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author miche
 */
public class Usuario extends Pessoa{
    protected String nivel_acesso; //protected permite acesso à essa variavel somente por esse pacote ou por classes herdadas
    protected String senha;

    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    public Usuario(int id, String nome, char sexo, String data_nascimento, String telefone, String email, String rg, String senha, String nivel_acesso) {
        super(id, nome, sexo, telefone, email, rg, data_nascimento);
        this.nivel_acesso = nivel_acesso;
        this.senha = senha;
    }
 
    //inicio dos getters e setters
    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    //fim dos getters e setters
    
}
