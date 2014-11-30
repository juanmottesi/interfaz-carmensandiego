package dominio;

import dominio.Ocupante;
import dominio.Villano;
import java.util.List;

@SuppressWarnings("all")
public class Informante implements Ocupante {
  private List<String> _informacion;
  
  public List<String> getInformacion() {
    return this._informacion;
  }
  
  public void setInformacion(final List<String> informacion) {
    this._informacion = informacion;
  }
  
  public Informante(final List<String> info) {
    this.setInformacion(info);
  }
  
  public List<String> pista(final Villano villano) {
    return this.getInformacion();
  }
  
  public boolean esVillano() {
    return false;
  }
}
