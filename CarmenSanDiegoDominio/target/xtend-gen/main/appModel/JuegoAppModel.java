package appModel;

import dominio.Caso;
import dominio.Detective;
import dominio.Expediente;
import dominio.Lugar;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class JuegoAppModel {
  private Detective _detective;
  
  public Detective getDetective() {
    return this._detective;
  }
  
  public void setDetective(final Detective detective) {
    this._detective = detective;
  }
  
  private List<Pais> _destinosFallidos;
  
  public List<Pais> getDestinosFallidos() {
    return this._destinosFallidos;
  }
  
  public void setDestinosFallidos(final List<Pais> destinosFallidos) {
    this._destinosFallidos = destinosFallidos;
  }
  
  private List<Pais> _planDeEscape;
  
  public List<Pais> getPlanDeEscape() {
    return this._planDeEscape;
  }
  
  public void setPlanDeEscape(final List<Pais> planDeEscape) {
    this._planDeEscape = planDeEscape;
  }
  
  private Villano _ordenDeArresto;
  
  public Villano getOrdenDeArresto() {
    return this._ordenDeArresto;
  }
  
  public void setOrdenDeArresto(final Villano ordenDeArresto) {
    this._ordenDeArresto = ordenDeArresto;
  }
  
  private Pais _siguientePais;
  
  public Pais getSiguientePais() {
    return this._siguientePais;
  }
  
  public void setSiguientePais(final Pais siguientePais) {
    this._siguientePais = siguientePais;
  }
  
  public JuegoAppModel(final Detective detective) {
    this._detective = detective;
    ArrayList<Pais> _newArrayList = CollectionLiterals.<Pais>newArrayList();
    this._planDeEscape = _newArrayList;
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    Caso _casoActual = detective.getCasoActual();
    Pais _ciudadActual = _casoActual.getCiudadActual();
    _planDeEscape.add(_ciudadActual);
    ArrayList<Pais> _newArrayList_1 = CollectionLiterals.<Pais>newArrayList();
    this._destinosFallidos = _newArrayList_1;
    this._ordenDeArresto = null;
  }
  
  public List<Villano> getTodosLosVillanos() {
    Expediente _instance = Expediente.getInstance();
    return _instance.getVillanos();
  }
  
  public void viajar() {
    this.agregarALista();
    Detective _detective = this.getDetective();
    Pais _siguientePais = this.getSiguientePais();
    _detective.viajarA(_siguientePais);
    Lugar _primerLugar = this.getPrimerLugar();
    ObservableUtils.firePropertyChanged(this, "primerLugar", _primerLugar);
    Lugar _segundoLugar = this.getSegundoLugar();
    ObservableUtils.firePropertyChanged(this, "segundoLugar", _segundoLugar);
    Lugar _tercerLugar = this.getTercerLugar();
    ObservableUtils.firePropertyChanged(this, "tercerLugar", _tercerLugar);
  }
  
  public void agregarALista() {
    Detective _detective = this.getDetective();
    Pais _siguientePais = this.getSiguientePais();
    boolean _perteneceAlPlanDeEscape = _detective.perteneceAlPlanDeEscape(_siguientePais);
    if (_perteneceAlPlanDeEscape) {
      List<Pais> _planDeEscape = this.getPlanDeEscape();
      Pais _siguientePais_1 = this.getSiguientePais();
      boolean _contains = _planDeEscape.contains(_siguientePais_1);
      boolean _not = (!_contains);
      if (_not) {
        List<Pais> _planDeEscape_1 = this.getPlanDeEscape();
        Pais _siguientePais_2 = this.getSiguientePais();
        _planDeEscape_1.add(_siguientePais_2);
        List<Pais> _planDeEscape_2 = this.getPlanDeEscape();
        ObservableUtils.firePropertyChanged(this, "planDeEscape", _planDeEscape_2);
      }
    } else {
      List<Pais> _destinosFallidos = this.getDestinosFallidos();
      Pais _siguientePais_3 = this.getSiguientePais();
      boolean _contains_1 = _destinosFallidos.contains(_siguientePais_3);
      boolean _not_1 = (!_contains_1);
      if (_not_1) {
        List<Pais> _destinosFallidos_1 = this.getDestinosFallidos();
        Pais _siguientePais_4 = this.getSiguientePais();
        _destinosFallidos_1.add(_siguientePais_4);
        List<Pais> _destinosFallidos_2 = this.getDestinosFallidos();
        ObservableUtils.firePropertyChanged(this, "destinosFallidos", _destinosFallidos_2);
      }
    }
  }
  
  public Lugar getPrimerLugar() {
    Detective _detective = this.getDetective();
    Caso _casoActual = _detective.getCasoActual();
    Pais _ciudadActual = _casoActual.getCiudadActual();
    List<Lugar> _lugaresDeInteres = _ciudadActual.getLugaresDeInteres();
    return _lugaresDeInteres.get(0);
  }
  
  public Lugar getSegundoLugar() {
    Detective _detective = this.getDetective();
    Caso _casoActual = _detective.getCasoActual();
    Pais _ciudadActual = _casoActual.getCiudadActual();
    List<Lugar> _lugaresDeInteres = _ciudadActual.getLugaresDeInteres();
    return _lugaresDeInteres.get(1);
  }
  
  public Lugar getTercerLugar() {
    Detective _detective = this.getDetective();
    Caso _casoActual = _detective.getCasoActual();
    Pais _ciudadActual = _casoActual.getCiudadActual();
    List<Lugar> _lugaresDeInteres = _ciudadActual.getLugaresDeInteres();
    return _lugaresDeInteres.get(2);
  }
}
