package dominio;

import com.google.common.collect.Lists;
import dominio.Ocupante;
import dominio.Villano;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class Cuidador implements Ocupante {
  private List<String> _informacion;
  
  public List<String> getInformacion() {
    return this._informacion;
  }
  
  public void setInformacion(final List<String> informacion) {
    this._informacion = informacion;
  }
  
  public Cuidador() {
    this.setInformacion(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Lo siento, creo que se ha equivocado de Ciudad, no hay nadie con esas caracteristicas")));
  }
  
  public List<String> pista(final Villano villano) {
    return this.getInformacion();
  }
  
  public boolean esVillano() {
    return false;
  }
}
