package br.recife.edu.ifpe.lavajato.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.recife.edu.ifpe.lavajato.model.classes.Carro;
import br.recife.edu.ifpe.lavajato.model.classes.TipoCarro;

public class RepositorioCarro implements Repositorio<Carro, String>{
	
	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioCarro() {

	}

	@Override
	public void inserir(Carro cl) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "insert into carro(placa,marca,corpredominante,nomedono,contatodono,cod_tipocarro) values (?,?,?,?,?,?)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cl.getPlaca());
		pstm.setString(2, cl.getMarca());
		pstm.setString(3, cl.getCorPredominante());
		pstm.setString(4, cl.getNomeDono());
		pstm.setString(5, cl.getContatoDono());
		pstm.setInt(6, cl.getTipo().getCodigo());
		
		pstm.execute();
		
	}

	@Override
	public void alterar(Carro cl) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "update carro set marca=?, corpredominante=?, nomedono=?, contatodono=? where placa=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, cl.getMarca());
		pstm.setString(2, cl.getCorPredominante());
		pstm.setString(3, cl.getNomeDono());
		pstm.setString(4, cl.getContatoDono());
		
		pstm.setString(5, cl.getPlaca());
		
		pstm.execute();
	}

	@Override
	public Carro ler(String k) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codi"
				+ "go) where c.placa = ?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, k);
		
		ResultSet result = pstm.executeQuery();
		
		Carro c = null;
		
		if(result.next()) {
			
			c = new Carro();
			
			c.setPlaca(result.getString("placa"));
			c.setCorPredominante(result.getString("corpredominante"));
			c.setMarca(result.getString("marca"));
			c.setNomeDono(result.getString("nomedono"));
			c.setContatoDono(result.getString("contatodono"));
			
			TipoCarro tc = new TipoCarro();
			
			tc.setCodigo(result.getInt("codigo"));
			tc.setTipo(result.getString("tipo"));
			tc.setDescricao(result.getString("descricao"));
			tc.setValorComum(result.getDouble("preconormal"));
			tc.setValorCompleta(result.getDouble("precocompleta"));
			
			c.setTipo(tc);
		}
		
		return c;
	}

	@Override
	public void deletar(String k) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "delete from carro where placa=?";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		pstm.setString(1, k);
		
		pstm.execute();
	}

	@Override
	public List<Carro> lerTudo() throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from carro as c join tipocarro as t on (c.cod_tipocarro = t.codi"
				+ "go)";
		
		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
		
		ResultSet result = pstm.executeQuery();
		
		List<Carro> carros = new ArrayList<Carro>();
		
		while(result.next()) {
			
			Carro c = new Carro();
			
			c.setPlaca(result.getString("placa"));
			c.setCorPredominante(result.getString("corpredominante"));
			c.setMarca(result.getString("marca"));
			c.setNomeDono(result.getString("nomedono"));
			c.setContatoDono(result.getString("contatodono"));
			
			TipoCarro tc = new TipoCarro();
			
			tc.setCodigo(result.getInt("codigo"));
			tc.setTipo(result.getString("tipo"));
			tc.setDescricao(result.getString("descricao"));
			tc.setValorComum(result.getDouble("preconormal"));
			tc.setValorCompleta(result.getDouble("precocompleta"));
			
			c.setTipo(tc);
		}
		
		return carros;
	}

}
