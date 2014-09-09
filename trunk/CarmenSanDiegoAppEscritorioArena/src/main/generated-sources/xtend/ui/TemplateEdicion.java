package ui;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import ui.TemplateAdministrador;

@SuppressWarnings("all")
public abstract class TemplateEdicion<T extends Object> extends TemplateAdministrador<T> {
  public TemplateEdicion(final WindowOwner owner, final T model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.obtenerTitulo();
    final Panel editorPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    editorPanel.setLayout(_verticalLayout);
    this.agregarLista(editorPanel);
    this.agregarEliminar(editorPanel);
    Panel panel1 = new Panel(editorPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel1.setLayout(_horizontalLayout);
    this.agregarInput(panel1);
    this.agregarAgregar(panel1);
    this.agregarBotones(editorPanel);
  }
  
  public abstract void agregarAgregar(final Panel panel);
  
  public abstract void agregarEliminar(final Panel mainPanel);
  
  public abstract void agregarInput(final Panel mainPanel);
}
