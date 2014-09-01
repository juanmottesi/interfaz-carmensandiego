package dominio;

import dominio.Lugar;
import dominio.auxiliar.Random;
import exception.ExceptionPaisYaAgregado;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  private List<Pais> _conexionesAereas;
  
  public List<Pais> getConexionesAereas() {
    return this._conexionesAereas;
  }
  
  public void setConexionesAereas(final List<Pais> conexionesAereas) {
    this._conexionesAereas = conexionesAereas;
  }
  
  public Pais(final String nombreDelPais, final List<String> caracteristicasDelPais, final List<Lugar> lugaresDeInteres, final List<Pais> conexionesAereas) {
    this.setNombreDelPais(nombreDelPais);
    this.setCaracteristicasDelPais(caracteristicasDelPais);
    this.setLugaresDeInteres(lugaresDeInteres);
    this.setConexionesAereas(conexionesAereas);
  }
  
  public void agregarConeccionA(final Pais p) {
    try {
      List<Pais> _conexionesAereas = this.getConexionesAereas();
      boolean _contains = _conexionesAereas.contains(p);
      boolean _not = (!_contains);
      if (_not) {
        List<Pais> _conexionesAereas_1 = this.getConexionesAereas();
        _conexionesAereas_1.add(p);
        List<Pais> _conexionesAereas_2 = p.getConexionesAereas();
        _conexionesAereas_2.add(this);
      } else {
        throw new ExceptionPaisYaAgregado();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
}
