package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import ui.TemplateNuevoEditar;

@SuppressWarnings("all")
public class NuevoVillanoWindow /* extends /* TemplateNuevoEditar<InterfazVillanos> */  */{
  public NuevoVillanoWindow(final WindowOwner owner, final /* InterfazVillanos */Object model) {
    super(owner, model);
  }
  
  public void obtenerTitulo() {
    this.setTitle("Expedientes - Nuevo Villano");
  }
  
  public void agregarBotones(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nsoyEditar cannot be resolved"
      + "\nagregarVillano cannot be resolved");
  }
  
  public void agregarCaracteristicas(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nsoyEditar cannot be resolved"
      + "\nlistaSeniasParticulares cannot be resolved"
      + "\nlistaHobbies cannot be resolved");
  }
}
