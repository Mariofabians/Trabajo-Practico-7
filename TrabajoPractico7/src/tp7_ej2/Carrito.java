package tp7_ej2;

public class Carrito {
	private int numCarrito;
	private Producto prod;
	private double monto;
	private int cantidad;
	
	public Carrito(int numero, Persona per1)
	{
		numCarrito=numero;
		monto=0.0;
	}
	
	public int getNumCarrito()
	{
		return numCarrito;
	}
	
	public double getMontoCarrito()
	{
		return monto;
	}
	
	public int getCantidad() 
	{
		return cantidad;
	}
	
	public Producto getProducto()
	{
		return prod;
	}
	
	public void listaProducto()
	{
		System.out.println(cantidad+"     "+prod.getNombre()+"     "+prod.getPrecio()+"     "+monto);
	}
}
