package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.ProfessoresDAO;
import br.unifor.pin.saa.entity.Professores;

@Component
public class ProfessorBO {


	private static final Logger logger = LoggerFactory
			.getLogger(ProfessorBO.class);

	@Autowired
	private ProfessoresDAO professoresDAO;
	
	public void salvar(Professores professor) {
		loggerInit("salvar");
		professoresDAO.salvar(professor);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Professores professor){
		loggerInit("atualizar");
		professoresDAO.atualizar(professor);
		loggerFinhish("atualizar");
		
	}

	public List<Professores> listaProfessorPorNome(String nome) {
		loggerInit("listaInstituicaoPorNome");
		List<Professores> professores = professoresDAO.listarPorNome(nome);
		loggerFinhish("listaUsuarioPorNome");
		return professores;
	}
	
	public Professores buscarPorId(Long id){
		return professoresDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Professores professor) {
		loggerInit("excluir");
		professor = professoresDAO.buscarPorId(professor.getId());
		professoresDAO.excluir(professor);
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
