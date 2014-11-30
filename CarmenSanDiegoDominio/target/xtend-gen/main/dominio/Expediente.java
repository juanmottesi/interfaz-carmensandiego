package dominio;

import com.google.common.base.Objects;
import dominio.Villano;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Expediente {
  private static Expediente instance = null;
  
  private List<Villano> _villanos;
  
  public List<Villano> getVillanos() {
    return this._villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this._villanos = villanos;
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
  
  public void agregarVillano(final Villano nuevoVillano) {
    List<Villano> _villanos = this.getVillanos();
    _villanos.add(nuevoVillano);
    List<Villano> _villanos_1 = this.getVillanos();
    ObservableUtils.firePropertyChanged(this, "villanos", _villanos_1);
  }
}
