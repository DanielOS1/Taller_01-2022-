import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		listaCliente lC = new listaCliente(999);
		listaProducto lP = new listaProducto(999);
		leerArchivos(lC, lP);
		Cliente c = iniciarSesion(lC);
		menuUsuario(c, lC, lP);
	}

	public static void leerArchivos(listaCliente lC, listaProducto lP) throws FileNotFoundException {
		Scanner scanClientes = new Scanner(new File("Clientes.txt"));
		while (scanClientes.hasNextLine()) {
			String partes[] = scanClientes.nextLine().split(",");
			String nombre = partes[0];
			String contraseña = partes[1];
			int saldo = Integer.parseInt(partes[2]);
			String correo = partes[3];

			Cliente c = new Cliente(nombre, contraseña, correo, saldo);
			if (!lC.ingresarCliente(c)) {
				System.out.println("no hay espacio");
			}

		}
		System.out.println("--------");
		Scanner scanProducto = new Scanner(new File("Productos.txt"));
		while (scanProducto.hasNextLine()) {
			String partes[] = scanProducto.nextLine().split(",");
			String nombre = partes[0];
			int precio = Integer.parseInt(partes[1]);
			int stock = Integer.parseInt(partes[2]);

			Producto p = new Producto(nombre, precio, stock);
			if (!lP.ingresarProducto(p)) {
				System.out.println("no hay espacio");
			}

		}
		Scanner scanVentas = new Scanner(new File("Ventas.txt"));
		while (scanVentas.hasNextLine()) {
			String partes[] = scanVentas.nextLine().split(",");
			String nombre = partes[0];
			int vendido = Integer.parseInt(partes[1]);

			Producto p = lP.buscarProducto(nombre);
			p.setVendido(vendido);

		}

	}

	public static Cliente iniciarSesion(listaCliente lC) {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println("Bienvenido a Xiaomiau");
		System.out.print("Porfavor ingrese su nombre: ");
		String nombre = scan.nextLine();
		Cliente c = lC.buscarCliente(nombre);
		System.out.println("-----------------------");
		while (c == null) {
			System.out.println("###############################");
			System.out.println("Nombre de Usuario no encontrado");
			System.out.print("Porfavor ingrese su nombre: ");
			nombre = scan.nextLine();
			c = lC.buscarCliente(nombre);
			System.out.println("###############################");
		}
		System.out.println("");
		System.out.println("-----------------------");
		System.out.print("Porfavor Ingrese su contraseña: ");
		String contraseña = scan.nextLine();
		while (!contraseña.equals(c.getContraseña())) {
			System.out.println("###############################");
			System.out.print("Contraseña Incorrecta");
			System.out.print("Desea cambiar su contraseña? (si/no)");
			String cambio = scan.nextLine();
			if (cambio.equalsIgnoreCase("si")) {
				System.out.print("Ingrese su nueva contraseña: ");
				String nuevaContraseña = scan.nextLine();
				c.setContraseña(nuevaContraseña);
			}
			System.out.print("Porfavor ingrese su Contraseña: ");
			contraseña = scan.nextLine();
			System.out.println("###############################");
		}
		System.out.println("[Sesion Iniciada Correctamente]");
		System.out.println("Bienvenido de vuelta " + c.getNombre());
		return c;

	}

	public static void menuUsuario(Cliente c, listaCliente lC, listaProducto lP) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ha ingresado al menu de usuario");
		System.out.println("-----------------------------");
		System.out.println("1.- Elejir un producto \n2.- cambiar contraseña "
				+ "\n3.- ver catalogo \n4.- ver saldo \n5.- Recargar saldo \n6.- ver carrito"
				+ "\n7.- quitar del carrito \n8.- pagar carrito \n9.- Salir");
		System.out.println("-----------------------------");
		System.out.print("Elija una de estas opciones disponibles: ");
		int opcion = scan.nextInt();

		while (opcion != 7) {
			if (opcion == 1) {
				int cantStock = 0;
				comprarProducto(cantStock, c, lC, lP, scan);
			} else if (opcion == 2) {

			}
		}

	}

	public static void comprarProducto(int cantStock, Cliente c, listaCliente lC, listaProducto lP, Scanner scan) {

		System.out.println("Comprar producto");
		System.out.println("Ingrese el nombre del producto: ");
		String nombre = scan.nextLine();
		Producto p = lP.buscarProducto(nombre);
		int comprar = 0;
		if (p != null && p.getStock() > 0) {
			System.out.println("Producto encontrado..." + p.getNombre());
			System.out.println("quedan " + p.getStock() + " Piezas disponibles");
			System.out.print("Cuantos va a comprar: ");
			comprar = scan.nextInt();
			cantStock = comprar;
			int valorDeCompra = p.getPrecio() * comprar;
			if (c.getSaldo() >= valorDeCompra) {
				for (int i = 0; i < comprar; i++) {
					c.getLP().ingresarProducto(p);
				}
				int valor = p.getStock() - comprar;
				p.setStock(valor);
			} else {
				System.out.println("Dinero insuficiente");
			}

		}

		for (int i = 0; i < c.getLP().getCant(); i++) {
			System.out.println(c.getLP().getProductoI(i).getNombre());
		}
	}

	public static void cambiarContraseña(Cliente c, Scanner scan) {
		System.out.println("Cambio de contraseña");
		System.out.println("Ingrese su contraseña actual");
		String contraseña = scan.nextLine();
		while (!contraseña.equals(c.getContraseña())) {
			System.out.println("Contraseña erronea");
			System.out.println("ingrese la contraseña nuevamente");
			contraseña = scan.nextLine();
		}
		System.out.println("Contraseña correcta");
		System.out.println("Ingrese su nueva contraseña: ");
		String nuevaContraseña1 = scan.nextLine();
		System.out.println("ingrese su contraseña nuevamente: ");
		String nuevaContraseña2 = scan.nextLine();
		while (!nuevaContraseña1.equals(nuevaContraseña2)) {
			System.out.println("Contraseñas diferentes");
			System.out.println("Ingrese su nueva contraseña: ");
			nuevaContraseña1 = scan.nextLine();
			System.out.println("ingrese su contraseña nuevamente: ");
			nuevaContraseña2 = scan.nextLine();
		}
		
		

	}
}
