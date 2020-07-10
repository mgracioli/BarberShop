/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import model.Agendamento;

/**
 *
 * @author miche
 */
public class Correio {
    
    public void notificarPorEmail(Agendamento agendamento){
        String emailFormatado = formatarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        //usando a classe de email
        Email email = new Email("Agendamento BarberShop", emailFormatado, destinatario); //campos: assunto do email, corpo do email, destinatario
        email.enviar();
    }

    private String formatarEmail(Agendamento agendamento) {
       String nomeCliente = agendamento.getCliente().getNome();
       String servico = agendamento.getServico().getDescricao();
       String dataAgendamento = agendamento.getDataFormatada();
       String horaAgendamento = agendamento.getHoraFormatada();
       float valor = agendamento.getValor();
       
       return "Olá "+ nomeCliente +" vai dar uma tapa no visual? Seu agendamento para: "+ 
               servico +" está marcado para o dia "+ dataAgendamento +" às "+ 
               horaAgendamento +" . O preço será de R$ "+ valor +".";
    }
}
