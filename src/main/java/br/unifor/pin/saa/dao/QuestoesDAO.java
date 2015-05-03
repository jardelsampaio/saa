package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Questoes;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class QuestoesDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Questoes questao) {
		entityManager.persist(questao);
	}
	
	public void atualizar(Questoes questao){
		entityManager.merge(questao);
	}
	
	public void excluir(Questoes questao){
		entityManager.remove(questao);
	}
	
	public Questoes buscarPorId(Long id){
		return entityManager.find(Questoes.class, id);
	}
	
	public Questoes buscarPorNome(String nome) {
		String jpql = "select a from Questoes a where a.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Questoes) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Questoes> listarPorNome(String enunciado) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Questoes> criteriaQuery = criteriaBuilder.createQuery(Questoes.class);
		Root<Questoes> alunos = criteriaQuery.from(Questoes.class);
		criteriaQuery.where(criteriaBuilder.like(alunos.<String>get("enunciado"), "%"+enunciado+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
}
