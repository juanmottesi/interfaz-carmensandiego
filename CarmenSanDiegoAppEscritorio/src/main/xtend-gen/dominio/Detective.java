package dominio;

import dominio.Caso;
import dominio.Pais;
import dominio.Villano;
import exception.ExceptionFaltanPaises;
import exception.ExceptionFaltanPaisesOVillanos;
import exception.ExceptionPaisRepetido;
import exception.ExceptionVillanoRepetido;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Detective {
  private List<Villano> _expedientes;
  
  public List<Villano> getExpedientes() {
    return this._expedientes;
  }
  
  public void setExpedientes(final List<Villano> expedientes) {
    this._expedientes = expedientes;
  }
  
  private List<Pais> _mapamundi;
  
  public List<Pais> getMapamundi() {
    return this._mapamundi;
  }
  
  public void setMapamundi(final List<Pais> mapamundi) {
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
    ArrayList<Villano> _newArrayList = CollectionLiterals.<Villano>newArrayList();
    this.setExpedientes(_newArrayList);
    ArrayList<Pais> _newArrayList_1 = CollectionLiterals.<Pais>newArrayList();
    this.setMapamundi(_newArrayList_1);
  }
  
  public void agregarVillano(final Villano villano) {
    try {
      List<Villano> _expedientes = this.getExpedientes();
      boolean _contains = _expedientes.contains(villano);
      if (_contains) {
        throw new ExceptionVillanoRepetido();
      }
      List<Villano> _expedientes_1 = this.getExpedientes();
      _expedientes_1.add(villano);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void agregarPais(final Pais pais) {
    try {
      List<Pais> _mapamundi = this.getMapamundi();
      boolean _contains = _mapamundi.contains(pais);
      if (_contains) {
        throw new ExceptionPaisRepetido();
      }
      List<Pais> _mapamundi_1 = this.getMapamundi();
      _mapamundi_1.add(pais);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void iniciarJuego() {
    try {
      boolean _or = false;
      List<Pais> _mapamundi = this.getMapamundi();
      int _size = _mapamundi.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        _or = true;
      } else {
        List<Villano> _expedientes = this.getExpedientes();
        int _size_1 = _expedientes.size();
        boolean _equals_1 = (_size_1 == 0);
        _or = _equals_1;
      }
      if (_or) {
        throw new ExceptionFaltanPaisesOVillanos();
      }
      List<Pais> _mapamundi_1 = this.getMapamundi();
      int _size_2 = _mapamundi_1.size();
      boolean _lessThan = (_size_2 < 3);
      if (_lessThan) {
        throw new ExceptionFaltanPaises();
      }
      List<Pais> _mapamundi_2 = this.getMapamundi();
      List<Villano> _expedientes_1 = this.getExpedientes();
      Caso _caso = new Caso(_mapamundi_2, _expedientes_1);
      this.setCasoActual(_caso);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
