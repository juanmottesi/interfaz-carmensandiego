package dominio;

import dominio.Expediente;
import dominio.Mapamundi;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Caso {
  private List<Pais> _planDeEscape;
  
  public List<Pais> getPlanDeEscape() {
    return this._planDeEscape;
  }
  
  public void setPlanDeEscape(final List<Pais> planDeEscape) {
    this._planDeEscape = planDeEscape;
  }
  
  private Villano _villano;
  
  public Villano getVillano() {
    return this._villano;
  }
  
  public void setVillano(final Villano villano) {
    this._villano = villano;
  }
  
  private Pais _ciudadActual;
  
  public Pais getCiudadActual() {
    return this._ciudadActual;
  }
  
  public Caso(final Mapamundi mapamundi, final Expediente expediente) {
    Villano _obtenerVillano = expediente.obtenerVillano();
    this.setVillano(_obtenerVillano);
    ArrayList<Pais> _planDeEscape = mapamundi.planDeEscape();
    this.setPlanDeEscape(_planDeEscape);
    this.generarInformantes();
    List<Pais> _planDeEscape_1 = this.getPlanDeEscape();
    Pais _get = _planDeEscape_1.get(0);
    this.setCiudadActual(_get);
  }
  
  public CharSequence getObtenerReporte() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A las 10 de la mañana en la ciudad ");
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    Pais _get = _planDeEscape.get(0);
    String _nombreDelPais = _get.getNombreDelPais();
    _builder.append(_nombreDelPais, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("la comunidad  fue conmovida  al darse cuenta del faltante de gran valor! ");
    return _builder;
  }
  
  public String getObtenerObjetoRobado() {
    return "El Santo Grial";
  }
  
  public void generarInformantes() {
    for (int i = 0; (i < (this.getPlanDeEscape().size() - 1)); i++) {
      List<Pais> _planDeEscape = this.getPlanDeEscape();
      Pais _get = _planDeEscape.get(i);
      List<Pais> _planDeEscape_1 = this.getPlanDeEscape();
      Pais _get_1 = _planDeEscape_1.get((i + 1));
      Villano _villano = this.getVillano();
      _get.generarInformantes(_get_1, _villano);
    }
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    List<Pais> _planDeEscape_1 = this.getPlanDeEscape();
    int _size = _planDeEscape_1.size();
    int _minus = (_size - 1);
    Pais _get = _planDeEscape.get(_minus);
    Villano _villano = this.getVillano();
    _get.colocarVillanoEInformantes(_villano);
  }
  
  public void setCiudadActual(final Pais pais) {
    this._ciudadActual = pais;
    Pais _ciudadActual = this.getCiudadActual();
    ObservableUtils.firePropertyChanged(this, "ciudadActual", _ciudadActual);
  }
  
  public boolean perteneceAlPlanDeEscape(final Pais pais) {
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    return _planDeEscape.contains(pais);
  }
}
