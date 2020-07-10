//classe de testes para testar se o codigo para envio de email está funcionando, quando eu tentei, nao estava funcionando

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EmailTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Email email = new Email("teste assunto envio email", "Teste mensagem do email", "email_do_remetente");
        
        email.enviar();
    }
}
