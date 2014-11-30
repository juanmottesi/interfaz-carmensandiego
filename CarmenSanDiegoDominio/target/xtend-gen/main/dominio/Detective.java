package dominio;

import dominio.Caso;
import dominio.Expediente;
import dominio.Mapamundi;
import dominio.Pais;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Detective {
  private Expediente _expedientes;
  
  public Expediente getExpedientes() {
    return this._expedientes;
  }
  
  public void setExpedientes(final Expediente expedientes) {
    this._expedientes = expedientes;
  }
  
  private Mapamundi _mapamundi;
  
  public Mapamundi getMapamundi() {
    return this._mapamundi;
  }
  
  public void setMapamundi(final Mapamundi mapamundi) {
    this._mapamundi = mapamundi;
  }
  
  private Caso _casoActual;
  
  public Caso getCasoActual() {
    return this._casoActual;
  }
  
  public void setCasoActual(final Caso casoActual) {
    this._casoActual = casoActual;
  }
  
  public Detective() {
    Expediente _instance = Expediente.getInstance();
    this.setExpedientes(_instance);
    Mapamundi _instance_1 = Mapamundi.getInstance();
    this.setMapamundi(_instance_1);
  }
  
  public void iniciarJuego() {
    Mapamundi _mapamundi = this.getMapamundi();
    _mapamundi.puedoIniciar();
    Expediente _expedientes = this.getExpedientes();
    _expedientes.puedoIniciar();
    Mapamundi _mapamundi_1 = this.getMapamundi();
    Expediente _expedientes_1 = this.getExpedientes();
    Caso _caso = new Caso(_mapamundi_1, _expedientes_1);
    this.setCasoActual(_caso);
  }
  
  public void viajarA(final Pais pais) {
    Caso _casoActual = this.getCasoActual();
    _casoActual.setCiudadActual(pais);
  }
  
  public boolean perteneceAlPlanDeEscape(final Pais pais) {
    Caso _casoActual = this.getCasoActual();
    return _casoActual.perteneceAlPlanDeEscape(pais);
  }
}
