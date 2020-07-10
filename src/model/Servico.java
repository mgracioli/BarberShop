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
public class Servico {
    
    //somente a classe Servico tera acesso às variaveis id, descricao e valor pq elas sao private
    private int id;
    private String descricao;
    private float valor;
    private String getDescricao;

    //para criar o método construtor: alt+Insert
    //o metodo construtor serve para informar quais variaveis e funçoes que obrigatoriamente estarao presentes quando rodar essa classe, nesse caso, as variaveis id, valor e descrição obrigatoriamente deverao ser passados como parametro na hora que essa classe for instanciada em alguma outra parte do programa
    public Servico(int id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    //inicio dos getters e setters, getters e setters são informações das variaveis q eu posso acessar de fora dessa classe (Servico)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // fim dos getters e setters
    
    @Override
    public String toString(){
        return getDescricao();
    }

}