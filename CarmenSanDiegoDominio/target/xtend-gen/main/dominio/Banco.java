package dominio;

import dominio.Informante;
import dominio.Lugar;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Banco extends Lugar {
  public Banco() {
    super();
    this.setNombreDelLugar("Banco");
    this.setImagen("images/banco.jpg");
  }
  
  public void generarInformantes(final Pais siguientePais, final Villano villano) {
    ArrayList<String> lista = CollectionLiterals.<String>newArrayList();
    String _obtenerCaracteristica = siguientePais.obtenerCaracteristica(lista);
    lista.add(_obtenerCaracteristica);
    String _obtenerSeniaParticular = villano.obtenerSeniaParticular(lista);
    lista.add(_obtenerSeniaParticular);
    Informante _informante = new Informante(lista);
    this.setOcupante(_informante);
  }
}
