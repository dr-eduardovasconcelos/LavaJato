package br.recife.edu.ifpe.lavajato.model.repositorios;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.recife.edu.ifpe.lavajato.model.classes.Carro;
import br.recife.edu.ifpe.lavajato.model.classes.Lavagem;

public class RepositorioLavagem implements Repositorio<Lavagem, Integer> {

	/*
	 * O modificador do construtor � default para impedir que o objeto seja criado
	 * fora do pacote
	 */
	RepositorioLavagem() {

	}

	@Override
	public void inserir(Lavagem cl) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "insert into lavagem(dataehoraentrega, pronto, pago, tipolavagem, valor, placa_carro) values (?,0,?,?,?,?)";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setDate(1, new Date(cl.getDataEHoraEntrada()));
		pstm.setBoolean(2, cl.isPago());
		pstm.setString(3, cl.getTipoLavagem());
		pstm.setDouble(4, cl.getValor());
		pstm.setString(5, cl.getCarro().getPlaca());

		pstm.execute();

	}

	@Override
	public void alterar(Lavagem cl) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update lavagem set pronto=? where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setBoolean(1, cl.isPronto());

		pstm.setInt(2, cl.getCodigo());

		pstm.execute();

	}

	@Override
	public Lavagem ler(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from lavagem where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

		ResultSet result = pstm.executeQuery();

		Lavagem l = null;

		if (result.next()) {

			l = new Lavagem();

			l.setCodigo(k);
			l.setDataEHoraEntrada(result.getDate("dataEHoraEntrada").getTime());
			l.setDataEHoraTermino(result.getDate("dataEHoraTermino").getTime());
			l.setPago(result.getBoolean("pago"));
			l.setPronto(result.getBoolean("pronto"));
			l.setValor(result.getDouble("valor"));
			l.setTipoLavagem(result.getString("tipolavagem"));

			String placa = result.getString("placa_carro");

			Carro c = Fachada.getCurrentInstance().lerCarro(placa);

			l.setCarro(c);

		}

		return l;

	}

	@Override
	public void deletar(Integer k) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from lavagem where codigo=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setInt(1, k);

	}

	@Override
	public List<Lavagem> lerTudo() throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select * from lavagem";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Lavagem> lavagens = new ArrayList<Lavagem>();

		if (result.next()) {

			Lavagem l = new Lavagem();

			l.setCodigo(result.getInt("codigo"));
			l.setDataEHoraEntrada(result.getDate("dataEHoraEntrada").getTime());
			l.setDataEHoraTermino(result.getDate("dataEHoraTermino").getTime());
			l.setPago(result.getBoolean("pago"));
			l.setPronto(result.getBoolean("pronto"));
			l.setValor(result.getDouble("valor"));
			l.setTipoLavagem(result.getString("tipolavagem"));

			String placa = result.getString("placa_carro");

			Carro c = Fachada.getCurrentInstance().lerCarro(placa);

			l.setCarro(c);

			lavagens.add(l);

		}

		return lavagens;
	}

	/*
	 * Aqui insiro os filtros para as regras de neg�cio
	 */

	public List<Lavagem> filtroPorPlaca(String placaCarro) throws SQLException {

		String sql = "select * from lavagem where placa_carro=?";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		pstm.setString(1, placaCarro);

		ResultSet result = pstm.executeQuery();

		List<Lavagem> lavagens = new ArrayList<Lavagem>();

		if (result.next()) {

			Lavagem l = new Lavagem();

			l.setCodigo(result.getInt("codigo"));
			l.setDataEHoraEntrada(result.getDate("dataEHoraEntrada").getTime());
			l.setDataEHoraTermino(result.getDate("dataEHoraTermino").getTime());
			l.setPago(result.getBoolean("pago"));
			l.setPronto(result.getBoolean("pronto"));
			l.setValor(result.getDouble("valor"));
			l.setTipoLavagem(result.getString("tipolavagem"));

			String placa = result.getString("placa_carro");

			Carro c = Fachada.getCurrentInstance().lerCarro(placa);

			l.setCarro(c);

			lavagens.add(l);

		}

		return lavagens;
	}

	public List<Lavagem> filtroPorStatusNaoPronto() throws SQLException {

		String sql = "select * from lavagem where pronto=0";

		PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

		ResultSet result = pstm.executeQuery();

		List<Lavagem> lavagens = new ArrayList<Lavagem>();

		if (result.next()) {

			Lavagem l = new Lavagem();

			l.setCodigo(result.getInt("codigo"));
			l.setDataEHoraEntrada(result.getDate("dataEHoraEntrada").getTime());
			l.setDataEHoraTermino(result.getDate("dataEHoraTermino").getTime());
			l.setPago(result.getBoolean("pago"));
			l.setPronto(result.getBoolean("pronto"));
			l.setValor(result.getDouble("valor"));
			l.setTipoLavagem(result.getString("tipolavagem"));

			String placa = result.getString("placa_carro");

			Carro c = Fachada.getCurrentInstance().lerCarro(placa);

			l.setCarro(c);

			lavagens.add(l);

		}

		return lavagens;
	}

}
