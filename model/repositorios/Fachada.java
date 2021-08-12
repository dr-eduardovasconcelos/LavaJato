package br.recife.edu.ifpe.lavajato.model.repositorios;

import java.sql.SQLException;
import java.util.List;

import br.recife.edu.ifpe.lavajato.model.classes.Carro;
import br.recife.edu.ifpe.lavajato.model.classes.Lavagem;
import br.recife.edu.ifpe.lavajato.model.classes.TipoCarro;

public class Fachada {
	
	private static Fachada myself = null;
	
	private Repositorio<TipoCarro, Integer> rTipoCarro = null;
	private Repositorio<Carro, String> rCarro = null;
	private Repositorio<Lavagem, Integer> rLavagem = null;
	
	
	private Fachada() {
		
		this.rTipoCarro = new RepositorioTipoCarro();
		this.rCarro = new RepositorioCarro();
		this.rLavagem = new RepositorioLavagem();
		
	}
	
	public static Fachada getCurrentInstance() {
		
		if(myself == null)
			myself = new Fachada();
		
		return myself;
		
	}
	
	public void inserir(TipoCarro tc) throws SQLException {
		this.rTipoCarro.inserir(tc);
	}
	
	public void inserir(Carro c) throws SQLException {
		this.rCarro.inserir(c);
	}
	
	public void inserir(Lavagem l) throws SQLException {
		this.rLavagem.inserir(l);
	}
	
	public void alterar(TipoCarro tc) throws SQLException {
		this.rTipoCarro.alterar(tc);
	}
	
	public void alterar(Carro c) throws SQLException {
		this.rCarro.alterar(c);
	}
	
	public void alterar(Lavagem l) throws SQLException {
		this.rLavagem.alterar(l);
	}
	
	public TipoCarro lerTipoCarro(int codigo) throws SQLException {
		return this.rTipoCarro.ler(codigo);
	}
	
	public Carro lerCarro(String placa) throws SQLException {
		return this.rCarro.ler(placa);
	}
	
	public Lavagem lerLavagem(int codigo) throws SQLException {
		return this.rLavagem.ler(codigo);
	}
	
	public void deletarTipoCarro(int codigo) throws SQLException {
		this.rTipoCarro.deletar(codigo);
	}
	
	public void deletarCarro(String placa) throws SQLException {
		this.rCarro.deletar(placa);
	}
	
	public void deletarLavagem(int codigo) throws SQLException {
		this.rLavagem.deletar(codigo);
	}
	
	public List<TipoCarro> lerTudoTipoCarro() throws SQLException{
		return this.rTipoCarro.lerTudo();
	}
	
	public List<Carro> lerTudoCarro() throws SQLException{
		return this.rCarro.lerTudo();
	}
	
	public List<Lavagem> lerTudoLavagem() throws SQLException{
		return this.rLavagem.lerTudo();
	}
	
	/*
	 * area de filtros
	 */
	
	public List<Lavagem> filtroPorPlaca(String placa) throws SQLException{
		return ((RepositorioLavagem)this.rLavagem).filtroPorPlaca(placa);
	}

	
	public List<Lavagem> filtroPorStatusNaoPronto() throws SQLException{
		return ((RepositorioLavagem)this.rLavagem).filtroPorStatusNaoPronto();
	}
}
