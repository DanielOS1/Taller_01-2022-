
public class Cliente {

	private String nombre;
	private String contrase�a;
	private String correo;
	private int saldo;
	private listaProducto lP;
	
	
	public Cliente(String nombre, String contrase�a, String correo, int saldo) {
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.correo = correo;
		this.saldo = saldo;
		lP = new listaProducto(999);
		
	}


	public String getNombre() {
		return nombre;
	}



	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public String getCorreo() {
		return correo;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public listaProducto getLP() {
		return lP;
	}


}
