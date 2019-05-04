package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOCidade;
import dao.DAOEstado;
import entidade.Cidade;
import entidade.Estado;

public class TelaEstado {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Salvar \n 2 - Alterar \n 3 - Excluir \n 4 -Consultar  \n 5 - Sair";
	public TelaEstado() {

		int num = 0;
		do {
			do {
				System.out.println(menu);
				num = scan.nextInt();
				scan.nextLine();
			}while(num < 1 && num > 5);
			if (num == 1) {
				Estado estado = new Estado();
				DAOEstado dao = new DAOEstado();
				System.out.println("Digite o nome do estado:");
				String nomeEstado = scan.nextLine();
				estado.setNomeEstado(nomeEstado); 
				
				System.out.println("Digite a sigla do estado:");
				String sigla = scan.nextLine();
				estado.setSigla(sigla);
			
				dao.inserir(estado);
			
			}
			else if (num == 2) {
				Estado estado = new Estado();
				DAOEstado dao = new DAOEstado();
				System.out.println("Digite o id:");
				long idEstado = Integer.parseInt(scan.nextLine());
				estado.setIdEstado(idEstado);
				System.out.println("Digite o nome do estado:");
				String nomeEstado = scan.nextLine();
				estado.setNomeEstado(nomeEstado);
			
				System.out.println("Digite a sigla do estado:");
				String sigla = scan.nextLine();
				estado.setSigla(sigla);
				
				dao.alterar(estado);
				
			}
			else if (num == 3) {
				Estado estado = new Estado();
				DAOEstado dao = new DAOEstado();
				System.out.println("Digite o id:");
				long idEstado = scan.nextLong();
				estado.setIdEstado(idEstado);
				
				dao.excluir(estado); 
			}
			else if (num == 4) {
				DAOEstado dao = new DAOEstado();
				
				System.out.println("------Lista das Cidades------");
				
				List<Estado> est = dao.buscar();
				
				for (Estado estado : est) {
					System.out.println("ID: "+estado.getIdEstado()+", Nome do Estado: "+estado.getNomeEstado()+", Sigla do Estado: "+estado.getSigla());
				}
								
			}
			else if (num == 5) {
				System.out.println("-------Programa Fechado-------");
				
			}
			else {
				System.out.println("-------Opção Invalida-------");
			}
		
		}while(num != 5);
	}
}

