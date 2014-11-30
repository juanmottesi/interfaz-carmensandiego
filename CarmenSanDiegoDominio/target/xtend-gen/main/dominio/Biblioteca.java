package dominio;

import dominio.Informante;
import dominio.Lugar;
import dominio.Pais;
import dominio.Villano;
import dominio.auxiliar.Random;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Biblioteca extends Lugar {
  public Biblioteca() {
    super();
    this.setNombreDelLugar("Biblioteca");
    this.setImagen("images/biblioteca.jpg");
  }
  
  public void generarInformantes(final Pais siguientePais, final Villano villano) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
      public void apply(final ArrayList<String> it) {
        String _obtenerCaracteristica = siguientePais.obtenerCaracteristica(it);
        it.add(_obtenerCaracteristica);
        String _obtenerSeniaParticular = villano.obtenerSeniaParticular(it);
        it.add(_obtenerSeniaParticular);
        int _obtenerRandom = Random.obtenerRandom(1, 11);
        boolean _lessEqualsThan = (_obtenerRandom <= 5);
        if (_lessEqualsThan) {
          String _obtenerHobbie = villano.obtenerHobbie(it);
          it.add(_obtenerHobbie);
        }
      }
    };
    ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
    Informante _informante = new Informante(_doubleArrow);
    this.setOcupante(_informante);
  }
}
