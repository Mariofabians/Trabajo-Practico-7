package tp7_ej2;

public class DescuentoPorcentajeConTope extends Descuento {
	private static final double montoTopeDesc=500;
@Override
	public double valorFinal(double valorInicial)
	{
		double valorFinal=0.0;
		if(valorInicial*(this.getValorDesc()/100)<=montoTopeDesc)
		{
			valorFinal=valorInicial - (valorInicial*(this.getValorDesc()/100));
		}
		else
		{
			valorFinal=valorInicial-montoTopeDesc;
		}
		return valorFinal;
	}

	public String dameDescuento()
	{
		return this.getValorDesc()+"% con un tope de "+montoTopeDesc;
	}
}
