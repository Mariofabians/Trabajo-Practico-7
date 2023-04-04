package tp7_ej2;

public class ItemCarrito {
	private Producto prod[];
	private double montoItem;
	private double montoTotal;
	private int cantidad;
	private int i;
	
	public ItemCarrito (Carrito car, Producto p[], int cant, int i)
	{
		car.getNumCarrito();
		prod=p;
		cantidad=cant;
		montoItem=p[i].getPrecio()*cantidad;
		montoTotal=0.0;
		this.i=i;
	}
	
	public double getMontoItem() {
		return montoItem;
	}
	
	public double getMontoTotal()
	{
		return montoTotal;
	}
	
	public void mostrarTitulo() {
		System.out.println("Código\t\tProducto\t\t\tCantidad\t  Precio  \t\tSubTotal");
	}
	
	public void mostrarItem()
	{
		System.out.println(prod[i].getCodigo()+"\t\t"+prod[i].getNombre()+" "+prod[i].getDesc()+"\t\t  "+cantidad+"\t\t  "+prod[i].getPrecio()+"\t\t  "+montoItem);
	}
}
