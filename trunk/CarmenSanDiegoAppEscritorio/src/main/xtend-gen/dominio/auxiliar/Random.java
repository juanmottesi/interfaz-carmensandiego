package dominio.auxiliar;

@SuppressWarnings("all")
public class Random {
  public static int obtenerRandom(final int min, final int max) {
    int _xifexpression = (int) 0;
    if ((min < max)) {
      int _xblockexpression = (int) 0;
      {
        double _random = Math.random();
        double _multiply = (_random * max);
        int nRandom = ((int) _multiply);
        int _xifexpression_1 = (int) 0;
        if ((nRandom >= min)) {
          _xifexpression_1 = nRandom;
        } else {
          _xifexpression_1 = Random.obtenerRandom(min, max);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = min;
    }
    return _xifexpression;
  }
}
