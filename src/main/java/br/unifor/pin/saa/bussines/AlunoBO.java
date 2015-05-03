package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.AlunosDAO;
import br.unifor.pin.saa.entity.Alunos;

@Component
public class AlunoBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AlunoBO.class);

	@Autowired
	private AlunosDAO alunosDAO;
	
	public void salvar(Alunos aluno) {
		loggerInit("salvar");
		alunosDAO.salvar(aluno);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Alunos aluno){
		loggerInit("atualizar");
		alunosDAO.atualizar(aluno);
		loggerFinhish("atualizar");
		
	}

	public List<Alunos> listaUsuarioPorNome(String nome) {
		loggerInit("listaAlunoPorNome");
		List<Alunos> alunos = alunosDAO.listarPorNome(nome);
		loggerFinhish("listaUsuarioPorNome");
		return alunos;
	}
	
	public Alunos buscarPorId(Long id){
		return alunosDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Alunos aluno) {
		loggerInit("excluir");
		aluno = alunosDAO.buscarPorId(aluno.getId());
		alunosDAO.excluir(aluno);
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
