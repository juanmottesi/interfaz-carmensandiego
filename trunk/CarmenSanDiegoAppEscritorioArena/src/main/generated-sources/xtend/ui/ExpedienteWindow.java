package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import ui.TemplateAdministrador;

@SuppressWarnings("all")
public class ExpedienteWindow /* extends /* TemplateAdministrador<Expediente> */  */{
  public ExpedienteWindow(final WindowOwner owner, final /* Expediente */Object model) {
    super(owner, model);
  }
  
  public void obtenerTitulo() {
    this.setTitle("Expedientes");
  }
  
  public void agregarLista(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nVillano cannot be resolved to a type."
      + "\nThe method or field Villano is undefined for the type ExpedienteWindow");
  }
  
  public void agregarBotones(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nVillano cannot be resolved."
      + "\nsetNuevoVillano cannot be resolved"
      + "\nvillanoSeleccionado cannot be resolved");
  }
  
  public void agregarCaracteristicas(final Panel panel) {
    this.agregarPanel(panel, "Nombre:", "villanoSeleccionado.nombre");
    this.agregarPanel(panel, "Sexo: ", "villanoSeleccionado.sexo");
    this.agregarPanelConListaConLabel(panel, "Señas Particulares: ", "Seña", "villanoSeleccionado.seniasParticulares");
    this.agregarPanelConListaConLabel(panel, "Hobbies: ", "Hobbie", "villanoSeleccionado.hobbies");
  }
}
