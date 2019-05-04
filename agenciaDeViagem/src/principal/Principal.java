package principal;

import java.text.ParseException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOEstado;
import entidade.Estado;
import telas.TelaCidade;
import telas.TelaCliente;
import telas.TelaEstado;
import telas.TelaHospedagem;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("agenciaViagem");
		EntityManager gerenciador = fabrica.createEntityManager(); 
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Escolha uma opção: \n 1 - Estado \n 2 - Cidade \n 3 - Cliente \n 4 - Hospedagem");
		Integer num = Integer.parseInt(scan.nextLine()); 
		
		if (num == 1) { 
			TelaEstado t = new TelaEstado();  
			
		}
		else if (num == 2) {
			TelaCidade c = new TelaCidade();
			
		}
		else if (num == 3) {
			TelaCliente cl =new TelaCliente();
		}
		else if (num == 4) {
			TelaHospedagem h =new TelaHospedagem();
		}
		
	}

}
