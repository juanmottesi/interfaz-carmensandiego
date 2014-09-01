package dominio;

import dominio.Villano;

@SuppressWarnings("all")
public abstract class Lugar {
  public abstract String obtenerPista(final Villano villano);
}
