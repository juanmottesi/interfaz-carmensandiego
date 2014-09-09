package dominio;

import dominio.Lugar;
import dominio.Villano;

@SuppressWarnings("all")
public class Club extends Lugar {
  public Club() {
    this.setNombreDelLugar("Club");
  }
  
  public String obtenerPista(final Villano villano) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
