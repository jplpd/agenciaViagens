package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.TransporteViagem;
import fabrica.Fabrica;

public class DAOTransporteViagem {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public TransporteViagem inserir(TransporteViagem transporteViagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(transporteViagem);
			transacao.commit();
			 
		}catch(Exception e) { 
			e.printStackTrace();
			transacao.rollback();
		}
		return transporteViagem;
	}
	public TransporteViagem excluir(TransporteViagem transporteViagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			transporteViagem = gerenciador.find(TransporteViagem.class, transporteViagem.getIdTranporteViagem());
			gerenciador.remove(transporteViagem);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return transporteViagem;
	}
	public TransporteViagem alterar(TransporteViagem transporteViagem) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(transporteViagem);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return transporteViagem;
	}
	public List<TransporteViagem> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from TransporteViagem").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
