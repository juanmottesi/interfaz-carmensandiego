package dominio;

@SuppressWarnings("all")
public interface InterfazPaises {
  public abstract String caracteristicasSeleccionada();
  
  public abstract String obtenerInputCaracteristica();
  
  public abstract String listaCaracteristicas();
  
  public abstract void eliminarCaracteristica();
  
  public abstract void agregarCaracteristica();
  
  public abstract void actualizar();
  
  public abstract void eliminarConexion();
  
  public abstract String conexionesSeleccionada();
  
  public abstract String listaConexiones();
  
  public abstract String obtenerInputConexiones();
  
  public abstract void agregarConexion();
  
  public abstract String listaLugares();
  
  public abstract String obtenerInputLugares();
  
  public abstract void eliminarLugar();
  
  public abstract String lugaresSeleccionada();
  
  public abstract void agregarLugar();
  
  public abstract String obtenerTitulo();
  
  public abstract Boolean soyEditar();
  
  public abstract void agregarPais();
}
