package dominio;

import com.google.common.base.Objects;
import dominio.Lugar;
import dominio.Mapamundi;
import dominio.Villano;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Pais {
  private String _nombreDelPais;
  
  public String getNombreDelPais() {
    return this._nombreDelPais;
  }
  
  public void setNombreDelPais(final String nombreDelPais) {
    this._nombreDelPais = nombreDelPais;
  }
  
  private List<String> _caracteristicasDelPais;
  
  public List<String> getCaracteristicasDelPais() {
    return this._caracteristicasDelPais;
  }
  
  public void setCaracteristicasDelPais(final List<String> caracteristicasDelPais) {
    this._caracteristicasDelPais = caracteristicasDelPais;
  }
  
  private List<Lugar> _lugaresDeInteres;
  
  public List<Lugar> getLugaresDeInteres() {
    return this._lugaresDeInteres;
  }
  
  public void setLugaresDeInteres(final List<Lugar> lugaresDeInteres) {
    this._lugaresDeInteres = lugaresDeInteres;
  }
  
  private List<String> _conexionesAereas;
  
  public List<String> getConexionesAereas() {
    return this._conexionesAereas;
  }
  
  public void setConexionesAereas(final List<String> conexionesAereas) {
    this._conexionesAereas = conexionesAereas;
  }
  
  public Pais() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setCaracteristicasDelPais(_newArrayList);
    ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
    this.setLugaresDeInteres(_newArrayList_1);
    ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList();
    this.setConexionesAereas(_newArrayList_2);
  }
  
  public Pais obtenerSiguientePais(final List<Pais> paises) {
    Pais _xblockexpression = null;
    {
      final Function1<Pais, String> _function = new Function1<Pais, String>() {
        public String apply(final Pais it) {
          return it.getNombreDelPais();
        }
      };
      List<String> _map = ListExtensions.<Pais, String>map(paises, _function);
      final List<String> paisesAux = IterableExtensions.<String>toList(_map);
      List<String> _conexionesAereas = this.getConexionesAereas();
      final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
        public Boolean apply(final String each) {
          boolean _contains = paisesAux.contains(each);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<String> pais = IterableExtensions.<String>filter(_conexionesAereas, _function_1);
      Mapamundi _instance = Mapamundi.getInstance();
      final Iterable<String> _converted_pais = (Iterable<String>)pais;
      int _size = IterableExtensions.size(pais);
      int _obtenerRandom = Random.obtenerRandom(0, _size);
      String _get = ((String[])Conversions.unwrapArray(_converted_pais, String.class))[_obtenerRandom];
      _xblockexpression = _instance.getPais(_get);
    }
    return _xblockexpression;
  }
  
  public void agregarCaracteristica(final String nuevaCaracteristica) {
    boolean _isBlank = StringUtils.isBlank(nuevaCaracteristica);
    if (_isBlank) {
      throw new UserException("Característica no valida");
    }
    List<String> _caracteristicasLowerCase = this.caracteristicasLowerCase();
    String _lowerCase = nuevaCaracteristica.toLowerCase();
    boolean _contains = _caracteristicasLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Característica ya agregada");
    }
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    _caracteristicasDelPais.add(nuevaCaracteristica);
    List<String> _caracteristicasDelPais_1 = this.getCaracteristicasDelPais();
    ObservableUtils.firePropertyChanged(this, "caracteristicasDelPais", _caracteristicasDelPais_1);
  }
  
  public void eliminarCaracteristica(final String caracteristicaSeleccionada) {
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    _caracteristicasDelPais.remove(caracteristicaSeleccionada);
    List<String> _caracteristicasDelPais_1 = this.getCaracteristicasDelPais();
    ObservableUtils.firePropertyChanged(this, "caracteristicasDelPais", _caracteristicasDelPais_1);
  }
  
  public void agregarConexion(final Pais paisSeleccionado) {
    List<String> _conexionesAereas = this.getConexionesAereas();
    boolean _contains = _conexionesAereas.contains(paisSeleccionado);
    if (_contains) {
      throw new UserException("Conexion ya agregada");
    }
    List<String> _conexionesAereas_1 = this.getConexionesAereas();
    String _nombreDelPais = paisSeleccionado.getNombreDelPais();
    _conexionesAereas_1.add(_nombreDelPais);
    paisSeleccionado.agregarConexionAux(this);
    List<String> _conexionesAereas_2 = this.getConexionesAereas();
    ObservableUtils.firePropertyChanged(this, "conexionesAereas", _conexionesAereas_2);
  }
  
  private void agregarConexionAux(final Pais pais) {
    List<String> _conexionesAereas = this.getConexionesAereas();
    boolean _contains = _conexionesAereas.contains(pais);
    if (_contains) {
      throw new UserException("Conexion ya agregada");
    } else {
      List<String> _conexionesAereas_1 = this.getConexionesAereas();
      String _nombreDelPais = pais.getNombreDelPais();
      _conexionesAereas_1.add(_nombreDelPais);
    }
  }
  
  public void eliminarConexion(final Pais paisSeleccionado) {
    List<String> _conexionesAereas = this.getConexionesAereas();
    String _nombreDelPais = paisSeleccionado.getNombreDelPais();
    _conexionesAereas.remove(_nombreDelPais);
    List<String> _conexionesAereas_1 = paisSeleccionado.getConexionesAereas();
    String _nombreDelPais_1 = this.getNombreDelPais();
    _conexionesAereas_1.remove(_nombreDelPais_1);
    List<String> _conexionesAereas_2 = this.getConexionesAereas();
    ObservableUtils.firePropertyChanged(this, "conexionesAereas", _conexionesAereas_2);
  }
  
  public void agregarLugar(final Lugar nuevoLugar) {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    boolean _contains = _lugaresDeInteres.contains(nuevoLugar);
    if (_contains) {
      throw new UserException("Lugar ya agregado, elija otro");
    }
    List<Lugar> _lugaresDeInteres_1 = this.getLugaresDeInteres();
    int _size = _lugaresDeInteres_1.size();
    boolean _equals = (_size == 3);
    if (_equals) {
      throw new UserException("Solo puede poseer 3 lugares de interés");
    }
    List<Lugar> _lugaresDeInteres_2 = this.getLugaresDeInteres();
    _lugaresDeInteres_2.add(nuevoLugar);
    List<Lugar> _lugaresDeInteres_3 = this.getLugaresDeInteres();
    ObservableUtils.firePropertyChanged(this, "lugaresDeInteres", _lugaresDeInteres_3);
  }
  
  public void eliminarLugar(final Lugar lugarSeleccionado) {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    _lugaresDeInteres.remove(lugarSeleccionado);
    List<Lugar> _lugaresDeInteres_1 = this.getLugaresDeInteres();
    ObservableUtils.firePropertyChanged(this, "lugaresDeInteres", _lugaresDeInteres_1);
  }
  
  public List<String> caracteristicasLowerCase() {
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        return it.toLowerCase();
      }
    };
    return ListExtensions.<String, String>map(_caracteristicasDelPais, _function);
  }
  
  public void esCorrecto(final List<Pais> paises) {
    String _nombreDelPais = this.getNombreDelPais();
    boolean _isBlank = StringUtils.isBlank(_nombreDelPais);
    if (_isBlank) {
      throw new UserException("Nombre del pais Incorrecto");
    }
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        String _nombreDelPais = it.getNombreDelPais();
        String _nombreDelPais_1 = Pais.this.getNombreDelPais();
        return Boolean.valueOf(Objects.equal(_nombreDelPais, _nombreDelPais_1));
      }
    };
    Iterable<Pais> _filter = IterableExtensions.<Pais>filter(paises, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      throw new UserException("Pais ya agregado");
    }
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    int _size_1 = _lugaresDeInteres.size();
    boolean _lessThan = (_size_1 < 3);
    if (_lessThan) {
      throw new UserException("Se necesitan 3 Lugares de Interés");
    }
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    int _size_2 = _caracteristicasDelPais.size();
    boolean _lessThan_1 = (_size_2 < 3);
    if (_lessThan_1) {
      throw new UserException("Se necesitan 3 Caracteristicas");
    }
  }
  
  public void generarInformantes(final Pais pais, final Villano villano) {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    for (final Lugar l : _lugaresDeInteres) {
      l.generarInformantes(pais, villano);
    }
  }
  
  public void colocarVillanoEInformantes(final Villano villano) {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    for (final Lugar l : _lugaresDeInteres) {
      l.generarInformantes();
    }
    List<Lugar> _lugaresDeInteres_1 = this.getLugaresDeInteres();
    int _obtenerRandom = Random.obtenerRandom(0, 2);
    Lugar _get = _lugaresDeInteres_1.get(_obtenerRandom);
    _get.ubicarVillano(villano);
  }
  
  public String obtenerCaracteristica(final ArrayList<String> lista) {
    String _xblockexpression = null;
    {
      List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
      List<String> _caracteristicasDelPais_1 = this.getCaracteristicasDelPais();
      int _size = _caracteristicasDelPais_1.size();
      int _obtenerRandom = Random.obtenerRandom(0, _size);
      String aux = _caracteristicasDelPais.get(_obtenerRandom);
      String _xifexpression = null;
      boolean _contains = lista.contains(aux);
      if (_contains) {
        _xifexpression = this.obtenerCaracteristica(lista);
      } else {
        _xifexpression = aux;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
