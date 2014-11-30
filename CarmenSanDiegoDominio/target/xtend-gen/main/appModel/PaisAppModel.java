package appModel;

import com.google.common.collect.Lists;
import dominio.Banco;
import dominio.Biblioteca;
import dominio.Club;
import dominio.Embajada;
import dominio.Lugar;
import dominio.Mapamundi;
import dominio.Pais;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class PaisAppModel {
  private Pais _pais;
  
  public Pais getPais() {
    return this._pais;
  }
  
  public void setPais(final Pais pais) {
    this._pais = pais;
  }
  
  private String _caracteristicaSeleccionada;
  
  public String getCaracteristicaSeleccionada() {
    return this._caracteristicaSeleccionada;
  }
  
  public void setCaracteristicaSeleccionada(final String caracteristicaSeleccionada) {
    this._caracteristicaSeleccionada = caracteristicaSeleccionada;
  }
  
  private String _nuevaCaracteristica;
  
  public String getNuevaCaracteristica() {
    return this._nuevaCaracteristica;
  }
  
  public void setNuevaCaracteristica(final String nuevaCaracteristica) {
    this._nuevaCaracteristica = nuevaCaracteristica;
  }
  
  private Pais _conexionSeleccionada;
  
  public Pais getConexionSeleccionada() {
    return this._conexionSeleccionada;
  }
  
  public void setConexionSeleccionada(final Pais conexionSeleccionada) {
    this._conexionSeleccionada = conexionSeleccionada;
  }
  
  private Pais _nuevaConexion;
  
  public Pais getNuevaConexion() {
    return this._nuevaConexion;
  }
  
  public void setNuevaConexion(final Pais nuevaConexion) {
    this._nuevaConexion = nuevaConexion;
  }
  
  private Lugar _lugarSeleccionada;
  
  public Lugar getLugarSeleccionada() {
    return this._lugarSeleccionada;
  }
  
  public void setLugarSeleccionada(final Lugar lugarSeleccionada) {
    this._lugarSeleccionada = lugarSeleccionada;
  }
  
  private Lugar _nuevoLugar;
  
  public Lugar getNuevoLugar() {
    return this._nuevoLugar;
  }
  
  public void setNuevoLugar(final Lugar nuevoLugar) {
    this._nuevoLugar = nuevoLugar;
  }
  
  public PaisAppModel(final Pais paisSeleccionado) {
    this.setPais(paisSeleccionado);
  }
  
  public void esCorrecto() {
    Pais _pais = this.getPais();
    Mapamundi _instance = Mapamundi.getInstance();
    List<Pais> _paises = _instance.getPaises();
    _pais.esCorrecto(_paises);
  }
  
  public void agregarCaracteristica() {
    Pais _pais = this.getPais();
    String _nuevaCaracteristica = this.getNuevaCaracteristica();
    _pais.agregarCaracteristica(_nuevaCaracteristica);
    this.setNuevaCaracteristica(null);
    String _nuevaCaracteristica_1 = this.getNuevaCaracteristica();
    ObservableUtils.firePropertyChanged(this, "nuevaCaracteristica", _nuevaCaracteristica_1);
  }
  
  public void eliminarCaracteristica() {
    Pais _pais = this.getPais();
    String _caracteristicaSeleccionada = this.getCaracteristicaSeleccionada();
    _pais.eliminarCaracteristica(_caracteristicaSeleccionada);
  }
  
  public void agregarConexion() {
    Pais _pais = this.getPais();
    Pais _nuevaConexion = this.getNuevaConexion();
    _pais.agregarConexion(_nuevaConexion);
    List<Pais> _paisesPosibles = this.getPaisesPosibles();
    ObservableUtils.firePropertyChanged(this, "paisesPosibles", _paisesPosibles);
    this.setNuevaConexion(null);
    Pais _nuevaConexion_1 = this.getNuevaConexion();
    ObservableUtils.firePropertyChanged(this, "nuevaConexion", _nuevaConexion_1);
  }
  
  public void eliminarConexion() {
    Pais _pais = this.getPais();
    Pais _conexionSeleccionada = this.getConexionSeleccionada();
    _pais.eliminarConexion(_conexionSeleccionada);
  }
  
  public void agregarLugar() {
    Pais _pais = this.getPais();
    Lugar _nuevoLugar = this.getNuevoLugar();
    _pais.agregarLugar(_nuevoLugar);
    List<? extends Lugar> _lugaresPosibles = this.getLugaresPosibles();
    ObservableUtils.firePropertyChanged(this, "lugaresPosibles", _lugaresPosibles);
    this.setNuevoLugar(null);
    Lugar _nuevoLugar_1 = this.getNuevoLugar();
    ObservableUtils.firePropertyChanged(this, "nuevoLugar", _nuevoLugar_1);
  }
  
  public void eliminarLugar() {
    Pais _pais = this.getPais();
    Lugar _lugarSeleccionada = this.getLugarSeleccionada();
    _pais.eliminarLugar(_lugarSeleccionada);
    List<? extends Lugar> _lugaresPosibles = this.getLugaresPosibles();
    ObservableUtils.firePropertyChanged(this, "lugaresPosibles", _lugaresPosibles);
  }
  
  public List<Pais> getPaisesPosibles() {
    Mapamundi _instance = Mapamundi.getInstance();
    List<Pais> _paises = _instance.getPaises();
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        Pais _pais = PaisAppModel.this.getPais();
        boolean _equals = it.equals(_pais);
        return Boolean.valueOf((!_equals));
      }
    };
    Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_paises, _function);
    final Function1<Pais, Boolean> _function_1 = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        Pais _pais = PaisAppModel.this.getPais();
        List<String> _conexionesAereas = _pais.getConexionesAereas();
        boolean _contains = _conexionesAereas.contains(it);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<Pais> _filter_1 = IterableExtensions.<Pais>filter(_filter, _function_1);
    return IterableExtensions.<Pais>toList(_filter_1);
  }
  
  public List<? extends Lugar> getLugaresPosibles() {
    List<? extends Lugar> _xblockexpression = null;
    {
      Biblioteca _biblioteca = new Biblioteca();
      Banco _banco = new Banco();
      Club _club = new Club();
      Embajada _embajada = new Embajada();
      List<? extends Lugar> lista = Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _banco, _club, _embajada));
      final Function1<Lugar, Boolean> _function = new Function1<Lugar, Boolean>() {
        public Boolean apply(final Lugar it) {
          boolean _xblockexpression = false;
          {
            Pais _pais = PaisAppModel.this.getPais();
            List<Lugar> _lugaresDeInteres = _pais.getLugaresDeInteres();
            final Function1<Lugar, String> _function = new Function1<Lugar, String>() {
              public String apply(final Lugar it) {
                return it.getNombreDelLugar();
              }
            };
            List<String> aux = ListExtensions.<Lugar, String>map(_lugaresDeInteres, _function);
            String _nombreDelLugar = it.getNombreDelLugar();
            boolean _contains = aux.contains(_nombreDelLugar);
            _xblockexpression = (!_contains);
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      Iterable<? extends Lugar> _filter = IterableExtensions.filter(lista, _function);
      _xblockexpression = IterableExtensions.toList(_filter);
    }
    return _xblockexpression;
  }
}
