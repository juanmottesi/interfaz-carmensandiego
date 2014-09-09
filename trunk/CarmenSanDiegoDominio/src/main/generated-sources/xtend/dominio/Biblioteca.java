package dominio;

import dominio.Lugar;
import dominio.Villano;

@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca() {
    this.setNombreDelLugar("Biblioteca");
  }
  
  public String obtenerPista(final Villano villano) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
