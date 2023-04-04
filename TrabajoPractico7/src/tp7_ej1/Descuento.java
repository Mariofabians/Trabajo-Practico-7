package tp7_ej1;

public abstract class Descuento {
	private double valor;
	
	public double getValorDesc() 
	{
		return valor;
	}
	
	public void setValorDesc(double valor) 
	{
		this.valor = valor;
	}
	
	public abstract String dameDescuento();

	public abstract double valorFinal(double valorInicial);
	}
