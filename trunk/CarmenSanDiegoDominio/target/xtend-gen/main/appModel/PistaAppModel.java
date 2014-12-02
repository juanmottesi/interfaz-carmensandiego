package appModel;

import appModel.Tupla;
import java.io.Serializable;

@SuppressWarnings("all")
public class PistaAppModel implements Serializable {
  private String _nombreDelLugar;
  
  public String getNombreDelLugar() {
    return this._nombreDelLugar;
  }
  
  public void setNombreDelLugar(final String nombreDelLugar) {
    this._nombreDelLugar = nombreDelLugar;
  }
  
  private Tupla _pista;
  
  public Tupla getPista() {
    return this._pista;
  }
  
  public void setPista(final Tupla pista) {
    this._pista = pista;
  }
  
  private Boolean _esVillano;
  
  public Boolean getEsVillano() {
    return this._esVillano;
  }
  
  public void setEsVillano(final Boolean esVillano) {
    this._esVillano = esVillano;
  }
  
  public PistaAppModel(final String nombreDelLugar, final Tupla pista) {
    this.setNombreDelLugar(nombreDelLugar);
    this.setPista(pista);
    Boolean _esVillano = this.getEsVillano();
    this.setEsVillano(_esVillano);
  }
}
