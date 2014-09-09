package dominio;

import com.google.common.base.Objects;
import dominio.InterfazPaises;
import dominio.Lugar;
import dominio.Mapamundi;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Pais implements InterfazPaises {
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
  
  private List<Pais> _conexionesAereas;
  
  public List<Pais> getConexionesAereas() {
    return this._conexionesAereas;
  }
  
  public void setConexionesAereas(final List<Pais> conexionesAereas) {
    this._conexionesAereas = conexionesAereas;
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
  
  private List<Pais> _paises;
  
  public void setPaises(final List<Pais> paises) {
    this._paises = paises;
  }
  
  private Lugar _lugarSeleccionado;
  
  public Lugar getLugarSeleccionado() {
    return this._lugarSeleccionado;
  }
  
  public void setLugarSeleccionado(final Lugar lugarSeleccionado) {
    this._lugarSeleccionado = lugarSeleccionado;
  }
  
  private Lugar _nuevoLugar;
  
  public Lugar getNuevoLugar() {
    return this._nuevoLugar;
  }
  
  public void setNuevoLugar(final Lugar nuevoLugar) {
    this._nuevoLugar = nuevoLugar;
  }
  
  private List<Lugar> _lugaresPosibles;
  
  public void setLugaresPosibles(final List<Lugar> lugaresPosibles) {
    this._lugaresPosibles = lugaresPosibles;
  }
  
  public Pais() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setCaracteristicasDelPais(_newArrayList);
    ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
    this.setLugaresDeInteres(_newArrayList_1);
    ArrayList<Pais> _newArrayList_2 = CollectionLiterals.<Pais>newArrayList();
    this.setConexionesAereas(_newArrayList_2);
  }
  
  public Pais(final String nombreDelPais, final List<String> caracteristicasDelPais, final List<Lugar> lugaresDeInteres, final List<Pais> conexionesAereas) {
    this.setNombreDelPais(nombreDelPais);
    this.setCaracteristicasDelPais(caracteristicasDelPais);
    this.setLugaresDeInteres(lugaresDeInteres);
    this.setConexionesAereas(conexionesAereas);
  }
  
  public Pais obtenerSiguientePais(final List<Pais> paises) {
    Pais _xblockexpression = null;
    {
      List<Pais> _conexionesAereas = this.getConexionesAereas();
      final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
        public Boolean apply(final Pais it) {
          boolean _contains = paises.contains(it);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<Pais> pais = IterableExtensions.<Pais>filter(_conexionesAereas, _function);
      final Iterable<Pais> _converted_pais = (Iterable<Pais>)pais;
      int _size = IterableExtensions.size(pais);
      int _obtenerRandom = Random.obtenerRandom(0, _size);
      _xblockexpression = ((Pais[])Conversions.unwrapArray(_converted_pais, Pais.class))[_obtenerRandom];
    }
    return _xblockexpression;
  }
  
  public void agregarCaracteristica() {
    List<String> _caracteristicasLowerCase = this.caracteristicasLowerCase();
    String _nuevaCaracteristica = this.getNuevaCaracteristica();
    String _lowerCase = _nuevaCaracteristica.toLowerCase();
    boolean _contains = _caracteristicasLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Característica ya agregada");
    }
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    String _nuevaCaracteristica_1 = this.getNuevaCaracteristica();
    _caracteristicasDelPais.add(_nuevaCaracteristica_1);
    this.actualizar();
  }
  
  public void eliminarCaracteristica() {
    List<String> _caracteristicasDelPais = this.getCaracteristicasDelPais();
    String _caracteristicaSeleccionada = this.getCaracteristicaSeleccionada();
    _caracteristicasDelPais.remove(_caracteristicaSeleccionada);
    this.actualizar();
  }
  
  public void agregarConexion() {
    List<Pais> _conexionesAereas = this.getConexionesAereas();
    Pais _nuevaConexion = this.getNuevaConexion();
    boolean _contains = _conexionesAereas.contains(_nuevaConexion);
    if (_contains) {
      throw new UserException("Conexion ya agregada");
    }
    List<Pais> _conexionesAereas_1 = this.getConexionesAereas();
    int _size = _conexionesAereas_1.size();
    boolean _greaterEqualsThan = (_size >= 3);
    if (_greaterEqualsThan) {
      throw new UserException("Solo puede poseer 3 conexiones");
    }
    List<Pais> _conexionesAereas_2 = this.getConexionesAereas();
    Pais _nuevaConexion_1 = this.getNuevaConexion();
    _conexionesAereas_2.add(_nuevaConexion_1);
    Pais _nuevaConexion_2 = this.getNuevaConexion();
    List<Pais> _conexionesAereas_3 = _nuevaConexion_2.getConexionesAereas();
    _conexionesAereas_3.add(this);
    this.actualizar();
  }
  
  public void eliminarConexion() {
    List<Pais> _conexionesAereas = this.getConexionesAereas();
    Pais _conexionSeleccionada = this.getConexionSeleccionada();
    _conexionesAereas.remove(_conexionSeleccionada);
    Pais _conexionSeleccionada_1 = this.getConexionSeleccionada();
    List<Pais> _conexionesAereas_1 = _conexionSeleccionada_1.getConexionesAereas();
    _conexionesAereas_1.remove(this);
    this.actualizar();
  }
  
  public void agregarLugar() {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    Lugar _nuevoLugar = this.getNuevoLugar();
    boolean _contains = _lugaresDeInteres.contains(_nuevoLugar);
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
    Lugar _nuevoLugar_1 = this.getNuevoLugar();
    _lugaresDeInteres_2.add(_nuevoLugar_1);
    this.actualizar();
  }
  
  public void eliminarLugar() {
    List<Lugar> _lugaresDeInteres = this.getLugaresDeInteres();
    Lugar _lugarSeleccionado = this.getLugarSeleccionado();
    _lugaresDeInteres.remove(_lugarSeleccionado);
    this.actualizar();
  }
  
  public void actualizar() {
    List<String> carac = this.getCaracteristicasDelPais();
    this.setCaracteristicasDelPais(null);
    this.setCaracteristicasDelPais(carac);
    this.setCaracteristicaSeleccionada(null);
    this.setNuevaCaracteristica(null);
    List<Pais> conex = this.getConexionesAereas();
    this.setConexionesAereas(null);
    this.setConexionesAereas(conex);
    this.setNuevaConexion(null);
    this.setConexionSeleccionada(null);
    List<Lugar> lugares = this.getLugaresDeInteres();
    this.setLugaresDeInteres(null);
    this.setLugaresDeInteres(lugares);
    this.setNuevoLugar(null);
    this.setLugarSeleccionado(null);
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
  
  public String obtenerInputCaracteristica() {
    return "nuevaCaracteristica";
  }
  
  public String listaCaracteristicas() {
    return "caracteristicasDelPais";
  }
  
  public String caracteristicasSeleccionada() {
    return "caracteristicaSeleccionada";
  }
  
  public String conexionesSeleccionada() {
    return "conexionSeleccionada";
  }
  
  public String listaConexiones() {
    return "conexionesAereas";
  }
  
  public String obtenerInputConexiones() {
    return "nuevaConexion";
  }
  
  public List<Pais> getPaises() {
    Mapamundi _instance = Mapamundi.getInstance();
    List<Pais> _paises = _instance.getPaises();
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais each) {
        boolean _equals = Objects.equal(each, Pais.this);
        return Boolean.valueOf((!_equals));
      }
    };
    Iterable<Pais> _filter = IterableExtensions.<Pais>filter(_paises, _function);
    return IterableExtensions.<Pais>toList(_filter);
  }
  
  public String listaLugares() {
    return "lugaresDeInteres";
  }
  
  public String obtenerInputLugares() {
    return "nuevoLugar";
  }
  
  public String lugaresSeleccionada() {
    return "lugarSeleccionado";
  }
  
  public List<Lugar> getLugaresPosibles() {
    Mapamundi _instance = Mapamundi.getInstance();
    return _instance.getLugaresPosibles();
  }
  
  public String obtenerTitulo() {
    return "Mapamundi - Editar Pais";
  }
  
  public Boolean soyEditar() {
    return Boolean.valueOf(true);
  }
  
  public void agregarPais() {
    try {
      throw new Exception("Error!");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
