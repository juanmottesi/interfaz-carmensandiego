package dominio;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import dominio.Ocupante;
import dominio.Sexo;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Villano implements Ocupante {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<String> _seniasParticulares;
  
  public List<String> getSeniasParticulares() {
    return this._seniasParticulares;
  }
  
  public void setSeniasParticulares(final List<String> seniasParticulares) {
    this._seniasParticulares = seniasParticulares;
  }
  
  private List<String> _hobbies;
  
  public List<String> getHobbies() {
    return this._hobbies;
  }
  
  public void setHobbies(final List<String> hobbies) {
    this._hobbies = hobbies;
  }
  
  private Sexo _sexo;
  
  public Sexo getSexo() {
    return this._sexo;
  }
  
  public void setSexo(final Sexo sexo) {
    this._sexo = sexo;
  }
  
  public Villano() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setSeniasParticulares(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
    this.setHobbies(_newArrayList_1);
  }
  
  public Villano(final String nombre) {
    this.setNombre(nombre);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setSeniasParticulares(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
    this.setHobbies(_newArrayList_1);
    this.setSexo(Sexo.Masculino);
  }
  
  public void agregarSeniaParticular(final String nuevaSeniaParticular) {
    boolean _isBlank = StringUtils.isBlank(nuevaSeniaParticular);
    if (_isBlank) {
      throw new UserException("Senia Particular no valida");
    }
    List<String> _seniasParticularLowerCase = this.seniasParticularLowerCase();
    String _lowerCase = nuevaSeniaParticular.toLowerCase();
    boolean _contains = _seniasParticularLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Senia Particular ya agregada");
    }
    List<String> _seniasParticulares = this.getSeniasParticulares();
    _seniasParticulares.add(nuevaSeniaParticular);
    List<String> _seniasParticulares_1 = this.getSeniasParticulares();
    ObservableUtils.firePropertyChanged(this, "seniasParticulares", _seniasParticulares_1);
  }
  
  public void eliminarSeniaParticular(final String seniaSeleccionada) {
    List<String> _seniasParticulares = this.getSeniasParticulares();
    _seniasParticulares.remove(seniaSeleccionada);
    List<String> _seniasParticulares_1 = this.getSeniasParticulares();
    ObservableUtils.firePropertyChanged(this, "seniasParticulares", _seniasParticulares_1);
  }
  
  public void eliminarHobbie(final String hobbieSeleccionada) {
    List<String> _hobbies = this.getHobbies();
    _hobbies.remove(hobbieSeleccionada);
    List<String> _hobbies_1 = this.getHobbies();
    ObservableUtils.firePropertyChanged(this, "hobbies", _hobbies_1);
  }
  
  public void agregarHobbie(final String nuevoHobbie) {
    boolean _isBlank = StringUtils.isBlank(nuevoHobbie);
    if (_isBlank) {
      throw new UserException("Hobbie no valido");
    }
    List<String> _hobbiesLowerCase = this.hobbiesLowerCase();
    String _lowerCase = nuevoHobbie.toLowerCase();
    boolean _contains = _hobbiesLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Hobbie ya agregada");
    }
    List<String> _hobbies = this.getHobbies();
    _hobbies.add(nuevoHobbie);
    List<String> _hobbies_1 = this.getHobbies();
    ObservableUtils.firePropertyChanged(this, "hobbies", _hobbies_1);
  }
  
  public List<String> seniasParticularLowerCase() {
    List<String> _seniasParticulares = this.getSeniasParticulares();
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        return it.toLowerCase();
      }
    };
    return ListExtensions.<String, String>map(_seniasParticulares, _function);
  }
  
  public List<String> hobbiesLowerCase() {
    List<String> _hobbies = this.getHobbies();
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        return it.toLowerCase();
      }
    };
    return ListExtensions.<String, String>map(_hobbies, _function);
  }
  
  public void esCorrecto(final List<Villano> villanos) {
    String _nombre = this.getNombre();
    boolean _isBlank = StringUtils.isBlank(_nombre);
    if (_isBlank) {
      throw new UserException("Nombre del Villano Incorrecto");
    }
    final Function1<Villano, Boolean> _function = new Function1<Villano, Boolean>() {
      public Boolean apply(final Villano it) {
        String _nombre = it.getNombre();
        String _nombre_1 = Villano.this.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
      }
    };
    Iterable<Villano> _filter = IterableExtensions.<Villano>filter(villanos, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _notEquals = (_size != 1);
    if (_notEquals) {
      throw new UserException("Villano ya agregado");
    }
    List<String> _hobbies = this.getHobbies();
    int _size_1 = _hobbies.size();
    boolean _lessThan = (_size_1 < 3);
    if (_lessThan) {
      throw new UserException("Se necesitan 3 Hobbies");
    }
    List<String> _seniasParticulares = this.getSeniasParticulares();
    int _size_2 = _seniasParticulares.size();
    boolean _lessThan_1 = (_size_2 < 3);
    if (_lessThan_1) {
      throw new UserException("Se necesitan 3 Señas particulares");
    }
  }
  
  public String obtenerSeniaParticular(final ArrayList<String> lista) {
    String _xblockexpression = null;
    {
      List<String> _seniasParticulares = this.getSeniasParticulares();
      List<String> _seniasParticulares_1 = this.getSeniasParticulares();
      int _size = _seniasParticulares_1.size();
      int _obtenerRandom = Random.obtenerRandom(0, _size);
      String aux = _seniasParticulares.get(_obtenerRandom);
      String _xifexpression = null;
      boolean _contains = lista.contains(aux);
      if (_contains) {
        _xifexpression = this.obtenerSeniaParticular(lista);
      } else {
        _xifexpression = aux;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String obtenerHobbie(final ArrayList<String> lista) {
    String _xblockexpression = null;
    {
      List<String> _hobbies = this.getHobbies();
      List<String> _hobbies_1 = this.getHobbies();
      int _size = _hobbies_1.size();
      int _minus = (_size - 1);
      int _obtenerRandom = Random.obtenerRandom(0, _minus);
      String aux = _hobbies.get(_obtenerRandom);
      String _xifexpression = null;
      boolean _contains = lista.contains(aux);
      if (_contains) {
        _xifexpression = this.obtenerHobbie(lista);
      } else {
        _xifexpression = aux;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public List<String> pista(final Villano villano) {
    String _nombre = villano.getNombre();
    String _plus = ("Alto!!! Detengase: " + _nombre);
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList(_plus));
  }
  
  public boolean esVillano() {
    return true;
  }
}
