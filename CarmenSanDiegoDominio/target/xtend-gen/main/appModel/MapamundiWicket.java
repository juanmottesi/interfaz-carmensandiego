package appModel;

import dominio.Mapamundi;
import dominio.Pais;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class MapamundiWicket implements Serializable {
  private Pais _paisSeleccionado;
  
  public Pais getPaisSeleccionado() {
    return this._paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this._paisSeleccionado = paisSeleccionado;
  }
  
  private List<Pais> _paises;
  
  public List<Pais> getPaises() {
    return this._paises;
  }
  
  public void setPaises(final List<Pais> paises) {
    this._paises = paises;
  }
  
  public void eliminarPaisSeleccionado() {
    Mapamundi _instance = Mapamundi.getInstance();
    Pais _paisSeleccionado = this.getPaisSeleccionado();
    _instance.eliminarPais(_paisSeleccionado);
    this.setPaisSeleccionado(null);
  }
  
  public void buscarPaises() {
    ArrayList<Pais> _newArrayList = CollectionLiterals.<Pais>newArrayList();
    this.setPaises(_newArrayList);
    Mapamundi _instance = Mapamundi.getInstance();
    List<Pais> _paises = _instance.getPaises();
    this.setPaises(_paises);
  }
}
