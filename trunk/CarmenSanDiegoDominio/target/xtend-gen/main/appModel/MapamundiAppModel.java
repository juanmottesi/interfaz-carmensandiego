package appModel;

import dominio.Mapamundi;
import dominio.Pais;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class MapamundiAppModel {
  private Mapamundi _mapamundi;
  
  public Mapamundi getMapamundi() {
    return this._mapamundi;
  }
  
  public void setMapamundi(final Mapamundi mapamundi) {
    this._mapamundi = mapamundi;
  }
  
  private Pais _paisSeleccionado;
  
  public Pais getPaisSeleccionado() {
    return this._paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this._paisSeleccionado = paisSeleccionado;
  }
  
  public MapamundiAppModel() {
    Mapamundi _instance = Mapamundi.getInstance();
    this.setMapamundi(_instance);
  }
  
  public Pais agregarPais() {
    Pais _xblockexpression = null;
    {
      Pais pais = new Pais();
      Mapamundi _mapamundi = this.getMapamundi();
      _mapamundi.agregarPais(pais);
      _xblockexpression = pais;
    }
    return _xblockexpression;
  }
  
  public void eliminarPais() {
    Mapamundi _mapamundi = this.getMapamundi();
    Pais _paisSeleccionado = this.getPaisSeleccionado();
    _mapamundi.eliminarPais(_paisSeleccionado);
  }
}
