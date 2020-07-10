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
import javax.swing.JOptionPane;

/**
 *
 * @author miche
 */
public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date data; //aqui eu passo como tipo Date, no construtor eu passo como String. O que acontece é que, na hora de instanciar essa classe, eu vou passar a data e a hora como uma string, depois, la no try...catch ele vai transformar essa string em uma variavel do tipo Date, por isso usa o comando .parse(data), o comando parse serve para converter variaveis de um tipo em outro tipo
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data); //o parse transforma um objeto de um tipo em outro tipo, no caso, vai transformar uma string em um tipo Date (que é o tipo da variavel data);
        } catch (ParseException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //segundo construtor
    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String observacao) {
        //poderia copiar e colar tudo o que ja tem no construtor la em cima e só adicionar a parte da variavel observação, mas ele fez de um modo diferente a titulo de conhecimento
        this(id, cliente, servico, valor, data);
        this.observacao = observacao;
    }
    
    //inicio getters e setters 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    
    //metodo para deixar a data formatada só com dd/MM/yyyy
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    //metodo para deixar a data formatada só com as horas e minutos
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //fim dos getters e setters
    
    
    
}
