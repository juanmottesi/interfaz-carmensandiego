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
public class Club extends Lugar {
  public Club() {
    super();
    this.setNombreDelLugar("Club");
    this.setImagen("images/club.jpg");
  }
  
  public void generarInformantes(final Pais siguientePais, final Villano villano) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
      public void apply(final ArrayList<String> it) {
        String _obtenerSeniaParticular = villano.obtenerSeniaParticular(it);
        it.add(_obtenerSeniaParticular);
        String _obtenerSeniaParticular_1 = villano.obtenerSeniaParticular(it);
        it.add(_obtenerSeniaParticular_1);
        int _obtenerRandom = Random.obtenerRandom(1, 11);
        boolean _lessEqualsThan = (_obtenerRandom <= 7);
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
