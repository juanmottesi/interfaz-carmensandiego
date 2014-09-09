package ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import ui.TemplateAdministrador;

@SuppressWarnings("all")
public abstract class TemplateNuevoEditar<T extends Object> extends TemplateAdministrador<T> {
  public TemplateNuevoEditar(final WindowOwner owner, final T model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.obtenerTitulo();
    final Panel editorPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    editorPanel.setLayout(_verticalLayout);
    this.agregarCaracteristicas(editorPanel);
    this.agregarBotones(editorPanel);
  }
  
  public void agregarLista(final Panel panel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
