package dominio;

import dominio.Expediente;
import dominio.Mapamundi;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;

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
  
  private String _reporte;
  
  public String getReporte() {
    return this._reporte;
  }
  
  public void setReporte(final String reporte) {
    this._reporte = reporte;
  }
  
  private String _objetoRobado;
  
  public String getObjetoRobado() {
    return this._objetoRobado;
  }
  
  public void setObjetoRobado(final String objetoRobado) {
    this._objetoRobado = objetoRobado;
  }
  
  public Caso(final Mapamundi mapamundi, final Expediente expediente) {
    Villano _obtenerVillano = expediente.obtenerVillano();
    this.setVillano(_obtenerVillano);
    ArrayList<Pais> _planDeEscape = mapamundi.planDeEscape();
    this.setPlanDeEscape(_planDeEscape);
    String _obtenerObjetoRobado = this.obtenerObjetoRobado();
    this.setObjetoRobado(_obtenerObjetoRobado);
    String _obtenerReporte = this.obtenerReporte();
    this.setReporte(_obtenerReporte);
  }
  
  public String obtenerReporte() {
    List<Pais> _planDeEscape = this.getPlanDeEscape();
    Pais _get = _planDeEscape.get(0);
    String _nombreDelPais = _get.getNombreDelPais();
    String _plus = (("Detective, tenemos un caso para usted!" + 
      "A las 10 de la mañana en la ciudad ") + _nombreDelPais);
    String _plus_1 = (_plus + 
      "la comunidad  fue conmovida  al darse cuenta del faltante de gran valor!");
    String _objetoRobado = this.getObjetoRobado();
    return (_plus_1 + _objetoRobado);
  }
  
  public String obtenerObjetoRobado() {
    return "La Cuchara real";
  }
}
