
public class Cliente {

	private String nombre;
	private String contraseña;
	private String correo;
	private int saldo;
	private listaProducto lP;
	
	
	public Cliente(String nombre, String contraseña, String correo, int saldo) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.correo = correo;
		this.saldo = saldo;
		lP = new listaProducto(999);
		
	}


	public String getNombre() {
		return nombre;
	}



	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
