package appModel;

import appModel.PistaAppModel;
import appModel.Tupla;
import com.google.common.base.Objects;
import dominio.Caso;
import dominio.Detective;
import dominio.Expediente;
import dominio.Lugar;
import dominio.Mapamundi;
import dominio.Ocupante;
import dominio.Pais;
import dominio.Villano;
import dummyData.DummyData;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CasoAppModel {
  private static CasoAppModel instance = null;
  
  public static CasoAppModel getInstance() {
    CasoAppModel _xblockexpression = null;
    {
      boolean _equals = Objects.equal(CasoAppModel.instance, null);
      if (_equals) {
        DummyData _dummyData = new DummyData();
        Detective dummyDetective = _dummyData.crearJuegoDummy();
        dummyDetective.iniciarJuego();
        Caso _casoActual = dummyDetective.getCasoActual();
        CasoAppModel _casoAppModel = new CasoAppModel(_casoActual);
        CasoAppModel.instance = _casoAppModel;
      }
      _xblockexpression = CasoAppModel.instance;
    }
    return _xblockexpression;
  }
  
  private Caso _casoActual;
  
  public Caso getCasoActual() {
    return this._casoActual;
  }
  
  public void setCasoActual(final Caso casoActual) {
    this._casoActual = casoActual;
  }
  
  private List<String> _paisesVisitadosCorrectos;
  
  public List<String> getPaisesVisitadosCorrectos() {
    return this._paisesVisitadosCorrectos;
  }
  
  public void setPaisesVisitadosCorrectos(final List<String> paisesVisitadosCorrectos) {
    this._paisesVisitadosCorrectos = paisesVisitadosCorrectos;
  }
  
  private List<String> _paisesVisitadosIncorrectos;
  
  public List<String> getPaisesVisitadosIncorrectos() {
    return this._paisesVisitadosIncorrectos;
  }
  
  public void setPaisesVisitadosIncorrectos(final List<String> paisesVisitadosIncorrectos) {
    this._paisesVisitadosIncorrectos = paisesVisitadosIncorrectos;
  }
  
  private Villano _ordenEmitida;
  
  public Villano getOrdenEmitida() {
    return this._ordenEmitida;
  }
  
  public void setOrdenEmitida(final Villano ordenEmitida) {
    this._ordenEmitida = ordenEmitida;
  }
  
  private List<Villano> _villanos;
  
  public List<Villano> getVillanos() {
    return this._villanos;
  }
  
  public void setVillanos(final List<Villano> villanos) {
    this._villanos = villanos;
  }
  
  public CasoAppModel(final Caso caso) {
    this.setCasoActual(caso);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    this.setPaisesVisitadosCorrectos(_newArrayList);
    List<String> _paisesVisitadosCorrectos = this.getPaisesVisitadosCorrectos();
    Pais _ciudadActual = caso.getCiudadActual();
    String _nombreDelPais = _ciudadActual.getNombreDelPais();
    _paisesVisitadosCorrectos.add(_nombreDelPais);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
    this.setPaisesVisitadosIncorrectos(_newArrayList_1);
    Villano _villano = new Villano("null");
    this.setOrdenEmitida(_villano);
    Expediente _instance = Expediente.getInstance();
    List<Villano> _villanos = _instance.getVillanos();
    this.setVillanos(_villanos);
  }
  
  public CasoAppModel viajar(final String nombrePais) {
    CasoAppModel _xblockexpression = null;
    {
      Mapamundi _instance = Mapamundi.getInstance();
      Pais paisSeleccionado = _instance.getPais(nombrePais);
      Caso _casoActual = this.getCasoActual();
      boolean _perteneceAlPlanDeEscape = _casoActual.perteneceAlPlanDeEscape(paisSeleccionado);
      if (_perteneceAlPlanDeEscape) {
        List<String> _paisesVisitadosCorrectos = this.getPaisesVisitadosCorrectos();
        boolean _contains = _paisesVisitadosCorrectos.contains(nombrePais);
        boolean _not = (!_contains);
        if (_not) {
          List<String> _paisesVisitadosCorrectos_1 = this.getPaisesVisitadosCorrectos();
          _paisesVisitadosCorrectos_1.add(nombrePais);
        }
      } else {
        List<String> _paisesVisitadosIncorrectos = this.getPaisesVisitadosIncorrectos();
        boolean _contains_1 = _paisesVisitadosIncorrectos.contains(nombrePais);
        boolean _not_1 = (!_contains_1);
        if (_not_1) {
          List<String> _paisesVisitadosIncorrectos_1 = this.getPaisesVisitadosIncorrectos();
          _paisesVisitadosIncorrectos_1.add(nombrePais);
        }
      }
      Caso _casoActual_1 = this.getCasoActual();
      _casoActual_1.setCiudadActual(paisSeleccionado);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public List<List<String>> generarPistas() {
    ArrayList<List<String>> _xblockexpression = null;
    {
      final ArrayList<List<String>> pistas = new ArrayList<List<String>>();
      Caso _casoActual = this.getCasoActual();
      Pais _ciudadActual = _casoActual.getCiudadActual();
      List<Lugar> _lugaresDeInteres = _ciudadActual.getLugaresDeInteres();
      final Procedure1<Lugar> _function = new Procedure1<Lugar>() {
        public void apply(final Lugar lugar) {
          Ocupante _ocupante = lugar.getOcupante();
          Caso _casoActual = CasoAppModel.this.getCasoActual();
          Villano _villano = _casoActual.getVillano();
          List<String> _pista = _ocupante.pista(_villano);
          pistas.add(_pista);
        }
      };
      IterableExtensions.<Lugar>forEach(_lugaresDeInteres, _function);
      _xblockexpression = pistas;
    }
    return _xblockexpression;
  }
  
  public void ordenDeArresto(final String villanoNombre) {
    Expediente _instance = Expediente.getInstance();
    List<Villano> _villanos = _instance.getVillanos();
    final Function1<Villano, Boolean> _function = new Function1<Villano, Boolean>() {
      public Boolean apply(final Villano it) {
        String _nombre = it.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, villanoNombre));
      }
    };
    Villano villano = IterableExtensions.<Villano>findFirst(_villanos, _function);
    this.setOrdenEmitida(villano);
  }
  
  public String esFinal() {
    Villano _ordenEmitida = this.getOrdenEmitida();
    Caso _casoActual = this.getCasoActual();
    Villano _villano = _casoActual.getVillano();
    boolean _equals = Objects.equal(_ordenEmitida, _villano);
    if (_equals) {
      return "Ganaste!! =D";
    }
    return "Perdiste T_T";
  }
  
  public String getStringPaisesVisitadosIncorrectos() {
    List<String> _paisesVisitadosIncorrectos = this.getPaisesVisitadosIncorrectos();
    return this.transformListToString(_paisesVisitadosIncorrectos);
  }
  
  public String getStringPaisesVisitadosCorrectos() {
    List<String> _paisesVisitadosCorrectos = this.getPaisesVisitadosCorrectos();
    return this.transformListToString(_paisesVisitadosCorrectos);
  }
  
  public String transformListToString(final List<String> ls) {
    String _xblockexpression = null;
    {
      String ret = ls.toString();
      int _length = ret.length();
      int _minus = (_length - 1);
      String _substring = ret.substring(1, _minus);
      ret = _substring;
      String _replace = ret.replace(", ", " -> ");
      ret = _replace;
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public ArrayList<PistaAppModel> generarPistasAppModel() {
    ArrayList<PistaAppModel> _xblockexpression = null;
    {
      ArrayList<PistaAppModel> ret = CollectionLiterals.<PistaAppModel>newArrayList();
      Caso _casoActual = this.getCasoActual();
      Pais _ciudadActual = _casoActual.getCiudadActual();
      List<Lugar> _lugaresDeInteres = _ciudadActual.getLugaresDeInteres();
      Lugar primero = _lugaresDeInteres.get(0);
      String _nombreDelLugar = primero.getNombreDelLugar();
      Ocupante _ocupante = primero.getOcupante();
      Caso _casoActual_1 = this.getCasoActual();
      Villano _villano = _casoActual_1.getVillano();
      List<String> _pista = _ocupante.pista(_villano);
      Ocupante _ocupante_1 = primero.getOcupante();
      boolean _esVillano = _ocupante_1.esVillano();
      Tupla _tupla = new Tupla(_pista, Boolean.valueOf(_esVillano));
      PistaAppModel _pistaAppModel = new PistaAppModel(_nombreDelLugar, _tupla);
      ret.add(_pistaAppModel);
      Caso _casoActual_2 = this.getCasoActual();
      Pais _ciudadActual_1 = _casoActual_2.getCiudadActual();
      List<Lugar> _lugaresDeInteres_1 = _ciudadActual_1.getLugaresDeInteres();
      Lugar segundo = _lugaresDeInteres_1.get(1);
      String _nombreDelLugar_1 = segundo.getNombreDelLugar();
      Ocupante _ocupante_2 = segundo.getOcupante();
      Caso _casoActual_3 = this.getCasoActual();
      Villano _villano_1 = _casoActual_3.getVillano();
      List<String> _pista_1 = _ocupante_2.pista(_villano_1);
      Ocupante _ocupante_3 = segundo.getOcupante();
      boolean _esVillano_1 = _ocupante_3.esVillano();
      Tupla _tupla_1 = new Tupla(_pista_1, Boolean.valueOf(_esVillano_1));
      PistaAppModel _pistaAppModel_1 = new PistaAppModel(_nombreDelLugar_1, _tupla_1);
      ret.add(_pistaAppModel_1);
      Caso _casoActual_4 = this.getCasoActual();
      Pais _ciudadActual_2 = _casoActual_4.getCiudadActual();
      List<Lugar> _lugaresDeInteres_2 = _ciudadActual_2.getLugaresDeInteres();
      Lugar tercero = _lugaresDeInteres_2.get(2);
      String _nombreDelLugar_2 = tercero.getNombreDelLugar();
      Ocupante _ocupante_4 = tercero.getOcupante();
      Caso _casoActual_5 = this.getCasoActual();
      Villano _villano_2 = _casoActual_5.getVillano();
      List<String> _pista_2 = _ocupante_4.pista(_villano_2);
      Ocupante _ocupante_5 = tercero.getOcupante();
      boolean _esVillano_2 = _ocupante_5.esVillano();
      Tupla _tupla_2 = new Tupla(_pista_2, Boolean.valueOf(_esVillano_2));
      PistaAppModel _pistaAppModel_2 = new PistaAppModel(_nombreDelLugar_2, _tupla_2);
      ret.add(_pistaAppModel_2);
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  public ArrayList<PistaAppModel> generarPistasAppModel(final String pais) {
    ArrayList<PistaAppModel> _xblockexpression = null;
    {
      Mapamundi _instance = Mapamundi.getInstance();
      final Pais pActual = _instance.getPais(pais);
      ArrayList<PistaAppModel> _newArrayList = CollectionLiterals.<PistaAppModel>newArrayList();
      final Procedure1<ArrayList<PistaAppModel>> _function = new Procedure1<ArrayList<PistaAppModel>>() {
        public void apply(final ArrayList<PistaAppModel> it) {
          List<Lugar> _lugaresDeInteres = pActual.getLugaresDeInteres();
          Lugar _get = _lugaresDeInteres.get(0);
          String _nombreDelLugar = _get.getNombreDelLugar();
          List<Lugar> _lugaresDeInteres_1 = pActual.getLugaresDeInteres();
          Lugar _get_1 = _lugaresDeInteres_1.get(0);
          Ocupante _ocupante = _get_1.getOcupante();
          Caso _casoActual = CasoAppModel.this.getCasoActual();
          Villano _villano = _casoActual.getVillano();
          List<String> _pista = _ocupante.pista(_villano);
          List<Lugar> _lugaresDeInteres_2 = pActual.getLugaresDeInteres();
          Lugar _get_2 = _lugaresDeInteres_2.get(0);
          Ocupante _ocupante_1 = _get_2.getOcupante();
          boolean _esVillano = _ocupante_1.esVillano();
          Tupla _tupla = new Tupla(_pista, Boolean.valueOf(_esVillano));
          PistaAppModel _pistaAppModel = new PistaAppModel(_nombreDelLugar, _tupla);
          it.add(_pistaAppModel);
          List<Lugar> _lugaresDeInteres_3 = pActual.getLugaresDeInteres();
          Lugar _get_3 = _lugaresDeInteres_3.get(1);
          String _nombreDelLugar_1 = _get_3.getNombreDelLugar();
          List<Lugar> _lugaresDeInteres_4 = pActual.getLugaresDeInteres();
          Lugar _get_4 = _lugaresDeInteres_4.get(1);
          Ocupante _ocupante_2 = _get_4.getOcupante();
          Caso _casoActual_1 = CasoAppModel.this.getCasoActual();
          Villano _villano_1 = _casoActual_1.getVillano();
          List<String> _pista_1 = _ocupante_2.pista(_villano_1);
          List<Lugar> _lugaresDeInteres_5 = pActual.getLugaresDeInteres();
          Lugar _get_5 = _lugaresDeInteres_5.get(1);
          Ocupante _ocupante_3 = _get_5.getOcupante();
          boolean _esVillano_1 = _ocupante_3.esVillano();
          Tupla _tupla_1 = new Tupla(_pista_1, Boolean.valueOf(_esVillano_1));
          PistaAppModel _pistaAppModel_1 = new PistaAppModel(_nombreDelLugar_1, _tupla_1);
          it.add(_pistaAppModel_1);
          List<Lugar> _lugaresDeInteres_6 = pActual.getLugaresDeInteres();
          Lugar _get_6 = _lugaresDeInteres_6.get(2);
          String _nombreDelLugar_2 = _get_6.getNombreDelLugar();
          List<Lugar> _lugaresDeInteres_7 = pActual.getLugaresDeInteres();
          Lugar _get_7 = _lugaresDeInteres_7.get(2);
          Ocupante _ocupante_4 = _get_7.getOcupante();
          Caso _casoActual_2 = CasoAppModel.this.getCasoActual();
          Villano _villano_2 = _casoActual_2.getVillano();
          List<String> _pista_2 = _ocupante_4.pista(_villano_2);
          List<Lugar> _lugaresDeInteres_8 = pActual.getLugaresDeInteres();
          Lugar _get_8 = _lugaresDeInteres_8.get(2);
          Ocupante _ocupante_5 = _get_8.getOcupante();
          boolean _esVillano_2 = _ocupante_5.esVillano();
          Tupla _tupla_2 = new Tupla(_pista_2, Boolean.valueOf(_esVillano_2));
          PistaAppModel _pistaAppModel_2 = new PistaAppModel(_nombreDelLugar_2, _tupla_2);
          it.add(_pistaAppModel_2);
        }
      };
      _xblockexpression = ObjectExtensions.<ArrayList<PistaAppModel>>operator_doubleArrow(_newArrayList, _function);
    }
    return _xblockexpression;
  }
  
  public CasoAppModel nuevoCaso() {
    CasoAppModel _xblockexpression = null;
    {
      CasoAppModel.instance = null;
      _xblockexpression = CasoAppModel.getInstance();
    }
    return _xblockexpression;
  }
}
