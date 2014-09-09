package dominio;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import dominio.Banco;
import dominio.Biblioteca;
import dominio.Club;
import dominio.Embajada;
import dominio.InterfazPaises;
import dominio.Lugar;
import dominio.Pais;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Mapamundi implements InterfazPaises {
  private static Mapamundi instance = null;
  
  private List<Pais> _paises;
  
  public List<Pais> getPaises() {
    return this._paises;
  }
  
  public void setPaises(final List<Pais> paises) {
    this._paises = paises;
  }
  
  private List<Lugar> _lugaresPosibles;
  
  public List<Lugar> getLugaresPosibles() {
    return this._lugaresPosibles;
  }
  
  public void setLugaresPosibles(final List<Lugar> lugaresPosibles) {
    this._lugaresPosibles = lugaresPosibles;
  }
  
  private Pais _paisSeleccionado;
  
  public Pais getPaisSeleccionado() {
    return this._paisSeleccionado;
  }
  
  public void setPaisSeleccionado(final Pais paisSeleccionado) {
    this._paisSeleccionado = paisSeleccionado;
  }
  
  private Pais _nuevoPais;
  
  public Pais getNuevoPais() {
    return this._nuevoPais;
  }
  
  public void setNuevoPais(final Pais nuevoPais) {
    this._nuevoPais = nuevoPais;
  }
  
  private Mapamundi() {
    ArrayList<Pais> _newArrayList = CollectionLiterals.<Pais>newArrayList();
    this.setPaises(_newArrayList);
    ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
    this.setLugaresPosibles(_newArrayList_1);
    List<Lugar> _lugaresPosibles = this.getLugaresPosibles();
    Embajada _embajada = new Embajada();
    Banco _banco = new Banco();
    Biblioteca _biblioteca = new Biblioteca();
    Club _club = new Club();
    _lugaresPosibles.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_embajada, _banco, _biblioteca, _club)));
  }
  
  public static Mapamundi getInstance() {
    Mapamundi _xblockexpression = null;
    {
      boolean _equals = Objects.equal(Mapamundi.instance, null);
      if (_equals) {
        Mapamundi _mapamundi = new Mapamundi();
        Mapamundi.instance = _mapamundi;
      }
      _xblockexpression = Mapamundi.instance;
    }
    return _xblockexpression;
  }
  
  public void puedoIniciar() {
    List<Pais> _paises = this.getPaises();
    int _size = _paises.size();
    boolean _greaterEqualsThan = (_size >= 3);
    boolean _not = (!_greaterEqualsThan);
    if (_not) {
      throw new UserException("Faltan crear mas paises");
    }
  }
  
  public Pais primerPais() {
    List<Pais> _paises = this.getPaises();
    List<Pais> _paises_1 = this.getPaises();
    int _size = _paises_1.size();
    int _obtenerRandom = Random.obtenerRandom(0, _size);
    return _paises.get(_obtenerRandom);
  }
  
  public ArrayList<Pais> planDeEscape() {
    ArrayList<Pais> _xblockexpression = null;
    {
      List<Pais> _paises = this.getPaises();
      int _size = _paises.size();
      int _obtenerRandom = Random.obtenerRandom(2, _size);
      int nRandom = (_obtenerRandom - 1);
      ArrayList<Pais> ret = CollectionLiterals.<Pais>newArrayList();
      Pais _primerPais = this.primerPais();
      ret.add(_primerPais);
      IntegerRange _upTo = new IntegerRange(0, nRandom);
      for (final Integer i : _upTo) {
        {
          int _size_1 = ret.size();
          int _minus = (_size_1 - 1);
          Pais p = ret.get(_minus);
          Pais _obtenerSiguientePais = p.obtenerSiguientePais(ret);
          ret.add(_obtenerSiguientePais);
        }
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public void agregarPais() {
    boolean _or = false;
    Pais _nuevoPais = this.getNuevoPais();
    String _nombreDelPais = _nuevoPais.getNombreDelPais();
    boolean _equals = Objects.equal(_nombreDelPais, null);
    if (_equals) {
      _or = true;
    } else {
      Pais _nuevoPais_1 = this.getNuevoPais();
      String _nombreDelPais_1 = _nuevoPais_1.getNombreDelPais();
      int _length = _nombreDelPais_1.length();
      boolean _greaterThan = (_length > 0);
      boolean _not = (!_greaterThan);
      _or = _not;
    }
    if (_or) {
      throw new UserException("Debe ingresar el nombre del Pais");
    }
    List<String> _paisesNombreLowerCase = this.paisesNombreLowerCase();
    Pais _nuevoPais_2 = this.getNuevoPais();
    String _nombreDelPais_2 = _nuevoPais_2.getNombreDelPais();
    String _lowerCase = _nombreDelPais_2.toLowerCase();
    boolean _contains = _paisesNombreLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Pais ya agregado");
    }
    Pais _nuevoPais_3 = this.getNuevoPais();
    List<Lugar> _lugaresDeInteres = _nuevoPais_3.getLugaresDeInteres();
    int _size = _lugaresDeInteres.size();
    boolean _lessThan = (_size < 3);
    if (_lessThan) {
      throw new UserException("Debe seleccionar 3 lugares de Interés");
    }
    List<Pais> _paises = this.getPaises();
    Pais _nuevoPais_4 = this.getNuevoPais();
    _paises.add(_nuevoPais_4);
    this.actualizarPaises();
  }
  
  public void eliminarPais() {
    Pais _paisSeleccionado = this.getPaisSeleccionado();
    List<Pais> _conexionesAereas = _paisSeleccionado.getConexionesAereas();
    final Procedure1<Pais> _function = new Procedure1<Pais>() {
      public void apply(final Pais each) {
        each.eliminarConexion();
      }
    };
    IterableExtensions.<Pais>forEach(_conexionesAereas, _function);
    List<Pais> _paises = this.getPaises();
    Pais _paisSeleccionado_1 = this.getPaisSeleccionado();
    _paises.remove(_paisSeleccionado_1);
    this.actualizarPaises();
  }
  
  public void actualizarPaises() {
    List<Pais> p = this.getPaises();
    this.setPaises(null);
    this.setPaises(p);
    this.setPaisSeleccionado(null);
    this.setNuevoPais(null);
  }
  
  public List<String> paisesNombreLowerCase() {
    List<Pais> _paises = this.getPaises();
    final Function1<Pais, String> _function = new Function1<Pais, String>() {
      public String apply(final Pais it) {
        String _nombreDelPais = it.getNombreDelPais();
        return _nombreDelPais.toLowerCase();
      }
    };
    return ListExtensions.<Pais, String>map(_paises, _function);
  }
  
  public void eliminarCaracteristica() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.eliminarCaracteristica();
  }
  
  public String obtenerInputCaracteristica() {
    return "nuevoPais.nuevaCaracteristica";
  }
  
  public String listaCaracteristicas() {
    return "nuevoPais.caracteristicasDelPais";
  }
  
  public String caracteristicasSeleccionada() {
    return "nuevoPais.caracteristicaSeleccionada";
  }
  
  public void agregarCaracteristica() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.agregarCaracteristica();
  }
  
  public void actualizar() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.actualizar();
  }
  
  public void eliminarConexion() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.eliminarConexion();
  }
  
  public String conexionesSeleccionada() {
    return "nuevoPais.conexionSeleccionada";
  }
  
  public String listaConexiones() {
    return "nuevoPais.conexionesAereas";
  }
  
  public String obtenerInputConexiones() {
    return "nuevoPais.nuevaConexion";
  }
  
  public void agregarConexion() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.agregarConexion();
  }
  
  public String listaLugares() {
    return "nuevoPais.lugaresDeInteres";
  }
  
  public String obtenerInputLugares() {
    return "nuevoPais.nuevoLugar";
  }
  
  public void eliminarLugar() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.eliminarLugar();
  }
  
  public String lugaresSeleccionada() {
    return "nuevoPais.lugarSeleccionado";
  }
  
  public void agregarLugar() {
    Pais _nuevoPais = this.getNuevoPais();
    _nuevoPais.agregarLugar();
  }
  
  public String obtenerTitulo() {
    return "Mapamundi - Nuevo Pais";
  }
  
  public Boolean soyEditar() {
    return Boolean.valueOf(false);
  }
}
