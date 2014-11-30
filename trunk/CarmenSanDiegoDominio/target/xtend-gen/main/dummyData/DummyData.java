package dummyData;

import appModel.CasoAppModel;
import com.google.common.collect.Lists;
import dominio.Banco;
import dominio.Biblioteca;
import dominio.Caso;
import dominio.Club;
import dominio.Detective;
import dominio.Embajada;
import dominio.Expediente;
import dominio.Lugar;
import dominio.Mapamundi;
import dominio.Ocupante;
import dominio.Pais;
import dominio.Sexo;
import dominio.Villano;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DummyData {
  public Detective crearJuegoDummy() {
    Detective _xblockexpression = null;
    {
      Detective detective = new Detective();
      this.crearVillanos(detective);
      this.crearPaises(detective);
      _xblockexpression = detective;
    }
    return _xblockexpression;
  }
  
  public void crearPaises(final Detective detective) {
    Mapamundi _mapamundi = detective.getMapamundi();
    Pais _pais = new Pais();
    final Procedure1<Pais> _function = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Argentina");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("Se constituye de 24 entidades, 23 provincias y una ciudad autónoma", "La bandera consta de tres franjas dos celestes y una blanca", "Es reconocida por su gran pasión por el fútbol")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow = ObjectExtensions.<Pais>operator_doubleArrow(_pais, _function);
    _mapamundi.agregarPais(_doubleArrow);
    Mapamundi _mapamundi_1 = detective.getMapamundi();
    Pais _pais_1 = new Pais();
    final Procedure1<Pais> _function_1 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("China");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("Estado soberano situado en Asia Oriental", "Es el país más poblado del mundo", "La moneda oficial es el Yuan")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Banco _banco = new Banco();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _banco)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_1 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_1, _function_1);
    _mapamundi_1.agregarPais(_doubleArrow_1);
    Mapamundi _mapamundi_2 = detective.getMapamundi();
    Pais _pais_2 = new Pais();
    final Procedure1<Pais> _function_2 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Nigeria");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("La moneda oficial es Naira", "Es el país más poblado de Africa", "La bandera consta de tres franjas dos verdes y una blanca")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_2 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_2, _function_2);
    _mapamundi_2.agregarPais(_doubleArrow_2);
    Mapamundi _mapamundi_3 = detective.getMapamundi();
    Pais _pais_3 = new Pais();
    final Procedure1<Pais> _function_3 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Brasil");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("El idioma oficial es el portugues", "La moneda oficial es el real", "Al norte del país se encuentra la cuenca amazónica")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_3 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_3, _function_3);
    _mapamundi_3.agregarPais(_doubleArrow_3);
    Mapamundi _mapamundi_4 = detective.getMapamundi();
    Pais _pais_4 = new Pais();
    final Procedure1<Pais> _function_4 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Mexico");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("La bandera tiene 3 colores verde, blanco y rojo", "Introdujo el chocolate, el chile y el maíz al resto del mundo ", "Es el mayor productor de plata en el mundo")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_4 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_4, _function_4);
    _mapamundi_4.agregarPais(_doubleArrow_4);
    Mapamundi _mapamundi_5 = detective.getMapamundi();
    Pais _pais_5 = new Pais();
    final Procedure1<Pais> _function_5 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Estados Unidos");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("Capital Washington D. C.", "Moneda oficial el Dolar", "La bandera tiene 50 estrellas")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_5 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_5, _function_5);
    _mapamundi_5.agregarPais(_doubleArrow_5);
    Mapamundi _mapamundi_6 = detective.getMapamundi();
    Pais _pais_6 = new Pais();
    final Procedure1<Pais> _function_6 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("España");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("La moneda oficial es el Euro", "La bandera tiene 2 franjas rojas, una amarilla y un escudo", "Capital Madrid")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_6 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_6, _function_6);
    _mapamundi_6.agregarPais(_doubleArrow_6);
    Mapamundi _mapamundi_7 = detective.getMapamundi();
    Pais _pais_7 = new Pais();
    final Procedure1<Pais> _function_7 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Italia");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("Capital Roma", "Moneda oficial es el Euro", "La bandera tiene 3 colores verde, blanco y rojo")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_7 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_7, _function_7);
    _mapamundi_7.agregarPais(_doubleArrow_7);
    Mapamundi _mapamundi_8 = detective.getMapamundi();
    Pais _pais_8 = new Pais();
    final Procedure1<Pais> _function_8 = new Procedure1<Pais>() {
      public void apply(final Pais it) {
        it.setNombreDelPais("Alemania");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(
              Collections.<String>unmodifiableList(Lists.<String>newArrayList("La moneda oficial es el Euro", "La bandera tiene 3 colores negro, rojo y amarillo", "Capital Berling")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setCaracteristicasDelPais(_doubleArrow);
        ArrayList<Lugar> _newArrayList_1 = CollectionLiterals.<Lugar>newArrayList();
        final Procedure1<ArrayList<Lugar>> _function_1 = new Procedure1<ArrayList<Lugar>>() {
          public void apply(final ArrayList<Lugar> it) {
            Biblioteca _biblioteca = new Biblioteca();
            Club _club = new Club();
            Embajada _embajada = new Embajada();
            it.addAll(Collections.<Lugar>unmodifiableList(Lists.<Lugar>newArrayList(_biblioteca, _club, _embajada)));
          }
        };
        ArrayList<Lugar> _doubleArrow_1 = ObjectExtensions.<ArrayList<Lugar>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setLugaresDeInteres(_doubleArrow_1);
      }
    };
    Pais _doubleArrow_8 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_8, _function_8);
    _mapamundi_8.agregarPais(_doubleArrow_8);
    Mapamundi _mapamundi_9 = detective.getMapamundi();
    List<Pais> _paises = _mapamundi_9.getPaises();
    Pais _get = _paises.get(0);
    Mapamundi _mapamundi_10 = detective.getMapamundi();
    List<Pais> _paises_1 = _mapamundi_10.getPaises();
    Pais _get_1 = _paises_1.get(1);
    _get.agregarConexion(_get_1);
    Mapamundi _mapamundi_11 = detective.getMapamundi();
    List<Pais> _paises_2 = _mapamundi_11.getPaises();
    Pais _get_2 = _paises_2.get(0);
    Mapamundi _mapamundi_12 = detective.getMapamundi();
    List<Pais> _paises_3 = _mapamundi_12.getPaises();
    Pais _get_3 = _paises_3.get(2);
    _get_2.agregarConexion(_get_3);
    Mapamundi _mapamundi_13 = detective.getMapamundi();
    List<Pais> _paises_4 = _mapamundi_13.getPaises();
    Pais _get_4 = _paises_4.get(0);
    Mapamundi _mapamundi_14 = detective.getMapamundi();
    List<Pais> _paises_5 = _mapamundi_14.getPaises();
    Pais _get_5 = _paises_5.get(3);
    _get_4.agregarConexion(_get_5);
    Mapamundi _mapamundi_15 = detective.getMapamundi();
    List<Pais> _paises_6 = _mapamundi_15.getPaises();
    Pais _get_6 = _paises_6.get(0);
    Mapamundi _mapamundi_16 = detective.getMapamundi();
    List<Pais> _paises_7 = _mapamundi_16.getPaises();
    Pais _get_7 = _paises_7.get(4);
    _get_6.agregarConexion(_get_7);
    Mapamundi _mapamundi_17 = detective.getMapamundi();
    List<Pais> _paises_8 = _mapamundi_17.getPaises();
    Pais _get_8 = _paises_8.get(0);
    Mapamundi _mapamundi_18 = detective.getMapamundi();
    List<Pais> _paises_9 = _mapamundi_18.getPaises();
    Pais _get_9 = _paises_9.get(5);
    _get_8.agregarConexion(_get_9);
    Mapamundi _mapamundi_19 = detective.getMapamundi();
    List<Pais> _paises_10 = _mapamundi_19.getPaises();
    Pais _get_10 = _paises_10.get(0);
    Mapamundi _mapamundi_20 = detective.getMapamundi();
    List<Pais> _paises_11 = _mapamundi_20.getPaises();
    Pais _get_11 = _paises_11.get(6);
    _get_10.agregarConexion(_get_11);
    Mapamundi _mapamundi_21 = detective.getMapamundi();
    List<Pais> _paises_12 = _mapamundi_21.getPaises();
    Pais _get_12 = _paises_12.get(0);
    Mapamundi _mapamundi_22 = detective.getMapamundi();
    List<Pais> _paises_13 = _mapamundi_22.getPaises();
    Pais _get_13 = _paises_13.get(7);
    _get_12.agregarConexion(_get_13);
    Mapamundi _mapamundi_23 = detective.getMapamundi();
    List<Pais> _paises_14 = _mapamundi_23.getPaises();
    Pais _get_14 = _paises_14.get(0);
    Mapamundi _mapamundi_24 = detective.getMapamundi();
    List<Pais> _paises_15 = _mapamundi_24.getPaises();
    Pais _get_15 = _paises_15.get(8);
    _get_14.agregarConexion(_get_15);
    Mapamundi _mapamundi_25 = detective.getMapamundi();
    List<Pais> _paises_16 = _mapamundi_25.getPaises();
    Pais _get_16 = _paises_16.get(1);
    Mapamundi _mapamundi_26 = detective.getMapamundi();
    List<Pais> _paises_17 = _mapamundi_26.getPaises();
    Pais _get_17 = _paises_17.get(2);
    _get_16.agregarConexion(_get_17);
    Mapamundi _mapamundi_27 = detective.getMapamundi();
    List<Pais> _paises_18 = _mapamundi_27.getPaises();
    Pais _get_18 = _paises_18.get(1);
    Mapamundi _mapamundi_28 = detective.getMapamundi();
    List<Pais> _paises_19 = _mapamundi_28.getPaises();
    Pais _get_19 = _paises_19.get(3);
    _get_18.agregarConexion(_get_19);
    Mapamundi _mapamundi_29 = detective.getMapamundi();
    List<Pais> _paises_20 = _mapamundi_29.getPaises();
    Pais _get_20 = _paises_20.get(1);
    Mapamundi _mapamundi_30 = detective.getMapamundi();
    List<Pais> _paises_21 = _mapamundi_30.getPaises();
    Pais _get_21 = _paises_21.get(4);
    _get_20.agregarConexion(_get_21);
    Mapamundi _mapamundi_31 = detective.getMapamundi();
    List<Pais> _paises_22 = _mapamundi_31.getPaises();
    Pais _get_22 = _paises_22.get(1);
    Mapamundi _mapamundi_32 = detective.getMapamundi();
    List<Pais> _paises_23 = _mapamundi_32.getPaises();
    Pais _get_23 = _paises_23.get(5);
    _get_22.agregarConexion(_get_23);
    Mapamundi _mapamundi_33 = detective.getMapamundi();
    List<Pais> _paises_24 = _mapamundi_33.getPaises();
    Pais _get_24 = _paises_24.get(1);
    Mapamundi _mapamundi_34 = detective.getMapamundi();
    List<Pais> _paises_25 = _mapamundi_34.getPaises();
    Pais _get_25 = _paises_25.get(6);
    _get_24.agregarConexion(_get_25);
    Mapamundi _mapamundi_35 = detective.getMapamundi();
    List<Pais> _paises_26 = _mapamundi_35.getPaises();
    Pais _get_26 = _paises_26.get(1);
    Mapamundi _mapamundi_36 = detective.getMapamundi();
    List<Pais> _paises_27 = _mapamundi_36.getPaises();
    Pais _get_27 = _paises_27.get(7);
    _get_26.agregarConexion(_get_27);
    Mapamundi _mapamundi_37 = detective.getMapamundi();
    List<Pais> _paises_28 = _mapamundi_37.getPaises();
    Pais _get_28 = _paises_28.get(1);
    Mapamundi _mapamundi_38 = detective.getMapamundi();
    List<Pais> _paises_29 = _mapamundi_38.getPaises();
    Pais _get_29 = _paises_29.get(8);
    _get_28.agregarConexion(_get_29);
    Mapamundi _mapamundi_39 = detective.getMapamundi();
    List<Pais> _paises_30 = _mapamundi_39.getPaises();
    Pais _get_30 = _paises_30.get(2);
    Mapamundi _mapamundi_40 = detective.getMapamundi();
    List<Pais> _paises_31 = _mapamundi_40.getPaises();
    Pais _get_31 = _paises_31.get(3);
    _get_30.agregarConexion(_get_31);
    Mapamundi _mapamundi_41 = detective.getMapamundi();
    List<Pais> _paises_32 = _mapamundi_41.getPaises();
    Pais _get_32 = _paises_32.get(2);
    Mapamundi _mapamundi_42 = detective.getMapamundi();
    List<Pais> _paises_33 = _mapamundi_42.getPaises();
    Pais _get_33 = _paises_33.get(4);
    _get_32.agregarConexion(_get_33);
    Mapamundi _mapamundi_43 = detective.getMapamundi();
    List<Pais> _paises_34 = _mapamundi_43.getPaises();
    Pais _get_34 = _paises_34.get(2);
    Mapamundi _mapamundi_44 = detective.getMapamundi();
    List<Pais> _paises_35 = _mapamundi_44.getPaises();
    Pais _get_35 = _paises_35.get(5);
    _get_34.agregarConexion(_get_35);
    Mapamundi _mapamundi_45 = detective.getMapamundi();
    List<Pais> _paises_36 = _mapamundi_45.getPaises();
    Pais _get_36 = _paises_36.get(2);
    Mapamundi _mapamundi_46 = detective.getMapamundi();
    List<Pais> _paises_37 = _mapamundi_46.getPaises();
    Pais _get_37 = _paises_37.get(6);
    _get_36.agregarConexion(_get_37);
    Mapamundi _mapamundi_47 = detective.getMapamundi();
    List<Pais> _paises_38 = _mapamundi_47.getPaises();
    Pais _get_38 = _paises_38.get(2);
    Mapamundi _mapamundi_48 = detective.getMapamundi();
    List<Pais> _paises_39 = _mapamundi_48.getPaises();
    Pais _get_39 = _paises_39.get(7);
    _get_38.agregarConexion(_get_39);
    Mapamundi _mapamundi_49 = detective.getMapamundi();
    List<Pais> _paises_40 = _mapamundi_49.getPaises();
    Pais _get_40 = _paises_40.get(2);
    Mapamundi _mapamundi_50 = detective.getMapamundi();
    List<Pais> _paises_41 = _mapamundi_50.getPaises();
    Pais _get_41 = _paises_41.get(8);
    _get_40.agregarConexion(_get_41);
    Mapamundi _mapamundi_51 = detective.getMapamundi();
    List<Pais> _paises_42 = _mapamundi_51.getPaises();
    Pais _get_42 = _paises_42.get(3);
    Mapamundi _mapamundi_52 = detective.getMapamundi();
    List<Pais> _paises_43 = _mapamundi_52.getPaises();
    Pais _get_43 = _paises_43.get(4);
    _get_42.agregarConexion(_get_43);
    Mapamundi _mapamundi_53 = detective.getMapamundi();
    List<Pais> _paises_44 = _mapamundi_53.getPaises();
    Pais _get_44 = _paises_44.get(3);
    Mapamundi _mapamundi_54 = detective.getMapamundi();
    List<Pais> _paises_45 = _mapamundi_54.getPaises();
    Pais _get_45 = _paises_45.get(5);
    _get_44.agregarConexion(_get_45);
    Mapamundi _mapamundi_55 = detective.getMapamundi();
    List<Pais> _paises_46 = _mapamundi_55.getPaises();
    Pais _get_46 = _paises_46.get(3);
    Mapamundi _mapamundi_56 = detective.getMapamundi();
    List<Pais> _paises_47 = _mapamundi_56.getPaises();
    Pais _get_47 = _paises_47.get(6);
    _get_46.agregarConexion(_get_47);
    Mapamundi _mapamundi_57 = detective.getMapamundi();
    List<Pais> _paises_48 = _mapamundi_57.getPaises();
    Pais _get_48 = _paises_48.get(3);
    Mapamundi _mapamundi_58 = detective.getMapamundi();
    List<Pais> _paises_49 = _mapamundi_58.getPaises();
    Pais _get_49 = _paises_49.get(7);
    _get_48.agregarConexion(_get_49);
    Mapamundi _mapamundi_59 = detective.getMapamundi();
    List<Pais> _paises_50 = _mapamundi_59.getPaises();
    Pais _get_50 = _paises_50.get(3);
    Mapamundi _mapamundi_60 = detective.getMapamundi();
    List<Pais> _paises_51 = _mapamundi_60.getPaises();
    Pais _get_51 = _paises_51.get(8);
    _get_50.agregarConexion(_get_51);
    Mapamundi _mapamundi_61 = detective.getMapamundi();
    List<Pais> _paises_52 = _mapamundi_61.getPaises();
    Pais _get_52 = _paises_52.get(4);
    Mapamundi _mapamundi_62 = detective.getMapamundi();
    List<Pais> _paises_53 = _mapamundi_62.getPaises();
    Pais _get_53 = _paises_53.get(5);
    _get_52.agregarConexion(_get_53);
    Mapamundi _mapamundi_63 = detective.getMapamundi();
    List<Pais> _paises_54 = _mapamundi_63.getPaises();
    Pais _get_54 = _paises_54.get(4);
    Mapamundi _mapamundi_64 = detective.getMapamundi();
    List<Pais> _paises_55 = _mapamundi_64.getPaises();
    Pais _get_55 = _paises_55.get(6);
    _get_54.agregarConexion(_get_55);
    Mapamundi _mapamundi_65 = detective.getMapamundi();
    List<Pais> _paises_56 = _mapamundi_65.getPaises();
    Pais _get_56 = _paises_56.get(4);
    Mapamundi _mapamundi_66 = detective.getMapamundi();
    List<Pais> _paises_57 = _mapamundi_66.getPaises();
    Pais _get_57 = _paises_57.get(7);
    _get_56.agregarConexion(_get_57);
    Mapamundi _mapamundi_67 = detective.getMapamundi();
    List<Pais> _paises_58 = _mapamundi_67.getPaises();
    Pais _get_58 = _paises_58.get(4);
    Mapamundi _mapamundi_68 = detective.getMapamundi();
    List<Pais> _paises_59 = _mapamundi_68.getPaises();
    Pais _get_59 = _paises_59.get(8);
    _get_58.agregarConexion(_get_59);
    Mapamundi _mapamundi_69 = detective.getMapamundi();
    List<Pais> _paises_60 = _mapamundi_69.getPaises();
    Pais _get_60 = _paises_60.get(5);
    Mapamundi _mapamundi_70 = detective.getMapamundi();
    List<Pais> _paises_61 = _mapamundi_70.getPaises();
    Pais _get_61 = _paises_61.get(6);
    _get_60.agregarConexion(_get_61);
    Mapamundi _mapamundi_71 = detective.getMapamundi();
    List<Pais> _paises_62 = _mapamundi_71.getPaises();
    Pais _get_62 = _paises_62.get(5);
    Mapamundi _mapamundi_72 = detective.getMapamundi();
    List<Pais> _paises_63 = _mapamundi_72.getPaises();
    Pais _get_63 = _paises_63.get(7);
    _get_62.agregarConexion(_get_63);
    Mapamundi _mapamundi_73 = detective.getMapamundi();
    List<Pais> _paises_64 = _mapamundi_73.getPaises();
    Pais _get_64 = _paises_64.get(5);
    Mapamundi _mapamundi_74 = detective.getMapamundi();
    List<Pais> _paises_65 = _mapamundi_74.getPaises();
    Pais _get_65 = _paises_65.get(8);
    _get_64.agregarConexion(_get_65);
    Mapamundi _mapamundi_75 = detective.getMapamundi();
    List<Pais> _paises_66 = _mapamundi_75.getPaises();
    Pais _get_66 = _paises_66.get(6);
    Mapamundi _mapamundi_76 = detective.getMapamundi();
    List<Pais> _paises_67 = _mapamundi_76.getPaises();
    Pais _get_67 = _paises_67.get(7);
    _get_66.agregarConexion(_get_67);
    Mapamundi _mapamundi_77 = detective.getMapamundi();
    List<Pais> _paises_68 = _mapamundi_77.getPaises();
    Pais _get_68 = _paises_68.get(6);
    Mapamundi _mapamundi_78 = detective.getMapamundi();
    List<Pais> _paises_69 = _mapamundi_78.getPaises();
    Pais _get_69 = _paises_69.get(8);
    _get_68.agregarConexion(_get_69);
    Mapamundi _mapamundi_79 = detective.getMapamundi();
    List<Pais> _paises_70 = _mapamundi_79.getPaises();
    Pais _get_70 = _paises_70.get(7);
    Mapamundi _mapamundi_80 = detective.getMapamundi();
    List<Pais> _paises_71 = _mapamundi_80.getPaises();
    Pais _get_71 = _paises_71.get(8);
    _get_70.agregarConexion(_get_71);
  }
  
  public void crearVillanos(final Detective detective) {
    Expediente _expedientes = detective.getExpedientes();
    Villano _villano = new Villano();
    final Procedure1<Villano> _function = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("El Pinguino");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Alto", "Pelado", "Corpulento")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setSeniasParticulares(_doubleArrow);
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function_1 = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("El futbol", "Pesca", "Autos")));
          }
        };
        ArrayList<String> _doubleArrow_1 = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setHobbies(_doubleArrow_1);
        it.setSexo(Sexo.Masculino);
      }
    };
    Villano _doubleArrow = ObjectExtensions.<Villano>operator_doubleArrow(_villano, _function);
    _expedientes.agregarVillano(_doubleArrow);
    Expediente _expedientes_1 = detective.getExpedientes();
    Villano _villano_1 = new Villano();
    final Procedure1<Villano> _function_1 = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("Loki");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Alto", "Flaco", "Pelo castaño")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setSeniasParticulares(_doubleArrow);
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function_1 = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Surf", "El futbol", "Rafting")));
          }
        };
        ArrayList<String> _doubleArrow_1 = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setHobbies(_doubleArrow_1);
        it.setSexo(Sexo.Masculino);
      }
    };
    Villano _doubleArrow_1 = ObjectExtensions.<Villano>operator_doubleArrow(_villano_1, _function_1);
    _expedientes_1.agregarVillano(_doubleArrow_1);
    Expediente _expedientes_2 = detective.getExpedientes();
    Villano _villano_2 = new Villano();
    final Procedure1<Villano> _function_2 = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("Gatubela");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Usa vestidos", "Es Fumadora", "Usa jayas")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setSeniasParticulares(_doubleArrow);
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function_1 = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Pintura", "La fotografia", "Hockey")));
          }
        };
        ArrayList<String> _doubleArrow_1 = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setHobbies(_doubleArrow_1);
        it.setSexo(Sexo.Femenino);
      }
    };
    Villano _doubleArrow_2 = ObjectExtensions.<Villano>operator_doubleArrow(_villano_2, _function_2);
    _expedientes_2.agregarVillano(_doubleArrow_2);
    Expediente _expedientes_3 = detective.getExpedientes();
    Villano _villano_3 = new Villano();
    final Procedure1<Villano> _function_3 = new Procedure1<Villano>() {
      public void apply(final Villano it) {
        it.setNombre("Madame Hydra");
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Delgada", "Alta", "Pelo largo de color verde oscuro")));
          }
        };
        ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
        it.setSeniasParticulares(_doubleArrow);
        ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList();
        final Procedure1<ArrayList<String>> _function_1 = new Procedure1<ArrayList<String>>() {
          public void apply(final ArrayList<String> it) {
            it.addAll(Collections.<String>unmodifiableList(Lists.<String>newArrayList("Lectura", "Tiro con arco", "Baile")));
          }
        };
        ArrayList<String> _doubleArrow_1 = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList_1, _function_1);
        it.setHobbies(_doubleArrow_1);
        it.setSexo(Sexo.Femenino);
      }
    };
    Villano _doubleArrow_3 = ObjectExtensions.<Villano>operator_doubleArrow(_villano_3, _function_3);
    _expedientes_3.agregarVillano(_doubleArrow_3);
  }
  
  public static void main(final String[] args) {
    DummyData _dummyData = new DummyData();
    Detective dummy = _dummyData.crearJuegoDummy();
    dummy.iniciarJuego();
    Caso _casoActual = dummy.getCasoActual();
    CasoAppModel r = new CasoAppModel(_casoActual);
    Caso _casoActual_1 = r.getCasoActual();
    Pais _ciudadActual = _casoActual_1.getCiudadActual();
    String _nombreDelPais = _ciudadActual.getNombreDelPais();
    System.out.println(_nombreDelPais);
    CasoAppModel _viajar = r.viajar("Argentina");
    r = _viajar;
    Caso _casoActual_2 = r.getCasoActual();
    List<Pais> _planDeEscape = _casoActual_2.getPlanDeEscape();
    for (final Pais p : _planDeEscape) {
      {
        List<Lugar> _lugaresDeInteres = p.getLugaresDeInteres();
        for (final Lugar l : _lugaresDeInteres) {
          Ocupante _ocupante = l.getOcupante();
          Caso _casoActual_3 = r.getCasoActual();
          Villano _villano = _casoActual_3.getVillano();
          List<String> _pista = _ocupante.pista(_villano);
          System.out.println(_pista);
        }
        System.out.println("----");
      }
    }
    List<String> _paisesVisitadosCorrectos = r.getPaisesVisitadosCorrectos();
    System.out.println(_paisesVisitadosCorrectos);
    List<String> _paisesVisitadosIncorrectos = r.getPaisesVisitadosIncorrectos();
    System.out.println(_paisesVisitadosIncorrectos);
    CasoAppModel _viajar_1 = r.viajar("Argentina");
    r = _viajar_1;
    List<String> _paisesVisitadosCorrectos_1 = r.getPaisesVisitadosCorrectos();
    System.out.println(_paisesVisitadosCorrectos_1);
    List<String> _paisesVisitadosIncorrectos_1 = r.getPaisesVisitadosIncorrectos();
    System.out.println(_paisesVisitadosIncorrectos_1);
    CasoAppModel _viajar_2 = r.viajar("Alemania");
    r = _viajar_2;
    List<String> _paisesVisitadosCorrectos_2 = r.getPaisesVisitadosCorrectos();
    System.out.println(_paisesVisitadosCorrectos_2);
    List<String> _paisesVisitadosIncorrectos_2 = r.getPaisesVisitadosIncorrectos();
    System.out.println(_paisesVisitadosIncorrectos_2);
    CasoAppModel _viajar_3 = r.viajar("Argentina");
    r = _viajar_3;
    List<String> _paisesVisitadosCorrectos_3 = r.getPaisesVisitadosCorrectos();
    System.out.println(_paisesVisitadosCorrectos_3);
    List<String> _paisesVisitadosIncorrectos_3 = r.getPaisesVisitadosIncorrectos();
    System.out.println(_paisesVisitadosIncorrectos_3);
  }
}
