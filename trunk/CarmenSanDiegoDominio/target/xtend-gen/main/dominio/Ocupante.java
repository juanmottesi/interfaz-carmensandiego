package dominio;

import dominio.Villano;
import java.util.List;

@SuppressWarnings("all")
public interface Ocupante {
  public abstract List<String> pista(final Villano villano);
  
  public abstract boolean esVillano();
}
