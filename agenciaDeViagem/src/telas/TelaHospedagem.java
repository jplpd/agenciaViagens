package telas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOHospedagem;
import entidade.Cidade;
import entidade.Hospedagem;

public class TelaHospedagem {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Salvar \n 2 - Alterar \n 3 - Excluir \n 4 -Consultar  \n 5 - Sair";
	
	public TelaHospedagem()  {

		int num = 0;
		do {
			do {
				System.out.println(menu);
				num = scan.nextInt();
				scan.nextLine();
			}while(num < 1 && num > 5);
			if (num == 1) {
				
				Hospedagem hosp =new Hospedagem();
				Cidade cidade = new Cidade();
				DAOHospedagem dao = new DAOHospedagem();
				DAOCidade daoc = new DAOCidade();
				
				System.out.println("Digite o nome da Hospedagem:");
				String nomeHopedagem = scan.nextLine();
				hosp.setNomeHopedagem(nomeHopedagem);
				
				System.out.println("Digite o valor da diaria:");
				Double valorDiaria = Double.parseDouble(scan.nextLine());
				hosp.setValorDiaria(valorDiaria);
				
				System.out.println("Digite o valor total da hospedagem:");
				Double valorTotalHopedagem = Double.parseDouble(scan.nextLine());
				hosp.setValorTotalHopedagem(valorTotalHopedagem);
				
				System.out.println("Digite a id da cidade:");
				long id = scan.nextLong();
				cidade.setId(id);;
				hosp.setCidade(cidade);
				
				dao.inserir(hosp);
				
			}
			else if (num == 2) {
				Hospedagem hosp =new Hospedagem();
				Cidade cidade = new Cidade();
				DAOHospedagem dao = new DAOHospedagem();
				DAOCidade daoc = new DAOCidade();
				
				System.out.println("Digite o ID:");
				long idHospedagem = Integer.parseInt(scan.nextLine());
				hosp.setIdHospedagem(idHospedagem);
				
				System.out.println("Digite o nome da Hospedagem:");
				String nomeHopedagem = scan.nextLine();
				hosp.setNomeHopedagem(nomeHopedagem);
				
				System.out.println("Digite o valor da diaria:");
				Double valorDiaria = Double.parseDouble(scan.nextLine());
				hosp.setValorDiaria(valorDiaria);
				
				System.out.println("Digite o valor total da hospedagem:");
				Double valorTotalHopedagem = Double.parseDouble(scan.nextLine());
				hosp.setValorTotalHopedagem(valorTotalHopedagem);
				
				System.out.println("Digite a id da cidade:");
				long id = scan.nextLong();
				cidade.setId(id);;
				hosp.setCidade(cidade);

				dao.alterar(hosp);
				
			}
			else if (num == 3) {
				Hospedagem hosp =new Hospedagem();
				Cidade cidade = new Cidade();
				DAOHospedagem dao = new DAOHospedagem();
				DAOCidade daoc = new DAOCidade();
				
				System.out.println("Digite o ID:");
				long idHospedagem = Integer.parseInt(scan.nextLine());
				hosp.setIdHospedagem(idHospedagem);
				
				dao.excluir(hosp);
			}
			else if (num == 4) {
				DAOHospedagem dao = new DAOHospedagem();
				
				System.out.println("-------Lista das Cidades-------");
				
				List<Hospedagem> hos= dao.buscar();
				
				for (Hospedagem hosp : hos) {
					System.out.println("ID: "+hosp.getIdHospedagem()+", Nome da Hospedagem: "+hosp.getNomeHopedagem()+
							", Valor da Diaria "+hosp.getValorDiaria()+", Valor Total: "+hosp.getValorTotalHopedagem()+
							", Cidade: "+hosp.getCidade());
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
