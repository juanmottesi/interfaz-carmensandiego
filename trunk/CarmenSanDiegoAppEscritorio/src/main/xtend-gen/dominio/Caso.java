package dominio;

import dominio.Pais;
import dominio.Villano;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IntegerRange;

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
  
  public Caso(final List<Pais> paises, final List<Villano> villanos) {
    Villano _obtenerVillano = this.obtenerVillano(villanos);
    this.setVillano(_obtenerVillano);
    ArrayList<Pais> _obtenerPlanDeEscape = this.obtenerPlanDeEscape(paises);
    this.setPlanDeEscape(_obtenerPlanDeEscape);
    String _obtenerObjetoRobado = this.obtenerObjetoRobado();
    this.setObjetoRobado(_obtenerObjetoRobado);
    String _obtenerReporte = this.obtenerReporte();
    this.setReporte(_obtenerReporte);
  }
  
  public Villano obtenerVillano(final List<Villano> villanos) {
    int _size = villanos.size();
    int _obtenerRandom = Random.obtenerRandom(0, _size);
    return villanos.get(_obtenerRandom);
  }
  
  public ArrayList<Pais> obtenerPlanDeEscape(final List<Pais> paises) {
    ArrayList<Pais> _xblockexpression = null;
    {
      int _size = paises.size();
      int _obtenerRandom = Random.obtenerRandom(2, _size);
      int nRandom = (_obtenerRandom - 1);
      ArrayList<Pais> ret = CollectionLiterals.<Pais>newArrayList();
      Pais _primerPais = this.primerPais(paises);
      ret.add(_primerPais);
      IntegerRange _upTo = new IntegerRange(0, nRandom);
      for (final Integer i : _upTo) {
        {
          int _size_1 = ret.size();
          int _minus = (_size_1 - 1);
          Pais p = ret.get(_minus);
          Pais _obtenerSiguientePais = p.obtenerSiguientePais(ret);
          ret.add(_obtenerSiguientePais);
        }
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public Pais primerPais(final List<Pais> paises) {
    int _size = paises.size();
    int _obtenerRandom = Random.obtenerRandom(0, _size);
    return paises.get(_obtenerRandom);
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
