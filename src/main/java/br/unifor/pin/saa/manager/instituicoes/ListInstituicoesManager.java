package br.unifor.pin.saa.manager.instituicoes;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.InstituicaoBO;
import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listInstituicao")
@Component(value="listInstituicao")
public class ListInstituicoesManager {

	@Autowired
	private InstituicaoBO instituicaoBO;
	private String nome;
	private List<Instituicoes> instituicao;
	
	public void lista(){
		
		instituicao = instituicaoBO.listaInstituicaoPorNome(nome);
		
	}
	
	public void excluir(Instituicoes instituicao){
		instituicaoBO.excluir(instituicao);
		this.instituicao = instituicaoBO.listaInstituicaoPorNome(nome);
	}
	
	public String preparaAtualizar(Instituicoes instituicao){
		System.out.println(instituicao.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.instituicao = null;
	}
	
	
	public String salvar(){
		return null;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Instituicoes> getInstituicoes() {
		return instituicao;
	}
	public void setUsuarios(List<Instituicoes> instituicao) {
		this.instituicao = instituicao;
	}
	
}
