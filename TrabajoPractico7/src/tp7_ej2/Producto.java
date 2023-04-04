package tp7_ej2;

public class Producto {
	
	private int codigo;
	private String nombre;
	private String desc;
	private double precio;
	private int stock;
	
	public Producto(int cod, String nom, String desc, double prec, int stk) {
		codigo = cod;
		nombre = nom;
		this.desc = desc;
		precio = prec;
		stock = stk;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDesc() {
		return desc;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}
}
