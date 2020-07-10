/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miche
 */

/*
*uma classe abstrata significa que eu nao posso/não consigo instanciar essa classe. Nesse caso, na barbearia, eu só posso ter 
*ou um cliente, ou um usuário, nao posso ter uma Pessoa, sendo assim, a classe pessoa somente esta aí para fornecer seus métodos 
*e atributos para as classes Cliente e Usuário
*/
abstract class Pessoa {
    //o modificador protected permite que essas variaveis sejam acessadas pela classe Pessoa e pelas classes Usuario e Cliente, que são classes derivadas ,ou classes "filhas" da  classe "Pessoa"
    protected int id;
    protected String nome;
    protected char sexo;
    protected String telefone;
    protected String email;
    protected String rg;
    protected Date data_nascimento;
    
    //primeiro metodo construtor
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    //segundo metodo construtor
    public Pessoa(int id, String nome, char sexo, String telefone, String email, String rg, String data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        try {
            this.data_nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data_nascimento); //o parse transforma um objeto de um tipo em outro tipo, no caso, vai transformar uma string em um tipo Date (que é o tipo da variavel data);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //inicio dos getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    //fim dos getters e setters
    
    
    
}
