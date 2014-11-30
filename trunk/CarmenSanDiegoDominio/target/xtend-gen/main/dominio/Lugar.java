package dominio;

import dominio.Cuidador;
import dominio.Informante;
import dominio.Ocupante;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class Lugar {
  private String _nombreDelLugar;
  
  public String getNombreDelLugar() {
    return this._nombreDelLugar;
  }
  
  public void setNombreDelLugar(final String nombreDelLugar) {
    this._nombreDelLugar = nombreDelLugar;
  }
  
  private Ocupante _ocupante;
  
  public Ocupante getOcupante() {
    return this._ocupante;
  }
  
  public void setOcupante(final Ocupante ocupante) {
    this._ocupante = ocupante;
  }
  
  private String _imagen;
  
  public String getImagen() {
    return this._imagen;
  }
  
  public void setImagen(final String imagen) {
    this._imagen = imagen;
  }
  
  public Lugar() {
    Cuidador _cuidador = new Cuidador();
    this.setOcupante(_cuidador);
  }
  
  public abstract void generarInformantes(final Pais siguientePais, final Villano villano);
  
  public void generarInformantes() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
      public void apply(final ArrayList<String> it) {
        it.add("CUIDADO DETECTIVE!!");
      }
    };
    ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
    Informante _informante = new Informante(_doubleArrow);
    this.setOcupante(_informante);
  }
  
  public void ubicarVillano(final Villano villano) {
    this.setOcupante(villano);
  }
  
  public List<String> pista(final Villano villano) {
    Ocupante _ocupante = this.getOcupante();
    return _ocupante.pista(villano);
  }
}
