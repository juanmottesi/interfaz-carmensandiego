package dominio;

import dominio.Lugar;
import dominio.Villano;

@SuppressWarnings("all")
public class Embajada extends Lugar {
  public Embajada() {
    this.setNombreDelLugar("Embajada");
  }
  
  public String obtenerPista(final Villano villano) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
