package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Disciplinas;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class DisciplinasDAO {

		@PersistenceContext
		private EntityManager entityManager;
		
		public void salvar(Disciplinas disciplina) {
			entityManager.persist(disciplina);
		}
		
		public void atualizar(Disciplinas disciplina){
			entityManager.merge(disciplina);
		}
		
		public void excluir(Disciplinas disciplina){
			entityManager.remove(disciplina);
		}
		
		public Disciplinas buscarPorId(Long id){
			return entityManager.find(Disciplinas.class, id);
		}
		
		public Disciplinas buscarPorNome(String nome) {
			String jpql = "select a from Disciplinas a where a.nome = :nome";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("nome", nome);
			
			return (Disciplinas) query.getSingleResult();
		}
}
