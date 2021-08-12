package br.recife.edu.ifpe.lavajato.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.recife.edu.ifpe.lavajato.model.classes.TipoCarro;

public class RepositorioTipoCarro implements Repositorio<TipoCarro, Integer> {

	/*
	 * O modificador do construtor é default para impedir que o objeto seja criado fora do pacote
	 */
	RepositorioTipoCarro() {

	}

	@Override
	public void inserir(TipoCarro cl) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into tipocarro(tipo, descricao, preconormal, precocompleta) values (?,?,?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cl.getTipo());
		pstm.setString(2, cl.getDescricao());
		pstm.setDouble(3, cl.getValorComum());
		pstm.setDouble(4, cl.getValorCompleta());

		pstm.execute();
	}

	@Override
	public void alterar(TipoCarro cl) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update tipocarro set tipo=?, descricao=?, preconormal=?, precocompleta=? where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, cl.getTipo());
		pstm.setString(2, cl.getDescricao());
		pstm.setDouble(3, cl.getValorComum());
		pstm.setDouble(4, cl.getValorCompleta());

		pstm.setInt(5, cl.getCodigo());

		pstm.execute();
	}

	@Override
	public TipoCarro ler(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tipocarro where codigo = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		ResultSet result = pstm.executeQuery();

		TipoCarro tCarro = null;

		if (result.next()) {

			tCarro = new TipoCarro();
			
			tCarro.setCodigo(k);
			tCarro.setTipo(result.getString("tipo"));
			tCarro.setDescricao(result.getString("descricao"));
			tCarro.setValorComum(result.getDouble("preconormal"));
			tCarro.setValorCompleta(result.getDouble("precocompleta"));
			
		}

		return tCarro;
	}

	@Override
	public void deletar(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from tipocarro where codigo = ?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		pstm.execute();

	}

	@Override
	public List<TipoCarro> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from tipocarro";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<TipoCarro> tipos = new ArrayList<TipoCarro>();

		while (result.next()) {

			TipoCarro tCarro = new TipoCarro();

			tCarro.setCodigo(result.getInt("codigo"));
			tCarro.setTipo(result.getString("tipo"));
			tCarro.setDescricao(result.getString("descricao"));
			tCarro.setValorComum(result.getDouble("preconormal"));
			tCarro.setValorCompleta(result.getDouble("precocompleta"));

			tipos.add(tCarro);

		}

		return tipos;
	}

}
