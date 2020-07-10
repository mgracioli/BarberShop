//helper é um pacote que contem classes responsaveis por pegar os dados da tela e gerenciá-los, assim eu nao preciso poluir demais a minha classe LoginController cuja função é só gerenciar todas as tarefas

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import View.Login;
import model.Usuario;

/**
 *
 * @author miche
 */
//o implements IHelper é pq eu quero que a classe Loginhelper obrigatoriamente tenha que implementar os metodos da interfaceclasse Ihelper 
public class LoginHelper implements IHelper{
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obter_modelo(){
        //comando para pegar o usuario e senha da view
        String nome = view.getTextUsuario().getText(); //pega o campo text usuario e pega o nome que está la dentro
        String senha = view.getTextSenha().getText();
        
        Usuario modelo = new Usuario(0, nome, senha);
        
        return modelo;
    } 
    
    public void setar_modelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha(); 
        
        view.getTextUsuario().setText(nome); //pega o campo text usuario e seta, la dentro, o nome que eu passei como parametro
        view.getTextSenha().setText(senha);
    }
    
    @Override //o override serve para sobrescrever o metodo da classe pai, no caso, como é uma interface, ja nao tem descrição de metodo la, porém, se tivesse, ele seria sobrescrito
    public void limpar_tela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }

    @Override
    public Object obterModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
