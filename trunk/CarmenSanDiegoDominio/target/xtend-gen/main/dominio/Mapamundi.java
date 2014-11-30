package dominio;

import com.google.common.base.Objects;
import dominio.Pais;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Mapamundi {
  private static Mapamundi instance = null;
  
  private List<Pais> _paises;
  
  public List<Pais> getPaises() {
    return this._paises;
  }
  
  public void setPaises(final List<Pais> paises) {
    this._paises = paises;
  }
  
  public Mapamundi() {
    ArrayList<Pais> _newArrayList = CollectionLiterals.<Pais>newArrayList();
    this.setPaises(_newArrayList);
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
    boolean _lessThan = (_size < 3);
    if (_lessThan) {
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
  
  public void agregarPais(final Pais nuevoPais) {
    List<Pais> _paises = this.getPaises();
    _paises.add(nuevoPais);
    List<Pais> _paises_1 = this.getPaises();
    ObservableUtils.firePropertyChanged(this, "paises", _paises_1);
  }
  
  public void eliminarPais(final Pais paisSeleccionado) {
    List<String> _conexionesAereas = paisSeleccionado.getConexionesAereas();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String each) {
        Mapamundi _instance = Mapamundi.getInstance();
        Pais _pais = _instance.getPais(each);
        List<String> _conexionesAereas = _pais.getConexionesAereas();
        String _nombreDelPais = paisSeleccionado.getNombreDelPais();
        _conexionesAereas.remove(_nombreDelPais);
      }
    };
    IterableExtensions.<String>forEach(_conexionesAereas, _function);
    List<Pais> _paises = this.getPaises();
    _paises.remove(paisSeleccionado);
    List<Pais> _paises_1 = this.getPaises();
    ObservableUtils.firePropertyChanged(this, "paises", _paises_1);
  }
  
  public Pais getPais(final String nombrePais) {
    List<Pais> _paises = this.getPaises();
    final Function1<Pais, Boolean> _function = new Function1<Pais, Boolean>() {
      public Boolean apply(final Pais it) {
        String _nombreDelPais = it.getNombreDelPais();
        return Boolean.valueOf(Objects.equal(_nombreDelPais, nombrePais));
      }
    };
    return IterableExtensions.<Pais>findFirst(_paises, _function);
  }
}
