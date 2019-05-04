package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.ViagemHosped;
import fabrica.Fabrica;

public class DAOViagemHosped {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public ViagemHosped inserir(ViagemHosped viagemHosped) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(viagemHosped);
			transacao.commit();
			 
		}catch(Exception e) { 
			e.printStackTrace();
			transacao.rollback();
		}
		return viagemHosped;
	}
	public ViagemHosped excluir(ViagemHosped viagemHosped) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			viagemHosped = gerenciador.find(ViagemHosped.class, viagemHosped.getIdViagemHosped());
			gerenciador.remove(viagemHosped);
			transacao.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return viagemHosped;
	}
	public ViagemHosped alterar(ViagemHosped viagemHosped) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(viagemHosped);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return viagemHosped;
	}
	public List<ViagemHosped> buscar(){
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from ViagemHosped").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
