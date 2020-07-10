/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helper;

import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Cliente;
import model.Servico;

/**
 *
 * @author miche
 */
public class AgendaHelper implements IHelper {

    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencher_tabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel(); //o getModel é porque eu quero mexer no conteúdo/variaveis da tabela (no Model dela, como se fosse um MVC)
        tableModel.setNumRows(0); //seta o numero de linhas dessa tableModel em  pq eu  vou adicionar as linhas que eu quiser ali embaixo
        //percorrendo a lista de agendamentos (o arrayList<Agendamento>) preenchendo o tableModel
        //no codigo abaixo, eu vou adicionar linhas no meu tabelModel e em cada linha eu adiciono um Object que é, por sua vez, um objeto que contém as informações especificadas (id, nome do cliente, a descrição do serviço...)
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao(),});
        }
    }

    public void preencher_clientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCbboxCliente().getModel();
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente); //aqui nao precisa do cliente.getNome() porque lá na Classe cliente do model foi feito o override. Como cliente é um objeto (objeto do tipo Cliente) Se eu passasse só cliente como parametro (sem o .getNome()), o programa chamaria o metodo toString e me retornaria o codigo de referencia dessa string e, nao, o nome do cliente, que é o que eu quero, sendo assim, eu faço o override la na classe Cliente para que o metodo toString retorne o nome do cliente e nao a referencia do objeto cliente
        }
    }

    public void preencher_servico(ArrayList<Servico> servicos) {
        var comboBoxModel = (DefaultComboBoxModel) view.getCbboxServico().getModel();
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
    }

    public Cliente obterCliente() {
        return (Cliente) view.getCbboxCliente().getSelectedItem();
    }

    public Servico obterServico() {
        return (Servico) view.getCbboxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTextValor().setText(valor + ""); //tem que concatenar com uma string pq dai o valor passa a ser uma string tbm e não mais float. O metodo setText() só trabalh com strings
    }

    @Override //Override porque esse método está declarado la na interface IHelper e, aqui eu vou sobrescrever esse metodo (na verdade la no IHelper ele só tem a assinatura do método, nao tem codigo para ele, mas é como se tivesse)
    public Agendamento obterModelo() {
        //perceber o polimorfismo que acontece aqui: essa classe obterModelo é uma classe que vem la da interface IHelper e, por isso eu sou obrigado a implementar ela aqui, perceber que o retorno dessa função será um objeto do tipo Agendamento, isso só é possível pq la na interface IHelper eu declarei, na assinatura dessa função, que ela deveira retornar um tipo Object, sendo assim, ela pode retornar qualquer tipo de objeto que eu quiser
        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString); //converter a string id em int
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        String valorString = view.getTextValor().getText();
        float valor = Float.parseFloat(valorString);
        String data = view.getTxtAgendaData().getText();
        String hora = view.getTextFormatedHora().getText();
        //String dataHora = data + " " + hora;
        String dataHora = "22/05/2020 10:30"; //o certo seria fazer: String dataHora = data+" "+hora; mas, por algum motivo, nao esta funcionando
        String observacao = view.getTextObservacao().getText();
        //criar o agendamento
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        return agendamento;
    }

    @Override
    public void limpar_tela() {
        view.getTextId().setText("0");
        view.getTxtAgendaData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }

}
