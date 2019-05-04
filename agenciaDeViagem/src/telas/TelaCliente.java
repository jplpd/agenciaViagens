package telas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOCliente;
import entidade.Cidade;
import entidade.Cliente;


public class TelaCliente {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Salvar \n 2 - Alterar \n 3 - Excluir \n 4 -Consultar  \n 5 - Sair";
	
	public TelaCliente() throws ParseException {

		int num = 0;
		do {
			do {
				System.out.println(menu);
				num = scan.nextInt();
				scan.nextLine();
			}while(num < 1 && num > 5);
			if (num == 1) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				Cliente cliente =new Cliente();
				Cidade cidade = new Cidade();
				DAOCliente dao = new DAOCliente();
				DAOCidade daoc = new DAOCidade();
				
				System.out.println("Digite o nome do cliente:");
				String nome = scan.nextLine();
				cliente.setNome(nome);
				
				System.out.println("Digite o endereço do cliente:");
				String endereco = scan.nextLine();
				cliente.setEndereco(endereco);
				
				
				System.out.println("Digite o CPF:");
				String cpf = scan.nextLine();
				cliente.setCpf(cpf);
				
				
				System.out.println("Digite a data de nascimento:");
				String data = scan.nextLine();
				java.sql.Date dtAniversario = new java.sql.Date(format.parse(data).getTime());
				cliente.setDtAniversario(dtAniversario);
				
				
				System.out.println("Digite o telefone:");
				String telefone = scan.nextLine();
				cliente.setTelefone(telefone);
				
				
				System.out.println("Digite a id da cidade:");
				long id = scan.nextLong();
				cidade.setId(id);;
				cliente.setCidade(cidade);
				
				dao.inserir(cliente);
				
			}
			else if (num == 2) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				Cliente cliente =new Cliente();
				Cidade cidade = new Cidade();
				DAOCliente dao = new DAOCliente();
				DAOCidade daoc = new DAOCidade();
				
				System.out.println("Digite a ID do Clietne:");
				long idCliente = Integer.parseInt(scan.nextLine());
				cliente.setIdCliente(idCliente);
						
				System.out.println("Digite o nome do cliente:");
				String nome = scan.nextLine();
				cliente.setNome(nome);
				
				System.out.println("Digite o endereço do cliente:");
				String endereco = scan.nextLine();
				cliente.setEndereco(endereco);
				
				
				System.out.println("Digite o CPF:");
				String cpf = scan.nextLine();
				cliente.setCpf(cpf);
				
				
				System.out.println("Digite a data de nascimento:");
				String data = scan.nextLine();
				java.sql.Date dtAniversario = new java.sql.Date(format.parse(data).getTime());
				cliente.setDtAniversario(dtAniversario);
				
				
				System.out.println("Digite o telefone:");
				String telefone = scan.nextLine();
				cliente.setTelefone(telefone);
				
				
				System.out.println("Digite a id da cidade:");
				long id = scan.nextLong();
				cidade.setId(id);;
				cliente.setCidade(cidade);
				
				 
				dao.alterar(cliente);
				
			}
			else if (num == 3) {
				Cliente cliente =new Cliente();
				DAOCliente dao = new DAOCliente();
				
				System.out.println("Digite a ID do Clietne:");
				long idCliente = Integer.parseInt(scan.nextLine());
				cliente.setIdCliente(idCliente);
				
				dao.excluir(cliente);
			}
			else if (num == 4) {
				DAOCliente dao = new DAOCliente();
				
				System.out.println("-------Lista das Cidades-------");
				
				List<Cliente> cli= dao.buscar();
				
				for (Cliente cliente : cli) {
					System.out.println("ID: "+cliente.getIdCliente()+", Nome do Cliete: "+cliente.getNome()+
							", Endereço: "+cliente.getEndereco()+", CPF: "+cliente.getCpf()+", Data de Nascimento: "+
							cliente.getDtAniversario()+", Telefone"+cliente.getTelefone()+", Cidade: "+cliente.getCidade());
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
