//O controller faz a ligação entre a VIEW e o MODEL
//poderia fazer tudo isso daqui do CONTROLLER dentro do VIEW mas não estaria de acordo com a MVC

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.DAO.UsuarioDAO;
import View.Login;
import View.MenuPrincipal;
import controller.helper.LoginHelper;
import model.Usuario;

/**
 *
 * @author miche
 */
public class LoginController {

    private final Login view; //crio uma variavel Login para poder instanciar a classe Login, nesse caso ela nao precisara ser iinstanciada pq ela vai ser chamada como parametro no metodo construtor)
    private final LoginHelper helper; //crio uma variavel do tipo LoginHelper
    
    //metodo construtor
    public LoginController(Login view) { //esse view aqui é a propria classe Login que eu passei como parametro lá na classe Login
        this.view = view;  //o objeto view (do tipo Login) que eu criei ali em cima (o view que faz parte dessa classe) vai receber a classe Login lá do pacote view
        this.helper = new LoginHelper(view); //instancio a classe LoginHelper usando minha variavel helper
    }
    
    
    public void entrar_no_sistema(){
        //comando para pegar o usuario e senha da view usando o helper 
        Usuario usuario = helper.obter_modelo();
        
        //pesquisar o usuario no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario); //o usuario que está aqui entre parenteses é o usuario e senha que for digitado la nas caixas da tela de Login, quando chamar a função entrar no sistema, o LoginHelper vai criar um objeto usuario com o nome e senha fornecidos e vai retornar ele para a variavel usuario (aquele que chama a função helper.obter_modelo()), esse usuario é, entao passado para a função selectPorNomeESenha(), a qual vai verificar se o nome e senha passados correspondem a algum nome e senha do banco de dados
        
        //se o usuario for encontrado no banco, redireciona para a tela de Menu, senao mostra uma mensagem de erro
        if(usuarioAutenticado != null){
            //ir para o menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        } else{
            view.exibeMensagem("Usuario e/ou senha inválidos");
        }
    }

}
