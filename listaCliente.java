
public class listaCliente {

	private Cliente[] lc;
	private int cant;
	private int max;

	public listaCliente(int max) {
		lc = new Cliente[max];
		cant = 0;
		this.max = max;
	}

	public boolean ingresarCliente(Cliente cliente) {
		if (cant < max) {
			lc[cant] = cliente;
			cant++;
			return true;
		} else {
			return false;
		}
	}
	
	public Cliente getClienteI (int i) {
		if (i >= 0 && i < cant) {
			return lc[i];
		}else {
			return null;
		}
	}
	public Cliente buscarCliente(String nombre) {
		int i;
		for (i = 0; i < cant; i++) {
			if(lc[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if(i == cant) {
			return null;
		}else {
			return lc[i];
		}
	}

	public int getCant() {
		return cant;
	}

}
