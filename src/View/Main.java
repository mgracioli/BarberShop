package View;

//essa classe é só de teste, nao usa no programa de verdade
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;

public class Main {
    
    public static void main(String[] args) {
        String nome = "Thiago";
                
        Servico barba = new Servico(1, "barba", 30);
        
        Cliente cliente = new Cliente(1, "Joao", "Rua 21, 2451", "1350666");
                
        Usuario usuario = new Usuario(1, "admin ", "admin");
                
        Agendamento agendamento = new Agendamento(1, cliente, barba, 37, "12/07/2019 11:00");
        
        System.out.println(agendamento.getCliente().getCep());
        System.out.println(agendamento.getCliente().getNome());
    }  
}
