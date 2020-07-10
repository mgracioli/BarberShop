/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Classe responsável por enviar E-mail.
 * @author Denner Dias
 */
public class Email {
    static final String REMETENTE_NOME = "colocar_email";
    static final String REMETENTE_SENHA = "colocar_senha";
    private String assunto ;
    private String mensagem;
    private String destinatario;
    
    /**
     * 
     * @param assunto  Assunto para envio do E-mail.
     * @param mensagem  Mensagem qual vai ser enviado ao destinatário.
     * @param destinatario  E-mail do destinatário.
     */
    public Email(String assunto, String mensagem, String destinatario) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }
    
    //inicio dos getters e setters
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    //fim dos getters e setters
    
    /**
     * Função para enviar o e-mail ao destinatário.
     */
    public void enviar (){
        //a classe SimpleEmail está nas bibliotecas q foram importadas
        SimpleEmail email = new SimpleEmail();
            email.setSSLOnConnect(true);
            email.setHostName("smtp.gmail.com"); //o protocolo de transferencia de e-mail é o do gmail (por isso é bom usar um email do gmail como email do emissor)
            email.setSslSmtpPort("465");
       email.setAuthenticator(new DefaultAuthenticator(REMETENTE_NOME, REMETENTE_SENHA));
       try {
           email.setFrom(REMETENTE_NOME);

           email.setDebug(true);

           email.setSubject(this.assunto);
           email.setMsg(this.mensagem);
           email.addTo(this.destinatario);//por favor trocar antes de testar!!!!

           email.send();

       } catch (EmailException e) {
           e.printStackTrace();
       }
    }
}
