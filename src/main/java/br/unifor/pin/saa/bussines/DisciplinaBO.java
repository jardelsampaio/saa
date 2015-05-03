package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.DisciplinasDAO;
import br.unifor.pin.saa.entity.Disciplinas;

@Component
public class DisciplinaBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DisciplinaBO.class);

	@Autowired
	private DisciplinasDAO disciplinasDAO;
	
	public void salvar(Disciplinas disciplina) {
		loggerInit("salvar");
		disciplinasDAO.salvar(disciplina);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Disciplinas disciplina){
		loggerInit("atualizar");
		disciplinasDAO.atualizar(disciplina);
		loggerFinhish("atualizar");
		
	}

	public List<Disciplinas> listaDisciplinaPorNome(String nome) {
		loggerInit("listaDisciplinaPorNome");
		List<Disciplinas> disciplinas = disciplinasDAO.listarPorNome(nome);
		loggerFinhish("listaUsuarioPorNome");
		return disciplinas;
	}
	
	public Disciplinas buscarPorId(Long id){
		return disciplinasDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Disciplinas disciplina){
		loggerInit("excluir");
		disciplina = disciplinasDAO.buscarPorId(disciplina.getId());
		disciplinasDAO.excluir(disciplina);
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
