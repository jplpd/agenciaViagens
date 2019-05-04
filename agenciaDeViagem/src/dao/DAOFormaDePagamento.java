package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.FormaDePagamento;
import fabrica.Fabrica;

public class DAOFormaDePagamento {

	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public FormaDePagamento inserir(FormaDePagamento formaPagamento) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(formaPagamento);
			transacao.commit();
			 
		}catch(Exception e) { 
			e.printStackTrace();
			transacao.rollback();
		}
		return formaPagamento;
	}
	public FormaDePagamento excluir(FormaDePagamento formaPagamento) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			formaPagamento = gerenciador.find(FormaDePagamento.class, formaPagamento.getIdFormaPagamento());
			gerenciador.remove(formaPagamento);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return formaPagamento;
	}
	public FormaDePagamento alterar(FormaDePagamento formaPagamento) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(formaPagamento);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return formaPagamento;
	}
	public List<FormaDePagamento> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from FormaDePagamento").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
