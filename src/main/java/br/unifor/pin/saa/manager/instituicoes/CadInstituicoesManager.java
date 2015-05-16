package br.unifor.pin.saa.manager.instituicoes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicaoBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadInstituicao")
@Component(value="cadInstituicao")
public class CadInstituicoesManager {

	@Autowired
	private InstituicaoBO instituicaoBO;
	@Autowired
	private ListInstituicoesManager listInstituicao;
	private String nome;
	private String sigla;
	
	public String salvar(){
		Instituicoes instituicao = new Instituicoes();
		instituicao.setNome(nome);
		instituicao.setSigla(sigla);
		MessagesUtils.info("instituição salva com sucesso!");
		listInstituicao.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		this.nome = "";
		this.sigla = "";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
}
