package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.QuestoesDAO;
import br.unifor.pin.saa.entity.Questoes;

@Component
public class QuestaoBO {


	private static final Logger logger = LoggerFactory
			.getLogger(AlunoBO.class);

	@Autowired
	private QuestoesDAO questoesDAO;
	
	public void salvar(Questoes questao) {
		loggerInit("salvar");
		questoesDAO.salvar(questao);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Questoes questao){
		loggerInit("atualizar");
		questoesDAO.atualizar(questao);
		loggerFinhish("atualizar");
		
	}

	public List<Questoes> listaQuestoesPorEnunciado(String enunciado) {
		loggerInit("listaQuestoesPorEnunciado");
		List<Questoes> questoes = questoesDAO.listarPorNome(enunciado);
		loggerFinhish("listaQuestoesPorEnunciado");
		return questoes;
	}
	
	public Questoes buscarPorId(Long id){
		return questoesDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Questoes questao) {
		loggerInit("excluir");
		questao = questoesDAO.buscarPorId(questao.getId());
		questoesDAO.excluir(questao);
		loggerFinhish("excluir");
	}

	public void loggerInit(String method) {
		logger.debug("Inicio do método " + method + " da classe"
				+ this.getClass().getName());
	}

	public void loggerFinhish(String method) {
		logger.debug("Fim do método "+method+" da classe"
				+ this.getClass().getName());
	}
	
}
