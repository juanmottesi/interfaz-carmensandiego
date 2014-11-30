package appModel;

import dominio.Expediente;
import dominio.Villano;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class ExpedienteAppModel {
  private Expediente _expediente;
  
  public Expediente getExpediente() {
    return this._expediente;
  }
  
  public void setExpediente(final Expediente expediente) {
    this._expediente = expediente;
  }
  
  private Villano _villanoSeleccionado;
  
  public Villano getVillanoSeleccionado() {
    return this._villanoSeleccionado;
  }
  
  public void setVillanoSeleccionado(final Villano villanoSeleccionado) {
    this._villanoSeleccionado = villanoSeleccionado;
  }
  
  public ExpedienteAppModel() {
    Expediente _instance = Expediente.getInstance();
    this.setExpediente(_instance);
  }
  
  public Villano agregarVillano() {
    Villano _xblockexpression = null;
    {
      Villano villano = new Villano();
      Expediente _expediente = this.getExpediente();
      _expediente.agregarVillano(villano);
      _xblockexpression = villano;
    }
    return _xblockexpression;
  }
}
