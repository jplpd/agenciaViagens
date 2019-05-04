package telas;

import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOEstado;
import entidade.Cidade;
import entidade.Estado;


public class TelaCidade {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Salvar \n 2 - Alterar \n 3 - Excluir \n 4 -Consultar  \n 5 - Sair";
	
	public TelaCidade() {

		int num = 0;
		do {
			do {
				System.out.println(menu);
				num = scan.nextInt();
				scan.nextLine();
			}while(num < 1 && num > 5);
			if (num == 1) {
				Cidade cidade = new Cidade();
				Estado estado = new Estado();
				DAOCidade dao = new DAOCidade();
				DAOEstado daoE = new DAOEstado();
				System.out.println("Digite o nome da cidade:");
				String nomeCidade = scan.nextLine();
				cidade.setNomeCidade(nomeCidade);
				
				System.out.println("Digite a id do estado:");
				long idEstado = scan.nextLong();
				estado.setIdEstado(idEstado);
				cidade.setEstado(estado);
				
				dao.inserir(cidade);
				
			}
			else if (num == 2) {
				Cidade cidade = new Cidade();
				Estado estado = new Estado();
				DAOCidade dao = new DAOCidade();
				DAOEstado daoE = new DAOEstado();
				System.out.println("Digite o id:");
				long id= Integer.parseInt(scan.nextLine());
				cidade.setId(id);
				System.out.println("Digite o nome da cidade:");
				String nomeCidade = scan.nextLine();
				cidade.setNomeCidade(nomeCidade);
				
				System.out.println("Digite a id do estado:");
				long idEstado = scan.nextLong();
				estado.setIdEstado(idEstado);
				cidade.setEstado(estado);
				 
				dao.alterar(cidade);
				
			}
			else if (num == 3) {
				Cidade cidade = new Cidade();
				DAOCidade dao = new DAOCidade();
				System.out.println("Digite o id:");
				long id = scan.nextInt();
				cidade.setId(id);
				dao.excluir(cidade);
			}
			else if (num == 4) {
				DAOCidade dao = new DAOCidade();
				Estado estado = new Estado();
				
				System.out.println("-------Lista das Cidades-------");
				
				List<Cidade> cid = dao.buscar();
				
				for (Cidade cidade : cid) {
					System.out.println("ID: "+cidade.getId()+", Nome da Cidade: "+cidade.getNomeCidade()+", ID Estado: "+cidade.getEstado());
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
