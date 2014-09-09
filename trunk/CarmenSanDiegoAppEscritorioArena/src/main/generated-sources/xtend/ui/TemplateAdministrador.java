package ui;

import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.Adapter;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public abstract class TemplateAdministrador<T extends Object> extends Dialog<T> {
  public TemplateAdministrador(final WindowOwner owner, final T model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.obtenerTitulo();
    final Panel editorPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    editorPanel.setLayout(_columnLayout);
    Panel panelIzq = new Panel(editorPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    panelIzq.setLayout(_verticalLayout);
    this.agregarLista(panelIzq);
    this.agregarBotones(panelIzq);
    Panel panelDerecho = new Panel(editorPanel);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    panelDerecho.setLayout(_verticalLayout_1);
    this.agregarCaracteristicas(panelDerecho);
  }
  
  public abstract void obtenerTitulo();
  
  public abstract void agregarLista(final Panel panel);
  
  public abstract void agregarBotones(final Panel panel);
  
  public abstract void agregarCaracteristicas(final Panel panel);
  
  /**
   * agrega un Label con el texto recibido por parametro con ancho recibido por parametro
   * de color gris.
   */
  public Label agregarLabel(final Panel panel, final String texto, final int ancho) {
    Label _label = new Label(panel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText(texto);
        it.setWidth(ancho);
        it.setBackground(Color.lightGray);
      }
    };
    return ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  /**
   * agrega un Label con el texto recibido por parametro
   */
  public Label agregarLabel(final Panel panel, final String texto) {
    Label _label = new Label(panel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText(texto);
      }
    };
    return ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  /**
   * agrega un boton con el nombre recibido por parametro y realiza la accion que esta
   * en el bloque onclick
   */
  public Button agregarBoton(final Panel panel, final String nombre, final Procedure0 onclick) {
    Button _xblockexpression = null;
    {
      Panel panelBotones = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      panelBotones.setLayout(_verticalLayout);
      Button _button = new Button(panelBotones);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption(nombre);
          it.onClick(new Action() {
              public void execute() {
                onclick.apply();
              }
          });
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * agrega un boton con el nombre recibido por parametro, realiza la accion que esta
   * en el bloque onclick y tiene un bindEnabled
   */
  public Button agregarBoton(final Panel panel, final String nombre, final String bindEnabled, final Procedure0 onclick) {
    Button _xblockexpression = null;
    {
      Panel panelBotones = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      panelBotones.setLayout(_verticalLayout);
      Button _button = new Button(panelBotones);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption(nombre);
          it.onClick(new Action() {
              public void execute() {
                onclick.apply();
              }
          });
          NotNullObservable _notNullObservable = new NotNullObservable(bindEnabled);
          it.<Object, ControlBuilder>bindEnabled(_notNullObservable);
          it.disableOnError();
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarPanelConLista(final Panel panel, final String nombreLabel, final String bindItemsToProperty, final PropertyAdapter adapter) {
    List<Object> _xblockexpression = null;
    {
      Panel panelCarac = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(1);
      panelCarac.setLayout(_columnLayout);
      this.agregarLabel(panelCarac, nombreLabel, 153);
      List<Object> _list = new List<Object>(panelCarac);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.setWidth(130);
          it.setHeight(30);
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty(bindItemsToProperty);
          _bindItemsToProperty.setAdapter(adapter);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarPanelConLista(final Panel panel, final String nombreLabel, final String bindItemsToProperty) {
    List<Object> _xblockexpression = null;
    {
      Panel panelCarac = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(1);
      panelCarac.setLayout(_columnLayout);
      this.agregarLabel(panelCarac, nombreLabel, 153);
      List<Object> _list = new List<Object>(panelCarac);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.setWidth(130);
          it.setHeight(30);
          it.bindItemsToProperty(bindItemsToProperty);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarPanelConListaConLabel(final Panel panel, final String text, final String label, final String property) {
    List<Object> _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(1);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      this.agregarLabel(panelAux, label, 153);
      List<Object> _list = new List<Object>(panelAux);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.setWidth(130);
          it.setHeight(30);
          it.bindItemsToProperty(property);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarPanelConListaConLabel(final Panel panel, final String text, final String label, final String property, final Adapter adapter) {
    List<Object> _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(1);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      this.agregarLabel(panelAux, label, 153);
      List<Object> _list = new List<Object>(panelAux);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.setWidth(130);
          it.setHeight(30);
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty(property);
          _bindItemsToProperty.setAdapter(adapter);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
    }
    return _xblockexpression;
  }
  
  public Label agregarPanel(final Panel panel, final String text, final String property) {
    Label _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      HorizontalLayout _horizontalLayout = new HorizontalLayout();
      panelAux.setLayout(_horizontalLayout);
      this.agregarLabel(panelAux, text);
      Label _label = new Label(panelAux);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.<Object, ControlBuilder>bindValueToProperty(property);
          it.setWidth(100);
        }
      };
      _xblockexpression = ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    }
    return _xblockexpression;
  }
  
  public TextBox agregarTexBox(final Panel panel, final String text, final String property) {
    TextBox _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      TextBox _textBox = new TextBox(panelAux);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.setWidth(100);
          it.<Object, ControlBuilder>bindValueToProperty(property);
        }
      };
      _xblockexpression = ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    }
    return _xblockexpression;
  }
  
  public TextBox agregarTexBoxInmodificable(final Panel panel, final String text, final String property) {
    TextBox _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      TextBox _textBox = new TextBox(panelAux);
      final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
        public void apply(final TextBox it) {
          it.setWidth(100);
          it.<Object, ControlBuilder>bindValueToProperty(property);
        }
      };
      _xblockexpression = ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarLabelBotonYList(final Panel panel, final String text, final String nombre, final Procedure0 onclick, final String property, final Adapter adapter) {
    List<Object> _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      Button _button = new Button(panelAux);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption(nombre);
          it.onClick(new Action() {
              public void execute() {
                onclick.apply();
              }
          });
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Panel panelLista = new Panel(panel);
      ColumnLayout _columnLayout_1 = new ColumnLayout(1);
      panelLista.setLayout(_columnLayout_1);
      this.agregarLabel(panelLista, text, 203);
      List<Object> _list = new List<Object>(panelLista);
      final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty(property);
          _bindItemsToProperty.setAdapter(adapter);
          it.setWidth(180);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_1);
    }
    return _xblockexpression;
  }
  
  public List<Object> agregarLabelBotonYList(final Panel panel, final String text, final String nombre, final Procedure0 onclick, final String property) {
    List<Object> _xblockexpression = null;
    {
      Panel panelAux = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      panelAux.setLayout(_columnLayout);
      this.agregarLabel(panelAux, text);
      Button _button = new Button(panelAux);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption(nombre);
          it.onClick(new Action() {
              public void execute() {
                onclick.apply();
              }
          });
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Panel panelLista = new Panel(panel);
      ColumnLayout _columnLayout_1 = new ColumnLayout(1);
      panelLista.setLayout(_columnLayout_1);
      this.agregarLabel(panelLista, text, 203);
      List<Object> _list = new List<Object>(panelLista);
      final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          it.bindItemsToProperty(property);
          it.setWidth(180);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_1);
    }
    return _xblockexpression;
  }
}
