package tp7_ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Compra {

	public static void main(String[] args) {
		
		Producto listaProductos []=new Producto[3];
		
		File f=new File("C:\\Users\\mario\\Desktop\\Productos.txt");
		String linea;
		Scanner sn=null;
		
		try
		{
			sn=new Scanner(f);
			
			while(sn.hasNextLine())
			{
				for (int i=0;i<listaProductos.length;i++)
				{
					linea=sn.nextLine();
					int ind=i;
					cargarProductos(linea,listaProductos,ind);
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.print(e.getMessage());
		}
		finally
		{
			sn.close();
		}
		
		Persona pers1=new Persona ("Mario","Schujovitzky",36145563);
		Carrito carr=new Carrito (18,pers1);
		
		ItemCarrito item[]=new ItemCarrito [3];
		
		item [0]=new ItemCarrito(carr,listaProductos,4,0);
		item [1]=new ItemCarrito(carr,listaProductos,2,1);
		item [2]=new ItemCarrito(carr,listaProductos,6,2);
		
		LocalDate fecha=LocalDate.now();
		int dia=fecha.getDayOfMonth();
		char tipoDesc=' ';
		if (dia%2!=0)
		{
			tipoDesc='f'; // Día Par -> Descuento Fijo
		}
		else
		{
			tipoDesc='p'; // Día impar - Descuento por Porcentaje
		}
		
		Scanner sn2=new Scanner(System.in);
		double montoDesc=0.0;
		System.out.print("Ingrese el valor del descuento: ");
		boolean rep=true;
		do {
			try {
					montoDesc = sn2.nextDouble();
					rep=false;
				}
			catch (InputMismatchException e) {	
					System.out.println("\nHa ocurrido un error");
					System.out.print("Ingrese el valor del descuento: ");
					sn2.nextLine();
				}
		} while(rep);
		
		if(tipoDesc=='p')
		{
			while (montoDesc>=100)
			{
				System.out.println("\nHa ocurrido un error");
				System.out.print("Ingrese un valor de descuento menor al 100%: ");
				montoDesc=sn2.nextDouble();
			}
		}
		sn2.close();
				
		Descuento d=cargarDescuento(tipoDesc,montoDesc);
		mostrarCompra(item,pers1,carr,d);
	}

	private static void cargarProductos(String frase, Producto[] list, int indice) 
	{
		String items[]=frase.split("	");
		
		int codigo=Integer.parseInt(items[0]);
		String nombre=items[1];
		String descripcion=items[2];
		double precio=Double.parseDouble(items[3]);
		int stock=Integer.parseInt(items[4]);
		
		list[indice]=new Producto(codigo,nombre,descripcion,precio,stock);
	}

	public static void mostrarCompra(ItemCarrito it[],Persona per,Carrito car,Descuento desc)
	{
		double suma=0.0;
		System.out.println("\nCarrito número "+car.getNumCarrito()+" del cliente "+per.dar_nombre());
		System.out.print("\n");
		it[0].mostrarTitulo();
		for(ItemCarrito a:it)
		{
			a.mostrarItem();
			suma+=a.getMontoItem();
		}
		System.out.println("\nSuma:$"+suma);
		System.out.println("El descuento es de: "+desc.dameDescuento());
		System.out.println("La suma con descuento es: $"+desc.valorFinal(suma));
	}
	
	public static Descuento cargarDescuento(char desc,double monto)
	{
		Descuento des=null;
		if (desc=='f')
		{
			des=new DescuentoFijo();
			des.setValorDesc(monto);
		}
		else
		{
			if(desc=='p')
			{
				des=new DescuentoPorc();
				des.setValorDesc(monto);
			}
		}
		return des;
	}
}
