//IHelper é uma interface. Qualquer tipo de helper que for criado nesse projeto tem q herdar essa interface e, com isso, o programador fica obrigado a implementar as funções q estão aqui nessa interface, é intereesante pq assim, eu garanto que nenhum helper criado vai deixar de implementar funções essenciais que precisam estar em todo Helper

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

/**
 *
 * @author miche
 */
//as interfaces são obrigatoriamente publicas
//interfaces são como contratos, as classes que implementam as interfaces devem, obrigatoriamente, implementar as funções que estão declaradas na interface
//uma das vantagens das interfaces é que, se outro programador pegar o seu código e ele quiser criar um outro tipo de helper (no caso desse programa), ele já vai saber quais metodos obrigatoriamente ele vai ter q implementar
public interface IHelper {
    //declarar métodos abstratos, ou seja, métodos que deverão ser desenvolvidos/implementados nas subclasses. Quando a classe que contiver métodos abstratos for herdada, os referidos métodos deverão ser implementados, caso contrário, a classe que extendeu deverá ser declarada como abstrata.
    //um metodo/classe abstract significa que ela não deve ser instanciada, ela só serve para ser utilizada como classe pai para outras classes 
    //todo metodo de uma classe abstract é, por sua vez: public, abstract e void.
    Object obterModelo();  //aqui eu retorno Objetc pq dai eu consigo retornar qualquer tipo objeto quando eu implementar essa função, no caso desse programa, eu posso retornar Objetos do tipo Agendamento, do tipo Cliente, do tipo Servico, do tipo Login e assim vai
    void limpar_tela();
}
