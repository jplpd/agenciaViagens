package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Hospedagem;
import fabrica.Fabrica;

public class DAOHospedagem {
	
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public Hospedagem inserir(Hospedagem hospedagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(hospedagem);
			transacao.commit();
			 
		}catch(Exception e) { 
			e.printStackTrace();
			transacao.rollback();
		}
		return hospedagem;
	}
	public Hospedagem excluir(Hospedagem hospedagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			hospedagem = gerenciador.find(Hospedagem.class, hospedagem.getIdHospedagem());
			gerenciador.remove(hospedagem);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return hospedagem;
	}
	public Hospedagem alterar(Hospedagem hospedagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(hospedagem);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return hospedagem;
	}
	public List<Hospedagem> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from Hospedagem").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
