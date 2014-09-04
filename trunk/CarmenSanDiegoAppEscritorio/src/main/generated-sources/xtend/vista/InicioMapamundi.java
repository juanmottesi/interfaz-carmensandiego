package vista;

import dominio.Mapamundi;
import dominio.Pais;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class InicioMapamundi extends Dialog<Mapamundi> {
  public InicioMapamundi(final WindowOwner owner) {
    super(owner, ObjectExtensions.<Mapamundi>operator_doubleArrow(new Mapamundi(), new Procedure1<Mapamundi>() {
      public void apply(final Mapamundi it) {
        List<Pais> _paises = it.getPaises();
        Pais _pais = new Pais();
        final Procedure1<Pais> _function = new Procedure1<Pais>() {
          public void apply(final Pais it) {
            it.setNombreDelPais("Argentina");
            ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
            it.setCaracteristicasDelPais(_newArrayList);
            List<String> _caracteristicasDelPais = it.getCaracteristicasDelPais();
            _caracteristicasDelPais.add("LALALa");
          }
        };
        Pais _doubleArrow = ObjectExtensions.<Pais>operator_doubleArrow(_pais, _function);
        _paises.add(_doubleArrow);
        List<Pais> _paises_1 = it.getPaises();
        Pais _pais_1 = new Pais();
        final Procedure1<Pais> _function_1 = new Procedure1<Pais>() {
          public void apply(final Pais it) {
            it.setNombreDelPais("Brasil");
            ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
            it.setCaracteristicasDelPais(_newArrayList);
            List<String> _caracteristicasDelPais = it.getCaracteristicasDelPais();
            _caracteristicasDelPais.add("lololo");
          }
        };
        Pais _doubleArrow_1 = ObjectExtensions.<Pais>operator_doubleArrow(_pais_1, _function_1);
        _paises_1.add(_doubleArrow_1);
      }
    }));
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Mapamundi");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Panel panel1 = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panel1.setLayout(_columnLayout);
    org.uqbar.arena.widgets.List<Pais> _list = new org.uqbar.arena.widgets.List<Pais>(panel1);
    final Procedure1<org.uqbar.arena.widgets.List<Pais>> _function = new Procedure1<org.uqbar.arena.widgets.List<Pais>>() {
      public void apply(final org.uqbar.arena.widgets.List<Pais> it) {
        Binding<?, Selector<Pais>, ListBuilder<Pais>> _bindItemsToProperty = it.bindItemsToProperty("paises");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Pais.class, "nombreDelPais");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<Object, ControlBuilder>bindValueToProperty("paisSeleccionado");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<org.uqbar.arena.widgets.List<Pais>>operator_doubleArrow(_list, _function);
    Panel panelDerecho = new Panel(panel1);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    panelDerecho.setLayout(_verticalLayout_1);
    Panel panelNombre = new Panel(panelDerecho);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelNombre.setLayout(_horizontalLayout);
    Label _label = new Label(panelNombre);
    _label.setText("Nombre:");
    Label _label_1 = new Label(panelNombre);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.<Object, ControlBuilder>bindValueToProperty("paisSeleccionado.nombreDelPais");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
    Panel panelCaracteristica = new Panel(panelDerecho);
    VerticalLayout _verticalLayout_2 = new VerticalLayout();
    panelCaracteristica.setLayout(_verticalLayout_2);
    Label _label_2 = new Label(panelCaracteristica);
    _label_2.setText("Caracteristicas:");
    org.uqbar.arena.widgets.List<Pais> _list_1 = new org.uqbar.arena.widgets.List<Pais>(panelCaracteristica);
    final Procedure1<org.uqbar.arena.widgets.List<Pais>> _function_2 = new Procedure1<org.uqbar.arena.widgets.List<Pais>>() {
      public void apply(final org.uqbar.arena.widgets.List<Pais> it) {
        it.bindItemsToProperty("paisSeleccionado.caracteristicasDelPais");
        it.setHeight(100);
        it.setWidth(100);
      }
    };
    ObjectExtensions.<org.uqbar.arena.widgets.List<Pais>>operator_doubleArrow(_list_1, _function_2);
    Panel panelConexiones = new Panel(panelDerecho);
    VerticalLayout _verticalLayout_3 = new VerticalLayout();
    panelConexiones.setLayout(_verticalLayout_3);
    Label _label_3 = new Label(panelConexiones);
    _label_3.setText("Conexiones:");
    org.uqbar.arena.widgets.List<Pais> _list_2 = new org.uqbar.arena.widgets.List<Pais>(panelCaracteristica);
    final Procedure1<org.uqbar.arena.widgets.List<Pais>> _function_3 = new Procedure1<org.uqbar.arena.widgets.List<Pais>>() {
      public void apply(final org.uqbar.arena.widgets.List<Pais> it) {
        it.bindItemsToProperty("paisSeleccionado.conexionesAereas");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<org.uqbar.arena.widgets.List<Pais>>operator_doubleArrow(_list_2, _function_3);
  }
}
