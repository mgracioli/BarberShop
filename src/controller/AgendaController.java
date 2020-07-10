/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.Agenda;
import controller.helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import servico.Correio;

/**
 *
 * @author miche
 */
public class AgendaController {

    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualiza_tabela() {
        //buscar uma lista do banco de dados com os agendamentos 
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        //exibir a lista na view
        helper.preencher_tabela(agendamentos);
    }

    //função que pega os clientes do banco de dados e joga nos respectivos campos da agenda
    public void atualiza_cliente() {
        //metodo para buscar os clientes no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        //metodo para exibir os dados no combobox
        helper.preencher_clientes(clientes);
    }

    public void preencher_servico() {
        //metodo para buscar os servicos no banco de dados
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        //metodo para exibir os servicos no combobox
        helper.preencher_servico(servicos);
    }

    public void atualiza_valor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }

    public void agendar() {
        //buscar objeto agendamento da tela (pega das txt e combo box)
        Agendamento agendamento = helper.obterModelo();
        //salvar objeto agendamento no banco de dados
        new AgendamentoDAO().insert(agendamento);

        //enviando o email de confirmação do agendamento
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);

        //atualizar a tabela para ela mostrar o novo conteudo
        atualiza_tabela();
        helper.limpar_tela();
    }

}
