package appModel;

import java.util.List;

@SuppressWarnings("all")
public class Tupla {
  private List<String> _info;
  
  public List<String> getInfo() {
    return this._info;
  }
  
  public void setInfo(final List<String> info) {
    this._info = info;
  }
  
  private Boolean _estaElVillano;
  
  public Boolean getEstaElVillano() {
    return this._estaElVillano;
  }
  
  public void setEstaElVillano(final Boolean estaElVillano) {
    this._estaElVillano = estaElVillano;
  }
  
  public Tupla(final List<String> inf, final Boolean estaV) {
    this.setInfo(inf);
    this.setEstaElVillano(estaV);
  }
}
