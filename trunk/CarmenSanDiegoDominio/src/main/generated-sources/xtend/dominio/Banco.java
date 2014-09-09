package dominio;

import dominio.Lugar;
import dominio.Villano;

@SuppressWarnings("all")
public class Banco extends Lugar {
  public Banco() {
    this.setNombreDelLugar("Banco");
  }
  
  public String obtenerPista(final Villano villano) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
