package br.unifor.pin.saa.bussines;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.dao.UsuarioDAO;
import br.unifor.pin.saa.entity.Usuarios;

@Component
public class UsuarioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioBO.class);

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	

	public void salvar(Usuarios usuario) {
		loggerInit("salvar");
		usuario.setAtivo(false);
		usuario.setPrimeiroAcesso(true);
		usuarioDAO.salvar(usuario);
		loggerFinhish("salvar");
	}
	
	public void atualizar(Usuarios usuario){
		loggerInit("atualizar");
		usuarioDAO.atualizar(usuario);
		loggerFinhish("atualizar");
		
	}

	public List<Usuarios> listaUsuarioPorNome(String nome) {
		loggerInit("listaUsuarioPorNome");
		List<Usuarios> usuarios = usuarioDAO.listarPorNome(nome);
		loggerFinhish("listaUsuarioPorNome");
		return usuarios;
	}
	
	public Usuarios buscarPorId(Integer id){
		return usuarioDAO.buscaPorId(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void excluir(Usuarios usuario) {
		loggerInit("excluir");
		usuario = usuarioDAO.buscaPorId(usuario.getId());
		usuarioDAO.excluir(usuario);
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
