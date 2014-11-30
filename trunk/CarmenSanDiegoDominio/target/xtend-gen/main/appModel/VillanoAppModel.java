package appModel;

import dominio.Expediente;
import dominio.Sexo;
import dominio.Villano;
import java.util.Arrays;
import java.util.List;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class VillanoAppModel {
  private Villano _villano;
  
  public Villano getVillano() {
    return this._villano;
  }
  
  public void setVillano(final Villano villano) {
    this._villano = villano;
  }
  
  private String _seniaSeleccionada;
  
  public String getSeniaSeleccionada() {
    return this._seniaSeleccionada;
  }
  
  public void setSeniaSeleccionada(final String seniaSeleccionada) {
    this._seniaSeleccionada = seniaSeleccionada;
  }
  
  private String _nuevaSeniaParticular;
  
  public String getNuevaSeniaParticular() {
    return this._nuevaSeniaParticular;
  }
  
  public void setNuevaSeniaParticular(final String nuevaSeniaParticular) {
    this._nuevaSeniaParticular = nuevaSeniaParticular;
  }
  
  private String _hobbieSeleccionada;
  
  public String getHobbieSeleccionada() {
    return this._hobbieSeleccionada;
  }
  
  public void setHobbieSeleccionada(final String hobbieSeleccionada) {
    this._hobbieSeleccionada = hobbieSeleccionada;
  }
  
  private String _nuevoHobbie;
  
  public String getNuevoHobbie() {
    return this._nuevoHobbie;
  }
  
  public void setNuevoHobbie(final String nuevoHobbie) {
    this._nuevoHobbie = nuevoHobbie;
  }
  
  public VillanoAppModel(final Villano villanoSeleccionado) {
    this.setVillano(villanoSeleccionado);
  }
  
  public List<Sexo> getSexosPosibles() {
    Sexo[] _values = Sexo.values();
    return Arrays.<Sexo>asList(_values);
  }
  
  public void agregarSeniaParticular() {
    Villano _villano = this.getVillano();
    String _nuevaSeniaParticular = this.getNuevaSeniaParticular();
    _villano.agregarSeniaParticular(_nuevaSeniaParticular);
    this.setNuevaSeniaParticular(null);
    String _nuevaSeniaParticular_1 = this.getNuevaSeniaParticular();
    ObservableUtils.firePropertyChanged(this, "nuevaSeniaParticular", _nuevaSeniaParticular_1);
  }
  
  public void eliminarSeniaParticular() {
    Villano _villano = this.getVillano();
    String _seniaSeleccionada = this.getSeniaSeleccionada();
    _villano.eliminarSeniaParticular(_seniaSeleccionada);
  }
  
  public void agregarHobbie() {
    Villano _villano = this.getVillano();
    String _nuevoHobbie = this.getNuevoHobbie();
    _villano.agregarHobbie(_nuevoHobbie);
    this.setNuevoHobbie(null);
    String _nuevoHobbie_1 = this.getNuevoHobbie();
    ObservableUtils.firePropertyChanged(this, "nuevoHobbie", _nuevoHobbie_1);
  }
  
  public void eliminarHobbie() {
    Villano _villano = this.getVillano();
    String _hobbieSeleccionada = this.getHobbieSeleccionada();
    _villano.eliminarHobbie(_hobbieSeleccionada);
  }
  
  public void esCorrecto() {
    Villano _villano = this.getVillano();
    Expediente _instance = Expediente.getInstance();
    List<Villano> _villanos = _instance.getVillanos();
    _villano.esCorrecto(_villanos);
  }
}
