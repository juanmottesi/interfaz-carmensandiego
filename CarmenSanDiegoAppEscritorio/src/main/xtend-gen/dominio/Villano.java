package dominio;

import java.util.List;

@SuppressWarnings("all")
public class Villano {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<String> _seniasParticulares;
  
  public List<String> getSeniasParticulares() {
    return this._seniasParticulares;
  }
  
  public void setSeniasParticulares(final List<String> seniasParticulares) {
    this._seniasParticulares = seniasParticulares;
  }
  
  private List<String> _hobbies;
  
  public List<String> getHobbies() {
    return this._hobbies;
  }
  
  public void setHobbies(final List<String> hobbies) {
    this._hobbies = hobbies;
  }
  
  private String _sexo;
  
  public String getSexo() {
    return this._sexo;
  }
  
  public void setSexo(final String sexo) {
    this._sexo = sexo;
  }
  
  public Villano(final String nombre, final List<String> seniasParticulares, final List<String> hobbies, final String sexo) {
    this.setNombre(nombre);
    this.setSeniasParticulares(seniasParticulares);
    this.setHobbies(hobbies);
    this.setSexo(sexo);
  }
}
