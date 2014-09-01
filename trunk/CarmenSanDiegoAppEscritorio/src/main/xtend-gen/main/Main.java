package main;

import com.google.common.collect.Lists;
import dominio.Biblioteca;
import dominio.Caso;
import dominio.Club;
import dominio.Detective;
import dominio.Embajada;
import dominio.Lugar;
import dominio.Pais;
import dominio.Villano;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    Detective detective = new Detective();
    ArrayList<Lugar> lugares = new ArrayList<Lugar>();
    Biblioteca _biblioteca = new Biblioteca();
    lugares.add(_biblioteca);
    Club _club = new Club();
    lugares.add(_club);
    Embajada _embajada = new Embajada();
    lugares.add(_embajada);
    Pais arg = new Pais("Argentina", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais chl = new Pais("Chile", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais col = new Pais("Colombia", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais esp = new Pais("España", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais itl = new Pais("Italia", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais fr = new Pais("Francia", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    Pais ing = new Pais("Inglaterra", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Celeste y Blanca", "Asado")), lugares, Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList()));
    arg.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(chl, col, esp, itl, fr, ing)));
    chl.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, col, esp, itl, fr, ing)));
    col.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, chl, esp, itl, fr, ing)));
    esp.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, chl, col, itl, fr, ing)));
    itl.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, chl, col, esp, fr, ing)));
    fr.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, chl, col, esp, itl, ing)));
    ing.setConexionesAereas(Collections.<Pais>unmodifiableList(Lists.<Pais>newArrayList(arg, chl, col, esp, itl, fr)));
    detective.agregarPais(arg);
    detective.agregarPais(chl);
    detective.agregarPais(col);
    detective.agregarPais(esp);
    detective.agregarPais(itl);
    detective.agregarPais(fr);
    detective.agregarPais(ing);
    IntegerRange _upTo = new IntegerRange(0, 1000);
    for (final Integer r : _upTo) {
      {
        final Villano v1 = new Villano("Pepe", Collections.<String>unmodifiableList(Lists.<String>newArrayList("Sombrero", "Anillos", "Celular ultimo modelo")), Collections.<String>unmodifiableList(Lists.<String>newArrayList("Tenis", "Autos", "Tejo")), "Masculino");
        detective.agregarVillano(v1);
        detective.iniciarJuego();
        Caso _casoActual = detective.getCasoActual();
        List<Pais> _planDeEscape = _casoActual.getPlanDeEscape();
        System.out.println(_planDeEscape);
        Caso _casoActual_1 = detective.getCasoActual();
        List<Pais> _planDeEscape_1 = _casoActual_1.getPlanDeEscape();
        int _size = _planDeEscape_1.size();
        int _minus = (_size - 1);
        IntegerRange _upTo_1 = new IntegerRange(0, _minus);
        for (final int i : _upTo_1) {
          {
            Caso _casoActual_2 = detective.getCasoActual();
            List<Pais> _planDeEscape_2 = _casoActual_2.getPlanDeEscape();
            Pais e = _planDeEscape_2.get(i);
            String _nombreDelPais = e.getNombreDelPais();
            System.out.print(_nombreDelPais);
            System.out.print(", ");
          }
        }
        System.out.println("");
      }
    }
  }
}
