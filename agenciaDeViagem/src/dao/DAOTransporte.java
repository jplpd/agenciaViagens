package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Transporte;
import fabrica.Fabrica;

public class DAOTransporte {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public Transporte inserir(Transporte transporte) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(transporte);
			transacao.commit();
			 
		}catch(Exception e) { 
			e.printStackTrace();
			transacao.rollback();
		}
		return transporte;
	}
	public Transporte excluir(Transporte transporte) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			transporte = gerenciador.find(Transporte.class, transporte.getIdTransporte());
			gerenciador.remove(transporte);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return transporte;
	}
	public Transporte alterar(Transporte transporte) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(transporte);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return transporte;
	}
	public List<Transporte> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from Transporte").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
