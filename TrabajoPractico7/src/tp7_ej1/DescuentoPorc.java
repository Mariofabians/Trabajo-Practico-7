package tp7_ej1;

public class DescuentoPorc extends Descuento {
@Override
	public double valorFinal(double valorInicial) 
	{
		return valorInicial - (valorInicial*(this.getValorDesc()/100));
	}

	public String dameDescuento()
	{
		return this.getValorDesc()+"%";
	}
}