/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author miche
 */
public class Cliente extends Pessoa{ //o extends significa que essa classe é uma extensão (um braço) da classe Pessoa, é como se essa fosse uma classe filha da classe Pessoa, ela herda os atributos da classe Pessoa
    private String endereco;
    private String cep;
    private String getNome;
    
    //primeiro metodo construtor
    public Cliente(int id, String nome, char sexo, String data_nascimento, String telefone, String email, String rg, String endereco, String cep) {
        super(id, nome, sexo, telefone, email, rg, data_nascimento); //super é o construtor da classe Pai (que é uma superclasse), que, no caso, é a classe Pessoas
        this.endereco = endereco;
        this.cep = cep;
    }
    
    //segundo metodo construtor
    public Cliente(int id, String nome, String endereco, String cep) {
        super(id, nome); //super é o construtor da superclasse, ou seja, a classe pai
        this.endereco = endereco;
        this.cep = cep;
    }   
    
    //os getters e setter da variavel nome e id eu nao preciso pois já estão na superclasse
    //inicio dos getters e setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    // fim dos getters e setters
    
    //override serve para sobrescrever o metodo da superclasse. Como essa classe aqui é uma classe filha da superclasse Pessoa() (perceber lá em cima: public class Cliente extends Pessoa()) o seu método toString é o mesmo do da classe pai (o metodo toString existe em todas as classes q vc cria, é um metodo embutido na classe), o override permite que voce mude o comportamento dessa função toString que vai funcionar de forma diferente somente nessa classe aqui, caso um dia voce mude o nome da função toString da classe pai, o programa gera um aviso de que esse override nao estar mais sobrescrevendo nada, assim voce sabe que tem q arrumar o nome da função aqui também
    @Override
    public String toString(){
        //esse metodo é para o programa nao retornar o endereço de referencia da string e, sim, o nome da pessoa
        return getNome();
    }
    
}
