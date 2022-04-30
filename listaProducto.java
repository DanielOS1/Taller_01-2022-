
public class listaProducto {

	private Producto[] lp;
	private int cant;
	private int max;

	public listaProducto(int max) {
		lp = new Producto[max];
		cant = 0;
		this.max = max;
	}

	public boolean ingresarProducto(Producto Producto) {
		if (cant < max) {
			lp[cant] = Producto;
			cant++;
			return true;
		} else {
			return false;
		}
	}
	
	public Producto getProductoI (int i) {
		if (i >= 0 && i < cant) {
			return lp[i];
		}else {
			return null;
		}
	}
	public Producto buscarProducto(String nombre) {
		int i;
		for (i = 0; i < cant; i++) {
			if(lp[i].getNombre().equals(nombre)) {
				break;
			}
		}
		if(i == cant) {
			return null;
		}else {
			return lp[i];
		}
	}

	public int getCant() {
		return cant;
	}

}