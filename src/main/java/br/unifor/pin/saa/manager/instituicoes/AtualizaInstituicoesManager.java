package br.unifor.pin.saa.manager.instituicoes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicaoBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.entity.Usuarios;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "atualizaInstituicao")
@Component(value = "atualizaInstituicao")
public class AtualizaInstituicoesManager {

	@Autowired
	private InstituicaoBO instituicaoBO;
	private Instituicoes instituicaoSelecionado;

	public String atualizar() {
		instituicaoBO.atualizar(instituicaoSelecionado);
		MessagesUtils.info("Usuário atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Instituicoes instituicao) {
		instituicaoSelecionado = instituicaoBO.buscarPorId(instituicao.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		instituicaoSelecionado.setNome("");
		instituicaoSelecionado.setSigla("");
	}

	public Instituicoes getUsuarioSelecionado() {
		return instituicaoSelecionado;
	}
	public void setUsuarioSelecionado(Usuarios usuarioSelecionado) {
		this.instituicaoSelecionado = instituicaoSelecionado;
	}
	
}
