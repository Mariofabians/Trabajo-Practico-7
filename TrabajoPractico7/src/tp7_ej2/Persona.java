package tp7_ej2;

public class Persona {
	private String nombre;
	private String  apellido;
	private int dni;
	private int id;
	private static int idProx=1;
	
	public Persona (String nom, String ap, int dni)
	{
		nombre=nom;
		apellido=ap;
		this.dni=dni;
		id=idProx;
		idProx++;
	}

	public int getDni() {
		return dni;
	}
	
	public static int getIdSiguiente() {
		return idProx;
	}

	public String dar_nombre()
	{
		return id+" - "+nombre+" "+apellido;
	}
	
}
