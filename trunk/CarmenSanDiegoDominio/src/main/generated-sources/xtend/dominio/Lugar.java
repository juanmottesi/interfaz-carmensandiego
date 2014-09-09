package dominio;

import dominio.Villano;

@SuppressWarnings("all")
public abstract class Lugar {
  private String _nombreDelLugar;
  
  public String getNombreDelLugar() {
    return this._nombreDelLugar;
  }
  
  public void setNombreDelLugar(final String nombreDelLugar) {
    this._nombreDelLugar = nombreDelLugar;
  }
  
  public abstract String obtenerPista(final Villano villano);
}
