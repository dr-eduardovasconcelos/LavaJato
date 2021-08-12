package br.recife.edu.ifpe.lavajato.model.classes;

public class Lavagem {
	
	private int codigo;
	private long dataEHoraEntrada;
	private long dataEHoraTermino;
	private boolean pronto;
	private boolean pago;
	private String tipoLavagem;
	private double valor;
	
	private Carro carro;
	
	
	public Lavagem() {
		this.dataEHoraEntrada = System.currentTimeMillis();
		this.pronto = false;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public long getDataEHoraEntrada() {
		return dataEHoraEntrada;
	}

	public void setDataEHoraEntrada(long dataEHoraEntrada) {
		this.dataEHoraEntrada = dataEHoraEntrada;
	}

	public long getDataEHoraTermino() {
		return dataEHoraTermino;
	}

	public void setDataEHoraTermino(long dataEHoraTermino) {
		this.dataEHoraTermino = dataEHoraTermino;
	}

	public boolean isPronto() {
		return pronto;
	}

	public void setPronto(boolean pronto) {
		this.pronto = pronto;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public String getTipoLavagem() {
		return tipoLavagem;
	}

	public void setTipoLavagem(String tipoLavagem) {
		this.tipoLavagem = tipoLavagem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	

}
