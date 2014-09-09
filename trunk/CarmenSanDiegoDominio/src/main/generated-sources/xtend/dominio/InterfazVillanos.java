package dominio;

@SuppressWarnings("all")
public interface InterfazVillanos {
  public abstract String obtenerInputHobbie();
  
  public abstract void eliminarHobieSeleccionado();
  
  public abstract void agregarHobbie();
  
  public abstract String listaHobbies();
  
  public abstract String hobbiesSeleccionado();
  
  public abstract void actualizar();
  
  public abstract void agregarSeniasParticulares();
  
  public abstract void eliminarSeniasParticularesSeleccionado();
  
  public abstract String obtenerInputSeniasParticulares();
  
  public abstract String listaSeniasParticulares();
  
  public abstract String seniasParticularesSeleccionada();
  
  public abstract Boolean soyEditar();
  
  public abstract void agregarVillano();
}
