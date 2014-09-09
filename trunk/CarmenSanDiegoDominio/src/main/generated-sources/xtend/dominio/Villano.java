package dominio;

import dominio.InterfazVillanos;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Villano implements InterfazVillanos {
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
  
  private String _sexo;
  
  public String getSexo() {
    return this._sexo;
  }
  
  public void setSexo(final String sexo) {
    this._sexo = sexo;
  }
  
  private String _hobbieSeleccionado;
  
  public String getHobbieSeleccionado() {
    return this._hobbieSeleccionado;
  }
  
  public void setHobbieSeleccionado(final String hobbieSeleccionado) {
    this._hobbieSeleccionado = hobbieSeleccionado;
  }
  
  private String _nuevoHobbie;
  
  public String getNuevoHobbie() {
    return this._nuevoHobbie;
  }
  
  public void setNuevoHobbie(final String nuevoHobbie) {
    this._nuevoHobbie = nuevoHobbie;
  }
  
  private String _nuevaSeniaParticular;
  
  public String getNuevaSeniaParticular() {
    return this._nuevaSeniaParticular;
  }
  
  public void setNuevaSeniaParticular(final String nuevaSeniaParticular) {
    this._nuevaSeniaParticular = nuevaSeniaParticular;
  }
  
  private String _seniaParticularSeleccionada;
  
  public String getSeniaParticularSeleccionada() {
    return this._seniaParticularSeleccionada;
  }
  
  public void setSeniaParticularSeleccionada(final String seniaParticularSeleccionada) {
    this._seniaParticularSeleccionada = seniaParticularSeleccionada;
  }
  
  public Villano() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setSeniasParticulares(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
    this.setHobbies(_newArrayList_1);
  }
  
  public Villano(final String nombre, final List<String> seniasParticulares, final List<String> hobbies, final String sexo) {
    this.setNombre(nombre);
    this.setSeniasParticulares(seniasParticulares);
    this.setHobbies(hobbies);
    this.setSexo(sexo);
  }
  
  public String obtenerInputHobbie() {
    return "nuevoHobbie";
  }
  
  public void eliminarHobieSeleccionado() {
    List<String> _hobbies = this.getHobbies();
    String _hobbieSeleccionado = this.getHobbieSeleccionado();
    _hobbies.remove(_hobbieSeleccionado);
    this.actualizar();
  }
  
  public void agregarHobbie() {
    List<String> _hobbiesLowerCase = this.hobbiesLowerCase();
    String _nuevoHobbie = this.getNuevoHobbie();
    String _lowerCase = _nuevoHobbie.toLowerCase();
    boolean _contains = _hobbiesLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Hobbie ya agregada");
    }
    List<String> _hobbies = this.getHobbies();
    String _nuevoHobbie_1 = this.getNuevoHobbie();
    _hobbies.add(_nuevoHobbie_1);
    this.actualizar();
  }
  
  public String listaHobbies() {
    return "hobbies";
  }
  
  public String hobbiesSeleccionado() {
    return "hobbieSeleccionado";
  }
  
  public void actualizar() {
    List<String> hob = this.getHobbies();
    this.setHobbies(null);
    this.setHobbies(hob);
    this.setHobbieSeleccionado(null);
    this.setNuevoHobbie(null);
    List<String> sp = this.getSeniasParticulares();
    this.setSeniasParticulares(null);
    this.setSeniasParticulares(sp);
    this.setHobbieSeleccionado(null);
    this.setNuevaSeniaParticular(null);
  }
  
  public void agregarSeniasParticulares() {
    List<String> _seniasParticularesLowerCase = this.seniasParticularesLowerCase();
    String _nuevaSeniaParticular = this.getNuevaSeniaParticular();
    String _lowerCase = _nuevaSeniaParticular.toLowerCase();
    boolean _contains = _seniasParticularesLowerCase.contains(_lowerCase);
    if (_contains) {
      throw new UserException("Seña Particular ya agregada");
    }
    List<String> _seniasParticulares = this.getSeniasParticulares();
    String _nuevaSeniaParticular_1 = this.getNuevaSeniaParticular();
    _seniasParticulares.add(_nuevaSeniaParticular_1);
    this.actualizar();
  }
  
  public void eliminarSeniasParticularesSeleccionado() {
    List<String> _seniasParticulares = this.getSeniasParticulares();
    String _seniaParticularSeleccionada = this.getSeniaParticularSeleccionada();
    _seniasParticulares.remove(_seniaParticularSeleccionada);
    this.actualizar();
  }
  
  public String obtenerInputSeniasParticulares() {
    return "nuevaSeniaParticular";
  }
  
  public String listaSeniasParticulares() {
    return "seniasParticulares";
  }
  
  public String seniasParticularesSeleccionada() {
    return "seniaParticularSeleccionada";
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
  
  public List<String> seniasParticularesLowerCase() {
    List<String> _seniasParticulares = this.getSeniasParticulares();
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        return it.toLowerCase();
      }
    };
    return ListExtensions.<String, String>map(_seniasParticulares, _function);
  }
  
  public Boolean soyEditar() {
    return Boolean.valueOf(true);
  }
  
  public void agregarVillano() {
    try {
      throw new Exception("Error!");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
