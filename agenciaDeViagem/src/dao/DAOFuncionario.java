package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Estado;
import entidade.Funcionario;
import fabrica.Fabrica;

public class DAOFuncionario {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public Funcionario inserir(Funcionario funcioanrio) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			 
			transacao.begin();
			gerenciador.persist(funcioanrio);
			transacao.commit(); 
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return funcioanrio;
	}
	public Funcionario excluir(Funcionario funcioanrio) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			funcioanrio = gerenciador.find(Funcionario.class, funcioanrio.getIdFuncionario());
			gerenciador.remove(funcioanrio);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return funcioanrio;
	}
	public Funcionario alterar(Funcionario funcioanrio) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(funcioanrio);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return funcioanrio;
	}
	public List<Funcionario> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from Funcionario").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

