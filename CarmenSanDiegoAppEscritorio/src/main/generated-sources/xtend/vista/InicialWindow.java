package vista;

import dominio.Detective;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.lacar.ui.model.Action;
import vista.InicioMapamundi;

@SuppressWarnings("all")
public class InicialWindow extends MainWindow<Detective> {
  public InicialWindow() {
    super(new Detective());
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("¿Donde esta Carmen San Diego?");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("¿Que haremos ahora detective?");
    Panel panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel.setLayout(_horizontalLayout);
    Button _button = new Button(panel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Resolver Misterio");
        final Action _function = new Action() {
          public void execute() {
            Detective _modelObject = InicialWindow.this.getModelObject();
            _modelObject.getCasoActual();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(panel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Mapamundi");
        final Action _function = new Action() {
          public void execute() {
            InicioMapamundi _inicioMapamundi = new InicioMapamundi(InicialWindow.this);
            _inicioMapamundi.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(panel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Expedientes");
        final Action _function = new Action() {
          public void execute() {
            Detective _modelObject = InicialWindow.this.getModelObject();
            _modelObject.getExpedientes();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
  }
  
  public static void main(final String[] args) {
    InicialWindow _inicialWindow = new InicialWindow();
    _inicialWindow.startApplication();
  }
}
