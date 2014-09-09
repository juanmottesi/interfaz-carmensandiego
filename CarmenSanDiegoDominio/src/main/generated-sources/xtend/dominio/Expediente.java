package dominio;

import com.google.common.base.Objects;
import dominio.InterfazVillanos;
import dominio.Villano;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Expediente implements InterfazVillanos {
  private static Expediente instance = null;
  
  private List<Villano> _villanos;
  
  public List<Villano> getVillanos() {
    return this._villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this._villanos = villanos;
  }
  
  private Villano _villanoSeleccionado;
  
  public Villano getVillanoSeleccionado() {
    return this._villanoSeleccionado;
  }
  
  public void setVillanoSeleccionado(final Villano villanoSeleccionado) {
    this._villanoSeleccionado = villanoSeleccionado;
  }
  
  private Villano _nuevoVillano;
  
  public Villano getNuevoVillano() {
    return this._nuevoVillano;
  }
  
  public void setNuevoVillano(final Villano nuevoVillano) {
    this._nuevoVillano = nuevoVillano;
  }
  
  public Expediente() {
    ArrayList<Villano> _newArrayList = CollectionLiterals.<Villano>newArrayList();
    this.setVillanos(_newArrayList);
  }
  
  public static Expediente getInstance() {
    Expediente _xblockexpression = null;
    {
      boolean _equals = Objects.equal(Expediente.instance, null);
      if (_equals) {
        Expediente _expediente = new Expediente();
        Expediente.instance = _expediente;
      }
      _xblockexpression = Expediente.instance;
    }
    return _xblockexpression;
  }
  
  public void puedoIniciar() {
    List<Villano> _villanos = this.getVillanos();
    int _size = _villanos.size();
    boolean _greaterThan = (_size > 0);
    boolean _not = (!_greaterThan);
    if (_not) {
      throw new UserException("Faltan crear mas villanos");
    }
  }
  
  public Villano obtenerVillano() {
    List<Villano> _villanos = this.getVillanos();
    List<Villano> _villanos_1 = this.getVillanos();
    int _size = _villanos_1.size();
    int _minus = (_size - 1);
    int _obtenerRandom = Random.obtenerRandom(0, _minus);
    return _villanos.get(_obtenerRandom);
  }
  
  public void agregarVillano() {
    boolean _or = false;
    Villano _nuevoVillano = this.getNuevoVillano();
    String _nombre = _nuevoVillano.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      _or = true;
    } else {
      Villano _nuevoVillano_1 = this.getNuevoVillano();
      String _nombre_1 = _nuevoVillano_1.getNombre();
      int _length = _nombre_1.length();
      boolean _greaterThan = (_length > 0);
      boolean _not = (!_greaterThan);
      _or = _not;
    }
    if (_or) {
      throw new UserException("Debe ingresar el nombre del Villano");
    }
    List<String> _villanosNombreLowerCase = this.villanosNombreLowerCase();
    Villano _nuevoVillano_2 = this.getNuevoVillano();
    String _nombre_2 = _nuevoVillano_2.getNombre();
    String _lowerCase = _nombre_2.toLowerCase();
    boolean _contains = _villanosNombreLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Villano ya agregado");
    }
    Villano _nuevoVillano_3 = this.getNuevoVillano();
    String _sexo = _nuevoVillano_3.getSexo();
    boolean _equals_1 = Objects.equal(_sexo, null);
    if (_equals_1) {
      throw new UserException("El sexo del villano tiene que ser femenino o masculino");
    }
    Villano _nuevoVillano_4 = this.getNuevoVillano();
    Villano _nuevoVillano_5 = this.getNuevoVillano();
    String _sexo_1 = _nuevoVillano_5.getSexo();
    String _lowerCase_1 = _sexo_1.toLowerCase();
    _nuevoVillano_4.setSexo(_lowerCase_1);
    Villano _nuevoVillano_6 = this.getNuevoVillano();
    String _sexo_2 = _nuevoVillano_6.getSexo();
    boolean _notEquals = (!Objects.equal(_sexo_2, "masculino"));
    if (_notEquals) {
      Villano _nuevoVillano_7 = this.getNuevoVillano();
      String _sexo_3 = _nuevoVillano_7.getSexo();
      boolean _notEquals_1 = (!Objects.equal(_sexo_3, "femenino"));
      if (_notEquals_1) {
        throw new UserException("El sexo del villano tiene que ser femenino o masculino");
      }
    }
    List<Villano> _villanos = this.getVillanos();
    Villano _nuevoVillano_8 = this.getNuevoVillano();
    _villanos.add(_nuevoVillano_8);
    this.actualizarVillanos();
  }
  
  public List<String> villanosNombreLowerCase() {
    List<Villano> _villanos = this.getVillanos();
    final Function1<Villano, String> _function = new Function1<Villano, String>() {
      public String apply(final Villano it) {
        String _nombre = it.getNombre();
        return _nombre.toLowerCase();
      }
    };
    return ListExtensions.<Villano, String>map(_villanos, _function);
  }
  
  public void actualizarVillanos() {
    List<Villano> p = this.getVillanos();
    this.setVillanos(null);
    this.setVillanos(p);
    this.setVillanoSeleccionado(null);
    this.setNuevoVillano(null);
  }
  
  public String obtenerInputHobbie() {
    return "nuevoVillano.nuevoHobbie";
  }
  
  public void eliminarHobieSeleccionado() {
    Villano _nuevoVillano = this.getNuevoVillano();
    _nuevoVillano.eliminarHobieSeleccionado();
  }
  
  public void agregarHobbie() {
    Villano _nuevoVillano = this.getNuevoVillano();
    _nuevoVillano.agregarHobbie();
  }
  
  public String listaHobbies() {
    return "nuevoVillano.hobbies";
  }
  
  public String hobbiesSeleccionado() {
    return "nuevoVillano.hobbieSeleccionado";
  }
  
  public void actualizar() {
    Villano _nuevoVillano = this.getNuevoVillano();
    _nuevoVillano.actualizar();
  }
  
  public void agregarSeniasParticulares() {
    Villano _nuevoVillano = this.getNuevoVillano();
    _nuevoVillano.agregarSeniasParticulares();
  }
  
  public void eliminarSeniasParticularesSeleccionado() {
    Villano _nuevoVillano = this.getNuevoVillano();
    _nuevoVillano.eliminarSeniasParticularesSeleccionado();
  }
  
  public String obtenerInputSeniasParticulares() {
    return "nuevoVillano.nuevaSeniaParticular";
  }
  
  public String listaSeniasParticulares() {
    return "nuevoVillano.seniasParticulares";
  }
  
  public String seniasParticularesSeleccionada() {
    return "nuevoVillano.seniaParticularSeleccionada";
  }
  
  public Boolean soyEditar() {
    return Boolean.valueOf(false);
  }
}
