package tp7_ej2;

public class DescuentoFijo extends Descuento {
@Override
	public double valorFinal(double valorInicial)
	{
		return valorInicial - this.getValorDesc();
	}

	public String dameDescuento() {
		return "$"+this.getValorDesc();
	}
}