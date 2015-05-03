package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.InstituicoesDAO;
import br.unifor.pin.saa.entity.Instituicoes;

@Component
public class InstituicaoBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AlunoBO.class);

	@Autowired
	private InstituicoesDAO instituicoesDAO;
	
	public void salvar(Instituicoes instituicao) {
		loggerInit("salvar");
		instituicoesDAO.salvar(instituicao);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Instituicoes instituicao){
		loggerInit("atualizar");
		instituicoesDAO.atualizar(instituicao);
		loggerFinhish("atualizar");
		
	}

	public List<Instituicoes> listaInstituicaoPorNome(String nome) {
		loggerInit("listaInstituicaoPorNome");
		List<Instituicoes> instituicoes = instituicoesDAO.listarPorNome(nome);
		loggerFinhish("listaUsuarioPorNome");
		return instituicoes;
	}
	
	public Instituicoes buscarPorId(Long id){
		return instituicoesDAO.buscarPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Instituicoes instituicao) {
		loggerInit("excluir");
		instituicao = instituicoesDAO.buscarPorId(instituicao.getId());
		instituicoesDAO.excluir(instituicao);
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
